package com.amap.api.col.p0003sl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class u7 {

    /* renamed from: c, reason: collision with root package name */
    private static volatile u7 f5145c;

    /* renamed from: a, reason: collision with root package name */
    private BlockingQueue<Runnable> f5146a = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f5147b;

    private u7() {
        this.f5147b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f5147b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1, TimeUnit.SECONDS, this.f5146a, new ThreadPoolExecutor.AbortPolicy());
    }

    public static void a() {
        if (f5145c != null) {
            synchronized (u7.class) {
                try {
                    if (f5145c != null) {
                        f5145c.f5147b.shutdownNow();
                        f5145c.f5147b = null;
                        f5145c = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static u7 b() {
        if (f5145c == null) {
            synchronized (u7.class) {
                try {
                    if (f5145c == null) {
                        f5145c = new u7();
                    }
                } finally {
                }
            }
        }
        return f5145c;
    }

    public void a(Runnable runnable) {
        ExecutorService executorService = this.f5147b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
