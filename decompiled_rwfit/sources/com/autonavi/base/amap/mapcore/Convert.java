package com.autonavi.base.amap.mapcore;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class Convert {
    public static final String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b3 : bArr) {
            String hexString = Integer.toHexString(b3 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static void convert1bString(byte[] bArr, int i3, ConvertString convertString) {
        try {
            byte b3 = bArr[i3];
            convertString.byteLength = b3;
            convertString.value = new String(bArr, i3 + 1, b3, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

    public static void convert2bString(byte[] bArr, int i3, ConvertString convertString) {
        try {
            short s7 = getShort(bArr, i3);
            convertString.byteLength = s7;
            convertString.value = new String(bArr, i3 + 2, s7, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

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

    public static byte[] copyString(byte[] bArr, int i3, int i10) {
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, i3, bArr2, 0, i10);
        return bArr2;
    }

    public static byte[] covertBytes(byte b3) {
        return new byte[]{b3};
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

    public static byte[] get2BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(convertShort(bytes.length));
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static boolean getBit(byte b3, int i3) {
        int i10 = 32 - i3;
        return (((b3 << i10) >>> i10) >>> (i3 - 1)) > 0;
    }

    public static byte[] getDouble(double d5) {
        byte[] bArr = new byte[8];
        String hexString = Long.toHexString(Double.doubleToLongBits(d5));
        for (int i3 = 0; i3 < 8; i3++) {
            int i10 = i3 * 2;
            bArr[7 - i3] = (byte) Integer.parseInt(hexString.substring(i10, i10 + 2), 16);
        }
        return bArr;
    }

    public static int getInt(byte[] bArr, int i3) {
        int i10 = bArr[i3 + 3] & 255;
        int i11 = bArr[i3 + 2] & 255;
        int i12 = bArr[i3 + 1] & 255;
        return (i10 << 24) + (i11 << 16) + (i12 << 8) + (bArr[i3] & 255);
    }

    public static int getNum(byte b3, int i3, int i10) {
        int i11 = 31 - i10;
        return ((b3 << i11) >>> i11) >>> i3;
    }

    public static short getShort(byte[] bArr, int i3) {
        int i10 = bArr[i3 + 1] & 255;
        return (short) ((i10 << 8) + (bArr[i3] & 255));
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

    public static int getNum(short s7, int i3, int i10) {
        int i11 = 32 - i10;
        return ((s7 << i11) >>> i11) >>> (i3 - 1);
    }
}
