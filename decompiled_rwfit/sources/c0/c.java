package c0;

import t.f1;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3282a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1 f3283b;

    public /* synthetic */ c(f1 f1Var, int i3) {
        this.f3282a = i3;
        this.f3283b = f1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3282a) {
            case 0:
                this.f3283b.c();
                break;
            default:
                this.f3283b.f18323f.cancel(true);
                break;
        }
    }
}
