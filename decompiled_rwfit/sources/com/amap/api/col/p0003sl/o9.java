package com.amap.api.col.p0003sl;

import android.content.Context;

/* loaded from: classes.dex */
public class o9 {

    /* renamed from: a, reason: collision with root package name */
    private static o9 f4777a;

    private o9(Context context) {
    }

    public static o9 a(Context context) {
        if (f4777a == null) {
            synchronized (o9.class) {
                try {
                    if (f4777a == null) {
                        f4777a = new o9(context);
                    }
                } finally {
                }
            }
        }
        return f4777a;
    }
}
