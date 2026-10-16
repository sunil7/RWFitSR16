package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    public int f10553a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final void a(int i3, boolean z5) {
        super.setVisibility(i3);
        if (z5) {
            this.f10553a = i3;
        }
    }

    public final int getUserSetVisibility() {
        return this.f10553a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        a(i3, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10553a = getVisibility();
    }
}
