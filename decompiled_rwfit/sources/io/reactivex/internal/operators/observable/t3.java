package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class t3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14902b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14903c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t3(rg.l lVar, int i3, int i10) {
        super(lVar);
        this.f14902b = i10;
        this.f14903c = i3;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14902b) {
            case 0:
                this.f14546a.subscribe(new ObservableSkipLast$SkipLastObserver(sVar, this.f14903c));
                break;
            default:
                this.f14546a.subscribe(new ObservableTakeLast$TakeLastObserver(sVar, this.f14903c));
                break;
        }
    }
}
