package androidx.emoji2.text;

import android.graphics.ImageDecoder;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* loaded from: classes.dex */
public abstract /* synthetic */ class v {
    public static /* bridge */ /* synthetic */ ImageDecoder.Source f(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* synthetic */ PrecomputedText.Params.Builder k(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ void v(Object obj) {
    }

    public static /* bridge */ /* synthetic */ boolean w(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
