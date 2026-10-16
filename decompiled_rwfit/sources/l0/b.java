package l0;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final double f15675a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f2, float f10, boolean z5) {
        if (!z5) {
            return f2;
        }
        return (float) (((1.0d - f15675a) * f10) + f2);
    }

    public static float b(float f2, float f10, boolean z5) {
        if (!z5) {
            return f2 * 1.5f;
        }
        return (float) (((1.0d - f15675a) * f10) + (f2 * 1.5f));
    }
}
