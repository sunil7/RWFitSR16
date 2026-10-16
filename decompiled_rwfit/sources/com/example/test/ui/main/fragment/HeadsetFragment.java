package com.example.test.ui.main.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.network.bean.FirmwareInfoBean;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.R$style;
import com.example.test.XXApplication;
import com.example.test.presenter.device.y0;
import com.example.test.presenter.main.p0;
import com.example.test.ui.dialog.r;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import com.google.android.gms.internal.mlkit_vision_barcode.tb;
import f6.k3;
import java.util.ArrayList;
import java.util.Arrays;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class HeadsetFragment extends BaseFragment<p0, k3> implements e7.a, View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public k6.b f8070c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8071d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public FirmwareInfoBean f8072f;

    /* renamed from: g, reason: collision with root package name */
    public int f8073g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f8074h = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HeadsetFragment$loadingDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.h invoke() {
            Context requireContext = HeadsetFragment.this.requireContext();
            kotlin.jvm.internal.e.e(requireContext, "requireContext(...)");
            com.example.test.ui.dialog.h hVar = new com.example.test.ui.dialog.h(requireContext);
            hVar.c(8);
            return hVar;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f8075i = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HeadsetFragment$tipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final r invoke() {
            r rVar = new r(HeadsetFragment.this.f0());
            rVar.b(R$string.str_disconnect_tips);
            return rVar;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f8076j = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HeadsetFragment$headsetFindDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.f invoke() {
            com.example.test.ui.dialog.f fVar = new com.example.test.ui.dialog.f(HeadsetFragment.this.f0(), R$style.bottom_dialog);
            fVar.setContentView(R$layout.dialog_headset_find);
            Window window = fVar.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = 0;
                attributes.width = fVar.getContext().getResources().getDisplayMetrics().widthPixels;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                window.setBackgroundDrawableResource(R$color.transparent);
            }
            View findViewById = fVar.findViewById(R$id.ib_hs_find_left);
            kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
            fVar.f7959d = (ImageView) findViewById;
            View findViewById2 = fVar.findViewById(R$id.ib_hs_find_right);
            kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
            fVar.e = (ImageView) findViewById2;
            ((ImageView) fVar.findViewById(R$id.iv_find_close)).setOnClickListener(fVar);
            ImageView imageView = fVar.f7959d;
            if (imageView == null) {
                kotlin.jvm.internal.e.m("mIb_hs_find_left");
                throw null;
            }
            imageView.setOnClickListener(fVar);
            ImageView imageView2 = fVar.e;
            if (imageView2 == null) {
                kotlin.jvm.internal.e.m("mIb_hs_find_right");
                throw null;
            }
            imageView2.setOnClickListener(fVar);
            fVar.setOnDialogListener(new i(HeadsetFragment.this, 4));
            return fVar;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f8077k = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HeadsetFragment$headsetOtaDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.g invoke() {
            com.example.test.ui.dialog.g gVar = new com.example.test.ui.dialog.g(HeadsetFragment.this.f0(), R$style.bottom_dialog);
            gVar.setContentView(R$layout.dialog_headset_ota);
            Window window = gVar.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = 0;
                attributes.width = gVar.getContext().getResources().getDisplayMetrics().widthPixels;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                window.setBackgroundDrawableResource(R$color.transparent);
            }
            ((ImageView) gVar.findViewById(R$id.iv_find_close)).setOnClickListener(gVar);
            View findViewById = gVar.findViewById(R$id.progressBtn);
            kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
            gVar.f7961b = (ProgressButtonView) findViewById;
            View findViewById2 = gVar.findViewById(R$id.tv_hs_ota_current);
            kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
            gVar.f7962c = (TextView) findViewById2;
            View findViewById3 = gVar.findViewById(R$id.tv_hs_ota_new);
            kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
            gVar.f7963d = (TextView) findViewById3;
            gVar.a().setText(gVar.getContext().getString(R$string.str_install));
            gVar.a().setEnable(true);
            gVar.a().setOnClickListener(gVar);
            gVar.setOnDialogListener(new c0.b(3, HeadsetFragment.this, gVar));
            return gVar;
        }
    });

    public final void E(float f2) {
        String concat = String.format("%s: %.2f", Arrays.copyOf(new Object[]{getString(R$string.str_installing), Float.valueOf(f2)}, 2)).concat("%");
        q0().a().setProgress(f2);
        q0().a().setText(concat);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        p0 p0Var = new p0(this);
        p0Var.e = "";
        p0Var.f7545f = "0e090B00";
        return p0Var;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void V() {
        eh.b bVar = this.f8074h;
        ((com.example.test.ui.dialog.h) bVar.getValue()).c(8);
        if (((com.example.test.ui.dialog.h) bVar.getValue()).isShowing()) {
            return;
        }
        ((com.example.test.ui.dialog.h) bVar.getValue()).show();
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        k3 k3Var = (k3) this.f7251b;
        if (k3Var != null) {
            return k3Var.f13060a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a3;
        View a10;
        View a11;
        View a12;
        View a13;
        View a14;
        View inflate = layoutInflater.inflate(R$layout.fragment_headset, viewGroup, false);
        int i3 = R$id.iv_head_icon;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.iv_hs_equalizer_bg;
            ImageView imageView = (ImageView) he.a(i3, inflate);
            if (imageView != null) {
                i3 = R$id.ll_battery_case;
                if (((LinearLayout) he.a(i3, inflate)) != null) {
                    i3 = R$id.ll_headset;
                    if (((LinearLayout) he.a(i3, inflate)) != null) {
                        i3 = R$id.pb_hs_battery_case;
                        ProgressBar progressBar = (ProgressBar) he.a(i3, inflate);
                        if (progressBar != null) {
                            i3 = R$id.pb_hs_battery_left;
                            ProgressBar progressBar2 = (ProgressBar) he.a(i3, inflate);
                            if (progressBar2 != null) {
                                i3 = R$id.pb_hs_battery_right;
                                ProgressBar progressBar3 = (ProgressBar) he.a(i3, inflate);
                                if (progressBar3 != null) {
                                    i3 = R$id.pb_hs_brightness;
                                    SeekBar seekBar = (SeekBar) he.a(i3, inflate);
                                    if (seekBar != null) {
                                        i3 = R$id.rl_hs_brightness;
                                        if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                            i3 = R$id.rl_hs_equalizer;
                                            if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                                i3 = R$id.rl_hs_finddev;
                                                RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                                                if (relativeLayout != null) {
                                                    i3 = R$id.rl_hs_navview;
                                                    if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                                        i3 = R$id.rl_hs_ota;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) he.a(i3, inflate);
                                                        if (relativeLayout2 != null) {
                                                            i3 = R$id.sv_headset;
                                                            if (((ScrollView) he.a(i3, inflate)) != null) {
                                                                i3 = R$id.tv_hs_battery_case;
                                                                TextView textView = (TextView) he.a(i3, inflate);
                                                                if (textView != null) {
                                                                    i3 = R$id.tv_hs_battery_left;
                                                                    TextView textView2 = (TextView) he.a(i3, inflate);
                                                                    if (textView2 != null) {
                                                                        i3 = R$id.tv_hs_battery_right;
                                                                        TextView textView3 = (TextView) he.a(i3, inflate);
                                                                        if (textView3 != null) {
                                                                            i3 = R$id.tv_hs_brightness_title;
                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                i3 = R$id.tv_hs_eq_title1;
                                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                                    i3 = R$id.tv_hs_eq_title2;
                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                        i3 = R$id.tv_hs_eq_title3;
                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                            i3 = R$id.tv_hs_eq_title4;
                                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                i3 = R$id.tv_hs_eq_title5;
                                                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                    i3 = R$id.tv_hs_equalizer_title;
                                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                        i3 = R$id.tv_hs_finddev_title;
                                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                            i3 = R$id.tv_hs_navleft;
                                                                                                            TextView textView4 = (TextView) he.a(i3, inflate);
                                                                                                            if (textView4 != null) {
                                                                                                                i3 = R$id.tv_hs_navlist;
                                                                                                                ImageView imageView2 = (ImageView) he.a(i3, inflate);
                                                                                                                if (imageView2 != null) {
                                                                                                                    i3 = R$id.tv_hs_navtitle;
                                                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                        i3 = R$id.tv_hs_ota_title;
                                                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                            i3 = R$id.tv_hs_ota_version;
                                                                                                                            TextView textView5 = (TextView) he.a(i3, inflate);
                                                                                                                            if (textView5 != null && (a3 = he.a((i3 = R$id.view_hs_eq_click1), inflate)) != null && (a10 = he.a((i3 = R$id.view_hs_eq_click2), inflate)) != null && (a11 = he.a((i3 = R$id.view_hs_eq_click3), inflate)) != null && (a12 = he.a((i3 = R$id.view_hs_eq_click4), inflate)) != null && (a13 = he.a((i3 = R$id.view_hs_eq_click5), inflate)) != null && (a14 = he.a((i3 = R$id.view_hs_ota_point), inflate)) != null) {
                                                                                                                                return new k3((RelativeLayout) inflate, imageView, progressBar, progressBar2, progressBar3, seekBar, relativeLayout, relativeLayout2, textView, textView2, textView3, textView4, imageView2, textView5, a3, a10, a11, a12, a13, a14);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    public final void a0(int i3) {
        y.u().G();
        b0();
        if (!this.e) {
            this.e = true;
            com.example.baselibrary.utils.d.a(R$string.str_upgrade_fail);
        }
        k6.b bVar = this.f8070c;
        if (bVar != null) {
            bVar.P();
        }
        this.f8070c = null;
        com.example.test.service.e.h().getClass();
        com.example.test.service.e.h().f7682a = true;
        com.example.test.service.e.h().n();
        q0().a().setEnable(true);
        q0().a().setText(getString(R$string.str_reinstall));
        q0().dismiss();
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void b0() {
        ((com.example.test.ui.dialog.h) this.f8074h.getValue()).dismiss();
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        Log.e("qob", "HeadsetFragment initData");
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        Log.e("qob", "HeadsetFragment initView");
        com.example.test.service.e.h().getClass();
        Log.e("qob", "initOTAManager");
        XXApplication xXApplication = XXApplication.f7400h;
        k6.b bVar = new k6.b(j1.a());
        this.f8070c = bVar;
        y0 y0Var = new y0(this, 1 == true ? 1 : 0);
        ArrayList arrayList = (ArrayList) bVar.e.f36a;
        if (!arrayList.contains(y0Var)) {
            arrayList.add(y0Var);
        }
        this.f8071d = false;
        k3 k3Var = (k3) this.f7251b;
        View view = k3Var != null ? k3Var.f13077t : null;
        if (view != null) {
            view.setVisibility(4);
        }
        k3 k3Var2 = (k3) this.f7251b;
        if (k3Var2 != null) {
            k3Var2.f13071m.setOnClickListener(this);
        }
        k3 k3Var3 = (k3) this.f7251b;
        if (k3Var3 != null) {
            k3Var3.f13065g.setOnClickListener(this);
        }
        k3 k3Var4 = (k3) this.f7251b;
        if (k3Var4 != null) {
            k3Var4.f13066h.setOnClickListener(this);
        }
        k3 k3Var5 = (k3) this.f7251b;
        if (k3Var5 != null) {
            k3Var5.f13073o.setOnClickListener(this);
        }
        k3 k3Var6 = (k3) this.f7251b;
        if (k3Var6 != null) {
            k3Var6.f13074p.setOnClickListener(this);
        }
        k3 k3Var7 = (k3) this.f7251b;
        if (k3Var7 != null) {
            k3Var7.f13075q.setOnClickListener(this);
        }
        k3 k3Var8 = (k3) this.f7251b;
        if (k3Var8 != null) {
            k3Var8.r.setOnClickListener(this);
        }
        k3 k3Var9 = (k3) this.f7251b;
        if (k3Var9 != null) {
            k3Var9.f13076s.setOnClickListener(this);
        }
        k3 k3Var10 = (k3) this.f7251b;
        if (k3Var10 != null) {
            k3Var10.f13064f.setOnSeekBarChangeListener(new l(this));
        }
        eb.e eVar = i6.f.f14366f;
        boolean z5 = eVar.r().c() != null;
        Log.e("qob", "BluetoothHelper isConnected " + z5 + " isDeviceConnected " + com.example.test.service.e.h().i());
        if (eVar.r().c() != null) {
            return;
        }
        eVar.r().a(r5.b.k().f18057g);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.rl_hs_ota;
        if (valueOf != null && valueOf.intValue() == i3) {
            k3 k3Var = (k3) this.f7251b;
            if (k3Var == null || k3Var.f13077t.getVisibility() != 0) {
                return;
            }
            if (this.f8073g < 35) {
                Toast.makeText(getContext(), R$string.headset_ota_battery_limit35, 1).show();
            } else {
                V();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.example.test.ui.main.fragment.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        HeadsetFragment this$0 = HeadsetFragment.this;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        this$0.b0();
                        this$0.q0().show();
                    }
                }, 5000L);
            }
            Object obj = com.example.test.service.p0.f7741g;
            this.f8072f = m1.a().d();
            ((p0) X()).f7544d = this.f8070c;
            TextView textView = q0().f7962c;
            if (textView == null) {
                kotlin.jvm.internal.e.m("otaCurrentVersion");
                throw null;
            }
            textView.setText("当前版本: V" + ((p0) X()).e);
            TextView textView2 = q0().f7963d;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("otaNewVersion");
                throw null;
            }
            FirmwareInfoBean firmwareInfoBean = this.f8072f;
            if (firmwareInfoBean == null) {
                kotlin.jvm.internal.e.m("bean");
                throw null;
            }
            textView2.setText("最新版本: V" + firmwareInfoBean.getToVersion());
            FirmwareInfoBean firmwareInfoBean2 = this.f8072f;
            if (firmwareInfoBean2 == null) {
                kotlin.jvm.internal.e.m("bean");
                throw null;
            }
            Log.e("qob", "initView " + firmwareInfoBean2.getDownloadUrl());
            return;
        }
        int i10 = R$id.tv_hs_navlist;
        if (valueOf != null && valueOf.intValue() == i10) {
            eh.b bVar = this.f8075i;
            ((r) bVar.getValue()).b(R$string.str_device_unbind_tips);
            ((r) bVar.getValue()).setOnDialogListener(new n(this, 7));
            ((r) bVar.getValue()).show();
            return;
        }
        int i11 = R$id.rl_hs_finddev;
        if (valueOf != null && valueOf.intValue() == i11) {
            ((com.example.test.ui.dialog.f) this.f8076j.getValue()).show();
            return;
        }
        int i12 = R$id.rl_hs_ota;
        if (valueOf != null && valueOf.intValue() == i12) {
            Toast.makeText(f0(), R$string.str_is_latest_version, 1).show();
            return;
        }
        int i13 = R$id.view_hs_eq_click1;
        if (valueOf != null && valueOf.intValue() == i13) {
            xd.a a3 = tb.a(new byte[]{90, -91, 53, 5, 0});
            k6.b bVar2 = this.f8070c;
            if (bVar2 != null) {
                bVar2.i(a3, null);
            }
            k3 k3Var2 = (k3) this.f7251b;
            if (k3Var2 != null) {
                k3Var2.f13061b.setImageResource(R$mipmap.hs_equalizer_bg1);
                return;
            }
            return;
        }
        int i14 = R$id.view_hs_eq_click2;
        if (valueOf != null && valueOf.intValue() == i14) {
            xd.a a10 = tb.a(new byte[]{90, -91, 53, 5, 1});
            k6.b bVar3 = this.f8070c;
            if (bVar3 != null) {
                bVar3.i(a10, null);
            }
            k3 k3Var3 = (k3) this.f7251b;
            if (k3Var3 != null) {
                k3Var3.f13061b.setImageResource(R$mipmap.hs_equalizer_bg2);
                return;
            }
            return;
        }
        int i15 = R$id.view_hs_eq_click3;
        if (valueOf != null && valueOf.intValue() == i15) {
            xd.a a11 = tb.a(new byte[]{90, -91, 53, 5, 2});
            k6.b bVar4 = this.f8070c;
            if (bVar4 != null) {
                bVar4.i(a11, null);
            }
            k3 k3Var4 = (k3) this.f7251b;
            if (k3Var4 != null) {
                k3Var4.f13061b.setImageResource(R$mipmap.hs_equalizer_bg3);
                return;
            }
            return;
        }
        int i16 = R$id.view_hs_eq_click4;
        if (valueOf != null && valueOf.intValue() == i16) {
            xd.a a12 = tb.a(new byte[]{90, -91, 53, 5, 3});
            k6.b bVar5 = this.f8070c;
            if (bVar5 != null) {
                bVar5.i(a12, null);
            }
            k3 k3Var5 = (k3) this.f7251b;
            if (k3Var5 != null) {
                k3Var5.f13061b.setImageResource(R$mipmap.hs_equalizer_bg4);
                return;
            }
            return;
        }
        int i17 = R$id.view_hs_eq_click5;
        if (valueOf != null && valueOf.intValue() == i17) {
            xd.a a13 = tb.a(new byte[]{90, -91, 53, 5, 4});
            k6.b bVar6 = this.f8070c;
            if (bVar6 != null) {
                bVar6.i(a13, null);
            }
            k3 k3Var6 = (k3) this.f7251b;
            if (k3Var6 != null) {
                k3Var6.f13061b.setImageResource(R$mipmap.hs_equalizer_bg5);
            }
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Log.e("qob", "HeadsetFragment onDestroy");
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceFirmwareInfoEvent(EventBusBeans.FirmwareEvent firmwareEvent) {
        kotlin.jvm.internal.e.f(firmwareEvent, "firmwareEvent");
        Log.e("qob", "onDeviceFirmwareInfoEvent " + firmwareEvent.getStatus());
        if (firmwareEvent.getStatus() == 11) {
            Object obj = com.example.test.service.p0.f7741g;
            this.f8072f = m1.a().d();
            if (!q0().isShowing()) {
                q0().show();
            }
            ((p0) X()).f7544d = this.f8070c;
            com.example.test.ui.dialog.g q02 = q0();
            ((ImageView) q02.findViewById(R$id.iv_find_close)).setVisibility(8);
            t6.e eVar = q02.f7960a;
            if (eVar != null) {
                eVar.a(100, 0);
            }
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        Log.e("qob", "HeadsetFragment onDeviceStatusEvent " + deviceStatusEvent.getStatus());
        int status = deviceStatusEvent.getStatus();
        eb.e eVar = i6.f.f14366f;
        if (status == 0) {
            eVar.r().b(r5.b.k().f18057g);
            return;
        }
        if (status != 1) {
            return;
        }
        k3 k3Var = (k3) this.f7251b;
        TextView textView = k3Var != null ? k3Var.f13070l : null;
        if (textView != null) {
            textView.setText(getString(R$string.str_connecting));
        }
        if (eVar.r().c() != null) {
            return;
        }
        eVar.r().a(r5.b.k().f18057g);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onFirmUpgradeEvent(EventBusBeans.FirmwareEvent firmwareEvent) {
        View view;
        String downloadUrl;
        kotlin.jvm.internal.e.f(firmwareEvent, "firmwareEvent");
        if (firmwareEvent.getStatus() == 11) {
            b0();
            return;
        }
        b0();
        if (firmwareEvent.getFirmwareInfoBean() == null || (downloadUrl = firmwareEvent.getFirmwareInfoBean().getDownloadUrl()) == null || downloadUrl.length() == 0) {
            k3 k3Var = (k3) this.f7251b;
            view = k3Var != null ? k3Var.f13077t : null;
            if (view == null) {
                return;
            }
            view.setVisibility(4);
            return;
        }
        k3 k3Var2 = (k3) this.f7251b;
        view = k3Var2 != null ? k3Var2.f13077t : null;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Log.e("qob", "HeadsetFragment onStart");
        b2.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        Log.e("qob", "HeadsetFragment onStop");
        b2.b(this);
    }

    public final com.example.test.ui.dialog.g q0() {
        return (com.example.test.ui.dialog.g) this.f8077k.getValue();
    }

    public final void s() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OtaActivity", "-----固件安装成功----");
        q0().a().setProgress(100.0f);
        q0().a().setText("100%");
        y.u().G();
        com.example.baselibrary.utils.d.a(R$string.str_upgrade_success);
        b0();
        k6.b bVar = this.f8070c;
        if (bVar != null) {
            bVar.P();
        }
        this.f8070c = null;
        com.example.test.service.e.h().getClass();
        com.example.test.service.e.h().f7682a = true;
        com.example.test.service.e.h().n();
        q0().dismiss();
        Object obj = com.example.test.service.p0.f7741g;
        m1.a().i();
        yh.d.b().e(new EventBusBeans.FirmwareEvent(-1, null));
    }

    public final void u0(float f2) {
        String concat = String.format("%s: %.2f", Arrays.copyOf(new Object[]{getString(R$string.str_ota_check_file), Float.valueOf(((double) f2) > 99.8d ? 100.0f : f2)}, 2)).concat("%");
        q0().a().setProgress(f2);
        q0().a().setText(concat);
    }
}
