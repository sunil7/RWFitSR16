package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class h extends Animation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2891a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2892b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f2893c;

    public h(SwipeRefreshLayout swipeRefreshLayout, int i3, int i10) {
        this.f2893c = swipeRefreshLayout;
        this.f2891a = i3;
        this.f2892b = i10;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f2, Transformation transformation) {
        this.f2893c.f2852z.setAlpha((int) (((this.f2892b - r0) * f2) + this.f2891a));
    }
}
