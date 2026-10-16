package androidx.swiperefreshlayout.widget;

import android.graphics.drawable.ShapeDrawable;
import android.view.animation.Animation;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class a extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public Animation.AnimationListener f2854a;

    /* renamed from: b, reason: collision with root package name */
    public int f2855b;

    @Override // android.view.View
    public final void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f2854a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public final void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f2854a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i3) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i3);
            this.f2855b = i3;
        }
    }
}
