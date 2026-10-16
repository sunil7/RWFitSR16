package cf;

import com.google.android.material.timepicker.TimeModel;
import java.text.DecimalFormatSymbols;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class f implements c {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f3469a;

    /* renamed from: b, reason: collision with root package name */
    public char f3470b;

    /* renamed from: c, reason: collision with root package name */
    public Formatter f3471c;

    /* renamed from: d, reason: collision with root package name */
    public final Object[] f3472d;

    public f() {
        StringBuilder sb2 = new StringBuilder();
        this.f3469a = sb2;
        this.f3472d = new Object[1];
        Locale locale = Locale.getDefault();
        this.f3471c = new Formatter(sb2, locale);
        this.f3470b = new DecimalFormatSymbols(locale).getZeroDigit();
    }

    @Override // cf.c
    public final String a(int i3) {
        Locale locale = Locale.getDefault();
        char c9 = this.f3470b;
        char zeroDigit = new DecimalFormatSymbols(locale).getZeroDigit();
        StringBuilder sb2 = this.f3469a;
        if (c9 != zeroDigit) {
            this.f3471c = new Formatter(sb2, locale);
            this.f3470b = new DecimalFormatSymbols(locale).getZeroDigit();
        }
        Integer valueOf = Integer.valueOf(i3);
        Object[] objArr = this.f3472d;
        objArr[0] = valueOf;
        sb2.delete(0, sb2.length());
        this.f3471c.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, objArr);
        return this.f3471c.toString();
    }
}
