package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class h0 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14665b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14666c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(rg.l lVar, Object obj, int i3) {
        super(lVar);
        this.f14665b = i3;
        this.f14666c = obj;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14665b) {
            case 0:
                this.f14546a.subscribe(new ObservableConcatWithCompletable$ConcatWithObserver(sVar, (rg.c) this.f14666c));
                break;
            case 1:
                this.f14546a.subscribe(new ObservableConcatWithMaybe$ConcatWithObserver(sVar, (rg.i) this.f14666c));
                break;
            case 2:
                this.f14546a.subscribe(new ObservableConcatWithSingle$ConcatWithObserver(sVar, (rg.a0) this.f14666c));
                break;
            case 3:
                this.f14546a.subscribe(new ObservableDoFinally$DoFinallyObserver(sVar, (vg.a) this.f14666c));
                break;
            case 4:
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                sVar.onSubscribe(sequentialDisposable);
                new ObservableRetryBiPredicate$RetryBiObserver(sVar, (vg.d) this.f14666c, sequentialDisposable, this.f14546a).subscribeNext();
                break;
            case 5:
                this.f14546a.subscribe(new v0(sVar, (vg.g) this.f14666c, 0));
                break;
            case 6:
                this.f14546a.subscribe(new o3(sVar, (vg.c) this.f14666c));
                break;
            default:
                try {
                    Object call = ((Callable) this.f14666c).call();
                    xg.c.b(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.f14546a.subscribe(new e2(sVar, (Collection) call));
                    break;
                } catch (Throwable th2) {
                    ad.a(th2);
                    EmptyDisposable.error(th2, sVar);
                    return;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(rg.q qVar) {
        super(qVar);
        this.f14665b = 7;
        this.f14666c = new xg.a(16);
    }
}
