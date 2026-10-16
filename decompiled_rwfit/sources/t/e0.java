package t;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class e0 implements androidx.camera.core.impl.q0 {

    /* renamed from: a, reason: collision with root package name */
    public af.a f18300a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f18301b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f18302c;
    public volatile boolean e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f18304f;

    /* renamed from: g, reason: collision with root package name */
    public Executor f18305g;

    /* renamed from: h, reason: collision with root package name */
    public z0 f18306h;

    /* renamed from: i, reason: collision with root package name */
    public ImageWriter f18307i;

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f18312n;

    /* renamed from: o, reason: collision with root package name */
    public ByteBuffer f18313o;

    /* renamed from: p, reason: collision with root package name */
    public ByteBuffer f18314p;

    /* renamed from: q, reason: collision with root package name */
    public ByteBuffer f18315q;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f18303d = 1;

    /* renamed from: j, reason: collision with root package name */
    public Rect f18308j = new Rect();

    /* renamed from: k, reason: collision with root package name */
    public Rect f18309k = new Rect();

    /* renamed from: l, reason: collision with root package name */
    public Matrix f18310l = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    public Matrix f18311m = new Matrix();
    public final Object r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public boolean f18316s = true;

    public abstract p0 a(androidx.camera.core.impl.r0 r0Var);

    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ob.a b(final t.p0 r17) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.e0.b(t.p0):ob.a");
    }

    @Override // androidx.camera.core.impl.q0
    public final void c(androidx.camera.core.impl.r0 r0Var) {
        try {
            p0 a3 = a(r0Var);
            if (a3 != null) {
                f(a3);
            }
        } catch (IllegalStateException e) {
            com.google.android.gms.internal.mlkit_vision_common.a0.c("ImageAnalysisAnalyzer", "Failed to acquire image.", e);
        }
    }

    public abstract void d();

    public final void e(p0 p0Var) {
        if (this.f18303d != 1) {
            if (this.f18303d == 2 && this.f18312n == null) {
                this.f18312n = ByteBuffer.allocateDirect(p0Var.getHeight() * p0Var.getWidth() * 4);
                return;
            }
            return;
        }
        if (this.f18313o == null) {
            this.f18313o = ByteBuffer.allocateDirect(p0Var.getHeight() * p0Var.getWidth());
        }
        this.f18313o.position(0);
        if (this.f18314p == null) {
            this.f18314p = ByteBuffer.allocateDirect((p0Var.getHeight() * p0Var.getWidth()) / 4);
        }
        this.f18314p.position(0);
        if (this.f18315q == null) {
            this.f18315q = ByteBuffer.allocateDirect((p0Var.getHeight() * p0Var.getWidth()) / 4);
        }
        this.f18315q.position(0);
    }

    public abstract void f(p0 p0Var);

    public final void g(int i3, int i10, int i11, int i12) {
        int i13 = this.f18301b;
        Matrix matrix = new Matrix();
        if (i13 > 0) {
            RectF rectF = new RectF(0.0f, 0.0f, i3, i10);
            RectF rectF2 = v.d.f19111a;
            Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            matrix.postRotate(i13);
            RectF rectF3 = new RectF(0.0f, 0.0f, i11, i12);
            Matrix matrix2 = new Matrix();
            matrix2.setRectToRect(rectF2, rectF3, scaleToFit);
            matrix.postConcat(matrix2);
        }
        RectF rectF4 = new RectF(this.f18308j);
        matrix.mapRect(rectF4);
        Rect rect = new Rect();
        rectF4.round(rect);
        this.f18309k = rect;
        this.f18311m.setConcat(this.f18310l, matrix);
    }

    public final void h(p0 p0Var, int i3) {
        z0 z0Var = this.f18306h;
        if (z0Var == null) {
            return;
        }
        z0Var.a();
        int width = p0Var.getWidth();
        int height = p0Var.getHeight();
        int m10 = this.f18306h.m();
        int q5 = this.f18306h.q();
        boolean z5 = i3 == 90 || i3 == 270;
        int i10 = z5 ? height : width;
        if (!z5) {
            width = height;
        }
        this.f18306h = new z0(com.google.android.gms.internal.mlkit_vision_common.z.a(i10, width, m10, q5));
        if (this.f18303d == 1) {
            ImageWriter imageWriter = this.f18307i;
            if (imageWriter != null) {
                imageWriter.close();
            }
            this.f18307i = ImageWriter.newInstance(this.f18306h.e(), this.f18306h.q());
        }
    }
}
