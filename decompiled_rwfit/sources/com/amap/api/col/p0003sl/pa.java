package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.HashMap;

/* loaded from: classes.dex */
public class pa {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f4828a = new HashMap<>();

    public static void a(Context context, m9 m9Var, String str, String str2) {
        if (m9Var == null || TextUtils.isEmpty(m9Var.d())) {
            return;
        }
        StringBuilder t8 = l0.t(str);
        t8.append(m9Var.d());
        String sb2 = t8.toString();
        f4828a.put(m9Var.d() + str, str2);
        if (context == null || TextUtils.isEmpty(sb2) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String b3 = n9.b(z8.b(n9.e(str2)));
        SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(sb2, b3);
        edit.commit();
    }

    public static String a(Context context, m9 m9Var, String str) {
        if (m9Var == null || TextUtils.isEmpty(m9Var.d())) {
            return null;
        }
        String str2 = f4828a.get(m9Var.d() + str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        StringBuilder t8 = l0.t(str);
        t8.append(m9Var.d());
        String sb2 = t8.toString();
        return (context == null || TextUtils.isEmpty(sb2)) ? "" : n9.c(z8.a(n9.c(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(sb2, ""))));
    }
}
