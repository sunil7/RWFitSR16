package t0;

import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.pf;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: f, reason: collision with root package name */
    public SparseArray f18448f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f18449g;

    @Override // t0.k
    public final void b(float f2, int i3) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }

    @Override // t0.k
    public final void c(View view, float f2) {
        this.f18451a.d(f2, this.f18449g);
        ((w0.b) this.f18448f.valueAt(0)).g(view, this.f18449g);
    }

    @Override // t0.k
    public final void d(int i3) {
        SparseArray sparseArray = this.f18448f;
        int size = sparseArray.size();
        int d5 = ((w0.b) sparseArray.valueAt(0)).d();
        double[] dArr = new double[size];
        this.f18449g = new float[d5];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, d5);
        for (int i10 = 0; i10 < size; i10++) {
            int keyAt = sparseArray.keyAt(i10);
            w0.b bVar = (w0.b) sparseArray.valueAt(i10);
            dArr[i10] = keyAt * 0.01d;
            bVar.c(this.f18449g);
            int i11 = 0;
            while (true) {
                if (i11 < this.f18449g.length) {
                    dArr2[i10][i11] = r7[i11];
                    i11++;
                }
            }
        }
        this.f18451a = pf.a(i3, dArr, dArr2);
    }
}
