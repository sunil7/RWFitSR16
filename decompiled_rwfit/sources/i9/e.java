package i9;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f14372a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f14373b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : g.f(str)) {
            String b3 = b(str2);
            if (b3 != null && f(b3)) {
                return b3;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.e.b(java.lang.String):java.lang.String");
    }

    public static String c(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (f(str)) {
            return 1;
        }
        if (g(str)) {
            return 2;
        }
        if ("text".equals(c(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = f14372a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        throw android.support.v4.media.session.e.c(0, arrayList);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : g.f(str)) {
            String b3 = b(str2);
            if (b3 != null && g(b3)) {
                return b3;
            }
        }
        return null;
    }

    public static boolean f(String str) {
        return "audio".equals(c(str));
    }

    public static boolean g(String str) {
        return "video".equals(c(str));
    }
}
