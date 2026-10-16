package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class GLConvertUtil {
    public static double convertDouble(byte[] bArr, int i3) {
        long j4 = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            j4 += (bArr[i10 + i3] & 255) << (i10 * 8);
        }
        return Double.longBitsToDouble(j4);
    }

    public static byte[] convertInt(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)};
    }

    public static byte[] convertShort(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255)};
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static int getInt(byte[] bArr, int i3) {
        int i10 = bArr[i3 + 3] & 255;
        int i11 = bArr[i3 + 2] & 255;
        int i12 = bArr[i3 + 1] & 255;
        return (i10 << 24) + (i11 << 16) + (i12 << 8) + (bArr[i3] & 255);
    }

    public static int getInt2(byte[] bArr, int i3) {
        int i10 = bArr[i3] & 255;
        int i11 = bArr[i3 + 1] & 255;
        int i12 = bArr[i3 + 2] & 255;
        return (i10 << 24) + (i11 << 16) + (i12 << 8) + (bArr[i3 + 3] & 255);
    }

    public static long getLong(byte[] bArr, int i3) {
        return ((bArr[i3 + 7] & 255) << 56) + ((bArr[i3 + 6] & 255) << 48) + ((bArr[i3 + 5] & 255) << 40) + ((bArr[i3 + 4] & 255) << 32) + ((bArr[i3 + 3] & 255) << 24) + ((bArr[i3 + 2] & 255) << 16) + ((bArr[i3 + 1] & 255) << 8) + (bArr[i3] & 255);
    }

    public static short getShort(byte[] bArr, int i3) {
        int i10 = bArr[i3 + 1] & 255;
        return (short) ((i10 << 8) + (bArr[i3] & 255));
    }

    public static short getShort2(byte[] bArr, int i3) {
        int i10 = bArr[i3] & 255;
        return (short) ((i10 << 8) + (bArr[i3 + 1] & 255));
    }

    public static String getString(byte[] bArr, int i3, int i10) {
        try {
            return new String(bArr, i3, i10, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i3, int i10) {
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i3, bArr2, 0, i10);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i3) {
        int i10 = bArr[i3 + 1] & 255;
        return (i10 << 8) + (bArr[i3] & 255);
    }

    public static void moveArray(byte[] bArr, int i3, byte[] bArr2, int i10, int i11) {
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr, i3, bArr3, 0, i11);
        System.arraycopy(bArr3, 0, bArr2, i10, i11);
    }

    public static void writeInt(byte[] bArr, int i3, int i10) {
        System.arraycopy(convertInt(i10), 0, bArr, i3, 4);
    }

    public static void writeShort(byte[] bArr, int i3, short s7) {
        System.arraycopy(convertShort(s7), 0, bArr, i3, 2);
    }
}
