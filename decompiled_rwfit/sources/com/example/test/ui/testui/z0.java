package com.example.test.ui.testui;

import android.util.Log;
import com.example.test.R$string;
import com.example.test.presenter.main.w1;

/* loaded from: classes.dex */
public final class z0 implements a7.e, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8332a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TRingVibrationActivity f8333b;

    public /* synthetic */ z0(TRingVibrationActivity tRingVibrationActivity, int i3) {
        this.f8332a = i3;
        this.f8333b = tRingVibrationActivity;
    }

    @Override // a7.e
    public void B() {
        this.f8333b.finish();
    }

    @Override // a7.e
    public void u0() {
        this.f8333b.onBackPressed();
    }

    @Override // t6.a
    public void v(String data) {
        TRingVibrationActivity tRingVibrationActivity = this.f8333b;
        int i3 = this.f8332a;
        kotlin.jvm.internal.e.f(data, "data");
        switch (i3) {
            case 1:
                Log.e("qob", "selectSingleDialog onDataSelect ".concat(data));
                if (data.equals(tRingVibrationActivity.getString(R$string.str_ring_vibration_1))) {
                    tRingVibrationActivity.S0().setLevel(1);
                } else if (data.equals(tRingVibrationActivity.getString(R$string.str_ring_vibration_2))) {
                    tRingVibrationActivity.S0().setLevel(2);
                } else if (data.equals(tRingVibrationActivity.getString(R$string.str_ring_vibration_3))) {
                    tRingVibrationActivity.S0().setLevel(3);
                } else {
                    tRingVibrationActivity.S0().setLevel(0);
                }
                tRingVibrationActivity.R0();
                ((w1) tRingVibrationActivity.I0()).m(tRingVibrationActivity.S0());
                break;
            default:
                int i10 = TRingVibrationActivity.H;
                tRingVibrationActivity.S0().setCount(Integer.parseInt(data));
                ((w1) tRingVibrationActivity.I0()).m(tRingVibrationActivity.S0());
                tRingVibrationActivity.R0();
                break;
        }
    }
}
