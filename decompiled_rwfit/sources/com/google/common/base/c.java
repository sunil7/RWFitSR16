package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class c {
    public static c equals() {
        return Equivalence$Equals.INSTANCE;
    }

    public static c identity() {
        return Equivalence$Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(Object obj, Object obj2);

    public abstract int doHash(Object obj);

    public final boolean equivalent(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return doEquivalent(obj, obj2);
    }

    public final e equivalentTo(@NullableDecl Object obj) {
        return new Equivalence$EquivalentToPredicate(this, obj);
    }

    public final int hash(@NullableDecl Object obj) {
        if (obj == null) {
            return 0;
        }
        return doHash(obj);
    }

    public final <F> c onResultOf(d dVar) {
        return new FunctionalEquivalence(dVar, this);
    }

    public final <S> c pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S> Equivalence$Wrapper<S> wrap(@NullableDecl final S s7) {
        final b bVar = null;
        return (Equivalence$Wrapper<S>) new Serializable(this, s7, bVar) { // from class: com.google.common.base.Equivalence$Wrapper
            private static final long serialVersionUID = 0;
            private final c equivalence;

            @NullableDecl
            private final T reference;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.getClass();
                this.equivalence = this;
                this.reference = s7;
            }

            public boolean equals(@NullableDecl Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Equivalence$Wrapper)) {
                    return false;
                }
                Equivalence$Wrapper equivalence$Wrapper = (Equivalence$Wrapper) obj;
                if (this.equivalence.equals(equivalence$Wrapper.equivalence)) {
                    return this.equivalence.equivalent(this.reference, equivalence$Wrapper.reference);
                }
                return false;
            }

            @NullableDecl
            public T get() {
                return this.reference;
            }

            public int hashCode() {
                return this.equivalence.hash(this.reference);
            }

            public String toString() {
                return this.equivalence + ".wrap(" + this.reference + ")";
            }
        };
    }
}
