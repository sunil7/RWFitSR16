package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* loaded from: classes.dex */
public final class a1 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a1 f11042a = new a1();

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Segment a(MapMakerInternalMap mapMakerInternalMap, int i3, int i10) {
        return new MapMakerInternalMap.StrongKeyStrongValueSegment(mapMakerInternalMap, i3, i10);
    }

    @Override // com.google.common.collect.w0
    public final v0 b(MapMakerInternalMap.Segment segment, v0 v0Var, v0 v0Var2) {
        b1 b1Var = (b1) v0Var;
        b1 b1Var2 = new b1(b1Var.f11112a, b1Var.f11113b, (b1) v0Var2);
        b1Var2.f11046d = b1Var.f11046d;
        return b1Var2;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength c() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength d() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.w0
    public final v0 e(MapMakerInternalMap.Segment segment, Object obj, int i3, v0 v0Var) {
        return new b1(obj, i3, (b1) v0Var);
    }

    @Override // com.google.common.collect.w0
    public final void f(MapMakerInternalMap.Segment segment, v0 v0Var, Object obj) {
        ((b1) v0Var).f11046d = obj;
    }
}
