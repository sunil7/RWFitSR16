package com.google.common.collect;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    static final int UNSET = -1;

    /* renamed from: a, reason: collision with root package name */
    public transient int[] f10997a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f10998b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f10999c;

    /* renamed from: d, reason: collision with root package name */
    public transient Set f11000d;
    public transient Set e;

    @MonotonicNonNullDecl
    transient long[] entries;

    /* renamed from: f, reason: collision with root package name */
    public transient Collection f11001f;

    @MonotonicNonNullDecl
    transient Object[] keys;
    transient float loadFactor;
    transient int modCount;

    @MonotonicNonNullDecl
    transient Object[] values;

    public CompactHashMap() {
        init(3, 1.0f);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i3) {
        return new CompactHashMap<>(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt < 0) {
                return;
            } else {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f10999c);
        for (int i3 = 0; i3 < this.f10999c; i3++) {
            objectOutputStream.writeObject(this.keys[i3]);
            objectOutputStream.writeObject(this.values[i3]);
        }
    }

    public final int a(Object obj) {
        int o3 = h.o(obj);
        int i3 = this.f10997a[(r1.length - 1) & o3];
        while (i3 != -1) {
            long j4 = this.entries[i3];
            if (((int) (j4 >>> 32)) == o3 && jb.a(obj, this.keys[i3])) {
                return i3;
            }
            i3 = (int) j4;
        }
        return -1;
    }

    public void accessEntry(int i3) {
    }

    public int adjustAfterRemove(int i3, int i10) {
        return i3 - 1;
    }

    public final Object b(Object obj, int i3) {
        int length = (r0.length - 1) & i3;
        int i10 = this.f10997a[length];
        if (i10 == -1) {
            return null;
        }
        int i11 = -1;
        while (true) {
            if (((int) (this.entries[i10] >>> 32)) == i3 && jb.a(obj, this.keys[i10])) {
                Object obj2 = this.values[i10];
                if (i11 == -1) {
                    this.f10997a[length] = (int) this.entries[i10];
                } else {
                    long[] jArr = this.entries;
                    jArr[i11] = (jArr[i11] & (-4294967296L)) | (((int) jArr[i10]) & 4294967295L);
                }
                moveLastEntry(i10);
                this.f10999c--;
                this.modCount++;
                return obj2;
            }
            int i12 = (int) this.entries[i10];
            if (i12 == -1) {
                return null;
            }
            i11 = i10;
            i10 = i12;
        }
    }

    public final void c(int i3) {
        if (this.f10997a.length >= 1073741824) {
            this.f10998b = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            return;
        }
        int i10 = ((int) (i3 * this.loadFactor)) + 1;
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        long[] jArr = this.entries;
        int i11 = i3 - 1;
        for (int i12 = 0; i12 < this.f10999c; i12++) {
            int i13 = (int) (jArr[i12] >>> 32);
            int i14 = i13 & i11;
            int i15 = iArr[i14];
            iArr[i14] = i12;
            jArr[i12] = (i13 << 32) | (i15 & 4294967295L);
        }
        this.f10998b = i10;
        this.f10997a = iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.f10999c, (Object) null);
        Arrays.fill(this.values, 0, this.f10999c, (Object) null);
        Arrays.fill(this.f10997a, -1);
        Arrays.fill(this.entries, -1L);
        this.f10999c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return a(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i3 = 0; i3 < this.f10999c; i3++) {
            if (jb.a(obj, this.values[i3])) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new j(this, 0);
    }

    public Set<K> createKeySet() {
        return new j(this, 1);
    }

    public Collection<V> createValues() {
        return new l(this, 0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.e;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.e = createEntrySet;
        return createEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new i(this, 1);
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int a3 = a(obj);
        accessEntry(a3);
        if (a3 == -1) {
            return null;
        }
        return (V) this.values[a3];
    }

    public int getSuccessor(int i3) {
        int i10 = i3 + 1;
        if (i10 < this.f10999c) {
            return i10;
        }
        return -1;
    }

    public void init(int i3, float f2) {
        kb.c("Initial capacity must be non-negative", i3 >= 0);
        kb.c("Illegal load factor", f2 > 0.0f);
        int f10 = h.f(i3, f2);
        int[] iArr = new int[f10];
        Arrays.fill(iArr, -1);
        this.f10997a = iArr;
        this.loadFactor = f2;
        this.keys = new Object[i3];
        this.values = new Object[i3];
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        this.entries = jArr;
        this.f10998b = Math.max(1, (int) (f10 * f2));
    }

    public void insertEntry(int i3, @NullableDecl K k10, @NullableDecl V v6, int i10) {
        this.entries[i3] = (i10 << 32) | 4294967295L;
        this.keys[i3] = k10;
        this.values[i3] = v6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f10999c == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f11000d;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.f11000d = createKeySet;
        return createKeySet;
    }

    public Iterator<K> keySetIterator() {
        return new i(this, 0);
    }

    public void moveLastEntry(int i3) {
        int size = size() - 1;
        if (i3 >= size) {
            this.keys[i3] = null;
            this.values[i3] = null;
            this.entries[i3] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i3] = objArr[size];
        Object[] objArr2 = this.values;
        objArr2[i3] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        long[] jArr = this.entries;
        long j4 = jArr[size];
        jArr[i3] = j4;
        jArr[size] = -1;
        int[] iArr = this.f10997a;
        int length = ((int) (j4 >>> 32)) & (iArr.length - 1);
        int i10 = iArr[length];
        if (i10 == size) {
            iArr[length] = i3;
            return;
        }
        while (true) {
            long[] jArr2 = this.entries;
            long j10 = jArr2[i10];
            int i11 = (int) j10;
            if (i11 == size) {
                jArr2[i10] = (j10 & (-4294967296L)) | (4294967295L & i3);
                return;
            }
            i10 = i11;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k10, @NullableDecl V v6) {
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int o3 = h.o(k10);
        int[] iArr = this.f10997a;
        int length = (iArr.length - 1) & o3;
        int i3 = this.f10999c;
        int i10 = iArr[length];
        if (i10 == -1) {
            iArr[length] = i3;
        } else {
            while (true) {
                long j4 = jArr[i10];
                if (((int) (j4 >>> 32)) == o3 && jb.a(k10, objArr[i10])) {
                    V v9 = (V) objArr2[i10];
                    objArr2[i10] = v6;
                    accessEntry(i10);
                    return v9;
                }
                int i11 = (int) j4;
                if (i11 == -1) {
                    jArr[i10] = ((-4294967296L) & j4) | (4294967295L & i3);
                    break;
                }
                i10 = i11;
            }
        }
        int i12 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        if (i3 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i13 = i3 + 1;
        int length2 = this.entries.length;
        if (i13 > length2) {
            int max = Math.max(1, length2 >>> 1) + length2;
            if (max >= 0) {
                i12 = max;
            }
            if (i12 != length2) {
                resizeEntries(i12);
            }
        }
        insertEntry(i3, k10, v6, o3);
        this.f10999c = i13;
        if (i3 >= this.f10998b) {
            c(this.f10997a.length * 2);
        }
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return (V) b(obj, h.o(obj));
    }

    public void resizeEntries(int i3) {
        this.keys = Arrays.copyOf(this.keys, i3);
        this.values = Arrays.copyOf(this.values, i3);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(copyOf, length, i3, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f10999c;
    }

    public void trimToSize() {
        int i3 = this.f10999c;
        if (i3 < this.entries.length) {
            resizeEntries(i3);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i3 / this.loadFactor)));
        if (max < 1073741824 && i3 / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.f10997a.length) {
            c(max);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f11001f;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.f11001f = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        return new i(this, 2);
    }

    public CompactHashMap(int i3) {
        this(i3, 1.0f);
    }

    public CompactHashMap(int i3, float f2) {
        init(i3, f2);
    }
}
