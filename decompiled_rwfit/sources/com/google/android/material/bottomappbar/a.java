package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10248a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f10249b;

    public /* synthetic */ a(BottomAppBar bottomAppBar, int i3) {
        this.f10248a = i3;
        this.f10249b = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar bottomAppBar = this.f10249b;
        switch (this.f10248a) {
            case 1:
                int i3 = BottomAppBar.V0;
                bottomAppBar.T = null;
                break;
            case 2:
                int i10 = BottomAppBar.V0;
                bottomAppBar.getClass();
                bottomAppBar.f10237e0 = false;
                bottomAppBar.U = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        float fabTranslationX;
        BottomAppBar bottomAppBar = this.f10249b;
        switch (this.f10248a) {
            case 0:
                if (!bottomAppBar.f10237e0) {
                    bottomAppBar.C(bottomAppBar.V, bottomAppBar.f10238f0);
                    break;
                }
                break;
            case 1:
                int i3 = BottomAppBar.V0;
                break;
            case 2:
                int i10 = BottomAppBar.V0;
                bottomAppBar.getClass();
                break;
            default:
                bottomAppBar.f10242k0.onAnimationStart(animator);
                View z5 = bottomAppBar.z();
                FloatingActionButton floatingActionButton = z5 instanceof FloatingActionButton ? (FloatingActionButton) z5 : null;
                if (floatingActionButton != null) {
                    fabTranslationX = bottomAppBar.getFabTranslationX();
                    floatingActionButton.setTranslationX(fabTranslationX);
                    break;
                }
                break;
        }
    }
}
