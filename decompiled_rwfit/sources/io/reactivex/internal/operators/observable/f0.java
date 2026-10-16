package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.dd;
import io.reactivex.internal.util.ErrorMode;

/* loaded from: classes2.dex */
public final class f0 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14634b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final vg.o f14635c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14636d;
    public final Object e;

    public f0(rg.q qVar, vg.o oVar, int i3, ErrorMode errorMode) {
        super(qVar);
        this.f14635c = oVar;
        this.e = errorMode;
        this.f14636d = Math.max(8, i3);
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14634b) {
            case 0:
                vg.o oVar = this.f14635c;
                rg.q qVar = this.f14546a;
                if (!dd.a(sVar, oVar, qVar)) {
                    ErrorMode errorMode = ErrorMode.IMMEDIATE;
                    int i3 = this.f14636d;
                    ErrorMode errorMode2 = (ErrorMode) this.e;
                    if (errorMode2 != errorMode) {
                        qVar.subscribe(new ObservableConcatMap$ConcatMapDelayErrorObserver(sVar, oVar, i3, errorMode2 == ErrorMode.END));
                        break;
                    } else {
                        qVar.subscribe(new ObservableConcatMap$SourceObserver(new ah.c(sVar), oVar, i3));
                        break;
                    }
                }
                break;
            default:
                this.f14546a.subscribe(new o4(new ah.c(sVar), (rg.q) this.e, this.f14635c, this.f14636d));
                break;
        }
    }

    public f0(rg.l lVar, rg.q qVar, vg.o oVar, int i3) {
        super(lVar);
        this.e = qVar;
        this.f14635c = oVar;
        this.f14636d = i3;
    }
}
