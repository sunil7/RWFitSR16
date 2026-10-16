package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class j4 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final Callable f14707a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14708b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.g f14709c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14710d;

    public j4(Callable callable, vg.o oVar, vg.g gVar, boolean z5) {
        this.f14707a = callable;
        this.f14708b = oVar;
        this.f14709c = gVar;
        this.f14710d = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        vg.g gVar = this.f14709c;
        try {
            Object call = this.f14707a.call();
            try {
                Object apply = this.f14708b.apply(call);
                xg.c.b(apply, "The sourceSupplier returned a null ObservableSource");
                ((rg.q) apply).subscribe(new ObservableUsing$UsingObserver(sVar, call, gVar, this.f14710d));
            } catch (Throwable th2) {
                ad.a(th2);
                try {
                    gVar.f(call);
                    EmptyDisposable.error(th2, sVar);
                } catch (Throwable th3) {
                    ad.a(th3);
                    EmptyDisposable.error(new CompositeException(th2, th3), sVar);
                }
            }
        } catch (Throwable th4) {
            ad.a(th4);
            EmptyDisposable.error(th4, sVar);
        }
    }
}
