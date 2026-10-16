package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.dd;

/* loaded from: classes2.dex */
public final class e1 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14625b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14626c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14627d;
    public final int e;

    public e1(rg.q qVar, vg.o oVar, boolean z5, int i3, int i10) {
        super(qVar);
        this.f14625b = oVar;
        this.f14626c = z5;
        this.f14627d = i3;
        this.e = i10;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        vg.o oVar = this.f14625b;
        rg.q qVar = this.f14546a;
        if (dd.a(sVar, oVar, qVar)) {
            return;
        }
        qVar.subscribe(new ObservableFlatMap$MergeObserver(sVar, oVar, this.f14626c, this.f14627d, this.e));
    }
}
