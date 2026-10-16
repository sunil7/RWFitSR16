package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final /* synthetic */ class p3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1026a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f1027b;

    public /* synthetic */ p3(Toolbar toolbar, int i3) {
        this.f1026a = i3;
        this.f1027b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1026a) {
            case 0:
                r3 r3Var = this.f1027b.L;
                h.m mVar = r3Var == null ? null : r3Var.f1037b;
                if (mVar != null) {
                    mVar.collapseActionView();
                    break;
                }
                break;
            default:
                this.f1027b.m();
                break;
        }
    }
}
