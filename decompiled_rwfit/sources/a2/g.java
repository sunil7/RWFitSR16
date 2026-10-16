package a2;

import android.opengl.Matrix;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.encoder.MinimalEncoder$VersionSize;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f32a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f33b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f34c;

    /* renamed from: d, reason: collision with root package name */
    public Object f35d;

    public g(int i3) {
        switch (i3) {
            case 3:
                this.f33b = new float[16];
                this.f34c = new float[16];
                this.f35d = new i9.f();
                break;
            default:
                this.f34c = new Object();
                this.f33b = new ArrayDeque();
                this.f35d = new AtomicReference();
                break;
        }
    }

    public static void b(ld.d[][][] dVarArr, int i3, ld.d dVar) {
        ld.d[] dVarArr2 = dVarArr[i3 + dVar.f15863d][dVar.f15862c];
        Mode mode = dVar.f15860a;
        char c9 = 0;
        if (mode != null) {
            int i10 = com.google.zxing.qrcode.encoder.b.f11277b[mode.ordinal()];
            char c10 = 1;
            if (i10 != 1) {
                c9 = 2;
                if (i10 != 2) {
                    c10 = 3;
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new IllegalStateException("Illegal mode " + mode);
                        }
                    }
                }
                c9 = c10;
            }
        }
        ld.d dVar2 = dVarArr2[c9];
        if (dVar2 != null) {
            if (dVar2.f15864f <= dVar.f15864f) {
                return;
            }
        }
        dVarArr2[c9] = dVar;
    }

    public static boolean d(Mode mode, char c9) {
        int i3;
        int i10 = com.google.zxing.qrcode.encoder.b.f11277b[mode.ordinal()];
        if (i10 == 1) {
            return com.google.zxing.qrcode.encoder.a.c(String.valueOf(c9));
        }
        if (i10 == 2) {
            if (c9 < '`') {
                i3 = com.google.zxing.qrcode.encoder.a.f11274a[c9];
            } else {
                int[] iArr = com.google.zxing.qrcode.encoder.a.f11274a;
                i3 = -1;
            }
            if (i3 == -1) {
                return false;
            }
        } else if (i10 != 3) {
            if (i10 != 4) {
                return false;
            }
        } else if (c9 < '0' || c9 > '9') {
            return false;
        }
        return true;
    }

    public static void e(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f2 = fArr2[10];
        float f10 = fArr2[8];
        float sqrt = (float) Math.sqrt((f10 * f10) + (f2 * f2));
        float f11 = fArr2[10] / sqrt;
        fArr[0] = f11;
        float f12 = fArr2[8];
        fArr[2] = f12 / sqrt;
        fArr[8] = (-f12) / sqrt;
        fArr[10] = f11;
    }

    public static jd.f i(MinimalEncoder$VersionSize minimalEncoder$VersionSize) {
        int i3 = com.google.zxing.qrcode.encoder.b.f11276a[minimalEncoder$VersionSize.ordinal()];
        return i3 != 1 ? i3 != 2 ? jd.f.c(40) : jd.f.c(26) : jd.f.c(9);
    }

    public void a() {
        v3.c.b((v3.c) this.f35d, this, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(jd.f r13, ld.d[][][] r14, int r15, ld.d r16) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.g.c(jd.f, ld.d[][][], int, ld.d):void");
    }

    public void f(j jVar) {
        w.a aVar;
        synchronized (this.f34c) {
            if (this.f32a) {
                throw new IllegalStateException("callback.onResult already called, cannot call again.");
            }
            this.f32a = true;
            aVar = (w.a) this.f35d;
        }
        if (aVar != null) {
            aVar.execute(new x.h(this, 2, jVar, false));
        } else {
            ((d) this.f33b).o(jVar);
        }
    }

    public com.google.zxing.qrcode.encoder.c g(jd.f fVar) {
        CharsetEncoder[] charsetEncoderArr;
        int i3;
        String str = (String) this.f33b;
        int length = str.length();
        sc.e eVar = (sc.e) this.f34c;
        int i10 = 1;
        ld.d[][][] dVarArr = (ld.d[][][]) Array.newInstance((Class<?>) ld.d.class, length + 1, eVar.f18238a.length, 4);
        c(fVar, dVarArr, 0, null);
        while (true) {
            charsetEncoderArr = eVar.f18238a;
            if (i10 > length) {
                break;
            }
            for (int i11 = 0; i11 < charsetEncoderArr.length; i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    ld.d dVar = dVarArr[i10][i11][i12];
                    if (dVar != null && i10 < length) {
                        c(fVar, dVarArr, i10, dVar);
                    }
                }
            }
            i10++;
        }
        int i13 = -1;
        int i14 = Integer.MAX_VALUE;
        int i15 = -1;
        for (int i16 = 0; i16 < charsetEncoderArr.length; i16++) {
            for (int i17 = 0; i17 < 4; i17++) {
                ld.d dVar2 = dVarArr[length][i16][i17];
                if (dVar2 != null && (i3 = dVar2.f15864f) < i14) {
                    i13 = i16;
                    i15 = i17;
                    i14 = i3;
                }
            }
        }
        if (i13 >= 0) {
            return new com.google.zxing.qrcode.encoder.c(this, fVar, dVarArr[length][i13][i15]);
        }
        throw new WriterException(l0.o("Internal error: failed to encode \"", str, "\""));
    }

    public File h() {
        File file;
        synchronized (((v3.c) this.f35d)) {
            try {
                v3.b bVar = (v3.b) this.f33b;
                if (bVar.f19154f != this) {
                    throw new IllegalStateException();
                }
                if (!bVar.e) {
                    ((boolean[]) this.f34c)[0] = true;
                }
                file = bVar.f19153d[0];
                ((v3.c) this.f35d).f19156a.mkdirs();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return file;
    }

    public void j(Runnable runnable, Executor executor) {
        synchronized (this.f34c) {
            try {
                if (this.f32a) {
                    ((ArrayDeque) this.f33b).add(new gc.l(runnable, executor));
                } else {
                    this.f32a = true;
                    l(runnable, executor);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void k() {
        synchronized (this.f34c) {
            try {
                if (((ArrayDeque) this.f33b).isEmpty()) {
                    this.f32a = false;
                    return;
                }
                gc.l lVar = (gc.l) ((ArrayDeque) this.f33b).remove();
                l(lVar.f14049b, lVar.f14048a);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void l(Runnable runnable, Executor executor) {
        try {
            executor.execute(new x.h(24, this, runnable));
        } catch (RejectedExecutionException unused) {
            k();
        }
    }

    public g(String str, Charset charset, boolean z5, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f33b = str;
        this.f32a = z5;
        this.f34c = new sc.e(str, charset);
        this.f35d = errorCorrectionLevel;
    }

    public g(h5.b bVar, d dVar) {
        this.f34c = new Object();
        this.f32a = false;
        this.f35d = null;
        this.f33b = dVar;
    }

    public g(v3.c cVar, v3.b bVar) {
        this.f35d = cVar;
        this.f33b = bVar;
        this.f34c = bVar.e ? null : new boolean[cVar.f19161g];
    }
}
