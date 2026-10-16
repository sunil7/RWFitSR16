package p0;

import com.google.android.gms.internal.mlkit_vision_barcode.pf;

/* loaded from: classes.dex */
public final class c extends pf {

    /* renamed from: a, reason: collision with root package name */
    public double f17306a;

    /* renamed from: b, reason: collision with root package name */
    public double[] f17307b;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double b(double d5) {
        return this.f17307b[0];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void c(double d5, double[] dArr) {
        double[] dArr2 = this.f17307b;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void d(double d5, float[] fArr) {
        int i3 = 0;
        while (true) {
            double[] dArr = this.f17307b;
            if (i3 >= dArr.length) {
                return;
            }
            fArr[i3] = (float) dArr[i3];
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double e(double d5) {
        return 0.0d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void f(double d5, double[] dArr) {
        for (int i3 = 0; i3 < this.f17307b.length; i3++) {
            dArr[i3] = 0.0d;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double[] g() {
        return new double[]{this.f17306a};
    }
}
