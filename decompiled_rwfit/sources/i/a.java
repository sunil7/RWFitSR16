package i;

import android.os.Looper;
import com.google.android.gms.internal.mlkit_vision_barcode.kc;

/* loaded from: classes.dex */
public final class a extends kc {

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f14326b;

    /* renamed from: c, reason: collision with root package name */
    public static final w.a f14327c = new w.a(1);

    /* renamed from: d, reason: collision with root package name */
    public static final w.a f14328d = new w.a(2);

    /* renamed from: a, reason: collision with root package name */
    public b f14329a;

    public static a a() {
        if (f14326b != null) {
            return f14326b;
        }
        synchronized (a.class) {
            try {
                if (f14326b == null) {
                    a aVar = new a();
                    aVar.f14329a = new b();
                    f14326b = aVar;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f14326b;
    }

    public final void b(Runnable runnable) {
        b bVar = this.f14329a;
        if (bVar.f14332c == null) {
            synchronized (bVar.f14330a) {
                try {
                    if (bVar.f14332c == null) {
                        bVar.f14332c = b.a(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        bVar.f14332c.post(runnable);
    }
}
