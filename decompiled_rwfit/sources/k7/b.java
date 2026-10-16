package k7;

import android.animation.TimeInterpolator;

/* loaded from: classes.dex */
public final class b implements TimeInterpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15527a = 0;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        switch (this.f15527a) {
            case 0:
                return f2;
            case 1:
                float f15 = 1.0f - f2;
                if (f15 < 0.36363637f) {
                    f12 = 7.5625f * f15 * f15;
                } else {
                    if (f15 < 0.72727275f) {
                        float f16 = f15 - 0.54545456f;
                        f10 = 7.5625f * f16 * f16;
                        f11 = 0.75f;
                    } else if (f15 < 0.90909094f) {
                        float f17 = f15 - 0.8181818f;
                        f10 = 7.5625f * f17 * f17;
                        f11 = 0.9375f;
                    } else {
                        float f18 = f15 - 0.95454544f;
                        f10 = 7.5625f * f18 * f18;
                        f11 = 0.984375f;
                    }
                    f12 = f10 + f11;
                }
                return 1.0f - f12;
            default:
                if (f2 < 0.36363637f) {
                    return 7.5625f * f2 * f2;
                }
                if (f2 < 0.72727275f) {
                    float f19 = f2 - 0.54545456f;
                    f13 = 7.5625f * f19 * f19;
                    f14 = 0.75f;
                } else if (f2 < 0.90909094f) {
                    float f20 = f2 - 0.8181818f;
                    f13 = 7.5625f * f20 * f20;
                    f14 = 0.9375f;
                } else {
                    float f21 = f2 - 0.95454544f;
                    f13 = 7.5625f * f21 * f21;
                    f14 = 0.984375f;
                }
                return f13 + f14;
        }
    }
}
