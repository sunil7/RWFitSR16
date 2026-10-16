package o2;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f16689a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16690b;

    public a(boolean z5) {
        this.f16690b = z5;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        StringBuilder t8 = l0.t(this.f16690b ? "WM.task-" : "androidx.work-");
        t8.append(this.f16689a.incrementAndGet());
        return new Thread(runnable, t8.toString());
    }
}
