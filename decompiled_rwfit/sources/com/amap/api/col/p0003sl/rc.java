package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public abstract class rc implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    a f4961g;

    public interface a {
    }

    public final void cancelTask() {
        try {
            a aVar = this.f4961g;
            if (aVar != null) {
                sc.this.a(this, true);
            }
        } catch (Throwable th2) {
            ka.a(th2, "ThreadTask", "cancelTask");
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (Thread.interrupted()) {
                return;
            }
            runTask();
            if (Thread.interrupted() || (aVar = this.f4961g) == null) {
                return;
            }
            sc.this.a(this, false);
        } catch (Throwable th2) {
            ka.a(th2, "ThreadTask", "run");
            th2.printStackTrace();
        }
    }

    public abstract void runTask();
}
