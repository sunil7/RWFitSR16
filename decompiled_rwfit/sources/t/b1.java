package t;

/* loaded from: classes.dex */
public final /* synthetic */ class b1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18274a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e1 f18275b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f18276c;

    public /* synthetic */ b1(e1 e1Var, l lVar, int i3) {
        this.f18274a = i3;
        this.f18275b = e1Var;
        this.f18276c = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18274a) {
            case 0:
                this.f18275b.g(this.f18276c);
                break;
            default:
                this.f18275b.g(this.f18276c);
                break;
        }
    }
}
