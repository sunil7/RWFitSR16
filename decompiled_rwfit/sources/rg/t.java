package rg;

/* loaded from: classes2.dex */
public final class t implements ug.b, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f18129a;

    /* renamed from: b, reason: collision with root package name */
    public final w f18130b;

    /* renamed from: c, reason: collision with root package name */
    public Thread f18131c;

    public t(Runnable runnable, w wVar) {
        this.f18129a = runnable;
        this.f18130b = wVar;
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f18131c == Thread.currentThread()) {
            w wVar = this.f18130b;
            if (wVar instanceof io.reactivex.internal.schedulers.k) {
                io.reactivex.internal.schedulers.k kVar = (io.reactivex.internal.schedulers.k) wVar;
                if (kVar.f15092b) {
                    return;
                }
                kVar.f15092b = true;
                kVar.f15091a.shutdown();
                return;
            }
        }
        this.f18130b.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f18130b.isDisposed();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18131c = Thread.currentThread();
        try {
            this.f18129a.run();
        } finally {
            dispose();
            this.f18131c = null;
        }
    }
}
