package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.bd;
import io.reactivex.internal.util.ErrorMode;
import rg.l;
import rg.s;
import vg.o;

/* loaded from: classes2.dex */
public final class b extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14491a;

    /* renamed from: b, reason: collision with root package name */
    public final l f14492b;

    /* renamed from: c, reason: collision with root package name */
    public final o f14493c;

    /* renamed from: d, reason: collision with root package name */
    public final ErrorMode f14494d;
    public final int e;

    public /* synthetic */ b(l lVar, o oVar, ErrorMode errorMode, int i3, int i10) {
        this.f14491a = i10;
        this.f14492b = lVar;
        this.f14493c = oVar;
        this.f14494d = errorMode;
        this.e = i3;
    }

    @Override // rg.l
    public final void subscribeActual(s sVar) {
        switch (this.f14491a) {
            case 0:
                l lVar = this.f14492b;
                o oVar = this.f14493c;
                if (!bd.b(lVar, oVar, sVar)) {
                    lVar.subscribe(new ObservableConcatMapMaybe$ConcatMapMaybeMainObserver(sVar, oVar, this.e, this.f14494d));
                    break;
                }
                break;
            default:
                l lVar2 = this.f14492b;
                o oVar2 = this.f14493c;
                if (!bd.c(lVar2, oVar2, sVar)) {
                    lVar2.subscribe(new ObservableConcatMapSingle$ConcatMapSingleMainObserver(sVar, oVar2, this.e, this.f14494d));
                    break;
                }
                break;
        }
    }
}
