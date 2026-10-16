package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public abstract class y5 {
    public static void a() {
        pd.f("Not in application's main thread", b());
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void c(Runnable runnable) {
        if (b()) {
            runnable.run();
        } else {
            pd.f("Unable to post to main thread", new Handler(Looper.getMainLooper()).post(runnable));
        }
    }
}
