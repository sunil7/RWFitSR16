package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableGroupBy$GroupByObserver<T, K, V> extends AtomicInteger implements rg.s, ug.b {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final rg.s actual;
    final int bufferSize;
    final boolean delayError;
    final vg.o keySelector;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14521s;
    final vg.o valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final Map<Object, o1> groups = new ConcurrentHashMap();

    public ObservableGroupBy$GroupByObserver(rg.s sVar, vg.o oVar, vg.o oVar2, int i3, boolean z5) {
        this.actual = sVar;
        this.keySelector = oVar;
        this.valueSelector = oVar2;
        this.bufferSize = i3;
        this.delayError = z5;
        lazySet(1);
    }

    public void cancel(K k10) {
        if (k10 == null) {
            k10 = (K) NULL_KEY;
        }
        this.groups.remove(k10);
        if (decrementAndGet() == 0) {
            this.f14521s.dispose();
        }
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
            this.f14521s.dispose();
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled.get();
    }

    @Override // rg.s
    public void onComplete() {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((o1) obj).f14792b.onComplete();
        }
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        ArrayList arrayList = new ArrayList(this.groups.values());
        this.groups.clear();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((o1) obj).f14792b.onError(th2);
        }
        this.actual.onError(th2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rg.s
    public void onNext(T t8) {
        try {
            Object apply = this.keySelector.apply(t8);
            Object obj = apply != null ? apply : NULL_KEY;
            o1 o1Var = this.groups.get(obj);
            if (o1Var == null) {
                if (this.cancelled.get()) {
                    return;
                }
                o1Var = new o1(apply, new ObservableGroupBy$State(this.bufferSize, this, apply, this.delayError));
                this.groups.put(obj, o1Var);
                getAndIncrement();
                this.actual.onNext(o1Var);
            }
            try {
                Object apply2 = this.valueSelector.apply(t8);
                xg.c.b(apply2, "The value supplied is null");
                o1Var.f14792b.onNext(apply2);
            } catch (Throwable th2) {
                ad.a(th2);
                this.f14521s.dispose();
                onError(th2);
            }
        } catch (Throwable th3) {
            ad.a(th3);
            this.f14521s.dispose();
            onError(th3);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14521s, bVar)) {
            this.f14521s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
