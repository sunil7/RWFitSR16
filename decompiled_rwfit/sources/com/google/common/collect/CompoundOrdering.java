package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
final class CompoundOrdering<T> extends z1 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    public CompoundOrdering(Iterable<? extends Comparator<? super T>> iterable) {
        Collection collection;
        Comparator[] comparatorArr = new Comparator[0];
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends Comparator<? super T>> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h.a(arrayList, it);
            collection = arrayList;
        }
        this.comparators = (Comparator[]) collection.toArray(comparatorArr);
    }

    @Override // java.util.Comparator
    public int compare(T t8, T t10) {
        int i3 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.comparators;
            if (i3 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i3].compare(t8, t10);
            if (compare != 0) {
                return compare;
            }
            i3++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.comparators, ((CompoundOrdering) obj).comparators);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return r5.a.f(new StringBuilder("Ordering.compound("), Arrays.toString(this.comparators), ")");
    }

    public CompoundOrdering(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.comparators = new Comparator[]{comparator, comparator2};
    }
}
