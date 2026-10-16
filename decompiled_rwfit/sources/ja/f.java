package ja;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public long f15392a;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f15394c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f15395d = 0;
    public int e = 1;

    /* renamed from: b, reason: collision with root package name */
    public long f15393b = 150;

    public f(long j4) {
        this.f15392a = j4;
    }

    public final void a(Animator animator) {
        animator.setStartDelay(this.f15392a);
        animator.setDuration(this.f15393b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f15395d);
            valueAnimator.setRepeatMode(this.e);
        }
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f15394c;
        return timeInterpolator != null ? timeInterpolator : a.f15384b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f15392a == fVar.f15392a && this.f15393b == fVar.f15393b && this.f15395d == fVar.f15395d && this.e == fVar.e) {
            return b().getClass().equals(fVar.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f15392a;
        long j10 = this.f15393b;
        return ((((b().getClass().hashCode() + (((((int) (j4 ^ (j4 >>> 32))) * 31) + ((int) ((j10 >>> 32) ^ j10))) * 31)) * 31) + this.f15395d) * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n");
        sb2.append(f.class.getName());
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" delay: ");
        sb2.append(this.f15392a);
        sb2.append(" duration: ");
        sb2.append(this.f15393b);
        sb2.append(" interpolator: ");
        sb2.append(b().getClass());
        sb2.append(" repeatCount: ");
        sb2.append(this.f15395d);
        sb2.append(" repeatMode: ");
        return r5.a.e(sb2, this.e, "}\n");
    }
}
