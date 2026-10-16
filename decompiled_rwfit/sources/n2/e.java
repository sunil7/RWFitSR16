package n2;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class e implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16367a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        switch (this.f16367a) {
            case 0:
                float f10 = f2 - 1.0f;
                return (f10 * f10 * f10 * f10 * f10) + 1.0f;
            default:
                float f11 = f2 - 1.0f;
                return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }
}
