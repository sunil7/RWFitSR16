package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class b0 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14571b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14572c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14573d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(rg.l lVar, Object obj, Object obj2, int i3) {
        super(lVar);
        this.f14571b = i3;
        this.f14572c = obj;
        this.f14573d = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14571b) {
            case 0:
                a0 a0Var = (a0) this.f14572c;
                ObservableCache$ReplayDisposable observableCache$ReplayDisposable = new ObservableCache$ReplayDisposable(sVar, a0Var);
                sVar.onSubscribe(observableCache$ReplayDisposable);
                while (true) {
                    AtomicReference atomicReference = a0Var.f14555h;
                    ObservableCache$ReplayDisposable[] observableCache$ReplayDisposableArr = (ObservableCache$ReplayDisposable[]) atomicReference.get();
                    if (observableCache$ReplayDisposableArr != a0.f14548k) {
                        int length = observableCache$ReplayDisposableArr.length;
                        ObservableCache$ReplayDisposable[] observableCache$ReplayDisposableArr2 = new ObservableCache$ReplayDisposable[length + 1];
                        System.arraycopy(observableCache$ReplayDisposableArr, 0, observableCache$ReplayDisposableArr2, 0, length);
                        observableCache$ReplayDisposableArr2[length] = observableCache$ReplayDisposable;
                        while (!atomicReference.compareAndSet(observableCache$ReplayDisposableArr, observableCache$ReplayDisposableArr2)) {
                            if (atomicReference.get() != observableCache$ReplayDisposableArr) {
                                break;
                            }
                        }
                    }
                }
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f14573d;
                if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
                    a0Var.f14553f.subscribe(a0Var);
                }
                observableCache$ReplayDisposable.replay();
                break;
            case 1:
                ah.c cVar = new ah.c(sVar);
                ObservableWithLatestFrom$WithLatestFromObserver observableWithLatestFrom$WithLatestFromObserver = new ObservableWithLatestFrom$WithLatestFromObserver(cVar, (vg.c) this.f14572c);
                cVar.onSubscribe(observableWithLatestFrom$WithLatestFromObserver);
                ((rg.q) this.f14573d).subscribe(new n3(observableWithLatestFrom$WithLatestFromObserver, 1));
                this.f14546a.subscribe(observableWithLatestFrom$WithLatestFromObserver);
                break;
            case 2:
                this.f14546a.subscribe(new t(new ah.c(sVar), (Callable) this.f14573d, (Callable) this.f14572c));
                break;
            case 3:
                this.f14546a.subscribe(new t(new ah.c(sVar), (Callable) this.f14573d, (rg.q) this.f14572c));
                break;
            case 4:
                try {
                    Object call = ((Callable) this.f14572c).call();
                    xg.c.b(call, "The initialSupplier returned a null value");
                    this.f14546a.subscribe(new c0(sVar, call, (vg.b) this.f14573d, 0));
                    break;
                } catch (Throwable th2) {
                    EmptyDisposable.error(th2, sVar);
                    return;
                }
            case 5:
                try {
                    Object call2 = ((Callable) this.f14573d).call();
                    xg.c.b(call2, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.f14546a.subscribe(new t0(sVar, (vg.o) this.f14572c, (Collection) call2));
                    break;
                } catch (Throwable th3) {
                    ad.a(th3);
                    EmptyDisposable.error(th3, sVar);
                    return;
                }
            case 6:
                this.f14546a.subscribe(new u0(sVar, (vg.o) this.f14572c, (vg.d) this.f14573d));
                break;
            case 7:
                this.f14546a.subscribe(new io.reactivex.internal.observers.e(sVar, 0, (vg.g) this.f14572c, (vg.a) this.f14573d));
                break;
            case 8:
                try {
                    Object call3 = ((Callable) this.f14573d).call();
                    xg.c.b(call3, "The seed supplied is null");
                    this.f14546a.subscribe(new o3(sVar, (vg.c) this.f14572c, call3));
                    break;
                } catch (Throwable th4) {
                    ad.a(th4);
                    EmptyDisposable.error(th4, sVar);
                    return;
                }
            default:
                this.f14546a.subscribe(new d4(sVar, (TimeUnit) this.f14573d, (rg.x) this.f14572c));
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(rg.l lVar, Object obj, Object obj2, int i3, boolean z5) {
        super(lVar);
        this.f14571b = i3;
        this.f14572c = obj2;
        this.f14573d = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(rg.l lVar, a0 a0Var) {
        super(lVar);
        this.f14571b = 0;
        this.f14572c = a0Var;
        this.f14573d = new AtomicBoolean();
    }
}
