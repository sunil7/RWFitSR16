package ab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f159a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f160b;

    public /* synthetic */ f(h hVar, int i3) {
        this.f159a = i3;
        this.f160b = hVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f159a) {
            case 1:
                super.onAnimationEnd(animator);
                h hVar = this.f160b;
                hVar.c();
                hVar.f173k.a();
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        switch (this.f159a) {
            case 0:
                super.onAnimationRepeat(animator);
                h hVar = this.f160b;
                hVar.f170h = (hVar.f170h + 4) % hVar.f169g.f153c.length;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }
}
