package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes2.dex */
public final class a3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14563b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a3(rg.q qVar, int i3) {
        super(qVar);
        this.f14563b = i3;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14563b) {
            case 0:
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                sVar.onSubscribe(sequentialDisposable);
                new ObservableRepeatUntil$RepeatUntilObserver(sVar, null, sequentialDisposable, this.f14546a).subscribeNext();
                return;
            case 1:
                this.f14546a.subscribe(new i0((Object) sVar, 0));
                return;
            case 2:
                this.f14546a.subscribe(new r0(sVar));
                return;
            case 3:
                s0 s0Var = new s0();
                s0Var.f14869b = sVar;
                this.f14546a.subscribe(s0Var);
                return;
            case 4:
                this.f14546a.subscribe(new s0(sVar, 1));
                return;
            case 5:
                this.f14546a.subscribe(new s0(sVar, 2));
                return;
            case 6:
                try {
                    throw null;
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th2) {
                    ad.a(th2);
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
                    nullPointerException.initCause(th2);
                    throw nullPointerException;
                }
            case 7:
                this.f14546a.subscribe(new s0(sVar, 3));
                return;
            case 8:
                this.f14546a.subscribe(new ah.c(sVar));
                return;
            default:
                this.f14546a.subscribe(new e2(sVar, 1));
                return;
        }
    }
}
