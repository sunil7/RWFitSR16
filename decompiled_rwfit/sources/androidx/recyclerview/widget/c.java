package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: b, reason: collision with root package name */
    public static ExecutorService f2520b;

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2519a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final m f2521c = new m(0);

    public static o a(c cVar) {
        int i3;
        s sVar;
        int i10;
        r rVar;
        int i11;
        int i12;
        s sVar2;
        s sVar3;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int oldListSize = cVar.getOldListSize();
        int newListSize = cVar.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        r rVar2 = new r();
        int i22 = 0;
        rVar2.f2717a = 0;
        rVar2.f2718b = oldListSize;
        rVar2.f2719c = 0;
        rVar2.f2720d = newListSize;
        arrayList2.add(rVar2);
        int i23 = oldListSize + newListSize;
        int i24 = 1;
        int i25 = (((i23 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i25];
        int i26 = i25 / 2;
        int[] iArr2 = new int[i25];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            r rVar3 = (r) arrayList2.remove(arrayList2.size() - i24);
            if (rVar3.b() >= i24 && rVar3.a() >= i24) {
                int a3 = ((rVar3.a() + rVar3.b()) + i24) / 2;
                int i27 = i24 + i26;
                iArr[i27] = rVar3.f2717a;
                iArr2[i27] = rVar3.f2718b;
                int i28 = i22;
                while (i28 < a3) {
                    int i29 = Math.abs(rVar3.b() - rVar3.a()) % 2 == i24 ? i24 : i22;
                    int b3 = rVar3.b() - rVar3.a();
                    int i30 = -i28;
                    int i31 = i30;
                    while (true) {
                        if (i31 > i28) {
                            i11 = i22;
                            i3 = i26;
                            i12 = a3;
                            sVar2 = null;
                            break;
                        }
                        if (i31 == i30 || (i31 != i28 && iArr[i31 + 1 + i26] > iArr[(i31 - 1) + i26])) {
                            i17 = iArr[i31 + 1 + i26];
                            i18 = i17;
                        } else {
                            i17 = iArr[(i31 - 1) + i26];
                            i18 = i17 + 1;
                        }
                        i3 = i26;
                        int i32 = ((i18 - rVar3.f2717a) + rVar3.f2719c) - i31;
                        if (i28 == 0 || i18 != i17) {
                            i19 = i18;
                            i20 = i32;
                        } else {
                            i19 = i18;
                            i20 = i32 - 1;
                        }
                        int i33 = i31;
                        int i34 = i32;
                        int i35 = i19;
                        i12 = a3;
                        while (i35 < rVar3.f2718b && i34 < rVar3.f2720d && cVar.areItemsTheSame(i35, i34)) {
                            i35++;
                            i34++;
                        }
                        iArr[i33 + i3] = i35;
                        if (i29 != 0) {
                            int i36 = b3 - i33;
                            i21 = i29;
                            if (i36 >= i30 + 1 && i36 <= i28 - 1 && iArr2[i36 + i3] <= i35) {
                                sVar2 = new s();
                                sVar2.f2736a = i17;
                                sVar2.f2737b = i20;
                                sVar2.f2738c = i35;
                                sVar2.f2739d = i34;
                                i11 = 0;
                                sVar2.e = false;
                                break;
                            }
                        } else {
                            i21 = i29;
                        }
                        i31 = i33 + 2;
                        i22 = 0;
                        i26 = i3;
                        a3 = i12;
                        i29 = i21;
                    }
                    if (sVar2 != null) {
                        sVar = sVar2;
                        break;
                    }
                    int i37 = (rVar3.b() - rVar3.a()) % 2 == 0 ? 1 : i11;
                    int b10 = rVar3.b() - rVar3.a();
                    int i38 = i30;
                    while (true) {
                        if (i38 > i28) {
                            sVar3 = null;
                            break;
                        }
                        if (i38 == i30 || (i38 != i28 && iArr2[i38 + 1 + i3] < iArr2[(i38 - 1) + i3])) {
                            i13 = iArr2[i38 + 1 + i3];
                            i14 = i13;
                        } else {
                            i13 = iArr2[(i38 - 1) + i3];
                            i14 = i13 - 1;
                        }
                        int i39 = rVar3.f2720d - ((rVar3.f2718b - i14) - i38);
                        int i40 = (i28 == 0 || i14 != i13) ? i39 : i39 + 1;
                        int i41 = i37;
                        while (i14 > rVar3.f2717a && i39 > rVar3.f2719c) {
                            i15 = b10;
                            if (!cVar.areItemsTheSame(i14 - 1, i39 - 1)) {
                                break;
                            }
                            i14--;
                            i39--;
                            b10 = i15;
                        }
                        i15 = b10;
                        iArr2[i38 + i3] = i14;
                        if (i41 != 0 && (i16 = i15 - i38) >= i30 && i16 <= i28 && iArr[i16 + i3] >= i14) {
                            sVar3 = new s();
                            sVar3.f2736a = i14;
                            sVar3.f2737b = i39;
                            sVar3.f2738c = i13;
                            sVar3.f2739d = i40;
                            sVar3.e = true;
                            break;
                        }
                        i38 += 2;
                        i37 = i41;
                        b10 = i15;
                    }
                    if (sVar3 != null) {
                        sVar = sVar3;
                        break;
                    }
                    i28++;
                    i26 = i3;
                    a3 = i12;
                    i24 = 1;
                    i22 = 0;
                }
            }
            i3 = i26;
            sVar = null;
            if (sVar != null) {
                if (sVar.a() > 0) {
                    int i42 = sVar.f2739d;
                    int i43 = sVar.f2737b;
                    int i44 = i42 - i43;
                    int i45 = sVar.f2738c;
                    int i46 = sVar.f2736a;
                    int i47 = i45 - i46;
                    arrayList.add(i44 != i47 ? sVar.e ? new n(i46, i43, sVar.a()) : i44 > i47 ? new n(i46, i43 + 1, sVar.a()) : new n(i46 + 1, i43, sVar.a()) : new n(i46, i43, i47));
                }
                if (arrayList3.isEmpty()) {
                    rVar = new r();
                    i10 = 1;
                } else {
                    i10 = 1;
                    rVar = (r) arrayList3.remove(arrayList3.size() - 1);
                }
                rVar.f2717a = rVar3.f2717a;
                rVar.f2719c = rVar3.f2719c;
                rVar.f2718b = sVar.f2736a;
                rVar.f2720d = sVar.f2737b;
                arrayList2.add(rVar);
                rVar3.f2718b = rVar3.f2718b;
                rVar3.f2720d = rVar3.f2720d;
                rVar3.f2717a = sVar.f2738c;
                rVar3.f2719c = sVar.f2739d;
                arrayList2.add(rVar3);
            } else {
                i10 = 1;
                arrayList3.add(rVar3);
            }
            i26 = i3;
            i24 = i10;
            i22 = 0;
        }
        Collections.sort(arrayList, f2521c);
        return new o(cVar, arrayList, iArr, iArr2);
    }

    public static int b(w1 w1Var, androidx.emoji2.text.g gVar, View view, View view2, i1 i1Var, boolean z5) {
        if (i1Var.v() == 0 || w1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z5) {
            return Math.abs(i1.K(view) - i1.K(view2)) + 1;
        }
        return Math.min(gVar.o(), gVar.e(view2) - gVar.h(view));
    }

    public static int c(w1 w1Var, androidx.emoji2.text.g gVar, View view, View view2, i1 i1Var, boolean z5, boolean z6) {
        if (i1Var.v() == 0 || w1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z6 ? Math.max(0, (w1Var.b() - Math.max(i1.K(view), i1.K(view2))) - 1) : Math.max(0, Math.min(i1.K(view), i1.K(view2)));
        if (z5) {
            return Math.round((max * (Math.abs(gVar.e(view2) - gVar.h(view)) / (Math.abs(i1.K(view) - i1.K(view2)) + 1))) + (gVar.n() - gVar.h(view)));
        }
        return max;
    }

    public static int d(w1 w1Var, androidx.emoji2.text.g gVar, View view, View view2, i1 i1Var, boolean z5) {
        if (i1Var.v() == 0 || w1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z5) {
            return w1Var.b();
        }
        return (int) (((gVar.e(view2) - gVar.h(view)) / (Math.abs(i1.K(view) - i1.K(view2)) + 1)) * w1Var.b());
    }

    public abstract boolean areContentsTheSame(int i3, int i10);

    public abstract boolean areItemsTheSame(int i3, int i10);

    public abstract Object getChangePayload(int i3, int i10);

    public abstract int getNewListSize();

    public abstract int getOldListSize();
}
