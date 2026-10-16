package com.google.zxing.aztec.decoder;

import com.autonavi.aps.amapapi.config.Const;
import com.tencent.connect.common.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11220b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f11221c = {"CTRL_PS", " ", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "e", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f11222d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] e = {"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", Const.STR_MART_WELL, "$", "%", Const.STR_MART_ADD, "'", "(", ")", "*", "+", Const.STR_MART_COMMA, "-", ".", "/", ":", Const.STR_MART_SEMICOLON, "<", "=", ">", "?", "[", "]", Const.STR_MART_JSON_BEGIN, "}", "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f11223f = {"CTRL_PS", " ", "0", "1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Const.STR_MART_COMMA, ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f11224g = StandardCharsets.ISO_8859_1;

    /* renamed from: a, reason: collision with root package name */
    public qc.a f11225a;

    public static int b(boolean[] zArr, int i3, int i10) {
        int i11 = 0;
        for (int i12 = i3; i12 < i3 + i10; i12++) {
            i11 <<= 1;
            if (zArr[i12]) {
                i11 |= 1;
            }
        }
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x02a3, code lost:
    
        throw com.google.zxing.FormatException.getFormatInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final sc.d a(qc.a r25) {
        /*
            Method dump skipped, instructions count: 869
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.b.a(qc.a):sc.d");
    }
}
