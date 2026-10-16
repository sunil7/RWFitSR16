package p4;

import com.bumptech.glide.request.RequestCoordinator$RequestState;

/* loaded from: classes.dex */
public final class b implements d, c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f17467a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17468b;

    /* renamed from: c, reason: collision with root package name */
    public volatile c f17469c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f17470d;
    public RequestCoordinator$RequestState e;

    /* renamed from: f, reason: collision with root package name */
    public RequestCoordinator$RequestState f17471f;

    public b(Object obj, d dVar) {
        RequestCoordinator$RequestState requestCoordinator$RequestState = RequestCoordinator$RequestState.CLEARED;
        this.e = requestCoordinator$RequestState;
        this.f17471f = requestCoordinator$RequestState;
        this.f17467a = obj;
        this.f17468b = dVar;
    }

    @Override // p4.d, p4.c
    public final boolean a() {
        boolean z5;
        synchronized (this.f17467a) {
            try {
                z5 = this.f17469c.a() || this.f17470d.a();
            } finally {
            }
        }
        return z5;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final d b() {
        d b3;
        synchronized (this.f17467a) {
            try {
                ?? r12 = this.f17468b;
                b3 = r12 != 0 ? r12.b() : this;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return b3;
    }

    @Override // p4.c
    public final boolean c(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f17469c.c(bVar.f17469c) && this.f17470d.c(bVar.f17470d)) {
                return true;
            }
        }
        return false;
    }

    @Override // p4.c
    public final void clear() {
        synchronized (this.f17467a) {
            try {
                RequestCoordinator$RequestState requestCoordinator$RequestState = RequestCoordinator$RequestState.CLEARED;
                this.e = requestCoordinator$RequestState;
                this.f17469c.clear();
                if (this.f17471f != requestCoordinator$RequestState) {
                    this.f17471f = requestCoordinator$RequestState;
                    this.f17470d.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final boolean d(c cVar) {
        boolean z5;
        synchronized (this.f17467a) {
            ?? r12 = this.f17468b;
            z5 = (r12 == 0 || r12.d(this)) && m(cVar);
        }
        return z5;
    }

    @Override // p4.c
    public final boolean e() {
        boolean z5;
        synchronized (this.f17467a) {
            try {
                RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
                RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.CLEARED;
                z5 = requestCoordinator$RequestState == requestCoordinator$RequestState2 && this.f17471f == requestCoordinator$RequestState2;
            } finally {
            }
        }
        return z5;
    }

    @Override // p4.c
    public final void f() {
        synchronized (this.f17467a) {
            try {
                RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
                RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.RUNNING;
                if (requestCoordinator$RequestState == requestCoordinator$RequestState2) {
                    this.e = RequestCoordinator$RequestState.PAUSED;
                    this.f17469c.f();
                }
                if (this.f17471f == requestCoordinator$RequestState2) {
                    this.f17471f = RequestCoordinator$RequestState.PAUSED;
                    this.f17470d.f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p4.c
    public final void g() {
        synchronized (this.f17467a) {
            try {
                RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
                RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.RUNNING;
                if (requestCoordinator$RequestState != requestCoordinator$RequestState2) {
                    this.e = requestCoordinator$RequestState2;
                    this.f17469c.g();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final void h(c cVar) {
        synchronized (this.f17467a) {
            try {
                if (cVar.equals(this.f17469c)) {
                    this.e = RequestCoordinator$RequestState.SUCCESS;
                } else if (cVar.equals(this.f17470d)) {
                    this.f17471f = RequestCoordinator$RequestState.SUCCESS;
                }
                ?? r32 = this.f17468b;
                if (r32 != 0) {
                    r32.h(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p4.c
    public final boolean i() {
        boolean z5;
        synchronized (this.f17467a) {
            try {
                RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
                RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.SUCCESS;
                z5 = requestCoordinator$RequestState == requestCoordinator$RequestState2 || this.f17471f == requestCoordinator$RequestState2;
            } finally {
            }
        }
        return z5;
    }

    @Override // p4.c
    public final boolean isRunning() {
        boolean z5;
        synchronized (this.f17467a) {
            try {
                RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
                RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.RUNNING;
                z5 = requestCoordinator$RequestState == requestCoordinator$RequestState2 || this.f17471f == requestCoordinator$RequestState2;
            } finally {
            }
        }
        return z5;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final void j(c cVar) {
        synchronized (this.f17467a) {
            try {
                if (cVar.equals(this.f17470d)) {
                    this.f17471f = RequestCoordinator$RequestState.FAILED;
                    ?? r32 = this.f17468b;
                    if (r32 != 0) {
                        r32.j(this);
                    }
                    return;
                }
                this.e = RequestCoordinator$RequestState.FAILED;
                RequestCoordinator$RequestState requestCoordinator$RequestState = this.f17471f;
                RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.RUNNING;
                if (requestCoordinator$RequestState != requestCoordinator$RequestState2) {
                    this.f17471f = requestCoordinator$RequestState2;
                    this.f17470d.g();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final boolean k(c cVar) {
        boolean z5;
        synchronized (this.f17467a) {
            ?? r12 = this.f17468b;
            z5 = (r12 == 0 || r12.k(this)) && m(cVar);
        }
        return z5;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final boolean l(c cVar) {
        boolean z5;
        synchronized (this.f17467a) {
            ?? r12 = this.f17468b;
            z5 = (r12 == 0 || r12.l(this)) && m(cVar);
        }
        return z5;
    }

    public final boolean m(c cVar) {
        if (cVar.equals(this.f17469c)) {
            return true;
        }
        return this.e == RequestCoordinator$RequestState.FAILED && cVar.equals(this.f17470d);
    }
}
