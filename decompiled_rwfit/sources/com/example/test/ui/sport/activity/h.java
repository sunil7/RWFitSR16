package com.example.test.ui.sport.activity;

import com.example.test.service.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.k1;
import com.google.android.gms.internal.mlkit_vision_barcode.o1;

/* loaded from: classes.dex */
public final class h implements t6.b, com.example.test.ui.view.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8172a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportNewDetailJLActivity f8173b;

    public /* synthetic */ h(SportNewDetailJLActivity sportNewDetailJLActivity, int i3) {
        this.f8172a = i3;
        this.f8173b = sportNewDetailJLActivity;
    }

    @Override // com.example.test.ui.view.l
    public void a() {
        SportNewDetailJLActivity sportNewDetailJLActivity = this.f8173b;
        switch (this.f8172a) {
            case 1:
                int i3 = SportNewDetailJLActivity.Q;
                ((com.example.baselibrary.utils.e) sportNewDetailJLActivity.K.getValue()).sendEmptyMessage(0);
                break;
            default:
                int i10 = SportNewDetailJLActivity.Q;
                ((com.example.baselibrary.utils.e) sportNewDetailJLActivity.K.getValue()).sendEmptyMessage(1);
                break;
        }
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        SportNewDetailJLActivity sportNewDetailJLActivity = this.f8173b;
        sportNewDetailJLActivity.H = true;
        Object obj = s0.N;
        o1.a().f();
        com.example.test.presenter.sport.l lVar = (com.example.test.presenter.sport.l) sportNewDetailJLActivity.I0();
        int S0 = sportNewDetailJLActivity.S0();
        lVar.f7613f = true;
        k1.a((byte) 4, S0);
        if (sportNewDetailJLActivity.O < 120) {
            sportNewDetailJLActivity.finish();
        } else {
            ((com.example.test.presenter.sport.l) sportNewDetailJLActivity.I0()).l();
            new Thread(new g(sportNewDetailJLActivity, 3)).start();
        }
    }
}
