package io.reactivex.internal.observers;

/* loaded from: classes2.dex */
public interface g {
    void drain();

    void innerComplete(InnerQueuedObserver innerQueuedObserver);

    void innerError(InnerQueuedObserver innerQueuedObserver, Throwable th2);

    void innerNext(InnerQueuedObserver innerQueuedObserver, Object obj);
}
