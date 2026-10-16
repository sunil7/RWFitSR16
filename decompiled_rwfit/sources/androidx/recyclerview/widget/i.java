package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2581a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f2582b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2583c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f2584d;
    public final /* synthetic */ l e;

    public /* synthetic */ i(l lVar, j jVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i3) {
        this.f2581a = i3;
        this.e = lVar;
        this.f2582b = jVar;
        this.f2583c = viewPropertyAnimator;
        this.f2584d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2581a) {
            case 0:
                this.f2583c.setListener(null);
                View view = this.f2584d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                j jVar = this.f2582b;
                z1 z1Var = jVar.f2604a;
                l lVar = this.e;
                lVar.c(z1Var);
                lVar.r.remove(jVar.f2604a);
                lVar.i();
                break;
            default:
                this.f2583c.setListener(null);
                View view2 = this.f2584d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                j jVar2 = this.f2582b;
                z1 z1Var2 = jVar2.f2605b;
                l lVar2 = this.e;
                lVar2.c(z1Var2);
                lVar2.r.remove(jVar2.f2605b);
                lVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f2581a) {
            case 0:
                z1 z1Var = this.f2582b.f2604a;
                this.e.getClass();
                break;
            default:
                z1 z1Var2 = this.f2582b.f2605b;
                this.e.getClass();
                break;
        }
    }
}
