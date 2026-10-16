package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class f implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2887a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f2888b;

    public /* synthetic */ f(SwipeRefreshLayout swipeRefreshLayout, int i3) {
        this.f2887a = i3;
        this.f2888b = swipeRefreshLayout;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        j jVar;
        switch (this.f2887a) {
            case 0:
                SwipeRefreshLayout swipeRefreshLayout = this.f2888b;
                if (!swipeRefreshLayout.f2831c) {
                    swipeRefreshLayout.l();
                    break;
                } else {
                    swipeRefreshLayout.f2852z.setAlpha(255);
                    swipeRefreshLayout.f2852z.start();
                    if (swipeRefreshLayout.E && (jVar = swipeRefreshLayout.f2830b) != null) {
                        jVar.j();
                    }
                    swipeRefreshLayout.f2841n = swipeRefreshLayout.f2846t.getTop();
                    break;
                }
                break;
            default:
                SwipeRefreshLayout swipeRefreshLayout2 = this.f2888b;
                swipeRefreshLayout2.getClass();
                g gVar = new g(swipeRefreshLayout2, 1);
                swipeRefreshLayout2.B = gVar;
                gVar.setDuration(150L);
                a aVar = swipeRefreshLayout2.f2846t;
                aVar.f2854a = null;
                aVar.clearAnimation();
                swipeRefreshLayout2.f2846t.startAnimation(swipeRefreshLayout2.B);
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i3 = this.f2887a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i3 = this.f2887a;
    }
}
