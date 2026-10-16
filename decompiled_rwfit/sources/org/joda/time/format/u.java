package org.joda.time.format;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final double f17226a = Math.log(10.0d);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f17227b = 0;

    public static void a(Appendable appendable, int i3, int i10) {
        if (i3 < 0) {
            appendable.append('-');
            if (i3 == Integer.MIN_VALUE) {
                while (i10 > 10) {
                    appendable.append('0');
                    i10--;
                }
                appendable.append("2147483648");
                return;
            }
            i3 = -i3;
        }
        if (i3 < 10) {
            while (i10 > 1) {
                appendable.append('0');
                i10--;
            }
            appendable.append((char) (i3 + 48));
            return;
        }
        if (i3 >= 100) {
            int log = i3 < 1000 ? 3 : i3 < 10000 ? 4 : ((int) (Math.log(i3) / f17226a)) + 1;
            while (i10 > log) {
                appendable.append('0');
                i10--;
            }
            appendable.append(Integer.toString(i3));
            return;
        }
        while (i10 > 2) {
            appendable.append('0');
            i10--;
        }
        int i11 = ((i3 + 1) * 13421772) >> 27;
        appendable.append((char) (i11 + 48));
        appendable.append((char) (((i3 - (i11 << 3)) - (i11 << 1)) + 48));
    }

    public static void b(StringBuffer stringBuffer, int i3, int i10) {
        try {
            a(stringBuffer, i3, i10);
        } catch (IOException unused) {
        }
    }

    public static void c(Appendable appendable, int i3) {
        if (i3 < 0) {
            appendable.append('-');
            if (i3 == Integer.MIN_VALUE) {
                appendable.append("2147483648");
                return;
            }
            i3 = -i3;
        }
        if (i3 < 10) {
            appendable.append((char) (i3 + 48));
        } else {
            if (i3 >= 100) {
                appendable.append(Integer.toString(i3));
                return;
            }
            int i10 = ((i3 + 1) * 13421772) >> 27;
            appendable.append((char) (i10 + 48));
            appendable.append((char) (((i3 - (i10 << 3)) - (i10 << 1)) + 48));
        }
    }

    public static int d(long j4) {
        int log;
        if (j4 < 0) {
            if (j4 == Long.MIN_VALUE) {
                return 20;
            }
            log = d(-j4);
        } else {
            if (j4 < 10) {
                return 1;
            }
            if (j4 < 100) {
                return 2;
            }
            if (j4 < 1000) {
                return 3;
            }
            if (j4 < 10000) {
                return 4;
            }
            log = (int) (Math.log(j4) / f17226a);
        }
        return log + 1;
    }

    public static String e(int i3, String str) {
        String concat = str.length() <= i3 + 35 ? str : str.substring(0, i3 + 32).concat("...");
        if (i3 <= 0) {
            return "Invalid format: \"" + concat + '\"';
        }
        if (i3 >= str.length()) {
            return l0.o("Invalid format: \"", concat, "\" is too short");
        }
        StringBuilder r = android.support.v4.media.session.e.r("Invalid format: \"", concat, "\" is malformed at \"");
        r.append(concat.substring(i3));
        r.append('\"');
        return r.toString();
    }

    public static int f(int i3, String str) {
        int charAt = str.charAt(i3) - '0';
        return (str.charAt(i3 + 1) + ((charAt << 3) + (charAt << 1))) - 48;
    }
}
