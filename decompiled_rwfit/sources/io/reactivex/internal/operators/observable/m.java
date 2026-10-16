package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class m extends rg.y implements yg.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14740a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.l f14741b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14742c;

    public /* synthetic */ m(rg.l lVar, Object obj, int i3) {
        this.f14740a = i3;
        this.f14741b = lVar;
        this.f14742c = obj;
    }

    @Override // yg.a
    public final rg.l a() {
        switch (this.f14740a) {
            case 0:
                return new k(this.f14741b, (vg.p) this.f14742c, 0);
            case 1:
                return new k(this.f14741b, (vg.p) this.f14742c, 1);
            default:
                return new h0(this.f14741b, (Callable) this.f14742c, 7);
        }
    }

    @Override // rg.y
    public final void c(rg.z zVar) {
        switch (this.f14740a) {
            case 0:
                this.f14741b.subscribe(new l(zVar, (vg.p) this.f14742c, 0));
                break;
            case 1:
                this.f14741b.subscribe(new l(zVar, (vg.p) this.f14742c, 1));
                break;
            default:
                try {
                    Object call = ((Callable) this.f14742c).call();
                    xg.c.b(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.f14741b.subscribe(new e2(zVar, (Collection) call));
                    break;
                } catch (Throwable th2) {
                    ad.a(th2);
                    EmptyDisposable.error(th2, zVar);
                    return;
                }
        }
    }

    public m(rg.l lVar, int i3) {
        this.f14740a = 2;
        this.f14741b = lVar;
        this.f14742c = new xg.a(i3);
    }
}
