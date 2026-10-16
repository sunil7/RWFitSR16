package ia;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i implements d, c, a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14385a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f14386b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14387c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14388d;

    public i(Executor executor, b bVar) {
        this.f14385a = 2;
        this.f14387c = new Object();
        this.f14386b = executor;
        this.f14388d = bVar;
    }

    private final void b(f fVar) {
        if (fVar.f()) {
            synchronized (this.f14387c) {
                try {
                    if (((d) this.f14388d) == null) {
                        return;
                    }
                    this.f14386b.execute(new j(2, this, fVar));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void a(f fVar) {
        switch (this.f14385a) {
            case 0:
                ((l) this.f14386b).execute(new x.h(this, 29, fVar, false));
                return;
            case 1:
                if (((m) fVar).f14401d) {
                    synchronized (this.f14387c) {
                        try {
                            if (((a) this.f14388d) != null) {
                                ((w.a) this.f14386b).getClass();
                                synchronized (this.f14387c) {
                                    try {
                                        a aVar = (a) this.f14388d;
                                        if (aVar != null) {
                                            aVar.e();
                                        }
                                    } finally {
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 2:
                synchronized (this.f14387c) {
                }
                this.f14386b.execute(new j(0, this, fVar));
                return;
            case 3:
                if (fVar.f() || ((m) fVar).f14401d) {
                    return;
                }
                synchronized (this.f14387c) {
                    try {
                        if (((c) this.f14388d) != null) {
                            this.f14386b.execute(new j(1, this, fVar));
                        }
                    } finally {
                    }
                }
                return;
            case 4:
                b(fVar);
                return;
            default:
                ((l) this.f14386b).execute(new j(3, this, fVar));
                return;
        }
    }

    @Override // ia.a
    public void e() {
        switch (this.f14385a) {
            case 0:
                ((m) this.f14388d).i();
                break;
            default:
                ((m) this.f14388d).i();
                break;
        }
    }

    @Override // ia.d
    public void onSuccess(Object obj) {
        switch (this.f14385a) {
            case 0:
                ((m) this.f14388d).h(obj);
                break;
            default:
                ((m) this.f14388d).h(obj);
                break;
        }
    }

    @Override // ia.c
    public void w(Exception exc) {
        switch (this.f14385a) {
            case 0:
                ((m) this.f14388d).g(exc);
                break;
            default:
                ((m) this.f14388d).g(exc);
                break;
        }
    }

    public i(Executor executor, c cVar) {
        this.f14385a = 3;
        this.f14387c = new Object();
        this.f14386b = executor;
        this.f14388d = cVar;
    }

    public i(Executor executor, d dVar) {
        this.f14385a = 4;
        this.f14387c = new Object();
        this.f14386b = executor;
        this.f14388d = dVar;
    }

    public /* synthetic */ i(Executor executor, Object obj, m mVar, int i3) {
        this.f14385a = i3;
        this.f14386b = executor;
        this.f14387c = obj;
        this.f14388d = mVar;
    }

    public i(w.a aVar, a aVar2) {
        this.f14385a = 1;
        this.f14387c = new Object();
        this.f14386b = aVar;
        this.f14388d = aVar2;
    }
}
