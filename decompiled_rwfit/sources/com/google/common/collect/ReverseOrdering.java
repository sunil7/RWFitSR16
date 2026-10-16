package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class ReverseOrdering<T> extends z1 implements Serializable {
    private static final long serialVersionUID = 0;
    final z1 forwardOrder;

    public ReverseOrdering(z1 z1Var) {
        z1Var.getClass();
        this.forwardOrder = z1Var;
    }

    @Override // java.util.Comparator
    public int compare(T t8, T t10) {
        return this.forwardOrder.compare(t10, t8);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E max(E e, E e10) {
        return (E) this.forwardOrder.min(e, e10);
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E min(E e, E e10) {
        return (E) this.forwardOrder.max(e, e10);
    }

    @Override // com.google.common.collect.z1
    public <S extends T> z1 reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E max(E e, E e10, E e11, E... eArr) {
        return (E) this.forwardOrder.min(e, e10, e11, eArr);
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E min(E e, E e10, E e11, E... eArr) {
        return (E) this.forwardOrder.max(e, e10, e11, eArr);
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // com.google.common.collect.z1
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }
}
