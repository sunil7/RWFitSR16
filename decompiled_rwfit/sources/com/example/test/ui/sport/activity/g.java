package com.example.test.ui.sport.activity;

import com.autonavi.aps.amapapi.config.Const;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8170a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SportNewDetailJLActivity f8171b;

    public /* synthetic */ g(SportNewDetailJLActivity sportNewDetailJLActivity, int i3) {
        this.f8170a = i3;
        this.f8171b = sportNewDetailJLActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SportNewDetailJLActivity this$0 = this.f8171b;
        switch (this.f8170a) {
            case 0:
                int i3 = SportNewDetailJLActivity.Q;
                Thread.sleep(300L);
                yh.d.b().e(new EventBusBeans.SportMapDataPushEvent(this$0.P));
                break;
            case 1:
                int i10 = SportNewDetailJLActivity.Q;
                this$0.finish();
                break;
            case 2:
                int i11 = SportNewDetailJLActivity.Q;
                Thread.sleep(1000L);
                ((com.example.test.presenter.sport.l) this$0.I0()).k(1);
                break;
            default:
                kotlin.jvm.internal.e.f(this$0, "this$0");
                Thread.sleep(Const.L_MAX_WAIT_WIFI);
                this$0.finish();
                break;
        }
    }
}
