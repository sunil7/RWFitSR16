package g4;

import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes.dex */
public final class b implements x3.h {

    /* renamed from: b, reason: collision with root package name */
    public static final x3.e f13812b = x3.e.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");

    /* renamed from: c, reason: collision with root package name */
    public static final x3.e f13813c = new x3.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, x3.e.e);

    /* renamed from: a, reason: collision with root package name */
    public final a4.g f13814a;

    public b(a4.g gVar) {
        this.f13814a = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    @Override // x3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(java.lang.Object r9, java.io.File r10, x3.f r11) {
        /*
            r8 = this;
            z3.s r9 = (z3.s) r9
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            x3.e r1 = g4.b.f13813c
            java.lang.Object r2 = r11.c(r1)
            android.graphics.Bitmap$CompressFormat r2 = (android.graphics.Bitmap.CompressFormat) r2
            if (r2 == 0) goto L15
            goto L20
        L15:
            boolean r2 = r9.hasAlpha()
            if (r2 == 0) goto L1e
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG
            goto L20
        L1e:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
        L20:
            r9.getWidth()
            r9.getHeight()
            int r3 = t4.g.f18515b
            long r3 = android.os.SystemClock.elapsedRealtimeNanos()
            x3.e r5 = g4.b.f13812b
            java.lang.Object r5 = r11.c(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            a4.g r10 = r8.f13814a
            com.bumptech.glide.load.data.c r6 = new com.bumptech.glide.load.data.c     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r6.<init>(r7, r10)     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            r9.compress(r2, r5, r6)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r6.close()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r6.close()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52
            goto L52
        L4f:
            r9 = move-exception
            goto Lc1
        L52:
            r10 = 1
            goto L72
        L54:
            r9 = move-exception
            goto Lbb
        L56:
            r10 = move-exception
            goto L60
        L58:
            r6 = r7
            goto Lbb
        L5a:
            r6 = r7
            goto L60
        L5c:
            r9 = move-exception
            goto L58
        L5e:
            r10 = move-exception
            goto L5a
        L60:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L54
            if (r5 == 0) goto L6c
            java.lang.String r5 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r5, r10)     // Catch: java.lang.Throwable -> L54
        L6c:
            if (r6 == 0) goto L71
            r6.close()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L71
        L71:
            r10 = 0
        L72:
            r5 = 2
            boolean r5 = android.util.Log.isLoggable(r0, r5)
            if (r5 == 0) goto Lba
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Compressed with type: "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = " of size "
            r5.append(r2)
            int r2 = t4.l.c(r9)
            r5.append(r2)
            java.lang.String r2 = " in "
            r5.append(r2)
            double r2 = t4.g.a(r3)
            r5.append(r2)
            java.lang.String r2 = ", options format: "
            r5.append(r2)
            java.lang.Object r11 = r11.c(r1)
            r5.append(r11)
            java.lang.String r11 = ", hasAlpha: "
            r5.append(r11)
            boolean r9 = r9.hasAlpha()
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            android.util.Log.v(r0, r9)
        Lba:
            return r10
        Lbb:
            if (r6 == 0) goto Lc2
            r6.close()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> Lc2
            goto Lc2
        Lc1:
            throw r9
        Lc2:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.b.e(java.lang.Object, java.io.File, x3.f):boolean");
    }

    @Override // x3.h
    public final EncodeStrategy o(x3.f fVar) {
        return EncodeStrategy.TRANSFORMED;
    }
}
