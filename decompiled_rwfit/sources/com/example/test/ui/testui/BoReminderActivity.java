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
import com.example.blesdk.bean.function.BoReminderBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class BoReminderActivity extends XXBaseActivity<com.example.test.presenter.device.i, f6.l> implements f7.b, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int G = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.BoReminderActivity$selectSingleDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 90; i3 < 100; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(BoReminderActivity.this, arrayList);
            lVar.setOnDialogDataListener(new a(BoReminderActivity.this));
            return lVar;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.BoReminderActivity$boReminderBean$2
        @Override // oh.a
        public final BoReminderBean invoke() {
            return new BoReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.i(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.l) this.f7247z.getValue()).f13078a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_bo_reminder, (ViewGroup) null, false);
        int i3 = R$id.ivNext;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.reminder_switch;
            SwitchCompat switchCompat = (SwitchCompat) he.a(i3, inflate);
            if (switchCompat != null) {
                i3 = R$id.rl_bo;
                if (((RelativeLayout) he.a(i3, inflate)) != null) {
                    i3 = R$id.rl_health_heart;
                    RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                    if (relativeLayout != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            i3 = R$id.tv_bo_remark;
                            if (((TextView) he.a(i3, inflate)) != null) {
                                i3 = R$id.tv_bo_title;
                                if (((TextView) he.a(i3, inflate)) != null) {
                                    i3 = R$id.tv_bo_value;
                                    TextView textView = (TextView) he.a(i3, inflate);
                                    if (textView != null) {
                                        return new f6.l((LinearLayout) inflate, switchCompat, relativeLayout, titleView, textView);
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
        ((com.example.test.presenter.device.i) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.l) bVar.getValue()).f13081d.setOnTitleListener(new a(this));
        ((f6.l) bVar.getValue()).f13080c.setOnClickListener(this);
        R0();
    }

    public final void R0() {
        eh.b bVar = this.f7247z;
        ((f6.l) bVar.getValue()).e.setText(S0().getRemindValue() + " %");
        ((f6.l) bVar.getValue()).f13079b.setOnCheckedChangeListener(null);
        ((f6.l) bVar.getValue()).f13079b.setChecked(S0().isOpen());
        ((f6.l) bVar.getValue()).f13079b.setOnCheckedChangeListener(this);
    }

    public final BoReminderBean S0() {
        return (BoReminderBean) this.F.getValue();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton p02, boolean z5) {
        kotlin.jvm.internal.e.f(p02, "p0");
        if (p02.equals(((f6.l) this.f7247z.getValue()).f13079b)) {
            S0().setOpen(z5);
            Log.e("qob", "血氧提醒 开关改变" + z5);
            ((com.example.test.presenter.device.i) I0()).m(S0());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.rl_health_heart;
        if (valueOf != null && valueOf.intValue() == i3) {
            Log.e("qob", " isOpen " + S0().isOpen() + " remindValue " + S0().getRemindValue());
            int remindValue = S0().getRemindValue();
            if (remindValue < 90) {
                remindValue = 90;
            } else if (remindValue > 99) {
                remindValue = 99;
            }
            eh.b bVar = this.E;
            ((com.example.test.ui.dialog.l) bVar.getValue()).a(remindValue - 90);
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        R0();
    }
}
