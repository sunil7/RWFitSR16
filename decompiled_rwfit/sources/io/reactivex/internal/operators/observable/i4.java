package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class i4 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14694a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14695b;

    public /* synthetic */ i4(Object obj, int i3) {
        this.f14694a = i3;
        this.f14695b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14694a) {
            case 0:
                ((ObservableUnsubscribeOn$UnsubscribeObserver) this.f14695b).f14540s.dispose();
                return;
            default:
                p0 p0Var = (p0) this.f14695b;
                try {
                    p0Var.f14816a.onComplete();
                    return;
                } finally {
                    p0Var.f14819d.dispose();
                }
        }
    }
}
