package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class k0 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14713a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14714b;

    public /* synthetic */ k0(Object obj, int i3) {
        this.f14713a = i3;
        this.f14714b = obj;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14713a) {
            case 0:
                ObservableCreate$CreateEmitter observableCreate$CreateEmitter = new ObservableCreate$CreateEmitter(sVar);
                sVar.onSubscribe(observableCreate$CreateEmitter);
                try {
                    ((rg.o) this.f14714b).d(observableCreate$CreateEmitter);
                    break;
                } catch (Throwable th2) {
                    ad.a(th2);
                    observableCreate$CreateEmitter.onError(th2);
                    return;
                }
            case 1:
                Object[] objArr = (Object[]) this.f14714b;
                i1 i1Var = new i1(sVar, objArr);
                sVar.onSubscribe(i1Var);
                if (!i1Var.f14692d) {
                    int length = objArr.length;
                    for (int i3 = 0; i3 < length && !i1Var.e; i3++) {
                        Object obj = objArr[i3];
                        if (obj == null) {
                            i1Var.f14689a.onError(new NullPointerException(com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "The ", "th element is null")));
                            break;
                        } else {
                            i1Var.f14689a.onNext(obj);
                        }
                    }
                    if (!i1Var.e) {
                        i1Var.f14689a.onComplete();
                        break;
                    }
                }
                break;
            case 2:
                try {
                    Iterator it = ((Iterable) this.f14714b).iterator();
                    try {
                        if (it.hasNext()) {
                            k1 k1Var = new k1(sVar, it);
                            sVar.onSubscribe(k1Var);
                            if (!k1Var.f14718d) {
                                while (!k1Var.f14717c) {
                                    try {
                                        Object next = k1Var.f14716b.next();
                                        xg.c.b(next, "The iterator returned a null value");
                                        k1Var.f14715a.onNext(next);
                                        if (k1Var.f14717c) {
                                            break;
                                        } else {
                                            try {
                                                if (!k1Var.f14716b.hasNext()) {
                                                    if (!k1Var.f14717c) {
                                                        k1Var.f14715a.onComplete();
                                                        break;
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                ad.a(th3);
                                                k1Var.f14715a.onError(th3);
                                                return;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        ad.a(th4);
                                        k1Var.f14715a.onError(th4);
                                        return;
                                    }
                                }
                                break;
                            }
                        } else {
                            EmptyDisposable.complete(sVar);
                            break;
                        }
                    } catch (Throwable th5) {
                        ad.a(th5);
                        EmptyDisposable.error(th5, sVar);
                        return;
                    }
                } catch (Throwable th6) {
                    ad.a(th6);
                    EmptyDisposable.error(th6, sVar);
                    return;
                }
                break;
            case 3:
                ((rg.e) ((ci.a) this.f14714b)).a(new l1(sVar));
                break;
            default:
                ((rg.q) this.f14714b).subscribe(sVar);
                break;
        }
    }
}
