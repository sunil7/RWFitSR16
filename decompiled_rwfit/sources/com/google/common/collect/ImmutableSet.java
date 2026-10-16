package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;

    /* renamed from: b, reason: collision with root package name */
    public transient ImmutableList f11017b;

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static ImmutableSet a(int i3, Object... objArr) {
        if (i3 == 0) {
            return of();
        }
        if (i3 == 1) {
            return of(objArr[0]);
        }
        int chooseTableSize = chooseTableSize(i3);
        Object[] objArr2 = new Object[chooseTableSize];
        int i10 = chooseTableSize - 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i3; i13++) {
            Object obj = objArr[i13];
            if (obj == null) {
                throw new NullPointerException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i13, "at index "));
            }
            int hashCode = obj.hashCode();
            int n4 = h.n(hashCode);
            while (true) {
                int i14 = n4 & i10;
                Object obj2 = objArr2[i14];
                if (obj2 == null) {
                    objArr[i12] = obj;
                    objArr2[i14] = obj;
                    i11 += hashCode;
                    i12++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                n4++;
            }
        }
        Arrays.fill(objArr, i12, i3, (Object) null);
        if (i12 == 1) {
            return new SingletonImmutableSet(objArr[0], i11);
        }
        if (chooseTableSize(i12) < chooseTableSize / 2) {
            return a(i12, objArr);
        }
        int length = objArr.length;
        if (i12 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i12);
        }
        return new RegularImmutableSet(objArr, i11, objArr2, i10, i12);
    }

    public static boolean access$000(int i3, int i10) {
        return i3 < (i10 >> 1) + (i10 >> 2);
    }

    public static <E> i0 builder() {
        return new i0(4);
    }

    public static <E> i0 builderWithExpectedSize(int i3) {
        h.d(i3, "expectedSize");
        i0 i0Var = new i0(i3);
        i0Var.f11079d = new Object[chooseTableSize(i3)];
        return i0Var;
    }

    public static int chooseTableSize(int i3) {
        int max = Math.max(i3, 2);
        if (max >= 751619276) {
            kb.c("collection too large", max < MAX_TABLE_SIZE);
            return MAX_TABLE_SIZE;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * 0.7d < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return a(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f11017b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.f11017b = createAsList;
        return createAsList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (size() == set.size()) {
                        if (containsAll(set)) {
                        }
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return h.m(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract d2 iterator();

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e10) {
        return a(2, e, e10);
    }

    public static <E> ImmutableSet<E> of(E e, E e10, E e11) {
        return a(3, e, e10, e11);
    }

    public static <E> ImmutableSet<E> of(E e, E e10, E e11, E e12) {
        return a(4, e, e10, e11, e12);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e, E e10, E e11, E e12, E e13) {
        return a(5, e, e10, e11, e12, e13);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e, E e10, E e11, E e12, E e13, E e14, E... eArr) {
        kb.c("the total number of elements must fit in an int", eArr.length <= 2147483641);
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e10;
        objArr[2] = e11;
        objArr[3] = e12;
        objArr[4] = e13;
        objArr[5] = e14;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return a(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        i0 i0Var = new i0(4);
        i0Var.t(next);
        while (it.hasNext()) {
            i0Var.t(it.next());
        }
        return i0Var.u();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return a(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
