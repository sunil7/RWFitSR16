package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class a6 {
    public static w.a a() {
        if (w.a.f19270b != null) {
            return w.a.f19270b;
        }
        synchronized (w.a.class) {
            try {
                if (w.a.f19270b == null) {
                    w.a.f19270b = new w.a(0);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return w.a.f19270b;
    }

    public static w.d b() {
        if (w.d.f19277c != null) {
            return w.d.f19277c;
        }
        synchronized (w.d.class) {
            try {
                if (w.d.f19277c == null) {
                    w.d.f19277c = new w.d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return w.d.f19277c;
    }

    public static w.e c() {
        if (w.e.f19280c != null) {
            return w.e.f19280c;
        }
        synchronized (w.e.class) {
            try {
                if (w.e.f19280c == null) {
                    w.e.f19280c = new w.e();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return w.e.f19280c;
    }

    public static w.c d() {
        if (w.f.f19283a != null) {
            return w.f.f19283a;
        }
        synchronized (w.f.class) {
            try {
                if (w.f.f19283a == null) {
                    w.f.f19283a = new w.c(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return w.f.f19283a;
    }
}
