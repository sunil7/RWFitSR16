package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10253a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f10254b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10255c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f10256d;
    public final /* synthetic */ BottomAppBar e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i3, boolean z5) {
        this.e = bottomAppBar;
        this.f10254b = actionMenuView;
        this.f10255c = i3;
        this.f10256d = z5;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f10253a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f10253a) {
            return;
        }
        BottomAppBar bottomAppBar = this.e;
        bottomAppBar.getClass();
        bottomAppBar.G(this.f10254b, this.f10255c, this.f10256d, false);
    }
}
