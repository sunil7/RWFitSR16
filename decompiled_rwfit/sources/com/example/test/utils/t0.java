package com.example.test.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* loaded from: classes.dex */
public final class t0 extends ImageSpan {
    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i3, int i10, float f2, int i11, int i12, int i13, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i14 = i13 - drawable.getBounds().bottom;
        int i15 = ((ImageSpan) this).mVerticalAlignment;
        if (i15 == 1) {
            i14 -= fontMetricsInt.descent;
        } else if (i15 == 2) {
            i14 = (((i12 + fontMetricsInt.ascent) + (fontMetricsInt.descent + i12)) / 2) - (drawable.getBounds().bottom / 2);
        }
        canvas.translate(f2, i14);
        drawable.draw(canvas);
        canvas.restore();
    }
}
