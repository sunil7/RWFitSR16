package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.view.PreviewView;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.j0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: i, reason: collision with root package name */
    public static final PreviewView.ScaleType f1589i = PreviewView.ScaleType.FILL_CENTER;

    /* renamed from: a, reason: collision with root package name */
    public Size f1590a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f1591b;

    /* renamed from: c, reason: collision with root package name */
    public int f1592c;

    /* renamed from: d, reason: collision with root package name */
    public Matrix f1593d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1594f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1595g;

    /* renamed from: h, reason: collision with root package name */
    public PreviewView.ScaleType f1596h;

    public final Matrix a(int i3, Rect rect, Size size) {
        Matrix matrix = null;
        if (!f()) {
            return null;
        }
        Matrix matrix2 = new Matrix();
        if (f()) {
            matrix = new Matrix(this.f1593d);
            matrix.postConcat(c(size, i3));
        }
        matrix.invert(matrix2);
        Matrix matrix3 = new Matrix();
        matrix3.setRectToRect(new RectF(0.0f, 0.0f, rect.width(), rect.height()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix2.postConcat(matrix3);
        return matrix2;
    }

    public final Size b() {
        return v.d.b(this.f1592c) ? new Size(this.f1591b.height(), this.f1591b.width()) : new Size(this.f1591b.width(), this.f1591b.height());
    }

    public final Matrix c(Size size, int i3) {
        Matrix.ScaleToFit scaleToFit;
        RectF rectF;
        pd.f(null, f());
        if (v.d.c(size, true, b())) {
            rectF = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        } else {
            RectF rectF2 = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
            Size b3 = b();
            RectF rectF3 = new RectF(0.0f, 0.0f, b3.getWidth(), b3.getHeight());
            Matrix matrix = new Matrix();
            PreviewView.ScaleType scaleType = this.f1596h;
            switch (b.f1588a[scaleType.ordinal()]) {
                case 1:
                case 2:
                    scaleToFit = Matrix.ScaleToFit.CENTER;
                    break;
                case 3:
                case 4:
                    scaleToFit = Matrix.ScaleToFit.END;
                    break;
                case 5:
                case 6:
                    scaleToFit = Matrix.ScaleToFit.START;
                    break;
                default:
                    a0.b("PreviewTransform", "Unexpected crop rect: " + scaleType);
                    scaleToFit = Matrix.ScaleToFit.FILL;
                    break;
            }
            if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
                matrix.setRectToRect(rectF3, rectF2, scaleToFit);
            } else {
                matrix.setRectToRect(rectF2, rectF3, scaleToFit);
                matrix.invert(matrix);
            }
            matrix.mapRect(rectF3);
            if (i3 == 1) {
                float width = size.getWidth() / 2.0f;
                float f2 = width + width;
                rectF = new RectF(f2 - rectF3.right, rectF3.top, f2 - rectF3.left, rectF3.bottom);
            } else {
                rectF = rectF3;
            }
        }
        Matrix a3 = v.d.a(new RectF(this.f1591b), rectF, this.f1592c, false);
        if (this.f1594f && this.f1595g) {
            if (v.d.b(this.f1592c)) {
                a3.preScale(1.0f, -1.0f, this.f1591b.centerX(), this.f1591b.centerY());
                return a3;
            }
            a3.preScale(-1.0f, 1.0f, this.f1591b.centerX(), this.f1591b.centerY());
        }
        return a3;
    }

    public final Matrix d() {
        pd.f(null, f());
        RectF rectF = new RectF(0.0f, 0.0f, this.f1590a.getWidth(), this.f1590a.getHeight());
        return v.d.a(rectF, rectF, !this.f1595g ? this.f1592c : -j0.b(this.e), false);
    }

    public final RectF e(Size size, int i3) {
        pd.f(null, f());
        Matrix c9 = c(size, i3);
        RectF rectF = new RectF(0.0f, 0.0f, this.f1590a.getWidth(), this.f1590a.getHeight());
        c9.mapRect(rectF);
        return rectF;
    }

    public final boolean f() {
        return (this.f1591b == null || this.f1590a == null || !(!this.f1595g || this.e != -1)) ? false : true;
    }
}
