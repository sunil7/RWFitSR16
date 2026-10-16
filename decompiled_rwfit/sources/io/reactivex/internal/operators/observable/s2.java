package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class s2 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14872b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.o f14873c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s2(rg.q qVar, vg.o oVar, int i3) {
        super(qVar);
        this.f14872b = i3;
        this.f14873c = oVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14872b) {
            case 0:
                io.reactivex.subjects.a aVar = new io.reactivex.subjects.a();
                try {
                    Object apply = this.f14873c.apply(aVar);
                    xg.c.b(apply, "The selector returned a null ObservableSource");
                    rg.q qVar = (rg.q) apply;
                    ObservablePublishSelector$TargetObserver observablePublishSelector$TargetObserver = new ObservablePublishSelector$TargetObserver(sVar);
                    qVar.subscribe(observablePublishSelector$TargetObserver);
                    this.f14546a.subscribe(new r2(0, aVar, observablePublishSelector$TargetObserver));
                    break;
                } catch (Throwable th2) {
                    ad.a(th2);
                    EmptyDisposable.error(th2, sVar);
                    return;
                }
            case 1:
                this.f14546a.subscribe(new m0(new ah.c(sVar), this.f14873c));
                break;
            case 2:
                this.f14546a.subscribe(new h1(sVar, this.f14873c, 0));
                break;
            case 3:
                this.f14546a.subscribe(new v0(sVar, this.f14873c, 2));
                break;
            default:
                this.f14546a.subscribe(new h1(sVar, this.f14873c, 1));
                break;
        }
    }
}
