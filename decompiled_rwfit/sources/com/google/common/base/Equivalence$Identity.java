package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes.dex */
final class Equivalence$Identity extends c implements Serializable {
    static final Equivalence$Identity INSTANCE = new Equivalence$Identity();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.c
    public boolean doEquivalent(Object obj, Object obj2) {
        return false;
    }

    @Override // com.google.common.base.c
    public int doHash(Object obj) {
        return System.identityHashCode(obj);
    }
}
