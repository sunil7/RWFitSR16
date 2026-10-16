package z2;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.b f20195a;

    /* renamed from: b, reason: collision with root package name */
    public final ob.a f20196b;

    public d(androidx.work.impl.utils.futures.b bVar, ob.a aVar) {
        this.f20195a = bVar;
        this.f20196b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f20195a.f20203a != this) {
            return;
        }
        if (g.f20201f.b(this.f20195a, this, g.f(this.f20196b))) {
            g.c(this.f20195a);
        }
    }
}
