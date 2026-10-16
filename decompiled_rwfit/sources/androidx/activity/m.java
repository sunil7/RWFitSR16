package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class m {
    public static OnBackInvokedCallback a(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new l(runnable, 0);
    }

    public static void b(Object obj, int i3, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i3, (OnBackInvokedCallback) obj2);
    }

    public static void c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
