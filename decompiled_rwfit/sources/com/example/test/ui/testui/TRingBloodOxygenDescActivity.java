package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BoChartData;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingBloodOxygenDescActivity extends XXBaseActivity<com.example.test.presenter.main.k, f6.g> implements g7.f, View.OnClickListener {
    public static int F;
    public final String E = "TRingBloodOxygenDescAct";

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.k(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.g) this.f7247z.getValue()).f12893a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_bloodoxygendesc, (ViewGroup) null, false);
        int i3 = R$id.nsv_data;
        if (((NestedScrollView) he.a(i3, inflate)) != null) {
            i3 = R$id.toolbar;
            TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
            if (tRingToolBarView != null) {
                i3 = R$id.tv_content;
                TextView textView = (TextView) he.a(i3, inflate);
                if (textView != null) {
                    i3 = R$id.tv_title;
                    TextView textView2 = (TextView) he.a(i3, inflate);
                    if (textView2 != null) {
                        return new f6.g((ConstraintLayout) inflate, tRingToolBarView, textView, textView2);
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
        TextView textView;
        int intExtra = getIntent().getIntExtra("type", 0);
        F = intExtra;
        Log.d(this.E, com.google.android.gms.internal.mlkit_vision_barcode.l0.j(intExtra, "heartType = "));
        int i3 = F;
        eh.b bVar = this.f7247z;
        if (i3 == 1) {
            f6.g gVar = (f6.g) bVar.getValue();
            TextView textView2 = gVar != null ? gVar.f12895c : null;
            if (textView2 != null) {
                textView2.setText(getString(R$string.ring_str_hrv_description));
            }
            f6.g gVar2 = (f6.g) bVar.getValue();
            textView = gVar2 != null ? gVar2.f12896d : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
            f6.g gVar3 = (f6.g) bVar.getValue();
            if (gVar3 != null) {
                TRingToolBarView tRingToolBarView = gVar3.f12894b;
                String string = getString(R$string.ring_hrv_readme_title);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                tRingToolBarView.setBarTitle(string);
            }
        } else if (i3 == 3) {
            f6.g gVar4 = (f6.g) bVar.getValue();
            textView = gVar4 != null ? gVar4.f12895c : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_str_stress_description));
            }
            f6.g gVar5 = (f6.g) bVar.getValue();
            if (gVar5 != null) {
                TRingToolBarView tRingToolBarView2 = gVar5.f12894b;
                String string2 = getString(R$string.ring_stress_readme_title);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                tRingToolBarView2.setBarTitle(string2);
            }
        } else if (i3 == 4) {
            f6.g gVar6 = (f6.g) bVar.getValue();
            textView = gVar6 != null ? gVar6.f12895c : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_str_bloodsugar_description));
            }
            f6.g gVar7 = (f6.g) bVar.getValue();
            if (gVar7 != null) {
                TRingToolBarView tRingToolBarView3 = gVar7.f12894b;
                String string3 = getString(R$string.ring_bloodsugar_readme_title);
                kotlin.jvm.internal.e.e(string3, "getString(...)");
                tRingToolBarView3.setBarTitle(string3);
            }
        } else if (i3 == 5) {
            f6.g gVar8 = (f6.g) bVar.getValue();
            textView = gVar8 != null ? gVar8.f12895c : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_str_muslimcount_description));
            }
            f6.g gVar9 = (f6.g) bVar.getValue();
            if (gVar9 != null) {
                TRingToolBarView tRingToolBarView4 = gVar9.f12894b;
                String string4 = getString(R$string.ring_muslimcount_detail_title);
                kotlin.jvm.internal.e.e(string4, "getString(...)");
                tRingToolBarView4.setBarTitle(string4);
            }
        } else if (i3 == 6) {
            f6.g gVar10 = (f6.g) bVar.getValue();
            textView = gVar10 != null ? gVar10.f12895c : null;
            if (textView != null) {
                textView.setText(getString(R$string.ring_str_bp_description));
            }
            f6.g gVar11 = (f6.g) bVar.getValue();
            if (gVar11 != null) {
                TRingToolBarView tRingToolBarView5 = gVar11.f12894b;
                String string5 = getString(R$string.ring_bp_readme_title);
                kotlin.jvm.internal.e.e(string5, "getString(...)");
                tRingToolBarView5.setBarTitle(string5);
            }
        } else {
            f6.g gVar12 = (f6.g) bVar.getValue();
            if (gVar12 != null) {
                TRingToolBarView tRingToolBarView6 = gVar12.f12894b;
                String string6 = getString(R$string.ring_bo_readme_title);
                kotlin.jvm.internal.e.e(string6, "getString(...)");
                tRingToolBarView6.setBarTitle(string6);
            }
        }
        f6.g gVar13 = (f6.g) bVar.getValue();
        if (gVar13 != null) {
            gVar13.f12894b.setOnViewChildListener(new a1(this, 1));
        }
    }

    @Override // g7.f
    public final void a() {
    }

    @Override // g7.f
    public final void b() {
    }

    @Override // g7.f
    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
    }

    @Override // g7.f
    public final void e() {
    }

    @Override // g7.f
    public final void f(int i3) {
    }

    @Override // g7.f
    public final void g0(BoChartData boChartData) {
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
        Log.e("qob", "DeviceScanFragment onDestroy");
        b0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            Log.e("qob", "DeviceScanFragment DEVICE_CONNECTED");
            b0();
            Log.d("tong", "bluedevice link success");
        } else {
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
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Log.e("qob", "deviceScan onResume ");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        Log.e("qob", "deviceScan onStart");
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.e("qob", "deviceScan onStop");
        b2.b(this);
    }
}
