package androidx.swiperefreshlayout.widget;

import android.animation.Animator;

/* loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f2858a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f2859b;

    public c(e eVar, d dVar) {
        this.f2859b = eVar;
        this.f2858a = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        e eVar = this.f2859b;
        d dVar = this.f2858a;
        eVar.a(1.0f, dVar, true);
        dVar.f2869k = dVar.e;
        dVar.f2870l = dVar.f2864f;
        dVar.f2871m = dVar.f2865g;
        dVar.a((dVar.f2868j + 1) % dVar.f2867i.length);
        if (!eVar.f2886f) {
            eVar.e += 1.0f;
            return;
        }
        eVar.f2886f = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (dVar.f2872n) {
            dVar.f2872n = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2859b.e = 0.0f;
    }
}
