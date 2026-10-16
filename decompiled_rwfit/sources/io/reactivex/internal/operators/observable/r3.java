package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class r3 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final ObservableSequenceEqualSingle$EqualCoordinator f14860a;

    /* renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f14861b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14862c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14863d;
    public Throwable e;

    public r3(ObservableSequenceEqualSingle$EqualCoordinator observableSequenceEqualSingle$EqualCoordinator, int i3, int i10) {
        this.f14860a = observableSequenceEqualSingle$EqualCoordinator;
        this.f14862c = i3;
        this.f14861b = new io.reactivex.internal.queue.b(i10);
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14863d = true;
        this.f14860a.drain();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.e = th2;
        this.f14863d = true;
        this.f14860a.drain();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        this.f14861b.offer(obj);
        this.f14860a.drain();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f14860a.setDisposable(bVar, this.f14862c);
    }
}
