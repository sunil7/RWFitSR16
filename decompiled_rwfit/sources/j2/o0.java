package j2;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final p0 f15272a;

    /* renamed from: b, reason: collision with root package name */
    public static final ab.g f15273b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f15272a = new q0();
        } else {
            f15272a = new p0();
        }
        f15273b = new ab.g(14, Float.class, "translationAlpha");
        new ab.g(15, Rect.class, "clipBounds");
    }

    public static void a(View view, int i3, int i10, int i11, int i12) {
        f15272a.e(view, i3, i10, i11, i12);
    }

    public static void b(View view, float f2) {
        f15272a.b(view, f2);
    }

    public static void c(int i3, View view) {
        f15272a.c(i3, view);
    }
}
