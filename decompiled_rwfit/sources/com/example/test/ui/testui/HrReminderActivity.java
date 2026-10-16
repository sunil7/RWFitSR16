package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.example.blesdk.bean.function.HrReminderBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class HrReminderActivity extends XXBaseActivity<com.example.test.presenter.device.m0, f6.m0> implements f7.n, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int G = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HrReminderActivity$selectSingleDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 60; i3 < 201; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(HrReminderActivity.this, arrayList);
            lVar.setOnDialogDataListener(new e(HrReminderActivity.this));
            return lVar;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HrReminderActivity$hrReminderBean$2
        @Override // oh.a
        public final HrReminderBean invoke() {
            return new HrReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.m0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.m0) this.f7247z.getValue()).f13114a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_hr_reminder, (ViewGroup) null, false);
        int i3 = R$id.ivNext;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.reminder_switch;
            SwitchCompat switchCompat = (SwitchCompat) he.a(i3, inflate);
            if (switchCompat != null) {
                i3 = R$id.rl_health_bloodsugar;
                if (((RelativeLayout) he.a(i3, inflate)) != null) {
                    i3 = R$id.rl_health_heart;
                    RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                    if (relativeLayout != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            i3 = R$id.tv_health_bloodsugar_title;
                            if (((TextView) he.a(i3, inflate)) != null) {
                                i3 = R$id.tv_health_bloodsugar_value;
                                if (((TextView) he.a(i3, inflate)) != null) {
                                    i3 = R$id.tv_health_hr_value;
                                    TextView textView = (TextView) he.a(i3, inflate);
                                    if (textView != null) {
                                        return new f6.m0((LinearLayout) inflate, switchCompat, relativeLayout, titleView, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.m0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        TitleView titleView = ((f6.m0) bVar.getValue()).f13117d;
        String string = getString(R$string.str_heart_rate_reminder_title);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        titleView.setTitle(string);
        ((f6.m0) bVar.getValue()).f13117d.setOnTitleListener(new e(this));
        ((f6.m0) bVar.getValue()).f13116c.setOnClickListener(this);
        R0();
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        ((f6.m0) bVar.getValue()).e.setText(S0().getRemindValue() + " bpm");
        ((f6.m0) bVar.getValue()).f13115b.setOnCheckedChangeListener(null);
        ((f6.m0) bVar.getValue()).f13115b.setChecked(S0().isOpen());
        ((f6.m0) bVar.getValue()).f13115b.setOnCheckedChangeListener(this);
    }

    public final HrReminderBean S0() {
        return (HrReminderBean) this.F.getValue();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton p02, boolean z5) {
        kotlin.jvm.internal.e.f(p02, "p0");
        if (p02.equals(((f6.m0) this.f7247z.getValue()).f13115b)) {
            S0().setOpen(z5);
            Log.e("qob", "心率提醒 开关改变" + z5);
            ((com.example.test.presenter.device.m0) I0()).m(S0());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.rl_health_heart;
        if (valueOf != null && valueOf.intValue() == i3) {
            Log.e("qob", " isOpen " + S0().isOpen() + " remindValue " + S0().getRemindValue());
            int remindValue = S0().getRemindValue();
            if (remindValue < 60) {
                remindValue = 60;
            } else if (remindValue > 200) {
                remindValue = 200;
            }
            eh.b bVar = this.E;
            ((com.example.test.ui.dialog.l) bVar.getValue()).a(remindValue - 60);
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        R0();
    }
}
