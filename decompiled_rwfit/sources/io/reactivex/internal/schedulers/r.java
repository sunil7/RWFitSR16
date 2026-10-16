package io.reactivex.internal.schedulers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import rg.w;
import rg.x;

/* loaded from: classes2.dex */
public final class r extends x {

    /* renamed from: b, reason: collision with root package name */
    public static final r f15113b = new r();

    @Override // rg.x
    public final w a() {
        return new q();
    }

    @Override // rg.x
    public final ug.b c(Runnable runnable) {
        runnable.run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // rg.x
    public final ug.b d(Runnable runnable, long j4, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j4);
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            a1.b(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
