package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.UUID;

/* loaded from: classes.dex */
public class u9 {

    /* renamed from: b, reason: collision with root package name */
    private static u9 f5148b;

    /* renamed from: a, reason: collision with root package name */
    private String f5149a;

    private u9(Context context) {
        context.getApplicationContext();
        try {
            this.f5149a = UUID.randomUUID().toString().replaceAll("-", "");
        } catch (Throwable unused) {
        }
    }

    public static u9 a(Context context) {
        if (context == null) {
            return null;
        }
        if (f5148b == null) {
            synchronized (u9.class) {
                try {
                    if (f5148b == null) {
                        f5148b = new u9(context);
                    }
                } finally {
                }
            }
        }
        return f5148b;
    }

    public String a() {
        return this.f5149a;
    }
}
