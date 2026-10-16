package cf;

import android.view.animation.Interpolator;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes2.dex */
public final class g implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public static final float f3473a;

    /* renamed from: b, reason: collision with root package name */
    public static final float f3474b;

    static {
        float a3 = 1.0f / a(1.0f);
        f3473a = a3;
        f3474b = 1.0f - (a(1.0f) * a3);
    }

    public static float a(float f2) {
        float f10 = f2 * 8.0f;
        return f10 < 1.0f ? f10 - (1.0f - ((float) Math.exp(-f10))) : l0.a(1.0f, (float) Math.exp(1.0f - f10), 0.63212055f, 0.36787945f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        float a3 = a(f2) * f3473a;
        return a3 > 0.0f ? a3 + f3474b : a3;
    }
}
