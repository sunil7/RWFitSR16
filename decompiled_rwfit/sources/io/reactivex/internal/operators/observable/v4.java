package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class v4 extends io.reactivex.internal.observers.h implements ug.b, Runnable {

    /* renamed from: g, reason: collision with root package name */
    public final long f14951g;

    /* renamed from: h, reason: collision with root package name */
    public final long f14952h;

    /* renamed from: i, reason: collision with root package name */
    public final TimeUnit f14953i;

    /* renamed from: j, reason: collision with root package name */
    public final rg.w f14954j;

    /* renamed from: k, reason: collision with root package name */
    public final int f14955k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedList f14956l;

    /* renamed from: m, reason: collision with root package name */
    public ug.b f14957m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f14958n;

    public v4(ah.c cVar, long j4, long j10, TimeUnit timeUnit, rg.w wVar, int i3) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14951g = j4;
        this.f14952h = j10;
        this.f14953i = timeUnit;
        this.f14954j = wVar;
        this.f14955k = i3;
        this.f14956l = new LinkedList();
    }

    @Override // ug.b
    public final void dispose() {
        this.f14472d = true;
    }

    public final void f() {
        io.reactivex.internal.queue.a aVar = this.f14471c;
        ah.c cVar = this.f14470b;
        LinkedList linkedList = this.f14956l;
        int i3 = 1;
        while (!this.f14958n) {
            boolean z5 = this.e;
            Object poll = aVar.poll();
            boolean z6 = poll == null;
            boolean z8 = poll instanceof u4;
            if (z5 && (z6 || z8)) {
                aVar.clear();
                Throwable th2 = this.f14473f;
                if (th2 != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((io.reactivex.subjects.d) it.next()).onError(th2);
                    }
                } else {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        ((io.reactivex.subjects.d) it2.next()).onComplete();
                    }
                }
                this.f14954j.dispose();
                linkedList.clear();
                return;
            }
            if (z6) {
                i3 = this.f14469a.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else if (z8) {
                u4 u4Var = (u4) poll;
                if (!u4Var.f14929b) {
                    linkedList.remove(u4Var.f14928a);
                    u4Var.f14928a.onComplete();
                    if (linkedList.isEmpty() && this.f14472d) {
                        this.f14958n = true;
                    }
                } else if (!this.f14472d) {
                    io.reactivex.subjects.d dVar = new io.reactivex.subjects.d(this.f14955k);
                    linkedList.add(dVar);
                    cVar.onNext(dVar);
                    this.f14954j.a(new x3(4, this, dVar), this.f14951g, this.f14953i);
                }
            } else {
                Iterator it3 = linkedList.iterator();
                while (it3.hasNext()) {
                    ((io.reactivex.subjects.d) it3.next()).onNext(poll);
                }
            }
        }
        this.f14957m.dispose();
        this.f14954j.dispose();
        aVar.clear();
        linkedList.clear();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14472d;
    }

    @Override // rg.s
    public final void onComplete() {
        this.e = true;
        if (b()) {
            f();
        }
        this.f14470b.onComplete();
        this.f14954j.dispose();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14473f = th2;
        this.e = true;
        if (b()) {
            f();
        }
        this.f14470b.onError(th2);
        this.f14954j.dispose();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (c()) {
            Iterator it = this.f14956l.iterator();
            while (it.hasNext()) {
                ((io.reactivex.subjects.d) it.next()).onNext(obj);
            }
            if (this.f14469a.addAndGet(-1) == 0) {
                return;
            }
        } else {
            this.f14471c.offer(obj);
            if (!b()) {
                return;
            }
        }
        f();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14957m, bVar)) {
            this.f14957m = bVar;
            this.f14470b.onSubscribe(this);
            if (this.f14472d) {
                return;
            }
            io.reactivex.subjects.d dVar = new io.reactivex.subjects.d(this.f14955k);
            this.f14956l.add(dVar);
            this.f14470b.onNext(dVar);
            this.f14954j.a(new x3(4, this, dVar), this.f14951g, this.f14953i);
            rg.w wVar = this.f14954j;
            long j4 = this.f14952h;
            wVar.c(this, j4, j4, this.f14953i);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        u4 u4Var = new u4(new io.reactivex.subjects.d(this.f14955k), true);
        if (!this.f14472d) {
            this.f14471c.offer(u4Var);
        }
        if (b()) {
            f();
        }
    }
}
