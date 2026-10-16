package com.example.test.presenter.sport;

import com.example.test.R$string;
import com.example.test.ui.sport.activity.SportNewRecordDetailActivity;

/* loaded from: classes.dex */
public final class n implements u5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f7620a;

    public n(o oVar) {
        this.f7620a = oVar;
    }

    @Override // u5.i
    public final void a(int i3) {
        ((SportNewRecordDetailActivity) ((i7.e) this.f7620a.f7255a)).S0();
    }

    @Override // u5.i
    public final void b(float f2) {
        int i3 = (int) (f2 * 100);
        SportNewRecordDetailActivity sportNewRecordDetailActivity = (SportNewRecordDetailActivity) ((i7.e) this.f7620a.f7255a);
        if (!sportNewRecordDetailActivity.R0().isShowing() && i3 < 100) {
            sportNewRecordDetailActivity.R0().show();
            return;
        }
        sportNewRecordDetailActivity.R0().b(sportNewRecordDetailActivity.getString(R$string.str_syncing) + ":" + i3 + "%");
    }

    @Override // u5.i
    public final void onFinish() {
        ((SportNewRecordDetailActivity) ((i7.e) this.f7620a.f7255a)).T0();
    }
}
