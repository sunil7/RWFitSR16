package j1;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.emoji2.text.v;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f15172a;

    /* renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f15173b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15174c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15175d;

    public d(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i3, int i10) {
        PrecomputedText.Params.Builder breakStrategy;
        PrecomputedText.Params.Builder hyphenationFrequency;
        PrecomputedText.Params.Builder textDirection;
        if (Build.VERSION.SDK_INT >= 29) {
            breakStrategy = v.k(textPaint).setBreakStrategy(i3);
            hyphenationFrequency = breakStrategy.setHyphenationFrequency(i10);
            textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
            textDirection.build();
        }
        this.f15172a = textPaint;
        this.f15173b = textDirectionHeuristic;
        this.f15174c = i3;
        this.f15175d = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f15174c != dVar.f15174c || this.f15175d != dVar.f15175d) {
            return false;
        }
        TextPaint textPaint = this.f15172a;
        float textSize = textPaint.getTextSize();
        TextPaint textPaint2 = dVar.f15172a;
        if (textSize != textPaint2.getTextSize() || textPaint.getTextScaleX() != textPaint2.getTextScaleX() || textPaint.getTextSkewX() != textPaint2.getTextSkewX() || textPaint.getLetterSpacing() != textPaint2.getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) || textPaint.getFlags() != textPaint2.getFlags() || !textPaint.getTextLocales().equals(textPaint2.getTextLocales())) {
            return false;
        }
        if (textPaint.getTypeface() == null) {
            if (textPaint2.getTypeface() != null) {
                return false;
            }
        } else if (!textPaint.getTypeface().equals(textPaint2.getTypeface())) {
            return false;
        }
        return this.f15173b == dVar.f15173b;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f15172a;
        return k1.b.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f15173b, Integer.valueOf(this.f15174c), Integer.valueOf(this.f15175d));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(Const.STR_MART_JSON_BEGIN);
        StringBuilder sb3 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f15172a;
        sb3.append(textPaint.getTextSize());
        sb2.append(sb3.toString());
        sb2.append(", textScaleX=" + textPaint.getTextScaleX());
        sb2.append(", textSkewX=" + textPaint.getTextSkewX());
        sb2.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb2.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb2.append(", textLocale=" + textPaint.getTextLocales());
        sb2.append(", typeface=" + textPaint.getTypeface());
        sb2.append(", variationSettings=" + textPaint.getFontVariationSettings());
        sb2.append(", textDir=" + this.f15173b);
        sb2.append(", breakStrategy=" + this.f15174c);
        sb2.append(", hyphenationFrequency=" + this.f15175d);
        sb2.append("}");
        return sb2.toString();
    }

    public d(PrecomputedText.Params params) {
        TextPaint textPaint;
        TextDirectionHeuristic textDirection;
        int breakStrategy;
        int hyphenationFrequency;
        textPaint = params.getTextPaint();
        this.f15172a = textPaint;
        textDirection = params.getTextDirection();
        this.f15173b = textDirection;
        breakStrategy = params.getBreakStrategy();
        this.f15174c = breakStrategy;
        hyphenationFrequency = params.getHyphenationFrequency();
        this.f15175d = hyphenationFrequency;
    }
}
