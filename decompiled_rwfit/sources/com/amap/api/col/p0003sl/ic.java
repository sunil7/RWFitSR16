package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public class ic extends hc {
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r4 == null) goto L31;
     */
    @Override // com.amap.api.col.p0003sl.hc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] b(byte[] r9) {
        /*
            r8 = this;
            java.lang.String r0 = "zp2"
            java.lang.String r1 = "zp1"
            java.lang.String r2 = "ut"
            int r3 = com.amap.api.col.p0003sl.n9.f4707d
            r3 = 0
            if (r9 == 0) goto L71
            int r4 = r9.length
            if (r4 != 0) goto Lf
            goto L71
        Lf:
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3e
            r4.<init>()     // Catch: java.lang.Throwable -> L3e
            java.util.zip.ZipOutputStream r5 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L3b
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L3b
            java.util.zip.ZipEntry r6 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> L39
            java.lang.String r7 = "log"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L39
            r5.putNextEntry(r6)     // Catch: java.lang.Throwable -> L39
            r5.write(r9)     // Catch: java.lang.Throwable -> L39
            r5.closeEntry()     // Catch: java.lang.Throwable -> L39
            r5.finish()     // Catch: java.lang.Throwable -> L39
            byte[] r3 = r4.toByteArray()     // Catch: java.lang.Throwable -> L39
            r5.close()     // Catch: java.lang.Throwable -> L34
            goto L52
        L34:
            r9 = move-exception
            com.amap.api.col.p0003sl.ga.a(r9, r2, r1)
            goto L52
        L39:
            r9 = move-exception
            goto L41
        L3b:
            r9 = move-exception
            r5 = r3
            goto L41
        L3e:
            r9 = move-exception
            r4 = r3
            r5 = r4
        L41:
            java.lang.String r6 = "zp"
            com.amap.api.col.p0003sl.ga.a(r9, r2, r6)     // Catch: java.lang.Throwable -> L5b
            if (r5 == 0) goto L50
            r5.close()     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r9 = move-exception
            com.amap.api.col.p0003sl.ga.a(r9, r2, r1)
        L50:
            if (r4 == 0) goto L5a
        L52:
            r4.close()     // Catch: java.lang.Throwable -> L56
            goto L5a
        L56:
            r9 = move-exception
            com.amap.api.col.p0003sl.ga.a(r9, r2, r0)
        L5a:
            return r3
        L5b:
            r9 = move-exception
            if (r5 == 0) goto L66
            r5.close()     // Catch: java.lang.Throwable -> L62
            goto L66
        L62:
            r3 = move-exception
            com.amap.api.col.p0003sl.ga.a(r3, r2, r1)
        L66:
            if (r4 == 0) goto L70
            r4.close()     // Catch: java.lang.Throwable -> L6c
            goto L70
        L6c:
            r1 = move-exception
            com.amap.api.col.p0003sl.ga.a(r1, r2, r0)
        L70:
            throw r9
        L71:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ic.b(byte[]):byte[]");
    }
}
