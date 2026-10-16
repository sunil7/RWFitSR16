package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.dd;

/* loaded from: classes2.dex */
public final class m2 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14752b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f14753c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14754d;
    public final Object e;

    public m2(rg.l lVar, rg.x xVar, boolean z5, int i3) {
        super(lVar);
        this.e = xVar;
        this.f14754d = z5;
        this.f14753c = i3;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14752b) {
            case 0:
                rg.x xVar = (rg.x) this.e;
                boolean z5 = xVar instanceof io.reactivex.internal.schedulers.r;
                rg.q qVar = this.f14546a;
                if (!z5) {
                    qVar.subscribe(new ObservableObserveOn$ObserveOnObserver(sVar, xVar.a(), this.f14754d, this.f14753c));
                    break;
                } else {
                    qVar.subscribe(sVar);
                    break;
                }
            default:
                vg.o oVar = (vg.o) this.e;
                rg.q qVar2 = this.f14546a;
                if (!dd.a(sVar, oVar, qVar2)) {
                    qVar2.subscribe(new ObservableSwitchMap$SwitchMapObserver(sVar, oVar, this.f14753c, this.f14754d));
                    break;
                }
                break;
        }
    }

    public m2(rg.q qVar, vg.o oVar, int i3, boolean z5) {
        super(qVar);
        this.e = oVar;
        this.f14753c = i3;
        this.f14754d = z5;
    }
}
