package com.amap.api.col.p0003sl;

import android.content.Context;

/* loaded from: classes.dex */
public class v9 {

    /* renamed from: c, reason: collision with root package name */
    private static v9 f5197c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5198a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5199b = ba.a(n9.b("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private v9(Context context) {
        this.f5198a = context.getApplicationContext();
    }

    public static v9 a(Context context) {
        if (f5197c == null) {
            synchronized (v9.class) {
                try {
                    if (f5197c == null) {
                        f5197c = new v9(context);
                    }
                } finally {
                }
            }
        }
        return f5197c;
    }

    public final void a(String str) {
        w9.a(this.f5198a).a(this.f5199b);
        w9.a(this.f5198a).b(str);
    }

    public final synchronized void a() {
        try {
            if (f9.e == null) {
                int i3 = aa.f3618h;
                z9 z9Var = new z9();
                if (f9.e == null) {
                    f9.e = z9Var;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
