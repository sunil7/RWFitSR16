package com.example.test.utils;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.example.test.R$mipmap;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class r0 extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8750a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f8751b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v0 f8752c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s0 f8753d;

    public r0(s0 s0Var, XXBaseActivity xXBaseActivity, TextView textView, v0 v0Var) {
        this.f8753d = s0Var;
        this.f8750a = xXBaseActivity;
        this.f8751b = textView;
        this.f8752c = v0Var;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        s0 s0Var = this.f8753d;
        boolean z5 = s0Var.f8756a;
        s0Var.f8756a = !z5;
        v0 v0Var = this.f8752c;
        TextView textView = this.f8751b;
        XXBaseActivity xXBaseActivity = this.f8750a;
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) s0Var.f8757b;
        if (z5) {
            spannableStringBuilder.setSpan(new t0(xXBaseActivity, R$mipmap.ic_checkbox_unselect, 2), 0, 1, 33);
            textView.setText(spannableStringBuilder);
            v0Var.b();
        } else {
            spannableStringBuilder.setSpan(new t0(xXBaseActivity, R$mipmap.ic_checkbox_select, 2), 0, 1, 33);
            textView.setText(spannableStringBuilder);
            v0Var.a();
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(-1);
        textPaint.setUnderlineText(false);
    }
}
