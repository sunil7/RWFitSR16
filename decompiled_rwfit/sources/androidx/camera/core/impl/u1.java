package androidx.camera.core.impl;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class u1 implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f1497h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Executor f1498a;

    /* renamed from: b, reason: collision with root package name */
    public final a1 f1499b;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f1501d;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f1500c = new AtomicBoolean(true);
    public Object e = f1497h;

    /* renamed from: f, reason: collision with root package name */
    public int f1502f = -1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1503g = false;

    public u1(AtomicReference atomicReference, Executor executor, a1 a1Var) {
        this.f1501d = atomicReference;
        this.f1498a = executor;
        this.f1499b = a1Var;
    }

    public final void a(int i3) {
        synchronized (this) {
            try {
                if (this.f1500c.get()) {
                    if (i3 <= this.f1502f) {
                        return;
                    }
                    this.f1502f = i3;
                    if (this.f1503g) {
                        return;
                    }
                    this.f1503g = true;
                    try {
                        this.f1498a.execute(this);
                    } catch (Throwable unused) {
                        synchronized (this) {
                            this.f1503g = false;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this) {
            try {
                if (!this.f1500c.get()) {
                    this.f1503g = false;
                    return;
                }
                Object obj = this.f1501d.get();
                int i3 = this.f1502f;
                while (true) {
                    if (!Objects.equals(this.e, obj)) {
                        this.e = obj;
                        if (obj instanceof g) {
                            a1 a1Var = this.f1499b;
                            ((g) obj).getClass();
                            a1Var.onError(null);
                        } else {
                            this.f1499b.a(obj);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (i3 == this.f1502f || !this.f1500c.get()) {
                                break;
                            }
                            obj = this.f1501d.get();
                            i3 = this.f1502f;
                        } finally {
                        }
                    }
                }
                this.f1503g = false;
            } finally {
            }
        }
    }
}
