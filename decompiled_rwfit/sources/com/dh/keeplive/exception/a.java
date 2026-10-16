package com.dh.keeplive.exception;

import android.os.Process;
import eh.b;
import java.lang.Thread;
import kotlin.jvm.internal.e;
import kotlin.text.m;

/* loaded from: classes.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: b, reason: collision with root package name */
    public static final b f7207b = kotlin.a.b(new oh.a() { // from class: com.dh.keeplive.exception.KeepLiveUncaughtExceptionHandler$Companion$instance$2
        @Override // oh.a
        public final a invoke() {
            return new a();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f7208a = Thread.getDefaultUncaughtExceptionHandler();

    public a() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread t8, Throwable e) {
        e.f(t8, "t");
        e.f(e, "e");
        String message = e.getMessage();
        if (message != null && (m.c(message, "Bad notification for startForeground: java.lang.RuntimeException: invalid channel for service notification", false) || m.c(message, "Context.startForegroundService() did not then call Service.startForeground()", false))) {
            Process.killProcess(Process.myPid());
            System.exit(10);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7208a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t8, e);
        }
    }
}
