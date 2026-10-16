package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.RingBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.StepChartData;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.m2;
import f6.z2;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingStepStatisticsActivity extends RingBaseActivity<com.example.test.presenter.main.a, m2> implements g7.a, View.OnClickListener {
    public TRingStepStatisticsActivity() {
        new ArrayList();
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.a(this);
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final View H0() {
        RelativeLayout relativeLayout = ((m2) this.f7249z.getValue()).f13124a;
        kotlin.jvm.internal.e.e(relativeLayout, "getRoot(...)");
        return relativeLayout;
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_stepstatistics, (ViewGroup) null, false);
        int i3 = R$id.fragment_container;
        if (((FragmentContainerView) he.a(i3, inflate)) != null) {
            return new m2((RelativeLayout) inflate);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void K0() {
        Log.e("qob", "TRingStepStatisticsActivity initData");
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void L0() {
    }

    @Override // g7.a
    public final void R(StepChartData stepChartData) {
        Log.d("tong", "stepChartData char size = " + stepChartData.getSteps().size());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            view.getId();
        }
    }

    @Override // com.example.test.ui.RingBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.e("qob", "TRingStepStatisticsActivity onDestroy");
        b0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            Log.e("qob", "TRingStepStatisticsActivity DEVICE_CONNECTED");
            b0();
            return;
        }
        if (status == 2) {
            Log.e("qob", "TRingStepStatisticsActivity DEVICE_CONNECTING");
            return;
        }
        if (status != 3) {
            if (status == 4) {
                b0();
                return;
            } else if (status != 5) {
                b0();
                return;
            } else {
                b0();
                return;
            }
        }
        Log.e("qob", "TRingStepStatisticsActivity DEVICE_BINDING");
        O0().a(R$string.str_binding);
        O0().setCancelable(false);
        O0().c(0);
        if (O0().isShowing()) {
            return;
        }
        O0().show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Log.e("qob", "TRingStepStatisticsActivity onResume ");
        Fragment v6 = C0().v(R$id.fragment_container);
        TRingActivityFragment tRingActivityFragment = v6 instanceof TRingActivityFragment ? (TRingActivityFragment) v6 : null;
        if (tRingActivityFragment != null) {
            Log.e("qob", "showToolbarBackItem");
            z2 z2Var = (z2) tRingActivityFragment.f7251b;
            if (z2Var != null) {
                z2Var.f13491l.setbarStatusIvVisiable(0);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        Log.e("qob", "TRingStepStatisticsActivity onStart");
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.e("qob", "TRingStepStatisticsActivity onStop");
        b2.b(this);
    }
}
