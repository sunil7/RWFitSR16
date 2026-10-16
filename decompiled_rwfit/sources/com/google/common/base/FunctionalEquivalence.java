package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class FunctionalEquivalence<F, T> extends c implements Serializable {
    private static final long serialVersionUID = 0;
    private final d function;
    private final c resultEquivalence;

    public FunctionalEquivalence(d dVar, c cVar) {
        dVar.getClass();
        this.function = dVar;
        cVar.getClass();
        this.resultEquivalence = cVar;
    }

    @Override // com.google.common.base.c
    public boolean doEquivalent(F f2, F f10) {
        return this.resultEquivalence.equivalent(this.function.apply(f2), this.function.apply(f10));
    }

    @Override // com.google.common.base.c
    public int doHash(F f2) {
        return this.resultEquivalence.hash(this.function.apply(f2));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionalEquivalence) {
            FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
            if (this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
