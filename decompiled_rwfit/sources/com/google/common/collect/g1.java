package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class g1 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g1 f11073a = new g1();

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Segment a(MapMakerInternalMap mapMakerInternalMap, int i3, int i10) {
        return new MapMakerInternalMap.WeakKeyStrongValueSegment(mapMakerInternalMap, i3, i10);
    }

    @Override // com.google.common.collect.w0
    public final v0 b(MapMakerInternalMap.Segment segment, v0 v0Var, v0 v0Var2) {
        ReferenceQueue referenceQueue;
        MapMakerInternalMap.WeakKeyStrongValueSegment weakKeyStrongValueSegment = (MapMakerInternalMap.WeakKeyStrongValueSegment) segment;
        h1 h1Var = (h1) v0Var;
        h1 h1Var2 = (h1) v0Var2;
        if (h1Var.get() == 0) {
            return null;
        }
        referenceQueue = weakKeyStrongValueSegment.queueForKeys;
        h1 h1Var3 = new h1(referenceQueue, h1Var.get(), h1Var.f11115a, h1Var2);
        h1Var3.f11076c = h1Var.f11076c;
        return h1Var3;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength c() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength d() {
        return MapMakerInternalMap.Strength.STRONG;
    }

    @Override // com.google.common.collect.w0
    public final v0 e(MapMakerInternalMap.Segment segment, Object obj, int i3, v0 v0Var) {
        ReferenceQueue referenceQueue;
        referenceQueue = ((MapMakerInternalMap.WeakKeyStrongValueSegment) segment).queueForKeys;
        return new h1(referenceQueue, obj, i3, (h1) v0Var);
    }

    @Override // com.google.common.collect.w0
    public final void f(MapMakerInternalMap.Segment segment, v0 v0Var, Object obj) {
        ((h1) v0Var).f11076c = obj;
    }
}
