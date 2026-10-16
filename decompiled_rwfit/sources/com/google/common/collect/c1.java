package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class c1 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c1 f11054a = new c1();

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Segment a(MapMakerInternalMap mapMakerInternalMap, int i3, int i10) {
        return new MapMakerInternalMap.StrongKeyWeakValueSegment(mapMakerInternalMap, i3, i10);
    }

    @Override // com.google.common.collect.w0
    public final v0 b(MapMakerInternalMap.Segment segment, v0 v0Var, v0 v0Var2) {
        ReferenceQueue referenceQueue;
        MapMakerInternalMap.StrongKeyWeakValueSegment strongKeyWeakValueSegment = (MapMakerInternalMap.StrongKeyWeakValueSegment) segment;
        d1 d1Var = (d1) v0Var;
        d1 d1Var2 = (d1) v0Var2;
        if (MapMakerInternalMap.Segment.isCollected(d1Var)) {
            return null;
        }
        referenceQueue = strongKeyWeakValueSegment.queueForValues;
        d1 d1Var3 = new d1(d1Var.f11112a, d1Var.f11113b, d1Var2);
        d1Var3.f11058d = d1Var.f11058d.b(referenceQueue, d1Var3);
        return d1Var3;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength c() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength d() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.w0
    public final v0 e(MapMakerInternalMap.Segment segment, Object obj, int i3, v0 v0Var) {
        return new d1(obj, i3, (d1) v0Var);
    }

    @Override // com.google.common.collect.w0
    public final void f(MapMakerInternalMap.Segment segment, v0 v0Var, Object obj) {
        ReferenceQueue referenceQueue;
        d1 d1Var = (d1) v0Var;
        referenceQueue = ((MapMakerInternalMap.StrongKeyWeakValueSegment) segment).queueForValues;
        l1 l1Var = d1Var.f11058d;
        d1Var.f11058d = new m1(referenceQueue, obj, d1Var);
        l1Var.clear();
    }
}
