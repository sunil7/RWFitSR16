package com.autonavi.aps.amapapi.security;

import com.amap.api.col.p0003sl.ga;
import com.amap.api.col.p0003sl.h9;
import com.amap.api.col.p0003sl.n9;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class Encrypt {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String KEY_TRANSFORMATION = "CUlNBL0VDQi9QS0NTMVBhZGRpbmc";

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f6730a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f6731b = {61, 61, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f6732c;

    /* renamed from: d, reason: collision with root package name */
    private static final IvParameterSpec f6733d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        f6732c = bArr;
        f6733d = new IvParameterSpec(bArr);
    }

    private static SecretKeySpec a(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    public static byte[] aesDecrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec a3 = a(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(n9.c());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, a3, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    public static byte[] aesDecryptByCBC(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(bArr, "AES"), f6733d);
        return cipher.doFinal(bArr2);
    }

    public static byte[] aesEncrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec a3 = a(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(n9.c());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, a3, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            BigInteger modPow = new BigInteger(bArr).modPow(bigInteger, bigInteger2);
            byte[] bArr2 = new byte[16];
            BigInteger bigInteger3 = new BigInteger("256");
            int i3 = 0;
            while (modPow.bitCount() > 0 && i3 < 16) {
                BigInteger[] divideAndRemainder = modPow.divideAndRemainder(bigInteger3);
                BigInteger bigInteger4 = divideAndRemainder[0];
                bArr2[i3] = (byte) divideAndRemainder[1].intValue();
                i3++;
                modPow = bigInteger4;
            }
            return bArr2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] decryptAES(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(n9.b("YQUVTL0VDQi9Ob1BhZGRpbmc="));
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] decryptRsponse(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(n9.c()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Encrypt", "decryptRsponse length = " + (bArr != null ? bArr.length : 0));
            return null;
        }
    }

    public static String encode(String str, String str2) {
        byte[] bArr;
        if (str2 == null) {
            return null;
        }
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bytes);
                bArr = messageDigest.digest();
            } catch (Throwable th2) {
                ga.a(th2, "MD5", "gmb");
                bArr = null;
            }
            int length = bArr.length;
            StringBuilder sb2 = new StringBuilder(length * 2);
            for (int i3 = 0; i3 < length; i3++) {
                char[] cArr = f6730a;
                sb2.append(cArr[(bArr[i3] >> 4) & 15]);
                sb2.append(cArr[bArr[i3] & 15]);
            }
            return sb2.toString();
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "Encrypt", "encode");
            return null;
        }
    }

    public static String generatorKey(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return encode("MD5", encode("SHA1", str) + str);
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static synchronized byte[] rsaDecryptByPrivateKey(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        synchronized (Encrypt.class) {
            try {
                PrivateKey generatePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(h9.a(str)));
                Cipher cipher = Cipher.getInstance(n9.b(KEY_TRANSFORMATION));
                cipher.init(2, generatePrivate);
                int length = bArr.length;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i3 = 0;
                int i10 = 0;
                while (true) {
                    int i11 = length - i3;
                    if (i11 > 0) {
                        byte[] doFinal = i11 > 256 ? cipher.doFinal(bArr, i3, 256) : cipher.doFinal(bArr, i3, i11);
                        byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                        i10++;
                        i3 = i10 * 256;
                    } else {
                        byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return byteArray;
    }

    public static synchronized byte[] rsaEncryptByPrivateKey(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        synchronized (Encrypt.class) {
            try {
                PrivateKey generatePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(h9.a(str)));
                Cipher cipher = Cipher.getInstance(n9.b(KEY_TRANSFORMATION));
                cipher.init(1, generatePrivate);
                int length = bArr.length;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i3 = 0;
                int i10 = 0;
                while (true) {
                    int i11 = length - i3;
                    if (i11 > 0) {
                        byte[] doFinal = i11 > 245 ? cipher.doFinal(bArr, i3, 245) : cipher.doFinal(bArr, i3, i11);
                        byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                        i10++;
                        i3 = i10 * 245;
                    } else {
                        byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return byteArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00f4, code lost:
    
        if (r8 != 4) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] rsaEncryptCarrier(byte[] r16) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.security.Encrypt.rsaEncryptCarrier(byte[]):byte[]");
    }
}
