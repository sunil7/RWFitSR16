package p4;

import com.bumptech.glide.request.RequestCoordinator$RequestState;

/* loaded from: classes.dex */
public final class f implements d, c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f17472a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f17473b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.bumptech.glide.request.a f17474c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f17475d;
    public RequestCoordinator$RequestState e;

    /* renamed from: f, reason: collision with root package name */
    public RequestCoordinator$RequestState f17476f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17477g;

    public f(Object obj, d dVar) {
        RequestCoordinator$RequestState requestCoordinator$RequestState = RequestCoordinator$RequestState.CLEARED;
        this.e = requestCoordinator$RequestState;
        this.f17476f = requestCoordinator$RequestState;
        this.f17473b = obj;
        this.f17472a = dVar;
    }

    @Override // p4.d, p4.c
    public final boolean a() {
        boolean z5;
        synchronized (this.f17473b) {
            try {
                z5 = this.f17475d.a() || this.f17474c.a();
            } finally {
            }
        }
        return z5;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final d b() {
        d b3;
        synchronized (this.f17473b) {
            try {
                ?? r12 = this.f17472a;
                b3 = r12 != 0 ? r12.b() : this;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return b3;
    }

    @Override // p4.c
    public final boolean c(c cVar) {
        if (!(cVar instanceof f)) {
            return false;
        }
        f fVar = (f) cVar;
        if (this.f17474c == null) {
            if (fVar.f17474c != null) {
                return false;
            }
        } else if (!this.f17474c.c(fVar.f17474c)) {
            return false;
        }
        return this.f17475d == null ? fVar.f17475d == null : this.f17475d.c(fVar.f17475d);
    }

    @Override // p4.c
    public final void clear() {
        synchronized (this.f17473b) {
            this.f17477g = false;
            RequestCoordinator$RequestState requestCoordinator$RequestState = RequestCoordinator$RequestState.CLEARED;
            this.e = requestCoordinator$RequestState;
            this.f17476f = requestCoordinator$RequestState;
            this.f17475d.clear();
            this.f17474c.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final boolean d(c cVar) {
        boolean z5;
        synchronized (this.f17473b) {
            try {
                ?? r12 = this.f17472a;
                z5 = (r12 == 0 || r12.d(this)) && cVar.equals(this.f17474c) && !a();
            } finally {
            }
        }
        return z5;
    }

    @Override // p4.c
    public final boolean e() {
        boolean z5;
        synchronized (this.f17473b) {
            z5 = this.e == RequestCoordinator$RequestState.CLEARED;
        }
        return z5;
    }

    @Override // p4.c
    public final void f() {
        synchronized (this.f17473b) {
            try {
                if (!this.f17476f.isComplete()) {
                    this.f17476f = RequestCoordinator$RequestState.PAUSED;
                    this.f17475d.f();
                }
                if (!this.e.isComplete()) {
                    this.e = RequestCoordinator$RequestState.PAUSED;
                    this.f17474c.f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p4.c
    public final void g() {
        synchronized (this.f17473b) {
            try {
                this.f17477g = true;
                try {
                    if (this.e != RequestCoordinator$RequestState.SUCCESS) {
                        RequestCoordinator$RequestState requestCoordinator$RequestState = this.f17476f;
                        RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.RUNNING;
                        if (requestCoordinator$RequestState != requestCoordinator$RequestState2) {
                            this.f17476f = requestCoordinator$RequestState2;
                            this.f17475d.g();
                        }
                    }
                    if (this.f17477g) {
                        RequestCoordinator$RequestState requestCoordinator$RequestState3 = this.e;
                        RequestCoordinator$RequestState requestCoordinator$RequestState4 = RequestCoordinator$RequestState.RUNNING;
                        if (requestCoordinator$RequestState3 != requestCoordinator$RequestState4) {
                            this.e = requestCoordinator$RequestState4;
                            this.f17474c.g();
                        }
                    }
                    this.f17477g = false;
                } catch (Throwable th2) {
                    this.f17477g = false;
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final void h(c cVar) {
        synchronized (this.f17473b) {
            try {
                if (cVar.equals(this.f17475d)) {
                    this.f17476f = RequestCoordinator$RequestState.SUCCESS;
                    return;
                }
                this.e = RequestCoordinator$RequestState.SUCCESS;
                ?? r32 = this.f17472a;
                if (r32 != 0) {
                    r32.h(this);
                }
                if (!this.f17476f.isComplete()) {
                    this.f17475d.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p4.c
    public final boolean i() {
        boolean z5;
        synchronized (this.f17473b) {
            z5 = this.e == RequestCoordinator$RequestState.SUCCESS;
        }
        return z5;
    }

    @Override // p4.c
    public final boolean isRunning() {
        boolean z5;
        synchronized (this.f17473b) {
            z5 = this.e == RequestCoordinator$RequestState.RUNNING;
        }
        return z5;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final void j(c cVar) {
        synchronized (this.f17473b) {
            try {
                if (!cVar.equals(this.f17474c)) {
                    this.f17476f = RequestCoordinator$RequestState.FAILED;
                    return;
                }
                this.e = RequestCoordinator$RequestState.FAILED;
                ?? r32 = this.f17472a;
                if (r32 != 0) {
                    r32.j(this);
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
        synchronized (this.f17473b) {
            try {
                ?? r12 = this.f17472a;
                z5 = (r12 == 0 || r12.k(this)) && (cVar.equals(this.f17474c) || this.e != RequestCoordinator$RequestState.SUCCESS);
            } finally {
            }
        }
        return z5;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, p4.d] */
    @Override // p4.d
    public final boolean l(c cVar) {
        boolean z5;
        synchronized (this.f17473b) {
            try {
                ?? r12 = this.f17472a;
                z5 = (r12 == 0 || r12.l(this)) && cVar.equals(this.f17474c) && this.e != RequestCoordinator$RequestState.PAUSED;
            } finally {
            }
        }
        return z5;
    }
}
