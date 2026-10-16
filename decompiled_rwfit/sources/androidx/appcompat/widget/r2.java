package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class r2 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1033a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1034b = false;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1035c;

    public /* synthetic */ r2(Object obj, int i3) {
        this.f1033a = i3;
        this.f1035c = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f1033a) {
            case 0:
                this.f1034b = true;
                break;
            default:
                this.f1034b = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1033a) {
            case 0:
                if (!this.f1034b) {
                    ((ScrollingTabContainerView) this.f1035c).setVisibility(0);
                    break;
                }
                break;
            default:
                if (!this.f1034b) {
                    androidx.recyclerview.widget.w wVar = (androidx.recyclerview.widget.w) this.f1035c;
                    if (((Float) wVar.f2781z.getAnimatedValue()).floatValue() != 0.0f) {
                        wVar.A = 2;
                        wVar.f2774s.invalidate();
                        break;
                    } else {
                        wVar.A = 0;
                        wVar.k(0);
                        break;
                    }
                } else {
                    this.f1034b = false;
                    break;
                }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1033a) {
            case 0:
                ((ScrollingTabContainerView) this.f1035c).setVisibility(0);
                this.f1034b = false;
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
