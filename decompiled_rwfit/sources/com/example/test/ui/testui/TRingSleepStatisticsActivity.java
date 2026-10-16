package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.RingBaseActivity;
import com.example.test.ui.model.chart.chart.SleepChartData;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.o3;
import f6.z1;
import java.util.List;
import kotlin.NotImplementedError;

/* loaded from: classes.dex */
public final class TRingSleepStatisticsActivity extends RingBaseActivity<com.example.test.presenter.main.c1, z1> implements g7.v, View.OnClickListener {
    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.c1(this);
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final View H0() {
        RelativeLayout relativeLayout = ((z1) this.f7249z.getValue()).f13480a;
        kotlin.jvm.internal.e.e(relativeLayout, "getRoot(...)");
        return relativeLayout;
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_sleeptatistics, (ViewGroup) null, false);
        int i3 = R$id.fragment_container;
        if (((FragmentContainerView) he.a(i3, inflate)) != null) {
            return new z1((RelativeLayout) inflate);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void L0() {
    }

    @Override // g7.v
    public final void Y(SleepChartData sleepChartData) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.v
    public final void c0(List list) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
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
        Log.e("qob", "TRingSleepStatisticsActivity onDestroy");
        b0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        o3 o3Var;
        super.onResume();
        Log.e("qob", "TRingSleepStatisticsActivity onResume");
        Fragment v6 = C0().v(R$id.fragment_container);
        TRingSleepFragment tRingSleepFragment = v6 instanceof TRingSleepFragment ? (TRingSleepFragment) v6 : null;
        if (tRingSleepFragment == null || (o3Var = (o3) tRingSleepFragment.f7251b) == null) {
            return;
        }
        o3Var.f13197p.setbarStatusIvVisiable(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        Log.e("qob", "TRingSleepStatisticsActivity onStart");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.e("qob", "TRingSleepStatisticsActivity onStop");
    }
}
