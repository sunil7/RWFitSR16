package androidx.camera.core.impl;

import android.util.Size;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final SurfaceConfig$ConfigType f1416a;

    /* renamed from: b, reason: collision with root package name */
    public final SurfaceConfig$ConfigSize f1417b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1418c;

    public i(SurfaceConfig$ConfigType surfaceConfig$ConfigType, SurfaceConfig$ConfigSize surfaceConfig$ConfigSize, long j4) {
        if (surfaceConfig$ConfigType == null) {
            throw new NullPointerException("Null configType");
        }
        this.f1416a = surfaceConfig$ConfigType;
        if (surfaceConfig$ConfigSize == null) {
            throw new NullPointerException("Null configSize");
        }
        this.f1417b = surfaceConfig$ConfigSize;
        this.f1418c = j4;
    }

    public static i a(SurfaceConfig$ConfigType surfaceConfig$ConfigType, SurfaceConfig$ConfigSize surfaceConfig$ConfigSize) {
        return new i(surfaceConfig$ConfigType, surfaceConfig$ConfigSize, 0L);
    }

    public static SurfaceConfig$ConfigType b(int i3) {
        return i3 == 35 ? SurfaceConfig$ConfigType.YUV : i3 == 256 ? SurfaceConfig$ConfigType.JPEG : i3 == 4101 ? SurfaceConfig$ConfigType.JPEG_R : i3 == 32 ? SurfaceConfig$ConfigType.RAW : SurfaceConfig$ConfigType.PRIV;
    }

    public static i c(int i3, int i10, Size size, j jVar) {
        SurfaceConfig$ConfigType b3 = b(i10);
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.NOT_SUPPORT;
        int a3 = b0.a.a(size);
        if (i3 == 1) {
            if (a3 <= b0.a.a((Size) jVar.f1423b.get(Integer.valueOf(i10)))) {
                surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.s720p;
            } else {
                if (a3 <= b0.a.a((Size) jVar.f1425d.get(Integer.valueOf(i10)))) {
                    surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.s1440p;
                }
            }
        } else if (a3 <= b0.a.a(jVar.f1422a)) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.VGA;
        } else if (a3 <= b0.a.a(jVar.f1424c)) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.PREVIEW;
        } else if (a3 <= b0.a.a(jVar.e)) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.RECORD;
        } else {
            if (a3 <= b0.a.a((Size) jVar.f1426f.get(Integer.valueOf(i10)))) {
                surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.MAXIMUM;
            } else {
                Size size2 = (Size) jVar.f1427g.get(Integer.valueOf(i10));
                if (size2 != null) {
                    if (a3 <= size2.getHeight() * size2.getWidth()) {
                        surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.ULTRA_MAXIMUM;
                    }
                }
            }
        }
        return a(b3, surfaceConfig$ConfigSize);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f1416a.equals(iVar.f1416a) && this.f1417b.equals(iVar.f1417b) && this.f1418c == iVar.f1418c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.f1416a.hashCode() ^ 1000003) * 1000003) ^ this.f1417b.hashCode()) * 1000003;
        long j4 = this.f1418c;
        return hashCode ^ ((int) ((j4 >>> 32) ^ j4));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SurfaceConfig{configType=");
        sb2.append(this.f1416a);
        sb2.append(", configSize=");
        sb2.append(this.f1417b);
        sb2.append(", streamUseCase=");
        return android.support.v4.media.session.e.n(sb2, this.f1418c, "}");
    }
}
