package hb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14297a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f14298b;

    public f(g gVar, int i3) {
        this.f14298b = gVar;
        this.f14297a = i3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f14298b.f14300b = this.f14297a;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f14298b.f14300b = this.f14297a;
    }
}
