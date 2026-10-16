package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.q;
import androidx.lifecycle.s;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements q {

    /* renamed from: a, reason: collision with root package name */
    public static int f349a;

    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_DESTROY) {
            return;
        }
        if (f349a == 0) {
            try {
                f349a = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f349a = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f349a == 1) {
            throw null;
        }
    }
}
