package com.example.test.utils;

import android.content.Intent;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.impl.d1;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.main.activity.SplashSelectActivity;
import com.example.test.ui.mine.activity.LoginActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class w0 implements i6.h {

    /* renamed from: b, reason: collision with root package name */
    public static w0 f8765b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8766a;

    public w0(int i3) {
        switch (i3) {
            case 4:
                this.f8766a = ((StillCaptureFlashStopRepeatingQuirk) p.a.f17285a.f(StillCaptureFlashStopRepeatingQuirk.class)) != null;
                break;
            case 5:
                this.f8766a = p.a.f17285a.f(TorchIsClosedAfterImageCapturingQuirk.class) != null;
                break;
            default:
                this.f8766a = z.a.f20181a.f(SurfaceOrderQuirk.class) != null;
                break;
        }
    }

    public static androidx.camera.core.impl.d0 a(androidx.camera.core.impl.d0 d0Var) {
        androidx.camera.core.impl.c0 c0Var = new androidx.camera.core.impl.c0();
        c0Var.f1356c = d0Var.f1368c;
        Iterator it = Collections.unmodifiableList(d0Var.f1366a).iterator();
        while (it.hasNext()) {
            c0Var.f1354a.add((androidx.camera.core.impl.g0) it.next());
        }
        c0Var.c(d0Var.f1367b);
        androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
        f2.m(m.b.Y(CaptureRequest.FLASH_MODE), 0);
        c0Var.c(new m.b(d1.a(f2), 12));
        return c0Var.d();
    }

    public static XXBaseActivity b() {
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a();
        if (j1.a().c() == null || !(j1.a().c() instanceof XXBaseActivity)) {
            return null;
        }
        return (XXBaseActivity) j1.a().c();
    }

    public static int c(int i3) {
        if (i3 == 1010) {
            return R$string.str_account_not_exist_login;
        }
        if (i3 == 1011) {
            return R$string.str_account_password_incorrect;
        }
        if (i3 == 1020) {
            return R$string.str_account_exist;
        }
        if (i3 == 1021) {
            return R$string.str_old_pw_error;
        }
        if (i3 == 1022 || i3 == 1024) {
            return R$string.str_verify_error;
        }
        if (i3 == 1023 || i3 == 1025) {
            return R$string.str_verify_overdue;
        }
        if (i3 == 1028) {
            return R$string.str_verify_format;
        }
        if (i3 == 1029) {
            return R$string.str_error_family_not_find;
        }
        if (i3 == 1030) {
            return R$string.str_error_family_already_friend;
        }
        if (i3 == 1031) {
            return R$string.str_error_family_already_apply;
        }
        if (i3 == 1032) {
            return R$string.str_error_family_not_myself;
        }
        if (i3 == 1026) {
            return R$string.code_sent_too_frequently;
        }
        return 0;
    }

    public static w0 d() {
        if (f8765b == null) {
            synchronized (w0.class) {
                f8765b = new w0();
            }
        }
        return f8765b;
    }

    public static boolean e() {
        return b() != null && LoginActivity.class.getName().equals(b().getClass().getName());
    }

    public static boolean g() {
        if (d6.a.f12304c == null) {
            synchronized (d6.a.class) {
                d6.a.f12304c = new d6.a();
            }
        }
        d6.a aVar = d6.a.f12304c;
        if (aVar == null) {
            return false;
        }
        if (aVar == null) {
            synchronized (d6.a.class) {
                d6.a.f12304c = new d6.a();
            }
        }
        return d6.a.f12304c.f12305a == 2;
    }

    public static void i() {
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a();
        b().startActivity(new Intent(b(), (Class<?>) SplashSelectActivity.class));
        j1.a().b(SplashSelectActivity.class.getName());
    }

    public boolean f(ArrayList arrayList, boolean z5) {
        if (this.f8766a && z5) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                Integer num = (Integer) ((CaptureRequest) obj).get(CaptureRequest.FLASH_MODE);
                if (num != null && num.intValue() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean h(ArrayList arrayList, boolean z5) {
        if (this.f8766a && z5) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                int intValue = ((Integer) ((CaptureRequest) obj).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
                if (intValue == 2 || intValue == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // i6.h
    public void j(Object obj) {
        i6.i callback = (i6.i) obj;
        kotlin.jvm.internal.e.f(callback, "callback");
        callback.a(this.f8766a);
    }
}
