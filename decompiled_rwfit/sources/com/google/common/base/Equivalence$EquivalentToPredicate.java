package com.google.common.base;

import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class Equivalence$EquivalentToPredicate<T> implements e, Serializable {
    private static final long serialVersionUID = 0;
    private final c equivalence;

    @NullableDecl
    private final T target;

    public Equivalence$EquivalentToPredicate(c cVar, @NullableDecl T t8) {
        cVar.getClass();
        this.equivalence = cVar;
        this.target = t8;
    }

    public boolean apply(@NullableDecl T t8) {
        return this.equivalence.equivalent(t8, this.target);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Equivalence$EquivalentToPredicate) {
            Equivalence$EquivalentToPredicate equivalence$EquivalentToPredicate = (Equivalence$EquivalentToPredicate) obj;
            if (this.equivalence.equals(equivalence$EquivalentToPredicate.equivalence) && jb.a(this.target, equivalence$EquivalentToPredicate.target)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.equivalence, this.target});
    }

    public String toString() {
        return this.equivalence + ".equivalentTo(" + this.target + ")";
    }
}
