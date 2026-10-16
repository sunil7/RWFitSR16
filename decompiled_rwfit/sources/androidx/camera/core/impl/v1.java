package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1511a = new ArrayList();

    public static void b(ArrayList arrayList, int i3, int[] iArr, int i10) {
        if (i10 >= iArr.length) {
            arrayList.add((int[]) iArr.clone());
            return;
        }
        for (int i11 = 0; i11 < i3; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 >= i10) {
                    iArr[i10] = i11;
                    b(arrayList, i3, iArr, i10 + 1);
                    break;
                } else if (i11 == iArr[i12]) {
                    break;
                } else {
                    i12++;
                }
            }
        }
    }

    public final void a(i iVar) {
        this.f1511a.add(iVar);
    }

    public final List c(List list) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        int size = list.size();
        ArrayList arrayList = this.f1511a;
        if (size != arrayList.size()) {
            return null;
        }
        int size2 = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        boolean z5 = false;
        b(arrayList2, size2, new int[size2], 0);
        i[] iVarArr = new i[list.size()];
        int size3 = arrayList2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                break;
            }
            Object obj = arrayList2.get(i3);
            i3++;
            int[] iArr = (int[]) obj;
            boolean z6 = true;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (iArr[i10] < list.size()) {
                    i iVar = (i) arrayList.get(i10);
                    i iVar2 = (i) list.get(iArr[i10]);
                    iVar.getClass();
                    z6 &= iVar2.f1417b.getId() <= iVar.f1417b.getId() && iVar2.f1416a == iVar.f1416a;
                    if (!z6) {
                        break;
                    }
                    iVarArr[iArr[i10]] = (i) arrayList.get(i10);
                }
            }
            if (z6) {
                z5 = true;
                break;
            }
        }
        if (z5) {
            return Arrays.asList(iVarArr);
        }
        return null;
    }
}
