package androidx.lifecycle;

import android.os.Looper;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f2402k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f2403a;

    /* renamed from: b, reason: collision with root package name */
    public final j.f f2404b;

    /* renamed from: c, reason: collision with root package name */
    public int f2405c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2406d;
    public volatile Object e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f2407f;

    /* renamed from: g, reason: collision with root package name */
    public int f2408g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2409h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2410i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.activity.e f2411j;

    public y(Object obj) {
        this.f2403a = new Object();
        this.f2404b = new j.f();
        this.f2405c = 0;
        this.f2407f = f2402k;
        this.f2411j = new androidx.activity.e(this, 5);
        this.e = obj;
        this.f2408g = 0;
    }

    public static void a(String str) {
        i.a.a().f14329a.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(x xVar) {
        if (xVar.f2399b) {
            if (!xVar.e()) {
                xVar.a(false);
                return;
            }
            int i3 = xVar.f2400c;
            int i10 = this.f2408g;
            if (i3 >= i10) {
                return;
            }
            xVar.f2400c = i10;
            xVar.f2398a.i(this.e);
        }
    }

    public final void c(x xVar) {
        if (this.f2409h) {
            this.f2410i = true;
            return;
        }
        this.f2409h = true;
        do {
            this.f2410i = false;
            if (xVar != null) {
                b(xVar);
                xVar = null;
            } else {
                j.f fVar = this.f2404b;
                fVar.getClass();
                j.d dVar = new j.d(fVar);
                fVar.f15160c.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((x) ((Map.Entry) dVar.next()).getValue());
                    if (this.f2410i) {
                        break;
                    }
                }
            }
        } while (this.f2410i);
        this.f2409h = false;
    }

    public Object d() {
        Object obj = this.e;
        if (obj != f2402k) {
            return obj;
        }
        return null;
    }

    public final void e(s sVar, c0 c0Var) {
        a("observe");
        if (((u) sVar.getLifecycle()).f2390b == Lifecycle$State.DESTROYED) {
            return;
        }
        LiveData$LifecycleBoundObserver liveData$LifecycleBoundObserver = new LiveData$LifecycleBoundObserver(this, sVar, c0Var);
        x xVar = (x) this.f2404b.c(c0Var, liveData$LifecycleBoundObserver);
        if (xVar != null && !xVar.d(sVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (xVar != null) {
            return;
        }
        sVar.getLifecycle().a(liveData$LifecycleBoundObserver);
    }

    public final void f(c0 c0Var) {
        a("observeForever");
        w wVar = new w(this, c0Var);
        x xVar = (x) this.f2404b.c(c0Var, wVar);
        if (xVar instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (xVar != null) {
            return;
        }
        wVar.a(true);
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Object obj) {
        boolean z5;
        synchronized (this.f2403a) {
            z5 = this.f2407f == f2402k;
            this.f2407f = obj;
        }
        if (z5) {
            i.a.a().b(this.f2411j);
        }
    }

    public final void j(c0 c0Var) {
        a("removeObserver");
        x xVar = (x) this.f2404b.d(c0Var);
        if (xVar == null) {
            return;
        }
        xVar.b();
        xVar.a(false);
    }

    public void k(Object obj) {
        a("setValue");
        this.f2408g++;
        this.e = obj;
        c(null);
    }

    public y() {
        this.f2403a = new Object();
        this.f2404b = new j.f();
        this.f2405c = 0;
        Object obj = f2402k;
        this.f2407f = obj;
        this.f2411j = new androidx.activity.e(this, 5);
        this.e = obj;
        this.f2408g = -1;
    }
}
