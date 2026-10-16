package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class o0 extends rg.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14789a;

    /* renamed from: b, reason: collision with root package name */
    public final Callable f14790b;

    public /* synthetic */ o0(Callable callable, int i3) {
        this.f14789a = i3;
        this.f14790b = callable;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14789a) {
            case 0:
                try {
                    Object call = this.f14790b.call();
                    xg.c.b(call, "null ObservableSource supplied");
                    ((rg.q) call).subscribe(sVar);
                    break;
                } catch (Throwable th2) {
                    ad.a(th2);
                    EmptyDisposable.error(th2, sVar);
                    return;
                }
            default:
                try {
                    Object call2 = this.f14790b.call();
                    xg.c.b(call2, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
                    th = (Throwable) call2;
                } catch (Throwable th3) {
                    th = th3;
                    ad.a(th);
                }
                EmptyDisposable.error(th, sVar);
                break;
        }
    }
}
