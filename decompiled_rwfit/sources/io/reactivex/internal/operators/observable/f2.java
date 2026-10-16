package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class f2 extends rg.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14640a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.l f14641b;

    public /* synthetic */ f2(rg.l lVar, int i3) {
        this.f14640a = i3;
        this.f14641b = lVar;
    }

    @Override // rg.g
    public final void c(rg.h hVar) {
        switch (this.f14640a) {
            case 0:
                this.f14641b.subscribe(new e2(hVar, 0));
                break;
            default:
                this.f14641b.subscribe(new l(hVar));
                break;
        }
    }
}
