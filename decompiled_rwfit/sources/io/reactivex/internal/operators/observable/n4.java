package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class n4 extends ah.a {

    /* renamed from: b, reason: collision with root package name */
    public final o4 f14783b;

    /* renamed from: c, reason: collision with root package name */
    public final io.reactivex.subjects.d f14784c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14785d;

    public n4(o4 o4Var, io.reactivex.subjects.d dVar) {
        this.f14783b = o4Var;
        this.f14784c = dVar;
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14785d) {
            return;
        }
        this.f14785d = true;
        o4 o4Var = this.f14783b;
        o4Var.f14806j.a(this);
        o4Var.f14471c.offer(new p4(this.f14784c, null));
        if (o4Var.b()) {
            o4Var.f();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14785d) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.f14785d = true;
        o4 o4Var = this.f14783b;
        o4Var.f14807k.dispose();
        o4Var.f14806j.dispose();
        o4Var.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        dispose();
        onComplete();
    }
}
