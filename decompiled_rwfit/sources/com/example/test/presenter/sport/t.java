package com.example.test.presenter.sport;

import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportRecordDetailActivity;

/* loaded from: classes.dex */
public final class t implements u5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f7631a;

    public t(u uVar) {
        this.f7631a = uVar;
    }

    @Override // u5.i
    public final void a(int i3) {
        ((SportRecordDetailActivity) ((i7.g) this.f7631a.f7255a)).S0();
    }

    @Override // u5.i
    public final void b(float f2) {
        int i3 = (int) (f2 * 100);
        SportRecordDetailActivity sportRecordDetailActivity = (SportRecordDetailActivity) ((i7.g) this.f7631a.f7255a);
        if (!sportRecordDetailActivity.R0().isShowing() && i3 < 100) {
            sportRecordDetailActivity.R0().show();
            return;
        }
        sportRecordDetailActivity.R0().b(sportRecordDetailActivity.getString(R$string.str_syncing) + ":" + i3 + "%");
    }

    @Override // u5.i
    public final void onFinish() {
        ((SportRecordDetailActivity) ((i7.g) this.f7631a.f7255a)).T0();
    }
}
