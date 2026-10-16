package yh;

import java.util.logging.Level;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final o4.e f20131a = new o4.e();

    /* renamed from: b, reason: collision with root package name */
    public final d f20132b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f20133c;

    public a(d dVar) {
        this.f20132b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j k10;
        while (true) {
            try {
                try {
                    o4.e eVar = this.f20131a;
                    synchronized (eVar) {
                        try {
                            if (((j) eVar.f16737a) == null) {
                                eVar.wait(1000);
                            }
                            k10 = eVar.k();
                        } finally {
                        }
                    }
                    if (k10 == null) {
                        synchronized (this) {
                            k10 = this.f20131a.k();
                            if (k10 == null) {
                                this.f20133c = false;
                                this.f20133c = false;
                                return;
                            }
                        }
                    }
                    this.f20132b.c(k10);
                } catch (InterruptedException e) {
                    this.f20132b.f20155p.l(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.f20133c = false;
                    return;
                }
            } catch (Throwable th2) {
                this.f20133c = false;
                throw th2;
            }
        }
    }
}
