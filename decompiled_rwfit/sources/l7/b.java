package l7;

import com.github.mikephil.charting.data.BarEntry;

/* loaded from: classes.dex */
public final class b extends a {
    @Override // l7.a
    public final void b(o7.b bVar) {
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
                    a(f10, f16, d5, f15);
                    i3++;
                    f12 = f2;
                } else {
                    float f19 = -barEntry.l();
                    int i10 = 0;
                    float f20 = 0.0f;
                    while (i10 < o3.length) {
                        float f21 = o3[i10];
                        if (f21 >= f14) {
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
                        a(f11 * f23, f24, f19 * f23, f22);
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
