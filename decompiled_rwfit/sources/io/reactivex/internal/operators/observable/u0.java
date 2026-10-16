package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class u0 extends io.reactivex.internal.observers.a {

    /* renamed from: f, reason: collision with root package name */
    public final vg.o f14915f;

    /* renamed from: g, reason: collision with root package name */
    public Object f14916g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14917h;

    public u0(rg.s sVar, vg.o oVar, vg.d dVar) {
        super(sVar);
        this.f14915f = oVar;
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14453d) {
            return;
        }
        int i3 = this.e;
        rg.s sVar = this.f14450a;
        if (i3 != 0) {
            sVar.onNext(obj);
            return;
        }
        try {
            Object apply = this.f14915f.apply(obj);
            if (this.f14917h) {
                boolean a3 = xg.c.a(this.f14916g, apply);
                this.f14916g = apply;
                if (a3) {
                    return;
                }
            } else {
                this.f14917h = true;
                this.f14916g = apply;
            }
            sVar.onNext(obj);
        } catch (Throwable th2) {
            a(th2);
        }
    }

    @Override // yg.f
    public final Object poll() {
        while (true) {
            Object poll = this.f14452c.poll();
            if (poll == null) {
                return null;
            }
            Object apply = this.f14915f.apply(poll);
            if (!this.f14917h) {
                this.f14917h = true;
                this.f14916g = apply;
                return poll;
            }
            if (!xg.c.a(this.f14916g, apply)) {
                this.f14916g = apply;
                return poll;
            }
            this.f14916g = apply;
        }
    }
}
