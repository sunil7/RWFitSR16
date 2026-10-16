package androidx.fragment.app;

import android.transition.Transition;

/* loaded from: classes.dex */
public final class k extends j {

    /* renamed from: c, reason: collision with root package name */
    public final Object f2207c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2208d;
    public final Object e;

    public k(p1 p1Var, h1.d dVar, boolean z5, boolean z6) {
        super(p1Var, dVar);
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State = p1Var.f2251a;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = SpecialEffectsController$Operation$State.VISIBLE;
        Fragment fragment = p1Var.f2253c;
        if (specialEffectsController$Operation$State == specialEffectsController$Operation$State2) {
            this.f2207c = z5 ? fragment.getReenterTransition() : fragment.getEnterTransition();
            this.f2208d = z5 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        } else {
            this.f2207c = z5 ? fragment.getReturnTransition() : fragment.getExitTransition();
            this.f2208d = true;
        }
        if (!z6) {
            this.e = null;
        } else if (z5) {
            this.e = fragment.getSharedElementReturnTransition();
        } else {
            this.e = fragment.getSharedElementEnterTransition();
        }
    }

    public final k1 c(Object obj) {
        if (obj == null) {
            return null;
        }
        j1 j1Var = e1.f2172a;
        if (obj instanceof Transition) {
            return j1Var;
        }
        k1 k1Var = e1.f2173b;
        if (k1Var != null && k1Var.e(obj)) {
            return k1Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f2203a.f2253c + " is not a valid framework Transition or AndroidX Transition");
    }
}
