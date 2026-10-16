package kd;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final sc.b f15604a;

    /* renamed from: c, reason: collision with root package name */
    public final int f15606c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15607d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f15608f;

    /* renamed from: g, reason: collision with root package name */
    public final float f15609g;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f15605b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    public final int[] f15610h = new int[3];

    public b(sc.b bVar, int i3, int i10, int i11, int i12, float f2) {
        this.f15604a = bVar;
        this.f15606c = i3;
        this.f15607d = i10;
        this.e = i11;
        this.f15608f = i12;
        this.f15609g = f2;
    }

    public final boolean a(int[] iArr) {
        float f2 = this.f15609g;
        float f10 = f2 / 2.0f;
        for (int i3 = 0; i3 < 3; i3++) {
            if (Math.abs(f2 - iArr[i3]) >= f10) {
                return false;
            }
        }
        return true;
    }

    public final a b(int[] iArr, int i3, int i10) {
        int i11 = 0;
        int i12 = iArr[0];
        int i13 = iArr[1];
        int i14 = i12 + i13 + iArr[2];
        float f2 = (i10 - r5) - (i13 / 2.0f);
        int i15 = (int) f2;
        int i16 = i13 * 2;
        sc.b bVar = this.f15604a;
        int i17 = bVar.f18222b;
        int[] iArr2 = this.f15610h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        int i18 = i3;
        while (i18 >= 0 && bVar.b(i15, i18)) {
            int i19 = iArr2[1];
            if (i19 > i16) {
                break;
            }
            iArr2[1] = i19 + 1;
            i18--;
        }
        float f10 = Float.NaN;
        if (i18 >= 0 && iArr2[1] <= i16) {
            while (i18 >= 0 && !bVar.b(i15, i18)) {
                int i20 = iArr2[0];
                if (i20 > i16) {
                    break;
                }
                iArr2[0] = i20 + 1;
                i18--;
            }
            if (iArr2[0] <= i16) {
                int i21 = i3 + 1;
                while (i21 < i17 && bVar.b(i15, i21)) {
                    int i22 = iArr2[1];
                    if (i22 > i16) {
                        break;
                    }
                    iArr2[1] = i22 + 1;
                    i21++;
                }
                if (i21 != i17 && iArr2[1] <= i16) {
                    while (i21 < i17 && !bVar.b(i15, i21)) {
                        int i23 = iArr2[2];
                        if (i23 > i16) {
                            break;
                        }
                        iArr2[2] = i23 + 1;
                        i21++;
                    }
                    int i24 = iArr2[2];
                    if (i24 <= i16 && Math.abs(((iArr2[0] + iArr2[1]) + i24) - i14) * 5 < i14 * 2 && a(iArr2)) {
                        f10 = (i21 - iArr2[2]) - (iArr2[1] / 2.0f);
                    }
                }
            }
        }
        if (Float.isNaN(f10)) {
            return null;
        }
        float f11 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        ArrayList arrayList = this.f15605b;
        int size = arrayList.size();
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            a aVar = (a) obj;
            if (Math.abs(f10 - aVar.f11248b) <= f11) {
                float f12 = aVar.f11247a;
                if (Math.abs(f2 - f12) <= f11) {
                    float f13 = aVar.f15603c;
                    float abs = Math.abs(f11 - f13);
                    if (abs <= 1.0f || abs <= f13) {
                        return new a((f12 + f2) / 2.0f, (aVar.f11248b + f10) / 2.0f, (f13 + f11) / 2.0f);
                    }
                } else {
                    continue;
                }
            }
        }
        arrayList.add(new a(f2, f10, f11));
        return null;
    }
}
