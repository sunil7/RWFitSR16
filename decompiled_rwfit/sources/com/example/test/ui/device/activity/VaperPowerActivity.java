package com.example.test.ui.device.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.blesdk.bean.function.VaperPowerBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.device.j1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.t2;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class VaperPowerActivity extends XXBaseActivity<j1, t2> implements f7.a0, View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public VaperPowerBean E = new VaperPowerBean();
    public ArrayList F = new ArrayList();
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.VaperPowerActivity$selectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            VaperPowerActivity vaperPowerActivity = VaperPowerActivity.this;
            ArrayList arrayList = vaperPowerActivity.F;
            if (vaperPowerActivity.E.getVaperPowerType() == 1) {
                String string = VaperPowerActivity.this.getString(R$string.str_vaperpower_mode_normal);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                String string2 = VaperPowerActivity.this.getString(R$string.str_vaperpower_mode_boost);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                arrayList = kotlin.collections.i.e(string, string2);
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(VaperPowerActivity.this, arrayList);
            lVar.setOnDialogDataListener(new e0(VaperPowerActivity.this, 1));
            return lVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new j1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((t2) this.f7247z.getValue()).f13342a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_vaper_power, (ViewGroup) null, false);
        int i3 = R$id.avScreenInfo;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.titleView;
            TitleView titleView = (TitleView) he.a(i3, inflate);
            if (titleView != null) {
                return new t2((LinearLayout) inflate, actionItemView, titleView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((j1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((t2) bVar.getValue()).f13343b.setOnClickListener(this);
        ((t2) bVar.getValue()).f13344c.setOnTitleListener(new i0(this, 0));
        R0();
    }

    public final void R0() {
        if (this.E.getVaperPowerType() == 2) {
            this.F = new ArrayList();
            int[] vaperPowerLevel = this.E.getVaperPowerLevel();
            kotlin.jvm.internal.e.e(vaperPowerLevel, "getVaperPowerLevel(...)");
            for (int i3 : vaperPowerLevel) {
                this.F.add(i3 + "W");
            }
        } else if (this.E.getVaperPowerType() == 3) {
            String string = getString(R$string.str_vaperpower_mode_normal);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            String string2 = getString(R$string.str_vaperpower_mode_smooth);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            String string3 = getString(R$string.str_vaperpower_mode_boost);
            kotlin.jvm.internal.e.e(string3, "getString(...)");
            this.F = kotlin.collections.i.e(string, string2, string3);
        } else {
            String string4 = getString(R$string.str_vaperpower_mode_smooth);
            kotlin.jvm.internal.e.e(string4, "getString(...)");
            String string5 = getString(R$string.str_vaperpower_mode_normal);
            kotlin.jvm.internal.e.e(string5, "getString(...)");
            String string6 = getString(R$string.str_vaperpower_mode_boost);
            kotlin.jvm.internal.e.e(string6, "getString(...)");
            this.F = kotlin.collections.i.e(string4, string5, string6);
        }
        ((t2) this.f7247z.getValue()).f13343b.setHintStr((String) this.F.get(this.E.getPowerLevel()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.avScreenInfo;
        if (valueOf != null && valueOf.intValue() == i3) {
            int powerLevel = this.E.getPowerLevel();
            if (this.E.getVaperPowerType() == 1) {
                powerLevel--;
            }
            eh.b bVar = this.G;
            ((com.example.test.ui.dialog.l) bVar.getValue()).a(powerLevel);
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onVaperPowerLevelEvent(EventBusBeans.VaperPowerLevelEvent powerLevelEvent) {
        kotlin.jvm.internal.e.f(powerLevelEvent, "powerLevelEvent");
        if (powerLevelEvent.getVaperPowerLevelBean() != null) {
            VaperPowerBean vaperPowerLevelBean = powerLevelEvent.getVaperPowerLevelBean();
            kotlin.jvm.internal.e.e(vaperPowerLevelBean, "getVaperPowerLevelBean(...)");
            this.E = vaperPowerLevelBean;
            R0();
        }
    }
}
