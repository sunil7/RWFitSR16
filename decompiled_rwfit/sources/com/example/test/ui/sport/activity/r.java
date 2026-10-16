package com.example.test.ui.sport.activity;

import com.example.test.presenter.sport.y;

/* loaded from: classes.dex */
public final class r implements t6.a, a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8186a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportSettingActivity f8187b;

    public /* synthetic */ r(SportSettingActivity sportSettingActivity, int i3) {
        this.f8186a = i3;
        this.f8187b = sportSettingActivity;
    }

    @Override // a7.e
    public void B() {
        int i3 = SportSettingActivity.I;
        SportSettingActivity sportSettingActivity = this.f8187b;
        ((y) sportSettingActivity.I0()).l(sportSettingActivity.S0());
    }

    @Override // a7.e
    public void u0() {
        this.f8187b.onBackPressed();
    }

    @Override // t6.a
    public void v(String data) {
        SportSettingActivity sportSettingActivity = this.f8187b;
        int i3 = this.f8186a;
        kotlin.jvm.internal.e.f(data, "data");
        switch (i3) {
            case 0:
                int i10 = SportSettingActivity.I;
                sportSettingActivity.S0().setCalorie(Integer.parseInt(data));
                sportSettingActivity.R0();
                break;
            case 1:
                int i11 = SportSettingActivity.I;
                sportSettingActivity.S0().setDistance(Integer.parseInt(data));
                sportSettingActivity.R0();
                break;
            default:
                int i12 = SportSettingActivity.I;
                sportSettingActivity.S0().setTime(Integer.parseInt(data));
                sportSettingActivity.R0();
                break;
        }
    }
}
