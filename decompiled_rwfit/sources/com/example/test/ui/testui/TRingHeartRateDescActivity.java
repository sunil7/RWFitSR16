package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.HrChartData;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import kotlin.NotImplementedError;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingHeartRateDescActivity extends XXBaseActivity<com.example.test.presenter.main.u0, f6.j0> implements g7.o, View.OnClickListener {
    @Override // g7.o
    public final void F(HrChartData hrChartData) {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.u0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.j0) this.f7247z.getValue()).f13014a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_heartratedesc, (ViewGroup) null, false);
        int i3 = R$id.ll_hr_desc;
        if (((LinearLayout) he.a(i3, inflate)) != null) {
            i3 = R$id.nsv_data;
            if (((NestedScrollView) he.a(i3, inflate)) != null) {
                i3 = R$id.toolbar;
                TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                if (tRingToolBarView != null) {
                    i3 = R$id.tv_hrdesc_title;
                    if (((TextView) he.a(i3, inflate)) != null) {
                        return new f6.j0((ConstraintLayout) inflate, tRingToolBarView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        f6.j0 j0Var = (f6.j0) bVar.getValue();
        if (j0Var != null) {
            TRingToolBarView tRingToolBarView = j0Var.f13015b;
            String string = getString(R$string.ring_hr_readme_title);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            tRingToolBarView.setBarTitle(string);
        }
        f6.j0 j0Var2 = (f6.j0) bVar.getValue();
        if (j0Var2 != null) {
            j0Var2.f13015b.setOnViewChildListener(new a1(this, 5));
        }
    }

    @Override // g7.o
    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
    }

    @Override // g7.o
    public final void e() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.o
    public final void f(int i3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            view.getId();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            Log.e("qob", "DeviceScanFragment DEVICE_CONNECTED");
            b0();
            return;
        }
        if (status == 2) {
            Log.e("qob", "DeviceScanFragment DEVICE_CONNECTING");
            return;
        }
        if (status == 3) {
            Log.e("qob", "DeviceScanFragment DEVICE_BINDING");
            Q0(R$string.str_binding);
        } else if (status == 4) {
            b0();
        } else if (status != 5) {
            b0();
        } else {
            b0();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        b2.b(this);
    }
}
