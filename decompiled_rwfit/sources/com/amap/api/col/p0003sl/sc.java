package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.rc;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class sc {

    /* renamed from: a, reason: collision with root package name */
    protected ThreadPoolExecutor f5047a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<rc, Future<?>> f5048b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected rc.a f5049c = new a();

    public class a implements rc.a {
        public a() {
        }
    }

    public final synchronized boolean a(rc rcVar) {
        boolean z5;
        try {
            z5 = this.f5048b.containsKey(rcVar);
        } catch (Throwable th2) {
            ka.a(th2, "TPool", "contain");
            th2.printStackTrace();
            z5 = false;
        }
        return z5;
    }

    public void b(rc rcVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (a(rcVar) || (threadPoolExecutor = this.f5047a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        rcVar.f4961g = this.f5049c;
        try {
            Future<?> submit = this.f5047a.submit(rcVar);
            if (submit == null) {
                return;
            }
            synchronized (this) {
                try {
                    this.f5048b.put(rcVar, submit);
                } finally {
                }
            }
        } catch (RejectedExecutionException e) {
            ka.a(e, "TPool", "addTask");
        }
    }

    public final synchronized void a(rc rcVar, boolean z5) {
        try {
            Future<?> remove = this.f5048b.remove(rcVar);
            if (z5 && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th2) {
            ka.a(th2, "TPool", "removeQueue");
            th2.printStackTrace();
        }
    }

    public void a(long j4, TimeUnit timeUnit) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f5047a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j4, timeUnit);
            }
        } catch (InterruptedException unused) {
        }
    }

    public Executor b() {
        return this.f5047a;
    }

    public void a() {
        try {
            Iterator<Map.Entry<rc, Future<?>>> it = this.f5048b.entrySet().iterator();
            while (it.hasNext()) {
                Future<?> future = this.f5048b.get(it.next().getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.f5048b.clear();
        } catch (Throwable th2) {
            ka.a(th2, "TPool", "destroy");
            th2.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.f5047a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
