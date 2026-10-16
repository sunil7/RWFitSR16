package kb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import ra.d;
import ra.e;

/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15600a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f15601b;

    public /* synthetic */ c(e eVar, int i3) {
        this.f15600a = i3;
        this.f15601b = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f15600a) {
            case 0:
                e eVar = this.f15601b;
                d revealInfo = eVar.getRevealInfo();
                revealInfo.f18108c = Float.MAX_VALUE;
                eVar.setRevealInfo(revealInfo);
                break;
            default:
                this.f15601b.c();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f15600a) {
            case 1:
                this.f15601b.e();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
