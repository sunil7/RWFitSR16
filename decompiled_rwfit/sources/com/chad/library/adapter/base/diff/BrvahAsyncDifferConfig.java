package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.p;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class BrvahAsyncDifferConfig<T> {
    private final Executor backgroundThreadExecutor;
    private final p diffCallback;
    private final Executor mainThreadExecutor;

    public static final class Builder<T> {
        private static Executor sDiffExecutor;
        private Executor mBackgroundThreadExecutor;
        private final p mDiffCallback;
        private Executor mMainThreadExecutor;
        public static final Companion Companion = new Companion(null);
        private static final Object sExecutorLock = new Object();

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(c cVar) {
                this();
            }
        }

        public Builder(p mDiffCallback) {
            e.g(mDiffCallback, "mDiffCallback");
            this.mDiffCallback = mDiffCallback;
        }

        public final BrvahAsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor == null) {
                synchronized (sExecutorLock) {
                    if (sDiffExecutor == null) {
                        sDiffExecutor = Executors.newFixedThreadPool(2);
                    }
                }
                this.mBackgroundThreadExecutor = sDiffExecutor;
            }
            Executor executor = this.mMainThreadExecutor;
            Executor executor2 = this.mBackgroundThreadExecutor;
            if (executor2 != null) {
                return new BrvahAsyncDifferConfig<>(executor, executor2, this.mDiffCallback);
            }
            e.l();
            throw null;
        }

        public final Builder<T> setBackgroundThreadExecutor(Executor executor) {
            this.mBackgroundThreadExecutor = executor;
            return this;
        }

        public final Builder<T> setMainThreadExecutor(Executor executor) {
            this.mMainThreadExecutor = executor;
            return this;
        }
    }

    public BrvahAsyncDifferConfig(Executor executor, Executor backgroundThreadExecutor, p diffCallback) {
        e.g(backgroundThreadExecutor, "backgroundThreadExecutor");
        e.g(diffCallback, "diffCallback");
        this.mainThreadExecutor = executor;
        this.backgroundThreadExecutor = backgroundThreadExecutor;
        this.diffCallback = diffCallback;
    }

    public final Executor getBackgroundThreadExecutor() {
        return this.backgroundThreadExecutor;
    }

    public final p getDiffCallback() {
        return this.diffCallback;
    }

    public final Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }
}
