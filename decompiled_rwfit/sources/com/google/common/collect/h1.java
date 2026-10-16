package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class h1 extends r0 {

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f11076c;

    public h1(ReferenceQueue referenceQueue, Object obj, int i3, h1 h1Var) {
        super(referenceQueue, obj, i3, h1Var);
        this.f11076c = null;
    }

    @Override // com.google.common.collect.v0
    public final Object getValue() {
        return this.f11076c;
    }
}
