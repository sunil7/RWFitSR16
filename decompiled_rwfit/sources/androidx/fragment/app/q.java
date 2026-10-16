package androidx.fragment.app;

/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2258a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f2259b;

    public /* synthetic */ q(Fragment fragment, int i3) {
        this.f2258a = i3;
        this.f2259b = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2258a) {
            case 0:
                this.f2259b.startPostponedEnterTransition();
                break;
            default:
                this.f2259b.callStartTransitionListener(false);
                break;
        }
    }
}
