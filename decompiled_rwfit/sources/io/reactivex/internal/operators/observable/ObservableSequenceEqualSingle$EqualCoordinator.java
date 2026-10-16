package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class ObservableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements ug.b {
    private static final long serialVersionUID = -6178010334400373240L;
    final rg.z actual;
    volatile boolean cancelled;
    final vg.d comparer;
    final rg.q first;
    final r3[] observers;
    final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
    final rg.q second;

    /* renamed from: v1, reason: collision with root package name */
    T f14530v1;

    /* renamed from: v2, reason: collision with root package name */
    T f14531v2;

    public ObservableSequenceEqualSingle$EqualCoordinator(rg.z zVar, int i3, rg.q qVar, rg.q qVar2, vg.d dVar) {
        this.actual = zVar;
        this.first = qVar;
        this.second = qVar2;
        this.comparer = dVar;
        this.observers = new r3[]{new r3(this, 0, i3), new r3(this, 1, i3)};
    }

    public void cancel(io.reactivex.internal.queue.b bVar, io.reactivex.internal.queue.b bVar2) {
        this.cancelled = true;
        bVar.clear();
        bVar2.clear();
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.resources.dispose();
        if (getAndIncrement() == 0) {
            r3[] r3VarArr = this.observers;
            r3VarArr[0].f14861b.clear();
            r3VarArr[1].f14861b.clear();
        }
    }

    public void drain() {
        Throwable th2;
        Throwable th3;
        if (getAndIncrement() != 0) {
            return;
        }
        r3[] r3VarArr = this.observers;
        r3 r3Var = r3VarArr[0];
        io.reactivex.internal.queue.b bVar = r3Var.f14861b;
        r3 r3Var2 = r3VarArr[1];
        io.reactivex.internal.queue.b bVar2 = r3Var2.f14861b;
        int i3 = 1;
        while (!this.cancelled) {
            boolean z5 = r3Var.f14863d;
            if (z5 && (th3 = r3Var.e) != null) {
                cancel(bVar, bVar2);
                this.actual.onError(th3);
                return;
            }
            boolean z6 = r3Var2.f14863d;
            if (z6 && (th2 = r3Var2.e) != null) {
                cancel(bVar, bVar2);
                this.actual.onError(th2);
                return;
            }
            if (this.f14530v1 == null) {
                this.f14530v1 = (T) bVar.poll();
            }
            boolean z8 = this.f14530v1 == null;
            if (this.f14531v2 == null) {
                this.f14531v2 = (T) bVar2.poll();
            }
            T t8 = this.f14531v2;
            boolean z10 = t8 == null;
            if (z5 && z6 && z8 && z10) {
                this.actual.onSuccess(Boolean.TRUE);
                return;
            }
            if (z5 && z6 && z8 != z10) {
                cancel(bVar, bVar2);
                this.actual.onSuccess(Boolean.FALSE);
                return;
            }
            if (!z8 && !z10) {
                try {
                    vg.d dVar = this.comparer;
                    T t10 = this.f14530v1;
                    ((ec.a) dVar).getClass();
                    if (!xg.c.a(t10, t8)) {
                        cancel(bVar, bVar2);
                        this.actual.onSuccess(Boolean.FALSE);
                        return;
                    } else {
                        this.f14530v1 = null;
                        this.f14531v2 = null;
                    }
                } catch (Throwable th4) {
                    ad.a(th4);
                    cancel(bVar, bVar2);
                    this.actual.onError(th4);
                    return;
                }
            }
            if (z8 || z10) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
        bVar.clear();
        bVar2.clear();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public boolean setDisposable(ug.b bVar, int i3) {
        return this.resources.setResource(i3, bVar);
    }

    public void subscribe() {
        r3[] r3VarArr = this.observers;
        this.first.subscribe(r3VarArr[0]);
        this.second.subscribe(r3VarArr[1]);
    }
}
