package com.example.test.utils;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class u extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f8763a;

    /* renamed from: b, reason: collision with root package name */
    public final Lambda f8764b;

    /* JADX WARN: Multi-variable type inference failed */
    public u(Context context, int i3, oh.a aVar) {
        this.f8763a = i3;
        this.f8764b = (Lambda) aVar;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.internal.Lambda, oh.a] */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        kotlin.jvm.internal.e.f(widget, "widget");
        TextView textView = widget instanceof TextView ? (TextView) widget : null;
        if (textView != null) {
            textView.setHighlightColor(0);
        }
        this.f8764b.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        kotlin.jvm.internal.e.f(ds, "ds");
        super.updateDrawState(ds);
        ds.setColor(this.f8763a);
        ds.setUnderlineText(false);
    }
}
