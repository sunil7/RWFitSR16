package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.database.table.Devices;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingPCycleSettingsActivity extends XXBaseActivity<com.example.test.presenter.device.a, f6.b1> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingPCycleSettingsActivity$rangeDaysOptions$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 20;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 35) {
                    return arrayList;
                }
                i3 = i10;
            }
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingPCycleSettingsActivity$rangeDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            TRingPCycleSettingsActivity tRingPCycleSettingsActivity = TRingPCycleSettingsActivity.this;
            int i3 = TRingPCycleSettingsActivity.I;
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(tRingPCycleSettingsActivity, (List) tRingPCycleSettingsActivity.E.getValue());
            lVar.setOnDialogDataListener(new m0(TRingPCycleSettingsActivity.this));
            return lVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingPCycleSettingsActivity$mensDaysOptions$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 2;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 10) {
                    return arrayList;
                }
                i3 = i10;
            }
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingPCycleSettingsActivity$mensDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            TRingPCycleSettingsActivity tRingPCycleSettingsActivity = TRingPCycleSettingsActivity.this;
            int i3 = TRingPCycleSettingsActivity.I;
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(tRingPCycleSettingsActivity, (List) tRingPCycleSettingsActivity.G.getValue());
            lVar.setOnDialogDataListener(new l0(TRingPCycleSettingsActivity.this));
            return lVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.a(this, 2);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.b1) this.f7247z.getValue()).f12712a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_pcycle_settings, (ViewGroup) null, false);
        int i3 = R$id.last_mens_day;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.ll_action;
            if (((LinearLayout) he.a(i3, inflate)) != null) {
                i3 = R$id.menstrual_period;
                ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView2 != null) {
                    i3 = R$id.range_days;
                    ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView3 != null) {
                        i3 = R$id.toolbar;
                        TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                        if (tRingToolBarView != null) {
                            return new f6.b1((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, tRingToolBarView);
                        }
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
        b2.a(this);
        eh.b bVar = this.f7247z;
        f6.b1 b1Var = (f6.b1) bVar.getValue();
        if (b1Var != null) {
            b1Var.e.setOnViewChildListener(new a1(this, 6));
        }
        ((f6.b1) bVar.getValue()).f12713b.setOnClickListener(this);
        ((f6.b1) bVar.getValue()).f12715d.setOnClickListener(this);
        ((f6.b1) bVar.getValue()).f12714c.setOnClickListener(this);
        R0();
    }

    public final void R0() {
        com.example.test.utils.k a3 = y1.a();
        Integer valueOf = a3 != null ? Integer.valueOf(a3.t()) : null;
        com.example.test.utils.k a10 = y1.a();
        Integer valueOf2 = a10 != null ? Integer.valueOf(a10.u()) : null;
        com.example.test.utils.k a11 = y1.a();
        String s7 = a11 != null ? a11.s() : null;
        eh.b bVar = this.f7247z;
        ((f6.b1) bVar.getValue()).f12715d.setHintStr(String.valueOf(valueOf));
        ((f6.b1) bVar.getValue()).f12714c.setHintStr(String.valueOf(valueOf2));
        if (s7 != null) {
            ((f6.b1) bVar.getValue()).f12713b.setHintStr(s7);
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        ActionItemView actionItemView = ((f6.b1) bVar.getValue()).f12713b;
        String format = now.format(ofPattern);
        kotlin.jvm.internal.e.e(format, "format(...)");
        actionItemView.setHintStr(format);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x012c  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r7) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.TRingPCycleSettingsActivity.onClick(android.view.View):void");
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.time.LocalDateTime] */
    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDateEvent(EventBusBeans.DateValueEvent dateValueEvent) {
        kotlin.jvm.internal.e.f(dateValueEvent, "dateValueEvent");
        Log.e("tong", "sel date = " + dateValueEvent.getDate());
        ?? localDateTime = dateValueEvent.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        kotlin.jvm.internal.e.e(localDateTime, "toLocalDateTime(...)");
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            String format = localDateTime.format(ofPattern);
            kotlin.jvm.internal.e.e(format, "format(...)");
            Devices c9 = kVar.c();
            if (c9 != null) {
                kVar.M(format, c9.getUserId() + "menstrual_start_date");
            }
        }
        yh.d.b().e(new EventBusBeans.WomenHealthRemindSettingEvent());
        R0();
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }
}
