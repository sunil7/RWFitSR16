package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import java.util.AbstractMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    public final transient int[] e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f11027f;

    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableMap f11028c;

        /* renamed from: d, reason: collision with root package name */
        public final transient Object[] f11029d;
        public final transient int e;

        /* renamed from: f, reason: collision with root package name */
        public final transient int f11030f;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i3, int i10) {
            this.f11028c = immutableMap;
            this.f11029d = objArr;
            this.e = i3;
            this.f11030f = i10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null && value.equals(this.f11028c.get(key))) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i3) {
            return asList().copyIntoArray(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f11030f;
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i3) {
                    kb.d(i3, EntrySet.this.f11030f);
                    int i10 = i3 * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.f11029d[EntrySet.this.e + i10], EntrySet.this.f11029d[i10 + (EntrySet.this.e ^ 1)]);
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f11030f;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public d2 iterator() {
            return asList().iterator();
        }
    }

    public static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableMap f11031c;

        /* renamed from: d, reason: collision with root package name */
        public final transient ImmutableList f11032d;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f11031c = immutableMap;
            this.f11032d = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f11032d;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.f11031c.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i3) {
            return asList().copyIntoArray(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f11031c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public d2 iterator() {
            return asList().iterator();
        }
    }

    public static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: c, reason: collision with root package name */
        public final transient Object[] f11033c;

        /* renamed from: d, reason: collision with root package name */
        public final transient int f11034d;
        public final transient int e;

        public KeysOrValuesAsList(Object[] objArr, int i3, int i10) {
            this.f11033c = objArr;
            this.f11034d = i3;
            this.e = i10;
        }

        @Override // java.util.List
        public Object get(int i3) {
            kb.d(i3, this.e);
            return this.f11033c[(i3 * 2) + this.f11034d];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.e;
        }
    }

    public RegularImmutableMap(int[] iArr, Object[] objArr, int i3) {
        this.e = iArr;
        this.alternatingKeysAndValues = objArr;
        this.f11027f = i3;
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i3, Object[] objArr) {
        if (i3 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i3 == 1) {
            h.c(objArr[0], objArr[1]);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        kb.e(i3, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i3, ImmutableSet.chooseTableSize(i3), 0), objArr, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] createHashTable(java.lang.Object[] r10, int r11, int r12, int r13) {
        /*
            r0 = 1
            if (r11 != r0) goto Le
            r11 = r10[r13]
            r12 = r13 ^ 1
            r10 = r10[r12]
            com.google.common.collect.h.c(r11, r10)
            r10 = 0
            return r10
        Le:
            int r1 = r12 + (-1)
            int[] r12 = new int[r12]
            r2 = -1
            java.util.Arrays.fill(r12, r2)
            r3 = 0
        L17:
            if (r3 >= r11) goto L74
            int r4 = r3 * 2
            int r5 = r4 + r13
            r6 = r10[r5]
            r7 = r13 ^ 1
            int r4 = r4 + r7
            r4 = r10[r4]
            com.google.common.collect.h.c(r6, r4)
            int r7 = r6.hashCode()
            int r7 = com.google.common.collect.h.n(r7)
        L2f:
            r7 = r7 & r1
            r8 = r12[r7]
            if (r8 != r2) goto L39
            r12[r7] = r5
            int r3 = r3 + 1
            goto L17
        L39:
            r9 = r10[r8]
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L44
            int r7 = r7 + 1
            goto L2f
        L44:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Multiple entries with same key: "
            r12.<init>(r13)
            r12.append(r6)
            java.lang.String r13 = "="
            r12.append(r13)
            r12.append(r4)
            java.lang.String r1 = " and "
            r12.append(r1)
            r1 = r10[r8]
            r12.append(r1)
            r12.append(r13)
            r13 = r8 ^ 1
            r10 = r10[r13]
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L74:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.createHashTable(java.lang.Object[], int, int, int):int[]");
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f11027f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f11027f));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f11027f);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) get(this.e, this.alternatingKeysAndValues, this.f11027f, 0, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f11027f;
    }

    public static Object get(@NullableDecl int[] iArr, @NullableDecl Object[] objArr, int i3, int i10, @NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        if (i3 == 1) {
            if (objArr[i10].equals(obj)) {
                return objArr[i10 ^ 1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int n4 = h.n(obj.hashCode());
        while (true) {
            int i11 = n4 & length;
            int i12 = iArr[i11];
            if (i12 == -1) {
                return null;
            }
            if (objArr[i12].equals(obj)) {
                return objArr[i12 ^ 1];
            }
            n4 = i11 + 1;
        }
    }
}
