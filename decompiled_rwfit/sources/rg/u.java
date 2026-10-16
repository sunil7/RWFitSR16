package rg;

import android.os.Handler;
import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;

/* loaded from: classes2.dex */
public final class u implements ug.b, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18132a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f18133b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f18134c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f18135d;

    public u(Handler handler, Runnable runnable) {
        this.f18135d = handler;
        this.f18133b = runnable;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f18132a) {
            case 0:
                this.f18134c = true;
                ((w) this.f18135d).dispose();
                break;
            default:
                this.f18134c = true;
                ((Handler) this.f18135d).removeCallbacks(this);
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f18132a) {
        }
        return this.f18134c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18132a) {
            case 0:
                if (this.f18134c) {
                    return;
                }
                try {
                    this.f18133b.run();
                    return;
                } catch (Throwable th2) {
                    ad.a(th2);
                    ((w) this.f18135d).dispose();
                    throw io.reactivex.internal.util.b.b(th2);
                }
            default:
                try {
                    this.f18133b.run();
                    return;
                } catch (Throwable th3) {
                    a1.b(th3);
                    return;
                }
        }
    }

    public u(Runnable runnable, w wVar) {
        this.f18133b = runnable;
        this.f18135d = wVar;
    }
}
