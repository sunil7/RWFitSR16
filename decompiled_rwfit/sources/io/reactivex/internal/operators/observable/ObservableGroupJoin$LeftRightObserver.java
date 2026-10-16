package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableGroupJoin$LeftRightObserver extends AtomicReference<ug.b> implements rg.s, ug.b {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final q1 parent;

    public ObservableGroupJoin$LeftRightObserver(q1 q1Var, boolean z5) {
        this.parent = q1Var;
        this.isLeft = z5;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // rg.s
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.parent.innerError(th2);
    }

    @Override // rg.s
    public void onNext(Object obj) {
        this.parent.innerValue(this.isLeft, obj);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
