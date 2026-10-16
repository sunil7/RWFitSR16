package androidx.camera.core.impl;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class a0 {
    public static Context a(Context context, int i3) {
        return context.createDeviceContext(i3);
    }

    public static int b(Context context) {
        return context.getDeviceId();
    }

    public static int c(Context context) {
        return context.getDeviceId();
    }
}
