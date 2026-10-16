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
import com.example.blesdk.bean.function.DrinkReminderBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class HealthWatcherActivity extends XXBaseActivity<com.example.test.presenter.device.k0, f6.i0> implements f7.m, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int L = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HealthWatcherActivity$selectSingleDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("30");
            arrayList.add("60");
            arrayList.add(HealthWatcherActivity.this.getString(R$string.str_ring_screen_light_0));
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(HealthWatcherActivity.this, arrayList);
            lVar.setOnDialogDataListener(new d(HealthWatcherActivity.this));
            return lVar;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HealthWatcherActivity$drinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HealthWatcherActivity$oodrinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HealthWatcherActivity$hrvDrinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HealthWatcherActivity$stressDrinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HealthWatcherActivity$bloodsugarDrinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.HealthWatcherActivity$bloodPressureDrinkReminderBean$2
        @Override // oh.a
        public final DrinkReminderBean invoke() {
            return new DrinkReminderBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.k0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.i0) this.f7247z.getValue()).f12974a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_health_watcher, (ViewGroup) null, false);
        int i3 = R$id.ivNext;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.rl_health_bloodsugar;
            RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
            if (relativeLayout != null) {
                i3 = R$id.rl_health_bp;
                RelativeLayout relativeLayout2 = (RelativeLayout) he.a(i3, inflate);
                if (relativeLayout2 != null) {
                    i3 = R$id.rl_health_heart;
                    RelativeLayout relativeLayout3 = (RelativeLayout) he.a(i3, inflate);
                    if (relativeLayout3 != null) {
                        i3 = R$id.rl_health_hrv;
                        if (((RelativeLayout) he.a(i3, inflate)) != null) {
                            i3 = R$id.rl_health_oo;
                            if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                i3 = R$id.rl_health_stress;
                                RelativeLayout relativeLayout4 = (RelativeLayout) he.a(i3, inflate);
                                if (relativeLayout4 != null) {
                                    i3 = R$id.scBtn_bloodsugar;
                                    SwitchCompat switchCompat = (SwitchCompat) he.a(i3, inflate);
                                    if (switchCompat != null) {
                                        i3 = R$id.scBtn_bp;
                                        SwitchCompat switchCompat2 = (SwitchCompat) he.a(i3, inflate);
                                        if (switchCompat2 != null) {
                                            i3 = R$id.scBtn_hrv;
                                            SwitchCompat switchCompat3 = (SwitchCompat) he.a(i3, inflate);
                                            if (switchCompat3 != null) {
                                                i3 = R$id.scBtn_oo;
                                                SwitchCompat switchCompat4 = (SwitchCompat) he.a(i3, inflate);
                                                if (switchCompat4 != null) {
                                                    i3 = R$id.scBtn_stress;
                                                    SwitchCompat switchCompat5 = (SwitchCompat) he.a(i3, inflate);
                                                    if (switchCompat5 != null) {
                                                        i3 = R$id.titleView;
                                                        TitleView titleView = (TitleView) he.a(i3, inflate);
                                                        if (titleView != null) {
                                                            i3 = R$id.tv_health_bloodsugar_title;
                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                i3 = R$id.tv_health_bloodsugar_value;
                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                    i3 = R$id.tv_health_bp_title;
                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                        i3 = R$id.tv_health_bp_value;
                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                            i3 = R$id.tv_health_hr_value;
                                                                            TextView textView = (TextView) he.a(i3, inflate);
                                                                            if (textView != null) {
                                                                                i3 = R$id.tv_health_hrv_title;
                                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                                    i3 = R$id.tv_health_hrv_value;
                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                        i3 = R$id.tv_health_oo_title;
                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                            i3 = R$id.tv_health_oo_value;
                                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                i3 = R$id.tv_health_stress_title;
                                                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                    i3 = R$id.tv_health_stress_value;
                                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                        return new f6.i0((LinearLayout) inflate, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, switchCompat, switchCompat2, switchCompat3, switchCompat4, switchCompat5, titleView, textView);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
        ((com.example.test.presenter.device.k0) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        Object obj = com.example.test.utils.m.f8734b;
        boolean d5 = d2.a().d();
        eh.b bVar = this.f7247z;
        if (!d5) {
            ((f6.i0) bVar.getValue()).e.setVisibility(8);
        }
        if (!d2.a().b()) {
            ((f6.i0) bVar.getValue()).f12975b.setVisibility(8);
        }
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (!(supportMenuBean != null ? supportMenuBean.isBloodPress() : true)) {
            ((f6.i0) bVar.getValue()).f12976c.setVisibility(8);
        }
        TitleView titleView = ((f6.i0) bVar.getValue()).f12983k;
        String string = getString(R$string.ring_item_healthmonitor_title);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        titleView.setTitle(string);
        ((f6.i0) bVar.getValue()).f12983k.setOnTitleListener(new d(this));
        ((f6.i0) bVar.getValue()).f12977d.setOnClickListener(this);
        R0();
    }

    public final void R0() {
        boolean isOpen = U0().isOpen();
        eh.b bVar = this.f7247z;
        if (isOpen) {
            ((f6.i0) bVar.getValue()).f12984l.setText(U0().getRemindDuration() + " " + getString(R$string.str_mins));
        } else {
            ((f6.i0) bVar.getValue()).f12984l.setText(getString(R$string.str_ring_screen_light_0));
        }
        ((f6.i0) bVar.getValue()).f12981i.setOnCheckedChangeListener(null);
        ((f6.i0) bVar.getValue()).f12981i.setChecked(W0().isOpen());
        ((f6.i0) bVar.getValue()).f12981i.setOnCheckedChangeListener(this);
        ((f6.i0) bVar.getValue()).f12980h.setOnCheckedChangeListener(null);
        ((f6.i0) bVar.getValue()).f12980h.setChecked(V0().isOpen());
        ((f6.i0) bVar.getValue()).f12980h.setOnCheckedChangeListener(this);
        ((f6.i0) bVar.getValue()).f12982j.setOnCheckedChangeListener(null);
        ((f6.i0) bVar.getValue()).f12982j.setChecked(X0().isOpen());
        ((f6.i0) bVar.getValue()).f12982j.setOnCheckedChangeListener(this);
        ((f6.i0) bVar.getValue()).f12978f.setOnCheckedChangeListener(null);
        ((f6.i0) bVar.getValue()).f12978f.setChecked(T0().isOpen());
        ((f6.i0) bVar.getValue()).f12978f.setOnCheckedChangeListener(this);
        ((f6.i0) bVar.getValue()).f12979g.setOnCheckedChangeListener(null);
        ((f6.i0) bVar.getValue()).f12979g.setChecked(S0().isOpen());
        ((f6.i0) bVar.getValue()).f12979g.setOnCheckedChangeListener(this);
    }

    public final DrinkReminderBean S0() {
        return (DrinkReminderBean) this.K.getValue();
    }

    public final DrinkReminderBean T0() {
        return (DrinkReminderBean) this.J.getValue();
    }

    public final DrinkReminderBean U0() {
        return (DrinkReminderBean) this.F.getValue();
    }

    public final DrinkReminderBean V0() {
        return (DrinkReminderBean) this.H.getValue();
    }

    public final DrinkReminderBean W0() {
        return (DrinkReminderBean) this.G.getValue();
    }

    public final DrinkReminderBean X0() {
        return (DrinkReminderBean) this.I.getValue();
    }

    public final void Y0(DrinkReminderBean drinkReminderBean, int i3) {
        kotlin.jvm.internal.e.f(drinkReminderBean, "drinkReminderBean");
        if (i3 == 0) {
            U0().setOpen(drinkReminderBean.isOpen());
            U0().setRemindDuration(drinkReminderBean.getRemindDuration());
            U0().setRepeatModel(drinkReminderBean.getRepeatModel());
            U0().setStartHour(drinkReminderBean.getStartHour());
            U0().setStartMin(drinkReminderBean.getStartMin());
            U0().setEndHour(drinkReminderBean.getEndHour());
            U0().setEndMin(drinkReminderBean.getEndMin());
        } else if (i3 == 1) {
            W0().setOpen(drinkReminderBean.isOpen());
            W0().setRemindDuration(drinkReminderBean.getRemindDuration());
            W0().setRepeatModel(drinkReminderBean.getRepeatModel());
            W0().setStartHour(drinkReminderBean.getStartHour());
            W0().setStartMin(drinkReminderBean.getStartMin());
            W0().setEndHour(drinkReminderBean.getEndHour());
            W0().setEndMin(drinkReminderBean.getEndMin());
        } else if (i3 == 2) {
            V0().setOpen(drinkReminderBean.isOpen());
            V0().setRemindDuration(drinkReminderBean.getRemindDuration());
            V0().setRepeatModel(drinkReminderBean.getRepeatModel());
            V0().setStartHour(drinkReminderBean.getStartHour());
            V0().setStartMin(drinkReminderBean.getStartMin());
            V0().setEndHour(drinkReminderBean.getEndHour());
            V0().setEndMin(drinkReminderBean.getEndMin());
        } else if (i3 == 4) {
            T0().setOpen(drinkReminderBean.isOpen());
            T0().setRemindDuration(drinkReminderBean.getRemindDuration());
            T0().setRepeatModel(drinkReminderBean.getRepeatModel());
            T0().setStartHour(drinkReminderBean.getStartHour());
            T0().setStartMin(drinkReminderBean.getStartMin());
            T0().setEndHour(drinkReminderBean.getEndHour());
            T0().setEndMin(drinkReminderBean.getEndMin());
        } else if (i3 != 5) {
            X0().setOpen(drinkReminderBean.isOpen());
            X0().setRemindDuration(drinkReminderBean.getRemindDuration());
            X0().setRepeatModel(drinkReminderBean.getRepeatModel());
            X0().setStartHour(drinkReminderBean.getStartHour());
            X0().setStartMin(drinkReminderBean.getStartMin());
            X0().setEndHour(drinkReminderBean.getEndHour());
            X0().setEndMin(drinkReminderBean.getEndMin());
        } else {
            S0().setOpen(drinkReminderBean.isOpen());
            S0().setRemindDuration(drinkReminderBean.getRemindDuration());
            S0().setRepeatModel(drinkReminderBean.getRepeatModel());
            S0().setStartHour(drinkReminderBean.getStartHour());
            S0().setStartMin(drinkReminderBean.getStartMin());
            S0().setEndHour(drinkReminderBean.getEndHour());
            S0().setEndMin(drinkReminderBean.getEndMin());
        }
        R0();
    }

    public final void Z0() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    public final void a1() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton p02, boolean z5) {
        kotlin.jvm.internal.e.f(p02, "p0");
        eh.b bVar = this.f7247z;
        if (p02.equals(((f6.i0) bVar.getValue()).f12981i)) {
            W0().setOpen(z5);
            W0().setRemindDuration(60);
            W0().setStartHour(0);
            W0().setStartMin(0);
            W0().setEndHour(23);
            W0().setEndMin(59);
            com.example.test.presenter.device.k0 k0Var = (com.example.test.presenter.device.k0) I0();
            DrinkReminderBean data = W0();
            k0Var.getClass();
            kotlin.jvm.internal.e.f(data, "data");
            k0Var.f7444c = data;
            ((XXBaseActivity) ((f7.m) k0Var.f7255a)).V();
            com.google.android.gms.internal.mlkit_vision_common.p.J(data);
            return;
        }
        if (p02.equals(((f6.i0) bVar.getValue()).f12980h)) {
            V0().setOpen(z5);
            V0().setRemindDuration(60);
            V0().setStartHour(0);
            V0().setStartMin(0);
            V0().setEndHour(23);
            V0().setEndMin(59);
            com.example.test.presenter.device.k0 k0Var2 = (com.example.test.presenter.device.k0) I0();
            DrinkReminderBean data2 = V0();
            k0Var2.getClass();
            kotlin.jvm.internal.e.f(data2, "data");
            k0Var2.f7445d = data2;
            ((XXBaseActivity) ((f7.m) k0Var2.f7255a)).V();
            com.google.android.gms.internal.mlkit_vision_common.p.M(data2);
            return;
        }
        if (p02.equals(((f6.i0) bVar.getValue()).f12978f)) {
            T0().setOpen(z5);
            T0().setRemindDuration(60);
            T0().setStartHour(0);
            T0().setStartMin(0);
            T0().setEndHour(23);
            T0().setEndMin(59);
            com.example.test.presenter.device.k0 k0Var3 = (com.example.test.presenter.device.k0) I0();
            DrinkReminderBean data3 = T0();
            k0Var3.getClass();
            kotlin.jvm.internal.e.f(data3, "data");
            k0Var3.f7446f = data3;
            ((XXBaseActivity) ((f7.m) k0Var3.f7255a)).V();
            com.google.android.gms.internal.mlkit_vision_common.p.L(data3);
            return;
        }
        if (p02.equals(((f6.i0) bVar.getValue()).f12979g)) {
            S0().setOpen(z5);
            S0().setRemindDuration(60);
            S0().setStartHour(0);
            S0().setStartMin(0);
            S0().setEndHour(23);
            S0().setEndMin(59);
            com.example.test.presenter.device.k0 k0Var4 = (com.example.test.presenter.device.k0) I0();
            DrinkReminderBean data4 = S0();
            k0Var4.getClass();
            kotlin.jvm.internal.e.f(data4, "data");
            k0Var4.f7447g = data4;
            ((XXBaseActivity) ((f7.m) k0Var4.f7255a)).V();
            com.google.android.gms.internal.mlkit_vision_common.p.K(data4);
            return;
        }
        X0().setOpen(z5);
        X0().setRemindDuration(60);
        X0().setStartHour(0);
        X0().setStartMin(0);
        X0().setEndHour(23);
        X0().setEndMin(59);
        com.example.test.presenter.device.k0 k0Var5 = (com.example.test.presenter.device.k0) I0();
        DrinkReminderBean data5 = X0();
        k0Var5.getClass();
        kotlin.jvm.internal.e.f(data5, "data");
        k0Var5.e = data5;
        ((XXBaseActivity) ((f7.m) k0Var5.f7255a)).V();
        com.google.android.gms.internal.mlkit_vision_common.p.O(data5);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.rl_health_heart;
        if (valueOf != null && valueOf.intValue() == i3) {
            Log.e("qob", " isOpen " + U0().isOpen() + " remindDuration " + U0().getRemindDuration());
            boolean isOpen = U0().isOpen();
            eh.b bVar = this.E;
            if (isOpen) {
                ((com.example.test.ui.dialog.l) bVar.getValue()).a((U0().getRemindDuration() / 30) + (-1) < 0 ? 0 : (U0().getRemindDuration() / 30) - 1);
            } else {
                ((com.example.test.ui.dialog.l) bVar.getValue()).a(2);
            }
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onOptionEvent(EventBusBeans.OptionEvent optionEvent) {
        kotlin.jvm.internal.e.f(optionEvent, "optionEvent");
        U0().setRepeatModel(optionEvent.getSelectValue());
        R0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        R0();
    }
}
