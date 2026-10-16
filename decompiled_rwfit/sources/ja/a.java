package ja;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f15383a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final v1.a f15384b = new v1.a();

    /* renamed from: c, reason: collision with root package name */
    public static final v1.a f15385c = new v1.a(v1.a.f19126c);

    /* renamed from: d, reason: collision with root package name */
    public static final v1.a f15386d = new v1.a(v1.a.e);
    public static final DecelerateInterpolator e = new DecelerateInterpolator();

    public static float a(float f2, float f10, float f11) {
        return l0.a(f10, f2, f11, f2);
    }

    public static float b(float f2, float f10, float f11, float f12, float f13) {
        return f13 < f11 ? f2 : f13 > f12 ? f10 : a(f2, f10, (f13 - f11) / (f12 - f11));
    }
}
