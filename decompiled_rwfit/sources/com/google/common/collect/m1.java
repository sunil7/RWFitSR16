package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class m1 extends WeakReference implements l1 {

    /* renamed from: a, reason: collision with root package name */
    public final v0 f11097a;

    public m1(ReferenceQueue referenceQueue, Object obj, v0 v0Var) {
        super(obj, referenceQueue);
        this.f11097a = v0Var;
    }

    @Override // com.google.common.collect.l1
    public final v0 a() {
        return this.f11097a;
    }

    @Override // com.google.common.collect.l1
    public final l1 b(ReferenceQueue referenceQueue, k1 k1Var) {
        return new m1(referenceQueue, get(), k1Var);
    }
}
