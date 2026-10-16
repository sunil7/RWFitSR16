package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public final class u0 extends r0 {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ v0 f2745q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(v0 v0Var, Context context) {
        super(context);
        this.f2745q = v0Var;
    }

    @Override // androidx.recyclerview.widget.r0
    public final float b(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.r0
    public final int c(int i3) {
        return Math.min(100, super.c(i3));
    }

    @Override // androidx.recyclerview.widget.r0
    public final void f(View view, u1 u1Var) {
        v0 v0Var = this.f2745q;
        int[] b3 = v0Var.b(v0Var.f2754a.getLayoutManager(), view);
        int i3 = b3[0];
        int i10 = b3[1];
        int ceil = (int) Math.ceil(c(Math.max(Math.abs(i3), Math.abs(i10))) / 0.3356d);
        if (ceil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.f2729j;
            u1Var.f2746a = i3;
            u1Var.f2747b = i10;
            u1Var.f2748c = ceil;
            u1Var.e = decelerateInterpolator;
            u1Var.f2750f = true;
        }
    }
}
