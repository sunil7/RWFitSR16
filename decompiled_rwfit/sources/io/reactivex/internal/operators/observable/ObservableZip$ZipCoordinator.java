package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableZip$ZipCoordinator<T, R> extends AtomicInteger implements ug.b {
    private static final long serialVersionUID = 2983708048395377667L;
    final rg.s actual;
    volatile boolean cancelled;
    final boolean delayError;
    final x4[] observers;
    final T[] row;
    final vg.o zipper;

    public ObservableZip$ZipCoordinator(rg.s sVar, vg.o oVar, int i3, boolean z5) {
        this.actual = sVar;
        this.zipper = oVar;
        this.observers = new x4[i3];
        this.row = (T[]) new Object[i3];
        this.delayError = z5;
    }

    public void cancel() {
        clear();
        cancelSources();
    }

    public void cancelSources() {
        for (x4 x4Var : this.observers) {
            DisposableHelper.dispose(x4Var.e);
        }
    }

    public boolean checkTerminated(boolean z5, boolean z6, rg.s sVar, boolean z8, x4 x4Var) {
        if (this.cancelled) {
            cancel();
            return true;
        }
        if (!z5) {
            return false;
        }
        if (z8) {
            if (!z6) {
                return false;
            }
            Throwable th2 = x4Var.f15009d;
            cancel();
            if (th2 != null) {
                sVar.onError(th2);
            } else {
                sVar.onComplete();
            }
            return true;
        }
        Throwable th3 = x4Var.f15009d;
        if (th3 != null) {
            cancel();
            sVar.onError(th3);
            return true;
        }
        if (!z6) {
            return false;
        }
        cancel();
        sVar.onComplete();
        return true;
    }

    public void clear() {
        for (x4 x4Var : this.observers) {
            x4Var.f15007b.clear();
        }
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelSources();
        if (getAndIncrement() == 0) {
            clear();
        }
    }

    public void drain() {
        Throwable th2;
        if (getAndIncrement() != 0) {
            return;
        }
        x4[] x4VarArr = this.observers;
        rg.s sVar = this.actual;
        T[] tArr = this.row;
        boolean z5 = this.delayError;
        int i3 = 1;
        while (true) {
            int i10 = 0;
            int i11 = 0;
            for (x4 x4Var : x4VarArr) {
                if (tArr[i11] == null) {
                    boolean z6 = x4Var.f15008c;
                    Object poll = x4Var.f15007b.poll();
                    boolean z8 = poll == null;
                    if (checkTerminated(z6, z8, sVar, z5, x4Var)) {
                        return;
                    }
                    if (z8) {
                        i10++;
                    } else {
                        tArr[i11] = poll;
                    }
                } else if (x4Var.f15008c && !z5 && (th2 = x4Var.f15009d) != null) {
                    cancel();
                    sVar.onError(th2);
                    return;
                }
                i11++;
            }
            if (i10 != 0) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                try {
                    Object apply = this.zipper.apply(tArr.clone());
                    xg.c.b(apply, "The zipper returned a null value");
                    sVar.onNext(apply);
                    Arrays.fill(tArr, (Object) null);
                } catch (Throwable th3) {
                    ad.a(th3);
                    cancel();
                    sVar.onError(th3);
                    return;
                }
            }
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(rg.q[] qVarArr, int i3) {
        x4[] x4VarArr = this.observers;
        int length = x4VarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            x4VarArr[i10] = new x4(this, i3);
        }
        lazySet(0);
        this.actual.onSubscribe(this);
        for (int i11 = 0; i11 < length && !this.cancelled; i11++) {
            qVarArr[i11].subscribe(x4VarArr[i11]);
        }
    }
}
