package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements s1 {

    /* renamed from: b, reason: collision with root package name */
    public transient ImmutableList f11015b;

    /* renamed from: c, reason: collision with root package name */
    public transient ImmutableSet f11016c;

    public final class EntrySet extends IndexedImmutableSet<r1> {
        private static final long serialVersionUID = 0;

        public EntrySet(g0 g0Var) {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof r1) {
                r1 r1Var = (r1) obj;
                if (r1Var.getCount() > 0 && ImmutableMultiset.this.count(r1Var.getElement()) == r1Var.getCount()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.IndexedImmutableSet
        public r1 get(int i3) {
            return ImmutableMultiset.this.getEntry(i3);
        }
    }

    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public static ImmutableMultiset a(Object... objArr) {
        w1 w1Var = new w1();
        w1Var.e(4);
        for (Object obj : objArr) {
            obj.getClass();
            w1Var.f(w1Var.b(obj) + 1, obj);
        }
        return w1Var.f11141c == 0 ? of() : new RegularImmutableMultiset(w1Var);
    }

    public static <E> h0 builder() {
        return new h0(4);
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends r1> collection) {
        int size = collection.size();
        w1 w1Var = new w1();
        w1Var.e(size);
        for (r1 r1Var : collection) {
            Object element = r1Var.getElement();
            int count = r1Var.getCount();
            if (count != 0) {
                element.getClass();
                w1Var.f(w1Var.b(element) + count, element);
            }
        }
        return w1Var.f11141c == 0 ? of() : new RegularImmutableMultiset(w1Var);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        w1 w1Var = new w1();
        w1Var.e(4);
        while (it.hasNext()) {
            E next = it.next();
            next.getClass();
            w1Var.f(w1Var.b(next) + 1, next);
        }
        return w1Var.f11141c == 0 ? of() : new RegularImmutableMultiset(w1Var);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.s1
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E e, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f11015b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList = super.asList();
        this.f11015b = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        d2 it = entrySet().iterator();
        while (it.hasNext()) {
            r1 r1Var = (r1) it.next();
            Arrays.fill(objArr, i3, r1Var.getCount() + i3, r1Var.getElement());
            i3 += r1Var.getCount();
        }
        return i3;
    }

    public abstract /* synthetic */ int count(@NullableDecl @CompatibleWith("E") Object obj);

    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection
    public boolean equals(@NullableDecl Object obj) {
        return h.h(this, obj);
    }

    public abstract r1 getEntry(int i3);

    @Override // java.util.Collection
    public int hashCode() {
        return h.m(entrySet());
    }

    @Override // com.google.common.collect.s1
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E e, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> of(E e) {
        return a(e);
    }

    @Override // com.google.common.collect.s1
    public ImmutableSet<r1> entrySet() {
        ImmutableSet<r1> immutableSet = this.f11016c;
        if (immutableSet == null) {
            immutableSet = isEmpty() ? ImmutableSet.of() : new EntrySet(null);
            this.f11016c = immutableSet;
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public d2 iterator() {
        return new g0(entrySet().iterator());
    }

    @Override // com.google.common.collect.s1
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E e, int i3, int i10) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e, E e10) {
        return a(e, e10);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e10, E e11) {
        return a(e, e10, e11);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e10, E e11, E e12) {
        return a(e, e10, e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e10, E e11, E e12, E e13) {
        return a(e, e10, e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e10, E e11, E e12, E e13, E e14, E... eArr) {
        h0 h0Var = new h0(4);
        h0Var.r(1, e);
        h0Var.r(1, e10);
        h0Var.r(1, e11);
        h0Var.r(1, e12);
        h0Var.r(1, e13);
        h0Var.r(1, e14);
        for (E e15 : eArr) {
            h0Var.r(1, e15);
        }
        return h0Var.s();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return a(eArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006b -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <E> com.google.common.collect.ImmutableMultiset<E> copyOf(java.lang.Iterable<? extends E> r5) {
        /*
            boolean r0 = r5 instanceof com.google.common.collect.ImmutableMultiset
            if (r0 == 0) goto Le
            r0 = r5
            com.google.common.collect.ImmutableMultiset r0 = (com.google.common.collect.ImmutableMultiset) r0
            boolean r1 = r0.isPartialView()
            if (r1 != 0) goto Le
            return r0
        Le:
            com.google.common.collect.h0 r0 = new com.google.common.collect.h0
            boolean r1 = r5 instanceof com.google.common.collect.s1
            if (r1 == 0) goto L20
            r2 = r5
            com.google.common.collect.s1 r2 = (com.google.common.collect.s1) r2
            java.util.Set r2 = r2.elementSet()
            int r2 = r2.size()
            goto L22
        L20:
            r2 = 11
        L22:
            r0.<init>(r2)
            if (r1 == 0) goto La1
            com.google.common.collect.s1 r5 = (com.google.common.collect.s1) r5
            boolean r1 = r5 instanceof com.google.common.collect.RegularImmutableMultiset
            if (r1 == 0) goto L33
            r1 = r5
            com.google.common.collect.RegularImmutableMultiset r1 = (com.google.common.collect.RegularImmutableMultiset) r1
            com.google.common.collect.w1 r1 = r1.contents
            goto L3e
        L33:
            boolean r1 = r5 instanceof com.google.common.collect.AbstractMapBasedMultiset
            if (r1 == 0) goto L3d
            r1 = r5
            com.google.common.collect.AbstractMapBasedMultiset r1 = (com.google.common.collect.AbstractMapBasedMultiset) r1
            com.google.common.collect.w1 r1 = r1.backingMap
            goto L3e
        L3d:
            r1 = 0
        L3e:
            if (r1 == 0) goto L6e
            com.google.common.collect.w1 r5 = r0.f11074a
            int r2 = r5.f11141c
            int r3 = r1.f11141c
            int r2 = java.lang.Math.max(r2, r3)
            r5.a(r2)
            int r5 = r1.f11141c
            r2 = -1
            if (r5 != 0) goto L54
        L52:
            r5 = r2
            goto L55
        L54:
            r5 = 0
        L55:
            if (r5 < 0) goto Lb4
            int r3 = r1.f11141c
            com.google.android.gms.internal.mlkit_vision_barcode.kb.d(r5, r3)
            java.lang.Object[] r3 = r1.f11139a
            r3 = r3[r5]
            int r4 = r1.c(r5)
            r0.r(r4, r3)
            int r5 = r5 + 1
            int r3 = r1.f11141c
            if (r5 >= r3) goto L52
            goto L55
        L6e:
            java.util.Set r1 = r5.entrySet()
            com.google.common.collect.w1 r2 = r0.f11074a
            int r3 = r2.f11141c
            int r1 = r1.size()
            int r1 = java.lang.Math.max(r3, r1)
            r2.a(r1)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L89:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto Lb4
            java.lang.Object r1 = r5.next()
            com.google.common.collect.r1 r1 = (com.google.common.collect.r1) r1
            java.lang.Object r2 = r1.getElement()
            int r1 = r1.getCount()
            r0.r(r1, r2)
            goto L89
        La1:
            java.util.Iterator r5 = r5.iterator()
        La5:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto Lb4
            java.lang.Object r1 = r5.next()
            r2 = 1
            r0.r(r2, r1)
            goto La5
        Lb4:
            com.google.common.collect.ImmutableMultiset r5 = r0.s()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableMultiset.copyOf(java.lang.Iterable):com.google.common.collect.ImmutableMultiset");
    }
}
