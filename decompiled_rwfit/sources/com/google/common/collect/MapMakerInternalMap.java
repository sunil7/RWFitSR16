package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.df;
import com.google.android.gms.internal.mlkit_vision_barcode.lb;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.v0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
class MapMakerInternalMap<K, V, E extends v0, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final l1 UNSET_WEAK_VALUE_REFERENCE = new p0();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient w0 entryHelper;

    @MonotonicNonNullDecl
    transient Set<Map.Entry<K, V>> entrySet;
    final com.google.common.base.c keyEquivalence;

    @MonotonicNonNullDecl
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;

    @MonotonicNonNullDecl
    transient Collection<V> values;

    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, com.google.common.base.c cVar, com.google.common.base.c cVar2, int i3, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, cVar, cVar2, i3, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            ConcurrentMap<K, V> create;
            objectInputStream.defaultReadObject();
            o0 readMapMaker = readMapMaker(objectInputStream);
            if (readMapMaker.f11104a) {
                create = MapMakerInternalMap.create(readMapMaker);
            } else {
                int i3 = readMapMaker.f11105b;
                if (i3 == -1) {
                    i3 = 16;
                }
                int i10 = readMapMaker.f11106c;
                if (i10 == -1) {
                    i10 = 4;
                }
                create = new ConcurrentHashMap<>(i3, 0.75f, i10);
            }
            this.delegate = create;
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public com.google.common.base.c defaultEquivalence() {
                return com.google.common.base.c.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public com.google.common.base.c defaultEquivalence() {
                return com.google.common.base.c.identity();
            }
        };

        Strength(p0 p0Var) {
        }

        public abstract com.google.common.base.c defaultEquivalence();
    }

    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker$Dummy, z0, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker$Dummy, z0, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i3, int i10) {
            super(mapMakerInternalMap, i3, i10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public z0 castForTesting(v0 v0Var) {
            return (z0) v0Var;
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, b1, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, b1, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i3, int i10) {
            super(mapMakerInternalMap, i3, i10);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public b1 castForTesting(v0 v0Var) {
            return (b1) v0Var;
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, d1, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, d1, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i3, int i10) {
            super(mapMakerInternalMap, i3, i10);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l1 getWeakValueReferenceForTesting(v0 v0Var) {
            return castForTesting(v0Var).f11058d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l1 newWeakValueReferenceForTesting(v0 v0Var, V v6) {
            return new m1(this.queueForValues, v6, castForTesting(v0Var));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(v0 v0Var, l1 l1Var) {
            d1 castForTesting = castForTesting(v0Var);
            l1 l1Var2 = castForTesting.f11058d;
            castForTesting.f11058d = l1Var;
            l1Var2.clear();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public d1 castForTesting(v0 v0Var) {
            return (d1) v0Var;
        }
    }

    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker$Dummy, f1, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker$Dummy, f1, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i3, int i10) {
            super(mapMakerInternalMap, i3, i10);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public f1 castForTesting(v0 v0Var) {
            return (f1) v0Var;
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, h1, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, h1, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i3, int i10) {
            super(mapMakerInternalMap, i3, i10);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public h1 castForTesting(v0 v0Var) {
            return (h1) v0Var;
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, j1, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, j1, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i3, int i10) {
            super(mapMakerInternalMap, i3, i10);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l1 getWeakValueReferenceForTesting(v0 v0Var) {
            return castForTesting(v0Var).f11083c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l1 newWeakValueReferenceForTesting(v0 v0Var, V v6) {
            return new m1(this.queueForValues, v6, castForTesting(v0Var));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(v0 v0Var, l1 l1Var) {
            j1 castForTesting = castForTesting(v0Var);
            l1 l1Var2 = castForTesting.f11083c;
            castForTesting.f11083c = l1Var;
            l1Var2.clear();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public j1 castForTesting(v0 v0Var) {
            return (j1) v0Var;
        }
    }

    public MapMakerInternalMap(o0 o0Var, w0 w0Var) {
        int i3 = o0Var.f11106c;
        this.concurrencyLevel = Math.min(i3 == -1 ? 4 : i3, 65536);
        com.google.common.base.c cVar = o0Var.f11108f;
        com.google.common.base.c defaultEquivalence = o0Var.a().defaultEquivalence();
        if (cVar == null) {
            if (defaultEquivalence == null) {
                throw new NullPointerException("Both parameters are null");
            }
            cVar = defaultEquivalence;
        }
        this.keyEquivalence = cVar;
        this.entryHelper = w0Var;
        int i10 = o0Var.f11105b;
        int min = Math.min(i10 == -1 ? 16 : i10, MAXIMUM_CAPACITY);
        int i11 = 1;
        int i12 = 0;
        int i13 = 1;
        int i14 = 0;
        while (i13 < this.concurrencyLevel) {
            i14++;
            i13 <<= 1;
        }
        this.segmentShift = 32 - i14;
        this.segmentMask = i13 - 1;
        this.segments = newSegmentArray(i13);
        int i15 = min / i13;
        while (i11 < (i13 * i15 < min ? i15 + 1 : i15)) {
            i11 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i12 >= segmentArr.length) {
                return;
            }
            segmentArr[i12] = createSegment(i11, -1);
            i12++;
        }
    }

    public static ArrayList access$900(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        h.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends v0, ?> create(o0 o0Var) {
        Strength a3 = o0Var.a();
        Strength strength = Strength.STRONG;
        if (a3 == strength && o0Var.b() == strength) {
            return new MapMakerInternalMap<>(o0Var, a1.f11042a);
        }
        if (o0Var.a() == strength && o0Var.b() == Strength.WEAK) {
            return new MapMakerInternalMap<>(o0Var, c1.f11054a);
        }
        Strength a10 = o0Var.a();
        Strength strength2 = Strength.WEAK;
        if (a10 == strength2 && o0Var.b() == strength) {
            return new MapMakerInternalMap<>(o0Var, g1.f11073a);
        }
        if (o0Var.a() == strength2 && o0Var.b() == strength2) {
            return new MapMakerInternalMap<>(o0Var, i1.f11080a);
        }
        throw new AssertionError();
    }

    public static <K> MapMakerInternalMap<K, MapMaker$Dummy, ? extends v0, ?> createWithDummyValues(o0 o0Var) {
        Strength a3 = o0Var.a();
        Strength strength = Strength.STRONG;
        if (a3 == strength && o0Var.b() == strength) {
            return new MapMakerInternalMap<>(o0Var, y0.f11152a);
        }
        Strength a10 = o0Var.a();
        Strength strength2 = Strength.WEAK;
        if (a10 == strength2 && o0Var.b() == strength) {
            return new MapMakerInternalMap<>(o0Var, e1.f11062a);
        }
        if (o0Var.b() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    public static int rehash(int i3) {
        int i10 = i3 + ((i3 << 15) ^ (-12931));
        int i11 = i10 ^ (i10 >>> 10);
        int i12 = i11 + (i11 << 3);
        int i13 = i12 ^ (i12 >>> 6);
        int i14 = (i13 << 2) + (i13 << 14) + i13;
        return (i14 >>> 16) ^ i14;
    }

    public static <K, V, E extends v0> l1 unsetWeakValueReference() {
        return UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj != null) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            long j4 = -1;
            int i3 = 0;
            while (i3 < 3) {
                long j10 = 0;
                for (WeakKeyWeakValueSegment weakKeyWeakValueSegment : segmentArr) {
                    int i10 = weakKeyWeakValueSegment.count;
                    AtomicReferenceArray<E> atomicReferenceArray = weakKeyWeakValueSegment.table;
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        for (E e = atomicReferenceArray.get(i11); e != null; e = e.b()) {
                            Object liveValue = weakKeyWeakValueSegment.getLiveValue(e);
                            if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                                return true;
                            }
                        }
                    }
                    j10 += weakKeyWeakValueSegment.modCount;
                }
                if (j10 == j4) {
                    return false;
                }
                i3++;
                j4 = j10;
            }
        }
        return false;
    }

    public E copyEntry(E e, E e10) {
        return segmentFor(e.c()).copyEntry(e, e10);
    }

    public Segment<K, V, E, S> createSegment(int i3, int i10) {
        return this.entryHelper.a(this, i3, i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        t0 t0Var = new t0(this, 0);
        this.entrySet = t0Var;
        return t0Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    public E getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public V getLiveValue(E e) {
        V v6;
        if (e.getKey() == null || (v6 = (V) e.getValue()) == null) {
            return null;
        }
        return v6;
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j4 = 0;
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].count != 0) {
                return false;
            }
            j4 += segmentArr[i3].modCount;
        }
        if (j4 == 0) {
            return true;
        }
        for (int i10 = 0; i10 < segmentArr.length; i10++) {
            if (segmentArr[i10].count != 0) {
                return false;
            }
            j4 -= segmentArr[i10].modCount;
        }
        return j4 == 0;
    }

    public boolean isLiveForTesting(v0 v0Var) {
        return segmentFor(v0Var.c()).getLiveValueForTesting(v0Var) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        t0 t0Var = new t0(this, 1);
        this.keySet = t0Var;
        return t0Var;
    }

    public Strength keyStrength() {
        return this.entryHelper.c();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i3) {
        return new Segment[i3];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k10, V v6) {
        k10.getClass();
        v6.getClass();
        int hash = hash(k10);
        return segmentFor(hash).put(k10, hash, v6, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k10, V v6) {
        k10.getClass();
        v6.getClass();
        int hash = hash(k10);
        return segmentFor(hash).put(k10, hash, v6, true);
    }

    public void reclaimKey(E e) {
        int c9 = e.c();
        segmentFor(c9).reclaimKey(e, c9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(l1 l1Var) {
        v0 a3 = l1Var.a();
        int c9 = a3.c();
        segmentFor(c9).reclaimValue(a3.getKey(), c9, l1Var);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k10, V v6) {
        k10.getClass();
        v6.getClass();
        int hash = hash(k10);
        return segmentFor(hash).replace(k10, hash, v6);
    }

    public Segment<K, V, E, S> segmentFor(int i3) {
        return this.segments[(i3 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j4 = 0;
        for (int i3 = 0; i3 < this.segments.length; i3++) {
            j4 += r0[i3].count;
        }
        return df.a(j4);
    }

    public com.google.common.base.c valueEquivalence() {
        return this.entryHelper.d().defaultEquivalence();
    }

    public Strength valueStrength() {
        return this.entryHelper.d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        l lVar = new l(this, 1);
        this.values = lVar;
        return lVar;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.c(), this.entryHelper.d(), this.keyEquivalence, this.entryHelper.d().defaultEquivalence(), this.concurrencyLevel, this);
    }

    public static abstract class AbstractSerializationProxy<K, V> extends q implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final com.google.common.base.c keyEquivalence;
        final Strength keyStrength;
        final com.google.common.base.c valueEquivalence;
        final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, com.google.common.base.c cVar, com.google.common.base.c cVar2, int i3, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = cVar;
            this.valueEquivalence = cVar2;
            this.concurrencyLevel = i3;
            this.delegate = concurrentMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        public o0 readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            int readInt = objectInputStream.readInt();
            o0 o0Var = new o0();
            if (readInt < 0) {
                throw new IllegalArgumentException();
            }
            o0Var.f11105b = readInt;
            Strength strength = this.keyStrength;
            Strength strength2 = o0Var.f11107d;
            if (strength2 != null) {
                throw new IllegalStateException(lb.a("Key strength was already set to %s", strength2));
            }
            strength.getClass();
            o0Var.f11107d = strength;
            Strength strength3 = Strength.STRONG;
            if (strength != strength3) {
                o0Var.f11104a = true;
            }
            Strength strength4 = this.valueStrength;
            Strength strength5 = o0Var.e;
            if (!(strength5 == null)) {
                throw new IllegalStateException(lb.a("Value strength was already set to %s", strength5));
            }
            strength4.getClass();
            o0Var.e = strength4;
            if (strength4 != strength3) {
                o0Var.f11104a = true;
            }
            com.google.common.base.c cVar = this.keyEquivalence;
            com.google.common.base.c cVar2 = o0Var.f11108f;
            if (!(cVar2 == null)) {
                throw new IllegalStateException(lb.a("key equivalence was already set to %s", cVar2));
            }
            cVar.getClass();
            o0Var.f11108f = cVar;
            o0Var.f11104a = true;
            int i3 = this.concurrencyLevel;
            int i10 = o0Var.f11106c;
            if (!(i10 == -1)) {
                throw new IllegalStateException(lb.a("concurrency level was already set to %s", Integer.valueOf(i10)));
            }
            if (i3 <= 0) {
                throw new IllegalArgumentException();
            }
            o0Var.f11106c = i3;
            return o0Var;
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        @Override // com.google.common.collect.r, com.google.common.collect.s
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k10, @NullableDecl V v6, V v9) {
        k10.getClass();
        v9.getClass();
        if (v6 == null) {
            return false;
        }
        int hash = hash(k10);
        return segmentFor(hash).replace(k10, hash, v6, v9);
    }

    public static abstract class Segment<K, V, E extends v0, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i3, int i10) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i10;
            initTable(newEntryArray(i3));
        }

        public static <K, V, E extends v0> boolean isCollected(E e) {
            return e.getValue() == null;
        }

        public abstract E castForTesting(v0 v0Var);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        atomicReferenceArray.set(i3, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                    unlock();
                } catch (Throwable th2) {
                    unlock();
                    throw th2;
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public boolean clearValueForTesting(K k10, int i3, l1 l1Var) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                v0 v0Var = (v0) atomicReferenceArray.get(length);
                for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                    Object key = v0Var2.getKey();
                    if (v0Var2.c() == i3 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((k1) v0Var2).a() != l1Var) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(v0Var, v0Var2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object obj, int i3) {
            try {
                boolean z5 = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i3);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z5 = true;
                    }
                }
                return z5;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        for (E e = atomicReferenceArray.get(i3); e != null; e = e.b()) {
                            Object liveValue = getLiveValue(e);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public E copyEntry(E e, E e10) {
            return (E) this.map.entryHelper.b(self(), e, e10);
        }

        public E copyForTesting(v0 v0Var, @NullableDecl v0 v0Var2) {
            return (E) this.map.entryHelper.b(self(), castForTesting(v0Var), castForTesting(v0Var2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i3 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((v0) poll);
                i3++;
            } while (i3 != 16);
        }

        @GuardedBy("this")
        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i3 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((l1) poll);
                i3++;
            } while (i3 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= MapMakerInternalMap.MAXIMUM_CAPACITY) {
                return;
            }
            int i3 = this.count;
            ScheduledRunnable scheduledRunnable = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (scheduledRunnable.length() * 3) / 4;
            int length2 = scheduledRunnable.length() - 1;
            for (int i10 = 0; i10 < length; i10++) {
                E e = atomicReferenceArray.get(i10);
                if (e != null) {
                    v0 b3 = e.b();
                    int c9 = e.c() & length2;
                    if (b3 == null) {
                        scheduledRunnable.set(c9, e);
                    } else {
                        v0 v0Var = e;
                        while (b3 != null) {
                            int c10 = b3.c() & length2;
                            if (c10 != c9) {
                                v0Var = b3;
                                c9 = c10;
                            }
                            b3 = b3.b();
                        }
                        scheduledRunnable.set(c9, v0Var);
                        while (e != v0Var) {
                            int c11 = e.c() & length2;
                            v0 copyEntry = copyEntry(e, (v0) scheduledRunnable.get(c11));
                            if (copyEntry != null) {
                                scheduledRunnable.set(c11, copyEntry);
                            } else {
                                i3--;
                            }
                            e = e.b();
                        }
                    }
                }
            }
            this.table = scheduledRunnable;
            this.count = i3;
        }

        public V get(Object obj, int i3) {
            try {
                E liveEntry = getLiveEntry(obj, i3);
                if (liveEntry == null) {
                    postReadCleanup();
                    return null;
                }
                V v6 = (V) liveEntry.getValue();
                if (v6 == null) {
                    tryDrainReferenceQueues();
                }
                return v6;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(Object obj, int i3) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i3); first != null; first = (E) first.b()) {
                if (first.c() == i3) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public E getFirst(int i3) {
            return this.table.get(i3 & (r0.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object obj, int i3) {
            return getEntry(obj, i3);
        }

        @NullableDecl
        public V getLiveValue(E e) {
            if (e.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v6 = (V) e.getValue();
            if (v6 != null) {
                return v6;
            }
            tryDrainReferenceQueues();
            return null;
        }

        @NullableDecl
        public V getLiveValueForTesting(v0 v0Var) {
            return getLiveValue(castForTesting(v0Var));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public l1 getWeakValueReferenceForTesting(v0 v0Var) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int i3) {
            return new AtomicReferenceArray<>(i3);
        }

        public E newEntryForTesting(K k10, int i3, @NullableDecl v0 v0Var) {
            return (E) this.map.entryHelper.e(self(), k10, i3, castForTesting(v0Var));
        }

        public l1 newWeakValueReferenceForTesting(v0 v0Var, V v6) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @GuardedBy("this")
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V put(K k10, int i3, V v6, boolean z5) {
            lock();
            try {
                preWriteCleanup();
                int i10 = this.count + 1;
                if (i10 > this.threshold) {
                    expand();
                    i10 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                v0 v0Var = (v0) atomicReferenceArray.get(length);
                for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                    Object key = v0Var2.getKey();
                    if (v0Var2.c() == i3 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v9 = (V) v0Var2.getValue();
                        if (v9 == null) {
                            this.modCount++;
                            setValue(v0Var2, v6);
                            this.count = this.count;
                            unlock();
                            return null;
                        }
                        if (z5) {
                            unlock();
                            return v9;
                        }
                        this.modCount++;
                        setValue(v0Var2, v6);
                        unlock();
                        return v9;
                    }
                }
                this.modCount++;
                v0 e = this.map.entryHelper.e(self(), k10, i3, v0Var);
                setValue(e, v6);
                atomicReferenceArray.set(length, e);
                this.count = i10;
                unlock();
                return null;
            } catch (Throwable th2) {
                unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public boolean reclaimKey(E e, int i3) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i3 & (atomicReferenceArray.length() - 1);
                v0 v0Var = (v0) atomicReferenceArray.get(length);
                for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                    if (v0Var2 == e) {
                        this.modCount++;
                        v0 removeFromChain = removeFromChain(v0Var, v0Var2);
                        int i10 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i10;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public boolean reclaimValue(K k10, int i3, l1 l1Var) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                v0 v0Var = (v0) atomicReferenceArray.get(length);
                for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                    Object key = v0Var2.getKey();
                    if (v0Var2.c() == i3 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((k1) v0Var2).a() != l1Var) {
                            return false;
                        }
                        this.modCount++;
                        v0 removeFromChain = removeFromChain(v0Var, v0Var2);
                        int i10 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i10;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public V remove(Object obj, int i3) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                v0 v0Var = (v0) atomicReferenceArray.get(length);
                for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                    Object key = v0Var2.getKey();
                    if (v0Var2.c() == i3 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v6 = (V) v0Var2.getValue();
                        if (v6 == null && !isCollected(v0Var2)) {
                            return null;
                        }
                        this.modCount++;
                        v0 removeFromChain = removeFromChain(v0Var, v0Var2);
                        int i10 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i10;
                        return v6;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public boolean removeEntryForTesting(E e) {
            int c9 = e.c();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = c9 & (atomicReferenceArray.length() - 1);
            v0 v0Var = (v0) atomicReferenceArray.get(length);
            for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                if (v0Var2 == e) {
                    this.modCount++;
                    v0 removeFromChain = removeFromChain(v0Var, v0Var2);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        @GuardedBy("this")
        public E removeFromChain(E e, E e10) {
            int i3 = this.count;
            E e11 = (E) e10.b();
            while (e != e10) {
                E copyEntry = copyEntry(e, e11);
                if (copyEntry != null) {
                    e11 = copyEntry;
                } else {
                    i3--;
                }
                e = (E) e.b();
            }
            this.count = i3;
            return e11;
        }

        public E removeFromChainForTesting(v0 v0Var, v0 v0Var2) {
            return removeFromChain(castForTesting(v0Var), castForTesting(v0Var2));
        }

        @CanIgnoreReturnValue
        public boolean removeTableEntryForTesting(v0 v0Var) {
            return removeEntryForTesting(castForTesting(v0Var));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean replace(K k10, int i3, V v6, V v9) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                v0 v0Var = (v0) atomicReferenceArray.get(length);
                for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                    Object key = v0Var2.getKey();
                    if (v0Var2.c() == i3 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        Object value = v0Var2.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v6, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(v0Var2, v9);
                            return true;
                        }
                        if (isCollected(v0Var2)) {
                            this.modCount++;
                            v0 removeFromChain = removeFromChain(v0Var, v0Var2);
                            int i10 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i10;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i3, v0 v0Var) {
            this.table.set(i3, castForTesting(v0Var));
        }

        public void setValue(E e, V v6) {
            this.map.entryHelper.f(self(), e, v6);
        }

        public void setValueForTesting(v0 v0Var, V v6) {
            this.map.entryHelper.f(self(), castForTesting(v0Var), v6);
        }

        public void setWeakValueReferenceForTesting(v0 v0Var, l1 l1Var) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = removeFromChain(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (isCollected(r4) == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean remove(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L5c
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.v0> r0 = r8.table     // Catch: java.lang.Throwable -> L5c
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L5c
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.v0 r3 = (com.google.common.collect.v0) r3     // Catch: java.lang.Throwable -> L5c
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L67
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L5c
                int r7 = r4.c()     // Catch: java.lang.Throwable -> L5c
                if (r7 != r10) goto L62
                if (r6 == 0) goto L62
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.v0, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.c r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L5c
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L5c
                if (r6 == 0) goto L62
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.v0, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.c r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L5c
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L41
                r5 = r2
                goto L47
            L41:
                boolean r9 = isCollected(r4)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L5e
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L5c
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.v0 r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L5c
                int r10 = r8.count     // Catch: java.lang.Throwable -> L5c
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L5c
                r8.count = r10     // Catch: java.lang.Throwable -> L5c
                r8.unlock()
                return r5
            L5c:
                r9 = move-exception
                goto L6b
            L5e:
                r8.unlock()
                return r5
            L62:
                com.google.common.collect.v0 r4 = r4.b()     // Catch: java.lang.Throwable -> L5c
                goto L16
            L67:
                r8.unlock()
                return r5
            L6b:
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V replace(K k10, int i3, V v6) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i3;
                v0 v0Var = (v0) atomicReferenceArray.get(length);
                for (v0 v0Var2 = v0Var; v0Var2 != null; v0Var2 = v0Var2.b()) {
                    Object key = v0Var2.getKey();
                    if (v0Var2.c() == i3 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v9 = (V) v0Var2.getValue();
                        if (v9 == null) {
                            if (isCollected(v0Var2)) {
                                this.modCount++;
                                v0 removeFromChain = removeFromChain(v0Var, v0Var2);
                                int i10 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i10;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(v0Var2, v6);
                        return v9;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
