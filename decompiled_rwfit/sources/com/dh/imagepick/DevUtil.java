package com.dh.imagepick;

import android.util.Log;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class DevUtil {
    public static final DevUtil INSTANCE = new DevUtil();
    private static boolean isDebug;

    private DevUtil() {
    }

    public final void d(String tag, String str) {
        e.f(tag, "tag");
        if (isDebug) {
            if (str == null) {
                str = "";
            }
            Log.d(tag, str);
        }
    }

    public final void e(String tag, String str) {
        e.f(tag, "tag");
        if (isDebug) {
            if (str == null) {
                str = "";
            }
            Log.e(tag, str);
        }
    }

    public final void i(String tag, String str) {
        e.f(tag, "tag");
        if (isDebug) {
            if (str == null) {
                str = "";
            }
            Log.i(tag, str);
        }
    }

    public final boolean isDebug() {
        return isDebug;
    }

    public final void setDebug(boolean z5) {
        isDebug = z5;
    }

    public final void v(String tag, String str) {
        e.f(tag, "tag");
        if (isDebug) {
            if (str == null) {
                str = "";
            }
            Log.v(tag, str);
        }
    }

    public final void w(String tag, String str) {
        e.f(tag, "tag");
        if (isDebug) {
            if (str == null) {
                str = "";
            }
            Log.w(tag, str);
        }
    }
}
