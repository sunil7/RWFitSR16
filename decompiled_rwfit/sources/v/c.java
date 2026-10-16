package v;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.mlkit_vision_barcode.jc;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Handler f19110a;

    public static Handler a() {
        if (f19110a != null) {
            return f19110a;
        }
        synchronized (c.class) {
            try {
                if (f19110a == null) {
                    f19110a = jc.a(Looper.getMainLooper());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f19110a;
    }
}
