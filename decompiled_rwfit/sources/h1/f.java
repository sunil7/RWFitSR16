package h1;

import android.os.Handler;
import android.os.Looper;
import t.r;

/* loaded from: classes.dex */
public abstract class f {
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static boolean b(Handler handler, r rVar, long j4) {
        return handler.postDelayed(rVar, "retry_token", j4);
    }
}
