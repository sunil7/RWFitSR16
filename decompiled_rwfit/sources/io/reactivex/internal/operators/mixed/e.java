package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.bd;
import rg.l;
import rg.s;
import vg.o;

/* loaded from: classes2.dex */
public final class e extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14505a;

    /* renamed from: b, reason: collision with root package name */
    public final l f14506b;

    /* renamed from: c, reason: collision with root package name */
    public final o f14507c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14508d;

    public /* synthetic */ e(l lVar, o oVar, boolean z5, int i3) {
        this.f14505a = i3;
        this.f14506b = lVar;
        this.f14507c = oVar;
        this.f14508d = z5;
    }

    @Override // rg.l
    public final void subscribeActual(s sVar) {
        switch (this.f14505a) {
            case 0:
                l lVar = this.f14506b;
                o oVar = this.f14507c;
                if (!bd.b(lVar, oVar, sVar)) {
                    lVar.subscribe(new ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(sVar, oVar, this.f14508d));
                    break;
                }
                break;
            default:
                l lVar2 = this.f14506b;
                o oVar2 = this.f14507c;
                if (!bd.c(lVar2, oVar2, sVar)) {
                    lVar2.subscribe(new ObservableSwitchMapSingle$SwitchMapSingleMainObserver(sVar, oVar2, this.f14508d));
                    break;
                }
                break;
        }
    }
}
