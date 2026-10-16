package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class l0 extends ah.a {

    /* renamed from: b, reason: collision with root package name */
    public final m0 f14730b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14731c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14732d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f14733f = new AtomicBoolean();

    public l0(m0 m0Var, long j4, Object obj) {
        this.f14730b = m0Var;
        this.f14731c = j4;
        this.f14732d = obj;
    }

    public final void a() {
        if (this.f14733f.compareAndSet(false, true)) {
            m0 m0Var = this.f14730b;
            long j4 = this.f14731c;
            Object obj = this.f14732d;
            if (j4 == m0Var.e) {
                m0Var.f14743a.onNext(obj);
            }
        }
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        a();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.e) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.e = true;
            this.f14730b.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        this.e = true;
        dispose();
        a();
    }
}
