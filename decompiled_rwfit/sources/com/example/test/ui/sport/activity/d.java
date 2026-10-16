package com.example.test.ui.sport.activity;

/* loaded from: classes.dex */
public final class d implements com.example.test.ui.view.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8164a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportDetailJLActivity f8165b;

    public /* synthetic */ d(SportDetailJLActivity sportDetailJLActivity, int i3) {
        this.f8164a = i3;
        this.f8165b = sportDetailJLActivity;
    }

    @Override // com.example.test.ui.view.l
    public final void a() {
        SportDetailJLActivity sportDetailJLActivity = this.f8165b;
        switch (this.f8164a) {
            case 0:
                int i3 = SportDetailJLActivity.M;
                ((com.example.baselibrary.utils.e) sportDetailJLActivity.J.getValue()).sendEmptyMessage(0);
                break;
            default:
                int i10 = SportDetailJLActivity.M;
                ((com.example.baselibrary.utils.e) sportDetailJLActivity.J.getValue()).sendEmptyMessage(1);
                break;
        }
    }
}
