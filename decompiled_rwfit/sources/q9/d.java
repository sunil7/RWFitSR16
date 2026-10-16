package q9;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final o4.c f17808b = new o4.c("LibraryVersion", "");

    /* renamed from: c, reason: collision with root package name */
    public static final d f17809c = new d();

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f17810a = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "LibraryVersion"
            o4.c r1 = q9.d.f17808b
            java.lang.String r2 = "Failed to get app version for libraryName: "
            java.lang.String r3 = "/"
            java.lang.String r4 = "Please provide a valid libraryName"
            q9.n.d(r11, r4)
            java.util.concurrent.ConcurrentHashMap r4 = r10.f17810a
            boolean r5 = r4.containsKey(r11)
            if (r5 == 0) goto L1c
            java.lang.Object r11 = r4.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            return r11
        L1c:
            java.util.Properties r5 = new java.util.Properties
            r5.<init>()
            r6 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L93 java.lang.Throwable -> L96
            r7.<init>(r3)     // Catch: java.io.IOException -> L93 java.lang.Throwable -> L96
            r7.append(r11)     // Catch: java.io.IOException -> L93 java.lang.Throwable -> L96
            java.lang.String r3 = ".properties"
            r7.append(r3)     // Catch: java.io.IOException -> L93 java.lang.Throwable -> L96
            java.lang.String r3 = r7.toString()     // Catch: java.io.IOException -> L93 java.lang.Throwable -> L96
            java.lang.Class<q9.d> r7 = q9.d.class
            java.io.InputStream r3 = r7.getResourceAsStream(r3)     // Catch: java.io.IOException -> L93 java.lang.Throwable -> L96
            if (r3 == 0) goto L72
            r5.load(r3)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.String r7 = "version"
            java.lang.String r6 = r5.getProperty(r7, r6)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r5.<init>()     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r5.append(r11)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.String r7 = " version is "
            r5.append(r7)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r5.append(r6)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.Object r7 = r1.f16732a     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r8 = 2
            boolean r7 = android.util.Log.isLoggable(r7, r8)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            if (r7 == 0) goto Lba
            java.lang.String r5 = r1.r(r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            android.util.Log.v(r0, r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            goto Lba
        L6b:
            r11 = move-exception
            goto L91
        L6d:
            r5 = move-exception
            r9 = r6
            r6 = r3
            r3 = r9
            goto L99
        L72:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r5.append(r11)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.Object r7 = r1.f16732a     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r8 = 5
            boolean r7 = android.util.Log.isLoggable(r7, r8)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            if (r7 == 0) goto Lba
            java.lang.String r5 = r1.r(r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            android.util.Log.w(r0, r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            goto Lba
        L91:
            r6 = r3
            goto Ldb
        L93:
            r3 = move-exception
            r5 = r3
            goto L98
        L96:
            r11 = move-exception
            goto Ldb
        L98:
            r3 = r6
        L99:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L96
            r7.append(r11)     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = r7.toString()     // Catch: java.lang.Throwable -> L96
            java.lang.Object r7 = r1.f16732a     // Catch: java.lang.Throwable -> L96
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L96
            r8 = 6
            boolean r7 = android.util.Log.isLoggable(r7, r8)     // Catch: java.lang.Throwable -> L96
            if (r7 == 0) goto Lb7
            java.lang.String r2 = r1.r(r2)     // Catch: java.lang.Throwable -> L96
            android.util.Log.e(r0, r2, r5)     // Catch: java.lang.Throwable -> L96
        Lb7:
            r9 = r6
            r6 = r3
            r3 = r9
        Lba:
            if (r3 == 0) goto Lbf
            r3.close()     // Catch: java.io.IOException -> Lbf
        Lbf:
            if (r6 != 0) goto Ld7
            java.lang.Object r2 = r1.f16732a
            java.lang.String r2 = (java.lang.String) r2
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)
            if (r2 == 0) goto Ld5
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            java.lang.String r1 = r1.r(r2)
            android.util.Log.d(r0, r1)
        Ld5:
            java.lang.String r6 = "UNKNOWN"
        Ld7:
            r4.put(r11, r6)
            return r6
        Ldb:
            if (r6 == 0) goto Le0
            r6.close()     // Catch: java.io.IOException -> Le0
        Le0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.d.a(java.lang.String):java.lang.String");
    }
}
