package com.example.test.ui.device.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.SedentaryReminderBean;
import com.example.test.R$string;
import com.example.test.presenter.device.p0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.model.RemindModel;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import f6.q0;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class LongSitJLActivity extends XXBaseActivity<p0, q0> implements f7.p, View.OnClickListener {
    public static final /* synthetic */ int J = 0;
    public boolean E;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.LongSitJLActivity$remindDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.d invoke() {
            ArrayList arrayList = new ArrayList();
            LongSitJLActivity longSitJLActivity = LongSitJLActivity.this;
            int i3 = LongSitJLActivity.J;
            int size = ((List) longSitJLActivity.G.getValue()).size();
            LongSitJLActivity longSitJLActivity2 = LongSitJLActivity.this;
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(((RemindModel) ((List) longSitJLActivity2.G.getValue()).get(i10)).getShowStr());
            }
            LongSitJLActivity longSitJLActivity3 = LongSitJLActivity.this;
            com.example.test.ui.dialog.d dVar = new com.example.test.ui.dialog.d(longSitJLActivity3, arrayList, longSitJLActivity3.S0().getAdvanceIndex());
            dVar.setOnOptionSelectListener(new p(LongSitJLActivity.this));
            return dVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.LongSitJLActivity$remindData$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<RemindModel> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RemindModel(0, LongSitJLActivity.this.getString(R$string.str_remind_duration_30_minutes), 30));
            arrayList.add(new RemindModel(1, LongSitJLActivity.this.getString(R$string.str_remind_duration_1_hour), 60));
            arrayList.add(new RemindModel(2, LongSitJLActivity.this.getString(R$string.str_remind_duration_2_hour), 120));
            arrayList.add(new RemindModel(3, LongSitJLActivity.this.getString(R$string.str_remind_duration_3_hour), 180));
            arrayList.add(new RemindModel(4, LongSitJLActivity.this.getString(R$string.str_remind_duration_4_hour), 240));
            return arrayList;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.LongSitJLActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(LongSitJLActivity.this);
            qVar.setOnDialogTimeSelectListener(new y2.f(LongSitJLActivity.this, 21));
            return qVar;
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.LongSitJLActivity$reminderBean$2
        @Override // oh.a
        public final SedentaryReminderBean invoke() {
            return new SedentaryReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new p0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((q0) this.f7247z.getValue()).f13249a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return q0.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((p0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((q0) bVar.getValue()).f13253f.setOnTitleListener(new a2.d(this, 21));
        ((q0) bVar.getValue()).f13250b.setOnClickListener(this);
        ((q0) bVar.getValue()).f13254g.setOnClickListener(this);
        ((q0) bVar.getValue()).e.setOnClickListener(this);
        ((q0) bVar.getValue()).f13251c.setOnClickListener(this);
        ((q0) bVar.getValue()).f13252d.setOnSwitchStatusChangListener(new p(this));
        R0();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R0() {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.LongSitJLActivity.R0():void");
    }

    public final SedentaryReminderBean S0() {
        return (SedentaryReminderBean) this.I.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.H.getValue();
    }

    @Override // f7.p
    public final void g() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.p
    public final void h() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.p
    public final void n(SedentaryReminderBean sedentaryReminderBean) {
        kotlin.jvm.internal.e.f(sedentaryReminderBean, "sedentaryReminderBean");
        S0().setOpen(sedentaryReminderBean.isOpen());
        S0().setRemindDuration(sedentaryReminderBean.getRemindDuration());
        S0().setRepeatModel(sedentaryReminderBean.getRepeatModel());
        S0().setStartHour(sedentaryReminderBean.getStartHour());
        S0().setStartMin(sedentaryReminderBean.getStartMin());
        S0().setEndHour(sedentaryReminderBean.getEndHour());
        S0().setEndMin(sedentaryReminderBean.getEndMin());
        int remindDuration = sedentaryReminderBean.getRemindDuration();
        if (remindDuration == 30) {
            S0().setAdvanceIndex(0);
        } else if (remindDuration == 60) {
            S0().setAdvanceIndex(1);
        } else if (remindDuration == 120) {
            S0().setAdvanceIndex(2);
        } else if (remindDuration == 180) {
            S0().setAdvanceIndex(3);
        } else if (remindDuration != 240) {
            S0().setAdvanceIndex(1);
        } else {
            S0().setAdvanceIndex(4);
        }
        R0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
    
        if (r0 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0128, code lost:
    
        if (r0 == 0) goto L53;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r8) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.LongSitJLActivity.onClick(android.view.View):void");
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onOptionEvent(EventBusBeans.OptionEvent optionEvent) {
        kotlin.jvm.internal.e.f(optionEvent, "optionEvent");
        S0().setRepeatModel(optionEvent.getSelectValue());
        R0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (T0().isShowing()) {
            T0().dismiss();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        R0();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSedentaryEvent(EventBusBeans.DeviceSedentaryEvent sedentaryEvent) {
        kotlin.jvm.internal.e.f(sedentaryEvent, "sedentaryEvent");
        SedentaryReminderBean sedentaryReminderBean = sedentaryEvent.getSedentaryReminderBean();
        if (sedentaryReminderBean != null) {
            n(sedentaryReminderBean);
        }
    }
}
