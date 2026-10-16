package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.hd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class y extends io.reactivex.internal.observers.h implements Runnable, ug.b {

    /* renamed from: g, reason: collision with root package name */
    public final Callable f15010g;

    /* renamed from: h, reason: collision with root package name */
    public final long f15011h;

    /* renamed from: i, reason: collision with root package name */
    public final long f15012i;

    /* renamed from: j, reason: collision with root package name */
    public final TimeUnit f15013j;

    /* renamed from: k, reason: collision with root package name */
    public final rg.w f15014k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedList f15015l;

    /* renamed from: m, reason: collision with root package name */
    public ug.b f15016m;

    public y(ah.c cVar, Callable callable, long j4, long j10, TimeUnit timeUnit, rg.w wVar) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f15010g = callable;
        this.f15011h = j4;
        this.f15012i = j10;
        this.f15013j = timeUnit;
        this.f15014k = wVar;
        this.f15015l = new LinkedList();
    }

    @Override // io.reactivex.internal.observers.h
    public final void a(ah.c cVar, Object obj) {
        cVar.onNext((Collection) obj);
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f14472d) {
            return;
        }
        this.f14472d = true;
        synchronized (this) {
            this.f15015l.clear();
        }
        this.f15016m.dispose();
        this.f15014k.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14472d;
    }

    @Override // rg.s
    public final void onComplete() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f15015l);
            this.f15015l.clear();
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            this.f14471c.offer((Collection) obj);
        }
        this.e = true;
        if (b()) {
            hd.b(this.f14471c, this.f14470b, this.f15014k, this);
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.e = true;
        synchronized (this) {
            this.f15015l.clear();
        }
        this.f14470b.onError(th2);
        this.f15014k.dispose();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Iterator it = this.f15015l.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(obj);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        rg.w wVar = this.f15014k;
        ah.c cVar = this.f14470b;
        if (DisposableHelper.validate(this.f15016m, bVar)) {
            this.f15016m = bVar;
            try {
                Object call = this.f15010g.call();
                xg.c.b(call, "The buffer supplied is null");
                Collection collection = (Collection) call;
                this.f15015l.add(collection);
                cVar.onSubscribe(this);
                TimeUnit timeUnit = this.f15013j;
                rg.w wVar2 = this.f15014k;
                long j4 = this.f15012i;
                wVar2.c(this, j4, j4, timeUnit);
                wVar.a(new x(this, collection, 1), this.f15011h, this.f15013j);
            } catch (Throwable th2) {
                ad.a(th2);
                bVar.dispose();
                EmptyDisposable.error(th2, cVar);
                wVar.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f14472d) {
            return;
        }
        try {
            Object call = this.f15010g.call();
            xg.c.b(call, "The bufferSupplier returned a null buffer");
            Collection collection = (Collection) call;
            synchronized (this) {
                try {
                    if (this.f14472d) {
                        return;
                    }
                    this.f15015l.add(collection);
                    this.f15014k.a(new x(this, collection, 0), this.f15011h, this.f15013j);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            ad.a(th3);
            this.f14470b.onError(th3);
            dispose();
        }
    }
}
