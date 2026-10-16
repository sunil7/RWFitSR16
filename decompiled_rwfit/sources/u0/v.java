package u0;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class v implements Comparable {
    public static final String[] r = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a, reason: collision with root package name */
    public p0.e f18764a;

    /* renamed from: c, reason: collision with root package name */
    public float f18766c;

    /* renamed from: d, reason: collision with root package name */
    public float f18767d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f18768f;

    /* renamed from: g, reason: collision with root package name */
    public float f18769g;

    /* renamed from: h, reason: collision with root package name */
    public float f18770h;

    /* renamed from: b, reason: collision with root package name */
    public int f18765b = 0;

    /* renamed from: i, reason: collision with root package name */
    public float f18771i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public int f18772j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f18773k = -1;

    /* renamed from: l, reason: collision with root package name */
    public float f18774l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public n f18775m = null;

    /* renamed from: n, reason: collision with root package name */
    public LinkedHashMap f18776n = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name */
    public int f18777o = 0;

    /* renamed from: p, reason: collision with root package name */
    public double[] f18778p = new double[18];

    /* renamed from: q, reason: collision with root package name */
    public double[] f18779q = new double[18];

    public static boolean b(float f2, float f10) {
        return (Float.isNaN(f2) || Float.isNaN(f10)) ? Float.isNaN(f2) != Float.isNaN(f10) : Math.abs(f2 - f10) > 1.0E-6f;
    }

    public static void e(float f2, float f10, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f15 = (float) dArr[i3];
            double d5 = dArr2[i3];
            int i10 = iArr[i3];
            if (i10 == 1) {
                f11 = f15;
            } else if (i10 == 2) {
                f13 = f15;
            } else if (i10 == 3) {
                f12 = f15;
            } else if (i10 == 4) {
                f14 = f15;
            }
        }
        float f16 = f11 - ((0.0f * f12) / 2.0f);
        float f17 = f13 - ((0.0f * f14) / 2.0f);
        fArr[0] = (((f12 * 1.0f) + f16) * f2) + ((1.0f - f2) * f16) + 0.0f;
        fArr[1] = (((f14 * 1.0f) + f17) * f10) + ((1.0f - f10) * f17) + 0.0f;
    }

    public final void a(w0.j jVar) {
        int i3;
        this.f18764a = p0.e.d(jVar.f19363d.f19410d);
        w0.l lVar = jVar.f19363d;
        this.f18772j = lVar.e;
        this.f18773k = lVar.f19408b;
        this.f18771i = lVar.f19413h;
        this.f18765b = lVar.f19411f;
        this.f18774l = jVar.e.B;
        for (String str : jVar.f19365g.keySet()) {
            w0.b bVar = (w0.b) jVar.f19365g.get(str);
            if (bVar != null && (i3 = w0.a.f19284a[bVar.f19287c.ordinal()]) != 1 && i3 != 2 && i3 != 3) {
                this.f18776n.put(str, bVar);
            }
        }
    }

    public final void c(double d5, int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f2 = this.e;
        float f10 = this.f18768f;
        float f11 = this.f18769g;
        float f12 = this.f18770h;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f13 = (float) dArr[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f2 = f13;
            } else if (i11 == 2) {
                f10 = f13;
            } else if (i11 == 3) {
                f11 = f13;
            } else if (i11 == 4) {
                f12 = f13;
            }
        }
        n nVar = this.f18775m;
        if (nVar != null) {
            float[] fArr2 = new float[2];
            nVar.c(d5, fArr2, new float[2]);
            float f14 = fArr2[0];
            float f15 = fArr2[1];
            double d8 = f14;
            double d10 = f2;
            double d11 = f10;
            f2 = (float) (((Math.sin(d11) * d10) + d8) - (f11 / 2.0f));
            f10 = (float) ((f15 - (Math.cos(d11) * d10)) - (f12 / 2.0f));
        }
        fArr[i3] = (f11 / 2.0f) + f2 + 0.0f;
        fArr[i3 + 1] = (f12 / 2.0f) + f10 + 0.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Float.compare(this.f18767d, ((v) obj).f18767d);
    }

    public final void d(float f2, float f10, float f11, float f12) {
        this.e = f2;
        this.f18768f = f10;
        this.f18769g = f11;
        this.f18770h = f12;
    }

    public final void f(n nVar, v vVar) {
        double d5 = (((this.f18769g / 2.0f) + this.e) - vVar.e) - (vVar.f18769g / 2.0f);
        double d8 = (((this.f18770h / 2.0f) + this.f18768f) - vVar.f18768f) - (vVar.f18770h / 2.0f);
        this.f18775m = nVar;
        this.e = (float) Math.hypot(d8, d5);
        if (Float.isNaN(this.f18774l)) {
            this.f18768f = (float) (Math.atan2(d8, d5) + 1.5707963267948966d);
        } else {
            this.f18768f = (float) Math.toRadians(this.f18774l);
        }
    }
}
