package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f8844a;

    /* renamed from: b, reason: collision with root package name */
    public static String f8845b;

    static {
        new StringBuilder(r5.a.a(57, Build.VERSION.RELEASE));
        f8844a = new HashSet();
        f8845b = "goog.exo.core";
    }

    public static synchronized void a(String str) {
        synchronized (f.class) {
            if (f8844a.add(str)) {
                String str2 = f8845b;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 2 + str.length());
                sb2.append(str2);
                sb2.append(", ");
                sb2.append(str);
                f8845b = sb2.toString();
            }
        }
    }
}
