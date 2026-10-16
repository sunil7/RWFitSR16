package i2;

import android.os.Trace;

/* loaded from: classes.dex */
public abstract class a {
    public static boolean a() {
        return Trace.isEnabled();
    }

    public static void b(int i3, String str) {
        Trace.setCounter(str, i3);
    }
}
