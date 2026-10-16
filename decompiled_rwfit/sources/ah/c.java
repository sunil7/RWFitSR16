package ah;

import androidx.appcompat.widget.b0;
import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import rg.s;

/* loaded from: classes2.dex */
public final class c implements s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final s f295a;

    /* renamed from: b, reason: collision with root package name */
    public ug.b f296b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f297c;

    /* renamed from: d, reason: collision with root package name */
    public b0 f298d;
    public volatile boolean e;

    public c(s sVar) {
        this.f295a = sVar;
    }

    @Override // ug.b
    public final void dispose() {
        this.f296b.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f296b.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                if (!this.f297c) {
                    this.e = true;
                    this.f297c = true;
                    this.f295a.onComplete();
                } else {
                    b0 b0Var = this.f298d;
                    if (b0Var == null) {
                        b0Var = new b0();
                        this.f298d = b0Var;
                    }
                    b0Var.a(NotificationLite.complete());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.e) {
            a1.b(th2);
            return;
        }
        synchronized (this) {
            try {
                boolean z5 = true;
                if (!this.e) {
                    if (this.f297c) {
                        this.e = true;
                        b0 b0Var = this.f298d;
                        if (b0Var == null) {
                            b0Var = new b0();
                            this.f298d = b0Var;
                        }
                        ((Object[]) b0Var.f873b)[0] = NotificationLite.error(th2);
                        return;
                    }
                    this.e = true;
                    this.f297c = true;
                    z5 = false;
                }
                if (z5) {
                    a1.b(th2);
                } else {
                    this.f295a.onError(th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        Object[] objArr;
        if (this.e) {
            return;
        }
        if (obj == null) {
            this.f296b.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                if (this.f297c) {
                    b0 b0Var = this.f298d;
                    if (b0Var == null) {
                        b0Var = new b0();
                        this.f298d = b0Var;
                    }
                    b0Var.a(NotificationLite.next(obj));
                    return;
                }
                this.f297c = true;
                this.f295a.onNext(obj);
                while (true) {
                    synchronized (this) {
                        try {
                            b0 b0Var2 = this.f298d;
                            if (b0Var2 == null) {
                                this.f297c = false;
                                return;
                            }
                            this.f298d = null;
                            s sVar = this.f295a;
                            for (Object[] objArr2 = (Object[]) b0Var2.f873b; objArr2 != null; objArr2 = objArr2[4]) {
                                for (int i3 = 0; i3 < 4 && (objArr = objArr2[i3]) != null; i3++) {
                                    if (NotificationLite.acceptFull(objArr, sVar)) {
                                        return;
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f296b, bVar)) {
            this.f296b = bVar;
            this.f295a.onSubscribe(this);
        }
    }
}
