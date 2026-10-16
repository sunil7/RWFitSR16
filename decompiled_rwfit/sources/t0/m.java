package t0;

import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.pf;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class m extends p {

    /* renamed from: g, reason: collision with root package name */
    public String f18456g;

    /* renamed from: h, reason: collision with root package name */
    public SparseArray f18457h;

    /* renamed from: i, reason: collision with root package name */
    public SparseArray f18458i;

    /* renamed from: j, reason: collision with root package name */
    public float[] f18459j;

    /* renamed from: k, reason: collision with root package name */
    public float[] f18460k;

    @Override // t0.p
    public final boolean b(float f2, long j4, View view, p0.e eVar) {
        this.f18462a.d(f2, this.f18459j);
        float[] fArr = this.f18459j;
        float f10 = fArr[fArr.length - 2];
        float f11 = fArr[fArr.length - 1];
        long j10 = j4 - this.e;
        if (Float.isNaN(this.f18466f)) {
            float c9 = eVar.c(view, this.f18456g);
            this.f18466f = c9;
            if (Float.isNaN(c9)) {
                this.f18466f = 0.0f;
            }
        }
        this.f18466f = (float) ((((j10 * 1.0E-9d) * f10) + this.f18466f) % 1.0d);
        this.e = j4;
        float sin = (float) Math.sin(r15 * 6.2831855f);
        this.f18465d = false;
        int i3 = 0;
        while (true) {
            float[] fArr2 = this.f18460k;
            if (i3 >= fArr2.length) {
                break;
            }
            boolean z5 = this.f18465d;
            float f12 = this.f18459j[i3];
            this.f18465d = z5 | (((double) f12) != 0.0d);
            fArr2[i3] = (f12 * sin) + f11;
            i3++;
        }
        ((w0.b) this.f18457h.valueAt(0)).g(view, this.f18460k);
        if (f10 != 0.0f) {
            this.f18465d = true;
        }
        return this.f18465d;
    }

    @Override // t0.p
    public final void c(int i3) {
        SparseArray sparseArray = this.f18457h;
        int size = sparseArray.size();
        int d5 = ((w0.b) sparseArray.valueAt(0)).d();
        double[] dArr = new double[size];
        int i10 = d5 + 2;
        this.f18459j = new float[i10];
        this.f18460k = new float[d5];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i10);
        for (int i11 = 0; i11 < size; i11++) {
            int keyAt = sparseArray.keyAt(i11);
            w0.b bVar = (w0.b) sparseArray.valueAt(i11);
            float[] fArr = (float[]) this.f18458i.valueAt(i11);
            dArr[i11] = keyAt * 0.01d;
            bVar.c(this.f18459j);
            int i12 = 0;
            while (true) {
                if (i12 < this.f18459j.length) {
                    dArr2[i11][i12] = r10[i12];
                    i12++;
                }
            }
            double[] dArr3 = dArr2[i11];
            dArr3[d5] = fArr[0];
            dArr3[d5 + 1] = fArr[1];
        }
        this.f18462a = pf.a(i3, dArr, dArr2);
    }
}
