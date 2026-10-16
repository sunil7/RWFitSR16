package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class w2 extends rg.y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14975a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.l f14976b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.c f14977c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14978d;

    public /* synthetic */ w2(rg.l lVar, Object obj, vg.c cVar, int i3) {
        this.f14975a = i3;
        this.f14976b = lVar;
        this.f14978d = obj;
        this.f14977c = cVar;
    }

    @Override // rg.y
    public final void c(rg.z zVar) {
        switch (this.f14975a) {
            case 0:
                this.f14976b.subscribe(new io.reactivex.internal.observers.e(zVar, 2, this.f14977c, this.f14978d));
                break;
            default:
                try {
                    Object call = ((Callable) this.f14978d).call();
                    xg.c.b(call, "The seedSupplier returned a null value");
                    this.f14976b.subscribe(new io.reactivex.internal.observers.e(zVar, 2, this.f14977c, call));
                    break;
                } catch (Throwable th2) {
                    ad.a(th2);
                    EmptyDisposable.error(th2, zVar);
                    return;
                }
        }
    }
}
