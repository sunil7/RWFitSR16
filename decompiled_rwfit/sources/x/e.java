package x;

import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements n0.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ob.a f19696a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w.c f19697b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f19698c;

    public /* synthetic */ e(ob.a aVar, w.c cVar, long j4) {
        this.f19696a = aVar;
        this.f19697b = cVar;
        this.f19698c = j4;
    }

    @Override // n0.g
    public final Object b(final androidx.concurrent.futures.b bVar) {
        final ob.a aVar = this.f19696a;
        i.e(true, aVar, bVar, a6.a());
        if (!aVar.isDone()) {
            final long j4 = this.f19698c;
            aVar.a(new m5.a(this.f19697b.schedule(new Callable() { // from class: x.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(androidx.concurrent.futures.b.this.b(new TimeoutException("Future[" + aVar + "] is not done within " + j4 + " ms.")));
                }
            }, j4, TimeUnit.MILLISECONDS), 15), a6.a());
        }
        return "TimeoutFuture[" + aVar + "]";
    }
}
