package io.reactivex.internal.schedulers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import rg.w;

/* loaded from: classes2.dex */
public final class m extends w {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f15097a;

    /* renamed from: b, reason: collision with root package name */
    public final ug.a f15098b = new ug.a();

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f15099c;

    public m(ScheduledExecutorService scheduledExecutorService) {
        this.f15097a = scheduledExecutorService;
    }

    @Override // rg.w
    public final ug.b a(Runnable runnable, long j4, TimeUnit timeUnit) {
        if (this.f15099c) {
            return EmptyDisposable.INSTANCE;
        }
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, this.f15098b);
        this.f15098b.c(scheduledRunnable);
        try {
            scheduledRunnable.setFuture(j4 <= 0 ? this.f15097a.submit((Callable) scheduledRunnable) : this.f15097a.schedule((Callable) scheduledRunnable, j4, timeUnit));
            return scheduledRunnable;
        } catch (RejectedExecutionException e) {
            dispose();
            a1.b(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f15099c) {
            return;
        }
        this.f15099c = true;
        this.f15098b.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f15099c;
    }
}
