package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public float f1728a = Float.NaN;

    /* renamed from: b, reason: collision with root package name */
    public float f1729b = Float.NaN;

    /* renamed from: c, reason: collision with root package name */
    public int f1730c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f1731d = -1;
    public final /* synthetic */ MotionLayout e;

    public b(MotionLayout motionLayout) {
        this.e = motionLayout;
    }

    public final void a() {
        int i3 = this.f1730c;
        MotionLayout motionLayout = this.e;
        if (i3 != -1 || this.f1731d != -1) {
            if (i3 == -1) {
                motionLayout.G(this.f1731d);
            } else {
                int i10 = this.f1731d;
                if (i10 == -1) {
                    motionLayout.D(i3);
                } else {
                    motionLayout.E(i3, i10);
                }
            }
            motionLayout.setState(MotionLayout.TransitionState.SETUP);
        }
        if (Float.isNaN(this.f1729b)) {
            if (Float.isNaN(this.f1728a)) {
                return;
            }
            motionLayout.setProgress(this.f1728a);
        } else {
            motionLayout.C(this.f1728a, this.f1729b);
            this.f1728a = Float.NaN;
            this.f1729b = Float.NaN;
            this.f1730c = -1;
            this.f1731d = -1;
        }
    }
}
