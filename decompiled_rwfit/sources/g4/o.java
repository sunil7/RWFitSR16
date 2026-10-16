package g4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.PreferredColorSpace;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: f, reason: collision with root package name */
    public static final x3.e f13835f = x3.e.a(DecodeFormat.DEFAULT, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    /* renamed from: g, reason: collision with root package name */
    public static final x3.e f13836g = x3.e.a(PreferredColorSpace.SRGB, "com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* renamed from: h, reason: collision with root package name */
    public static final x3.e f13837h;

    /* renamed from: i, reason: collision with root package name */
    public static final x3.e f13838i;

    /* renamed from: j, reason: collision with root package name */
    public static final gc.b f13839j;

    /* renamed from: k, reason: collision with root package name */
    public static final ArrayDeque f13840k;

    /* renamed from: a, reason: collision with root package name */
    public final a4.b f13841a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f13842b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.g f13843c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f13844d;
    public final u e = u.a();

    static {
        m mVar = m.f13828b;
        Boolean bool = Boolean.FALSE;
        f13837h = x3.e.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f13838i = x3.e.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f13839j = new gc.b(11);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = t4.l.f18523a;
        f13840k = new ArrayDeque(0);
    }

    public o(ArrayList arrayList, DisplayMetrics displayMetrics, a4.b bVar, a4.g gVar) {
        this.f13844d = arrayList;
        t4.f.c(displayMetrics, "Argument must not be null");
        this.f13842b = displayMetrics;
        this.f13841a = bVar;
        this.f13843c = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap c(de.o r9, android.graphics.BitmapFactory.Options r10, g4.n r11, a4.b r12) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r10.inJustDecodeBounds
            if (r1 != 0) goto L22
            r11.n()
            int r1 = r9.f12376a
            switch(r1) {
                case 23: goto Lf;
                default: goto Le;
            }
        Le:
            goto L22
        Lf:
            java.lang.Object r1 = r9.f12377b
            com.bumptech.glide.load.data.i r1 = (com.bumptech.glide.load.data.i) r1
            java.lang.Object r1 = r1.f6970b
            com.bumptech.glide.load.resource.bitmap.a r1 = (com.bumptech.glide.load.resource.bitmap.a) r1
            monitor-enter(r1)
            byte[] r2 = r1.f7021a     // Catch: java.lang.Throwable -> L1f
            int r2 = r2.length     // Catch: java.lang.Throwable -> L1f
            r1.f7023c = r2     // Catch: java.lang.Throwable -> L1f
            monitor-exit(r1)
            goto L22
        L1f:
            r9 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            throw r9
        L22:
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            java.lang.String r3 = r10.outMimeType
            java.util.concurrent.locks.Lock r4 = g4.x.f13864d
            r4.lock()
            android.graphics.Bitmap r9 = r9.k(r10)     // Catch: java.lang.IllegalArgumentException -> L35 java.lang.Throwable -> L7c
            r4.unlock()
            return r9
        L35:
            r4 = move-exception
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            java.lang.String r7 = ", outHeight: "
            java.lang.String r8 = ", outMimeType: "
            java.lang.StringBuilder r1 = com.google.android.gms.internal.mlkit_vision_barcode.l0.s(r1, r6, r2, r7, r8)     // Catch: java.lang.Throwable -> L7c
            r1.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = ", inBitmap: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            android.graphics.Bitmap r2 = r10.inBitmap     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = d(r2)     // Catch: java.lang.Throwable -> L7c
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L7c
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L7c
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L66
            java.lang.String r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r1, r5)     // Catch: java.lang.Throwable -> L7c
        L66:
            android.graphics.Bitmap r0 = r10.inBitmap     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L7b
            r12.j(r0)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            r0 = 0
            r10.inBitmap = r0     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            android.graphics.Bitmap r9 = c(r9, r10, r11, r12)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            java.util.concurrent.locks.Lock r10 = g4.x.f13864d
            r10.unlock()
            return r9
        L7a:
            throw r5     // Catch: java.lang.Throwable -> L7c
        L7b:
            throw r5     // Catch: java.lang.Throwable -> L7c
        L7c:
            r9 = move-exception
            java.util.concurrent.locks.Lock r10 = g4.x.f13864d
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.o.c(de.o, android.graphics.BitmapFactory$Options, g4.n, a4.b):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final c a(de.o oVar, int i3, int i10, x3.f fVar, n nVar) {
        ArrayDeque arrayDeque;
        BitmapFactory.Options options;
        byte[] bArr = (byte[]) this.f13843c.c(byte[].class, WXMediaMessage.THUMB_LENGTH_LIMIT);
        synchronized (o.class) {
            arrayDeque = f13840k;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                e(options);
            }
        }
        options.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.c(f13835f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) fVar.c(f13836g);
        m mVar = (m) fVar.c(m.f13832g);
        boolean booleanValue = ((Boolean) fVar.c(f13837h)).booleanValue();
        x3.e eVar = f13838i;
        try {
            c b3 = c.b(this.f13841a, b(oVar, options, mVar, decodeFormat, preferredColorSpace, fVar.c(eVar) != null && ((Boolean) fVar.c(eVar)).booleanValue(), i3, i10, booleanValue, nVar));
            e(options);
            synchronized (arrayDeque) {
                arrayDeque.offer(options);
            }
            this.f13843c.g(bArr);
            return b3;
        } catch (Throwable th2) {
            e(options);
            ArrayDeque arrayDeque2 = f13840k;
            synchronized (arrayDeque2) {
                arrayDeque2.offer(options);
                this.f13843c.g(bArr);
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05a8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(de.o r43, android.graphics.BitmapFactory.Options r44, g4.m r45, com.bumptech.glide.load.DecodeFormat r46, com.bumptech.glide.load.PreferredColorSpace r47, boolean r48, int r49, int r50, boolean r51, g4.n r52) {
        /*
            Method dump skipped, instructions count: 1526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.o.b(de.o, android.graphics.BitmapFactory$Options, g4.m, com.bumptech.glide.load.DecodeFormat, com.bumptech.glide.load.PreferredColorSpace, boolean, int, int, boolean, g4.n):android.graphics.Bitmap");
    }
}
