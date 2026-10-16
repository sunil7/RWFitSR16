package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes.dex */
public final class e0 implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f2538a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2539b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2540c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2541d;
    public final z1 e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2542f;

    /* renamed from: g, reason: collision with root package name */
    public final ValueAnimator f2543g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2544h;

    /* renamed from: i, reason: collision with root package name */
    public float f2545i;

    /* renamed from: j, reason: collision with root package name */
    public float f2546j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2547k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2548l = false;

    /* renamed from: m, reason: collision with root package name */
    public float f2549m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2550n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ z1 f2551o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j0 f2552p;

    public e0(j0 j0Var, z1 z1Var, int i3, float f2, float f10, float f11, float f12, int i10, z1 z1Var2) {
        this.f2552p = j0Var;
        this.f2550n = i10;
        this.f2551o = z1Var2;
        this.f2542f = i3;
        this.e = z1Var;
        this.f2538a = f2;
        this.f2539b = f10;
        this.f2540c = f11;
        this.f2541d = f12;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2543g = ofFloat;
        ofFloat.addUpdateListener(new v(this, 1));
        ofFloat.setTarget(z1Var.itemView);
        ofFloat.addListener(this);
        this.f2549m = 0.0f;
    }

    public final void a(Animator animator) {
        if (!this.f2548l) {
            this.e.setIsRecyclable(true);
        }
        this.f2548l = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2549m = 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        a(animator);
        if (this.f2547k) {
            return;
        }
        int i3 = this.f2550n;
        z1 z1Var = this.f2551o;
        j0 j0Var = this.f2552p;
        if (i3 <= 0) {
            j0Var.f2620m.clearView(j0Var.r, z1Var);
        } else {
            j0Var.f2609a.add(z1Var.itemView);
            this.f2544h = true;
            if (i3 > 0) {
                j0Var.r.post(new androidx.activity.f(j0Var, this, i3, 3, false));
            }
        }
        View view = j0Var.f2629w;
        View view2 = z1Var.itemView;
        if (view == view2) {
            j0Var.q(view2);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
