package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class j3 extends zg.a implements ug.b {
    public static final i3 e = new i3();

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14703a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f14704b;

    /* renamed from: c, reason: collision with root package name */
    public final c3 f14705c;

    /* renamed from: d, reason: collision with root package name */
    public final g3 f14706d;

    public j3(g3 g3Var, rg.l lVar, AtomicReference atomicReference, c3 c3Var) {
        this.f14706d = g3Var;
        this.f14703a = lVar;
        this.f14704b = atomicReference;
        this.f14705c = c3Var;
    }

    public static j3 d(rg.l lVar, c3 c3Var) {
        AtomicReference atomicReference = new AtomicReference();
        return new j3(new g3(atomicReference, c3Var), lVar, atomicReference, c3Var);
    }

    @Override // zg.a
    public final void c(vg.g gVar) {
        ObservableReplay$ReplayObserver observableReplay$ReplayObserver;
        loop0: while (true) {
            AtomicReference atomicReference = this.f14704b;
            observableReplay$ReplayObserver = (ObservableReplay$ReplayObserver) atomicReference.get();
            if (observableReplay$ReplayObserver != null && !observableReplay$ReplayObserver.isDisposed()) {
                break;
            }
            ObservableReplay$ReplayObserver observableReplay$ReplayObserver2 = new ObservableReplay$ReplayObserver(this.f14705c.call());
            while (!atomicReference.compareAndSet(observableReplay$ReplayObserver, observableReplay$ReplayObserver2)) {
                if (atomicReference.get() != observableReplay$ReplayObserver) {
                    break;
                }
            }
            observableReplay$ReplayObserver = observableReplay$ReplayObserver2;
            break loop0;
        }
        boolean z5 = !observableReplay$ReplayObserver.shouldConnect.get() && observableReplay$ReplayObserver.shouldConnect.compareAndSet(false, true);
        try {
            gVar.f(observableReplay$ReplayObserver);
            if (z5) {
                this.f14703a.subscribe(observableReplay$ReplayObserver);
            }
        } catch (Throwable th2) {
            if (z5) {
                observableReplay$ReplayObserver.shouldConnect.compareAndSet(true, false);
            }
            ad.a(th2);
            throw io.reactivex.internal.util.b.b(th2);
        }
    }

    @Override // ug.b
    public final void dispose() {
        this.f14704b.lazySet(null);
    }

    @Override // ug.b
    public final boolean isDisposed() {
        ug.b bVar = (ug.b) this.f14704b.get();
        return bVar == null || bVar.isDisposed();
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14706d.subscribe(sVar);
    }
}
