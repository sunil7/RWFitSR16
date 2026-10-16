package androidx.appcompat.app;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class j0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f511a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f512b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f513c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f514d;
    public Object e;

    public /* synthetic */ j0(Executor executor, com.example.test.ui.device.activity.f0 f0Var, com.example.test.ui.device.activity.f0 f0Var2, ia.g gVar) {
        this.f511a = 1;
        this.f512b = executor;
        this.f513c = f0Var;
        this.f514d = f0Var2;
        this.e = gVar;
    }

    public void a() {
        synchronized (this.f512b) {
            try {
                Runnable runnable = (Runnable) ((ArrayDeque) this.f513c).poll();
                this.e = runnable;
                if (runnable != null) {
                    ((k0) this.f514d).execute(runnable);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f511a) {
            case 0:
                synchronized (this.f512b) {
                    try {
                        ((ArrayDeque) this.f513c).add(new i0(0, this, runnable));
                        if (((Runnable) this.e) == null) {
                            a();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            default:
                try {
                    ((Executor) this.f512b).execute(runnable);
                    return;
                } catch (RuntimeException e) {
                    if (((ia.m) ((com.example.test.ui.device.activity.f0) this.f513c).f7859b).e()) {
                        ((com.example.test.ui.device.activity.f0) this.f514d).n();
                    } else {
                        ((ia.g) this.e).f14382a.g(e);
                    }
                    throw e;
                }
        }
    }

    public j0(k0 k0Var) {
        this.f511a = 0;
        this.f512b = new Object();
        this.f513c = new ArrayDeque();
        this.f514d = k0Var;
    }
}
