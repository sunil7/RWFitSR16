package v0;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f19116a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    public final ColorMatrix f19117b = new ColorMatrix();

    /* renamed from: c, reason: collision with root package name */
    public final ColorMatrix f19118c = new ColorMatrix();

    /* renamed from: d, reason: collision with root package name */
    public float f19119d = 1.0f;
    public float e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f19120f = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    public float f19121g = 1.0f;

    public final void a(ImageView imageView) {
        boolean z5;
        float f2;
        char c9;
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        float f10;
        char c15;
        float log;
        float f11;
        char c16;
        float f12;
        float f13;
        ColorMatrix colorMatrix = this.f19117b;
        colorMatrix.reset();
        float f14 = this.e;
        float[] fArr = this.f19116a;
        boolean z6 = true;
        if (f14 != 1.0f) {
            float f15 = 1.0f - f14;
            float f16 = 0.2999f * f15;
            float f17 = 0.587f * f15;
            float f18 = f15 * 0.114f;
            fArr[0] = f16 + f14;
            fArr[1] = f17;
            fArr[2] = f18;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f16;
            fArr[6] = f17 + f14;
            fArr[7] = f18;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f16;
            fArr[11] = f17;
            fArr[12] = f18 + f14;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
            colorMatrix.set(fArr);
            z5 = true;
        } else {
            z5 = false;
        }
        float f19 = this.f19120f;
        ColorMatrix colorMatrix2 = this.f19118c;
        if (f19 != 1.0f) {
            colorMatrix2.setScale(f19, f19, f19, 1.0f);
            colorMatrix.postConcat(colorMatrix2);
            z5 = true;
        }
        float f20 = this.f19121g;
        if (f20 != 1.0f) {
            if (f20 <= 0.0f) {
                f20 = 0.01f;
            }
            float f21 = (5000.0f / f20) / 100.0f;
            f2 = 1.0f;
            if (f21 > 66.0f) {
                f10 = 66.0f;
                c9 = 17;
                c10 = 16;
                double d5 = f21 - 60.0f;
                c11 = 15;
                c12 = 14;
                f11 = ((float) Math.pow(d5, -0.13320475816726685d)) * 329.69873f;
                c15 = '\r';
                c14 = '\f';
                log = ((float) Math.pow(d5, 0.07551484555006027d)) * 288.12216f;
            } else {
                f10 = 66.0f;
                c9 = 17;
                c10 = 16;
                c11 = 15;
                c12 = 14;
                c15 = '\r';
                c14 = '\f';
                log = (((float) Math.log(f21)) * 99.4708f) - 161.11957f;
                f11 = 255.0f;
            }
            if (f21 >= f10) {
                c16 = c15;
                f12 = 305.0448f;
                f13 = 255.0f;
            } else if (f21 > 19.0f) {
                c16 = c15;
                f12 = 305.0448f;
                f13 = (((float) Math.log(f21 - 10.0f)) * 138.51773f) - 305.0448f;
            } else {
                c16 = c15;
                f12 = 305.0448f;
                f13 = 0.0f;
            }
            float min = Math.min(255.0f, Math.max(f11, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f13, 0.0f));
            float log2 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            c13 = c16;
            float log3 = (((float) Math.log(40.0f)) * 138.51773f) - f12;
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max(log2, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max(log3, 0.0f));
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[c14] = min6;
            fArr[c13] = 0.0f;
            fArr[c12] = 0.0f;
            fArr[c11] = 0.0f;
            fArr[c10] = 0.0f;
            fArr[c9] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
            colorMatrix2.set(fArr);
            colorMatrix.postConcat(colorMatrix2);
            z5 = true;
        } else {
            f2 = 1.0f;
            c9 = 17;
            c10 = 16;
            c11 = 15;
            c12 = 14;
            c13 = '\r';
            c14 = '\f';
        }
        float f22 = this.f19119d;
        if (f22 != f2) {
            fArr[0] = f22;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f22;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[c14] = f22;
            fArr[c13] = 0.0f;
            fArr[c12] = 0.0f;
            fArr[c11] = 0.0f;
            fArr[c10] = 0.0f;
            fArr[c9] = 0.0f;
            fArr[18] = f2;
            fArr[19] = 0.0f;
            colorMatrix2.set(fArr);
            colorMatrix.postConcat(colorMatrix2);
        } else {
            z6 = z5;
        }
        if (z6) {
            imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        } else {
            imageView.clearColorFilter();
        }
    }
}
