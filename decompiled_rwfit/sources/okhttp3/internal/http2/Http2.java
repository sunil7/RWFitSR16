package okhttp3.internal.http2;

import kotlin.jvm.internal.e;
import okhttp3.internal.Util;
import okio.ByteString;
import r5.a;
import wh.m;

/* loaded from: classes2.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE;
    private static final String[] FLAGS;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        ByteString.Companion.getClass();
        CONNECTION_PREFACE = m.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int i3 = 0; i3 < 256; i3++) {
            String binaryString = Integer.toBinaryString(i3);
            e.e(binaryString, "Integer.toBinaryString(it)");
            String format = Util.format("%8s", binaryString);
            e.f(format, "<this>");
            String replace = format.replace(' ', '0');
            e.e(replace, "this as java.lang.String…replace(oldChar, newChar)");
            strArr[i3] = replace;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i10 = iArr[0];
        strArr2[i10 | 8] = e.k("|PADDED", strArr2[i10]);
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr2[i11];
            int i13 = iArr[0];
            String[] strArr3 = FLAGS;
            int i14 = i13 | i12;
            strArr3[i14] = strArr3[i13] + "|" + strArr3[i12];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i13]);
            sb2.append("|");
            strArr3[i14 | 8] = a.f(sb2, strArr3[i12], "|PADDED");
        }
        int length = FLAGS.length;
        for (int i15 = 0; i15 < length; i15++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i15] == null) {
                strArr4[i15] = BINARY[i15];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i3, int i10) {
        String str;
        if (i10 == 0) {
            return "";
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 == 4 || i3 == 6) {
                return i10 == 1 ? "ACK" : BINARY[i10];
            }
            if (i3 != 7 && i3 != 8) {
                String[] strArr = FLAGS;
                if (i10 < strArr.length) {
                    str = strArr[i10];
                    e.c(str);
                } else {
                    str = BINARY[i10];
                }
                return (i3 != 5 || (i10 & 4) == 0) ? (i3 != 0 || (i10 & 32) == 0) ? str : kotlin.text.m.r(str, "PRIORITY", "COMPRESSED") : kotlin.text.m.r(str, "HEADERS", "PUSH_PROMISE");
            }
        }
        return BINARY[i10];
    }

    public final String formattedType$okhttp(int i3) {
        String[] strArr = FRAME_NAMES;
        return i3 < strArr.length ? strArr[i3] : Util.format("0x%02x", Integer.valueOf(i3));
    }

    public final String frameLog(boolean z5, int i3, int i10, int i11, int i12) {
        return Util.format("%s 0x%08x %5d %-13s %s", z5 ? "<<" : ">>", Integer.valueOf(i3), Integer.valueOf(i10), formattedType$okhttp(i11), formatFlags(i11, i12));
    }
}
