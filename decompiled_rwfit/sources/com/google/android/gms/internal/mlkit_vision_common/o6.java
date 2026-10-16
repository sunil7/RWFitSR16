package com.google.android.gms.internal.mlkit_vision_common;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class o6 {
    public static void a(int i3, Object obj, Exception exc, String str, Object... objArr) {
        if (i3 >= 5) {
            String concat = "FileDownloader.".concat((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
            int i10 = ye.e.f20123a;
            Log.println(i3, concat, String.format(Locale.ENGLISH, str, objArr));
            if (exc != null) {
                exc.printStackTrace();
            }
        }
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(5, obj, null, str, objArr);
    }
}
