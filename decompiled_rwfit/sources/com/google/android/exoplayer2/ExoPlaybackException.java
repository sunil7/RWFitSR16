package com.google.android.exoplayer2;

import android.os.Bundle;
import com.amap.api.services.core.AMapException;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends PlaybackException {
    public static final a CREATOR = new b9.a(22);
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    final boolean isRecoverable;
    public final x8.a mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final int type;

    public ExoPlaybackException(int i3, Exception exc, int i10) {
        this(i3, exc, null, i10, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, null, str, 1001, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th2, String str, int i3, Format format, int i10, boolean z5, int i11) {
        if (format == null) {
            i10 = 4;
        }
        return new ExoPlaybackException(1, th2, null, i11, str, i3, format, i10, z5);
    }

    public static ExoPlaybackException createForSource(IOException iOException, int i3) {
        return new ExoPlaybackException(0, iOException, i3);
    }

    @Deprecated
    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return createForUnexpected(runtimeException, 1000);
    }

    public ExoPlaybackException copyWithMediaPeriodId(x8.a aVar) {
        String message = getMessage();
        int i3 = i9.g.f14378a;
        return new ExoPlaybackException(message, getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, aVar, this.timestampMs, this.isRecoverable);
    }

    @Override // com.google.android.exoplayer2.PlaybackException
    public boolean errorInfoEquals(PlaybackException playbackException) {
        if (!super.errorInfoEquals(playbackException)) {
            return false;
        }
        int i3 = i9.g.f14378a;
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
        return this.type == exoPlaybackException.type && i9.g.a(this.rendererName, exoPlaybackException.rendererName) && this.rendererIndex == exoPlaybackException.rendererIndex && i9.g.a(this.rendererFormat, exoPlaybackException.rendererFormat) && this.rendererFormatSupport == exoPlaybackException.rendererFormatSupport && i9.g.a(this.mediaPeriodId, exoPlaybackException.mediaPeriodId) && this.isRecoverable == exoPlaybackException.isRecoverable;
    }

    public Exception getRendererException() {
        pc.b(this.type == 1);
        Throwable cause = getCause();
        cause.getClass();
        return (Exception) cause;
    }

    public IOException getSourceException() {
        pc.b(this.type == 0);
        Throwable cause = getCause();
        cause.getClass();
        return (IOException) cause;
    }

    public RuntimeException getUnexpectedException() {
        pc.b(this.type == 2);
        Throwable cause = getCause();
        cause.getClass();
        return (RuntimeException) cause;
    }

    @Override // com.google.android.exoplayer2.PlaybackException
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(PlaybackException.keyForField(1001), this.type);
        bundle.putString(PlaybackException.keyForField(1002), this.rendererName);
        bundle.putInt(PlaybackException.keyForField(1003), this.rendererIndex);
        bundle.putParcelable(PlaybackException.keyForField(1004), this.rendererFormat);
        bundle.putInt(PlaybackException.keyForField(1005), this.rendererFormatSupport);
        bundle.putBoolean(PlaybackException.keyForField(AMapException.CODE_AMAP_INVALID_USER_IP), this.isRecoverable);
        return bundle;
    }

    public ExoPlaybackException(String str, Throwable th2, int i3, int i10, String str2, int i11, Format format, int i12, x8.a aVar, long j4, boolean z5) {
        super(str, th2, i3, j4);
        pc.a(!z5 || i10 == 1);
        pc.a(th2 != null || i10 == 3);
        this.type = i10;
        this.rendererName = str2;
        this.rendererIndex = i11;
        this.rendererFormat = format;
        this.rendererFormatSupport = i12;
        this.mediaPeriodId = aVar;
        this.isRecoverable = z5;
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException, int i3) {
        return new ExoPlaybackException(2, runtimeException, i3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ExoPlaybackException(int r14, java.lang.Throwable r15, java.lang.String r16, int r17, java.lang.String r18, int r19, com.google.android.exoplayer2.Format r20, int r21, boolean r22) {
        /*
            r13 = this;
            r0 = r16
            r5 = r18
            r8 = r21
            r1 = 2
            if (r14 == 0) goto L73
            r2 = 3
            r3 = 1
            if (r14 == r3) goto L17
            if (r14 == r2) goto L14
            java.lang.String r2 = "Unexpected runtime error"
        L11:
            r3 = r19
            goto L77
        L14:
            java.lang.String r2 = "Remote error"
            goto L11
        L17:
            java.lang.String r4 = java.lang.String.valueOf(r20)
            java.util.UUID r6 = com.google.android.exoplayer2.b.f8843a
            if (r8 == 0) goto L3a
            if (r8 == r3) goto L37
            if (r8 == r1) goto L34
            if (r8 == r2) goto L31
            r2 = 4
            if (r8 != r2) goto L2b
            java.lang.String r2 = "YES"
            goto L3c
        L2b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            r14.<init>()
            throw r14
        L31:
            java.lang.String r2 = "NO_EXCEEDS_CAPABILITIES"
            goto L3c
        L34:
            java.lang.String r2 = "NO_UNSUPPORTED_DRM"
            goto L3c
        L37:
            java.lang.String r2 = "NO_UNSUPPORTED_TYPE"
            goto L3c
        L3a:
            java.lang.String r2 = "NO"
        L3c:
            r3 = 53
            int r3 = r5.a.a(r3, r5)
            int r6 = r4.length()
            int r6 = r6 + r3
            int r3 = r2.length()
            int r3 = r3 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            r6.append(r5)
            java.lang.String r3 = " error, index="
            r6.append(r3)
            r3 = r19
            r6.append(r3)
            java.lang.String r7 = ", format="
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = ", format_supported="
            r6.append(r4)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            goto L77
        L73:
            r3 = r19
            java.lang.String r2 = "Source error"
        L77:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L90
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            int r4 = r4 + r1
            int r1 = r5.a.a(r4, r0)
            java.lang.String r4 = ": "
            java.lang.String r2 = r5.a.b(r1, r2, r4, r0)
        L90:
            r1 = r2
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r4 = r14
            r2 = r15
            r7 = r20
            r12 = r22
            r6 = r3
            r3 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlaybackException.<init>(int, java.lang.Throwable, java.lang.String, int, java.lang.String, int, com.google.android.exoplayer2.Format, int, boolean):void");
    }
}
