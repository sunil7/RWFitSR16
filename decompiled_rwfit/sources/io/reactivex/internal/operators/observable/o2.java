package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class o2 implements rg.s, ug.b {
    public static final ObservablePublish$InnerDisposable[] e = new ObservablePublish$InnerDisposable[0];

    /* renamed from: f, reason: collision with root package name */
    public static final ObservablePublish$InnerDisposable[] f14793f = new ObservablePublish$InnerDisposable[0];

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f14794a;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f14797d = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f14795b = new AtomicReference(e);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f14796c = new AtomicBoolean();

    public o2(AtomicReference atomicReference) {
        this.f14794a = atomicReference;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ObservablePublish$InnerDisposable observablePublish$InnerDisposable) {
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr;
        while (true) {
            AtomicReference atomicReference = this.f14795b;
            ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr2 = (ObservablePublish$InnerDisposable[]) atomicReference.get();
            int length = observablePublish$InnerDisposableArr2.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (observablePublish$InnerDisposableArr2[i3].equals(observablePublish$InnerDisposable)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                observablePublish$InnerDisposableArr = e;
            } else {
                ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr3 = new ObservablePublish$InnerDisposable[length - 1];
                System.arraycopy(observablePublish$InnerDisposableArr2, 0, observablePublish$InnerDisposableArr3, 0, i3);
                System.arraycopy(observablePublish$InnerDisposableArr2, i3 + 1, observablePublish$InnerDisposableArr3, i3, (length - i3) - 1);
                observablePublish$InnerDisposableArr = observablePublish$InnerDisposableArr3;
            }
            while (!atomicReference.compareAndSet(observablePublish$InnerDisposableArr2, observablePublish$InnerDisposableArr)) {
                if (atomicReference.get() != observablePublish$InnerDisposableArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // ug.b
    public final void dispose() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.f14795b;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr = f14793f;
        if (((ObservablePublish$InnerDisposable[]) atomicReference2.getAndSet(observablePublish$InnerDisposableArr)) != observablePublish$InnerDisposableArr) {
            do {
                atomicReference = this.f14794a;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            DisposableHelper.dispose(this.f14797d);
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14795b.get() == f14793f;
    }

    @Override // rg.s
    public final void onComplete() {
        AtomicReference atomicReference;
        do {
            atomicReference = this.f14794a;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        for (ObservablePublish$InnerDisposable observablePublish$InnerDisposable : (ObservablePublish$InnerDisposable[]) this.f14795b.getAndSet(f14793f)) {
            observablePublish$InnerDisposable.child.onComplete();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        AtomicReference atomicReference;
        do {
            atomicReference = this.f14794a;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArr = (ObservablePublish$InnerDisposable[]) this.f14795b.getAndSet(f14793f);
        if (observablePublish$InnerDisposableArr.length == 0) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        for (ObservablePublish$InnerDisposable observablePublish$InnerDisposable : observablePublish$InnerDisposableArr) {
            observablePublish$InnerDisposable.child.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        for (ObservablePublish$InnerDisposable observablePublish$InnerDisposable : (ObservablePublish$InnerDisposable[]) this.f14795b.get()) {
            observablePublish$InnerDisposable.child.onNext(obj);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.f14797d, bVar);
    }
}
