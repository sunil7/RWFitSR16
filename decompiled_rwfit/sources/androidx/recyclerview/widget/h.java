package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f2572a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2573b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f2574c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2575d;
    public final /* synthetic */ ViewPropertyAnimator e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l f2576f;

    public h(l lVar, z1 z1Var, int i3, View view, int i10, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2576f = lVar;
        this.f2572a = z1Var;
        this.f2573b = i3;
        this.f2574c = view;
        this.f2575d = i10;
        this.e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i3 = this.f2573b;
        View view = this.f2574c;
        if (i3 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f2575d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.e.setListener(null);
        l lVar = this.f2576f;
        z1 z1Var = this.f2572a;
        lVar.c(z1Var);
        lVar.f2660p.remove(z1Var);
        lVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2576f.getClass();
    }
}
