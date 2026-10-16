package com.example.test.presenter.main;

import android.util.Log;
import android.widget.TextView;
import com.example.test.R$drawable;
import com.example.test.R$string;
import com.example.test.ui.testui.TRingBloodPressureStatisticsActivity;

/* loaded from: classes.dex */
public final class m implements w5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f7533a;

    public m(n nVar) {
        this.f7533a = nVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "WearHandCallback errorCode "));
        Log.d("tong", "start failed");
    }

    @Override // u5.g
    public final void c() {
        Log.d("tong", "start test");
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        Log.d("tong", "start onResult data = " + num);
        if (num != null) {
            TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity = (TRingBloodPressureStatisticsActivity) ((g7.g) this.f7533a.f7255a);
            if (num.intValue() < 10) {
                tRingBloodPressureStatisticsActivity.getClass();
                return;
            }
            tRingBloodPressureStatisticsActivity.I = 0;
            eh.b bVar = tRingBloodPressureStatisticsActivity.f7247z;
            f6.i iVar = (f6.i) bVar.getValue();
            TextView textView = iVar != null ? iVar.f12972p : null;
            if (textView != null) {
                textView.setText(tRingBloodPressureStatisticsActivity.getString(R$string.ring_begin_measure));
            }
            f6.i iVar2 = (f6.i) bVar.getValue();
            if (iVar2 != null) {
                iVar2.f12972p.setBackgroundResource(R$drawable.shape_block_text_button);
            }
            n nVar = (n) tRingBloodPressureStatisticsActivity.I0();
            nVar.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "BloodOxygenPresenter", "开始同步血压数据");
            l bleDataCallback = (l) nVar.f7538d.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -64, new byte[]{5, 4, 16}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -64);
            }
        }
    }
}
