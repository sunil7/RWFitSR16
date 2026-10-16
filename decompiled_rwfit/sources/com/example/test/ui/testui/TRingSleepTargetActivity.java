package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.amap.api.services.core.AMapException;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BoChartData;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.od;
import f6.y1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.NotImplementedError;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingSleepTargetActivity extends XXBaseActivity<com.example.test.presenter.main.k, y1> implements g7.f, View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public final String E = "TRingSleepTargetActivit";
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSleepTargetActivity$sleepOptions$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 300;
            int a3 = od.a(300, AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, 30);
            if (300 <= a3) {
                while (true) {
                    int i10 = i3 / 60;
                    int i11 = i3 % 60;
                    if (i11 <= 0) {
                        arrayList.add(i10 + "H");
                    } else {
                        arrayList.add(i10 + "H" + i11 + "M");
                    }
                    if (i3 == a3) {
                        break;
                    }
                    i3 += 30;
                }
            }
            return arrayList;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSleepTargetActivity$sleeptimeSelectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.p invoke() {
            TRingSleepTargetActivity tRingSleepTargetActivity = TRingSleepTargetActivity.this;
            int i3 = TRingSleepTargetActivity.H;
            com.example.test.ui.dialog.p pVar = new com.example.test.ui.dialog.p(tRingSleepTargetActivity, (List) tRingSleepTargetActivity.F.getValue());
            pVar.setOnDialogDataListener(new t0(TRingSleepTargetActivity.this));
            return pVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.k(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((y1) this.f7247z.getValue()).f13460a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_sleeptarget, (ViewGroup) null, false);
        int i3 = R$id.nsv_data;
        if (((NestedScrollView) he.a(i3, inflate)) != null) {
            i3 = R$id.sleeptargetAv;
            ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
            if (actionItemView != null) {
                i3 = R$id.toolbar;
                TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                if (tRingToolBarView != null) {
                    return new y1((ConstraintLayout) inflate, actionItemView, tRingToolBarView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        Log.e("qob", "DeviceScanFragment initData");
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.A()) : null;
        Log.d(this.E, "distnum = " + valueOf);
        Integer valueOf2 = valueOf != null ? Integer.valueOf(valueOf.intValue() / 60) : null;
        Integer valueOf3 = valueOf != null ? Integer.valueOf(valueOf.intValue() % 60) : null;
        if (valueOf3 != null) {
            if (valueOf3.intValue() <= 0) {
                android.support.v4.media.session.e.B(new Object[]{valueOf2, "H"}, 2, Locale.ENGLISH, "%d%s", ((y1) this.f7247z.getValue()).f13461b);
            } else {
                android.support.v4.media.session.e.B(new Object[]{valueOf2, "H", valueOf3, "M"}, 4, Locale.ENGLISH, "%d%s%d%s", ((y1) this.f7247z.getValue()).f13461b);
            }
        }
        y1 y1Var = (y1) this.f7247z.getValue();
        if (y1Var != null) {
            y1Var.f13461b.setOnClickListener(this);
        }
        y1 y1Var2 = (y1) this.f7247z.getValue();
        if (y1Var2 != null) {
            y1Var2.f13462c.setOnViewChildListener(new t0(this));
        }
    }

    @Override // g7.f
    public final void a() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.f
    public final void b() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.f
    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.f
    public final void e() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.f
    public final void f(int i3) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // g7.f
    public final void g0(BoChartData boChartData) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.sleeptargetAv;
        if (valueOf != null && valueOf.intValue() == i3) {
            com.example.test.ui.dialog.p pVar = (com.example.test.ui.dialog.p) this.G.getValue();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            Integer valueOf2 = kVar != null ? Integer.valueOf(kVar.A()) : null;
            Integer valueOf3 = valueOf2 != null ? Integer.valueOf(valueOf2.intValue() / 60) : null;
            Integer valueOf4 = valueOf2 != null ? Integer.valueOf(valueOf2.intValue() % 60) : null;
            String format = valueOf4 != null ? valueOf4.intValue() <= 0 ? String.format(Locale.ENGLISH, "%d%s", Arrays.copyOf(new Object[]{valueOf3, "H"}, 2)) : String.format(Locale.ENGLISH, "%d%s%d%s", Arrays.copyOf(new Object[]{valueOf3, "H", valueOf4, "M"}, 4)) : null;
            int size = ((List) this.F.getValue()).size();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                if (((String) ((List) this.F.getValue()).get(i11)).equals(format)) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            pVar.a(i10);
            ((com.example.test.ui.dialog.p) this.G.getValue()).show();
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
