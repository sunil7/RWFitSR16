package com.amap.api.col.p0003sl;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class z8 {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = null;
        try {
            try {
                bArr2 = a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
            } catch (Throwable th2) {
                ka.a(th2, "AMU", "grk");
                bArr2 = null;
            }
            try {
                bArr3 = a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
            } catch (Throwable th3) {
                ka.a(th3, "AMU", "giv");
            }
            return h9.b(bArr2, bArr, bArr3);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = null;
        try {
            try {
                bArr2 = a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
            } catch (Throwable th2) {
                ka.a(th2, "AMU", "grk");
                bArr2 = null;
            }
            try {
                bArr3 = a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
            } catch (Throwable th3) {
                ka.a(th3, "AMU", "giv");
            }
            return h9.c(bArr2, bArr, bArr3);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    private static byte[] a(String str) {
        try {
            String[] split = new StringBuffer(str).reverse().toString().split(Const.STR_MART_COMMA);
            int length = split.length;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                bArr[i3] = Byte.parseByte(split[i3]);
            }
            String[] split2 = new StringBuffer(new String(x9.a(new String(bArr)), "UTF-8")).reverse().toString().split(Const.STR_MART_COMMA);
            byte[] bArr2 = new byte[split2.length];
            for (int i10 = 0; i10 < split2.length; i10++) {
                bArr2[i10] = Byte.parseByte(split2[i10]);
            }
            return bArr2;
        } catch (Throwable th2) {
            ka.a(th2, "AMU", "rcs");
            return null;
        }
    }
}
