package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class PairwiseEquivalence<T> extends c implements Serializable {
    private static final long serialVersionUID = 1;
    final c elementEquivalence;

    public PairwiseEquivalence(c cVar) {
        cVar.getClass();
        this.elementEquivalence = cVar;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }

    @Override // com.google.common.base.c
    public boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it = iterable.iterator();
        Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // com.google.common.base.c
    public int doHash(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int i3 = 78721;
        while (it.hasNext()) {
            i3 = (i3 * 24943) + this.elementEquivalence.hash(it.next());
        }
        return i3;
    }
}
