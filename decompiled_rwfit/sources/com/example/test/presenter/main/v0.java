package com.example.test.presenter.main;

import java.util.function.ToIntFunction;

/* loaded from: classes.dex */
public final /* synthetic */ class v0 implements ToIntFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7575a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ oh.l f7576b;

    public /* synthetic */ v0(oh.l lVar, int i3) {
        this.f7575a = i3;
        this.f7576b = lVar;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.f7575a) {
            case 0:
                oh.l tmp0 = this.f7576b;
                kotlin.jvm.internal.e.f(tmp0, "$tmp0");
                return ((Number) tmp0.invoke(obj)).intValue();
            case 1:
                oh.l tmp02 = this.f7576b;
                kotlin.jvm.internal.e.f(tmp02, "$tmp0");
                return ((Number) tmp02.invoke(obj)).intValue();
            case 2:
                oh.l tmp03 = this.f7576b;
                kotlin.jvm.internal.e.f(tmp03, "$tmp0");
                return ((Number) tmp03.invoke(obj)).intValue();
            case 3:
                oh.l tmp04 = this.f7576b;
                kotlin.jvm.internal.e.f(tmp04, "$tmp0");
                return ((Number) tmp04.invoke(obj)).intValue();
            default:
                oh.l tmp05 = this.f7576b;
                kotlin.jvm.internal.e.f(tmp05, "$tmp0");
                return ((Number) tmp05.invoke(obj)).intValue();
        }
    }
}
