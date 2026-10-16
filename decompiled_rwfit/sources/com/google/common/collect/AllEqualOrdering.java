package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class AllEqualOrdering extends z1 implements Serializable {
    static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.z1
    public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.copyOf(iterable);
    }

    @Override // com.google.common.collect.z1
    public <S> z1 reverse() {
        return this;
    }

    @Override // com.google.common.collect.z1
    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        Iterator<E> it = iterable.iterator();
        ArrayList arrayList = new ArrayList();
        h.a(arrayList, it);
        return arrayList;
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
