package com.example.test.presenter.device;

import android.util.Log;
import com.example.test.ui.device.activity.OtaActivity;

/* loaded from: classes.dex */
public final class x0 implements rd.d {

    /* renamed from: a, reason: collision with root package name */
    public final f7.u f7494a;

    /* renamed from: b, reason: collision with root package name */
    public final z0 f7495b;

    public x0(f7.u view, z0 presenter) {
        kotlin.jvm.internal.e.f(view, "view");
        kotlin.jvm.internal.e.f(presenter, "presenter");
        this.f7494a = view;
        this.f7495b = presenter;
    }

    @Override // rd.d
    public final void a(androidx.recyclerview.widget.x xVar) {
        Log.e("qob", "onError " + xVar);
        if (xVar != null) {
            OtaActivity otaActivity = (OtaActivity) this.f7494a;
            otaActivity.E = false;
            otaActivity.runOnUiThread(new com.example.test.ui.device.activity.w(otaActivity, 1));
        }
    }

    @Override // rd.d
    public final void d() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.V(false);
        }
        OtaActivity otaActivity = (OtaActivity) this.f7494a;
        otaActivity.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OtaActivity", "-----固件安装成功----");
        otaActivity.runOnUiThread(new com.example.test.ui.device.activity.w(otaActivity, 0));
    }

    @Override // rd.d
    public final void f(float f2, int i3) {
        if (i3 == 0) {
            ((OtaActivity) this.f7494a).R0(f2);
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null ? kotlin.jvm.internal.e.a(kVar.q(), Boolean.FALSE) : false) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                kVar2.V(true);
            }
        }
        ((OtaActivity) this.f7494a).E(f2);
    }

    @Override // rd.d
    public final void h() {
        Log.e("qob", "onCancelOTA");
    }

    @Override // rd.d
    public final void s() {
        Log.e("qob", "onStartOTA");
        ((OtaActivity) this.f7494a).R0(0.0f);
    }

    @Override // rd.d
    public final void t(String str, boolean z5) {
        Log.e("qob", "onNeedReconnect " + z5);
        kotlin.jvm.internal.e.c(str);
        this.f7495b.getClass();
        Log.e("qob", "change addr before : ".concat(str));
        byte[] a3 = ee.a.a(str);
        byte b3 = a3[a3.length - 1];
        char[] cArr = ee.b.f12595a;
        a3[a3.length - 1] = (byte) ((b3 & 255) + 1);
        StringBuilder sb2 = new StringBuilder();
        if (a3.length == 6) {
            for (int i3 = 0; i3 < a3.length; i3++) {
                int i10 = (a3[i3] & 255) >> 4;
                char[] cArr2 = ee.a.f12594a;
                sb2.append(cArr2[i10]);
                sb2.append(cArr2[a3[i3] & 15]);
                if (i3 != a3.length - 1) {
                    sb2.append(":");
                }
            }
        }
        Log.e("qob", "change addr after: " + sb2.toString());
        i6.f r = i6.f.f14366f.r();
        if (r.f14368a.a()) {
            r.f14369b.getClass();
            ee.c.b(2, "o", "reconnectDevice : address = " + str + ", isUseAdv = true");
        }
    }
}
