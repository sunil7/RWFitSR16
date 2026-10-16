package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
public abstract class i0 {
    public static int a(View view) {
        return view.getTextAlignment();
    }

    public static int b(View view) {
        return view.getTextDirection();
    }

    public static void c(View view, int i3) {
        view.setTextAlignment(i3);
    }

    public static void d(View view, int i3) {
        view.setTextDirection(i3);
    }
}
