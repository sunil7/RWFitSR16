package p0;

import com.google.android.gms.internal.mlkit_vision_barcode.pf;

/* loaded from: classes.dex */
public final class b extends pf {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f17304a;

    /* renamed from: b, reason: collision with root package name */
    public final a[] f17305b;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r5 == r3) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, p0.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(int[] r29, double[] r30, double[][] r31) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.b.<init>(int[], double[], double[][]):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double b(double d5) {
        a[] aVarArr = this.f17305b;
        a aVar = aVarArr[0];
        double d8 = aVar.f17290c;
        if (d5 < d8) {
            double d10 = d5 - d8;
            if (aVar.r) {
                return (d10 * aVarArr[0].f17298l) + aVar.c(d8);
            }
            aVar.g(d8);
            return (aVarArr[0].a() * d10) + aVarArr[0].e();
        }
        if (d5 > aVarArr[aVarArr.length - 1].f17291d) {
            double d11 = aVarArr[aVarArr.length - 1].f17291d;
            double d12 = d5 - d11;
            int length = aVarArr.length - 1;
            return (d12 * aVarArr[length].f17298l) + aVarArr[length].c(d11);
        }
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            a aVar2 = aVarArr[i3];
            if (d5 <= aVar2.f17291d) {
                if (aVar2.r) {
                    return aVar2.c(d5);
                }
                aVar2.g(d5);
                return aVarArr[i3].e();
            }
        }
        return Double.NaN;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void c(double d5, double[] dArr) {
        a[] aVarArr = this.f17305b;
        a aVar = aVarArr[0];
        double d8 = aVar.f17290c;
        if (d5 < d8) {
            double d10 = d5 - d8;
            if (aVar.r) {
                double c9 = aVar.c(d8);
                a aVar2 = aVarArr[0];
                dArr[0] = (aVar2.f17298l * d10) + c9;
                dArr[1] = (d10 * aVarArr[0].f17299m) + aVar2.d(d8);
                return;
            }
            aVar.g(d8);
            dArr[0] = (aVarArr[0].a() * d10) + aVarArr[0].e();
            dArr[1] = (aVarArr[0].b() * d10) + aVarArr[0].f();
            return;
        }
        if (d5 <= aVarArr[aVarArr.length - 1].f17291d) {
            for (int i3 = 0; i3 < aVarArr.length; i3++) {
                a aVar3 = aVarArr[i3];
                if (d5 <= aVar3.f17291d) {
                    if (aVar3.r) {
                        dArr[0] = aVar3.c(d5);
                        dArr[1] = aVarArr[i3].d(d5);
                        return;
                    } else {
                        aVar3.g(d5);
                        dArr[0] = aVarArr[i3].e();
                        dArr[1] = aVarArr[i3].f();
                        return;
                    }
                }
            }
            return;
        }
        double d11 = aVarArr[aVarArr.length - 1].f17291d;
        double d12 = d5 - d11;
        int length = aVarArr.length - 1;
        a aVar4 = aVarArr[length];
        if (aVar4.r) {
            double c10 = aVar4.c(d11);
            a aVar5 = aVarArr[length];
            dArr[0] = (aVar5.f17298l * d12) + c10;
            dArr[1] = (d12 * aVarArr[length].f17299m) + aVar5.d(d11);
            return;
        }
        aVar4.g(d5);
        dArr[0] = (aVarArr[length].a() * d12) + aVarArr[length].e();
        dArr[1] = (aVarArr[length].b() * d12) + aVarArr[length].f();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void d(double d5, float[] fArr) {
        a[] aVarArr = this.f17305b;
        a aVar = aVarArr[0];
        double d8 = aVar.f17290c;
        if (d5 < d8) {
            double d10 = d5 - d8;
            if (aVar.r) {
                double c9 = aVar.c(d8);
                a aVar2 = aVarArr[0];
                fArr[0] = (float) ((aVar2.f17298l * d10) + c9);
                fArr[1] = (float) ((d10 * aVarArr[0].f17299m) + aVar2.d(d8));
                return;
            }
            aVar.g(d8);
            fArr[0] = (float) ((aVarArr[0].a() * d10) + aVarArr[0].e());
            fArr[1] = (float) ((aVarArr[0].b() * d10) + aVarArr[0].f());
            return;
        }
        if (d5 <= aVarArr[aVarArr.length - 1].f17291d) {
            for (int i3 = 0; i3 < aVarArr.length; i3++) {
                a aVar3 = aVarArr[i3];
                if (d5 <= aVar3.f17291d) {
                    if (aVar3.r) {
                        fArr[0] = (float) aVar3.c(d5);
                        fArr[1] = (float) aVarArr[i3].d(d5);
                        return;
                    } else {
                        aVar3.g(d5);
                        fArr[0] = (float) aVarArr[i3].e();
                        fArr[1] = (float) aVarArr[i3].f();
                        return;
                    }
                }
            }
            return;
        }
        double d11 = aVarArr[aVarArr.length - 1].f17291d;
        double d12 = d5 - d11;
        int length = aVarArr.length - 1;
        a aVar4 = aVarArr[length];
        if (!aVar4.r) {
            aVar4.g(d5);
            fArr[0] = (float) aVarArr[length].e();
            fArr[1] = (float) aVarArr[length].f();
        } else {
            double c10 = aVar4.c(d11);
            a aVar5 = aVarArr[length];
            fArr[0] = (float) ((aVar5.f17298l * d12) + c10);
            fArr[1] = (float) ((d12 * aVarArr[length].f17299m) + aVar5.d(d11));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double e(double d5) {
        a[] aVarArr = this.f17305b;
        double d8 = aVarArr[0].f17290c;
        if (d5 < d8) {
            d5 = d8;
        }
        if (d5 > aVarArr[aVarArr.length - 1].f17291d) {
            d5 = aVarArr[aVarArr.length - 1].f17291d;
        }
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            a aVar = aVarArr[i3];
            if (d5 <= aVar.f17291d) {
                if (aVar.r) {
                    return aVar.f17298l;
                }
                aVar.g(d5);
                return aVarArr[i3].a();
            }
        }
        return Double.NaN;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void f(double d5, double[] dArr) {
        a[] aVarArr = this.f17305b;
        double d8 = aVarArr[0].f17290c;
        if (d5 < d8) {
            d5 = d8;
        } else if (d5 > aVarArr[aVarArr.length - 1].f17291d) {
            d5 = aVarArr[aVarArr.length - 1].f17291d;
        }
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            a aVar = aVarArr[i3];
            if (d5 <= aVar.f17291d) {
                if (aVar.r) {
                    dArr[0] = aVar.f17298l;
                    dArr[1] = aVar.f17299m;
                    return;
                } else {
                    aVar.g(d5);
                    dArr[0] = aVarArr[i3].a();
                    dArr[1] = aVarArr[i3].b();
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double[] g() {
        return this.f17304a;
    }
}
