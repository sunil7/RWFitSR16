package qc;

import com.google.zxing.f;

/* loaded from: classes.dex */
public final class b implements f {
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003a  */
    @Override // com.google.zxing.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.zxing.g a(com.google.zxing.a r8, java.util.EnumMap r9) {
        /*
            r7 = this;
            rc.a r1 = new rc.a
            sc.b r8 = r8.a()
            r1.<init>(r8)
            r8 = 0
            r2 = 0
            qc.a r0 = r1.a(r2)     // Catch: com.google.zxing.FormatException -> L2a com.google.zxing.NotFoundException -> L31
            com.google.zxing.h[] r3 = r0.f17893b     // Catch: com.google.zxing.FormatException -> L2a com.google.zxing.NotFoundException -> L31
            int r2 = r0.f17896f     // Catch: com.google.zxing.FormatException -> L22 com.google.zxing.NotFoundException -> L24
            com.google.zxing.aztec.decoder.b r4 = new com.google.zxing.aztec.decoder.b     // Catch: com.google.zxing.FormatException -> L22 com.google.zxing.NotFoundException -> L24
            r4.<init>()     // Catch: com.google.zxing.FormatException -> L22 com.google.zxing.NotFoundException -> L24
            sc.d r0 = r4.a(r0)     // Catch: com.google.zxing.FormatException -> L22 com.google.zxing.NotFoundException -> L24
            r4 = r3
            r3 = r8
            r8 = r0
            r0 = r2
            r2 = r3
            goto L38
        L22:
            r0 = move-exception
            goto L2c
        L24:
            r0 = move-exception
            goto L33
        L26:
            r3 = r8
            goto L2c
        L28:
            r3 = r8
            goto L33
        L2a:
            r0 = move-exception
            goto L26
        L2c:
            r4 = r3
            r3 = r0
            r0 = r2
            r2 = r8
            goto L38
        L31:
            r0 = move-exception
            goto L28
        L33:
            r4 = r2
            r2 = r0
            r0 = r4
            r4 = r3
            r3 = r8
        L38:
            if (r8 != 0) goto L59
            r8 = 1
            qc.a r8 = r1.a(r8)     // Catch: com.google.zxing.FormatException -> L4d com.google.zxing.NotFoundException -> L50
            com.google.zxing.h[] r4 = r8.f17893b     // Catch: com.google.zxing.FormatException -> L4d com.google.zxing.NotFoundException -> L50
            int r0 = r8.f17896f     // Catch: com.google.zxing.FormatException -> L4d com.google.zxing.NotFoundException -> L50
            com.google.zxing.aztec.decoder.b r1 = new com.google.zxing.aztec.decoder.b     // Catch: com.google.zxing.FormatException -> L4d com.google.zxing.NotFoundException -> L50
            r1.<init>()     // Catch: com.google.zxing.FormatException -> L4d com.google.zxing.NotFoundException -> L50
            sc.d r8 = r1.a(r8)     // Catch: com.google.zxing.FormatException -> L4d com.google.zxing.NotFoundException -> L50
            goto L59
        L4d:
            r0 = move-exception
        L4e:
            r8 = r0
            goto L52
        L50:
            r0 = move-exception
            goto L4e
        L52:
            if (r2 != 0) goto L58
            if (r3 == 0) goto L57
            throw r3
        L57:
            throw r8
        L58:
            throw r2
        L59:
            if (r9 == 0) goto L6a
            com.google.zxing.DecodeHintType r1 = com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r9 = r9.get(r1)
            if (r9 != 0) goto L64
            goto L6a
        L64:
            java.lang.ClassCastException r8 = new java.lang.ClassCastException
            r8.<init>()
            throw r8
        L6a:
            com.google.zxing.g r1 = new com.google.zxing.g
            com.google.zxing.BarcodeFormat r5 = com.google.zxing.BarcodeFormat.AZTEC
            java.lang.System.currentTimeMillis()
            byte[] r3 = r8.f18228a
            r6 = 0
            java.lang.String r2 = r8.f18229b
            r1.<init>(r2, r3, r4, r5, r6)
            java.util.ArrayList r9 = r8.f18230c
            if (r9 == 0) goto L82
            com.google.zxing.ResultMetadataType r2 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS
            r1.b(r2, r9)
        L82:
            java.lang.String r9 = r8.f18231d
            if (r9 == 0) goto L8b
            com.google.zxing.ResultMetadataType r2 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL
            r1.b(r2, r9)
        L8b:
            java.lang.Integer r9 = r8.e
            int r9 = r9.intValue()
            int r9 = r9 + r0
            com.google.zxing.ResultMetadataType r0 = com.google.zxing.ResultMetadataType.ERRORS_CORRECTED
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r1.b(r0, r9)
            com.google.zxing.ResultMetadataType r9 = com.google.zxing.ResultMetadataType.SYMBOLOGY_IDENTIFIER
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "]z"
            r0.<init>(r2)
            int r8 = r8.f18236j
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r1.b(r9, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: qc.b.a(com.google.zxing.a, java.util.EnumMap):com.google.zxing.g");
    }

    @Override // com.google.zxing.f
    public final void b() {
    }
}
