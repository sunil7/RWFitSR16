package v;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final RectF f19111a = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    public static Matrix a(RectF rectF, RectF rectF2, int i3, boolean z5) {
        Matrix matrix = new Matrix();
        RectF rectF3 = f19111a;
        Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
        matrix.setRectToRect(rectF, rectF3, scaleToFit);
        matrix.postRotate(i3);
        if (z5) {
            matrix.postScale(-1.0f, 1.0f);
        }
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF3, rectF2, scaleToFit);
        matrix.postConcat(matrix2);
        return matrix;
    }

    public static boolean b(int i3) {
        if (i3 == 90 || i3 == 270) {
            return true;
        }
        if (i3 == 0 || i3 == 180) {
            return false;
        }
        throw new IllegalArgumentException(l0.j(i3, "Invalid rotation degrees: "));
    }

    public static boolean c(Size size, boolean z5, Size size2) {
        float width;
        float width2;
        if (z5) {
            width = size.getWidth() / size.getHeight();
            width2 = width;
        } else {
            width = (size.getWidth() + 1.0f) / (size.getHeight() - 1.0f);
            width2 = (size.getWidth() - 1.0f) / (size.getHeight() + 1.0f);
        }
        return width >= (((float) size2.getWidth()) - 1.0f) / (((float) size2.getHeight()) + 1.0f) && (((float) size2.getWidth()) + 1.0f) / (((float) size2.getHeight()) - 1.0f) >= width2;
    }

    public static Size d(Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    public static Size e(Size size, int i3) {
        pd.a("Invalid rotation degrees: " + i3, i3 % 90 == 0);
        return b(f(i3)) ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    public static int f(int i3) {
        return ((i3 % 360) + 360) % 360;
    }
}
