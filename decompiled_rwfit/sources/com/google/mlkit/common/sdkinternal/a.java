package com.google.mlkit.common.sdkinternal;

import android.os.HandlerThread;
import android.os.Looper;
import c5.b;
import ia.g;
import ia.m;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import x.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f11200b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static a f11201c;

    /* renamed from: a, reason: collision with root package name */
    public final b f11202a;

    public a(Looper looper) {
        b bVar = new b(looper, 1, false);
        Looper.getMainLooper();
        this.f11202a = bVar;
    }

    public static a a() {
        a aVar;
        synchronized (f11200b) {
            try {
                if (f11201c == null) {
                    HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                    handlerThread.start();
                    f11201c = new a(handlerThread.getLooper());
                }
                aVar = f11201c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public static m b(Callable callable) {
        g gVar = new g();
        zzh.zza.execute(new h(22, callable, gVar));
        return gVar.f14382a;
    }

    public static Executor c() {
        return zzh.zza;
    }
}
