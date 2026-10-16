package com.example.test.ui.main.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.example.baselibrary.utils.e;
import com.example.database.table.User;
import com.example.test.MainActivity;
import com.example.test.R$layout;
import com.example.test.presenter.device.n;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.e0;
import com.example.test.ui.dialog.s;
import com.example.test.ui.testui.TMainRingActivity;
import com.example.test.ui.testui.TRingDeviceScanActivity;
import com.example.test.utils.k;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import eh.b;
import f6.k2;
import p5.a;

/* loaded from: classes.dex */
public final class StartActivity extends XXBaseActivity<n, k2> implements a, o5.a, View.OnClickListener {
    public static final /* synthetic */ int G = 0;
    public final b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.activity.StartActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final e invoke() {
            return new e(StartActivity.this);
        }
    });
    public final b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.activity.StartActivity$protocolDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final s invoke() {
            s sVar = new s(StartActivity.this);
            sVar.setOnDialogListener(new e0(StartActivity.this, 6));
            sVar.setCancelable(false);
            return sVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new n(this, 11);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((k2) this.f7247z.getValue()).f13059a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_start, (ViewGroup) null, false);
        if (inflate != null) {
            return new k2((ConstraintLayout) inflate);
        }
        throw new NullPointerException("rootView");
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        Boolean bool;
        if (getIntent() != null && (getIntent().getFlags() & 4194304) != 0) {
            finish();
            return;
        }
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        boolean z5 = false;
        if (kVar != null && (bool = (Boolean) kVar.i("is_init_launcher", Boolean.TYPE)) != null) {
            z5 = bool.booleanValue();
        }
        if (z5) {
            ((e) this.E.getValue()).sendEmptyMessageDelayed(1, Const.L_MAX_WAIT_WIFI);
        } else {
            ((s) this.F.getValue()).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // o5.a
    public final void r0(Message message) {
        String str;
        kotlin.jvm.internal.e.f(message, "message");
        ((e) this.E.getValue()).removeCallbacksAndMessages(null);
        k a3 = y1.a();
        if (a3 != null) {
            str = (String) a3.i("user_login_token", String.class);
            if (str == null) {
                str = "";
            }
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            startActivity(new Intent(this, (Class<?>) SplashSelectActivity.class));
        } else {
            if (d6.a.f12304c == null) {
                synchronized (d6.a.class) {
                    d6.a.f12304c = new d6.a();
                }
            }
            d6.a aVar = d6.a.f12304c;
            if (aVar != null) {
                aVar.f12306b = str;
            }
            k a10 = y1.a();
            User d5 = a10 != null ? a10.d() : null;
            if (d5 != null) {
                if (d6.a.f12304c == null) {
                    synchronized (d6.a.class) {
                        d6.a.f12304c = new d6.a();
                    }
                }
                d6.a aVar2 = d6.a.f12304c;
                if (aVar2 != null) {
                    aVar2.f12305a = d5.getPlatform();
                }
            }
            k a11 = y1.a();
            if (a11 == null || a11.c() == null) {
                startActivity(new Intent(this, (Class<?>) TRingDeviceScanActivity.class));
            } else {
                k a12 = y1.a();
                Integer valueOf = a12 != null ? Integer.valueOf(a12.x()) : null;
                if (valueOf != null && valueOf.intValue() == 1) {
                    k a13 = y1.a();
                    if (a13 != null) {
                        a13.c0();
                    }
                    int platform = d5 != null ? d5.getPlatform() : 0;
                    Intent intent = new Intent(this, (Class<?>) TMainRingActivity.class);
                    intent.putExtra("login_platform", platform);
                    intent.putExtra("is_need_info", false);
                    startActivity(intent);
                } else {
                    int platform2 = d5 != null ? d5.getPlatform() : 0;
                    Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
                    intent2.putExtra("login_platform", platform2);
                    intent2.putExtra("is_need_info", false);
                    startActivity(intent2);
                }
            }
        }
        finish();
    }
}
