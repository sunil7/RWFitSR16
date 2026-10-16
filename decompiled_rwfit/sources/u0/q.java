package u0;

import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class q extends o {

    /* renamed from: a, reason: collision with root package name */
    public float f18739a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f18740b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f18741c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MotionLayout f18742d;

    public q(MotionLayout motionLayout) {
        this.f18742d = motionLayout;
    }

    @Override // u0.o
    public final float a() {
        return this.f18742d.f1721v;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        float f10 = this.f18739a;
        MotionLayout motionLayout = this.f18742d;
        if (f10 > 0.0f) {
            float f11 = this.f18741c;
            if (f10 / f11 < f2) {
                f2 = f10 / f11;
            }
            motionLayout.f1721v = f10 - (f11 * f2);
            return ((f10 * f2) - (((f11 * f2) * f2) / 2.0f)) + this.f18740b;
        }
        float f12 = this.f18741c;
        if ((-f10) / f12 < f2) {
            f2 = (-f10) / f12;
        }
        motionLayout.f1721v = (f12 * f2) + f10;
        return (((f12 * f2) * f2) / 2.0f) + (f10 * f2) + this.f18740b;
    }
}
