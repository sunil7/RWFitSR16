package io.reactivex.internal.operators.observable;

import java.util.List;

/* loaded from: classes2.dex */
public final class v1 implements vg.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14943a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14944b;

    public /* synthetic */ v1(vg.o oVar, int i3) {
        this.f14943a = i3;
        this.f14944b = oVar;
    }

    @Override // vg.o
    public final Object apply(Object obj) {
        switch (this.f14943a) {
            case 0:
                Object apply = this.f14944b.apply(obj);
                xg.c.b(apply, "The mapper returned a null Iterable");
                return new k0((Iterable) apply, 2);
            case 1:
                Object apply2 = this.f14944b.apply(obj);
                xg.c.b(apply2, "The itemDelay returned a null ObservableSource");
                return new z2((rg.q) apply2, 1L, 2).map(new com.google.android.gms.internal.mlkit_common.i(obj, 4)).defaultIfEmpty(obj);
            default:
                return rg.l.zipIterable((List) obj, this.f14944b, false, rg.l.bufferSize());
        }
    }
}
