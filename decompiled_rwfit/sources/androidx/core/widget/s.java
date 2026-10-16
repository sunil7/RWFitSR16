package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class s {
    public static DecimalFormatSymbols a(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }
}
