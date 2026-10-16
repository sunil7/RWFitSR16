package androidx.appcompat.widget;

import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public abstract class h0 {
    public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }
}
