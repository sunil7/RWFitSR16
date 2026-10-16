package tg;

import android.os.Handler;
import android.os.Message;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import rg.u;
import rg.w;

/* loaded from: classes2.dex */
public final class c extends w {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f18630a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f18631b;

    public c(Handler handler) {
        this.f18630a = handler;
    }

    @Override // rg.w
    public final ug.b a(Runnable runnable, long j4, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        if (this.f18631b) {
            return EmptyDisposable.INSTANCE;
        }
        Handler handler = this.f18630a;
        u uVar = new u(handler, runnable);
        Message obtain = Message.obtain(handler, uVar);
        obtain.obj = this;
        this.f18630a.sendMessageDelayed(obtain, timeUnit.toMillis(j4));
        if (!this.f18631b) {
            return uVar;
        }
        this.f18630a.removeCallbacks(uVar);
        return EmptyDisposable.INSTANCE;
    }

    @Override // ug.b
    public final void dispose() {
        this.f18631b = true;
        this.f18630a.removeCallbacksAndMessages(this);
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f18631b;
    }
}
