package com.google.zxing.qrcode.detector;

import java.util.ArrayList;
import kd.c;
import sc.b;

/* loaded from: classes.dex */
public final class a {
    public static final FinderPatternFinder$EstimatedModuleComparator e = new FinderPatternFinder$EstimatedModuleComparator();

    /* renamed from: a, reason: collision with root package name */
    public final b f11269a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11271c;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f11270b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f11272d = new int[5];

    public a(b bVar) {
        this.f11269a = bVar;
    }

    public static float a(int i3, int[] iArr) {
        return ((i3 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean b(int[] iArr) {
        int i3 = 0;
        int i10 = 0;
        while (true) {
            if (i3 < 5) {
                int i11 = iArr[i3];
                if (i11 == 0) {
                    break;
                }
                i10 += i11;
                i3++;
            } else if (i10 >= 7) {
                float f2 = i10 / 7.0f;
                float f10 = f2 / 2.0f;
                if (Math.abs(f2 - iArr[0]) >= f10 || Math.abs(f2 - iArr[1]) >= f10 || Math.abs((f2 * 3.0f) - iArr[2]) >= 3.0f * f10 || Math.abs(f2 - iArr[3]) >= f10 || Math.abs(f2 - iArr[4]) >= f10) {
                    break;
                }
                return true;
            }
        }
        return false;
    }

    public static double e(c cVar, c cVar2) {
        double d5 = cVar.f11247a - cVar2.f11247a;
        double d8 = cVar.f11248b - cVar2.f11248b;
        return (d8 * d8) + (d5 * d5);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int[] r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.a.c(int[], int, int):boolean");
    }

    public final boolean d() {
        ArrayList arrayList = this.f11270b;
        int size = arrayList.size();
        int size2 = arrayList.size();
        float f2 = 0.0f;
        int i3 = 0;
        int i10 = 0;
        float f10 = 0.0f;
        while (i10 < size2) {
            Object obj = arrayList.get(i10);
            i10++;
            c cVar = (c) obj;
            if (cVar.f15612d >= 2) {
                i3++;
                f10 += cVar.f15611c;
            }
        }
        if (i3 >= 3) {
            float f11 = f10 / size;
            int size3 = arrayList.size();
            int i11 = 0;
            while (i11 < size3) {
                Object obj2 = arrayList.get(i11);
                i11++;
                f2 += Math.abs(((c) obj2).f15611c - f11);
            }
            if (f2 <= f10 * 0.05f) {
                return true;
            }
        }
        return false;
    }
}
