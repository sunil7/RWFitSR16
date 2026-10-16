package com.example.test.ui.testui;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.i2;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class TRingSportTypeActivity extends XXBaseActivity<com.example.test.presenter.device.n, i2> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int G = 0;
    public int E = 4;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSportTypeActivity$permissionTips$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            TRingSportTypeActivity tRingSportTypeActivity = TRingSportTypeActivity.this;
            tRingSportTypeActivity.getClass();
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(tRingSportTypeActivity);
            rVar.setOnDialogListener(new v0(TRingSportTypeActivity.this));
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 10);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((i2) this.f7247z.getValue()).f12989a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_sporttype, (ViewGroup) null, false);
        int i3 = R$id.iv_climbmoun;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.iv_healthwalk;
            if (((ImageView) he.a(i3, inflate)) != null) {
                i3 = R$id.iv_indoorrun;
                if (((ImageView) he.a(i3, inflate)) != null) {
                    i3 = R$id.iv_outdoorrun;
                    if (((ImageView) he.a(i3, inflate)) != null) {
                        i3 = R$id.iv_ridebike;
                        if (((ImageView) he.a(i3, inflate)) != null) {
                            i3 = R$id.rl_climbmoun;
                            RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                            if (relativeLayout != null) {
                                i3 = R$id.rl_healthwalk;
                                RelativeLayout relativeLayout2 = (RelativeLayout) he.a(i3, inflate);
                                if (relativeLayout2 != null) {
                                    i3 = R$id.rl_indoorrun;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) he.a(i3, inflate);
                                    if (relativeLayout3 != null) {
                                        i3 = R$id.rl_outdoorrun;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) he.a(i3, inflate);
                                        if (relativeLayout4 != null) {
                                            i3 = R$id.rl_ridebike;
                                            RelativeLayout relativeLayout5 = (RelativeLayout) he.a(i3, inflate);
                                            if (relativeLayout5 != null) {
                                                i3 = R$id.toolbar;
                                                TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                                                if (tRingToolBarView != null) {
                                                    return new i2((LinearLayout) inflate, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, tRingToolBarView);
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
        Log.e("qob", "DeviceScanFragment initData");
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((i2) bVar.getValue()).f12994g.setOnViewChildListener(new v0(this));
        i2 i2Var = (i2) bVar.getValue();
        if (i2Var != null) {
            i2Var.f12992d.setOnClickListener(this);
        }
        i2 i2Var2 = (i2) bVar.getValue();
        if (i2Var2 != null) {
            i2Var2.e.setOnClickListener(this);
        }
        i2 i2Var3 = (i2) bVar.getValue();
        if (i2Var3 != null) {
            i2Var3.f12993f.setOnClickListener(this);
        }
        i2 i2Var4 = (i2) bVar.getValue();
        if (i2Var4 != null) {
            i2Var4.f12991c.setOnClickListener(this);
        }
        i2 i2Var5 = (i2) bVar.getValue();
        if (i2Var5 != null) {
            i2Var5.f12990b.setOnClickListener(this);
        }
    }

    public final void R0() {
        int i3 = this.E;
        eh.b bVar = this.F;
        if (i3 == 4) {
            if (!nd.c.j(this, kotlin.collections.i.b("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACTIVITY_RECOGNITION", "android.permission.BODY_SENSORS"))) {
                ((com.example.test.ui.dialog.r) bVar.getValue()).b(R$string.str_sport_permisson_tips);
                ((com.example.test.ui.dialog.r) bVar.getValue()).show();
                return;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                v2.h hVar = new v2.h(this);
                hVar.o("android.permission.ACTIVITY_RECOGNITION");
                hVar.o("android.permission.BODY_SENSORS");
                hVar.p(new u0(this, 2));
                return;
            }
            v2.h hVar2 = new v2.h(this);
            hVar2.o("android.permission.ACTIVITY_RECOGNITION");
            hVar2.o("android.permission.BODY_SENSORS");
            hVar2.o("android.permission.WRITE_EXTERNAL_STORAGE");
            hVar2.o("android.permission.READ_EXTERNAL_STORAGE");
            hVar2.p(new u0(this, 3));
            return;
        }
        ArrayList b3 = kotlin.collections.i.b("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACTIVITY_RECOGNITION", "android.permission.BODY_SENSORS");
        b3.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        if (!nd.c.j(this, b3)) {
            ((com.example.test.ui.dialog.r) bVar.getValue()).b(R$string.str_sport_permisson_tips);
            ((com.example.test.ui.dialog.r) bVar.getValue()).show();
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            v2.h hVar3 = new v2.h(this);
            hVar3.o("android.permission.ACTIVITY_RECOGNITION");
            hVar3.o("android.permission.BODY_SENSORS");
            hVar3.p(new u0(this, 0));
            return;
        }
        v2.h hVar4 = new v2.h(this);
        hVar4.o("android.permission.ACTIVITY_RECOGNITION");
        hVar4.o("android.permission.BODY_SENSORS");
        hVar4.o("android.permission.WRITE_EXTERNAL_STORAGE");
        hVar4.o("android.permission.READ_EXTERNAL_STORAGE");
        hVar4.p(new u0(this, 1));
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.rl_indoorrun;
        if (valueOf != null && valueOf.intValue() == i3) {
            this.E = 4;
            R0();
            return;
        }
        int i10 = R$id.rl_outdoorrun;
        if (valueOf != null && valueOf.intValue() == i10) {
            this.E = 5;
            R0();
            return;
        }
        int i11 = R$id.rl_healthwalk;
        if (valueOf != null && valueOf.intValue() == i11) {
            this.E = 7;
            R0();
            return;
        }
        int i12 = R$id.rl_ridebike;
        if (valueOf != null && valueOf.intValue() == i12) {
            this.E = 2;
            R0();
            return;
        }
        int i13 = R$id.rl_climbmoun;
        if (valueOf != null && valueOf.intValue() == i13) {
            this.E = 14;
            R0();
        }
    }
}
