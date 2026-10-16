package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class ImmutableMultimap<K, V> extends g implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        @Weak
        final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public d2 iterator() {
            return this.multimap.m65entryIterator();
        }
    }

    public class Keys extends ImmutableMultiset<K> {
        public Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.s1
        public int count(@NullableDecl Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public r1 getEntry(int i3) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i3);
            return new Multisets$ImmutableEntry(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.s1
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.m67keySet();
        }
    }

    public static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        public final transient ImmutableMultimap f11014b;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.f11014b = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.f11014b.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i3) {
            d2 it = this.f11014b.map.values().iterator();
            while (it.hasNext()) {
                i3 = ((ImmutableCollection) it.next()).copyIntoArray(objArr, i3);
            }
            return i3;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f11014b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public d2 iterator() {
            return this.f11014b.m70valueIterator();
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i3) {
        this.map = immutableMap;
        this.size = i3;
    }

    public static <K, V> e0 builder() {
        return new e0();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(q1 q1Var) {
        if (q1Var instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) q1Var;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf(q1Var);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.g
    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.g
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public abstract ImmutableCollection<V> get(K k10);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Collection mo66get(Object obj) {
        return get((ImmutableMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.g
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.g, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(K k10, V v6) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Collection mo69replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.q1
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.g
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v6) {
        return ImmutableListMultimap.of((Object) k10, (Object) v6);
    }

    @Override // com.google.common.collect.q1
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    /* renamed from: createEntries, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<Map.Entry<K, V>> m62createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.g
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    /* renamed from: createValues, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> m63createValues() {
        return new Values(this);
    }

    @Override // 
    /* renamed from: entries, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<Map.Entry<K, V>> mo64entries() {
        Collection collection = this.f11067a;
        if (collection == null) {
            collection = m62createEntries();
            this.f11067a = collection;
        }
        return (ImmutableCollection) collection;
    }

    /* renamed from: entryIterator, reason: merged with bridge method [inline-methods] */
    public d2 m65entryIterator() {
        return new c0(this);
    }

    /* renamed from: keySet, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<K> m67keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.g
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(q1 q1Var) {
        throw new UnsupportedOperationException();
    }

    @Override // 
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: removeAll, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> mo68removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: valueIterator, reason: merged with bridge method [inline-methods] */
    public d2 m70valueIterator() {
        d0 d0Var = new d0();
        d0Var.f11056a = this.map.values().iterator();
        d0Var.f11057b = n0.f11098d;
        return d0Var;
    }

    /* renamed from: values, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> m71values() {
        Collection collection = this.f11069c;
        if (collection == null) {
            collection = m63createValues();
            this.f11069c = collection;
        }
        return (ImmutableCollection) collection;
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v6, K k11, V v9) {
        return ImmutableListMultimap.of((Object) k10, (Object) v6, (Object) k11, (Object) v9);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10) {
        return ImmutableListMultimap.of((Object) k10, (Object) v6, (Object) k11, (Object) v9, (Object) k12, (Object) v10);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11) {
        return ImmutableListMultimap.of((Object) k10, (Object) v6, (Object) k11, (Object) v9, (Object) k12, (Object) v10, (Object) k13, (Object) v11);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11, K k14, V v12) {
        return ImmutableListMultimap.of((Object) k10, (Object) v6, (Object) k11, (Object) v9, (Object) k12, (Object) v10, (Object) k13, (Object) v11, (Object) k14, (Object) v12);
    }
}
