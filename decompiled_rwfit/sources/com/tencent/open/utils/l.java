package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    private static Handler f12114c;

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f12115d;

    /* renamed from: b, reason: collision with root package name */
    private static Object f12113b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f12112a = c();

    public static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final Queue<Runnable> f12116a;

        /* renamed from: b, reason: collision with root package name */
        Runnable f12117b;

        private a() {
            this.f12116a = new LinkedList();
        }

        public synchronized void a() {
            Runnable poll = this.f12116a.poll();
            this.f12117b = poll;
            if (poll != null) {
                l.f12112a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f12116a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f12117b == null) {
                a();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            f12112a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static Handler a() {
        if (f12114c == null) {
            synchronized (l.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f12115d = handlerThread;
                handlerThread.start();
                f12114c = new Handler(f12115d.getLooper());
            }
        }
        return f12114c;
    }

    public static Executor b() {
        return new a();
    }
}
