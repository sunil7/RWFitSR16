package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

/* loaded from: classes.dex */
public abstract class t {
    public static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static PrecomputedText.Params b(TextView textView) {
        return textView.getTextMetricsParams();
    }

    public static void c(TextView textView, int i3) {
        textView.setFirstBaselineToTopHeight(i3);
    }
}
