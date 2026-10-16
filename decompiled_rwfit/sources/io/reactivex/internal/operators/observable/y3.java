package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class y3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15024b;

    /* renamed from: c, reason: collision with root package name */
    public final rg.x f15025c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y3(rg.l lVar, rg.x xVar, int i3) {
        super(lVar);
        this.f15024b = i3;
        this.f15025c = xVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f15024b) {
            case 0:
                ObservableSubscribeOn$SubscribeOnObserver observableSubscribeOn$SubscribeOnObserver = new ObservableSubscribeOn$SubscribeOnObserver(sVar);
                sVar.onSubscribe(observableSubscribeOn$SubscribeOnObserver);
                observableSubscribeOn$SubscribeOnObserver.setDisposable(this.f15025c.c(new x3(0, this, observableSubscribeOn$SubscribeOnObserver)));
                break;
            default:
                this.f14546a.subscribe(new ObservableUnsubscribeOn$UnsubscribeObserver(sVar, this.f15025c));
                break;
        }
    }
}
