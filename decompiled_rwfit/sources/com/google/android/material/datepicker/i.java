package com.google.android.material.datepicker;

import com.google.android.gms.internal.mlkit_vision_barcode.cb;
import io.reactivex.internal.operators.observable.f4;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10433a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final long f10434b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10435c;

    public i(j jVar, long j4) {
        this.f10435c = jVar;
        this.f10434b = j4;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [io.reactivex.internal.operators.observable.f4, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10433a) {
            case 0:
                j jVar = (j) this.f10435c;
                jVar.f10436a.setError(String.format(jVar.f10439d, cb.a(this.f10434b)));
                jVar.a();
                break;
            default:
                this.f10435c.onTimeout(this.f10434b);
                break;
        }
    }

    public i(long j4, f4 f4Var) {
        this.f10434b = j4;
        this.f10435c = f4Var;
    }
}
