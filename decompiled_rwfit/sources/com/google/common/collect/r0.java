package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class r0 extends WeakReference implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f11115a;

    /* renamed from: b, reason: collision with root package name */
    public final v0 f11116b;

    public r0(ReferenceQueue referenceQueue, Object obj, int i3, v0 v0Var) {
        super(obj, referenceQueue);
        this.f11115a = i3;
        this.f11116b = v0Var;
    }

    @Override // com.google.common.collect.v0
    public final v0 b() {
        return this.f11116b;
    }

    @Override // com.google.common.collect.v0
    public final int c() {
        return this.f11115a;
    }

    @Override // com.google.common.collect.v0
    public final Object getKey() {
        return get();
    }
}
