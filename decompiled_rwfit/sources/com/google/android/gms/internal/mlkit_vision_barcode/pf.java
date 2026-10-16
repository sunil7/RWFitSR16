package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class pf {
    public static pf a(int i3, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i3 = 2;
        }
        if (i3 == 0) {
            return new p0.h(dArr, dArr2);
        }
        if (i3 == 2) {
            double d5 = dArr[0];
            double[] dArr3 = dArr2[0];
            p0.c cVar = new p0.c();
            cVar.f17306a = d5;
            cVar.f17307b = dArr3;
            return cVar;
        }
        p0.g gVar = new p0.g();
        int length = dArr2[0].length;
        gVar.f17325c = new double[length];
        gVar.f17323a = dArr;
        gVar.f17324b = dArr2;
        if (length > 2) {
            double d8 = 0.0d;
            int i10 = 0;
            while (true) {
                double d10 = d8;
                if (i10 >= dArr.length) {
                    break;
                }
                double d11 = dArr2[i10][0];
                if (i10 > 0) {
                    Math.hypot(d11 - d8, d11 - d10);
                }
                i10++;
                d8 = d11;
            }
        }
        return gVar;
    }

    public abstract double b(double d5);

    public abstract void c(double d5, double[] dArr);

    public abstract void d(double d5, float[] fArr);

    public abstract double e(double d5);

    public abstract void f(double d5, double[] dArr);

    public abstract double[] g();
}
