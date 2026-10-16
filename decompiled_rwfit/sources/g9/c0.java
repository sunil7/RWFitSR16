package g9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.ui.DefaultTimeBar;

/* loaded from: classes.dex */
public final class c0 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13912a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f13913b;

    public /* synthetic */ c0(e0 e0Var, int i3) {
        this.f13912a = i3;
        this.f13913b = e0Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f13912a) {
            case 0:
                e0 e0Var = this.f13913b;
                View view = e0Var.f13926b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup = e0Var.f13927c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = e0Var.e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                    break;
                }
                break;
            case 1:
            default:
                super.onAnimationEnd(animator);
                break;
            case 2:
                this.f13913b.i(0);
                break;
            case 3:
                this.f13913b.i(0);
                break;
            case 4:
                ViewGroup viewGroup3 = this.f13913b.f13929f;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                    break;
                }
                break;
            case 5:
                ViewGroup viewGroup4 = this.f13913b.f13931h;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        e0 e0Var = this.f13913b;
        switch (this.f13912a) {
            case 0:
                View view = e0Var.f13933j;
                if ((view instanceof DefaultTimeBar) && !e0Var.A) {
                    DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                    ValueAnimator valueAnimator = defaultTimeBar.E;
                    if (valueAnimator.isStarted()) {
                        valueAnimator.cancel();
                    }
                    valueAnimator.setFloatValues(defaultTimeBar.F, 0.0f);
                    valueAnimator.setDuration(250L);
                    valueAnimator.start();
                    break;
                }
                break;
            case 1:
                View view2 = e0Var.f13926b;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ViewGroup viewGroup = e0Var.f13927c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                ViewGroup viewGroup2 = e0Var.e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(e0Var.A ? 0 : 4);
                }
                View view3 = e0Var.f13933j;
                if ((view3 instanceof DefaultTimeBar) && !e0Var.A) {
                    DefaultTimeBar defaultTimeBar2 = (DefaultTimeBar) view3;
                    ValueAnimator valueAnimator2 = defaultTimeBar2.E;
                    if (valueAnimator2.isStarted()) {
                        valueAnimator2.cancel();
                    }
                    defaultTimeBar2.G = false;
                    valueAnimator2.setFloatValues(defaultTimeBar2.F, 1.0f);
                    valueAnimator2.setDuration(250L);
                    valueAnimator2.start();
                    break;
                }
                break;
            case 2:
                e0Var.i(4);
                break;
            case 3:
                e0Var.i(4);
                break;
            case 4:
                ViewGroup viewGroup3 = e0Var.f13931h;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    e0Var.f13931h.setTranslationX(r9.getWidth());
                    ViewGroup viewGroup4 = e0Var.f13931h;
                    viewGroup4.scrollTo(viewGroup4.getWidth(), 0);
                    break;
                }
                break;
            default:
                ViewGroup viewGroup5 = e0Var.f13929f;
                if (viewGroup5 != null) {
                    viewGroup5.setVisibility(0);
                    break;
                }
                break;
        }
    }
}
