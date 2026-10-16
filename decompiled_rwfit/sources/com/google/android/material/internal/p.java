package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f10619a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f10620b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10621c;

    /* renamed from: d, reason: collision with root package name */
    public int f10622d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10628k;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f10623f = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: g, reason: collision with root package name */
    public float f10624g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f10625h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f10626i = 1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10627j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f10629l = null;

    public p(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.f10619a = charSequence;
        this.f10620b = textPaint;
        this.f10621c = i3;
        this.f10622d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f10619a == null) {
            this.f10619a = "";
        }
        int max = Math.max(0, this.f10621c);
        CharSequence charSequence = this.f10619a;
        int i3 = this.f10623f;
        TextPaint textPaint = this.f10620b;
        if (i3 == 1) {
            charSequence = TextUtils.ellipsize(charSequence, textPaint, max, this.f10629l);
        }
        int min = Math.min(charSequence.length(), this.f10622d);
        this.f10622d = min;
        if (this.f10628k && this.f10623f == 1) {
            this.e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
        obtain.setAlignment(this.e);
        obtain.setIncludePad(this.f10627j);
        obtain.setTextDirection(this.f10628k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f10629l;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f10623f);
        float f2 = this.f10624g;
        if (f2 != 0.0f || this.f10625h != 1.0f) {
            obtain.setLineSpacing(f2, this.f10625h);
        }
        if (this.f10623f > 1) {
            obtain.setHyphenationFrequency(this.f10626i);
        }
        return obtain.build();
    }
}
