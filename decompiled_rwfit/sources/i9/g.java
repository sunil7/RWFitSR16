package i9;

import android.os.Build;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.hb;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final int f14378a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f14379b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap f14380c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f14381d;
    public static final String[] e;

    static {
        String str = Build.VERSION.CODENAME;
        int i3 = "S".equals(str) ? 31 : "R".equals(str) ? 30 : Build.VERSION.SDK_INT;
        f14378a = i3;
        String str2 = Build.DEVICE;
        String str3 = Build.MANUFACTURER;
        String str4 = Build.MODEL;
        StringBuilder g10 = r5.a.g(r5.a.a(r5.a.a(r5.a.a(17, str2), str4), str3), str2, ", ", str4, ", ");
        g10.append(str3);
        g10.append(", ");
        g10.append(i3);
        f14379b = g10.toString();
        Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f14381d = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", Const.SP_KEY_FIRSTLOC_RELOC, "geo", "ka", "ice", "is", CoreUtil.STR_DEX_MAC_NAME, "mk", "mao", "mi", "may", Const.SP_KEY_GSM_UPLOAD_MXSIZE, "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", Const.SP_KEY_INFO_WRITE, "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", Const.SP_KEY_BATTERY_SAVING, "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        e = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(int i3, int i10, int i11) {
        return Math.max(i10, Math.min(i3, i11));
    }

    public static long c(long j4, long j10, long j11) {
        return Math.max(j10, Math.min(j4, j11));
    }

    public static String d(StringBuilder sb2, Formatter formatter, long j4) {
        if (j4 == -9223372036854775807L) {
            j4 = 0;
        }
        String str = j4 < 0 ? "-" : "";
        long abs = (Math.abs(j4) + 500) / 1000;
        long j10 = abs % 60;
        long j11 = (abs / 60) % 60;
        long j12 = abs / 3600;
        sb2.setLength(0);
        return j12 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j12), Long.valueOf(j11), Long.valueOf(j10)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j11), Long.valueOf(j10)).toString();
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String a3 = hb.a(str);
        int i3 = 0;
        String str2 = a3.split("-", 2)[0];
        if (f14380c == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            int length = iSOLanguages.length;
            String[] strArr = f14381d;
            HashMap hashMap = new HashMap(length + strArr.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        hashMap.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                hashMap.put(strArr[i10], strArr[i10 + 1]);
            }
            f14380c = hashMap;
        }
        String str4 = (String) f14380c.get(str2);
        if (str4 != null) {
            String valueOf = String.valueOf(a3.substring(str2.length()));
            a3 = valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4);
            str2 = str4;
        }
        if (!"no".equals(str2) && !Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID.equals(str2) && !"zh".equals(str2)) {
            return a3;
        }
        while (true) {
            String[] strArr2 = e;
            if (i3 >= strArr2.length) {
                return a3;
            }
            if (a3.startsWith(strArr2[i3])) {
                String valueOf2 = String.valueOf(strArr2[i3 + 1]);
                String valueOf3 = String.valueOf(a3.substring(strArr2[i3].length()));
                return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            i3 += 2;
        }
    }

    public static String[] f(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : str.trim().split("(\\s*,\\s*)", -1);
    }
}
