package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class e1 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e1 f11062a = new e1();

    @Override // com.google.common.collect.w0
    public final MapMakerInternalMap.Segment a(MapMakerInternalMap mapMakerInternalMap, int i3, int i10) {
        return new MapMakerInternalMap.WeakKeyDummyValueSegment(mapMakerInternalMap, i3, i10);
    }

    @Override // com.google.common.collect.w0
    public final v0 b(MapMakerInternalMap.Segment segment, v0 v0Var, v0 v0Var2) {
        ReferenceQueue referenceQueue;
        MapMakerInternalMap.WeakKeyDummyValueSegment weakKeyDummyValueSegment = (MapMakerInternalMap.WeakKeyDummyValueSegment) segment;
        f1 f1Var = (f1) v0Var;
        f1 f1Var2 = (f1) v0Var2;
        if (f1Var.get() == 0) {
            return null;
        }
        referenceQueue = weakKeyDummyValueSegment.queueForKeys;
        return new f1(referenceQueue, f1Var.get(), f1Var.f11115a, f1Var2);
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
        referenceQueue = ((MapMakerInternalMap.WeakKeyDummyValueSegment) segment).queueForKeys;
        return new f1(referenceQueue, obj, i3, (f1) v0Var);
    }

    @Override // com.google.common.collect.w0
    public final /* bridge */ /* synthetic */ void f(MapMakerInternalMap.Segment segment, v0 v0Var, Object obj) {
    }
}
