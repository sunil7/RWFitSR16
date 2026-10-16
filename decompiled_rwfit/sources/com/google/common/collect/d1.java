package com.google.common.collect;

/* loaded from: classes.dex */
public final class d1 extends q0 implements k1 {

    /* renamed from: d, reason: collision with root package name */
    public volatile l1 f11058d;

    public d1(Object obj, int i3, d1 d1Var) {
        super(obj, i3, d1Var);
        this.f11058d = MapMakerInternalMap.unsetWeakValueReference();
    }

    @Override // com.google.common.collect.k1
    public final l1 a() {
        return this.f11058d;
    }

    @Override // com.google.common.collect.v0
    public final Object getValue() {
        return this.f11058d.get();
    }
}
