package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class n0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final ah.c f14765a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14766b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f14767c;

    /* renamed from: d, reason: collision with root package name */
    public final rg.w f14768d;
    public ug.b e;

    /* renamed from: f, reason: collision with root package name */
    public ug.b f14769f;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f14770g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14771h;

    public n0(ah.c cVar, long j4, TimeUnit timeUnit, rg.w wVar) {
        this.f14765a = cVar;
        this.f14766b = j4;
        this.f14767c = timeUnit;
        this.f14768d = wVar;
    }

    @Override // ug.b
    public final void dispose() {
        this.e.dispose();
        this.f14768d.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14768d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14771h) {
            return;
        }
        this.f14771h = true;
        ug.b bVar = this.f14769f;
        if (bVar != null) {
            bVar.dispose();
        }
        ObservableDebounceTimed$DebounceEmitter observableDebounceTimed$DebounceEmitter = (ObservableDebounceTimed$DebounceEmitter) bVar;
        if (observableDebounceTimed$DebounceEmitter != null) {
            observableDebounceTimed$DebounceEmitter.run();
        }
        this.f14765a.onComplete();
        this.f14768d.dispose();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14771h) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        ug.b bVar = this.f14769f;
        if (bVar != null) {
            bVar.dispose();
        }
        this.f14771h = true;
        this.f14765a.onError(th2);
        this.f14768d.dispose();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14771h) {
            return;
        }
        long j4 = this.f14770g + 1;
        this.f14770g = j4;
        ug.b bVar = this.f14769f;
        if (bVar != null) {
            bVar.dispose();
        }
        ObservableDebounceTimed$DebounceEmitter observableDebounceTimed$DebounceEmitter = new ObservableDebounceTimed$DebounceEmitter(obj, j4, this);
        this.f14769f = observableDebounceTimed$DebounceEmitter;
        observableDebounceTimed$DebounceEmitter.setResource(this.f14768d.a(observableDebounceTimed$DebounceEmitter, this.f14766b, this.f14767c));
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.e, bVar)) {
            this.e = bVar;
            this.f14765a.onSubscribe(this);
        }
    }
}
