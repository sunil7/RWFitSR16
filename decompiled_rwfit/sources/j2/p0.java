package j2;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.ld;

/* loaded from: classes.dex */
public class p0 extends ld {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f15276d = true;
    public static boolean e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f15277f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f15278g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f15279h = true;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ld
    public void c(int i3, View view) {
        if (Build.VERSION.SDK_INT == 28) {
            super.c(i3, view);
        } else if (f15279h) {
            try {
                view.setTransitionVisibility(i3);
            } catch (NoSuchMethodError unused) {
                f15279h = false;
            }
        }
    }

    public void d(View view, Matrix matrix) {
        if (f15276d) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f15276d = false;
            }
        }
    }

    public void e(View view, int i3, int i10, int i11, int i12) {
        if (f15278g) {
            try {
                view.setLeftTopRightBottom(i3, i10, i11, i12);
            } catch (NoSuchMethodError unused) {
                f15278g = false;
            }
        }
    }

    public void f(View view, Matrix matrix) {
        if (e) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
    }

    public void g(View view, Matrix matrix) {
        if (f15277f) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f15277f = false;
            }
        }
    }
}
