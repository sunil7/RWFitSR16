package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class v implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2752a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2753b;

    public /* synthetic */ v(Object obj, int i3) {
        this.f2752a = i3;
        this.f2753b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2752a) {
            case 0:
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                w wVar = (w) this.f2753b;
                wVar.f2760c.setAlpha(floatValue);
                wVar.f2761d.setAlpha(floatValue);
                wVar.f2774s.invalidate();
                break;
            default:
                ((e0) this.f2753b).f2549m = valueAnimator.getAnimatedFraction();
                break;
        }
    }
}
