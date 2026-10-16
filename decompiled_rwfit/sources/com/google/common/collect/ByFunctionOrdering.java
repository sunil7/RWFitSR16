package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class ByFunctionOrdering<F, T> extends z1 implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.d function;
    final z1 ordering;

    public ByFunctionOrdering(com.google.common.base.d dVar, z1 z1Var) {
        dVar.getClass();
        this.function = dVar;
        z1Var.getClass();
        this.ordering = z1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public int compare(F f2, F f10) {
        return this.ordering.compare(this.function.apply(f2), this.function.apply(f10));
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByFunctionOrdering) {
            ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
            if (this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
