package com.example.test.ui.testui;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.SwitchBean;
import com.example.network.bean.UserInfoBean;
import com.example.test.MainActivity;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.ScanQrMlActivity;
import com.example.test.ui.device.adapter.DeviceScanAdapter;
import com.example.test.ui.device.model.BleDeviceModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.RadarView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.google.android.material.navigation.NavigationView;
import f6.k1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingDeviceScanActivity extends XXBaseActivity<com.example.test.presenter.device.u, k1> implements f7.f, View.OnClickListener {
    public static final /* synthetic */ int O = 0;
    public int H;
    public final eh.b M;
    public final eh.b N;
    public final String E = "TRingDeviceScanActivity";
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$loginPlatform$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = TRingDeviceScanActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("login_platform", 0) : 0);
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$isNeedInfo$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = TRingDeviceScanActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("is_need_info", false) : false);
        }
    });
    public s5.a I = new s5.a();
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$permissionTipDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.i invoke() {
            TRingDeviceScanActivity tRingDeviceScanActivity = TRingDeviceScanActivity.this;
            tRingDeviceScanActivity.getClass();
            com.example.test.ui.dialog.i iVar = new com.example.test.ui.dialog.i(tRingDeviceScanActivity, 2);
            iVar.setOnDialogListener(new t(TRingDeviceScanActivity.this, 2));
            iVar.setCancelable(false);
            return iVar;
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$deviceAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final DeviceScanAdapter invoke() {
            TRingDeviceScanActivity tRingDeviceScanActivity = TRingDeviceScanActivity.this;
            int i3 = TRingDeviceScanActivity.O;
            return new DeviceScanAdapter(tRingDeviceScanActivity.T0());
        }
    });
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$devices$2
        @Override // oh.a
        public final List<BleDeviceModel> invoke() {
            return new ArrayList();
        }
    });

    public TRingDeviceScanActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$loadingDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.h invoke() {
                TRingDeviceScanActivity tRingDeviceScanActivity = TRingDeviceScanActivity.this;
                tRingDeviceScanActivity.getClass();
                com.example.test.ui.dialog.h hVar = new com.example.test.ui.dialog.h(tRingDeviceScanActivity);
                hVar.c(8);
                return hVar;
            }
        });
        this.M = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$gpsTipsDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.r invoke() {
                TRingDeviceScanActivity tRingDeviceScanActivity = TRingDeviceScanActivity.this;
                tRingDeviceScanActivity.getClass();
                com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(tRingDeviceScanActivity);
                rVar.b(R$string.str_gps_open);
                rVar.setOnDialogListener(new t(TRingDeviceScanActivity.this, 1));
                return rVar;
            }
        });
        this.N = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceScanActivity$bleTipsDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.r invoke() {
                TRingDeviceScanActivity tRingDeviceScanActivity = TRingDeviceScanActivity.this;
                tRingDeviceScanActivity.getClass();
                com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(tRingDeviceScanActivity);
                rVar.b(R$string.str_ble_open);
                rVar.setOnDialogListener(new t(TRingDeviceScanActivity.this, 0));
                return rVar;
            }
        });
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.u(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        DrawerLayout drawerLayout = ((k1) this.f7247z.getValue()).f13048a;
        kotlin.jvm.internal.e.e(drawerLayout, "getRoot(...)");
        return drawerLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View a3;
        View inflate = getLayoutInflater().inflate(R$layout.activity_ring_device_scan, (ViewGroup) null, false);
        int i3 = R$id.deviceList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            DrawerLayout drawerLayout = (DrawerLayout) inflate;
            i3 = R$id.iv_hs_refresh;
            ImageView imageView = (ImageView) he.a(i3, inflate);
            if (imageView != null) {
                i3 = R$id.iv_hs_scan_icon;
                ImageView imageView2 = (ImageView) he.a(i3, inflate);
                if (imageView2 != null) {
                    i3 = R$id.iv_menu;
                    ImageView imageView3 = (ImageView) he.a(i3, inflate);
                    if (imageView3 != null) {
                        i3 = R$id.iv_search;
                        ImageView imageView4 = (ImageView) he.a(i3, inflate);
                        if (imageView4 != null && (a3 = he.a((i3 = R$id.iv_search_bg), inflate)) != null) {
                            i3 = R$id.iv_top_qcode;
                            ImageView imageView5 = (ImageView) he.a(i3, inflate);
                            if (imageView5 != null) {
                                i3 = R$id.nav_view;
                                NavigationView navigationView = (NavigationView) he.a(i3, inflate);
                                if (navigationView != null) {
                                    i3 = R$id.radarView1;
                                    RadarView radarView = (RadarView) he.a(i3, inflate);
                                    if (radarView != null) {
                                        i3 = R$id.rl_hs_unbind;
                                        if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                            i3 = R$id.rl_radar;
                                            if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                                i3 = R$id.rl_title;
                                                if (((RelativeLayout) he.a(i3, inflate)) != null) {
                                                    i3 = R$id.tv_hs_scan_title;
                                                    TextView textView = (TextView) he.a(i3, inflate);
                                                    if (textView != null) {
                                                        i3 = R$id.tv_hs_unbind_tip;
                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                            i3 = R$id.tv_hs_unbind_title;
                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                i3 = R$id.tv_search;
                                                                if (((TextView) he.a(i3, inflate)) != null) {
                                                                    i3 = R$id.tv_title;
                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                        return new k1(drawerLayout, recyclerView, drawerLayout, imageView, imageView2, imageView3, imageView4, a3, imageView5, navigationView, radarView, textView);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        String birthday;
        Log.e("qob", "TRingDeviceScanActivity initData");
        com.example.test.presenter.device.u uVar = (com.example.test.presenter.device.u) I0();
        boolean booleanValue = ((Boolean) this.G.getValue()).booleanValue();
        int intValue = ((Number) this.F.getValue()).intValue();
        uVar.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        SwitchBean switchBean = null;
        User d5 = kVar != null ? kVar.d() : null;
        if (!booleanValue && d5 != null && (birthday = d5.getBirthday()) != null && birthday.length() != 0) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                ArrayList w8 = kVar2.w();
                int size = w8.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    Object obj = w8.get(i3);
                    i3++;
                    if (kotlin.jvm.internal.e.a(((SwitchBean) obj).getParaName(), "isPerson")) {
                        switchBean = obj;
                        break;
                    }
                }
                switchBean = switchBean;
            }
            if (switchBean != null && kotlin.jvm.internal.e.a(switchBean.getParaValue(), "0")) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "MainPresenter", "隐私开关个人信息已关闭");
                ((com.example.test.presenter.device.u) I0()).k();
            }
        }
        if (d5 != null) {
            ((f7.f) uVar.f7255a).i(d5);
        }
        rg.l<HttpModel<UserInfoBean>> userInfo = ((UserApi) c6.d.f3392c.f113a).getUserInfo();
        kotlin.jvm.internal.e.e(userInfo, "getUserInfo(...)");
        com.example.baselibrary.utils.b.w(userInfo).subscribe(new com.example.test.presenter.device.t(intValue, d5, uVar, ((f7.f) uVar.f7255a).f0(), com.example.test.utils.w0.d(), 0));
        ((com.example.test.presenter.device.u) I0()).k();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        com.example.baselibrary.utils.d.f7269b = this;
        com.example.baselibrary.utils.d.f7271d = Toast.makeText(this, "", 0);
        eh.b bVar = this.f7247z;
        k1 k1Var = (k1) bVar.getValue();
        if (k1Var != null) {
            k1Var.f13053g.setOnClickListener(this);
        }
        k1 k1Var2 = (k1) bVar.getValue();
        if (k1Var2 != null) {
            k1Var2.f13052f.setOnClickListener(this);
        }
        k1 k1Var3 = (k1) bVar.getValue();
        if (k1Var3 != null) {
            k1Var3.f13055i.setOnClickListener(this);
        }
        k1 k1Var4 = (k1) bVar.getValue();
        if (k1Var4 != null) {
            k1Var4.f13051d.setOnClickListener(this);
        }
        k1 k1Var5 = (k1) bVar.getValue();
        if (k1Var5 != null) {
            k1Var5.f13058l.setOnClickListener(this);
        }
        k1 k1Var6 = (k1) bVar.getValue();
        if (k1Var6 != null) {
            k1Var6.e.setOnClickListener(this);
        }
        k1 k1Var7 = (k1) bVar.getValue();
        RecyclerView recyclerView = k1Var7 != null ? k1Var7.f13049b : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
        }
        k1 k1Var8 = (k1) bVar.getValue();
        if (k1Var8 != null) {
            RecyclerView recyclerView2 = k1Var8.f13049b;
            n.g0 g0Var = new n.g0(this);
            g0Var.e(getResources().getColor(R.color.transparent));
            g0Var.o(R$dimen.qb_px_10);
            recyclerView2.g(g0Var.d());
        }
        k1 k1Var9 = (k1) bVar.getValue();
        RecyclerView recyclerView3 = k1Var9 != null ? k1Var9.f13049b : null;
        eh.b bVar2 = this.K;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter((DeviceScanAdapter) bVar2.getValue());
        }
        k1 k1Var10 = (k1) bVar.getValue();
        RecyclerView recyclerView4 = k1Var10 != null ? k1Var10.f13049b : null;
        if (recyclerView4 != null) {
            recyclerView4.setItemAnimator(null);
        }
        ((DeviceScanAdapter) bVar2.getValue()).setOnItemClickListener(new s(this, 3));
        ((k1) bVar.getValue()).f13056j.setItemIconTintList(null);
        ((k1) bVar.getValue()).f13056j.setNavigationItemSelectedListener(new s(this, 4));
        V0();
    }

    public final boolean R0() {
        XXApplication xXApplication = XXApplication.f7400h;
        boolean d5 = com.example.test.utils.t.d(j1.a());
        boolean n4 = com.example.baselibrary.utils.b.n(j1.a());
        if (!n4) {
            ((com.example.test.ui.dialog.r) this.N.getValue()).show();
            return n4;
        }
        if (!d5) {
            ((com.example.test.ui.dialog.r) this.M.getValue()).show();
        }
        return d5;
    }

    public final void S0() {
        eh.b bVar = this.f7247z;
        View e = ((k1) bVar.getValue()).f13050c.e(8388611);
        if (e != null ? DrawerLayout.m(e) : false) {
            ((k1) bVar.getValue()).f13050c.c();
        }
    }

    public final List T0() {
        return (List) this.L.getValue();
    }

    public final com.example.test.ui.dialog.i U0() {
        return (com.example.test.ui.dialog.i) this.J.getValue();
    }

    public final void V0() {
        String string;
        User d5;
        User d8;
        User d10;
        User d11;
        User d12;
        User d13;
        User d14;
        eh.b bVar = this.f7247z;
        ImageView imageView = (ImageView) ((k1) bVar.getValue()).f13056j.c().findViewById(R$id.iv_userheader);
        TextView textView = (TextView) ((k1) bVar.getValue()).f13056j.c().findViewById(R$id.tv_username);
        TextView textView2 = (TextView) ((k1) bVar.getValue()).f13056j.c().findViewById(R$id.tv_user_id);
        kotlin.jvm.internal.e.c(imageView);
        int i3 = R$mipmap.ic_header_default;
        com.example.test.utils.k a3 = y1.a();
        String str = null;
        String avatar = (a3 == null || (d14 = a3.d()) == null) ? null : d14.getAvatar();
        String str2 = "";
        if (avatar == null) {
            avatar = "";
        }
        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).n(avatar).o(true)).d(z3.h.f20239b)).i(i3), i3)).x(imageView);
        com.example.test.utils.k a10 = y1.a();
        String name = (a10 == null || (d13 = a10.d()) == null) ? null : d13.getName();
        if (name == null || name.length() == 0) {
            com.example.test.utils.k a11 = y1.a();
            String account = (a11 == null || (d8 = a11.d()) == null) ? null : d8.getAccount();
            if (account == null || account.length() == 0) {
                string = getString(R$string.str_unset);
            } else {
                com.example.test.utils.k a12 = y1.a();
                if (a12 != null && (d5 = a12.d()) != null) {
                    string = d5.getAccount();
                }
                string = null;
            }
        } else {
            com.example.test.utils.k a13 = y1.a();
            if (a13 != null && (d12 = a13.d()) != null) {
                string = d12.getName();
            }
            string = null;
        }
        textView.setText(string);
        com.example.test.utils.k a14 = y1.a();
        if (((a14 == null || (d11 = a14.d()) == null) ? null : d11.getUserId()) != null) {
            com.example.test.utils.k a15 = y1.a();
            if (a15 != null && (d10 = a15.d()) != null) {
                str = d10.getUserId();
            }
            String valueOf = String.valueOf(str);
            if (Pattern.compile("\\d+").matcher(valueOf).matches()) {
                str2 = "ID:".concat(valueOf);
            }
        }
        textView2.setText(str2);
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // f7.f
    public final void i(User user) {
        yh.d.b().e(user);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.iv_search;
        eh.b bVar = this.f7247z;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (R0()) {
                if (!nd.c.j(this, android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"))) {
                    this.H = 1;
                    U0().b(2);
                    U0().show();
                    return;
                }
                T0().clear();
                ((DeviceScanAdapter) this.K.getValue()).notifyDataSetChanged();
                ((com.example.test.presenter.device.u) I0()).getClass();
                com.example.test.presenter.device.u.l();
                k1 k1Var = (k1) bVar.getValue();
                View view2 = k1Var != null ? k1Var.f13054h : null;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                k1 k1Var2 = (k1) bVar.getValue();
                if (k1Var2 != null) {
                    k1Var2.f13057k.b();
                    return;
                }
                return;
            }
            return;
        }
        int i10 = R$id.iv_menu;
        if (valueOf != null && valueOf.intValue() == i10) {
            Log.d("tong", "click iv_menu");
            View e = ((k1) bVar.getValue()).f13050c.e(8388611);
            if (e != null ? DrawerLayout.m(e) : false) {
                return;
            }
            V0();
            ((k1) bVar.getValue()).f13050c.p();
            return;
        }
        int i11 = R$id.iv_top_qcode;
        if (valueOf != null && valueOf.intValue() == i11) {
            Log.d("tong", "click iv_qcoder");
            if (R0()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.CAMERA");
                arrayList.addAll(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                if (nd.c.j(this, arrayList)) {
                    startActivity(new Intent(this, (Class<?>) ScanQrMlActivity.class));
                    return;
                }
                Log.d("tong", "no permissions");
                this.H = 2;
                U0().b(3);
                U0().show();
                return;
            }
            return;
        }
        int i12 = R$id.iv_hs_scan_icon;
        if (valueOf != null && valueOf.intValue() == i12 && R0()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("android.permission.CAMERA");
            arrayList2.addAll(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
            if (nd.c.j(this, arrayList2)) {
                startActivity(new Intent(this, (Class<?>) ScanQrMlActivity.class));
                return;
            }
            this.H = 2;
            U0().b(3);
            U0().show();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.e("qob", "TRingDeviceScanActivity onDestroy");
        b0();
        ((com.example.test.presenter.device.u) I0()).getClass();
        com.example.test.presenter.device.u.m();
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status != 1) {
            if (status == 2) {
                Log.e("qob", "TRingDeviceScanActivity DEVICE_CONNECTING");
                return;
            }
            if (status == 3) {
                Log.e("qob", "TRingDeviceScanActivity DEVICE_BINDING");
                Q0(R$string.str_binding);
                return;
            } else if (status == 4) {
                b0();
                return;
            } else if (status != 5) {
                b0();
                return;
            } else {
                b0();
                return;
            }
        }
        Log.e("qob", "TRingDeviceScanActivity DEVICE_CONNECTED");
        b0();
        s5.a aVar = this.I;
        if (aVar == null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.Y(0);
            }
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        } else if (aVar.f18215g == 4) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                kVar2.Y(1);
            }
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar3 = com.example.test.utils.k.f8731b;
            if (kVar3 != null) {
                kVar3.c0();
            }
            startActivity(new Intent(this, (Class<?>) TMainRingActivity.class));
        } else {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar4 = com.example.test.utils.k.f8731b;
            if (kVar4 != null) {
                kVar4.Y(0);
            }
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Log.e("qob", "TRingDeviceScanActivity onResume");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        Log.e("qob", "TRingDeviceScanActivity onStart");
        com.example.test.service.e.h().f7690j = true;
        b2.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.e("qob", "TRingDeviceScanActivity onStop");
        b2.b(this);
    }

    @Override // f7.f
    public final void s0() {
        eh.b bVar = this.f7247z;
        RadarView radarView = ((k1) bVar.getValue()).f13057k;
        Log.i("RadarView", "stop radar");
        radarView.f8542n = false;
        radarView.removeCallbacks(radarView.f8545q);
        ((k1) bVar.getValue()).f13054h.setVisibility(0);
    }

    @Override // f7.f
    public final void y0(BleDeviceModel bleDeviceModel) {
        Object obj;
        Iterator it = T0().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            BleDeviceModel bleDeviceModel2 = (BleDeviceModel) obj;
            if (kotlin.jvm.internal.e.a(bleDeviceModel2.getMac(), bleDeviceModel.getMac()) && kotlin.jvm.internal.e.a(bleDeviceModel2.getName(), bleDeviceModel.getName())) {
                break;
            }
        }
        BleDeviceModel bleDeviceModel3 = (BleDeviceModel) obj;
        if (bleDeviceModel3 != null) {
            T0().remove(bleDeviceModel3);
        }
        T0().add(bleDeviceModel);
        List T0 = T0();
        if (T0.size() > 1) {
            kotlin.collections.m.h(T0, new androidx.viewpager2.widget.a(5));
        }
        ((DeviceScanAdapter) this.K.getValue()).notifyItemRangeChanged(0, T0().size());
    }
}
