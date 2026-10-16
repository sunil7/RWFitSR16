package wh;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.d6;
import java.io.EOFException;
import java.io.InputStream;
import java.util.Arrays;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class m {
    public static ByteString a(String decodeBase64) {
        char c9;
        int i3;
        char charAt;
        char c10 = 'A';
        kotlin.jvm.internal.e.f(decodeBase64, "$this$decodeBase64");
        byte[] bArr = a.f19635a;
        int length = decodeBase64.length();
        while (true) {
            c9 = '\t';
            if (length <= 0 || !((charAt = decodeBase64.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                break;
            }
            length--;
        }
        int i10 = (int) ((length * 6) / 8);
        byte[] bArr2 = new byte[i10];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i11 < length) {
                char charAt2 = decodeBase64.charAt(i11);
                char c11 = c10;
                if (c10 <= charAt2 && 'Z' >= charAt2) {
                    i3 = charAt2 - 'A';
                } else if ('a' <= charAt2 && 'z' >= charAt2) {
                    i3 = charAt2 - 'G';
                } else if ('0' <= charAt2 && '9' >= charAt2) {
                    i3 = charAt2 + 4;
                } else if (charAt2 == '+' || charAt2 == '-') {
                    i3 = 62;
                } else if (charAt2 == '/' || charAt2 == '_') {
                    i3 = 63;
                } else {
                    if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != c9) {
                        break;
                    }
                    i11++;
                    c10 = c11;
                    c9 = '\t';
                }
                int i15 = i3 | (i13 << 6);
                i12++;
                if (i12 % 4 == 0) {
                    bArr2[i14] = (byte) (i15 >> 16);
                    int i16 = i14 + 2;
                    bArr2[i14 + 1] = (byte) (i15 >> 8);
                    i14 += 3;
                    bArr2[i16] = (byte) i15;
                }
                i13 = i15;
                i11++;
                c10 = c11;
                c9 = '\t';
            } else {
                int i17 = i12 % 4;
                if (i17 != 1) {
                    if (i17 == 2) {
                        bArr2[i14] = (byte) ((i13 << 12) >> 16);
                        i14 = 1 + i14;
                    } else if (i17 == 3) {
                        int i18 = i13 << 6;
                        int i19 = 1 + i14;
                        bArr2[i14] = (byte) (i18 >> 16);
                        i14 += 2;
                        bArr2[i19] = (byte) (i18 >> 8);
                    }
                    if (i14 != i10) {
                        bArr2 = Arrays.copyOf(bArr2, i14);
                        kotlin.jvm.internal.e.e(bArr2, "java.util.Arrays.copyOf(this, newSize)");
                    }
                }
            }
        }
        bArr2 = null;
        if (bArr2 != null) {
            return new ByteString(bArr2);
        }
        return null;
    }

    public static ByteString b(String decodeHex) {
        kotlin.jvm.internal.e.f(decodeHex, "$this$decodeHex");
        if (decodeHex.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(decodeHex).toString());
        }
        int length = decodeHex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i10 = i3 * 2;
            bArr[i3] = (byte) (xh.b.a(decodeHex.charAt(i10 + 1)) + (xh.b.a(decodeHex.charAt(i10)) << 4));
        }
        return new ByteString(bArr);
    }

    public static ByteString c(String encodeUtf8) {
        kotlin.jvm.internal.e.f(encodeUtf8, "$this$encodeUtf8");
        byte[] bytes = encodeUtf8.getBytes(kotlin.text.a.f15656a);
        kotlin.jvm.internal.e.e(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString(bytes);
        byteString.setUtf8$okio(encodeUtf8);
        return byteString;
    }

    public static ByteString d(m mVar, byte[] bArr) {
        int length = bArr.length;
        mVar.getClass();
        d6.b(bArr.length, 0, length);
        return new ByteString(kotlin.collections.g.d(0, length, bArr));
    }

    public static ByteString e(InputStream readByteString, int i3) {
        kotlin.jvm.internal.e.f(readByteString, "$this$readByteString");
        if (i3 < 0) {
            throw new IllegalArgumentException(l0.j(i3, "byteCount < 0: ").toString());
        }
        byte[] bArr = new byte[i3];
        int i10 = 0;
        while (i10 < i3) {
            int read = readByteString.read(bArr, i10, i3 - i10);
            if (read == -1) {
                throw new EOFException();
            }
            i10 += read;
        }
        return new ByteString(bArr);
    }
}
