package com.example.baselibrary.utils;

import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: b, reason: collision with root package name */
    public static ContextWrapper f7269b;

    /* renamed from: d, reason: collision with root package name */
    public static Toast f7271d;

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f7268a = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7270c = new Object();

    public static void a(int i3) {
        new Thread(new c(i3)).start();
    }

    public static void b(String str) {
        new Thread(new androidx.activity.e(str, 12)).start();
    }
}
