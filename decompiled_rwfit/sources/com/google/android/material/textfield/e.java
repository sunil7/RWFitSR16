package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.s2;
import androidx.appcompat.widget.u2;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* loaded from: classes.dex */
public final class e extends m {

    /* renamed from: d, reason: collision with root package name */
    public final s2 f10895d;
    public final u2 e;

    /* renamed from: f, reason: collision with root package name */
    public final a f10896f;

    /* renamed from: g, reason: collision with root package name */
    public final b f10897g;

    /* renamed from: h, reason: collision with root package name */
    public AnimatorSet f10898h;

    /* renamed from: i, reason: collision with root package name */
    public ValueAnimator f10899i;

    public e(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f10895d = new s2(this, 3);
        this.e = new u2(this, 1);
        int i3 = 0;
        this.f10896f = new a(this, i3);
        this.f10897g = new b(this, i3);
    }

    @Override // com.google.android.material.textfield.m
    public final void a() {
        Drawable b3 = pb.b(this.f10922b, R$drawable.mtrl_ic_cancel);
        TextInputLayout textInputLayout = this.f10921a;
        textInputLayout.setEndIconDrawable(b3);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        textInputLayout.setEndIconOnClickListener(new androidx.appcompat.app.c(this, 6));
        textInputLayout.addOnEditTextAttachedListener(this.f10896f);
        textInputLayout.addOnEndIconChangedListener(this.f10897g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(ja.a.f15386d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new d(this, 1));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = ja.a.f15383a;
        ofFloat2.setInterpolator(linearInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new d(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f10898h = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f10898h.addListener(new c(this, 0));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(linearInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new d(this, 0));
        this.f10899i = ofFloat3;
        ofFloat3.addListener(new c(this, 1));
    }

    @Override // com.google.android.material.textfield.m
    public final void c(boolean z5) {
        if (this.f10921a.getSuffixText() == null) {
            return;
        }
        d(z5);
    }

    public final void d(boolean z5) {
        boolean z6 = this.f10921a.g() == z5;
        if (z5 && !this.f10898h.isRunning()) {
            this.f10899i.cancel();
            this.f10898h.start();
            if (z6) {
                this.f10898h.end();
                return;
            }
            return;
        }
        if (z5) {
            return;
        }
        this.f10898h.cancel();
        this.f10899i.start();
        if (z6) {
            this.f10899i.end();
        }
    }
}
