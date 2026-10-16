package l1;

import android.view.View;
import androidx.core.R$id;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class s0 {
    public static void a(View view, x0 x0Var) {
        m0.k kVar = (m0.k) view.getTag(R$id.tag_unhandled_key_listeners);
        if (kVar == null) {
            kVar = new m0.k();
            view.setTag(R$id.tag_unhandled_key_listeners, kVar);
        }
        Objects.requireNonNull(x0Var);
        View.OnUnhandledKeyEventListener r0Var = new r0();
        kVar.put(x0Var, r0Var);
        view.addOnUnhandledKeyEventListener(r0Var);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, x0 x0Var) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        m0.k kVar = (m0.k) view.getTag(R$id.tag_unhandled_key_listeners);
        if (kVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) kVar.getOrDefault(x0Var, null)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T f(View view, int i3) {
        return (T) view.requireViewById(i3);
    }

    public static void g(View view, boolean z5) {
        view.setAccessibilityHeading(z5);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, boolean z5) {
        view.setScreenReaderFocusable(z5);
    }
}
