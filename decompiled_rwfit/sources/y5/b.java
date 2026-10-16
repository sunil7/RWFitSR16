package y5;

import android.graphics.Bitmap;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f20001a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f20002b = new HashMap();

    static {
        int i3 = 0;
        while (true) {
            char[] cArr = f20001a;
            if (i3 >= 16) {
                return;
            }
            f20002b.put(Character.valueOf(cArr[i3]), Byte.valueOf((byte) i3));
            i3++;
        }
    }

    public static byte[] a(int i3, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = i10 - 1;
        int i12 = 0;
        while (i11 >= 0) {
            bArr[i12] = (byte) ((i3 >> (i11 * 8)) & 255);
            i11--;
            i12++;
        }
        return bArr;
    }

    public static byte b(String str) {
        if (str == null) {
            return (byte) 0;
        }
        int length = str.length();
        if (length == 4 || length == 8) {
            return (byte) (length == 8 ? str.charAt(0) == '0' ? Integer.parseInt(str, 2) : Integer.parseInt(str, 2) - 256 : Integer.parseInt(str, 2));
        }
        return (byte) 0;
    }

    public static byte[] c(byte b3) {
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) (b3 & 1);
            b3 = (byte) (b3 >> 1);
        }
        return bArr;
    }

    public static int d(int i3, int i10, byte[] bArr) {
        int i11 = (i10 - i3) + 1;
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i3, bArr2, 0, i11);
        return j(bArr2);
    }

    public static String e(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static long f(byte[] bArr) {
        int length = bArr.length;
        if (length > 1 && (length % 2 != 0 || length > 8)) {
            throw new Exception("not support");
        }
        if (length == 0) {
            return 0L;
        }
        if (length == 1) {
            return bArr[0] & 255;
        }
        if (length == 2) {
            return (bArr[1] & 255) | ((bArr[0] & 255) << 8);
        }
        if (length == 4) {
            return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        if (length == 8) {
            return ((bArr[0] & 255) << 56) | ((bArr[1] & 255) << 48) | ((bArr[2] & 255) << 40) | ((bArr[3] & 255) << 32) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | ((bArr[6] & 255) << 8) | (bArr[7] & 255);
        }
        throw new Exception("not support");
    }

    public static long g(byte[] bArr) {
        int length = bArr.length;
        if (length > 1 && (length % 2 != 0 || length > 8)) {
            throw new Exception("not support");
        }
        if (length == 0) {
            return 0L;
        }
        if (length == 1) {
            return bArr[0] & 255;
        }
        if (length == 2) {
            return (bArr[0] & 255) | ((bArr[1] & 255) << 8);
        }
        if (length == 4) {
            return ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255);
        }
        throw new Exception("not support");
    }

    public static String h(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (bArr.length <= 0) {
            return "";
        }
        for (byte b3 : bArr) {
            String hexString = Integer.toHexString(b3 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
            sb2.append(" ");
        }
        return sb2.toString();
    }

    public static String i(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr.length <= 0) {
            return null;
        }
        for (byte b3 : bArr) {
            String hexString = Integer.toHexString(b3 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static int j(byte[] bArr) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (byte b3 : bArr) {
                String hexString = Integer.toHexString(b3 & 255);
                if (hexString.length() < 2) {
                    sb2.append(0);
                }
                sb2.append(hexString);
            }
            return Integer.valueOf(sb2.toString(), 16).intValue();
        } catch (Throwable th2) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "ByteConvertUtil", android.support.v4.media.session.e.p(th2, new StringBuilder("数据转换异常 ")));
            return 0;
        }
    }

    public static byte[] k(Bitmap bitmap) {
        int height = bitmap.getHeight() * bitmap.getWidth();
        int[] iArr = new int[height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        byte[] bArr = new byte[height * 2];
        int i3 = 0;
        for (int i10 = 0; i10 < height; i10++) {
            int i11 = iArr[i10];
            byte[] a3 = a((((i11 & 255) >> 3) << 11) + (((65280 & i11) >> 10) << 5) + ((16711680 & i11) >> 19), 2);
            bArr[i3] = a3[0];
            bArr[i3 + 1] = a3[1];
            i3 += 2;
        }
        return bArr;
    }

    public static boolean l(byte b3, int i3) {
        return ((b3 >> i3) & 1) == 1;
    }

    public static byte[] m(String str) {
        return str == null ? new byte[0] : str.getBytes(StandardCharsets.UTF_16LE);
    }

    public static byte[] n(String str) {
        return str == null ? new byte[0] : str.getBytes(StandardCharsets.UTF_8);
    }

    public static byte o(byte[] bArr) {
        byte b3 = bArr[0];
        for (int i3 = 1; i3 < bArr.length; i3++) {
            b3 = (byte) (b3 ^ bArr[i3]);
        }
        return b3;
    }

    public static String p(int i3, String str) {
        int length = n(str).length;
        if (length > i3) {
            str = str.substring(0, str.length() - (((length - i3) / 3) + 1));
        }
        return n(str).length > i3 ? p(i3, str) : str;
    }

    public static byte q(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return (byte) 0;
        }
        int i3 = 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            i3 = (int) ((Math.pow(2.0d, i10) * iArr[i10]) + i3);
        }
        return (byte) (i3 & 255);
    }

    public static byte[] r(long j4) {
        return new byte[]{(byte) (j4 & 255), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 24) & 255)};
    }
}
