package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class f2 {
    public static int a() {
        Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        String language = locale.getLanguage();
        kotlin.jvm.internal.e.e(language, "getLanguage(...)");
        String country = locale.getCountry();
        kotlin.jvm.internal.e.e(country, "getCountry(...)");
        String languageTag = locale.toLanguageTag();
        kotlin.jvm.internal.e.e(languageTag, "toLanguageTag(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(language);
        sb2.append(" ");
        sb2.append(country);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Language", r5.a.f(sb2, " ", languageTag));
        Locale locale2 = Locale.ROOT;
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "zh", false)) {
            return kotlin.text.m.x(languageTag, "zh-Hant", false) ? 25 : 0;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "en", false)) {
            return 1;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "tr", false)) {
            return 2;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ru", false)) {
            return 4;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "es", false)) {
            return 5;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "it", false)) {
            return 6;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ko", false)) {
            return 7;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "pt", false)) {
            return 8;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "de", false)) {
            return 9;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", Const.SP_KEY_FIRSTLOC_RELOC, false)) {
            return 10;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "nl", false)) {
            return 11;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "pl", false)) {
            return 12;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "cs", false)) {
            return 13;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "hu", false)) {
            return 14;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "sk", false)) {
            return 15;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ja", false)) {
            return 16;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "da", false)) {
            return 17;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "fi", false)) {
            return 18;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "nb", false)) {
            return 19;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "sv", false)) {
            return 20;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "sr", false)) {
            return 21;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "th", false)) {
            return 22;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "hi", false)) {
            return 23;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "el", false)) {
            return 24;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "lt", false)) {
            return 26;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "vi", false)) {
            return 27;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ar", false)) {
            return 28;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "in", false)) {
            return 29;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "uk", false)) {
            return 30;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", Const.SP_KEY_INFO_WRITE, false)) {
            return 32;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "et", false)) {
            return 34;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "sl", false)) {
            return 35;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "fa", false)) {
            return 36;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ro", false)) {
            return 37;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "bg", false)) {
            return 38;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "hr", false)) {
            return 39;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ur", false)) {
            return 40;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", Const.SP_KEY_GSM_UPLOAD_MXSIZE, false)) {
            return 41;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "jv", false)) {
            return 48;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "mr", false)) {
            return 49;
        }
        return android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "lv", false) ? 50 : 1;
    }

    public static int b() {
        Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        String language = locale.getLanguage();
        kotlin.jvm.internal.e.e(language, "getLanguage(...)");
        String country = locale.getCountry();
        kotlin.jvm.internal.e.e(country, "getCountry(...)");
        String languageTag = locale.toLanguageTag();
        kotlin.jvm.internal.e.e(languageTag, "toLanguageTag(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(language);
        sb2.append(" ");
        sb2.append(country);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Language", r5.a.f(sb2, " ", languageTag));
        Locale locale2 = Locale.ROOT;
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "zh", false)) {
            return kotlin.text.m.x(languageTag, "zh-Hant", false) ? 13 : 0;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "en", false)) {
            return 1;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ja", false)) {
            return 2;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "de", false)) {
            return 3;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", Const.SP_KEY_FIRSTLOC_RELOC, false)) {
            return 4;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "es", false)) {
            return 5;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ru", false)) {
            return 6;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "it", false)) {
            return 7;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "pt", false)) {
            return 8;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "tr", false)) {
            return 9;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "pl", false)) {
            return 10;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "nl", false)) {
            return 11;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "el", false)) {
            return 12;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", Const.SP_KEY_INFO_WRITE, false)) {
            return 14;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ar", false)) {
            return 15;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "vi", false)) {
            return 16;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "fa", false)) {
            return 17;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "in", false)) {
            return 18;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "th", false)) {
            return 19;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "my", false)) {
            return 20;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "hi", false)) {
            return 21;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ur", false)) {
            return 22;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "da", false)) {
            return 23;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", Const.SP_KEY_GSM_UPLOAD_MXSIZE, false)) {
            return 24;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "la", false)) {
            return 25;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ro", false)) {
            return 26;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "uk", false)) {
            return 27;
        }
        if (android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "ko", false)) {
            return 28;
        }
        return android.support.v4.media.session.e.C(language, locale2, "this as java.lang.String).toLowerCase(Locale.ROOT)", "cs", false) ? 29 : 1;
    }

    public static String c() {
        String language = Resources.getSystem().getConfiguration().getLocales().get(0).getLanguage();
        kotlin.jvm.internal.e.e(language, "getLanguage(...)");
        String country = Resources.getSystem().getConfiguration().getLocales().get(0).getCountry();
        kotlin.jvm.internal.e.e(country, "getCountry(...)");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "RingLanguage", r5.a.c(language, " ", country));
        Locale locale = Locale.ROOT;
        return (android.support.v4.media.session.e.C(language, locale, "this as java.lang.String).toLowerCase(Locale.ROOT)", "zh", false) && android.support.v4.media.session.e.C(country, locale, "this as java.lang.String).toLowerCase(Locale.ROOT)", "cn", false)) ? "zh-cn" : "en";
    }

    public static String d(Context context) {
        kotlin.jvm.internal.e.c(context);
        Configuration configuration = context.getResources().getConfiguration();
        String language = configuration.locale.getLanguage();
        kotlin.jvm.internal.e.e(language, "getLanguage(...)");
        String country = configuration.locale.getCountry();
        kotlin.jvm.internal.e.e(country, "getCountry(...)");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "RingLanguage Context", language + " " + country);
        Locale locale = Locale.ROOT;
        return (android.support.v4.media.session.e.C(language, locale, "this as java.lang.String).toLowerCase(Locale.ROOT)", "zh", false) && android.support.v4.media.session.e.C(country, locale, "this as java.lang.String).toLowerCase(Locale.ROOT)", "cn", false)) ? "zh-cn" : "en";
    }
}
