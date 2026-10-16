package com.google.common.collect;

/* loaded from: classes.dex */
public final class i extends c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11077f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ CompactHashMap f11078g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(CompactHashMap compactHashMap, int i3) {
        super(compactHashMap);
        this.f11077f = i3;
        this.f11078g = compactHashMap;
    }

    @Override // com.google.common.collect.c
    public final Object a(int i3) {
        switch (this.f11077f) {
            case 0:
                return this.f11078g.keys[i3];
            case 1:
                return new k(this.f11078g, i3);
            default:
                return this.f11078g.values[i3];
        }
    }
}
