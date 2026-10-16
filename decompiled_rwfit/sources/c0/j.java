package c0;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3317a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f3318b;

    public /* synthetic */ j(m mVar, int i3) {
        this.f3317a = i3;
        this.f3318b = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3317a) {
            case 0:
                this.f3318b.a();
                break;
            case 1:
                this.f3318b.b();
                break;
            default:
                m mVar = this.f3318b;
                o oVar = mVar.r;
                if (oVar != null) {
                    oVar.e();
                }
                if (mVar.f3328q == null) {
                    androidx.concurrent.futures.b bVar = mVar.f3327p;
                    bVar.f1608d = true;
                    n0.i iVar = bVar.f1606b;
                    if (iVar != null && iVar.f16358b.cancel(true)) {
                        bVar.f1605a = null;
                        bVar.f1606b = null;
                        bVar.f1607c = null;
                        break;
                    }
                }
                break;
        }
    }
}
