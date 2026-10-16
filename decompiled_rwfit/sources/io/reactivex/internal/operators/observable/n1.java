package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class n1 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14772a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final vg.c f14773b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14774c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14775d;

    public n1(Callable callable, vg.c cVar, vg.g gVar) {
        this.f14774c = callable;
        this.f14773b = cVar;
        this.f14775d = gVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14772a) {
            case 0:
                try {
                    Object call = ((Callable) this.f14774c).call();
                    vg.c cVar = this.f14773b;
                    m1 m1Var = new m1(sVar, cVar, (vg.g) this.f14775d, call);
                    sVar.onSubscribe(m1Var);
                    Object obj = m1Var.f14750c;
                    if (!m1Var.f14751d) {
                        while (!m1Var.f14751d) {
                            try {
                                obj = cVar.a(obj, m1Var);
                                if (m1Var.e) {
                                    m1Var.f14751d = true;
                                    m1Var.f14750c = null;
                                    m1Var.a(obj);
                                    break;
                                }
                            } catch (Throwable th2) {
                                ad.a(th2);
                                m1Var.f14750c = null;
                                m1Var.f14751d = true;
                                m1Var.onError(th2);
                                m1Var.a(obj);
                                return;
                            }
                        }
                        m1Var.f14750c = null;
                        m1Var.a(obj);
                        break;
                    } else {
                        m1Var.f14750c = null;
                        m1Var.a(obj);
                        break;
                    }
                } catch (Throwable th3) {
                    ad.a(th3);
                    EmptyDisposable.error(th3, sVar);
                    return;
                }
            default:
                try {
                    Iterator it = ((Iterable) this.f14775d).iterator();
                    xg.c.b(it, "The iterator returned by other is null");
                    try {
                        if (!it.hasNext()) {
                            EmptyDisposable.complete(sVar);
                            break;
                        } else {
                            ((rg.l) this.f14774c).subscribe(new c0(sVar, it, this.f14773b));
                            break;
                        }
                    } catch (Throwable th4) {
                        ad.a(th4);
                        EmptyDisposable.error(th4, sVar);
                        return;
                    }
                } catch (Throwable th5) {
                    ad.a(th5);
                    EmptyDisposable.error(th5, sVar);
                }
        }
    }

    public n1(rg.l lVar, Iterable iterable, vg.c cVar) {
        this.f14774c = lVar;
        this.f14775d = iterable;
        this.f14773b = cVar;
    }
}
