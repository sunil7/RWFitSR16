package com.example.test.utils;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class q0 extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8745a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final int f8746b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8747c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f8748d;

    public q0(int i3, m1.d dVar, int i10) {
        this.f8746b = i3;
        this.f8748d = dVar;
        this.f8747c = i10;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        switch (this.f8745a) {
            case 0:
                ((u0) this.f8748d).a(this.f8746b);
                break;
            default:
                Bundle bundle = new Bundle();
                bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f8746b);
                ((m1.d) this.f8748d).f15938a.performAction(this.f8747c, bundle);
                break;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        switch (this.f8745a) {
            case 0:
                super.updateDrawState(textPaint);
                textPaint.setColor(this.f8747c);
                textPaint.setUnderlineText(false);
                break;
            default:
                super.updateDrawState(textPaint);
                break;
        }
    }

    public q0(u0 u0Var, int i3, int i10) {
        this.f8748d = u0Var;
        this.f8746b = i3;
        this.f8747c = i10;
    }
}
