package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes.dex */
final class Equivalence$Equals extends c implements Serializable {
    static final Equivalence$Equals INSTANCE = new Equivalence$Equals();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.c
    public boolean doEquivalent(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    @Override // com.google.common.base.c
    public int doHash(Object obj) {
        return obj.hashCode();
    }
}
