package j2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.mlkit_vision_barcode.kd;

/* loaded from: classes.dex */
public final class s0 extends AnimatorListenerAdapter implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final View f15288a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15289b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f15290c;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15292f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f15291d = true;

    public s0(int i3, View view) {
        this.f15288a = view;
        this.f15289b = i3;
        this.f15290c = (ViewGroup) view.getParent();
        f(true);
    }

    @Override // j2.e0
    public final void a(f0 f0Var) {
    }

    @Override // j2.e0
    public final void b() {
        f(false);
    }

    @Override // j2.e0
    public final void c() {
        f(true);
    }

    @Override // j2.e0
    public final void d() {
    }

    @Override // j2.e0
    public final void e(f0 f0Var) {
        if (!this.f15292f) {
            o0.c(this.f15289b, this.f15288a);
            ViewGroup viewGroup = this.f15290c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        f0Var.w(this);
    }

    public final void f(boolean z5) {
        ViewGroup viewGroup;
        if (!this.f15291d || this.e == z5 || (viewGroup = this.f15290c) == null) {
            return;
        }
        this.e = z5;
        kd.a(viewGroup, z5);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f15292f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f15292f) {
            o0.c(this.f15289b, this.f15288a);
            ViewGroup viewGroup = this.f15290c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (this.f15292f) {
            return;
        }
        o0.c(this.f15289b, this.f15288a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (this.f15292f) {
            return;
        }
        o0.c(0, this.f15288a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
