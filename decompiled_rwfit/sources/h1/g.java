package h1;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Locale[] f14251a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean b(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (locale.getLanguage().equals(locale2.getLanguage())) {
            Locale[] localeArr = f14251a;
            for (Locale locale3 : localeArr) {
                if (locale3.equals(locale)) {
                    return false;
                }
            }
            for (Locale locale4 : localeArr) {
                if (locale4.equals(locale2)) {
                    return false;
                }
            }
            String c9 = j1.c.c(j1.c.a(j1.c.b(locale)));
            if (!c9.isEmpty()) {
                return c9.equals(j1.c.c(j1.c.a(j1.c.b(locale2))));
            }
            String country = locale.getCountry();
            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                return true;
            }
        }
        return false;
    }
}
