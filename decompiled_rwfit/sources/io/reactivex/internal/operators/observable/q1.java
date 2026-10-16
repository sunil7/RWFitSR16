package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public interface q1 {
    void innerClose(boolean z5, ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver);

    void innerCloseError(Throwable th2);

    void innerComplete(ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver);

    void innerError(Throwable th2);

    void innerValue(boolean z5, Object obj);
}
