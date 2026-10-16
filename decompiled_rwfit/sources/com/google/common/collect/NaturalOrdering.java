package com.google.common.collect;

import java.io.Serializable;

/* loaded from: classes.dex */
final class NaturalOrdering extends z1 implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    public transient z1 f11024a;

    /* renamed from: b, reason: collision with root package name */
    public transient z1 f11025b;

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.z1
    public <S extends Comparable> z1 nullsFirst() {
        z1 z1Var = this.f11024a;
        if (z1Var != null) {
            return z1Var;
        }
        z1 nullsFirst = super.nullsFirst();
        this.f11024a = nullsFirst;
        return nullsFirst;
    }

    @Override // com.google.common.collect.z1
    public <S extends Comparable> z1 nullsLast() {
        z1 z1Var = this.f11025b;
        if (z1Var != null) {
            return z1Var;
        }
        z1 nullsLast = super.nullsLast();
        this.f11025b = nullsLast;
        return nullsLast;
    }

    @Override // com.google.common.collect.z1
    public <S extends Comparable> z1 reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    @Override // java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }
}
