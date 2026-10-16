package com.example.test.ui.device.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.test.R$string;
import com.example.test.presenter.device.l1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.model.RemindModel;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import f6.w2;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class WashHandActivity extends XXBaseActivity<l1, w2> implements f7.k, View.OnClickListener {
    public static final /* synthetic */ int J = 0;
    public boolean G;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WashHandActivity$remindDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.d invoke() {
            ArrayList arrayList = new ArrayList();
            WashHandActivity washHandActivity = WashHandActivity.this;
            int i3 = WashHandActivity.J;
            int size = ((List) washHandActivity.F.getValue()).size();
            WashHandActivity washHandActivity2 = WashHandActivity.this;
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(((RemindModel) ((List) washHandActivity2.F.getValue()).get(i10)).getShowStr());
            }
            WashHandActivity washHandActivity3 = WashHandActivity.this;
            com.example.test.ui.dialog.d dVar = new com.example.test.ui.dialog.d(washHandActivity3, arrayList, washHandActivity3.S0().getAdvanceIndex());
            dVar.setOnOptionSelectListener(new k0(WashHandActivity.this));
            return dVar;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WashHandActivity$remindData$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<RemindModel> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RemindModel(0, WashHandActivity.this.getString(R$string.str_remind_duration_30_minutes), 30));
            arrayList.add(new RemindModel(1, WashHandActivity.this.getString(R$string.str_remind_duration_1_hour), 60));
            arrayList.add(new RemindModel(2, WashHandActivity.this.getString(R$string.str_remind_duration_2_hour), 120));
            arrayList.add(new RemindModel(3, WashHandActivity.this.getString(R$string.str_remind_duration_3_hour), 180));
            arrayList.add(new RemindModel(4, WashHandActivity.this.getString(R$string.str_remind_duration_4_hour), 240));
            return arrayList;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WashHandActivity$timeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.q invoke() {
            com.example.test.ui.dialog.q qVar = new com.example.test.ui.dialog.q(WashHandActivity.this);
            qVar.setOnDialogTimeSelectListener(new e0(WashHandActivity.this, 2));
            return qVar;
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.WashHandActivity$reminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new l1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((w2) this.f7247z.getValue()).f13422a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return w2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((l1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((w2) bVar.getValue()).e.setOnTitleListener(new i0(this, 1));
        ((w2) bVar.getValue()).f13423b.setOnClickListener(this);
        ((w2) bVar.getValue()).f13426f.setOnClickListener(this);
        ((w2) bVar.getValue()).f13425d.setOnClickListener(this);
        ((w2) bVar.getValue()).f13424c.setOnClickListener(this);
        ((w2) bVar.getValue()).f13427g.setOnSwitchStatusChangListener(new k0(this));
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
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.WashHandActivity.R0():void");
    }

    public final DrinkReminderBean S0() {
        return (DrinkReminderBean) this.I.getValue();
    }

    public final com.example.test.ui.dialog.q T0() {
        return (com.example.test.ui.dialog.q) this.H.getValue();
    }

    @Override // f7.k
    public final void a() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.k
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.k
    public final void c(DrinkReminderBean drinkReminderBean) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        S0().setOpen(drinkReminderBean.isOpen());
        S0().setRemindDuration(drinkReminderBean.getRemindDuration());
        S0().setRepeatModel(drinkReminderBean.getRepeatModel());
        S0().setStartHour(drinkReminderBean.getStartHour());
        S0().setStartMin(drinkReminderBean.getStartMin());
        S0().setEndHour(drinkReminderBean.getEndHour());
        S0().setEndMin(drinkReminderBean.getEndMin());
        int remindDuration = drinkReminderBean.getRemindDuration();
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

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
    
        if (r0 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0117, code lost:
    
        if (r0 == 0) goto L53;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r8) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.device.activity.WashHandActivity.onClick(android.view.View):void");
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
}
