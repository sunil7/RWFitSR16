package com.example.test.ui.testui;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$string;
import f6.o3;
import f6.s2;
import f6.v3;
import f6.z2;
import java.util.Calendar;
import l1.e2;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8277a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TMainRingActivity f8278b;

    public /* synthetic */ g(TMainRingActivity tMainRingActivity, int i3) {
        this.f8277a = i3;
        this.f8278b = tMainRingActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        o3 o3Var;
        z2 z2Var;
        switch (this.f8277a) {
            case 0:
                TMainRingActivity tMainRingActivity = this.f8278b;
                int i3 = TMainRingActivity.J;
                Fragment k10 = tMainRingActivity.S0().k(0);
                kotlin.jvm.internal.e.e(k10, "getItem(...)");
                if (k10 instanceof TRringHomeFragment) {
                    TRringHomeFragment tRringHomeFragment = (TRringHomeFragment) k10;
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
                    Log.d("tong", "mainActivity app style = " + valueOf);
                    if (valueOf != null && valueOf.intValue() == 0) {
                        v3 v3Var = (v3) tRringHomeFragment.f7251b;
                        if (v3Var != null) {
                            v3Var.e.setBarTitleColor(a1.d.a(tRringHomeFragment.f0(), R$color.color_white));
                        }
                        v3 v3Var2 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var2 != null && (linearLayout3 = v3Var2.f13409b) != null) {
                            linearLayout3.setBackgroundColor(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        }
                        Drawable b3 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_menu);
                        kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable = (VectorDrawable) b3;
                        vectorDrawable.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_white));
                        v3 v3Var3 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var3 != null) {
                            v3Var3.e.setBarStatusIv(vectorDrawable);
                        }
                        Drawable b10 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_refresh);
                        kotlin.jvm.internal.e.d(b10, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable2 = (VectorDrawable) b10;
                        vectorDrawable2.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_white));
                        v3 v3Var4 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var4 != null) {
                            v3Var4.e.setBarOption1Iv(vectorDrawable2);
                        }
                        Drawable b11 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_share);
                        kotlin.jvm.internal.e.d(b11, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable3 = (VectorDrawable) b11;
                        vectorDrawable3.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_white));
                        v3 v3Var5 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var5 != null) {
                            v3Var5.e.setBarOption2Iv(vectorDrawable3);
                        }
                    } else if (valueOf != null && valueOf.intValue() == 1) {
                        v3 v3Var6 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var6 != null) {
                            v3Var6.e.setBarTitleColor(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        }
                        v3 v3Var7 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var7 != null && (linearLayout2 = v3Var7.f13409b) != null) {
                            linearLayout2.setBackgroundColor(a1.d.a(tRringHomeFragment.f0(), R$color.color_greywhite));
                        }
                        Drawable b12 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_menu);
                        kotlin.jvm.internal.e.d(b12, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable4 = (VectorDrawable) b12;
                        vectorDrawable4.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        v3 v3Var8 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var8 != null) {
                            v3Var8.e.setBarStatusIv(vectorDrawable4);
                        }
                        Drawable b13 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_refresh);
                        kotlin.jvm.internal.e.d(b13, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable5 = (VectorDrawable) b13;
                        vectorDrawable5.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        v3 v3Var9 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var9 != null) {
                            v3Var9.e.setBarOption1Iv(vectorDrawable5);
                        }
                        Drawable b14 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_share);
                        kotlin.jvm.internal.e.d(b14, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable6 = (VectorDrawable) b14;
                        vectorDrawable6.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        v3 v3Var10 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var10 != null) {
                            v3Var10.e.setBarOption2Iv(vectorDrawable6);
                        }
                    } else if (valueOf != null && valueOf.intValue() == 2) {
                        v3 v3Var11 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var11 != null) {
                            v3Var11.e.setBarTitleColor(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        }
                        v3 v3Var12 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var12 != null && (linearLayout = v3Var12.f13409b) != null) {
                            linearLayout.setBackgroundColor(a1.d.a(tRringHomeFragment.f0(), R$color.color_pink));
                        }
                        Drawable b15 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_menu);
                        kotlin.jvm.internal.e.d(b15, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable7 = (VectorDrawable) b15;
                        vectorDrawable7.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        v3 v3Var13 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var13 != null) {
                            v3Var13.e.setBarStatusIv(vectorDrawable7);
                        }
                        Drawable b16 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_refresh);
                        kotlin.jvm.internal.e.d(b16, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable8 = (VectorDrawable) b16;
                        vectorDrawable8.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        v3 v3Var14 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var14 != null) {
                            v3Var14.e.setBarOption1Iv(vectorDrawable8);
                        }
                        Drawable b17 = a1.c.b(tRringHomeFragment.f0(), R$drawable.svg_ic_tb_share);
                        kotlin.jvm.internal.e.d(b17, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                        VectorDrawable vectorDrawable9 = (VectorDrawable) b17;
                        vectorDrawable9.setTint(a1.d.a(tRringHomeFragment.f0(), R$color.color_black));
                        v3 v3Var15 = (v3) tRringHomeFragment.f7251b;
                        if (v3Var15 != null) {
                            v3Var15.e.setBarOption2Iv(vectorDrawable9);
                        }
                    }
                }
                Fragment k11 = tMainRingActivity.S0().k(1);
                kotlin.jvm.internal.e.e(k11, "getItem(...)");
                if (k11 instanceof TRingActivityFragment) {
                    ((TRingActivityFragment) k11).q0();
                }
                if (tMainRingActivity.S0().c() == 4) {
                    Fragment k12 = tMainRingActivity.S0().k(2);
                    kotlin.jvm.internal.e.e(k12, "getItem(...)");
                    if (k12 instanceof TRingSleepFragment) {
                        ((TRingSleepFragment) k12).q0();
                    }
                    Fragment k13 = tMainRingActivity.S0().k(3);
                    kotlin.jvm.internal.e.e(k13, "getItem(...)");
                    if (k13 instanceof TRingDeviceFragment) {
                        ((TRingDeviceFragment) k13).q0();
                    }
                } else {
                    Fragment k14 = tMainRingActivity.S0().k(2);
                    kotlin.jvm.internal.e.e(k14, "getItem(...)");
                    if (k14 instanceof TRingDeviceFragment) {
                        ((TRingDeviceFragment) k14).q0();
                    }
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                Integer valueOf2 = kVar2 != null ? Integer.valueOf(kVar2.D()) : null;
                Log.d("tong", "mainActivity app style = " + valueOf2);
                if (valueOf2 != null && valueOf2.intValue() == 0) {
                    if (tMainRingActivity.S0().c() == 4) {
                        ((TMainBottomTabView) ((s2) tMainRingActivity.f7249z.getValue()).f13300b.f12378c).setLayoutColor(a1.d.a(tMainRingActivity, R$color.ring_leftmenu_bg));
                    } else {
                        ((TMainBottomSleepTabView) ((s2) tMainRingActivity.f7249z.getValue()).f13300b.f12379d).setLayoutColor(a1.d.a(tMainRingActivity, R$color.ring_leftmenu_bg));
                    }
                    new e2(tMainRingActivity.getWindow(), tMainRingActivity.H0()).b(false);
                    new e2(tMainRingActivity.getWindow(), tMainRingActivity.H0()).a(false);
                    ((s2) tMainRingActivity.f7249z.getValue()).f13302d.setBackgroundColor(a1.d.a(tMainRingActivity, R$color.color_black));
                    View c9 = ((s2) tMainRingActivity.f7249z.getValue()).f13302d.c();
                    c9.setBackgroundColor(a1.d.a(tMainRingActivity, R$color.color_black));
                    ((TextView) c9.findViewById(R$id.tv_username)).setTextColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    ((TextView) c9.findViewById(R$id.tv_user_id)).setTextColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    Menu menu = ((s2) tMainRingActivity.f7249z.getValue()).f13302d.getMenu();
                    kotlin.jvm.internal.e.e(menu, "getMenu(...)");
                    MenuItem findItem = menu.findItem(R$id.nav_qcoder);
                    Drawable b18 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_tb_menu);
                    kotlin.jvm.internal.e.d(b18, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable10 = (VectorDrawable) b18;
                    vectorDrawable10.setTint(a1.d.a(tMainRingActivity, R$color.color_white));
                    findItem.setIcon(vectorDrawable10);
                    MenuItem findItem2 = menu.findItem(R$id.nav_persional);
                    Drawable b19 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_personal);
                    kotlin.jvm.internal.e.d(b19, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable11 = (VectorDrawable) b19;
                    vectorDrawable11.setTint(a1.d.a(tMainRingActivity, R$color.color_white));
                    findItem2.setIcon(vectorDrawable11);
                    MenuItem findItem3 = menu.findItem(R$id.nav_settings);
                    Drawable b20 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_settings);
                    kotlin.jvm.internal.e.d(b20, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable12 = (VectorDrawable) b20;
                    vectorDrawable12.setTint(a1.d.a(tMainRingActivity, R$color.color_white));
                    findItem3.setIcon(vectorDrawable12);
                    MenuItem findItem4 = menu.findItem(R$id.nav_about);
                    Drawable b21 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_about);
                    kotlin.jvm.internal.e.d(b21, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable13 = (VectorDrawable) b21;
                    vectorDrawable13.setTint(a1.d.a(tMainRingActivity, R$color.color_white));
                    findItem4.setIcon(vectorDrawable13);
                    ((s2) tMainRingActivity.f7249z.getValue()).f13302d.setItemTextColor(ColorStateList.valueOf(a1.d.a(tMainRingActivity, R$color.color_white)));
                    return;
                }
                if (valueOf2 != null && valueOf2.intValue() == 1) {
                    if (tMainRingActivity.S0().c() == 4) {
                        ((TMainBottomTabView) ((s2) tMainRingActivity.f7249z.getValue()).f13300b.f12378c).setLayoutColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    } else {
                        ((TMainBottomSleepTabView) ((s2) tMainRingActivity.f7249z.getValue()).f13300b.f12379d).setLayoutColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    }
                    new e2(tMainRingActivity.getWindow(), tMainRingActivity.H0()).b(true);
                    new e2(tMainRingActivity.getWindow(), tMainRingActivity.H0()).a(true);
                    ((s2) tMainRingActivity.f7249z.getValue()).f13302d.setBackgroundColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    View c10 = ((s2) tMainRingActivity.f7249z.getValue()).f13302d.c();
                    c10.setBackgroundColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    ((TextView) c10.findViewById(R$id.tv_username)).setTextColor(a1.d.a(tMainRingActivity, R$color.color_black));
                    ((TextView) c10.findViewById(R$id.tv_user_id)).setTextColor(a1.d.a(tMainRingActivity, R$color.color_black));
                    Menu menu2 = ((s2) tMainRingActivity.f7249z.getValue()).f13302d.getMenu();
                    kotlin.jvm.internal.e.e(menu2, "getMenu(...)");
                    MenuItem findItem5 = menu2.findItem(R$id.nav_qcoder);
                    Drawable b22 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_tb_menu);
                    kotlin.jvm.internal.e.d(b22, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable14 = (VectorDrawable) b22;
                    vectorDrawable14.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem5.setIcon(vectorDrawable14);
                    MenuItem findItem6 = menu2.findItem(R$id.nav_persional);
                    Drawable b23 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_personal);
                    kotlin.jvm.internal.e.d(b23, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable15 = (VectorDrawable) b23;
                    vectorDrawable15.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem6.setIcon(vectorDrawable15);
                    MenuItem findItem7 = menu2.findItem(R$id.nav_settings);
                    Drawable b24 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_settings);
                    kotlin.jvm.internal.e.d(b24, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable16 = (VectorDrawable) b24;
                    vectorDrawable16.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem7.setIcon(vectorDrawable16);
                    MenuItem findItem8 = menu2.findItem(R$id.nav_about);
                    Drawable b25 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_about);
                    kotlin.jvm.internal.e.d(b25, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable17 = (VectorDrawable) b25;
                    vectorDrawable17.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem8.setIcon(vectorDrawable17);
                    ((s2) tMainRingActivity.f7249z.getValue()).f13302d.setItemTextColor(ColorStateList.valueOf(a1.d.a(tMainRingActivity, R$color.color_black)));
                    return;
                }
                if (valueOf2 != null && valueOf2.intValue() == 2) {
                    if (tMainRingActivity.S0().c() == 4) {
                        ((TMainBottomTabView) ((s2) tMainRingActivity.f7249z.getValue()).f13300b.f12378c).setLayoutColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    } else {
                        ((TMainBottomSleepTabView) ((s2) tMainRingActivity.f7249z.getValue()).f13300b.f12379d).setLayoutColor(a1.d.a(tMainRingActivity, R$color.color_white));
                    }
                    new e2(tMainRingActivity.getWindow(), tMainRingActivity.H0()).b(true);
                    new e2(tMainRingActivity.getWindow(), tMainRingActivity.H0()).a(true);
                    ((s2) tMainRingActivity.f7249z.getValue()).f13302d.setBackgroundColor(a1.d.a(tMainRingActivity, R$color.color_pink));
                    View c11 = ((s2) tMainRingActivity.f7249z.getValue()).f13302d.c();
                    c11.setBackgroundColor(a1.d.a(tMainRingActivity, R$color.color_pink));
                    ((TextView) c11.findViewById(R$id.tv_username)).setTextColor(a1.d.a(tMainRingActivity, R$color.color_black));
                    ((TextView) c11.findViewById(R$id.tv_user_id)).setTextColor(a1.d.a(tMainRingActivity, R$color.color_black));
                    Menu menu3 = ((s2) tMainRingActivity.f7249z.getValue()).f13302d.getMenu();
                    kotlin.jvm.internal.e.e(menu3, "getMenu(...)");
                    MenuItem findItem9 = menu3.findItem(R$id.nav_qcoder);
                    Drawable b26 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_tb_menu);
                    kotlin.jvm.internal.e.d(b26, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable18 = (VectorDrawable) b26;
                    vectorDrawable18.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem9.setIcon(vectorDrawable18);
                    MenuItem findItem10 = menu3.findItem(R$id.nav_persional);
                    Drawable b27 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_personal);
                    kotlin.jvm.internal.e.d(b27, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable19 = (VectorDrawable) b27;
                    vectorDrawable19.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem10.setIcon(vectorDrawable19);
                    MenuItem findItem11 = menu3.findItem(R$id.nav_settings);
                    Drawable b28 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_settings);
                    kotlin.jvm.internal.e.d(b28, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable20 = (VectorDrawable) b28;
                    vectorDrawable20.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem11.setIcon(vectorDrawable20);
                    MenuItem findItem12 = menu3.findItem(R$id.nav_about);
                    Drawable b29 = a1.c.b(tMainRingActivity, R$drawable.svg_ic_menu_about);
                    kotlin.jvm.internal.e.d(b29, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
                    VectorDrawable vectorDrawable21 = (VectorDrawable) b29;
                    vectorDrawable21.setTint(a1.d.a(tMainRingActivity, R$color.color_black));
                    findItem12.setIcon(vectorDrawable21);
                    ((s2) tMainRingActivity.f7249z.getValue()).f13302d.setItemTextColor(ColorStateList.valueOf(a1.d.a(tMainRingActivity, R$color.color_black)));
                    return;
                }
                return;
            case 1:
                int i10 = TMainRingActivity.J;
                try {
                    this.f8278b.Q0(R$string.str_device_connecting);
                    return;
                } catch (Throwable th2) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "MainActivity", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("弹窗出错 ", th2.getLocalizedMessage()));
                    return;
                }
            default:
                int i11 = TMainRingActivity.J;
                TMainRingActivity tMainRingActivity2 = this.f8278b;
                Fragment k15 = tMainRingActivity2.S0().k(1);
                kotlin.jvm.internal.e.e(k15, "getItem(...)");
                if ((k15 instanceof TRingActivityFragment) && (z2Var = (z2) ((TRingActivityFragment) k15).f7251b) != null) {
                    TRingDateSelectView tRingDateSelectView = z2Var.f13500v;
                    tRingDateSelectView.f8206b = Calendar.getInstance();
                    tRingDateSelectView.c();
                }
                Fragment k16 = tMainRingActivity2.S0().k(2);
                kotlin.jvm.internal.e.e(k16, "getItem(...)");
                if (!(k16 instanceof TRingSleepFragment) || (o3Var = (o3) ((TRingSleepFragment) k16).f7251b) == null) {
                    return;
                }
                TRingDateSelectView tRingDateSelectView2 = o3Var.T;
                tRingDateSelectView2.f8206b = Calendar.getInstance();
                tRingDateSelectView2.c();
                return;
        }
    }
}
