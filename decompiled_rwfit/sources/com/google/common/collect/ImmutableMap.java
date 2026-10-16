package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    /* renamed from: a, reason: collision with root package name */
    public transient ImmutableSet f11010a;

    /* renamed from: b, reason: collision with root package name */
    public transient ImmutableSet f11011b;

    /* renamed from: c, reason: collision with root package name */
    public transient ImmutableCollection f11012c;

    /* renamed from: d, reason: collision with root package name */
    public transient ImmutableSetMultimap f11013d;

    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public d2 iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract d2 entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        public MapViewOfValuesAsSingletonSets(x xVar) {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public d2 entryIterator() {
            return new a0(ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(@NullableDecl Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            d2 it = immutableMap.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                this.keys[i3] = entry.getKey();
                this.values[i3] = entry.getValue();
                i3++;
            }
        }

        public Object createMap(y yVar) {
            int i3 = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i3 >= objArr.length) {
                    return yVar.a();
                }
                yVar.b(objArr[i3], this.values[i3]);
                i3++;
            }
        }

        public Object readResolve() {
            return createMap(new y(this.keys.length));
        }
    }

    public static <K, V> y builder() {
        return new y(4);
    }

    public static <K, V> y builderWithExpectedSize(int i3) {
        h.d(i3, "expectedSize");
        return new y(i3);
    }

    public static void checkNoConflict(boolean z5, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z5) {
            throw conflictException(str, entry, entry2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k10, V v6) {
        h.c(k10, v6);
        return new AbstractMap.SimpleImmutableEntry(k10, v6);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.f11013d;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(null), size(), null);
        this.f11013d = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v6) {
        V v9 = get(obj);
        return v9 != null ? v9 : v6;
    }

    @Override // java.util.Map
    public int hashCode() {
        return h.m(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public d2 keyIterator() {
        return new x(entrySet().iterator());
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k10, V v6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return h.p(this);
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v6) {
        h.c(k10, v6);
        return RegularImmutableMap.create(1, new Object[]{k10, v6});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f11010a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.f11010a = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.f11011b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.f11011b = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.f11012c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.f11012c = createValues;
        return createValues;
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v6, K k11, V v9) {
        h.c(k10, v6);
        h.c(k11, v9);
        return RegularImmutableMap.create(2, new Object[]{k10, v6, k11, v9});
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        int size;
        boolean z5 = iterable instanceof Collection;
        Object[] objArr = new Object[(z5 ? ((Collection) iterable).size() : 4) * 2];
        if (z5 && (size = ((Collection) iterable).size() * 2) > objArr.length) {
            objArr = Arrays.copyOf(objArr, h.i(objArr.length, size));
        }
        int i3 = 0;
        for (Map.Entry<? extends K, ? extends V> entry : iterable) {
            K key = entry.getKey();
            V value = entry.getValue();
            int i10 = (i3 + 1) * 2;
            if (i10 > objArr.length) {
                objArr = Arrays.copyOf(objArr, h.i(objArr.length, i10));
            }
            h.c(key, value);
            objArr[i3 * 2] = key;
            objArr[(i3 * 2) + 1] = value;
            i3++;
        }
        return RegularImmutableMap.create(i3, objArr);
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10) {
        h.c(k10, v6);
        h.c(k11, v9);
        h.c(k12, v10);
        return RegularImmutableMap.create(3, new Object[]{k10, v6, k11, v9, k12, v10});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11) {
        h.c(k10, v6);
        h.c(k11, v9);
        h.c(k12, v10);
        h.c(k13, v11);
        return RegularImmutableMap.create(4, new Object[]{k10, v6, k11, v9, k12, v10, k13, v11});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11, K k14, V v12) {
        h.c(k10, v6);
        h.c(k11, v9);
        h.c(k12, v10);
        h.c(k13, v11);
        h.c(k14, v12);
        return RegularImmutableMap.create(5, new Object[]{k10, v6, k11, v9, k12, v10, k13, v11, k14, v12});
    }
}
