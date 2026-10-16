package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2168a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2169b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f2170c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p1 f2171d;
    public final /* synthetic */ i e;

    public e(ViewGroup viewGroup, View view, boolean z5, p1 p1Var, i iVar) {
        this.f2168a = viewGroup;
        this.f2169b = view;
        this.f2170c = z5;
        this.f2171d = p1Var;
        this.e = iVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f2168a;
        View view = this.f2169b;
        viewGroup.endViewTransition(view);
        if (this.f2170c) {
            this.f2171d.f2251a.applyState(view);
        }
        this.e.a();
    }
}
