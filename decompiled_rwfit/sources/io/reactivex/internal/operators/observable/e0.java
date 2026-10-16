package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class e0 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14620a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.q[] f14621b;

    /* renamed from: c, reason: collision with root package name */
    public final Iterable f14622c;

    /* renamed from: d, reason: collision with root package name */
    public final vg.o f14623d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14624f;

    public /* synthetic */ e0(rg.q[] qVarArr, Iterable iterable, vg.o oVar, int i3, boolean z5, int i10) {
        this.f14620a = i10;
        this.f14621b = qVarArr;
        this.f14622c = iterable;
        this.f14623d = oVar;
        this.e = i3;
        this.f14624f = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        int length;
        int length2;
        switch (this.f14620a) {
            case 0:
                rg.q[] qVarArr = this.f14621b;
                if (qVarArr == null) {
                    qVarArr = new rg.l[8];
                    length = 0;
                    for (rg.q qVar : this.f14622c) {
                        if (length == qVarArr.length) {
                            rg.q[] qVarArr2 = new rg.q[(length >> 2) + length];
                            System.arraycopy(qVarArr, 0, qVarArr2, 0, length);
                            qVarArr = qVarArr2;
                        }
                        qVarArr[length] = qVar;
                        length++;
                    }
                } else {
                    length = qVarArr.length;
                }
                int i3 = length;
                if (i3 == 0) {
                    EmptyDisposable.complete(sVar);
                    break;
                } else {
                    new ObservableCombineLatest$LatestCoordinator(sVar, this.f14623d, i3, this.e, this.f14624f).subscribe(qVarArr);
                    break;
                }
            default:
                rg.q[] qVarArr3 = this.f14621b;
                if (qVarArr3 == null) {
                    qVarArr3 = new rg.l[8];
                    length2 = 0;
                    for (rg.q qVar2 : this.f14622c) {
                        if (length2 == qVarArr3.length) {
                            rg.q[] qVarArr4 = new rg.q[(length2 >> 2) + length2];
                            System.arraycopy(qVarArr3, 0, qVarArr4, 0, length2);
                            qVarArr3 = qVarArr4;
                        }
                        qVarArr3[length2] = qVar2;
                        length2++;
                    }
                } else {
                    length2 = qVarArr3.length;
                }
                if (length2 == 0) {
                    EmptyDisposable.complete(sVar);
                    break;
                } else {
                    new ObservableZip$ZipCoordinator(sVar, this.f14623d, length2, this.f14624f).subscribe(qVarArr3, this.e);
                    break;
                }
        }
    }
}
