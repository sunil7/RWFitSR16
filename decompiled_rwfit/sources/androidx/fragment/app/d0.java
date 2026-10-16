package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class d0 extends AnimationSet implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f2157a;

    /* renamed from: b, reason: collision with root package name */
    public final View f2158b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2159c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2160d;
    public boolean e;

    public d0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.e = true;
        this.f2157a = viewGroup;
        this.f2158b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation) {
        this.e = true;
        if (this.f2159c) {
            return !this.f2160d;
        }
        if (!super.getTransformation(j4, transformation)) {
            this.f2159c = true;
            l1.z.a(this.f2157a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z5 = this.f2159c;
        ViewGroup viewGroup = this.f2157a;
        if (z5 || !this.e) {
            viewGroup.endViewTransition(this.f2158b);
            this.f2160d = true;
        } else {
            this.e = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation, float f2) {
        this.e = true;
        if (this.f2159c) {
            return !this.f2160d;
        }
        if (!super.getTransformation(j4, transformation, f2)) {
            this.f2159c = true;
            l1.z.a(this.f2157a, this);
        }
        return true;
    }
}
