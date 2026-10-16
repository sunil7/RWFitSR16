package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class j1 extends r0 implements k1 {

    /* renamed from: c, reason: collision with root package name */
    public volatile l1 f11083c;

    public j1(ReferenceQueue referenceQueue, Object obj, int i3, j1 j1Var) {
        super(referenceQueue, obj, i3, j1Var);
        this.f11083c = MapMakerInternalMap.unsetWeakValueReference();
    }

    @Override // com.google.common.collect.k1
    public final l1 a() {
        return this.f11083c;
    }

    @Override // com.google.common.collect.v0
    public final Object getValue() {
        return this.f11083c.get();
    }
}
