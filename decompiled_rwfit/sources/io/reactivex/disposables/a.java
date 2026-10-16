package io.reactivex.disposables;

import ug.b;

/* loaded from: classes2.dex */
public abstract class a {
    public static b a(Runnable runnable) {
        return new RunnableDisposable(runnable);
    }
}
