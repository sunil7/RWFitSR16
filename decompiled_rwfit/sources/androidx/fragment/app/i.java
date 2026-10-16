package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: c, reason: collision with root package name */
    public boolean f2199c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2200d;
    public c0 e;

    public final c0 c(Context context) {
        Animation loadAnimation;
        c0 c0Var;
        if (this.f2200d) {
            return this.e;
        }
        p1 p1Var = this.f2203a;
        boolean z5 = p1Var.f2251a == SpecialEffectsController$Operation$State.VISIBLE;
        boolean z6 = this.f2199c;
        Fragment fragment = p1Var.f2253c;
        int nextTransition = fragment.getNextTransition();
        int popEnterAnim = z6 ? z5 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z5 ? fragment.getEnterAnim() : fragment.getExitAnim();
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        c0 c0Var2 = null;
        if (viewGroup != null && viewGroup.getTag(R$id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R$id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z5, popEnterAnim);
            if (onCreateAnimation != null) {
                c0Var2 = new c0(onCreateAnimation);
            } else {
                Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z5, popEnterAnim);
                if (onCreateAnimator != null) {
                    c0Var2 = new c0(onCreateAnimator);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        popEnterAnim = nextTransition != 4097 ? nextTransition != 4099 ? nextTransition != 8194 ? -1 : z5 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit : z5 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit : z5 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
                    }
                    if (popEnterAnim != 0) {
                        boolean equals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                        try {
                            if (equals) {
                                try {
                                    loadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                                } catch (Resources.NotFoundException e) {
                                    throw e;
                                } catch (RuntimeException unused) {
                                }
                                if (loadAnimation != null) {
                                    c0Var = new c0(loadAnimation);
                                    c0Var2 = c0Var;
                                }
                            }
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                            if (loadAnimator != null) {
                                c0Var = new c0(loadAnimator);
                                c0Var2 = c0Var;
                            }
                        } catch (RuntimeException e10) {
                            if (equals) {
                                throw e10;
                            }
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                            if (loadAnimation2 != null) {
                                c0Var2 = new c0(loadAnimation2);
                            }
                        }
                    }
                }
            }
        }
        this.e = c0Var2;
        this.f2200d = true;
        return c0Var2;
    }
}
