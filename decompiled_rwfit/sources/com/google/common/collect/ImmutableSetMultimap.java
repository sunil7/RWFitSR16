package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: d, reason: collision with root package name */
    public final transient ImmutableSet f11018d;
    public transient ImmutableSetMultimap e;

    /* renamed from: f, reason: collision with root package name */
    public transient ImmutableSet f11019f;

    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableSetMultimap f11020c;

        public EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.f11020c = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f11020c.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f11020c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public d2 iterator() {
            return this.f11020c.m65entryIterator();
        }
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i3, @NullableDecl Comparator<? super V> comparator) {
        super(immutableMap, i3);
        this.f11018d = comparator == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet(comparator);
    }

    public static <K, V> j0 builder() {
        return new j0();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        j0 j0Var = new j0();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            j0Var.c(it.next());
        }
        return j0Var.d();
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        Object[] objArr = new Object[collection.size() * 2];
        int i3 = 0;
        int i10 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            AbstractCollection copyOf = comparator == null ? ImmutableSet.copyOf((Collection) value) : ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) value);
            if (!copyOf.isEmpty()) {
                int i11 = (i10 + 1) * 2;
                if (i11 > objArr.length) {
                    objArr = Arrays.copyOf(objArr, h.i(objArr.length, i11));
                }
                h.c(key, copyOf);
                objArr[i10 * 2] = key;
                objArr[(i10 * 2) + 1] = copyOf;
                i10++;
                i3 = copyOf.size() + i3;
            }
        }
        return new ImmutableSetMultimap<>(RegularImmutableMap.create(i10, objArr), i3, comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(readInt, "Invalid key count "));
        }
        y builder = ImmutableMap.builder();
        int i3 = 0;
        for (int i10 = 0; i10 < readInt; i10++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(readInt2, "Invalid value count "));
            }
            i0 i0Var = comparator == null ? new i0(4) : new l0(comparator);
            for (int i11 = 0; i11 < readInt2; i11++) {
                i0Var.t(objectInputStream.readObject());
            }
            ImmutableSet u10 = i0Var.u();
            if (u10.size() != readInt2) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            builder.b(readObject, u10);
            i3 += readInt2;
        }
        try {
            ImmutableMap a3 = builder.a();
            com.example.test.ui.device.activity.i0 i0Var2 = f0.f11065a;
            i0Var2.getClass();
            try {
                ((Field) i0Var2.f7866b).set(this, a3);
                com.example.test.ui.device.activity.i0 i0Var3 = f0.f11066b;
                i0Var3.getClass();
                try {
                    ((Field) i0Var3.f7866b).set(this, Integer.valueOf(i3));
                    com.example.test.ui.device.activity.i0 i0Var4 = k0.f11087a;
                    Object of2 = comparator == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet(comparator);
                    i0Var4.getClass();
                    try {
                        ((Field) i0Var4.f7866b).set(this, of2);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    }
                } catch (IllegalAccessException e10) {
                    throw new AssertionError(e10);
                }
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        } catch (IllegalArgumentException e12) {
            throw ((InvalidObjectException) new InvalidObjectException(e12.getMessage()).initCause(e12));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        h.q(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(@NullableDecl Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @NullableDecl
    public Comparator<? super V> valueComparator() {
        ImmutableSet immutableSet = this.f11018d;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v6) {
        j0 builder = builder();
        builder.e(k10, v6);
        return builder.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo66get(@NullableDecl Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.e;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        j0 builder = builder();
        d2 it = mo64entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.e(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> d5 = builder.d();
        d5.e = this;
        this.e = d5;
        return d5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo69replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Set mo66get(@NullableDecl Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Set mo69replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: entries */
    public ImmutableSet<Map.Entry<K, V>> mo64entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f11019f;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f11019f = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSet<V> get(@NullableDecl K k10) {
        ImmutableSet<V> immutableSet = (ImmutableSet) this.map.get(k10);
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<V> immutableSet2 = this.f11018d;
        if (immutableSet2 != null) {
            return immutableSet2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: removeAll */
    public ImmutableSet<V> mo68removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v6, K k11, V v9) {
        j0 builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        return builder.d();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(q1 q1Var) {
        q1Var.getClass();
        if (q1Var.isEmpty()) {
            return of();
        }
        if (q1Var instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) q1Var;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(q1Var.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10) {
        j0 builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        builder.e(k12, v10);
        return builder.d();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11) {
        j0 builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        builder.e(k12, v10);
        builder.e(k13, v11);
        return builder.d();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11, K k14, V v12) {
        j0 builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        builder.e(k12, v10);
        builder.e(k13, v11);
        builder.e(k14, v12);
        return builder.d();
    }
}
