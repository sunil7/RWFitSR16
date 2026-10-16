package j2;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class q0 extends p0 {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ld
    public final float a(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.ld
    public final void b(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // j2.p0, com.google.android.gms.internal.mlkit_vision_barcode.ld
    public final void c(int i3, View view) {
        view.setTransitionVisibility(i3);
    }

    @Override // j2.p0
    public final void d(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // j2.p0
    public final void e(View view, int i3, int i10, int i11, int i12) {
        view.setLeftTopRightBottom(i3, i10, i11, i12);
    }

    @Override // j2.p0
    public final void f(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // j2.p0
    public final void g(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
