package i9;

import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b implements k8.a {
    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }
}
