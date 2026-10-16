package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2566a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f2567b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f2568c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2569d;
    public final /* synthetic */ l e;

    public g(l lVar, z1 z1Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.e = lVar;
        this.f2567b = z1Var;
        this.f2569d = viewPropertyAnimator;
        this.f2568c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f2566a) {
            case 1:
                this.f2568c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2566a) {
            case 0:
                this.f2569d.setListener(null);
                this.f2568c.setAlpha(1.0f);
                l lVar = this.e;
                z1 z1Var = this.f2567b;
                lVar.c(z1Var);
                lVar.f2661q.remove(z1Var);
                lVar.i();
                break;
            default:
                this.f2569d.setListener(null);
                l lVar2 = this.e;
                z1 z1Var2 = this.f2567b;
                lVar2.c(z1Var2);
                lVar2.f2659o.remove(z1Var2);
                lVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f2566a) {
            case 0:
                this.e.getClass();
                break;
            default:
                this.e.getClass();
                break;
        }
    }

    public g(l lVar, z1 z1Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.e = lVar;
        this.f2567b = z1Var;
        this.f2568c = view;
        this.f2569d = viewPropertyAnimator;
    }
}
