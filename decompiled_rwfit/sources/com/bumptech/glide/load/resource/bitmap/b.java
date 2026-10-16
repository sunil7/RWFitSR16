package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_common.o;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import g4.b0;
import g4.c;
import g4.j;
import g4.m;
import x3.e;
import x3.f;
import x3.g;
import z3.s;

/* loaded from: classes.dex */
public final class b implements g {

    /* renamed from: d, reason: collision with root package name */
    public static final e f7026d = new e("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new i0(18));
    public static final e e = new e("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new j());

    /* renamed from: f, reason: collision with root package name */
    public static final o f7027f = new o(12);

    /* renamed from: a, reason: collision with root package name */
    public final b0 f7028a;

    /* renamed from: b, reason: collision with root package name */
    public final a4.b f7029b;

    /* renamed from: c, reason: collision with root package name */
    public final o f7030c = f7027f;

    public b(a4.b bVar, b0 b0Var) {
        this.f7029b = bVar;
        this.f7028a = b0Var;
    }

    public static Bitmap c(MediaMetadataRetriever mediaMetadataRetriever, long j4, int i3, int i10, int i11, m mVar) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 27 && i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && mVar != m.e) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float b3 = mVar.b(parseInt, parseInt2, i10, i11);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j4, i3, Math.round(parseInt * b3), Math.round(b3 * parseInt2));
            } catch (Throwable th2) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th2);
                }
            }
        }
        if (bitmap == null) {
            bitmap = mediaMetadataRetriever.getFrameAtTime(j4, i3);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new RuntimeException() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder$VideoDecoderException
            private static final long serialVersionUID = -2556382523004027815L;
        };
    }

    @Override // x3.g
    public final boolean a(Object obj, f fVar) {
        return true;
    }

    @Override // x3.g
    public final s b(Object obj, int i3, int i10, f fVar) {
        long longValue = ((Long) fVar.c(f7026d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException(l0.l(longValue, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
        }
        Integer num = (Integer) fVar.c(e);
        if (num == null) {
            num = 2;
        }
        m mVar = (m) fVar.c(m.f13832g);
        if (mVar == null) {
            mVar = m.f13831f;
        }
        m mVar2 = mVar;
        this.f7030c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f7028a.b(mediaMetadataRetriever, obj);
            Bitmap c9 = c(mediaMetadataRetriever, longValue, num.intValue(), i3, i10, mVar2);
            mediaMetadataRetriever.release();
            return c.b(this.f7029b, c9);
        } catch (Throwable th2) {
            mediaMetadataRetriever.release();
            throw th2;
        }
    }
}
