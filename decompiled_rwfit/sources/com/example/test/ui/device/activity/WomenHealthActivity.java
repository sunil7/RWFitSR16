package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.JLWomenHealthBean;
import com.example.blesdk.bean.function.WomenHealthBean;
import com.example.test.R$string;
import com.example.test.presenter.device.n1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import f6.y2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class WomenHealthActivity extends XXBaseActivity<n1, y2> implements f7.c0, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthActivity$womenHealthBean$2
        @Override // oh.a
        public final WomenHealthBean invoke() {
            return new WomenHealthBean();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(WomenHealthActivity.this);
            qVar.setOnDialogTimeSelectListener(new l0(WomenHealthActivity.this));
            return qVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthActivity$rangeDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 15;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 60) {
                    com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(WomenHealthActivity.this, arrayList);
                    lVar.setOnDialogDataListener(new e0(WomenHealthActivity.this, 3));
                    return lVar;
                }
                i3 = i10;
            }
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WomenHealthActivity$mensDaysDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            int i3 = 3;
            while (true) {
                int i10 = i3 + 1;
                arrayList.add(String.valueOf(i3));
                if (i10 > 15) {
                    com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(WomenHealthActivity.this, arrayList);
                    lVar.setOnDialogDataListener(new i0(WomenHealthActivity.this, 2));
                    return lVar;
                }
                i3 = i10;
            }
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new n1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((y2) this.f7247z.getValue()).f13463a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return y2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((n1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((y2) bVar.getValue()).e.setVisibility(8);
        ((y2) bVar.getValue()).f13468g.setVisibility(8);
        ((y2) bVar.getValue()).f13472k.setOnTitleListener(new l0(this));
        ((y2) bVar.getValue()).f13464b.setOnSwitchStatusChangListener(new y(this, 13));
        ((y2) bVar.getValue()).f13465c.setOnClickListener(this);
        ((y2) bVar.getValue()).f13469h.setOnClickListener(this);
        ((y2) bVar.getValue()).f13467f.setOnClickListener(this);
        ((y2) bVar.getValue()).f13470i.setOnClickListener(this);
        ((y2) bVar.getValue()).f13471j.setOnClickListener(this);
        S0();
    }

    @Override // f7.c0
    public final void N(JLWomenHealthBean womenHealthBean) {
        kotlin.jvm.internal.e.f(womenHealthBean, "womenHealthBean");
    }

    public final WomenHealthBean R0() {
        return (WomenHealthBean) this.E.getValue();
    }

    public final void S0() {
        String str;
        String str2;
        eh.b bVar = this.f7247z;
        ((y2) bVar.getValue()).f13464b.setItemOpen(R0().isOpen());
        ((y2) bVar.getValue()).f13466d.setVisibility(R0().isOpen() ? 0 : 8);
        ((y2) bVar.getValue()).f13469h.setHintStr(String.valueOf(R0().getRangeDays()));
        ((y2) bVar.getValue()).f13467f.setHintStr(String.valueOf(R0().getMensDays()));
        String str3 = null;
        if (R0().getLastDays() > 0) {
            ActionItemView actionItemView = ((y2) bVar.getValue()).f13465c;
            long lastDays = R0().getLastDays() * 1000;
            try {
                str2 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(lastDays));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(lastDays, " date translate error ", e.getMessage()));
                str2 = null;
            }
            actionItemView.setHintStr(str2 != null ? str2 : "");
        } else {
            ActionItemView actionItemView2 = ((y2) bVar.getValue()).f13465c;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis));
            } catch (Exception e10) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(currentTimeMillis, " date translate error ", e10.getMessage()));
                str = null;
            }
            actionItemView2.setHintStr(str != null ? str : "");
        }
        if (DateFormat.is24HourFormat(this)) {
            android.support.v4.media.session.e.B(new Object[]{Integer.valueOf(R0().getRemindHour()), Integer.valueOf(R0().getRemindMin())}, 2, Locale.ENGLISH, "%02d:%02d", ((y2) bVar.getValue()).f13471j);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, R0().getRemindHour());
        calendar.set(12, R0().getRemindMin());
        ActionItemView actionItemView3 = ((y2) bVar.getValue()).f13471j;
        Locale locale = Locale.ENGLISH;
        String str4 = calendar.get(9) == 1 ? "PM" : "AM";
        long timeInMillis = calendar.getTimeInMillis();
        try {
            str3 = new SimpleDateFormat("hh:mm", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
        } catch (Exception e11) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e11.getMessage()));
        }
        android.support.v4.media.session.e.B(new Object[]{str4, str3}, 2, locale, "%s %s", actionItemView3);
    }

    @Override // f7.c0
    public final void a() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.c0
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f2, code lost:
    
        if (r0 == 0) goto L44;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r6) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.WomenHealthActivity.onClick(android.view.View):void");
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDateEvent(EventBusBeans.DateValueEvent dateValueEvent) {
        kotlin.jvm.internal.e.f(dateValueEvent, "dateValueEvent");
        R0().setLastDays(dateValueEvent.getDate().getTime() / 1000);
        S0();
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onRemindEvent(EventBusBeans.WomenHealthRemindEvent womenHealthRemindEvent) {
        kotlin.jvm.internal.e.f(womenHealthRemindEvent, "womenHealthRemindEvent");
        R0().setMensOpen(womenHealthRemindEvent.isMensRemind());
        R0().setOvulOpen(womenHealthRemindEvent.isOvulRemid());
        R0().setOvulHighOpen(womenHealthRemindEvent.isOvulHighRemind());
        R0().setOvulOverOpen(womenHealthRemindEvent.isOvulOverRemind());
        S0();
    }

    @Override // f7.c0
    public final void t0(WomenHealthBean womenHealthBean) {
        kotlin.jvm.internal.e.f(womenHealthBean, "womenHealthBean");
        R0().setOpen(womenHealthBean.isOpen());
        R0().setType(womenHealthBean.getType());
        R0().setMensOpen(womenHealthBean.isMensOpen());
        R0().setOvulOpen(womenHealthBean.isOvulOpen());
        R0().setOvulHighOpen(womenHealthBean.isOvulHighOpen());
        R0().setOvulOverOpen(womenHealthBean.isOvulOverOpen());
        R0().setRangeDays(womenHealthBean.getRangeDays());
        R0().setMensDays(womenHealthBean.getMensDays());
        R0().setLastDays(womenHealthBean.getLastDays());
        R0().setRemindHour(womenHealthBean.getRemindHour());
        R0().setRemindMin(womenHealthBean.getRemindMin());
        S0();
    }
}
