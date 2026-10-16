package com.example.test.presenter.main;

import android.util.Log;
import android.widget.TextView;
import com.example.test.R$drawable;
import com.example.test.R$string;
import com.example.test.ui.testui.TRingBloodSugarStatisticsActivity;

/* loaded from: classes.dex */
public final class q implements w5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f7547a;

    public q(r rVar) {
        this.f7547a = rVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BSStatisticsPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "WearHandCallback errorCode "));
    }

    @Override // u5.g
    public final void c() {
        Log.d("BSStatisticsPresenter", "start test");
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        Log.d("BSStatisticsPresenter", "start onResult data = " + num);
        if (num != null) {
            TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity = (TRingBloodSugarStatisticsActivity) ((g7.h) this.f7547a.f7255a);
            if (num.intValue() < 10) {
                tRingBloodSugarStatisticsActivity.getClass();
                return;
            }
            tRingBloodSugarStatisticsActivity.I = 0;
            eh.b bVar = tRingBloodSugarStatisticsActivity.f7247z;
            f6.j jVar = (f6.j) bVar.getValue();
            TextView textView = jVar != null ? jVar.f13013q : null;
            if (textView != null) {
                textView.setText(tRingBloodSugarStatisticsActivity.getString(R$string.ring_begin_measure));
            }
            f6.j jVar2 = (f6.j) bVar.getValue();
            if (jVar2 != null) {
                jVar2.f13013q.setBackgroundResource(R$drawable.shape_block_text_button);
            }
            r rVar = (r) tRingBloodSugarStatisticsActivity.I0();
            rVar.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BloodSugarStatisticsPresenter", "开始同步血糖数据");
            o bleDataCallback = (o) rVar.e.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -112, new byte[]{5, 16, 16}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -112);
            }
        }
    }
}
