package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.os.Build;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class k0 {
    public static Context a(Context context) {
        int c9;
        Context applicationContext = context.getApplicationContext();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34 && (c9 = androidx.camera.core.impl.a0.c(context)) != androidx.camera.core.impl.a0.c(applicationContext)) {
            applicationContext = androidx.camera.core.impl.a0.a(applicationContext, c9);
        }
        if (i3 >= 30) {
            String b3 = n1.a.b(context);
            if (!Objects.equals(b3, n1.a.b(applicationContext))) {
                return n1.a.a(applicationContext, b3);
            }
        }
        return applicationContext;
    }
}
