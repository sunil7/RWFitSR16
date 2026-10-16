package ee;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f12595a = "0123456789ABCDEF".toCharArray();

    public static String a(char c9) {
        return c9 == '0' ? "0000" : c9 == '1' ? "0001" : c9 == '2' ? "0010" : c9 == '3' ? "0011" : c9 == '4' ? "0100" : c9 == '5' ? "0101" : c9 == '6' ? "0110" : c9 == '7' ? "0111" : c9 == '8' ? Constants.DEFAULT_UIN : c9 == '9' ? "1001" : (c9 == 'A' || c9 == 'a') ? "1010" : (c9 == 'B' || c9 == 'b') ? "1011" : (c9 == 'C' || c9 == 'c') ? "1100" : (c9 == 'D' || c9 == 'd') ? "1101" : (c9 == 'E' || c9 == 'e') ? "1110" : (c9 == 'F' || c9 == 'f') ? "1111" : "";
    }

    public static String b(int i3, byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < i3; i10++) {
            int i11 = (bArr[i10] & 255) >> 4;
            char[] cArr = f12595a;
            sb2.append(cArr[i11]);
            sb2.append(cArr[bArr[i10] & 15]);
        }
        return sb2.toString().trim().toUpperCase(Locale.US);
    }

    public static String c(byte[] bArr) {
        return bArr == null ? "" : b(bArr.length, bArr);
    }

    public static int d(byte b3, byte b10) {
        return ((b3 & 255) << 8) + (b10 & 255);
    }

    public static int e(int i3, byte[] bArr) {
        return d(bArr[i3], bArr[i3 + 1]);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 4) {
            return 0;
        }
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    public static byte g(char c9, char c10) {
        int length;
        String a3 = a(c9);
        String a10 = a(c10);
        if (TextUtils.isEmpty(a3)) {
            a3 = "";
        }
        if (!TextUtils.isEmpty(a10)) {
            a3 = a3.concat(a10);
        }
        if (TextUtils.isEmpty(a3) || a3 == null || ((length = a3.length()) != 4 && length != 8)) {
            return (byte) 0;
        }
        return (byte) (length == 8 ? a3.charAt(0) == '0' ? Integer.parseInt(a3, 2) : Integer.parseInt(a3, 2) - 256 : Integer.parseInt(a3, 2));
    }

    public static byte[] h(int i3) {
        return new byte[]{(byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
    }

    public static byte[] i(int i3) {
        return new byte[]{(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
    }
}
