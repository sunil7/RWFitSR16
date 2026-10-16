package com.example.test.ui.device.activity;

/* loaded from: classes.dex */
public final class n0 implements t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7879a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WomenHealthJLActivity f7880b;

    public /* synthetic */ n0(WomenHealthJLActivity womenHealthJLActivity, int i3) {
        this.f7879a = i3;
        this.f7880b = womenHealthJLActivity;
    }

    @Override // t6.a
    public final void v(String data) {
        WomenHealthJLActivity womenHealthJLActivity = this.f7880b;
        int i3 = this.f7879a;
        kotlin.jvm.internal.e.f(data, "data");
        switch (i3) {
            case 0:
                int i10 = WomenHealthJLActivity.K;
                womenHealthJLActivity.R0().setPeriodDuration(Integer.parseInt(data));
                womenHealthJLActivity.S0();
                break;
            default:
                int i11 = WomenHealthJLActivity.K;
                womenHealthJLActivity.R0().setRangeDuration(Integer.parseInt(data));
                womenHealthJLActivity.S0();
                break;
        }
    }
}
