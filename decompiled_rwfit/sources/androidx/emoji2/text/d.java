package androidx.emoji2.text;

import android.text.TextPaint;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f2023b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f2024a;

    public d() {
        TextPaint textPaint = new TextPaint();
        this.f2024a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
