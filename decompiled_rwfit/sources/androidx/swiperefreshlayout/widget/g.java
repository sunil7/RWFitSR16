package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class g extends Animation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2889a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f2890b;

    public /* synthetic */ g(SwipeRefreshLayout swipeRefreshLayout, int i3) {
        this.f2889a = i3;
        this.f2890b = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f2, Transformation transformation) {
        switch (this.f2889a) {
            case 0:
                this.f2890b.setAnimationProgress(f2);
                break;
            case 1:
                this.f2890b.setAnimationProgress(1.0f - f2);
                break;
            case 2:
                SwipeRefreshLayout swipeRefreshLayout = this.f2890b;
                int abs = swipeRefreshLayout.f2850x - Math.abs(swipeRefreshLayout.f2849w);
                swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.f2848v + ((int) ((abs - r1) * f2))) - swipeRefreshLayout.f2846t.getTop());
                e eVar = swipeRefreshLayout.f2852z;
                float f10 = 1.0f - f2;
                d dVar = eVar.f2882a;
                if (f10 != dVar.f2874p) {
                    dVar.f2874p = f10;
                }
                eVar.invalidateSelf();
                break;
            default:
                this.f2890b.k(f2);
                break;
        }
    }
}
