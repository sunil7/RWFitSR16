package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class i1 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i1 f11080a = new i1();

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Segment a(MapMakerInternalMap mapMakerInternalMap, int i3, int i10) {
        return new MapMakerInternalMap.WeakKeyWeakValueSegment(mapMakerInternalMap, i3, i10);
    }

    @Override // com.google.common.collect.w0
    public final v0 b(MapMakerInternalMap.Segment segment, v0 v0Var, v0 v0Var2) {
        ReferenceQueue referenceQueue;
        ReferenceQueue referenceQueue2;
        MapMakerInternalMap.WeakKeyWeakValueSegment weakKeyWeakValueSegment = (MapMakerInternalMap.WeakKeyWeakValueSegment) segment;
        j1 j1Var = (j1) v0Var;
        j1 j1Var2 = (j1) v0Var2;
        if (j1Var.get() == 0 || MapMakerInternalMap.Segment.isCollected(j1Var)) {
            return null;
        }
        referenceQueue = weakKeyWeakValueSegment.queueForKeys;
        referenceQueue2 = weakKeyWeakValueSegment.queueForValues;
        j1 j1Var3 = new j1(referenceQueue, j1Var.get(), j1Var.f11115a, j1Var2);
        j1Var3.f11083c = j1Var.f11083c.b(referenceQueue2, j1Var3);
        return j1Var3;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength c() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Strength d() {
        return MapMakerInternalMap.Strength.WEAK;
    }

    @Override // com.google.common.collect.w0
    public final v0 e(MapMakerInternalMap.Segment segment, Object obj, int i3, v0 v0Var) {
        ReferenceQueue referenceQueue;
        referenceQueue = ((MapMakerInternalMap.WeakKeyWeakValueSegment) segment).queueForKeys;
        return new j1(referenceQueue, obj, i3, (j1) v0Var);
    }

    @Override // com.google.common.collect.w0
    public final void f(MapMakerInternalMap.Segment segment, v0 v0Var, Object obj) {
        ReferenceQueue referenceQueue;
        j1 j1Var = (j1) v0Var;
        referenceQueue = ((MapMakerInternalMap.WeakKeyWeakValueSegment) segment).queueForValues;
        l1 l1Var = j1Var.f11083c;
        j1Var.f11083c = new m1(referenceQueue, obj, j1Var);
        l1Var.clear();
    }
}
