package wa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19561a;

    /* renamed from: b, reason: collision with root package name */
    public float f19562b;

    /* renamed from: c, reason: collision with root package name */
    public float f19563c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f19564d;

    public m(p pVar) {
        this.f19564d = pVar;
    }

    public abstract float a();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        float f2 = (int) this.f19563c;
        eb.h hVar = this.f19564d.f19566b;
        if (hVar != null) {
            hVar.k(f2);
        }
        this.f19561a = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        boolean z5 = this.f19561a;
        p pVar = this.f19564d;
        if (!z5) {
            eb.h hVar = pVar.f19566b;
            this.f19562b = hVar == null ? 0.0f : hVar.f12505a.f12499m;
            this.f19563c = a();
            this.f19561a = true;
        }
        float f2 = this.f19562b;
        float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.f19563c - f2)) + f2);
        eb.h hVar2 = pVar.f19566b;
        if (hVar2 != null) {
            hVar2.k(animatedFraction);
        }
    }
}
