package com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class z1 implements Comparator {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    public static z1 allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static z1 arbitrary() {
        return y1.f11153a;
    }

    public static <T> z1 explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    public static <T> z1 from(Comparator<T> comparator) {
        return comparator instanceof z1 ? (z1) comparator : new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> z1 natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static z1 usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<Object> list, @NullableDecl Object obj) {
        return Collections.binarySearch(list, obj, this);
    }

    public <U> z1 compound(Comparator<? super U> comparator) {
        comparator.getClass();
        return new CompoundOrdering(this, comparator);
    }

    public <E> List<E> greatestOf(Iterable<E> iterable, int i3) {
        return reverse().leastOf(iterable, i3);
    }

    public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E> List<E> leastOf(Iterable<E> iterable, int i3) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i3 * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i3) {
                    array = Arrays.copyOf(array, i3);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i3);
    }

    public <S> z1 lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    public <S> z1 nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S> z1 nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2> z1 onKeys() {
        return onResultOf(Maps$EntryFunction.KEY);
    }

    public <F> z1 onResultOf(com.google.common.base.d dVar) {
        return new ByFunctionOrdering(dVar, this);
    }

    public <S> z1 reverse() {
        return new ReverseOrdering(this);
    }

    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h.a(arrayList, it);
            collection = arrayList;
        }
        Object[] array = collection.toArray();
        Arrays.sort(array, this);
        List asList = Arrays.asList(array);
        asList.getClass();
        if (asList instanceof Collection) {
            return new ArrayList(asList);
        }
        Iterator it2 = asList.iterator();
        ArrayList arrayList2 = new ArrayList();
        h.a(arrayList2, it2);
        return arrayList2;
    }

    public static <T> z1 explicit(T t8, T... tArr) {
        return explicit(new Lists$OnePlusArrayList(t8, tArr));
    }

    @Deprecated
    public static <T> z1 from(z1 z1Var) {
        z1Var.getClass();
        return z1Var;
    }

    public <E> List<E> greatestOf(Iterator<E> it, int i3) {
        return reverse().leastOf(it, i3);
    }

    public static <T> z1 compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    public <E> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    public <E> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    public <E> E max(@NullableDecl E e, @NullableDecl E e10) {
        return compare(e, e10) >= 0 ? e : e10;
    }

    public <E> E min(@NullableDecl E e, @NullableDecl E e10) {
        return compare(e, e10) <= 0 ? e : e10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E max(@NullableDecl E e, @NullableDecl E e10, @NullableDecl E e11, E... eArr) {
        E e12 = (E) max(max(e, e10), e11);
        for (E e13 : eArr) {
            e12 = (E) max(e12, e13);
        }
        return e12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> E min(@NullableDecl E e, @NullableDecl E e10, @NullableDecl E e11, E... eArr) {
        E e12 = (E) min(min(e, e10), e11);
        for (E e13 : eArr) {
            e12 = (E) min(e12, e13);
        }
        return e12;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0128 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <E> java.util.List<E> leastOf(java.util.Iterator<E> r19, int r20) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.z1.leastOf(java.util.Iterator, int):java.util.List");
    }
}
