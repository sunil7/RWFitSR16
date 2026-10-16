package ah;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import rg.s;

/* loaded from: classes2.dex */
public final class b implements s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final s f292a;

    /* renamed from: b, reason: collision with root package name */
    public ug.b f293b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f294c;

    public b(s sVar) {
        this.f292a = sVar;
    }

    @Override // ug.b
    public final void dispose() {
        this.f293b.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f293b.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f294c) {
            return;
        }
        this.f294c = true;
        ug.b bVar = this.f293b;
        s sVar = this.f292a;
        if (bVar != null) {
            try {
                sVar.onComplete();
                return;
            } catch (Throwable th2) {
                ad.a(th2);
                a1.b(th2);
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            sVar.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                sVar.onError(nullPointerException);
            } catch (Throwable th3) {
                ad.a(th3);
                a1.b(new CompositeException(nullPointerException, th3));
            }
        } catch (Throwable th4) {
            ad.a(th4);
            a1.b(new CompositeException(nullPointerException, th4));
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f294c) {
            a1.b(th2);
            return;
        }
        this.f294c = true;
        ug.b bVar = this.f293b;
        s sVar = this.f292a;
        if (bVar != null) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                sVar.onError(th2);
                return;
            } catch (Throwable th3) {
                ad.a(th3);
                a1.b(new CompositeException(th2, th3));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            sVar.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                sVar.onError(new CompositeException(th2, nullPointerException));
            } catch (Throwable th4) {
                ad.a(th4);
                a1.b(new CompositeException(th2, nullPointerException, th4));
            }
        } catch (Throwable th5) {
            ad.a(th5);
            a1.b(new CompositeException(th2, nullPointerException, th5));
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f294c) {
            return;
        }
        ug.b bVar = this.f293b;
        s sVar = this.f292a;
        if (bVar == null) {
            this.f294c = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                sVar.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    sVar.onError(nullPointerException);
                    return;
                } catch (Throwable th2) {
                    ad.a(th2);
                    a1.b(new CompositeException(nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                ad.a(th3);
                a1.b(new CompositeException(nullPointerException, th3));
                return;
            }
        }
        if (obj == null) {
            NullPointerException nullPointerException2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f293b.dispose();
                onError(nullPointerException2);
                return;
            } catch (Throwable th4) {
                ad.a(th4);
                onError(new CompositeException(nullPointerException2, th4));
                return;
            }
        }
        try {
            sVar.onNext(obj);
        } catch (Throwable th5) {
            ad.a(th5);
            try {
                this.f293b.dispose();
                onError(th5);
            } catch (Throwable th6) {
                ad.a(th6);
                onError(new CompositeException(th5, th6));
            }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f293b, bVar)) {
            this.f293b = bVar;
            try {
                this.f292a.onSubscribe(this);
            } catch (Throwable th2) {
                ad.a(th2);
                this.f294c = true;
                try {
                    bVar.dispose();
                    a1.b(th2);
                } catch (Throwable th3) {
                    ad.a(th3);
                    a1.b(new CompositeException(th2, th3));
                }
            }
        }
    }
}
