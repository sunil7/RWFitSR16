package io.reactivex.internal.observers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;

/* loaded from: classes2.dex */
public final class f extends CountDownLatch implements s, Future, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public Object f14466a;

    /* renamed from: b, reason: collision with root package name */
    public Throwable f14467b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f14468c;

    public f() {
        super(1);
        this.f14468c = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        DisposableHelper disposableHelper;
        while (true) {
            AtomicReference atomicReference = this.f14468c;
            ug.b bVar = (ug.b) atomicReference.get();
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
            while (!atomicReference.compareAndSet(bVar, disposableHelper)) {
                if (atomicReference.get() != bVar) {
                    break;
                }
            }
            if (bVar != null) {
                bVar.dispose();
            }
            countDown();
            return true;
        }
    }

    @Override // ug.b
    public final void dispose() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        if (getCount() != 0) {
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th2 = this.f14467b;
        if (th2 == null) {
            return this.f14466a;
        }
        throw new ExecutionException(th2);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return DisposableHelper.isDisposed((ug.b) this.f14468c.get());
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return getCount() == 0;
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14466a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        while (true) {
            AtomicReference atomicReference = this.f14468c;
            ug.b bVar = (ug.b) atomicReference.get();
            if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                return;
            }
            while (!atomicReference.compareAndSet(bVar, this)) {
                if (atomicReference.get() != bVar) {
                    break;
                }
            }
            countDown();
            return;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14467b != null) {
            a1.b(th2);
            return;
        }
        this.f14467b = th2;
        while (true) {
            AtomicReference atomicReference = this.f14468c;
            ug.b bVar = (ug.b) atomicReference.get();
            if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                break;
            }
            while (!atomicReference.compareAndSet(bVar, this)) {
                if (atomicReference.get() != bVar) {
                    break;
                }
            }
            countDown();
            return;
        }
        a1.b(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14466a == null) {
            this.f14466a = obj;
        } else {
            ((ug.b) this.f14468c.get()).dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.f14468c, bVar);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        if (getCount() != 0 && !await(j4, timeUnit)) {
            throw new TimeoutException();
        }
        if (!isCancelled()) {
            Throwable th2 = this.f14467b;
            if (th2 == null) {
                return this.f14466a;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
