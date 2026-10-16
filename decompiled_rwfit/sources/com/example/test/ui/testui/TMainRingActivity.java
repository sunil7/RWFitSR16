package com.example.test.ui.testui;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.blesdk.bean.function.BindInfoBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.service.g1;
import com.example.test.ui.RingBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.NoScrollViewPager;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.ee;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.p1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.google.android.material.navigation.NavigationView;
import f6.s2;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TMainRingActivity extends RingBaseActivity<com.example.test.presenter.main.z0, s2> implements e7.b, o5.a {
    public static final /* synthetic */ int J = 0;
    public final eh.b C = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TMainRingActivity$loginPlatform$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = TMainRingActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("login_platform", 0) : 0);
        }
    });
    public final eh.b D = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TMainRingActivity$isNeedInfo$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = TMainRingActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("is_need_info", false) : false);
        }
    });
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TMainRingActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(TMainRingActivity.this);
        }
    });
    public androidx.fragment.app.x0 F;
    public NoScrollViewPager G;
    public long H;
    public boolean I;

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.z0(this);
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final View H0() {
        DrawerLayout drawerLayout = ((s2) this.f7249z.getValue()).f13299a;
        kotlin.jvm.internal.e.e(drawerLayout, "getRoot(...)");
        return drawerLayout;
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_tring_main, (ViewGroup) null, false);
        int i3 = R$id.contentViewMain;
        View a3 = he.a(i3, inflate);
        if (a3 != null) {
            int i10 = R$id.mainTabView;
            TMainBottomTabView tMainBottomTabView = (TMainBottomTabView) he.a(i10, a3);
            if (tMainBottomTabView != null) {
                i10 = R$id.mainTabViewSleep;
                TMainBottomSleepTabView tMainBottomSleepTabView = (TMainBottomSleepTabView) he.a(i10, a3);
                if (tMainBottomSleepTabView != null) {
                    i10 = R$id.view_pager;
                    if (((NoScrollViewPager) he.a(i10, a3)) != null) {
                        de.o oVar = new de.o((LinearLayout) a3, 22, tMainBottomTabView, tMainBottomSleepTabView);
                        DrawerLayout drawerLayout = (DrawerLayout) inflate;
                        int i11 = R$id.nav_view;
                        NavigationView navigationView = (NavigationView) he.a(i11, inflate);
                        if (navigationView != null) {
                            return new s2(drawerLayout, oVar, drawerLayout, navigationView);
                        }
                        i3 = i11;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(a3.getResources().getResourceName(i10)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void K0() {
        ((com.example.test.presenter.main.z0) I0()).k(((Number) this.C.getValue()).intValue(), ((Boolean) this.D.getValue()).booleanValue());
        ((com.example.test.presenter.main.z0) I0()).l();
        Object obj = g1.e;
        p1.a().o(true);
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void L0() {
        b2.a(this);
        com.example.baselibrary.utils.d.f7269b = this;
        com.example.baselibrary.utils.d.f7271d = Toast.makeText(this, "", 0);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        BindInfoBean m10 = kVar != null ? kVar.m() : null;
        Log.e("qob", "getLocalSupport isPressure isSupportSleep " + (m10 != null ? Byte.valueOf(m10.getIsSleep()) : null));
        boolean z5 = true;
        if (m10 != null && m10.getIsSleep() != 1) {
            z5 = false;
        }
        View findViewById = findViewById(R$id.view_pager);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.G = (NoScrollViewPager) findViewById;
        T0().setCanScroll(false);
        if (z5) {
            androidx.fragment.app.u0 C0 = C0();
            kotlin.jvm.internal.e.e(C0, "getSupportFragmentManager(...)");
            this.F = new f0(this, C0, 0);
            T0().setOffscreenPageLimit(4);
            ((TMainBottomTabView) ((s2) this.f7249z.getValue()).f13300b.f12378c).setVisibility(0);
            ((TMainBottomSleepTabView) ((s2) this.f7249z.getValue()).f13300b.f12379d).setVisibility(8);
            ((TMainBottomTabView) ((s2) this.f7249z.getValue()).f13300b.f12378c).setViewPager(T0());
        } else {
            androidx.fragment.app.u0 C02 = C0();
            kotlin.jvm.internal.e.e(C02, "getSupportFragmentManager(...)");
            this.F = new f0(this, C02, 1);
            T0().setOffscreenPageLimit(3);
            ((TMainBottomTabView) ((s2) this.f7249z.getValue()).f13300b.f12378c).setVisibility(8);
            ((TMainBottomSleepTabView) ((s2) this.f7249z.getValue()).f13300b.f12379d).setVisibility(0);
            ((TMainBottomSleepTabView) ((s2) this.f7249z.getValue()).f13300b.f12379d).setViewPager(T0());
        }
        T0().setAdapter(S0());
        T0().addOnPageChangeListener(new h(this));
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 != null ? kotlin.jvm.internal.e.a(kVar2.q(), Boolean.TRUE) : false) {
            Log.e("qob", "getJLOTAFileFailed");
            T0().setCurrentItem(0);
        }
        ((s2) this.f7249z.getValue()).f13302d.setItemIconTintList(null);
        ((s2) this.f7249z.getValue()).f13302d.setNavigationItemSelectedListener(new af.a(this, 9));
        U0();
    }

    public final void R0() {
        eh.b bVar = this.f7249z;
        View e = ((s2) bVar.getValue()).f13301c.e(8388611);
        if (e != null ? DrawerLayout.m(e) : false) {
            ((s2) bVar.getValue()).f13301c.c();
        }
    }

    public final androidx.fragment.app.x0 S0() {
        androidx.fragment.app.x0 x0Var = this.F;
        if (x0Var != null) {
            return x0Var;
        }
        kotlin.jvm.internal.e.m("mainPagerAdapter");
        throw null;
    }

    public final NoScrollViewPager T0() {
        NoScrollViewPager noScrollViewPager = this.G;
        if (noScrollViewPager != null) {
            return noScrollViewPager;
        }
        kotlin.jvm.internal.e.m("mainViewPager");
        throw null;
    }

    public final void U0() {
        String string;
        User d5;
        User d8;
        User d10;
        User d11;
        User d12;
        User d13;
        User d14;
        User d15;
        User d16;
        eh.b bVar = this.f7249z;
        ImageView imageView = (ImageView) ((s2) bVar.getValue()).f13302d.c().findViewById(R$id.iv_userheader);
        TextView textView = (TextView) ((s2) bVar.getValue()).f13302d.c().findViewById(R$id.tv_username);
        TextView textView2 = (TextView) ((s2) bVar.getValue()).f13302d.c().findViewById(R$id.tv_user_id);
        kotlin.jvm.internal.e.c(imageView);
        int i3 = R$mipmap.ic_header_default;
        com.example.test.utils.k a3 = y1.a();
        String str = null;
        String avatar = (a3 == null || (d16 = a3.d()) == null) ? null : d16.getAvatar();
        String str2 = "";
        if (avatar == null) {
            avatar = "";
        }
        ((com.bumptech.glide.i) android.support.v4.media.session.e.x((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).n(avatar).o(true)).d(z3.h.f20239b)).i(i3), i3)).x(imageView);
        com.example.test.utils.k a10 = y1.a();
        Log.d("tong", "user name = " + ((a10 == null || (d15 = a10.d()) == null) ? null : d15.getName()));
        com.example.test.utils.k a11 = y1.a();
        Log.d("tong", "user account = " + ((a11 == null || (d14 = a11.d()) == null) ? null : d14.getAccount()));
        com.example.test.utils.k a12 = y1.a();
        String name = (a12 == null || (d13 = a12.d()) == null) ? null : d13.getName();
        if (name == null || name.length() == 0) {
            com.example.test.utils.k a13 = y1.a();
            String account = (a13 == null || (d8 = a13.d()) == null) ? null : d8.getAccount();
            if (account == null || account.length() == 0) {
                string = getString(R$string.str_unset);
            } else {
                com.example.test.utils.k a14 = y1.a();
                if (a14 != null && (d5 = a14.d()) != null) {
                    string = d5.getAccount();
                }
                string = null;
            }
        } else {
            com.example.test.utils.k a15 = y1.a();
            if (a15 != null && (d12 = a15.d()) != null) {
                string = d12.getName();
            }
            string = null;
        }
        textView.setText(string);
        com.example.test.utils.k a16 = y1.a();
        if (((a16 == null || (d11 = a16.d()) == null) ? null : d11.getUserId()) != null) {
            com.example.test.utils.k a17 = y1.a();
            if (a17 != null && (d10 = a17.d()) != null) {
                str = d10.getUserId();
            }
            String valueOf = String.valueOf(str);
            if (Pattern.compile("\\d+").matcher(valueOf).matches()) {
                str2 = "ID:".concat(valueOf);
            }
        }
        textView2.setText(str2);
    }

    public final void V0(String str) {
        Object systemService = getSystemService("notification");
        kotlin.jvm.internal.e.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationChannel notificationChannel = new NotificationChannel("channel_id", "Important notice", 4);
        notificationChannel.setDescription("Application important message notification");
        notificationManager.createNotificationChannel(notificationChannel);
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) TMainRingActivity.class), 67108864);
        y0.l lVar = new y0.l(this, "channel_id");
        lVar.r.icon = R$mipmap.ic_logo;
        lVar.e = y0.l.b(getString(R$string.str_title_reminder_real_time));
        lVar.f19882f = y0.l.b(str);
        lVar.f19883g = activity;
        lVar.c(16, true);
        lVar.f19885i = 1;
        lVar.r.when = System.currentTimeMillis();
        notificationManager.notify(1001, lVar.a());
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // e7.b
    public final void i(User user) {
        yh.d.b().e(user);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        long j4 = this.H;
        if (j4 == 0 || (j4 > 0 && System.currentTimeMillis() - this.H > 5000)) {
            w0(R$string.str_back_desktop_tips);
            this.H = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - this.H <= 5000) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onChangeBackToFrontEvent(EventBusBeans.ChangeBackToFrontEvent changeBackToFrontEvent) {
        kotlin.jvm.internal.e.f(changeBackToFrontEvent, "changeBackToFrontEvent");
        ((com.example.baselibrary.utils.e) this.E.getValue()).post(new g(this, 2));
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onChangeThemeEvent(EventBusBeans.ChangeThemeEvent changeThemeEvent) {
        kotlin.jvm.internal.e.f(changeThemeEvent, "changeThemeEvent");
        Log.e("tong", "update theme = " + P0() + " count " + S0().c());
        ((com.example.baselibrary.utils.e) this.E.getValue()).post(new g(this, 0));
    }

    @Override // com.example.test.ui.RingBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "TMainRingActivity", "onDestroy");
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceConnectEvent(EventBusBeans.DeviceConnectEvent deviceConnectEvent) {
        kotlin.jvm.internal.e.f(deviceConnectEvent, "deviceConnectEvent");
        this.I = true;
        ((com.example.baselibrary.utils.e) this.E.getValue()).postDelayed(new g(this, 1), 500L);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            if (this.I) {
                b0();
                this.I = false;
            }
            XXApplication xXApplication = XXApplication.f7400h;
            j1.a().f();
            return;
        }
        if (status != 2) {
            if (status == 3) {
                if (this.I) {
                    Q0(R$string.str_binding);
                    return;
                }
                return;
            }
            if (status == 4) {
                if (this.I) {
                    b0();
                    this.I = false;
                    return;
                }
                return;
            }
            if (status == 5) {
                if (this.I) {
                    b0();
                    this.I = false;
                    return;
                }
                return;
            }
            if (this.I) {
                b0();
                this.I = false;
            }
            XXApplication xXApplication2 = XXApplication.f7400h;
            XXApplication a3 = j1.a();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", "XXApplication keepLiveUnRegister");
            WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
            String str = com.dh.keeplive.a.f7201c;
            ee.a().getClass();
            com.dh.keeplive.a.a(a3);
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onHrBoActualReminderEvent(EventBusBeans.HrBoActualReminderEvent hrBoActualReminderEvent) {
        kotlin.jvm.internal.e.f(hrBoActualReminderEvent, "hrBoActualReminderEvent");
        try {
            if (hrBoActualReminderEvent.getHrBoActualReminderBean() != null) {
                if (hrBoActualReminderEvent.getHrBoActualReminderBean().getType() == 0) {
                    String string = getString(R$string.str_hr_reminder_real_time);
                    kotlin.jvm.internal.e.e(string, "getString(...)");
                    String r = kotlin.text.m.r(string, "｛｝", hrBoActualReminderEvent.getHrBoActualReminderBean().getRemindValue() + "bpm");
                    V0(r);
                    com.example.baselibrary.utils.d.b(r);
                }
                if (hrBoActualReminderEvent.getHrBoActualReminderBean().getType() == 1) {
                    String string2 = getString(R$string.str_bo_reminder_real_time);
                    kotlin.jvm.internal.e.e(string2, "getString(...)");
                    String r8 = kotlin.text.m.r(string2, "｛｝", hrBoActualReminderEvent.getHrBoActualReminderBean().getRemindValue() + "%");
                    V0(r8);
                    com.example.baselibrary.utils.d.b(r8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            if (message != null) {
                Log.d("onHrBoActualReminderEvent", message);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
        String str = com.dh.keeplive.a.f7201c;
        ee.a().getClass();
        boolean c9 = com.dh.keeplive.ext.a.c(this);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "TMainRingActivity", r5.a.d("onResume keepLiveIsRunning = ", c9));
        if (c9) {
            return;
        }
        com.example.test.service.e.h().n();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "TMainRingActivity", "onStop");
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncStatusEvent(EventBusBeans.SyncStatusEvent syncStatusEvent) {
        kotlin.jvm.internal.e.f(syncStatusEvent, "syncStatusEvent");
        com.example.test.presenter.main.z0 z0Var = (com.example.test.presenter.main.z0) I0();
        z0Var.getClass();
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (supportMenuBean != null ? supportMenuBean.isNewSport() : false) {
            com.example.test.presenter.main.y0 bleDataCallback = (com.example.test.presenter.main.y0) z0Var.f7587c.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            if (!r5.b.k().f18054c) {
                x5.b.I0().F0((byte) 71);
                return;
            }
            x5.c b3 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getControlSportCmdJLData");
            b3.g((byte) 71, new byte[]{6, 4, 16, 0}, new boolean[0]);
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
    }

    @Override // e7.b
    public final void z() {
        com.example.baselibrary.utils.d.a(R$string.str_network_error);
    }
}
