package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: classes.dex */
public abstract class u {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static h1.i b(Configuration configuration) {
        return h1.i.a(configuration.getLocales().toLanguageTags());
    }

    public static void c(h1.i iVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(iVar.f14253a.f14254a.toLanguageTags()));
    }

    public static void d(Configuration configuration, h1.i iVar) {
        configuration.setLocales(LocaleList.forLanguageTags(iVar.f14253a.f14254a.toLanguageTags()));
    }
}
