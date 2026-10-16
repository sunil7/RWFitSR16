package k4;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.internal.mlkit_common.o;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a implements x3.g {

    /* renamed from: f, reason: collision with root package name */
    public static final o f15462f = new o(14);

    /* renamed from: g, reason: collision with root package name */
    public static final e0 f15463g = new e0(22);

    /* renamed from: a, reason: collision with root package name */
    public final Context f15464a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f15465b;

    /* renamed from: c, reason: collision with root package name */
    public final e0 f15466c;

    /* renamed from: d, reason: collision with root package name */
    public final o f15467d;
    public final ef.i e;

    public a(Context context, ArrayList arrayList, a4.b bVar, a4.g gVar) {
        o oVar = f15462f;
        this.f15464a = context.getApplicationContext();
        this.f15465b = arrayList;
        this.f15467d = oVar;
        this.e = new ef.i(22, bVar, gVar);
        this.f15466c = f15463g;
    }

    public static int d(w3.b bVar, int i3, int i10) {
        int min = Math.min(bVar.f19491g / i10, bVar.f19490f / i3);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder s7 = l0.s(max, "Downsampling GIF, sampleSize: ", i3, ", target dimens: [", "x");
            s7.append(i10);
            s7.append("], actual dimens: [");
            s7.append(bVar.f19490f);
            s7.append("x");
            s7.append(bVar.f19491g);
            s7.append("]");
            Log.v("BufferGifDecoder", s7.toString());
        }
        return max;
    }

    @Override // x3.g
    public final boolean a(Object obj, x3.f fVar) {
        ImageHeaderParser$ImageType imageHeaderParser$ImageType;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!((Boolean) fVar.c(i.f15502b)).booleanValue()) {
            if (byteBuffer == null) {
                imageHeaderParser$ImageType = ImageHeaderParser$ImageType.UNKNOWN;
            } else {
                ArrayList arrayList = this.f15465b;
                int size = arrayList.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        imageHeaderParser$ImageType = ImageHeaderParser$ImageType.UNKNOWN;
                        break;
                    }
                    ImageHeaderParser$ImageType a3 = ((x3.b) arrayList.get(i3)).a(byteBuffer);
                    if (a3 != ImageHeaderParser$ImageType.UNKNOWN) {
                        imageHeaderParser$ImageType = a3;
                        break;
                    }
                    i3++;
                }
            }
            if (imageHeaderParser$ImageType == ImageHeaderParser$ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x005b
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // x3.g
    public final z3.s b(java.lang.Object r8, int r9, int r10, x3.f r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            com.example.test.ui.device.activity.e0 r8 = r7.f15466c
            monitor-enter(r8)
            java.lang.Object r0 = r8.f7855b     // Catch: java.lang.Throwable -> L56
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch: java.lang.Throwable -> L56
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L56
            w3.c r0 = (w3.c) r0     // Catch: java.lang.Throwable -> L56
            if (r0 != 0) goto L17
            w3.c r0 = new w3.c     // Catch: java.lang.Throwable -> L19
            r0.<init>()     // Catch: java.lang.Throwable -> L19
        L17:
            r5 = r0
            goto L1d
        L19:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L59
        L1d:
            r0 = 0
            r5.f19497b = r0     // Catch: java.lang.Throwable -> L56
            byte[] r0 = r5.f19496a     // Catch: java.lang.Throwable -> L56
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L56
            w3.b r0 = new w3.b     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
            r5.f19498c = r0     // Catch: java.lang.Throwable -> L56
            r5.f19499d = r1     // Catch: java.lang.Throwable -> L56
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L56
            r5.f19497b = r0     // Catch: java.lang.Throwable -> L56
            r0.position(r1)     // Catch: java.lang.Throwable -> L56
            java.nio.ByteBuffer r0 = r5.f19497b     // Catch: java.lang.Throwable -> L56
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L56
            r0.order(r1)     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            i4.a r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4e
            com.example.test.ui.device.activity.e0 r9 = r1.f15466c
            r9.H(r5)
            return r8
        L4e:
            r0 = move-exception
            r8 = r0
            com.example.test.ui.device.activity.e0 r9 = r1.f15466c
            r9.H(r5)
            throw r8
        L56:
            r0 = move-exception
            r1 = r7
        L58:
            r9 = r0
        L59:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L5b
            throw r9
        L5b:
            r0 = move-exception
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.a.b(java.lang.Object, int, int, x3.f):z3.s");
    }

    public final i4.a c(ByteBuffer byteBuffer, int i3, int i10, w3.c cVar, x3.f fVar) {
        StringBuilder sb2;
        int i11 = t4.g.f18515b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            w3.b b3 = cVar.b();
            if (b3.f19488c > 0 && b3.f19487b == 0) {
                Bitmap.Config config = fVar.c(i.f15501a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int d5 = d(b3, i3, i10);
                o oVar = this.f15467d;
                ef.i iVar = this.e;
                oVar.getClass();
                w3.d dVar = new w3.d(iVar, b3, byteBuffer, d5);
                dVar.c(config);
                dVar.f19509k = (dVar.f19509k + 1) % dVar.f19510l.f19488c;
                Bitmap b10 = dVar.b();
                if (b10 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb2 = new StringBuilder("Decoded GIF from stream in ");
                        sb2.append(t4.g.a(elapsedRealtimeNanos));
                        Log.v("BufferGifDecoder", sb2.toString());
                        return null;
                    }
                    return null;
                }
                i4.a aVar = new i4.a(new c(new b(new h(com.bumptech.glide.b.b(this.f15464a), dVar, i3, i10, b10))), 1);
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + t4.g.a(elapsedRealtimeNanos));
                }
                return aVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb2 = new StringBuilder("Decoded GIF from stream in ");
                sb2.append(t4.g.a(elapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb2.toString());
                return null;
            }
            return null;
        } catch (Throwable th2) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + t4.g.a(elapsedRealtimeNanos));
            }
            throw th2;
        }
    }
}
