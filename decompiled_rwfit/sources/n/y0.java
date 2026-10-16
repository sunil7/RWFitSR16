package n;

/* loaded from: classes.dex */
public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16326a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t.z0 f16327b;

    public /* synthetic */ y0(t.z0 z0Var, int i3) {
        this.f16326a = i3;
        this.f16327b = z0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16326a) {
            case 0:
                this.f16327b.a();
                break;
            case 1:
                this.f16327b.a();
                break;
            default:
                t.z0 z0Var = this.f16327b;
                if (z0Var != null) {
                    z0Var.a();
                    break;
                }
                break;
        }
    }
}
