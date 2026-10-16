package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes.dex */
final class ReverseNaturalOrdering extends z1 implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.z1
    public <S extends Comparable> z1 reverse() {
        return z1.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E max(E e, E e10) {
        return (E) NaturalOrdering.INSTANCE.min(e, e10);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E min(E e, E e10) {
        return (E) NaturalOrdering.INSTANCE.max(e, e10);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E max(E e, E e10, E e11, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.min(e, e10, e11, eArr);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E min(E e, E e10, E e11, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.max(e, e10, e11, eArr);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E max(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E min(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.z1
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.max(iterable);
    }
}
