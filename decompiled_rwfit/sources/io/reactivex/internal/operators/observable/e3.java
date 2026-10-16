package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public interface e3 {
    void complete();

    void error(Throwable th2);

    void next(Object obj);

    void replay(ObservableReplay$InnerDisposable observableReplay$InnerDisposable);
}
