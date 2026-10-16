package zb;

import java.util.TimeZone;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f20386a = TimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i3, char c9) {
        return i3 < str.length() && str.charAt(i3) == c9;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6 A[Catch: IllegalArgumentException -> 0x00d5, NumberFormatException -> 0x00d8, IndexOutOfBoundsException -> 0x00db, TRY_LEAVE, TryCatch #2 {IllegalArgumentException -> 0x00d5, IndexOutOfBoundsException -> 0x00db, NumberFormatException -> 0x00d8, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:18:0x0051, B:20:0x0061, B:21:0x0063, B:23:0x006f, B:24:0x0072, B:26:0x0078, B:30:0x0082, B:35:0x0092, B:37:0x009a, B:38:0x009e, B:40:0x00a4, B:44:0x00b1, B:47:0x00bb, B:52:0x00f0, B:54:0x00f6, B:58:0x01a8, B:63:0x0108, B:64:0x0123, B:65:0x0124, B:68:0x0141, B:70:0x014e, B:73:0x0157, B:75:0x0176, B:78:0x0185, B:79:0x01a7, B:80:0x0130, B:81:0x01d9, B:82:0x01e0, B:83:0x00cb, B:84:0x00ce, B:87:0x00b6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d9 A[Catch: IllegalArgumentException -> 0x00d5, NumberFormatException -> 0x00d8, IndexOutOfBoundsException -> 0x00db, TryCatch #2 {IllegalArgumentException -> 0x00d5, IndexOutOfBoundsException -> 0x00db, NumberFormatException -> 0x00d8, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:18:0x0051, B:20:0x0061, B:21:0x0063, B:23:0x006f, B:24:0x0072, B:26:0x0078, B:30:0x0082, B:35:0x0092, B:37:0x009a, B:38:0x009e, B:40:0x00a4, B:44:0x00b1, B:47:0x00bb, B:52:0x00f0, B:54:0x00f6, B:58:0x01a8, B:63:0x0108, B:64:0x0123, B:65:0x0124, B:68:0x0141, B:70:0x014e, B:73:0x0157, B:75:0x0176, B:78:0x0185, B:79:0x01a7, B:80:0x0130, B:81:0x01d9, B:82:0x01e0, B:83:0x00cb, B:84:0x00ce, B:87:0x00b6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date b(java.lang.String r17, java.text.ParsePosition r18) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zb.a.b(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int c(int i3, int i10, String str) {
        int i11;
        int i12;
        if (i3 < 0 || i10 > str.length() || i3 > i10) {
            throw new NumberFormatException(str);
        }
        if (i3 < i10) {
            i12 = i3 + 1;
            int digit = Character.digit(str.charAt(i3), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i10));
            }
            i11 = -digit;
        } else {
            i11 = 0;
            i12 = i3;
        }
        while (i12 < i10) {
            int i13 = i12 + 1;
            int digit2 = Character.digit(str.charAt(i12), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i10));
            }
            i11 = (i11 * 10) - digit2;
            i12 = i13;
        }
        return -i11;
    }
}
