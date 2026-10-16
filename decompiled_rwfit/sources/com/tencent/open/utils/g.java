package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static Context f12099a;

    public static final Context a() {
        Context context = f12099a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context a3 = a();
        if (a3 != null) {
            return a3.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        f12099a = context;
    }

    public static final File a(String str) {
        return m.h(a(), str);
    }
}
