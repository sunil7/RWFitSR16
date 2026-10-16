package com.google.android.material.transformation;

import ab.q;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b, reason: collision with root package name */
    public AnimatorSet f10987b;

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public void s(View view, View view2, boolean z5, boolean z6) {
        AnimatorSet animatorSet = this.f10987b;
        boolean z8 = animatorSet != null;
        if (z8) {
            animatorSet.cancel();
        }
        AnimatorSet t8 = t(view, view2, z5, z8);
        this.f10987b = t8;
        t8.addListener(new q(this, 8));
        this.f10987b.start();
        if (z6) {
            return;
        }
        this.f10987b.end();
    }

    public abstract AnimatorSet t(View view, View view2, boolean z5, boolean z6);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
