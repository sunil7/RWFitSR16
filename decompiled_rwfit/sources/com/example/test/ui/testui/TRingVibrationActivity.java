package com.example.test.ui.testui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.blesdk.bean.function.BrightVibrationBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.main.w1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.u2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class TRingVibrationActivity extends XXBaseActivity<w1, u2> implements g7.b0, View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingVibrationActivity$selectSingleDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(TRingVibrationActivity.this.getString(R$string.str_ring_screen_light_0));
            arrayList.add(TRingVibrationActivity.this.getString(R$string.str_ring_vibration_1));
            arrayList.add(TRingVibrationActivity.this.getString(R$string.str_ring_vibration_2));
            arrayList.add(TRingVibrationActivity.this.getString(R$string.str_ring_vibration_3));
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(TRingVibrationActivity.this, arrayList);
            lVar.setOnDialogDataListener(new z0(TRingVibrationActivity.this, 1));
            return lVar;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingVibrationActivity$selectSingleDialog2$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 3; i3 < 11; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(TRingVibrationActivity.this, arrayList);
            lVar.setOnDialogDataListener(new z0(TRingVibrationActivity.this, 2));
            return lVar;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingVibrationActivity$vibrationBean$2
        @Override // oh.a
        public final BrightVibrationBean invoke() {
            return new BrightVibrationBean();
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new w1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((u2) this.f7247z.getValue()).f13374a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_vibration, (ViewGroup) null, false);
        int i3 = R$id.ivNext;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.ivNext2;
            if (((ImageView) he.a(i3, inflate)) != null) {
                i3 = R$id.rl_health_heart;
                RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                if (relativeLayout != null) {
                    i3 = R$id.rl_health_heart2;
                    RelativeLayout relativeLayout2 = (RelativeLayout) he.a(i3, inflate);
                    if (relativeLayout2 != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            i3 = R$id.tv_health_hr_value;
                            TextView textView = (TextView) he.a(i3, inflate);
                            if (textView != null) {
                                i3 = R$id.tv_health_hr_value2;
                                TextView textView2 = (TextView) he.a(i3, inflate);
                                if (textView2 != null) {
                                    return new u2((LinearLayout) inflate, relativeLayout, relativeLayout2, titleView, textView, textView2);
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
        ((w1) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((u2) bVar.getValue()).f13377d.setOnTitleListener(new z0(this, 0));
        ((u2) bVar.getValue()).f13375b.setOnClickListener(this);
        ((u2) bVar.getValue()).f13376c.setOnClickListener(this);
        R0();
    }

    public final void R0() {
        List d5 = kotlin.collections.i.d(getString(R$string.str_ring_screen_light_0), getString(R$string.str_ring_vibration_1), getString(R$string.str_ring_vibration_2), getString(R$string.str_ring_vibration_3));
        eh.b bVar = this.f7247z;
        ((u2) bVar.getValue()).e.setText((CharSequence) d5.get(S0().getLevel()));
        ((u2) bVar.getValue()).f13378f.setText(S0().getCount() + getString(R$string.str_count));
    }

    public final BrightVibrationBean S0() {
        return (BrightVibrationBean) this.G.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.rl_health_heart;
        if (valueOf != null && valueOf.intValue() == i3) {
            eh.b bVar = this.E;
            ((com.example.test.ui.dialog.l) bVar.getValue()).a(S0().getLevel());
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
            return;
        }
        int i10 = R$id.rl_health_heart2;
        if (valueOf != null && valueOf.intValue() == i10) {
            int count = S0().getCount() - 3;
            if (count < 0) {
                count = 0;
            }
            eh.b bVar2 = this.F;
            ((com.example.test.ui.dialog.l) bVar2.getValue()).a(count);
            ((com.example.test.ui.dialog.l) bVar2.getValue()).show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        R0();
    }
}
