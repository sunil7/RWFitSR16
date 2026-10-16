package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class x4 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final ObservableZip$ZipCoordinator f15006a;

    /* renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f15007b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f15008c;

    /* renamed from: d, reason: collision with root package name */
    public Throwable f15009d;
    public final AtomicReference e = new AtomicReference();

    public x4(ObservableZip$ZipCoordinator observableZip$ZipCoordinator, int i3) {
        this.f15006a = observableZip$ZipCoordinator;
        this.f15007b = new io.reactivex.internal.queue.b(i3);
    }

    @Override // rg.s
    public final void onComplete() {
        this.f15008c = true;
        this.f15006a.drain();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f15009d = th2;
        this.f15008c = true;
        this.f15006a.drain();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        this.f15007b.offer(obj);
        this.f15006a.drain();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.e, bVar);
    }
}
