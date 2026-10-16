package com.amap.api.col.p0003sl;

import com.autonavi.aps.amapapi.security.Encrypt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class h9 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f4268a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f4269b = new byte[128];

    static {
        for (int i3 = 0; i3 < 128; i3++) {
            f4269b[i3] = -1;
        }
        for (int i10 = 65; i10 <= 90; i10++) {
            f4269b[i10] = (byte) (i10 - 65);
        }
        for (int i11 = 97; i11 <= 122; i11++) {
            f4269b[i11] = (byte) (i11 - 71);
        }
        for (int i12 = 48; i12 <= 57; i12++) {
            f4269b[i12] = (byte) (i12 + 4);
        }
        byte[] bArr = f4269b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, n9.b("EQUVT"));
        Cipher cipher = Cipher.getInstance(n9.b("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    public static String b(byte[] bArr) {
        try {
            return a(bArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String c(byte[] bArr) {
        try {
            return a(bArr);
        } catch (Throwable th2) {
            ga.a(th2, "er", "e64");
            return null;
        }
    }

    public static byte[] d(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(n9.b("EQUVT"));
        byte[] bArr2 = null;
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey a3 = n9.a();
        if (a3 == null) {
            return null;
        }
        byte[] a10 = a(encoded, a3);
        try {
            bArr2 = a(encoded, bArr, n9.c());
        } catch (Throwable th2) {
            ga.a(th2, "er", "asEn");
        }
        byte[] bArr3 = new byte[a10.length + bArr2.length];
        System.arraycopy(a10, 0, bArr3, 0, a10.length);
        System.arraycopy(bArr2, 0, bArr3, a10.length, bArr2.length);
        return bArr3;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, n9.b("EQUVT"));
        Cipher cipher = Cipher.getInstance(n9.b("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return a(bArr, bArr2, bArr3);
    }

    public static byte[] a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(n9.b(Encrypt.KEY_TRANSFORMATION));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public static byte[] a(String str) {
        int i3;
        byte b3;
        int i10;
        byte b10;
        int i11 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] e = n9.e(str);
        int length = e.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i11 < length) {
            while (true) {
                i3 = i11 + 1;
                b3 = f4269b[e[i11]];
                if (i3 >= length || b3 != -1) {
                    break;
                }
                i11 = i3;
            }
            if (b3 == -1) {
                break;
            }
            while (true) {
                i10 = i3 + 1;
                b10 = f4269b[e[i3]];
                if (i10 >= length || b10 != -1) {
                    break;
                }
                i3 = i10;
            }
            if (b10 == -1) {
                break;
            }
            byteArrayOutputStream.write((b3 << 2) | ((b10 & 48) >>> 4));
            while (i10 != length) {
                int i12 = i10 + 1;
                byte b11 = e[i10];
                if (b11 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b12 = f4269b[b11];
                if (i12 >= length || b12 != -1) {
                    if (b12 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b10 & 15) << 4) | ((b12 & 60) >>> 2));
                    while (i12 != length) {
                        int i13 = i12 + 1;
                        byte b13 = e[i12];
                        if (b13 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b14 = f4269b[b13];
                        if (i13 < length && b14 == -1) {
                            i12 = i13;
                        } else {
                            if (b14 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b14 | ((b12 & 3) << 6));
                            i11 = i13;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i10 = i12;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            int i10 = i3 + 1;
            byte b3 = bArr[i3];
            int i11 = b3 & 255;
            if (i10 == length) {
                char[] cArr = f4268a;
                stringBuffer.append(cArr[i11 >>> 2]);
                stringBuffer.append(cArr[(b3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i12 = i3 + 2;
            byte b10 = bArr[i10];
            if (i12 == length) {
                char[] cArr2 = f4268a;
                stringBuffer.append(cArr2[i11 >>> 2]);
                stringBuffer.append(cArr2[((b3 & 3) << 4) | ((b10 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(b10 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i3 += 3;
            byte b11 = bArr[i12];
            char[] cArr3 = f4268a;
            stringBuffer.append(cArr3[i11 >>> 2]);
            stringBuffer.append(cArr3[((b3 & 3) << 4) | ((b10 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((b10 & 15) << 2) | ((b11 & 192) >>> 6)]);
            stringBuffer.append(cArr3[b11 & 63]);
        }
        return stringBuffer.toString();
    }
}
