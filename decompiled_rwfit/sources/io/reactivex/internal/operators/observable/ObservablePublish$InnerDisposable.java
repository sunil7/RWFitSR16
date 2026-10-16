package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservablePublish$InnerDisposable<T> extends AtomicReference<Object> implements ug.b {
    private static final long serialVersionUID = -1100270633763673112L;
    final rg.s child;

    public ObservablePublish$InnerDisposable(rg.s sVar) {
        this.child = sVar;
    }

    @Override // ug.b
    public void dispose() {
        Object andSet = getAndSet(this);
        if (andSet == null || andSet == this) {
            return;
        }
        ((o2) andSet).a(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get() == this;
    }

    public void setParent(o2 o2Var) {
        if (compareAndSet(null, o2Var)) {
            return;
        }
        o2Var.a(this);
    }
}
