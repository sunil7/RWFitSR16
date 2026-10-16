package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class x1 implements vg.a, vg.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14998a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.s f14999b;

    public /* synthetic */ x1(rg.s sVar, int i3) {
        this.f14998a = i3;
        this.f14999b = sVar;
    }

    @Override // vg.g
    public void f(Object obj) {
        switch (this.f14998a) {
            case 1:
                this.f14999b.onError((Throwable) obj);
                break;
            default:
                this.f14999b.onNext(obj);
                break;
        }
    }

    @Override // vg.a
    public void run() {
        this.f14999b.onComplete();
    }
}
