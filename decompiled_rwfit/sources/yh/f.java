package yh;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes2.dex */
public final class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final o4.e f20158a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20159b;

    /* renamed from: c, reason: collision with root package name */
    public final d f20160c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20161d;

    public f(d dVar, Looper looper) {
        super(looper);
        this.f20160c = dVar;
        this.f20159b = 10;
        this.f20158a = new o4.e();
    }

    public final void a(o oVar, Object obj) {
        j a3 = j.a(oVar, obj);
        synchronized (this) {
            try {
                this.f20158a.a(a3);
                if (!this.f20161d) {
                    this.f20161d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                j k10 = this.f20158a.k();
                if (k10 == null) {
                    synchronized (this) {
                        k10 = this.f20158a.k();
                        if (k10 == null) {
                            this.f20161d = false;
                            return;
                        }
                    }
                }
                this.f20160c.c(k10);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f20159b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.f20161d = true;
        } catch (Throwable th2) {
            this.f20161d = false;
            throw th2;
        }
    }
}
