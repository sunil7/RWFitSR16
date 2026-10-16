package ff;

/* loaded from: classes2.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13639a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f13640b;

    public /* synthetic */ o(q qVar, int i3) {
        this.f13639a = i3;
        this.f13640b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13639a) {
            case 0:
                this.f13640b.z();
                break;
            default:
                q qVar = this.f13640b;
                wf.b e = qVar.e();
                if (!e.equals(qVar.f13652i)) {
                    q.T.b(1, "onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
                    qVar.f13652i = e;
                    qVar.p();
                    break;
                } else {
                    q.T.b(1, "onSurfaceChanged:", "The computed preview size is identical. No op.");
                    break;
                }
        }
    }
}
