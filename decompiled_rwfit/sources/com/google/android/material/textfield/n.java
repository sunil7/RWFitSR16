package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10924a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f10925b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10926c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f10927d;
    public final /* synthetic */ o e;

    public n(o oVar, int i3, TextView textView, int i10, TextView textView2) {
        this.e = oVar;
        this.f10924a = i3;
        this.f10925b = textView;
        this.f10926c = i10;
        this.f10927d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AppCompatTextView appCompatTextView;
        int i3 = this.f10924a;
        o oVar = this.e;
        oVar.f10934h = i3;
        oVar.f10932f = null;
        TextView textView = this.f10925b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f10926c == 1 && (appCompatTextView = oVar.f10938l) != null) {
                appCompatTextView.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f10927d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f10927d;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
