package v1;

import android.view.animation.Interpolator;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public abstract class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f19128a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19129b;

    public b(float[] fArr) {
        this.f19128a = fArr;
        this.f19129b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f19128a;
        int min = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f10 = this.f19129b;
        float f11 = (f2 - (min * f10)) / f10;
        float f12 = fArr[min];
        return l0.a(fArr[min + 1], f12, f11, f12);
    }
}
