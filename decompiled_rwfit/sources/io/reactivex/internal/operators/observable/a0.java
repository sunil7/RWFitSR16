package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class a0 implements rg.s {

    /* renamed from: j, reason: collision with root package name */
    public static final ObservableCache$ReplayDisposable[] f14547j = new ObservableCache$ReplayDisposable[0];

    /* renamed from: k, reason: collision with root package name */
    public static final ObservableCache$ReplayDisposable[] f14548k = new ObservableCache$ReplayDisposable[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f14549a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f14550b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f14551c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f14552d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public final rg.l f14553f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14556i;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference f14555h = new AtomicReference(f14547j);

    /* renamed from: g, reason: collision with root package name */
    public final SequentialDisposable f14554g = new SequentialDisposable();

    public a0(rg.l lVar, int i3) {
        this.f14549a = i3;
        this.f14553f = lVar;
    }

    public final void a(Object obj) {
        if (this.f14552d == 0) {
            Object[] objArr = new Object[this.f14549a + 1];
            this.f14550b = objArr;
            this.f14551c = objArr;
            objArr[0] = obj;
            this.e = 1;
            this.f14552d = 1;
            return;
        }
        int i3 = this.e;
        int i10 = this.f14549a;
        if (i3 != i10) {
            this.f14551c[i3] = obj;
            this.e = i3 + 1;
            this.f14552d++;
        } else {
            Object[] objArr2 = new Object[i10 + 1];
            objArr2[0] = obj;
            this.f14551c[i10] = objArr2;
            this.f14551c = objArr2;
            this.e = 1;
            this.f14552d++;
        }
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14556i) {
            return;
        }
        this.f14556i = true;
        a(NotificationLite.complete());
        this.f14554g.dispose();
        for (ObservableCache$ReplayDisposable observableCache$ReplayDisposable : (ObservableCache$ReplayDisposable[]) this.f14555h.getAndSet(f14548k)) {
            observableCache$ReplayDisposable.replay();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14556i) {
            return;
        }
        this.f14556i = true;
        a(NotificationLite.error(th2));
        this.f14554g.dispose();
        for (ObservableCache$ReplayDisposable observableCache$ReplayDisposable : (ObservableCache$ReplayDisposable[]) this.f14555h.getAndSet(f14548k)) {
            observableCache$ReplayDisposable.replay();
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14556i) {
            return;
        }
        a(NotificationLite.next(obj));
        for (ObservableCache$ReplayDisposable observableCache$ReplayDisposable : (ObservableCache$ReplayDisposable[]) this.f14555h.get()) {
            observableCache$ReplayDisposable.replay();
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f14554g.update(bVar);
    }

    public final String toString() {
        int i3 = this.f14549a;
        int i10 = this.f14552d;
        ArrayList arrayList = new ArrayList(i10 + 1);
        Object[] objArr = this.f14550b;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            arrayList.add(objArr[i12]);
            i11++;
            i12++;
            if (i12 == i3) {
                objArr = (Object[]) objArr[i3];
                i12 = 0;
            }
        }
        return arrayList.toString();
    }
}
