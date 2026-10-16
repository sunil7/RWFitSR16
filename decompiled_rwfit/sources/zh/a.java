package zh;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.logging.Level;
import yh.g;

/* loaded from: classes2.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f20423a;

    static {
        boolean z5;
        try {
            Class.forName("android.util.Log");
            z5 = true;
        } catch (ClassNotFoundException unused) {
            z5 = false;
        }
        f20423a = z5;
    }

    public static int b(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        }
        if (intValue < 900) {
            return 4;
        }
        return intValue < 1000 ? 5 : 6;
    }

    @Override // yh.g
    public final void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(b(level), "EventBus", str);
        }
    }

    @Override // yh.g
    public final void l(Level level, String str, Throwable th2) {
        if (level != Level.OFF) {
            int b3 = b(level);
            StringBuilder u10 = l0.u(str, "\n");
            u10.append(Log.getStackTraceString(th2));
            Log.println(b3, "EventBus", u10.toString());
        }
    }
}
