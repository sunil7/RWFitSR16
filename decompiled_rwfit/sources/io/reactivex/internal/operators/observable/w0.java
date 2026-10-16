package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class w0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14966a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.g f14967b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.g f14968c;

    /* renamed from: d, reason: collision with root package name */
    public final vg.a f14969d;
    public final vg.a e;

    /* renamed from: f, reason: collision with root package name */
    public ug.b f14970f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14971g;

    public w0(rg.s sVar, vg.g gVar, vg.g gVar2, vg.a aVar, vg.a aVar2) {
        this.f14966a = sVar;
        this.f14967b = gVar;
        this.f14968c = gVar2;
        this.f14969d = aVar;
        this.e = aVar2;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14970f.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14970f.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14971g) {
            return;
        }
        try {
            this.f14969d.run();
            this.f14971g = true;
            this.f14966a.onComplete();
            try {
                this.e.run();
            } catch (Throwable th2) {
                ad.a(th2);
                com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            }
        } catch (Throwable th3) {
            ad.a(th3);
            onError(th3);
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14971g) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.f14971g = true;
        try {
            this.f14968c.f(th2);
        } catch (Throwable th3) {
            ad.a(th3);
            th2 = new CompositeException(th2, th3);
        }
        this.f14966a.onError(th2);
        try {
            this.e.run();
        } catch (Throwable th4) {
            ad.a(th4);
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th4);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14971g) {
            return;
        }
        try {
            this.f14967b.f(obj);
            this.f14966a.onNext(obj);
        } catch (Throwable th2) {
            ad.a(th2);
            this.f14970f.dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14970f, bVar)) {
            this.f14970f = bVar;
            this.f14966a.onSubscribe(this);
        }
    }
}
