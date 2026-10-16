package tg;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rg.u;
import rg.w;
import rg.x;

/* loaded from: classes2.dex */
public final class d extends x {

    /* renamed from: b, reason: collision with root package name */
    public final Handler f18632b;

    public d(Handler handler) {
        this.f18632b = handler;
    }

    @Override // rg.x
    public final w a() {
        return new c(this.f18632b);
    }

    @Override // rg.x
    public final ug.b d(Runnable runnable, long j4, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        Handler handler = this.f18632b;
        u uVar = new u(handler, runnable);
        handler.postDelayed(uVar, timeUnit.toMillis(j4));
        return uVar;
    }
}
