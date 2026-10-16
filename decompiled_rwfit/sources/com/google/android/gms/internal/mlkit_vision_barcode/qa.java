package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class qa {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if (r5 != (-1)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        d(r1, r7, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r12[r5] = (r12[r5] & r4) | (r7 & r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.Object r8, java.lang.Object r9, int r10, java.lang.Object r11, int[] r12, java.lang.Object[] r13, java.lang.Object[] r14) {
        /*
            int r0 = com.google.android.gms.internal.mlkit_vision_barcode.ra.a(r8)
            r1 = r0 & r10
            int r2 = b(r1, r11)
            r3 = -1
            if (r2 == 0) goto L3e
            int r4 = ~r10
            r0 = r0 & r4
            r5 = r3
        L10:
            int r2 = r2 + r3
            r6 = r12[r2]
            r7 = r6 & r10
            r6 = r6 & r4
            if (r6 != r0) goto L39
            r6 = r13[r2]
            boolean r6 = com.google.android.gms.internal.mlkit_vision_barcode.na.a(r8, r6)
            if (r6 == 0) goto L39
            if (r14 == 0) goto L2a
            r6 = r14[r2]
            boolean r6 = com.google.android.gms.internal.mlkit_vision_barcode.na.a(r9, r6)
            if (r6 == 0) goto L39
        L2a:
            if (r5 != r3) goto L30
            d(r1, r7, r11)
            return r2
        L30:
            r8 = r12[r5]
            r8 = r8 & r4
            r9 = r7 & r10
            r8 = r8 | r9
            r12[r5] = r8
            return r2
        L39:
            if (r7 == 0) goto L3e
            r5 = r2
            r2 = r7
            goto L10
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.qa.a(java.lang.Object, java.lang.Object, int, java.lang.Object, int[], java.lang.Object[], java.lang.Object[]):int");
    }

    public static int b(int i3, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i3] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i3] : ((int[]) obj)[i3];
    }

    public static Object c(int i3) {
        if (i3 < 2 || i3 > 1073741824 || Integer.highestOneBit(i3) != i3) {
            throw new IllegalArgumentException(l0.j(i3, "must be power of 2 between 2^1 and 2^30: "));
        }
        return i3 <= 256 ? new byte[i3] : i3 <= 65536 ? new short[i3] : new int[i3];
    }

    public static void d(int i3, int i10, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i3] = (byte) i10;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i3] = (short) i10;
        } else {
            ((int[]) obj)[i3] = i10;
        }
    }
}
