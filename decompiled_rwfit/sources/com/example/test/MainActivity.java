package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.u0;
import com.example.baselibrary.utils.e;
import com.example.database.table.User;
import com.example.test.presenter.main.z0;
import com.example.test.service.g1;
import com.example.test.ui.RingBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.MainBottomTabView;
import com.example.test.ui.view.NoScrollViewPager;
import com.example.test.utils.k;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ee;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.p1;
import f6.r0;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.ThreadMode;
import u6.p;
import yh.d;

/* loaded from: classes.dex */
public final class MainActivity extends RingBaseActivity<z0, r0> implements e7.b, o5.a {
    public static final /* synthetic */ int J = 0;
    public final eh.b C = kotlin.a.b(new oh.a() { // from class: com.example.test.MainActivity$loginPlatform$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = MainActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("login_platform", 0) : 0);
        }
    });
    public final eh.b D = kotlin.a.b(new oh.a() { // from class: com.example.test.MainActivity$isNeedInfo$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = MainActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("is_need_info", false) : false);
        }
    });
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.MainActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final e invoke() {
            return new e(MainActivity.this);
        }
    });
    public p F;
    public NoScrollViewPager G;
    public long H;
    public boolean I;

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new z0(this);
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((r0) this.f7249z.getValue()).f13271a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_main, (ViewGroup) null, false);
        int i3 = R$id.mainTabView;
        MainBottomTabView mainBottomTabView = (MainBottomTabView) he.a(i3, inflate);
        if (mainBottomTabView != null) {
            i3 = R$id.view_pager;
            if (((NoScrollViewPager) he.a(i3, inflate)) != null) {
                return new r0((LinearLayout) inflate, mainBottomTabView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void K0() {
        ((z0) I0()).k(((Number) this.C.getValue()).intValue(), ((Boolean) this.D.getValue()).booleanValue());
        ((z0) I0()).l();
        Object obj = g1.e;
        p1.a().o(true);
    }

    @Override // com.example.baselibrary.base.activity.RBaseActivity
    public final void L0() {
        b2.a(this);
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a().b(MainActivity.class.getName());
        u0 C0 = C0();
        kotlin.jvm.internal.e.e(C0, "getSupportFragmentManager(...)");
        this.F = new p(this, C0);
        View findViewById = findViewById(R$id.view_pager);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.G = (NoScrollViewPager) findViewById;
        S0().setCanScroll(false);
        S0().setAdapter(R0());
        S0().setOffscreenPageLimit(4);
        ((r0) this.f7249z.getValue()).f13272b.setViewPager(S0());
        R0().n();
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        if (kVar != null ? kotlin.jvm.internal.e.a(kVar.q(), Boolean.TRUE) : false) {
            Log.e("qob", "getJLOTAFileFailed");
            S0().setCurrentItem(0);
        }
        char[] cArr = y5.b.f20001a;
        Log.e("qob", "Brand " + Build.BRAND + " Model " + Build.MODEL);
    }

    public final p R0() {
        p pVar = this.F;
        if (pVar != null) {
            return pVar;
        }
        kotlin.jvm.internal.e.m("mainPagerAdapter");
        throw null;
    }

    public final NoScrollViewPager S0() {
        NoScrollViewPager noScrollViewPager = this.G;
        if (noScrollViewPager != null) {
            return noScrollViewPager;
        }
        kotlin.jvm.internal.e.m("mainViewPager");
        throw null;
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // e7.b
    public final void i(User user) {
        d.b().e(user);
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

    @Override // com.example.test.ui.RingBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.e("qob", "MainActivity onDestroy");
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceConnectEvent(EventBusBeans.DeviceConnectEvent deviceConnectEvent) {
        kotlin.jvm.internal.e.f(deviceConnectEvent, "deviceConnectEvent");
        this.I = true;
        ((e) this.E.getValue()).postDelayed(new androidx.activity.b(this, 16), 500L);
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
        String str = com.dh.keeplive.a.f7201c;
        ee.a().getClass();
        boolean c9 = com.dh.keeplive.ext.a.c(this);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "MainActivity", r5.a.d("onResume keepLiveIsRunning = ", c9));
        if (c9) {
            return;
        }
        com.example.test.service.e.h().n();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.e("qob", "MainActivity onStop");
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
