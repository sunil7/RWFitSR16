package l7;

import com.github.mikephil.charting.data.BarEntry;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public final float[] f15834b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15835c;

    /* renamed from: a, reason: collision with root package name */
    public int f15833a = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15836d = false;
    public float e = 1.0f;

    public a(int i3, boolean z5) {
        this.f15834b = new float[i3];
        this.f15835c = z5;
    }

    public final void a(float f2, float f10, float f11, float f12) {
        int i3 = this.f15833a;
        int i10 = i3 + 1;
        this.f15833a = i10;
        float[] fArr = this.f15834b;
        fArr[i3] = f2;
        int i11 = i3 + 2;
        this.f15833a = i11;
        fArr[i10] = f10;
        int i12 = i3 + 3;
        this.f15833a = i12;
        fArr[i11] = f11;
        this.f15833a = i3 + 4;
        fArr[i12] = f12;
    }

    public void b(o7.b bVar) {
        float f2;
        float f10;
        float abs;
        float abs2;
        float f11;
        float f12 = 1.0f;
        float size = bVar.f16820o.size() * 1.0f;
        float f13 = this.e / 2.0f;
        int i3 = 0;
        while (i3 < size) {
            BarEntry barEntry = (BarEntry) bVar.g(i3);
            if (barEntry != null) {
                float j4 = barEntry.j();
                float d5 = barEntry.d();
                float[] o3 = barEntry.o();
                float f14 = 0.0f;
                if (!this.f15835c || o3 == null) {
                    f2 = f12;
                    float f15 = j4 - f13;
                    float f16 = j4 + f13;
                    if (this.f15836d) {
                        f10 = d5 >= 0.0f ? d5 : 0.0f;
                        if (d5 > 0.0f) {
                            d5 = 0.0f;
                        }
                    } else {
                        float f17 = d5 >= 0.0f ? d5 : 0.0f;
                        if (d5 > 0.0f) {
                            d5 = 0.0f;
                        }
                        float f18 = d5;
                        d5 = f17;
                        f10 = f18;
                    }
                    if (d5 > 0.0f) {
                        d5 *= f2;
                    } else {
                        f10 *= f2;
                    }
                    a(f15, d5, f16, f10);
                    i3++;
                    f12 = f2;
                } else {
                    float f19 = -barEntry.l();
                    int i10 = 0;
                    float f20 = 0.0f;
                    while (i10 < o3.length) {
                        float f21 = o3[i10];
                        if (f21 == f14 && (f20 == f14 || f19 == f14)) {
                            abs = f21;
                            abs2 = f19;
                            f19 = abs;
                        } else if (f21 >= f14) {
                            abs = f21 + f20;
                            abs2 = f19;
                            f19 = f20;
                            f20 = abs;
                        } else {
                            abs = Math.abs(f21) + f19;
                            abs2 = Math.abs(f21) + f19;
                        }
                        float f22 = j4 - f13;
                        float f23 = f12;
                        float f24 = j4 + f13;
                        float f25 = f14;
                        if (this.f15836d) {
                            f11 = f19 >= abs ? f19 : abs;
                            if (f19 > abs) {
                                f19 = abs;
                            }
                        } else {
                            float f26 = f19 >= abs ? f19 : abs;
                            if (f19 > abs) {
                                f19 = abs;
                            }
                            float f27 = f26;
                            f11 = f19;
                            f19 = f27;
                        }
                        a(f22, f19 * f23, f24, f11 * f23);
                        i10++;
                        f19 = abs2;
                        f12 = f23;
                        f14 = f25;
                    }
                }
            }
            f2 = f12;
            i3++;
            f12 = f2;
        }
        this.f15833a = 0;
    }
}
