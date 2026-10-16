package org.joda.time.tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f17275a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f17276b;

    public static HashMap a() {
        return new HashMap(7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.HashMap] */
    public final synchronized String[] b(Locale locale, String str, String str2) {
        String[] strArr;
        String[] strArr2 = null;
        if (locale == null || str == 0) {
            return null;
        }
        try {
            Map map = (Map) this.f17275a.get(locale);
            if (map == null) {
                HashMap hashMap = this.f17275a;
                HashMap a3 = a();
                hashMap.put(locale, a3);
                map = a3;
            }
            ?? r22 = (Map) map.get(str);
            if (r22 == 0) {
                r22 = a();
                map.put(str, r22);
                String[][] zoneStrings = org.joda.time.c.a(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i3];
                    if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i3++;
                }
                String[][] zoneStrings2 = org.joda.time.c.a(locale).getZoneStrings();
                int length2 = zoneStrings2.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length2) {
                        String[] strArr3 = zoneStrings2[i10];
                        if (strArr3 != null && strArr3.length >= 5 && str.equals(strArr3[0])) {
                            strArr2 = strArr3;
                            break;
                        }
                        i10++;
                    } else {
                        break;
                    }
                }
                if (strArr != null && strArr2 != null) {
                    r22.put(strArr[2], new String[]{strArr2[2], strArr2[1]});
                    if (strArr[2].equals(strArr[4])) {
                        r22.put(strArr[4] + "-Summer", new String[]{strArr2[4], strArr2[3]});
                    } else {
                        r22.put(strArr[4], new String[]{strArr2[4], strArr2[3]});
                    }
                }
            }
            return (String[]) r22.get(str2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.HashMap] */
    public final synchronized String[] c(Locale locale, String str, String str2, boolean z5) {
        String[] strArr;
        String[] strArr2 = null;
        if (locale == null || str == null) {
            return null;
        }
        try {
            if (str.startsWith("Etc/")) {
                str = str.substring(4);
            }
            Map map = (Map) this.f17276b.get(locale);
            if (map == null) {
                HashMap hashMap = this.f17276b;
                HashMap a3 = a();
                hashMap.put(locale, a3);
                map = a3;
            }
            ?? r22 = (Map) map.get(str);
            if (r22 == 0) {
                r22 = a();
                map.put(str, r22);
                String[][] zoneStrings = org.joda.time.c.a(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i3];
                    if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i3++;
                }
                String[][] zoneStrings2 = org.joda.time.c.a(locale).getZoneStrings();
                int length2 = zoneStrings2.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length2) {
                        String[] strArr3 = zoneStrings2[i10];
                        if (strArr3 != null && strArr3.length >= 5 && str.equals(strArr3[0])) {
                            strArr2 = strArr3;
                            break;
                        }
                        i10++;
                    } else {
                        break;
                    }
                }
                if (strArr != null && strArr2 != null) {
                    r22.put(Boolean.TRUE, new String[]{strArr2[2], strArr2[1]});
                    r22.put(Boolean.FALSE, new String[]{strArr2[4], strArr2[3]});
                }
            }
            return (String[]) r22.get(Boolean.valueOf(z5));
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
