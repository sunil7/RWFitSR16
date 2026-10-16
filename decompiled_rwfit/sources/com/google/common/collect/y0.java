package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* loaded from: classes.dex */
public final class y0 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final y0 f11152a = new y0();

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Segment a(MapMakerInternalMap mapMakerInternalMap, int i3, int i10) {
        return new MapMakerInternalMap.StrongKeyDummyValueSegment(mapMakerInternalMap, i3, i10);
    }

    @Override // com.google.common.collect.w0
    public final v0 b(MapMakerInternalMap.Segment segment, v0 v0Var, v0 v0Var2) {
        z0 z0Var = (z0) v0Var;
        return new z0(z0Var.f11112a, z0Var.f11113b, (z0) v0Var2);
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
        return new z0(obj, i3, (z0) v0Var);
    }

    @Override // com.google.common.collect.w0
    public final /* bridge */ /* synthetic */ void f(MapMakerInternalMap.Segment segment, v0 v0Var, Object obj) {
    }
}
