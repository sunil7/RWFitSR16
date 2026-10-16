package com.example.test.ui.testui;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.r2;

/* loaded from: classes.dex */
public final class TRingThemeTypeActivity extends XXBaseActivity<com.example.test.presenter.device.n, r2> implements p5.a, View.OnClickListener {
    public int E;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 13);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((r2) this.f7247z.getValue()).f13276a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_themetype, (ViewGroup) null, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        int i3 = R$id.rl_theme_black;
        RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
        if (relativeLayout != null) {
            i3 = R$id.rl_theme_pink;
            RelativeLayout relativeLayout2 = (RelativeLayout) he.a(i3, inflate);
            if (relativeLayout2 != null) {
                i3 = R$id.rl_theme_white;
                RelativeLayout relativeLayout3 = (RelativeLayout) he.a(i3, inflate);
                if (relativeLayout3 != null) {
                    i3 = R$id.theme_title;
                    if (((TextView) he.a(i3, inflate)) != null) {
                        i3 = R$id.toolbar;
                        TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                        if (tRingToolBarView != null) {
                            return new r2(linearLayout, relativeLayout, relativeLayout2, relativeLayout3, tRingToolBarView);
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
        ((r2) bVar.getValue()).e.setOnViewChildListener(new a1(this, 8));
        eh.b bVar2 = this.D;
        Integer num = (Integer) bVar2.getValue();
        kotlin.jvm.internal.e.c(num);
        this.E = num.intValue();
        Integer num2 = (Integer) bVar2.getValue();
        if (num2 != null && num2.intValue() == 0) {
            ((r2) bVar.getValue()).f13277b.setBackgroundResource(R$mipmap.theme_black_sel);
            ((r2) bVar.getValue()).f13279d.setBackgroundResource(R$mipmap.theme_white_nor);
            ((r2) bVar.getValue()).f13278c.setBackgroundResource(R$mipmap.theme_pink_nor);
        } else if (num2 != null && num2.intValue() == 1) {
            ((r2) bVar.getValue()).f13277b.setBackgroundResource(R$mipmap.theme_black_nor);
            ((r2) bVar.getValue()).f13279d.setBackgroundResource(R$mipmap.theme_white_sel);
            ((r2) bVar.getValue()).f13278c.setBackgroundResource(R$mipmap.theme_pink_nor);
        } else if (num2 != null && num2.intValue() == 2) {
            ((r2) bVar.getValue()).f13277b.setBackgroundResource(R$mipmap.theme_black_nor);
            ((r2) bVar.getValue()).f13279d.setBackgroundResource(R$mipmap.theme_white_nor);
            ((r2) bVar.getValue()).f13278c.setBackgroundResource(R$mipmap.theme_pink_sel);
        }
        r2 r2Var = (r2) bVar.getValue();
        if (r2Var != null) {
            r2Var.f13277b.setOnClickListener(this);
        }
        r2 r2Var2 = (r2) bVar.getValue();
        if (r2Var2 != null) {
            r2Var2.f13279d.setOnClickListener(this);
        }
        r2 r2Var3 = (r2) bVar.getValue();
        if (r2Var3 != null) {
            r2Var3.f13278c.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.rl_theme_black;
        if (valueOf != null && valueOf.intValue() == i3) {
            Log.d("tong", "click-black theme");
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.M(0, "app_theme_style");
            }
            if (this.E != 0) {
                this.E = 0;
                recreate();
                yh.d.b().e(new EventBusBeans.ChangeThemeEvent());
                return;
            }
            return;
        }
        int i10 = R$id.rl_theme_white;
        if (valueOf != null && valueOf.intValue() == i10) {
            Log.d("tong", "click-while theme");
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                kVar2.M(1, "app_theme_style");
            }
            if (this.E != 1) {
                this.E = 1;
                recreate();
                yh.d.b().e(new EventBusBeans.ChangeThemeEvent());
                return;
            }
            return;
        }
        int i11 = R$id.rl_theme_pink;
        if (valueOf != null && valueOf.intValue() == i11) {
            Log.d("tong", "click-pink theme");
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
            if (kVar3 != null) {
                kVar3.M(2, "app_theme_style");
            }
            if (this.E != 2) {
                this.E = 2;
                recreate();
                yh.d.b().e(new EventBusBeans.ChangeThemeEvent());
            }
        }
    }
}
