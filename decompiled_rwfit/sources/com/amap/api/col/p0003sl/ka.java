package com.amap.api.col.p0003sl;

import android.content.Context;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ka extends ga implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;

    /* renamed from: g, reason: collision with root package name */
    private static WeakReference<Context> f4427g;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f4429i = 0;

    /* renamed from: d, reason: collision with root package name */
    private Context f4430d;

    /* renamed from: f, reason: collision with root package name */
    private static Set<Integer> f4426f = Collections.synchronizedSet(new HashSet());

    /* renamed from: h, reason: collision with root package name */
    private static final ThreadFactory f4428h = new a();

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4431a = new AtomicInteger(1);

        /* renamed from: com.amap.api.col.3sl.ka$a$a, reason: collision with other inner class name */
        public class C0005a extends Thread {
            public C0005a(a aVar, Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new C0005a(this, runnable, "pama#" + this.f4431a.getAndIncrement());
        }
    }

    private ka(Context context) {
        this.f4430d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f4211a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f4212b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f4212b = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f4212b = true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[Catch: all -> 0x0028, TryCatch #1 {all -> 0x0028, blocks: (B:9:0x0014, B:11:0x0018, B:13:0x0020, B:15:0x0024, B:16:0x002a), top: B:8:0x0014, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void c() {
        /*
            java.lang.Class<com.amap.api.col.3sl.ka> r0 = com.amap.api.col.p0003sl.ka.class
            monitor-enter(r0)
            java.util.concurrent.ExecutorService r1 = com.amap.api.col.p0003sl.ka.e     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto Ld
            r1.shutdown()     // Catch: java.lang.Throwable -> Lb
            goto Ld
        Lb:
            r1 = move-exception
            goto L11
        Ld:
            com.amap.api.col.p0003sl.fb.d()     // Catch: java.lang.Throwable -> Lb
            goto L14
        L11:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L34
        L14:
            com.amap.api.col.3sl.ga r1 = com.amap.api.col.p0003sl.ga.f4210c     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L2a
            java.lang.Thread$UncaughtExceptionHandler r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> L28
            com.amap.api.col.3sl.ga r2 = com.amap.api.col.p0003sl.ga.f4210c     // Catch: java.lang.Throwable -> L28
            if (r1 != r2) goto L2a
            java.lang.Thread$UncaughtExceptionHandler r1 = r2.f4211a     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L2a
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r1)     // Catch: java.lang.Throwable -> L28
            goto L2a
        L28:
            r1 = move-exception
            goto L2f
        L2a:
            r1 = 0
            com.amap.api.col.p0003sl.ga.f4210c = r1     // Catch: java.lang.Throwable -> L28
            monitor-exit(r0)
            return
        L2f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L34
            monitor-exit(r0)
            return
        L34:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ka.c():void");
    }

    public static void d() {
        WeakReference<Context> weakReference = f4427g;
        if (weakReference != null && weakReference.get() != null) {
            ha.a(f4427g.get());
            return;
        }
        ga gaVar = ga.f4210c;
        if (gaVar != null) {
            ha.a(((ka) gaVar).f4430d);
        }
    }

    public void b(Throwable th2, String str, String str2) {
        if (th2 == null) {
            return;
        }
        try {
            la.a(this.f4430d, th2, 1, str, str2);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        if (th2 == null) {
            return;
        }
        la.a(this.f4430d, th2, 0, (String) null, (String) null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4211a;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f4211a.uncaughtException(thread, th2);
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            f4427g = new WeakReference<>(context.getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    public static synchronized ka a(Context context, m9 m9Var) throws a9 {
        synchronized (ka.class) {
            if (m9Var != null) {
                if (m9Var.d() != null && !"".equals(m9Var.d())) {
                    try {
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (!f4426f.add(Integer.valueOf(m9Var.hashCode()))) {
                        return (ka) ga.f4210c;
                    }
                    ga gaVar = ga.f4210c;
                    if (gaVar == null) {
                        ga.f4210c = new ka(context);
                    } else {
                        gaVar.f4212b = false;
                    }
                    ga gaVar2 = ga.f4210c;
                    boolean z5 = gaVar2.f4212b;
                    try {
                        qc.d().b(new ja((ka) gaVar2, m9Var, z5));
                    } catch (RejectedExecutionException unused) {
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return (ka) ga.f4210c;
                }
                throw new a9("sdk name is invalid");
            }
            throw new a9("sdk info is null");
        }
    }

    @Deprecated
    public static synchronized ExecutorService b() {
        ExecutorService executorService;
        synchronized (ka.class) {
            try {
                ExecutorService executorService2 = e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f4428h);
                }
            } catch (Throwable unused) {
            }
            executorService = e;
        }
        return executorService;
    }

    @Override // com.amap.api.col.p0003sl.ga
    public final void a(Throwable th2, int i3, String str, String str2) {
        la.a(this.f4430d, th2, i3, str, str2);
    }

    public static void a(Throwable th2, String str, String str2) {
        try {
            ga gaVar = ga.f4210c;
            if (gaVar != null) {
                gaVar.a(th2, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(m9 m9Var, String str, String str2, String str3, String str4, String str5) {
        try {
            if (ga.f4210c != null) {
                la.a(m9Var, ((ka) ga.f4210c).f4430d, "networkError", "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(m9 m9Var, String str, String str2) {
        try {
            ga gaVar = ga.f4210c;
            if (gaVar != null) {
                la.a(m9Var, ((ka) gaVar).f4430d, str2, str);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized ka a() {
        ka kaVar;
        synchronized (ka.class) {
            kaVar = (ka) ga.f4210c;
        }
        return kaVar;
    }
}
