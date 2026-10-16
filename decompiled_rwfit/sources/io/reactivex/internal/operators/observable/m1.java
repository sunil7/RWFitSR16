package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;

/* loaded from: classes2.dex */
public final class m1 implements rg.d, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14748a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.g f14749b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14750c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14751d;
    public boolean e;

    public m1(rg.s sVar, vg.c cVar, vg.g gVar, Object obj) {
        this.f14748a = sVar;
        this.f14749b = gVar;
        this.f14750c = obj;
    }

    public final void a(Object obj) {
        try {
            this.f14749b.f(obj);
        } catch (Throwable th2) {
            ad.a(th2);
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        }
    }

    @Override // ug.b
    public final void dispose() {
        this.f14751d = true;
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14751d;
    }

    @Override // rg.d
    public final void onError(Throwable th2) {
        if (this.e) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.e = true;
            this.f14748a.onError(th2);
        }
    }

    @Override // rg.d
    public final void onNext(Object obj) {
        throw null;
    }
}
