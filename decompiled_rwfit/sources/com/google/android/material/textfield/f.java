package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class f extends m {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10900d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(TextInputLayout textInputLayout, int i3) {
        super(textInputLayout);
        this.f10900d = i3;
    }

    @Override // com.google.android.material.textfield.m
    public final void a() {
        switch (this.f10900d) {
            case 0:
                TextInputLayout textInputLayout = this.f10921a;
                textInputLayout.setEndIconOnClickListener(null);
                textInputLayout.setEndIconOnLongClickListener(null);
                break;
            default:
                TextInputLayout textInputLayout2 = this.f10921a;
                textInputLayout2.setEndIconOnClickListener(null);
                textInputLayout2.setEndIconDrawable((Drawable) null);
                textInputLayout2.setEndIconContentDescription((CharSequence) null);
                break;
        }
    }
}
