package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.pc;
import java.lang.Thread;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class qc extends sc {

    /* renamed from: d, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f4931d = new a();
    private static qc e = new qc(new pc.a().a(f4931d).a("amap-global-threadPool").a());

    public static class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th2) {
            ka.a(th2, "TPool", "ThreadPool");
        }
    }

    private qc(pc pcVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(pcVar.c(), pcVar.e(), pcVar.d(), TimeUnit.SECONDS, pcVar.f(), pcVar);
            this.f5047a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th2) {
            ka.a(th2, "TPool", "ThreadPool");
            th2.printStackTrace();
        }
    }

    public static qc a(pc pcVar) {
        return new qc(pcVar);
    }

    @Deprecated
    public static qc c() {
        return new qc(new pc.a().a(f4931d).a());
    }

    public static qc d() {
        return e;
    }

    @Deprecated
    public static synchronized qc e() {
        qc qcVar;
        synchronized (qc.class) {
            try {
                if (e == null) {
                    e = new qc(new pc.a().a(f4931d).a());
                }
                qcVar = e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return qcVar;
    }
}
