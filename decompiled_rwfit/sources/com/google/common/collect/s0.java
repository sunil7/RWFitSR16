package com.google.common.collect;

/* loaded from: classes.dex */
public final class s0 extends u0 {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f11117i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(MapMakerInternalMap mapMakerInternalMap, int i3) {
        super(mapMakerInternalMap);
        this.f11117i = i3;
    }

    @Override // com.google.common.collect.u0, java.util.Iterator
    public Object next() {
        switch (this.f11117i) {
            case 1:
                return c().f11100a;
            case 2:
                return c().f11101b;
            default:
                return super.next();
        }
    }
}
