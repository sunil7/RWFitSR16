package j2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i extends f0 {

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f15227x = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: y, reason: collision with root package name */
    public static final g f15228y = new g();

    /* renamed from: z, reason: collision with root package name */
    public static final ab.g f15229z = new ab.g(11, Matrix.class, "animatedTransform");

    public static void I(m0 m0Var) {
        Matrix matrix;
        View view = m0Var.f15264b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            HashMap hashMap = m0Var.f15263a;
            hashMap.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            Drawable drawable = imageView.getDrawable();
            if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                matrix = new Matrix(imageView.getImageMatrix());
            } else {
                int i3 = h.f15224a[imageView.getScaleType().ordinal()];
                if (i3 == 1) {
                    Drawable drawable2 = imageView.getDrawable();
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(imageView.getWidth() / drawable2.getIntrinsicWidth(), imageView.getHeight() / drawable2.getIntrinsicHeight());
                    matrix = matrix2;
                } else if (i3 != 2) {
                    matrix = new Matrix(imageView.getImageMatrix());
                } else {
                    Drawable drawable3 = imageView.getDrawable();
                    int intrinsicWidth = drawable3.getIntrinsicWidth();
                    float width = imageView.getWidth();
                    float f2 = intrinsicWidth;
                    int intrinsicHeight = drawable3.getIntrinsicHeight();
                    float height = imageView.getHeight();
                    float f10 = intrinsicHeight;
                    float max = Math.max(width / f2, height / f10);
                    int round = Math.round((width - (f2 * max)) / 2.0f);
                    int round2 = Math.round((height - (f10 * max)) / 2.0f);
                    Matrix matrix3 = new Matrix();
                    matrix3.postScale(max, max);
                    matrix3.postTranslate(round, round2);
                    matrix = matrix3;
                }
            }
            hashMap.put("android:changeImageTransform:matrix", matrix);
        }
    }

    @Override // j2.f0
    public final void d(m0 m0Var) {
        I(m0Var);
    }

    @Override // j2.f0
    public final void g(m0 m0Var) {
        I(m0Var);
    }

    @Override // j2.f0
    public final Animator k(ViewGroup viewGroup, m0 m0Var, m0 m0Var2) {
        if (m0Var == null || m0Var2 == null) {
            return null;
        }
        HashMap hashMap = m0Var.f15263a;
        Rect rect = (Rect) hashMap.get("android:changeImageTransform:bounds");
        HashMap hashMap2 = m0Var2.f15263a;
        Rect rect2 = (Rect) hashMap2.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) hashMap.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) hashMap2.get("android:changeImageTransform:matrix");
        boolean z5 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z5) {
            return null;
        }
        ImageView imageView = (ImageView) m0Var2.f15264b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        ab.g gVar = f15229z;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            g gVar2 = f15228y;
            a0 a0Var = b0.f15184a;
            return ObjectAnimator.ofObject(imageView, gVar, gVar2, a0Var, a0Var);
        }
        if (matrix == null) {
            matrix = b0.f15184a;
        }
        if (matrix2 == null) {
            matrix2 = b0.f15184a;
        }
        gVar.set(imageView, matrix);
        return ObjectAnimator.ofObject(imageView, gVar, new k0(), matrix, matrix2);
    }

    @Override // j2.f0
    public final String[] q() {
        return f15227x;
    }
}
