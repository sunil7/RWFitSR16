package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class j implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14696a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.s f14697b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.p f14698c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14699d;
    public boolean e;

    public /* synthetic */ j(rg.s sVar, vg.p pVar, int i3) {
        this.f14696a = i3;
        this.f14697b = sVar;
        this.f14698c = pVar;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14696a) {
            case 0:
                this.f14699d.dispose();
                break;
            case 1:
                this.f14699d.dispose();
                break;
            case 2:
                this.f14699d.dispose();
                break;
            case 3:
                this.f14699d.dispose();
                break;
            default:
                this.f14699d.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14696a) {
        }
        return this.f14699d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14696a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    Boolean bool = Boolean.TRUE;
                    rg.s sVar = this.f14697b;
                    sVar.onNext(bool);
                    sVar.onComplete();
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    Boolean bool2 = Boolean.FALSE;
                    rg.s sVar2 = this.f14697b;
                    sVar2.onNext(bool2);
                    sVar2.onComplete();
                    break;
                }
                break;
            case 2:
                this.f14697b.onComplete();
                break;
            case 3:
                if (!this.e) {
                    this.e = true;
                    this.f14697b.onComplete();
                    break;
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.f14697b.onComplete();
                    break;
                }
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14696a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.f14697b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.f14697b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            case 2:
                this.f14697b.onError(th2);
                break;
            case 3:
                if (!this.e) {
                    this.e = true;
                    this.f14697b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            default:
                if (!this.e) {
                    this.e = true;
                    this.f14697b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14696a) {
            case 0:
                if (!this.e) {
                    try {
                        if (!this.f14698c.l(obj)) {
                            this.e = true;
                            this.f14699d.dispose();
                            Boolean bool = Boolean.FALSE;
                            rg.s sVar = this.f14697b;
                            sVar.onNext(bool);
                            sVar.onComplete();
                            break;
                        }
                    } catch (Throwable th2) {
                        ad.a(th2);
                        this.f14699d.dispose();
                        onError(th2);
                        return;
                    }
                }
                break;
            case 1:
                if (!this.e) {
                    try {
                        if (this.f14698c.l(obj)) {
                            this.e = true;
                            this.f14699d.dispose();
                            Boolean bool2 = Boolean.TRUE;
                            rg.s sVar2 = this.f14697b;
                            sVar2.onNext(bool2);
                            sVar2.onComplete();
                            break;
                        }
                    } catch (Throwable th3) {
                        ad.a(th3);
                        this.f14699d.dispose();
                        onError(th3);
                        return;
                    }
                }
                break;
            case 2:
                boolean z5 = this.e;
                rg.s sVar3 = this.f14697b;
                if (z5) {
                    sVar3.onNext(obj);
                    break;
                } else {
                    try {
                        if (!this.f14698c.l(obj)) {
                            this.e = true;
                            sVar3.onNext(obj);
                            break;
                        }
                    } catch (Throwable th4) {
                        ad.a(th4);
                        this.f14699d.dispose();
                        sVar3.onError(th4);
                        return;
                    }
                }
                break;
            case 3:
                if (!this.e) {
                    rg.s sVar4 = this.f14697b;
                    sVar4.onNext(obj);
                    try {
                        if (this.f14698c.l(obj)) {
                            this.e = true;
                            this.f14699d.dispose();
                            sVar4.onComplete();
                            break;
                        }
                    } catch (Throwable th5) {
                        ad.a(th5);
                        this.f14699d.dispose();
                        onError(th5);
                        return;
                    }
                }
                break;
            default:
                if (!this.e) {
                    try {
                        boolean l3 = this.f14698c.l(obj);
                        rg.s sVar5 = this.f14697b;
                        if (!l3) {
                            this.e = true;
                            this.f14699d.dispose();
                            sVar5.onComplete();
                            break;
                        } else {
                            sVar5.onNext(obj);
                            break;
                        }
                    } catch (Throwable th6) {
                        ad.a(th6);
                        this.f14699d.dispose();
                        onError(th6);
                    }
                }
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14696a) {
            case 0:
                if (DisposableHelper.validate(this.f14699d, bVar)) {
                    this.f14699d = bVar;
                    this.f14697b.onSubscribe(this);
                    break;
                }
                break;
            case 1:
                if (DisposableHelper.validate(this.f14699d, bVar)) {
                    this.f14699d = bVar;
                    this.f14697b.onSubscribe(this);
                    break;
                }
                break;
            case 2:
                if (DisposableHelper.validate(this.f14699d, bVar)) {
                    this.f14699d = bVar;
                    this.f14697b.onSubscribe(this);
                    break;
                }
                break;
            case 3:
                if (DisposableHelper.validate(this.f14699d, bVar)) {
                    this.f14699d = bVar;
                    this.f14697b.onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14699d, bVar)) {
                    this.f14699d = bVar;
                    this.f14697b.onSubscribe(this);
                    break;
                }
                break;
        }
    }
}
