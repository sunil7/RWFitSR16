package io.reactivex.internal.schedulers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f15102a;

    /* renamed from: b, reason: collision with root package name */
    public final q f15103b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15104c;

    public o(Runnable runnable, q qVar, long j4) {
        this.f15102a = runnable;
        this.f15103b = qVar;
        this.f15104c = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f15103b.f15112d) {
            return;
        }
        q qVar = this.f15103b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        qVar.getClass();
        long convert = timeUnit.convert(System.currentTimeMillis(), timeUnit);
        long j4 = this.f15104c;
        if (j4 > convert) {
            try {
                Thread.sleep(j4 - convert);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                a1.b(e);
                return;
            }
        }
        if (this.f15103b.f15112d) {
            return;
        }
        this.f15102a.run();
    }
}
