package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class NullsFirstOrdering<T> extends z1 implements Serializable {
    private static final long serialVersionUID = 0;
    final z1 ordering;

    public NullsFirstOrdering(z1 z1Var) {
        this.ordering = z1Var;
    }

    @Override // java.util.Comparator
    public int compare(@NullableDecl T t8, @NullableDecl T t10) {
        if (t8 == t10) {
            return 0;
        }
        if (t8 == null) {
            return -1;
        }
        if (t10 == null) {
            return 1;
        }
        return this.ordering.compare(t8, t10);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.ordering.equals(((NullsFirstOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    @Override // com.google.common.collect.z1
    public <S extends T> z1 nullsFirst() {
        return this;
    }

    @Override // com.google.common.collect.z1
    public <S extends T> z1 nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override // com.google.common.collect.z1
    public <S extends T> z1 reverse() {
        return this.ordering.reverse().nullsLast();
    }

    public String toString() {
        return this.ordering + ".nullsFirst()";
    }
}
