package c0;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f3319a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3320b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3321c;

    public /* synthetic */ k(n nVar, int i3, int i10) {
        this.f3319a = nVar;
        this.f3320b = i3;
        this.f3321c = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z5;
        n nVar = this.f3319a;
        int i3 = nVar.f3336i;
        int i10 = this.f3320b;
        boolean z6 = true;
        if (i3 != i10) {
            nVar.f3336i = i10;
            z5 = true;
        } else {
            z5 = false;
        }
        int i11 = nVar.f3335h;
        int i12 = this.f3321c;
        if (i11 != i12) {
            nVar.f3335h = i12;
        } else {
            z6 = z5;
        }
        if (z6) {
            nVar.e();
        }
    }
}
