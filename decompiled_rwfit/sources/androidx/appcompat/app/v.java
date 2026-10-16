package androidx.appcompat.app;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.google.android.exoplayer2.PlaybackException;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class v {
    public static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    public static OnBackInvokedCallback b(Object obj, c0 c0Var) {
        Objects.requireNonNull(c0Var);
        androidx.activity.l lVar = new androidx.activity.l(c0Var, 1);
        androidx.activity.j.g(obj).registerOnBackInvokedCallback(PlaybackException.CUSTOM_ERROR_CODE_BASE, lVar);
        return lVar;
    }

    public static void c(Object obj, Object obj2) {
        androidx.activity.j.g(obj).unregisterOnBackInvokedCallback(androidx.activity.j.d(obj2));
    }
}
