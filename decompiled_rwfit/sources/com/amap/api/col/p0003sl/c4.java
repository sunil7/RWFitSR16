package com.amap.api.col.p0003sl;

import android.content.Context;
import android.util.Log;
import com.amap.api.map3d.R;

/* loaded from: classes.dex */
public class c4 {

    /* renamed from: a, reason: collision with root package name */
    static String f3806a;

    static {
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < 80; i3++) {
            sb2.append("=");
        }
        f3806a = sb2.toString();
    }

    public static void a() {
        String a3 = n1.a(R.string.O105492_282);
        Log.i("authErrLog", f3806a);
        Log.i("authErrLog", a3);
        Log.i("authErrLog", f3806a);
    }

    public static void b(String str) {
        if (str.length() >= 78) {
            Log.i("authErrLog", "|" + str.substring(0, 78) + "|");
            b(str.substring(78));
            return;
        }
        StringBuilder sb2 = new StringBuilder("|");
        sb2.append(str);
        for (int i3 = 0; i3 < 78 - str.length(); i3++) {
            sb2.append(" ");
        }
        sb2.append("|");
        Log.i("authErrLog", sb2.toString());
    }

    public static void a(String str) {
        Log.i("authErrLog", f3806a);
        Log.i("authErrLog", str);
        Log.i("authErrLog", f3806a);
    }

    public static void a(Context context, String str) {
        Log.i("authErrLog", f3806a);
        if (context != null) {
            b("key:" + b9.e(context));
        }
        Log.i("authErrLog", str);
        Log.i("authErrLog", f3806a);
    }
}
