package io.reactivex.subjects;

import androidx.appcompat.widget.b0;
import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.util.NotificationLite;
import rg.s;
import vg.p;

/* loaded from: classes2.dex */
public final class b extends c implements p {

    /* renamed from: a, reason: collision with root package name */
    public final a f15135a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15136b;

    /* renamed from: c, reason: collision with root package name */
    public b0 f15137c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f15138d;

    public b(a aVar) {
        this.f15135a = aVar;
    }

    public final void c() {
        b0 b0Var;
        Object[] objArr;
        while (true) {
            synchronized (this) {
                try {
                    b0Var = this.f15137c;
                    if (b0Var == null) {
                        this.f15136b = false;
                        return;
                    }
                    this.f15137c = null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            for (Object[] objArr2 = (Object[]) b0Var.f873b; objArr2 != null; objArr2 = objArr2[4]) {
                for (int i3 = 0; i3 < 4 && (objArr = objArr2[i3]) != null && !NotificationLite.acceptFull(objArr, this.f15135a); i3++) {
                }
            }
        }
    }

    @Override // vg.p
    public final boolean l(Object obj) {
        return NotificationLite.acceptFull(obj, this.f15135a);
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f15138d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f15138d) {
                    return;
                }
                this.f15138d = true;
                if (!this.f15136b) {
                    this.f15136b = true;
                    this.f15135a.onComplete();
                    return;
                }
                b0 b0Var = this.f15137c;
                if (b0Var == null) {
                    b0Var = new b0();
                    this.f15137c = b0Var;
                }
                b0Var.a(NotificationLite.complete());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f15138d) {
            a1.b(th2);
            return;
        }
        synchronized (this) {
            try {
                boolean z5 = true;
                if (!this.f15138d) {
                    this.f15138d = true;
                    if (this.f15136b) {
                        b0 b0Var = this.f15137c;
                        if (b0Var == null) {
                            b0Var = new b0();
                            this.f15137c = b0Var;
                        }
                        ((Object[]) b0Var.f873b)[0] = NotificationLite.error(th2);
                        return;
                    }
                    this.f15136b = true;
                    z5 = false;
                }
                if (z5) {
                    a1.b(th2);
                } else {
                    this.f15135a.onError(th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f15138d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f15138d) {
                    return;
                }
                if (!this.f15136b) {
                    this.f15136b = true;
                    this.f15135a.onNext(obj);
                    c();
                } else {
                    b0 b0Var = this.f15137c;
                    if (b0Var == null) {
                        b0Var = new b0();
                        this.f15137c = b0Var;
                    }
                    b0Var.a(NotificationLite.next(obj));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        boolean z5 = true;
        if (!this.f15138d) {
            synchronized (this) {
                try {
                    if (!this.f15138d) {
                        if (this.f15136b) {
                            b0 b0Var = this.f15137c;
                            if (b0Var == null) {
                                b0Var = new b0();
                                this.f15137c = b0Var;
                            }
                            b0Var.a(NotificationLite.disposable(bVar));
                            return;
                        }
                        this.f15136b = true;
                        z5 = false;
                    }
                } finally {
                }
            }
        }
        if (z5) {
            bVar.dispose();
        } else {
            this.f15135a.onSubscribe(bVar);
            c();
        }
    }

    @Override // rg.l
    public final void subscribeActual(s sVar) {
        this.f15135a.subscribe(sVar);
    }
}
