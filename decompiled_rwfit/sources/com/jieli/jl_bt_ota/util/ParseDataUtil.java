package com.jieli.jl_bt_ota.util;

/* loaded from: classes.dex */
public abstract class ParseDataUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11390a = "0123456789ABCDEF".toCharArray();

    static {
        System.loadLibrary("jl_ota_auth");
    }

    public static byte[] a(byte[] bArr) {
        if (bArr.length <= 1) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = bArr[(bArr.length - i3) - 1];
        }
        return bArr2;
    }

    public static String b(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                int i10 = (bArr[i3] & 255) >> 4;
                char[] cArr = f11390a;
                sb2.append(cArr[i10]);
                sb2.append(cArr[bArr[i3] & 15]);
                if (i3 != bArr.length - 1) {
                    sb2.append(":");
                }
            }
        }
        return sb2.toString();
    }
}
