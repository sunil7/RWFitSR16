package v7;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f19201a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f19202b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    public float f19203c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f19204d = 0.0f;
    public float e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f19205f = Float.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public float f19206g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f19207h = Float.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public float f19208i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f19209j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f19210k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public float f19211l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f19212m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public final Matrix f19213n = new Matrix();

    /* renamed from: o, reason: collision with root package name */
    public final float[] f19214o = new float[9];

    public final boolean a() {
        float f2 = this.f19208i;
        float f10 = this.f19206g;
        return f2 <= f10 && f10 <= 1.0f;
    }

    public final boolean b() {
        float f2 = this.f19209j;
        float f10 = this.e;
        return f2 <= f10 && f10 <= 1.0f;
    }

    public final boolean c(float f2) {
        return this.f19202b.bottom >= ((float) ((int) (f2 * 100.0f))) / 100.0f;
    }

    public final boolean d(float f2) {
        return this.f19202b.left <= f2 + 1.0f;
    }

    public final boolean e(float f2) {
        return this.f19202b.right >= (((float) ((int) (f2 * 100.0f))) / 100.0f) - 1.0f;
    }

    public final boolean f(float f2) {
        return this.f19202b.top <= f2;
    }

    public final boolean g(float f2) {
        return d(f2) && e(f2);
    }

    public final boolean h(float f2) {
        return f(f2) && c(f2);
    }

    public final void i(Matrix matrix, RectF rectF) {
        float f2;
        float f10;
        float[] fArr = this.f19214o;
        matrix.getValues(fArr);
        float f11 = fArr[2];
        float f12 = fArr[0];
        float f13 = fArr[5];
        float f14 = fArr[4];
        this.f19208i = Math.min(Math.max(this.f19206g, f12), this.f19207h);
        this.f19209j = Math.min(Math.max(this.e, f14), this.f19205f);
        if (rectF != null) {
            f2 = rectF.width();
            f10 = rectF.height();
        } else {
            f2 = 0.0f;
            f10 = 0.0f;
        }
        this.f19210k = Math.min(Math.max(f11, ((this.f19208i - 1.0f) * (-f2)) - this.f19211l), this.f19211l);
        float max = Math.max(Math.min(f13, ((this.f19209j - 1.0f) * f10) + this.f19212m), -this.f19212m);
        fArr[2] = this.f19210k;
        fArr[0] = this.f19208i;
        fArr[5] = max;
        fArr[4] = this.f19209j;
        matrix.setValues(fArr);
    }

    public final float j() {
        return this.f19204d - this.f19202b.bottom;
    }

    public final void k(Matrix matrix, View view, boolean z5) {
        Matrix matrix2 = this.f19201a;
        matrix2.set(matrix);
        i(matrix2, this.f19202b);
        if (z5) {
            view.invalidate();
        }
        matrix.set(matrix2);
    }

    public final void l(float f2, float f10, float f11, float f12) {
        this.f19202b.set(f2, f10, this.f19203c - f11, this.f19204d - f12);
    }
}
