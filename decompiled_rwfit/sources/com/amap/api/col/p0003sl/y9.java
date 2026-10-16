package com.amap.api.col.p0003sl;

import java.io.Closeable;

/* loaded from: classes.dex */
public final class y9 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5474a = n9.b("SYmFja3Vwcw");

    /* renamed from: b, reason: collision with root package name */
    public static final String f5475b = n9.b("SLmFkaXU");

    /* renamed from: c, reason: collision with root package name */
    public static final String f5476c = n9.b("JIw");

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0022 A[Catch: all -> 0x000f, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x000f, blocks: (B:5:0x0004, B:7:0x000a, B:9:0x0014, B:10:0x001a, B:15:0x0022, B:38:0x008f, B:31:0x0092, B:32:0x0095, B:53:0x00a3, B:49:0x00a8, B:45:0x00ab), top: B:4:0x0004 }] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.nio.channels.FileChannel, java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<com.amap.api.col.3sl.y9> r0 = com.amap.api.col.p0003sl.y9.class
            monitor-enter(r0)
            r1 = 0
            java.io.File r2 = r4.getExternalCacheDir()     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L19
            if (r2 != 0) goto L12
            java.io.File r2 = r4.getCacheDir()     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L19
            goto L12
        Lf:
            r4 = move-exception
            goto Lb0
        L12:
            if (r2 == 0) goto L19
            java.lang.String r4 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L19
            goto L1a
        L19:
            r4 = r1
        L1a:
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto L22
            monitor-exit(r0)
            return
        L22:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf
            r2.<init>()     // Catch: java.lang.Throwable -> Lf
            r2.append(r5)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = com.amap.api.col.p0003sl.y9.f5476c     // Catch: java.lang.Throwable -> Lf
            r2.append(r5)     // Catch: java.lang.Throwable -> Lf
            r2.append(r6)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> Lf
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf
            r6.<init>()     // Catch: java.lang.Throwable -> Lf
            r6.append(r4)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> Lf
            r6.append(r4)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r4 = com.amap.api.col.p0003sl.y9.f5474a     // Catch: java.lang.Throwable -> Lf
            r6.append(r4)     // Catch: java.lang.Throwable -> Lf
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> Lf
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> Lf
            r6.<init>(r4)     // Catch: java.lang.Throwable -> Lf
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lf
            java.lang.String r2 = com.amap.api.col.p0003sl.y9.f5475b     // Catch: java.lang.Throwable -> Lf
            r4.<init>(r6, r2)     // Catch: java.lang.Throwable -> Lf
            boolean r2 = r6.exists()     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L64
            boolean r2 = r6.isDirectory()     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L67
        L64:
            r6.mkdirs()     // Catch: java.lang.Throwable -> L9f
        L67:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L9f
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "rws"
            r6.<init>(r4, r2)     // Catch: java.lang.Throwable -> L9f
            java.nio.channels.FileChannel r4 = r6.getChannel()     // Catch: java.lang.Throwable -> L9a
            java.nio.channels.FileLock r1 = r4.tryLock()     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L8d
            java.lang.String r2 = "UTF-8"
            byte[] r5 = r5.getBytes(r2)     // Catch: java.lang.Throwable -> L89
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r5)     // Catch: java.lang.Throwable -> L89
            r4.write(r5)     // Catch: java.lang.Throwable -> L89
            goto L8d
        L89:
            r3 = r1
            r1 = r4
            r4 = r3
            goto L9b
        L8d:
            if (r1 == 0) goto L92
            r1.release()     // Catch: java.lang.Throwable -> Lf java.io.IOException -> L92
        L92:
            r4.close()     // Catch: java.lang.Throwable -> Lf java.io.IOException -> L95
        L95:
            a(r6)     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r0)
            return
        L9a:
            r4 = r1
        L9b:
            r3 = r1
            r1 = r4
            r4 = r3
            goto La1
        L9f:
            r4 = r1
            r6 = r4
        La1:
            if (r1 == 0) goto La6
            r1.release()     // Catch: java.lang.Throwable -> Lf java.io.IOException -> La6
        La6:
            if (r4 == 0) goto Lab
            r4.close()     // Catch: java.lang.Throwable -> Lf java.io.IOException -> Lab
        Lab:
            a(r6)     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r0)
            return
        Lb0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.y9.a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
