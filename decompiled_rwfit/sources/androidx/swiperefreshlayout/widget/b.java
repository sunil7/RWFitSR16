package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f2856a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f2857b;

    public b(e eVar, d dVar) {
        this.f2857b = eVar;
        this.f2856a = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        e eVar = this.f2857b;
        eVar.getClass();
        d dVar = this.f2856a;
        e.d(floatValue, dVar);
        eVar.a(floatValue, dVar, false);
        eVar.invalidateSelf();
    }
}
