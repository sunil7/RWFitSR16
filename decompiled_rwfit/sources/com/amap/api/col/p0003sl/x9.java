package com.amap.api.col.p0003sl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class x9 {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f5403a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f5404b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f5405c = true;

    private x9() {
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, bArr.length);
        } catch (IOException e) {
            if (!f5405c) {
                throw new AssertionError(e.getMessage());
            }
            str = null;
        }
        if (f5405c || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:41:0x017a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.InputStream, java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.zip.GZIPInputStream] */
    public static byte[] a(java.lang.String r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.x9.a(java.lang.String):byte[]");
    }

    private static byte[] a(byte[] bArr, int i3, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = f5403a;
        int i12 = (i10 > 0 ? (bArr[i3] << 24) >>> 8 : 0) | (i10 > 1 ? (bArr[i3 + 1] << 24) >>> 16 : 0) | (i10 > 2 ? (bArr[i3 + 2] << 24) >>> 24 : 0);
        if (i10 == 1) {
            bArr2[i11] = bArr3[i12 >>> 18];
            bArr2[i11 + 1] = bArr3[(i12 >>> 12) & 63];
            bArr2[i11 + 2] = 61;
            bArr2[i11 + 3] = 61;
            return bArr2;
        }
        if (i10 == 2) {
            bArr2[i11] = bArr3[i12 >>> 18];
            bArr2[i11 + 1] = bArr3[(i12 >>> 12) & 63];
            bArr2[i11 + 2] = bArr3[(i12 >>> 6) & 63];
            bArr2[i11 + 3] = 61;
            return bArr2;
        }
        if (i10 != 3) {
            return bArr2;
        }
        bArr2[i11] = bArr3[i12 >>> 18];
        bArr2[i11 + 1] = bArr3[(i12 >>> 12) & 63];
        bArr2[i11 + 2] = bArr3[(i12 >>> 6) & 63];
        bArr2[i11 + 3] = bArr3[i12 & 63];
        return bArr2;
    }

    private static String a(byte[] bArr, int i3) throws IOException {
        if (i3 >= 0) {
            if (i3 <= bArr.length) {
                int i10 = ((i3 / 3) * 4) + (i3 % 3 <= 0 ? 0 : 4);
                byte[] bArr2 = new byte[i10];
                int i11 = i3 - 2;
                int i12 = 0;
                int i13 = 0;
                while (i12 < i11) {
                    a(bArr, i12, 3, bArr2, i13);
                    i12 += 3;
                    i13 += 4;
                }
                if (i12 < i3) {
                    a(bArr, i12, i3 - i12, bArr2, i13);
                    i13 += 4;
                }
                if (i13 <= i10 - 1) {
                    byte[] bArr3 = new byte[i13];
                    System.arraycopy(bArr2, 0, bArr3, 0, i13);
                    bArr2 = bArr3;
                }
                try {
                    return new String(bArr2, "US-ASCII");
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr2);
                }
            }
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i3), Integer.valueOf(bArr.length)));
        }
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i3)));
    }
}
