package hb;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f14294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f14295b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f14296c;

    public e(g gVar, View view, View view2) {
        this.f14296c = gVar;
        this.f14294a = view;
        this.f14295b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f14296c.b(this.f14294a, this.f14295b, valueAnimator.getAnimatedFraction());
    }
}
