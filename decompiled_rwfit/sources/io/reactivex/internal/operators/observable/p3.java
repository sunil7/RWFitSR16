package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class p3 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final ObservableSequenceEqual$EqualCoordinator f14825a;

    /* renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f14826b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14827c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14828d;
    public Throwable e;

    public p3(ObservableSequenceEqual$EqualCoordinator observableSequenceEqual$EqualCoordinator, int i3, int i10) {
        this.f14825a = observableSequenceEqual$EqualCoordinator;
        this.f14827c = i3;
        this.f14826b = new io.reactivex.internal.queue.b(i10);
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14828d = true;
        this.f14825a.drain();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.e = th2;
        this.f14828d = true;
        this.f14825a.drain();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        this.f14826b.offer(obj);
        this.f14825a.drain();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f14825a.setDisposable(bVar, this.f14827c);
    }
}
