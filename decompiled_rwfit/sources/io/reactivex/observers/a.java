package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rg.b;
import rg.h;
import rg.s;
import rg.z;

/* loaded from: classes2.dex */
public final class a implements s, h, z, b, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f15125a;

    /* renamed from: b, reason: collision with root package name */
    public final VolatileSizeArrayList f15126b;

    /* renamed from: c, reason: collision with root package name */
    public final VolatileSizeArrayList f15127c;

    /* renamed from: d, reason: collision with root package name */
    public Thread f15128d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final s f15129f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f15130g;

    public a() {
        TestObserver$EmptyObserver testObserver$EmptyObserver = TestObserver$EmptyObserver.INSTANCE;
        this.f15126b = new VolatileSizeArrayList();
        this.f15127c = new VolatileSizeArrayList();
        this.f15125a = new CountDownLatch(1);
        this.f15130g = new AtomicReference();
        this.f15129f = testObserver$EmptyObserver;
    }

    @Override // ug.b
    public final void dispose() {
        DisposableHelper.dispose(this.f15130g);
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((ug.b) this.f15130g.get());
    }

    @Override // rg.s
    public final void onComplete() {
        CountDownLatch countDownLatch = this.f15125a;
        if (!this.e) {
            this.e = true;
            if (this.f15130g.get() == null) {
                this.f15127c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f15128d = Thread.currentThread();
            this.f15129f.onComplete();
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        CountDownLatch countDownLatch = this.f15125a;
        boolean z5 = this.e;
        VolatileSizeArrayList volatileSizeArrayList = this.f15127c;
        if (!z5) {
            this.e = true;
            if (this.f15130g.get() == null) {
                volatileSizeArrayList.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f15128d = Thread.currentThread();
            if (th2 == null) {
                volatileSizeArrayList.add(new NullPointerException("onError received a null Throwable"));
            } else {
                volatileSizeArrayList.add(th2);
            }
            this.f15129f.onError(th2);
            countDownLatch.countDown();
        } catch (Throwable th3) {
            countDownLatch.countDown();
            throw th3;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        boolean z5 = this.e;
        VolatileSizeArrayList volatileSizeArrayList = this.f15127c;
        if (!z5) {
            this.e = true;
            if (this.f15130g.get() == null) {
                volatileSizeArrayList.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f15128d = Thread.currentThread();
        this.f15126b.add(obj);
        if (obj == null) {
            volatileSizeArrayList.add(new NullPointerException("onNext received a null value"));
        }
        this.f15129f.onNext(obj);
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f15128d = Thread.currentThread();
        VolatileSizeArrayList volatileSizeArrayList = this.f15127c;
        if (bVar == null) {
            volatileSizeArrayList.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        AtomicReference atomicReference = this.f15130g;
        while (!atomicReference.compareAndSet(null, bVar)) {
            if (atomicReference.get() != null) {
                bVar.dispose();
                if (atomicReference.get() != DisposableHelper.DISPOSED) {
                    volatileSizeArrayList.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
                    return;
                }
                return;
            }
        }
        this.f15129f.onSubscribe(bVar);
    }

    @Override // rg.h
    public final void onSuccess(Object obj) {
        onNext(obj);
        onComplete();
    }
}
