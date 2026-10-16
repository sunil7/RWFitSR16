package io.reactivex.internal.observers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import rg.s;

/* loaded from: classes2.dex */
public abstract class a implements s, yg.b {

    /* renamed from: a, reason: collision with root package name */
    public final s f14450a;

    /* renamed from: b, reason: collision with root package name */
    public ug.b f14451b;

    /* renamed from: c, reason: collision with root package name */
    public yg.b f14452c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14453d;
    public int e;

    public a(s sVar) {
        this.f14450a = sVar;
    }

    public final void a(Throwable th2) {
        ad.a(th2);
        this.f14451b.dispose();
        onError(th2);
    }

    @Override // yg.f
    public void clear() {
        this.f14452c.clear();
    }

    @Override // ug.b
    public final void dispose() {
        this.f14451b.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14451b.isDisposed();
    }

    @Override // yg.f
    public final boolean isEmpty() {
        return this.f14452c.isEmpty();
    }

    @Override // yg.f
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // rg.s
    public void onComplete() {
        if (this.f14453d) {
            return;
        }
        this.f14453d = true;
        this.f14450a.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.f14453d) {
            a1.b(th2);
        } else {
            this.f14453d = true;
            this.f14450a.onError(th2);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14451b, bVar)) {
            this.f14451b = bVar;
            if (bVar instanceof yg.b) {
                this.f14452c = (yg.b) bVar;
            }
            this.f14450a.onSubscribe(this);
        }
    }

    @Override // yg.c
    public int requestFusion(int i3) {
        yg.b bVar = this.f14452c;
        if (bVar == null || (i3 & 4) != 0) {
            return 0;
        }
        int requestFusion = bVar.requestFusion(i3);
        if (requestFusion == 0) {
            return requestFusion;
        }
        this.e = requestFusion;
        return requestFusion;
    }
}
