package n7;

import android.graphics.DashPathEffect;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a extends b {

    /* renamed from: f, reason: collision with root package name */
    public p7.b f16386f;

    /* renamed from: l, reason: collision with root package name */
    public int f16392l;

    /* renamed from: m, reason: collision with root package name */
    public int f16393m;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f16401v;

    /* renamed from: g, reason: collision with root package name */
    public final int f16387g = -7829368;

    /* renamed from: h, reason: collision with root package name */
    public final float f16388h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public final int f16389i = -7829368;

    /* renamed from: j, reason: collision with root package name */
    public final float f16390j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public float[] f16391k = new float[0];

    /* renamed from: n, reason: collision with root package name */
    public int f16394n = 6;

    /* renamed from: o, reason: collision with root package name */
    public float f16395o = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    public boolean f16396p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f16397q = false;
    public boolean r = true;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f16398s = true;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f16399t = true;

    /* renamed from: u, reason: collision with root package name */
    public DashPathEffect f16400u = null;

    /* renamed from: w, reason: collision with root package name */
    public boolean f16402w = true;

    /* renamed from: x, reason: collision with root package name */
    public float f16403x = 0.0f;

    /* renamed from: y, reason: collision with root package name */
    public float f16404y = 0.0f;

    /* renamed from: z, reason: collision with root package name */
    public boolean f16405z = false;
    public float A = 0.0f;
    public float B = 0.0f;
    public float C = 0.0f;
    public final int D = 2;
    public final int E = 25;

    public a() {
        this.f16409d = v7.h.c(10.0f);
        this.f16407b = v7.h.c(5.0f);
        this.f16408c = v7.h.c(5.0f);
        this.f16401v = new ArrayList();
    }

    public void a(float f2, float f10) {
        float f11 = this.f16405z ? this.B : f2 - this.f16403x;
        float f12 = f10 + this.f16404y;
        if (Math.abs(f12 - f11) == 0.0f) {
            f12 += 1.0f;
            f11 -= 1.0f;
        }
        this.B = f11;
        this.A = f12;
        this.C = Math.abs(f12 - f11);
    }

    public final void b() {
        this.f16400u = new DashPathEffect(new float[]{10.0f, 20.0f}, 0.0f);
    }

    public final String c(int i3) {
        return (i3 < 0 || i3 >= this.f16391k.length) ? "" : e().getFormattedValue(this.f16391k[i3], this);
    }

    public final String d() {
        String str = "";
        for (int i3 = 0; i3 < this.f16391k.length; i3++) {
            String c9 = c(i3);
            if (c9 != null && str.length() < c9.length()) {
                str = c9;
            }
        }
        return str;
    }

    public final p7.b e() {
        p7.b bVar = this.f16386f;
        if (bVar == null || ((bVar instanceof p7.a) && ((p7.a) bVar).f17479b != this.f16393m)) {
            int i3 = this.f16393m;
            p7.a aVar = new p7.a();
            aVar.f17479b = i3;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < i3; i10++) {
                if (i10 == 0) {
                    stringBuffer.append(".");
                }
                stringBuffer.append("0");
            }
            aVar.f17478a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
            this.f16386f = aVar;
        }
        return this.f16386f;
    }

    public final void f(float f2) {
        this.f16405z = true;
        this.B = f2;
        this.C = Math.abs(this.A - f2);
    }

    public final void g() {
        this.f16395o = 1.0f;
        this.f16396p = true;
    }

    public final void h(int i3, boolean z5) {
        int i10 = this.E;
        if (i3 > i10) {
            i3 = i10;
        }
        int i11 = this.D;
        if (i3 < i11) {
            i3 = i11;
        }
        this.f16394n = i3;
        this.f16397q = z5;
    }
}
