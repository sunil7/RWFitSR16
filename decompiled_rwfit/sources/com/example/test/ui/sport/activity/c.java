package com.example.test.ui.sport.activity;

/* loaded from: classes.dex */
public final class c implements com.example.test.ui.view.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8162a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportDetailActivity f8163b;

    public /* synthetic */ c(SportDetailActivity sportDetailActivity, int i3) {
        this.f8162a = i3;
        this.f8163b = sportDetailActivity;
    }

    @Override // com.example.test.ui.view.l
    public final void a() {
        SportDetailActivity sportDetailActivity = this.f8163b;
        switch (this.f8162a) {
            case 0:
                int i3 = SportDetailActivity.M;
                ((com.example.baselibrary.utils.e) sportDetailActivity.J.getValue()).sendEmptyMessage(0);
                break;
            default:
                int i10 = SportDetailActivity.M;
                ((com.example.baselibrary.utils.e) sportDetailActivity.J.getValue()).sendEmptyMessage(1);
                break;
        }
    }
}
