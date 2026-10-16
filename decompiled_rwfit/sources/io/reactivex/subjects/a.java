package io.reactivex.subjects;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;

/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public static final PublishSubject$PublishDisposable[] f15131c = new PublishSubject$PublishDisposable[0];

    /* renamed from: d, reason: collision with root package name */
    public static final PublishSubject$PublishDisposable[] f15132d = new PublishSubject$PublishDisposable[0];

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f15133a = new AtomicReference(f15132d);

    /* renamed from: b, reason: collision with root package name */
    public Throwable f15134b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(PublishSubject$PublishDisposable publishSubject$PublishDisposable) {
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArr;
        while (true) {
            AtomicReference atomicReference = this.f15133a;
            PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArr2 = (PublishSubject$PublishDisposable[]) atomicReference.get();
            if (publishSubject$PublishDisposableArr2 == f15131c || publishSubject$PublishDisposableArr2 == (publishSubject$PublishDisposableArr = f15132d)) {
                return;
            }
            int length = publishSubject$PublishDisposableArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (publishSubject$PublishDisposableArr2[i3] == publishSubject$PublishDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length != 1) {
                publishSubject$PublishDisposableArr = new PublishSubject$PublishDisposable[length - 1];
                System.arraycopy(publishSubject$PublishDisposableArr2, 0, publishSubject$PublishDisposableArr, 0, i3);
                System.arraycopy(publishSubject$PublishDisposableArr2, i3 + 1, publishSubject$PublishDisposableArr, i3, (length - i3) - 1);
            }
            while (!atomicReference.compareAndSet(publishSubject$PublishDisposableArr2, publishSubject$PublishDisposableArr)) {
                if (atomicReference.get() != publishSubject$PublishDisposableArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // rg.s
    public final void onComplete() {
        AtomicReference atomicReference = this.f15133a;
        Object obj = atomicReference.get();
        Object obj2 = f15131c;
        if (obj == obj2) {
            return;
        }
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArr = (PublishSubject$PublishDisposable[]) atomicReference.getAndSet(obj2);
        for (PublishSubject$PublishDisposable publishSubject$PublishDisposable : publishSubject$PublishDisposableArr) {
            publishSubject$PublishDisposable.onComplete();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        xg.c.b(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference atomicReference = this.f15133a;
        Object obj = atomicReference.get();
        Object obj2 = f15131c;
        if (obj == obj2) {
            a1.b(th2);
            return;
        }
        this.f15134b = th2;
        PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArr = (PublishSubject$PublishDisposable[]) atomicReference.getAndSet(obj2);
        for (PublishSubject$PublishDisposable publishSubject$PublishDisposable : publishSubject$PublishDisposableArr) {
            publishSubject$PublishDisposable.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        xg.c.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference atomicReference = this.f15133a;
        if (atomicReference.get() == f15131c) {
            return;
        }
        for (PublishSubject$PublishDisposable publishSubject$PublishDisposable : (PublishSubject$PublishDisposable[]) atomicReference.get()) {
            publishSubject$PublishDisposable.onNext(obj);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (this.f15133a.get() == f15131c) {
            bVar.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rg.l
    public final void subscribeActual(s sVar) {
        PublishSubject$PublishDisposable publishSubject$PublishDisposable = new PublishSubject$PublishDisposable(sVar, this);
        sVar.onSubscribe(publishSubject$PublishDisposable);
        while (true) {
            AtomicReference atomicReference = this.f15133a;
            PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArr = (PublishSubject$PublishDisposable[]) atomicReference.get();
            if (publishSubject$PublishDisposableArr == f15131c) {
                Throwable th2 = this.f15134b;
                if (th2 != null) {
                    sVar.onError(th2);
                    return;
                } else {
                    sVar.onComplete();
                    return;
                }
            }
            int length = publishSubject$PublishDisposableArr.length;
            PublishSubject$PublishDisposable[] publishSubject$PublishDisposableArr2 = new PublishSubject$PublishDisposable[length + 1];
            System.arraycopy(publishSubject$PublishDisposableArr, 0, publishSubject$PublishDisposableArr2, 0, length);
            publishSubject$PublishDisposableArr2[length] = publishSubject$PublishDisposable;
            while (!atomicReference.compareAndSet(publishSubject$PublishDisposableArr, publishSubject$PublishDisposableArr2)) {
                if (atomicReference.get() != publishSubject$PublishDisposableArr) {
                    break;
                }
            }
            if (publishSubject$PublishDisposable.isDisposed()) {
                c(publishSubject$PublishDisposable);
                return;
            }
            return;
        }
    }
}
