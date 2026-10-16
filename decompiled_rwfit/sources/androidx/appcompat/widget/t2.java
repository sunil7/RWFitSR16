package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class t2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1061a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f1062b;

    public /* synthetic */ t2(SearchView searchView, int i3) {
        this.f1061a = i3;
        this.f1062b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1061a) {
            case 0:
                this.f1062b.u();
                break;
            default:
                o1.b bVar = this.f1062b.O;
                if (bVar instanceof i3) {
                    bVar.b(null);
                    break;
                }
                break;
        }
    }
}
