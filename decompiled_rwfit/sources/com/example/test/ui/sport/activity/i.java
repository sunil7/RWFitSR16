package com.example.test.ui.sport.activity;

import android.os.Handler;
import android.os.Message;
import com.example.blesdk.bean.sync.SportDataPushBean;
import com.example.test.ui.model.EventBusBeans;
import f6.d2;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SportNewDetailJLActivity f8174a;

    public i(SportNewDetailJLActivity sportNewDetailJLActivity) {
        this.f8174a = sportNewDetailJLActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        kotlin.jvm.internal.e.f(msg, "msg");
        SportNewDetailJLActivity sportNewDetailJLActivity = this.f8174a;
        long j4 = sportNewDetailJLActivity.O;
        long j10 = 3600;
        long j11 = 60;
        ((d2) sportNewDetailJLActivity.f7247z.getValue()).f12802p.setText(String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4 / j10), Long.valueOf((j4 % j10) / j11), Long.valueOf((j4 % j10) % j11)}, 3)));
        SportDataPushBean sportDataPushBean = sportNewDetailJLActivity.P;
        if (sportDataPushBean != null) {
            sportDataPushBean.settActivityTime(Integer.valueOf((int) sportNewDetailJLActivity.O));
        }
        yh.d.b().e(new EventBusBeans.SportMapDataPushEvent(sportNewDetailJLActivity.P));
    }
}
