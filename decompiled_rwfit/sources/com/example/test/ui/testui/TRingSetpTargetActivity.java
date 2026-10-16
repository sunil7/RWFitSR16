package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.database.table.User;
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
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import f6.n2;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingSetpTargetActivity extends XXBaseActivity<com.example.test.presenter.main.k, n2> implements g7.f, View.OnClickListener {
    public static final /* synthetic */ int L = 0;
    public final String E = "TRingSetpTargetActivity";
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSetpTargetActivity$stepOptions$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 5000;
            int a3 = od.a(5000, 50000, 1000);
            if (5000 <= a3) {
                while (true) {
                    arrayList.add(i3 + TRingSetpTargetActivity.this.getString(R$string.str_unit_step));
                    if (i3 == a3) {
                        break;
                    }
                    i3 += 1000;
                }
            }
            return arrayList;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSetpTargetActivity$stepNumSelectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.p invoke() {
            TRingSetpTargetActivity tRingSetpTargetActivity = TRingSetpTargetActivity.this;
            int i3 = TRingSetpTargetActivity.L;
            com.example.test.ui.dialog.p pVar = new com.example.test.ui.dialog.p(tRingSetpTargetActivity, (List) tRingSetpTargetActivity.F.getValue());
            pVar.setOnDialogDataListener(new o0(TRingSetpTargetActivity.this, 3));
            return pVar;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSetpTargetActivity$caluOptions$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 100;
            int a3 = od.a(100, 1000, 100);
            if (100 <= a3) {
                while (true) {
                    arrayList.add(i3 + "KCAL");
                    if (i3 == a3) {
                        break;
                    }
                    i3 += 100;
                }
            }
            return arrayList;
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSetpTargetActivity$caluNumSelectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.p invoke() {
            TRingSetpTargetActivity tRingSetpTargetActivity = TRingSetpTargetActivity.this;
            int i3 = TRingSetpTargetActivity.L;
            com.example.test.ui.dialog.p pVar = new com.example.test.ui.dialog.p(tRingSetpTargetActivity, (List) tRingSetpTargetActivity.H.getValue());
            pVar.setOnDialogDataListener(new o0(TRingSetpTargetActivity.this, 0));
            return pVar;
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSetpTargetActivity$distOptions$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<String> invoke() {
            String string = TRingSetpTargetActivity.this.getString(R$string.str_km);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            User d5 = kVar != null ? kVar.d() : null;
            if (d5 != null) {
                TRingSetpTargetActivity tRingSetpTargetActivity = TRingSetpTargetActivity.this;
                if (d5.getMeterUnit() == 0) {
                    string = tRingSetpTargetActivity.getString(R$string.str_km);
                    kotlin.jvm.internal.e.e(string, "getString(...)");
                } else {
                    string = tRingSetpTargetActivity.getString(R$string.str_mile);
                    kotlin.jvm.internal.e.e(string, "getString(...)");
                }
            }
            ArrayList arrayList = new ArrayList();
            for (double d8 = 1.0d; d8 <= 10.0d; d8 += 0.5d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(d8);
                sb2.append((Object) string);
                arrayList.add(sb2.toString());
            }
            return arrayList;
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSetpTargetActivity$distNumSelectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.p invoke() {
            TRingSetpTargetActivity tRingSetpTargetActivity = TRingSetpTargetActivity.this;
            int i3 = TRingSetpTargetActivity.L;
            com.example.test.ui.dialog.p pVar = new com.example.test.ui.dialog.p(tRingSetpTargetActivity, (List) tRingSetpTargetActivity.J.getValue());
            pVar.setOnDialogDataListener(new o0(TRingSetpTargetActivity.this, 1));
            return pVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.k(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((n2) this.f7247z.getValue()).f13141a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_steptarget, (ViewGroup) null, false);
        int i3 = R$id.calutargetAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.disttargetAv;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.nsv_data;
                if (((NestedScrollView) he.a(i3, inflate)) != null) {
                    i3 = R$id.steptargetAv;
                    ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView3 != null) {
                        i3 = R$id.toolbar;
                        TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                        if (tRingToolBarView != null) {
                            return new n2((ConstraintLayout) inflate, actionItemView, actionItemView2, actionItemView3, tRingToolBarView);
                        }
                    }
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
        com.example.test.utils.k a3 = y1.a();
        Long valueOf = a3 != null ? Long.valueOf(a3.C()) : null;
        String str = this.E;
        Log.d(str, "stepnum = " + valueOf);
        com.example.test.utils.k a10 = y1.a();
        Integer valueOf2 = a10 != null ? Integer.valueOf(a10.f()) : null;
        Log.d(str, "calunum = " + valueOf2);
        com.example.test.utils.k a11 = y1.a();
        Float valueOf3 = a11 != null ? Float.valueOf(a11.o()) : null;
        Log.d(str, "distnum = " + valueOf3);
        com.example.test.utils.k a12 = y1.a();
        User d5 = a12 != null ? a12.d() : null;
        eh.b bVar = this.f7247z;
        if (d5 != null) {
            String string = d5.getMeterUnit() == 0 ? getString(R$string.str_km) : getString(R$string.str_mile);
            kotlin.jvm.internal.e.c(string);
            android.support.v4.media.session.e.B(new Object[]{valueOf3, string}, 2, Locale.ENGLISH, "%.1f%s", ((n2) bVar.getValue()).f13143c);
        }
        ActionItemView actionItemView = ((n2) bVar.getValue()).f13142b;
        Locale locale = Locale.ENGLISH;
        android.support.v4.media.session.e.B(new Object[]{valueOf2, "KCAL"}, 2, locale, "%d%s", actionItemView);
        android.support.v4.media.session.e.B(new Object[]{valueOf, getString(R$string.str_unit_step)}, 2, locale, "%d%s", ((n2) bVar.getValue()).f13144d);
        ((n2) bVar.getValue()).f13142b.setOnClickListener(this);
        ((n2) bVar.getValue()).f13143c.setOnClickListener(this);
        ((n2) bVar.getValue()).f13144d.setOnClickListener(this);
        n2 n2Var = (n2) bVar.getValue();
        if (n2Var != null) {
            n2Var.e.setOnViewChildListener(new o0(this, 2));
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
        Object valueOf;
        Integer valueOf2 = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.steptargetAv;
        int i10 = 0;
        if (valueOf2 != null && valueOf2.intValue() == i3) {
            com.example.test.ui.dialog.p pVar = (com.example.test.ui.dialog.p) this.G.getValue();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            valueOf = kVar != null ? Long.valueOf(kVar.C()) : null;
            int size = ((List) this.F.getValue()).size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                System.out.println(((List) this.F.getValue()).get(i11));
                if (kotlin.text.m.x((String) ((List) this.F.getValue()).get(i11), String.valueOf(valueOf), false)) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            pVar.a(i10);
            ((com.example.test.ui.dialog.p) this.G.getValue()).show();
            return;
        }
        int i12 = R$id.calutargetAv;
        if (valueOf2 != null && valueOf2.intValue() == i12) {
            com.example.test.ui.dialog.p pVar2 = (com.example.test.ui.dialog.p) this.I.getValue();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            valueOf = kVar2 != null ? Integer.valueOf(kVar2.f()) : null;
            int size2 = ((List) this.H.getValue()).size();
            int i13 = 0;
            while (true) {
                if (i13 >= size2) {
                    break;
                }
                if (kotlin.text.m.x((String) ((List) this.H.getValue()).get(i13), String.valueOf(valueOf), false)) {
                    i10 = i13;
                    break;
                }
                i13++;
            }
            pVar2.a(i10);
            ((com.example.test.ui.dialog.p) this.I.getValue()).show();
            return;
        }
        int i14 = R$id.disttargetAv;
        if (valueOf2 != null && valueOf2.intValue() == i14) {
            com.example.test.ui.dialog.p pVar3 = (com.example.test.ui.dialog.p) this.K.getValue();
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
            valueOf = kVar3 != null ? Float.valueOf(kVar3.o()) : null;
            int size3 = ((List) this.J.getValue()).size();
            int i15 = 0;
            while (true) {
                if (i15 >= size3) {
                    break;
                }
                if (kotlin.text.m.x((String) ((List) this.J.getValue()).get(i15), String.valueOf(valueOf), false)) {
                    i10 = i15;
                    break;
                }
                i15++;
            }
            pVar3.a(i10);
            ((com.example.test.ui.dialog.p) this.K.getValue()).show();
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
            b0();
            return;
        }
        if (status != 2) {
            if (status == 3) {
                Q0(R$string.str_binding);
                return;
            }
            if (status == 4) {
                b0();
            } else if (status != 5) {
                b0();
            } else {
                b0();
            }
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
