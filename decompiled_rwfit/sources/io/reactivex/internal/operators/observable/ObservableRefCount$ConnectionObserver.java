package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableRefCount$ConnectionObserver extends AtomicReference<ug.b> implements rg.s, ug.b {
    private static final long serialVersionUID = 3813126992133394324L;
    final ug.a currentBase;
    final ug.b resource;
    final rg.s subscriber;
    final /* synthetic */ y2 this$0;

    public ObservableRefCount$ConnectionObserver(y2 y2Var, rg.s sVar, ug.a aVar, ug.b bVar) {
        this.this$0 = y2Var;
        this.subscriber = sVar;
        this.currentBase = aVar;
        this.resource = bVar;
    }

    public void cleanup() {
        this.this$0.e.lock();
        try {
            if (this.this$0.f15022c == this.currentBase) {
                Object obj = this.this$0.f15021b;
                if (obj instanceof ug.b) {
                    ((ug.b) obj).dispose();
                }
                this.this$0.f15022c.dispose();
                this.this$0.f15022c = new ug.a();
                this.this$0.f15023d.set(0);
            }
            this.this$0.e.unlock();
        } catch (Throwable th2) {
            this.this$0.e.unlock();
            throw th2;
        }
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.resource.dispose();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // rg.s
    public void onComplete() {
        cleanup();
        this.subscriber.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        cleanup();
        this.subscriber.onError(th2);
    }

    @Override // rg.s
    public void onNext(Object obj) {
        this.subscriber.onNext(obj);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
