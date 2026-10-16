package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import com.google.android.gms.internal.mlkit_vision_barcode.z1;
import f6.v1;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class SettingActivity extends XXBaseActivity<com.example.test.presenter.mine.q, v1> implements h7.j, View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SettingActivity$cacheDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(SettingActivity.this);
            rVar.b(R$string.str_clear_cache_tips);
            rVar.setOnDialogListener(new w(SettingActivity.this));
            return rVar;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SettingActivity$cacheStr$2
        {
            super(0);
        }

        @Override // oh.a
        public final String invoke() {
            return z1.c(SettingActivity.this);
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.SettingActivity$currentUser$2
        @Override // oh.a
        public final User invoke() {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                return kVar.d();
            }
            return null;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.q(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((v1) this.f7247z.getValue()).f13397a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_setting, (ViewGroup) null, false);
        int i3 = R$id.accountSafeAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.backgroudSafe;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.cacheAv;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.privacyAv;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.tempAv;
                        ActionItemView actionItemView5 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView5 != null) {
                            i3 = R$id.titleView;
                            TitleView titleView = (TitleView) he.a(i3, inflate);
                            if (titleView != null) {
                                i3 = R$id.unitAv;
                                ActionItemView actionItemView6 = (ActionItemView) he.a(i3, inflate);
                                if (actionItemView6 != null) {
                                    return new v1((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, actionItemView5, actionItemView6, titleView);
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
        eh.b bVar = this.f7247z;
        ActionItemView actionItemView = ((v1) bVar.getValue()).f13400d;
        String str = (String) this.F.getValue();
        kotlin.jvm.internal.e.e(str, "<get-cacheStr>(...)");
        actionItemView.setHintStr(str);
        User R0 = R0();
        if (R0 != null) {
            ActionItemView actionItemView2 = ((v1) bVar.getValue()).f13403h;
            String string = getString(R0.getMeterUnit() == 0 ? R$string.str_unit_metric : R$string.str_unit_imperial);
            kotlin.jvm.internal.e.c(string);
            actionItemView2.setHintStr(string);
            ActionItemView actionItemView3 = ((v1) bVar.getValue()).f13401f;
            String string2 = getString(R0.getTempUnit() == 0 ? R$string.str_temp_centigrade : R$string.str_temp_fahrenheit);
            kotlin.jvm.internal.e.c(string2);
            actionItemView3.setHintStr(string2);
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.x()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            ((v1) this.f7247z.getValue()).f13403h.setVisibility(8);
            ((v1) this.f7247z.getValue()).f13401f.setVisibility(8);
        }
        ((v1) this.f7247z.getValue()).f13402g.setOnTitleListener(new w(this));
        ((v1) this.f7247z.getValue()).f13403h.setOnClickListener(this);
        ((v1) this.f7247z.getValue()).f13398b.setOnClickListener(this);
        ((v1) this.f7247z.getValue()).e.setOnClickListener(this);
        ((v1) this.f7247z.getValue()).f13401f.setOnClickListener(this);
        ((v1) this.f7247z.getValue()).f13400d.setOnClickListener(this);
        ((v1) this.f7247z.getValue()).f13399c.setOnClickListener(this);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        User d5 = kVar2 != null ? kVar2.d() : null;
        if (d5 == null || d5.getPlatform() != 2) {
            return;
        }
        ((v1) this.f7247z.getValue()).e.setVisibility(8);
    }

    public final User R0() {
        return (User) this.G.getValue();
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i3 = R$id.unitAv;
            if (valueOf != null && valueOf.intValue() == i3) {
                User R0 = R0();
                if (R0 != null) {
                    int meterUnit = R0.getMeterUnit();
                    Intent intent = new Intent(this, (Class<?>) SelectActivity.class);
                    intent.putExtra("select_type", 5);
                    intent.putExtra("option_position", meterUnit);
                    startActivity(intent);
                    return;
                }
                return;
            }
            int i10 = R$id.tempAv;
            if (valueOf != null && valueOf.intValue() == i10) {
                User R02 = R0();
                if (R02 != null) {
                    int tempUnit = R02.getTempUnit();
                    Intent intent2 = new Intent(this, (Class<?>) SelectActivity.class);
                    intent2.putExtra("select_type", 6);
                    intent2.putExtra("option_position", tempUnit);
                    startActivity(intent2);
                    return;
                }
                return;
            }
            int i11 = R$id.accountSafeAv;
            if (valueOf != null && valueOf.intValue() == i11) {
                startActivity(new Intent(this, (Class<?>) AccountSafeActivity.class));
                return;
            }
            int i12 = R$id.privacyAv;
            if (valueOf != null && valueOf.intValue() == i12) {
                startActivity(new Intent(this, (Class<?>) PrivacySafeActivity.class));
                return;
            }
            int i13 = R$id.backgroudSafe;
            if (valueOf != null && valueOf.intValue() == i13) {
                startActivity(new Intent(this, (Class<?>) BackgroudHelpActivity.class));
                return;
            }
            int i14 = R$id.cacheAv;
            if (valueOf != null && valueOf.intValue() == i14) {
                String str = (String) this.F.getValue();
                kotlin.jvm.internal.e.e(str, "<get-cacheStr>(...)");
                if (str.length() > 0) {
                    ((com.example.test.ui.dialog.r) this.E.getValue()).show();
                } else {
                    w0(R$string.str_no_cache);
                }
            }
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onIntegerValueEvent(EventBusBeans.IntegerValueEvent integerValueEvent) {
        kotlin.jvm.internal.e.f(integerValueEvent, "integerValueEvent");
        int i3 = integerValueEvent.valueType;
        eh.b bVar = this.f7247z;
        if (i3 == 5) {
            User R0 = R0();
            if (R0 != null) {
                R0.setMeterUnit(integerValueEvent.value);
                ActionItemView actionItemView = ((v1) bVar.getValue()).f13403h;
                String string = getString(R0.getMeterUnit() == 0 ? R$string.str_unit_metric : R$string.str_unit_imperial);
                kotlin.jvm.internal.e.c(string);
                actionItemView.setHintStr(string);
            }
            ((com.example.test.presenter.mine.q) I0()).k(R0(), 5);
            return;
        }
        if (i3 != 6) {
            return;
        }
        User R02 = R0();
        if (R02 != null) {
            R02.setTempUnit(integerValueEvent.value);
            ActionItemView actionItemView2 = ((v1) bVar.getValue()).f13401f;
            String string2 = getString(R02.getTempUnit() == 0 ? R$string.str_temp_centigrade : R$string.str_temp_fahrenheit);
            kotlin.jvm.internal.e.c(string2);
            actionItemView2.setHintStr(string2);
        }
        ((com.example.test.presenter.mine.q) I0()).k(R0(), 6);
    }
}
