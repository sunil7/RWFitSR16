package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f12096a;

    /* renamed from: b, reason: collision with root package name */
    private String f12097b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static f f12098a = new f();
    }

    public static f a() {
        return a.f12098a;
    }

    public String b(Context context) {
        return this.f12096a;
    }

    public String c(Context context) {
        return this.f12097b;
    }

    private f() {
        this.f12096a = "";
        this.f12097b = "";
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 0);
        String str = this.f12097b;
        if (str == null || str.trim().isEmpty()) {
            this.f12097b = sharedPreferences.getString("build_model", "");
        }
        String str2 = this.f12096a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.f12096a = sharedPreferences.getString("build_device", "");
        }
    }

    public String b() {
        return this.f12097b;
    }

    public void a(Context context, String str) {
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.f12097b;
            if (str2 == null || !str2.equals(str)) {
                this.f12097b = str;
                if (context != null) {
                    context.getSharedPreferences("device_info_file", 0).edit().putString("build_model", this.f12097b).apply();
                    return;
                }
                return;
            }
            return;
        }
        this.f12097b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 0).edit().remove("build_model").apply();
        }
    }
}
