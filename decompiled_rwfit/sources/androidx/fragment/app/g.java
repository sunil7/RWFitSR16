package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class g implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2178a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2179b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f2180c;

    public g(View view, ViewGroup viewGroup, i iVar) {
        this.f2178a = viewGroup;
        this.f2179b = view;
        this.f2180c = iVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f2178a.post(new f(this, 0));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
