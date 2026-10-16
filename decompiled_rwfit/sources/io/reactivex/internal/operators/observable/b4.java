package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;

/* loaded from: classes2.dex */
public final class b4 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14584b;

    /* renamed from: c, reason: collision with root package name */
    public final rg.q f14585c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b4(rg.l lVar, rg.q qVar, int i3) {
        super(lVar);
        this.f14584b = i3;
        this.f14585c = qVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14584b) {
            case 0:
                ah.c cVar = new ah.c(sVar);
                ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
                ObservableTakeUntil$TakeUntilObserver observableTakeUntil$TakeUntilObserver = new ObservableTakeUntil$TakeUntilObserver(cVar, arrayCompositeDisposable);
                sVar.onSubscribe(arrayCompositeDisposable);
                this.f14585c.subscribe(new r2(1, arrayCompositeDisposable, cVar));
                this.f14546a.subscribe(observableTakeUntil$TakeUntilObserver);
                break;
            case 1:
                ah.c cVar2 = new ah.c(sVar);
                ArrayCompositeDisposable arrayCompositeDisposable2 = new ArrayCompositeDisposable(2);
                cVar2.onSubscribe(arrayCompositeDisposable2);
                w3 w3Var = new w3(cVar2, arrayCompositeDisposable2);
                this.f14585c.subscribe(new v3(arrayCompositeDisposable2, w3Var, cVar2));
                this.f14546a.subscribe(w3Var);
                break;
            default:
                q0 q0Var = new q0(sVar, this.f14585c);
                sVar.onSubscribe(q0Var.f14836c);
                this.f14546a.subscribe(q0Var);
                break;
        }
    }
}
