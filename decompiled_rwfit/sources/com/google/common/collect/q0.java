package com.google.common.collect;

/* loaded from: classes.dex */
public abstract class q0 implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11112a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11113b;

    /* renamed from: c, reason: collision with root package name */
    public final v0 f11114c;

    public q0(Object obj, int i3, v0 v0Var) {
        this.f11112a = obj;
        this.f11113b = i3;
        this.f11114c = v0Var;
    }

    @Override // com.google.common.collect.v0
    public final v0 b() {
        return this.f11114c;
    }

    @Override // com.google.common.collect.v0
    public final int c() {
        return this.f11113b;
    }

    @Override // com.google.common.collect.v0
    public final Object getKey() {
        return this.f11112a;
    }
}
