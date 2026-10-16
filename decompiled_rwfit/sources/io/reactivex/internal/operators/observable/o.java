package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class o extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14786a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14787b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14788c;

    public /* synthetic */ o(int i3, Object obj, Object obj2) {
        this.f14786a = i3;
        this.f14787b = obj;
        this.f14788c = obj2;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        int length;
        switch (this.f14786a) {
            case 0:
                rg.q[] qVarArr = (rg.q[]) this.f14787b;
                if (qVarArr == null) {
                    qVarArr = new rg.l[8];
                    try {
                        length = 0;
                        for (rg.q qVar : (Iterable) this.f14788c) {
                            if (qVar == null) {
                                EmptyDisposable.error(new NullPointerException("One of the sources is null"), sVar);
                                break;
                            } else {
                                if (length == qVarArr.length) {
                                    rg.q[] qVarArr2 = new rg.q[(length >> 2) + length];
                                    System.arraycopy(qVarArr, 0, qVarArr2, 0, length);
                                    qVarArr = qVarArr2;
                                }
                                int i3 = length + 1;
                                qVarArr[length] = qVar;
                                length = i3;
                            }
                        }
                    } catch (Throwable th2) {
                        ad.a(th2);
                        EmptyDisposable.error(th2, sVar);
                        return;
                    }
                } else {
                    length = qVarArr.length;
                }
                if (length == 0) {
                    EmptyDisposable.complete(sVar);
                    break;
                } else if (length == 1) {
                    qVarArr[0].subscribe(sVar);
                    break;
                } else {
                    n nVar = new n(sVar, length);
                    ObservableAmb$AmbInnerObserver[] observableAmb$AmbInnerObserverArr = nVar.f14763b;
                    int length2 = observableAmb$AmbInnerObserverArr.length;
                    int i10 = 0;
                    while (true) {
                        rg.s sVar2 = nVar.f14762a;
                        if (i10 < length2) {
                            int i11 = i10 + 1;
                            observableAmb$AmbInnerObserverArr[i10] = new ObservableAmb$AmbInnerObserver(nVar, i11, sVar2);
                            i10 = i11;
                        } else {
                            AtomicInteger atomicInteger = nVar.f14764c;
                            atomicInteger.lazySet(0);
                            sVar2.onSubscribe(nVar);
                            for (int i12 = 0; i12 < length2 && atomicInteger.get() == 0; i12++) {
                                qVarArr[i12].subscribe(observableAmb$AmbInnerObserverArr[i12]);
                            }
                        }
                    }
                }
            case 1:
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                sVar.onSubscribe(sequentialDisposable);
                ((rg.q) this.f14788c).subscribe(new q0(this, sequentialDisposable, sVar));
                break;
            case 2:
                try {
                    Object call = ((Callable) this.f14787b).call();
                    xg.c.b(call, "The connectableFactory returned a null ConnectableObservable");
                    zg.a aVar = (zg.a) call;
                    Object apply = ((vg.o) this.f14788c).apply(aVar);
                    xg.c.b(apply, "The selector returned a null ObservableSource");
                    rg.q qVar2 = (rg.q) apply;
                    ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(sVar);
                    qVar2.subscribe(observerResourceWrapper);
                    aVar.c(new z1(observerResourceWrapper, 2));
                    break;
                } catch (Throwable th3) {
                    ad.a(th3);
                    EmptyDisposable.error(th3, sVar);
                    return;
                }
            default:
                try {
                    Object apply2 = ((vg.o) this.f14788c).apply(this.f14787b);
                    xg.c.b(apply2, "The mapper returned a null ObservableSource");
                    rg.q qVar3 = (rg.q) apply2;
                    if (!(qVar3 instanceof Callable)) {
                        qVar3.subscribe(sVar);
                        break;
                    } else {
                        try {
                            Object call2 = ((Callable) qVar3).call();
                            if (call2 == null) {
                                EmptyDisposable.complete(sVar);
                                break;
                            } else {
                                ObservableScalarXMap$ScalarDisposable observableScalarXMap$ScalarDisposable = new ObservableScalarXMap$ScalarDisposable(sVar, call2);
                                sVar.onSubscribe(observableScalarXMap$ScalarDisposable);
                                observableScalarXMap$ScalarDisposable.run();
                                break;
                            }
                        } catch (Throwable th4) {
                            ad.a(th4);
                            EmptyDisposable.error(th4, sVar);
                            return;
                        }
                    }
                } catch (Throwable th5) {
                    EmptyDisposable.error(th5, sVar);
                    return;
                }
        }
    }
}
