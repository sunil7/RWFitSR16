package androidx.fragment.app;

import androidx.lifecycle.Lifecycle$Event;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2187a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2188b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2189c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2190d;

    public h(androidx.lifecycle.u uVar, Lifecycle$Event lifecycle$Event) {
        this.f2187a = 1;
        this.f2188b = false;
        this.f2189c = uVar;
        this.f2190d = lifecycle$Event;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2187a) {
            case 0:
                p1 p1Var = (p1) this.f2189c;
                p1 p1Var2 = (p1) this.f2190d;
                e1.a(p1Var.f2253c, p1Var2.f2253c, this.f2188b);
                break;
            case 1:
                if (!this.f2188b) {
                    ((androidx.lifecycle.u) this.f2189c).e((Lifecycle$Event) this.f2190d);
                    this.f2188b = true;
                    break;
                }
                break;
            default:
                ((androidx.camera.core.impl.utils.executor.b) this.f2189c).execute(new androidx.camera.camera2.internal.g(this, 1));
                break;
        }
    }

    public h(p1 p1Var, p1 p1Var2, boolean z5, m0.b bVar) {
        this.f2187a = 0;
        this.f2189c = p1Var;
        this.f2190d = p1Var2;
        this.f2188b = z5;
    }

    public h(androidx.camera.camera2.internal.h hVar, androidx.camera.core.impl.utils.executor.b bVar) {
        this.f2187a = 2;
        this.f2190d = hVar;
        this.f2188b = false;
        this.f2189c = bVar;
    }
}
