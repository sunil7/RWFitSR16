package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.hd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class t extends io.reactivex.internal.observers.h implements ug.b {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f14890g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final Callable f14891h;

    /* renamed from: i, reason: collision with root package name */
    public ug.b f14892i;

    /* renamed from: j, reason: collision with root package name */
    public Collection f14893j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f14894k;

    /* renamed from: l, reason: collision with root package name */
    public Object f14895l;

    public t(ah.c cVar, Callable callable, rg.q qVar) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14891h = callable;
        this.f14894k = qVar;
    }

    @Override // io.reactivex.internal.observers.h
    public final void a(ah.c cVar, Object obj) {
        switch (this.f14890g) {
            case 0:
                this.f14470b.onNext((Collection) obj);
                break;
            default:
                this.f14470b.onNext((Collection) obj);
                break;
        }
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14890g) {
            case 0:
                if (!this.f14472d) {
                    this.f14472d = true;
                    this.f14892i.dispose();
                    DisposableHelper.dispose((AtomicReference) this.f14895l);
                    if (b()) {
                        this.f14471c.clear();
                        break;
                    }
                }
                break;
            default:
                if (!this.f14472d) {
                    this.f14472d = true;
                    ((u) this.f14895l).dispose();
                    this.f14892i.dispose();
                    if (b()) {
                        this.f14471c.clear();
                        break;
                    }
                }
                break;
        }
    }

    public void f() {
        try {
            Object call = this.f14891h.call();
            xg.c.b(call, "The buffer supplied is null");
            Collection collection = (Collection) call;
            try {
                Object call2 = ((Callable) this.f14894k).call();
                xg.c.b(call2, "The boundary ObservableSource supplied is null");
                rg.q qVar = (rg.q) call2;
                s sVar = new s(this);
                if (DisposableHelper.replace((AtomicReference) this.f14895l, sVar)) {
                    synchronized (this) {
                        try {
                            Collection collection2 = this.f14893j;
                            if (collection2 == null) {
                                return;
                            }
                            this.f14893j = collection;
                            qVar.subscribe(sVar);
                            d(collection2, this);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                ad.a(th3);
                this.f14472d = true;
                this.f14892i.dispose();
                this.f14470b.onError(th3);
            }
        } catch (Throwable th4) {
            ad.a(th4);
            dispose();
            this.f14470b.onError(th4);
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14890g) {
        }
        return this.f14472d;
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14890g) {
            case 0:
                synchronized (this) {
                    try {
                        Collection collection = this.f14893j;
                        if (collection == null) {
                            return;
                        }
                        this.f14893j = null;
                        this.f14471c.offer(collection);
                        this.e = true;
                        if (b()) {
                            hd.b(this.f14471c, this.f14470b, this, this);
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            default:
                synchronized (this) {
                    try {
                        Collection collection2 = this.f14893j;
                        if (collection2 == null) {
                            return;
                        }
                        this.f14893j = null;
                        this.f14471c.offer(collection2);
                        this.e = true;
                        if (b()) {
                            hd.b(this.f14471c, this.f14470b, this, this);
                            return;
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14890g) {
            case 0:
                dispose();
                this.f14470b.onError(th2);
                break;
            default:
                dispose();
                this.f14470b.onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14890g) {
            case 0:
                synchronized (this) {
                    try {
                        Collection collection = this.f14893j;
                        if (collection == null) {
                            return;
                        }
                        collection.add(obj);
                        return;
                    } finally {
                    }
                }
            default:
                synchronized (this) {
                    try {
                        Collection collection2 = this.f14893j;
                        if (collection2 == null) {
                            return;
                        }
                        collection2.add(obj);
                        return;
                    } finally {
                    }
                }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14890g) {
            case 0:
                if (DisposableHelper.validate(this.f14892i, bVar)) {
                    this.f14892i = bVar;
                    ah.c cVar = this.f14470b;
                    try {
                        Object call = this.f14891h.call();
                        xg.c.b(call, "The buffer supplied is null");
                        this.f14893j = (Collection) call;
                        try {
                            Object call2 = ((Callable) this.f14894k).call();
                            xg.c.b(call2, "The boundary ObservableSource supplied is null");
                            rg.q qVar = (rg.q) call2;
                            s sVar = new s(this);
                            ((AtomicReference) this.f14895l).set(sVar);
                            cVar.onSubscribe(this);
                            if (!this.f14472d) {
                                qVar.subscribe(sVar);
                                break;
                            }
                        } catch (Throwable th2) {
                            ad.a(th2);
                            this.f14472d = true;
                            bVar.dispose();
                            EmptyDisposable.error(th2, cVar);
                            return;
                        }
                    } catch (Throwable th3) {
                        ad.a(th3);
                        this.f14472d = true;
                        bVar.dispose();
                        EmptyDisposable.error(th3, cVar);
                        return;
                    }
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14892i, bVar)) {
                    this.f14892i = bVar;
                    try {
                        Object call3 = this.f14891h.call();
                        xg.c.b(call3, "The buffer supplied is null");
                        this.f14893j = (Collection) call3;
                        u uVar = new u(this, 0);
                        this.f14895l = uVar;
                        this.f14470b.onSubscribe(this);
                        if (!this.f14472d) {
                            ((rg.q) this.f14894k).subscribe(uVar);
                            break;
                        }
                    } catch (Throwable th4) {
                        ad.a(th4);
                        this.f14472d = true;
                        bVar.dispose();
                        EmptyDisposable.error(th4, this.f14470b);
                    }
                }
                break;
        }
    }

    public t(ah.c cVar, Callable callable, Callable callable2) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14895l = new AtomicReference();
        this.f14891h = callable;
        this.f14894k = callable2;
    }
}
