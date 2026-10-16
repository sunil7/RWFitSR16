package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2680a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2681b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f2682c;

    /* renamed from: d, reason: collision with root package name */
    public final c f2683d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2684f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2685g;

    public o(c cVar, ArrayList arrayList, int[] iArr, int[] iArr2) {
        int[] iArr3;
        int[] iArr4;
        c cVar2;
        int i3;
        n nVar;
        int i10;
        this.f2680a = arrayList;
        this.f2681b = iArr;
        this.f2682c = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.f2683d = cVar;
        int oldListSize = cVar.getOldListSize();
        this.e = oldListSize;
        int newListSize = cVar.getNewListSize();
        this.f2684f = newListSize;
        this.f2685g = true;
        n nVar2 = arrayList.isEmpty() ? null : (n) arrayList.get(0);
        if (nVar2 == null || nVar2.f2672a != 0 || nVar2.f2673b != 0) {
            arrayList.add(0, new n(0, 0, 0));
        }
        arrayList.add(new n(oldListSize, newListSize, 0));
        Iterator it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            iArr3 = this.f2682c;
            iArr4 = this.f2681b;
            cVar2 = this.f2683d;
            if (!hasNext) {
                break;
            }
            n nVar3 = (n) it.next();
            for (int i11 = 0; i11 < nVar3.f2674c; i11++) {
                int i12 = nVar3.f2672a + i11;
                int i13 = nVar3.f2673b + i11;
                int i14 = cVar2.areContentsTheSame(i12, i13) ? 1 : 2;
                iArr4[i12] = (i13 << 4) | i14;
                iArr3[i13] = (i12 << 4) | i14;
            }
        }
        if (this.f2685g) {
            int size = arrayList.size();
            int i15 = 0;
            int i16 = 0;
            while (i16 < size) {
                Object obj = arrayList.get(i16);
                i16++;
                n nVar4 = (n) obj;
                while (true) {
                    i3 = nVar4.f2672a;
                    if (i15 < i3) {
                        if (iArr4[i15] == 0) {
                            int size2 = arrayList.size();
                            int i17 = 0;
                            int i18 = 0;
                            while (true) {
                                if (i17 < size2) {
                                    nVar = (n) arrayList.get(i17);
                                    while (true) {
                                        i10 = nVar.f2673b;
                                        if (i18 < i10) {
                                            if (iArr3[i18] == 0 && cVar2.areItemsTheSame(i15, i18)) {
                                                int i19 = cVar2.areContentsTheSame(i15, i18) ? 8 : 4;
                                                iArr4[i15] = (i18 << 4) | i19;
                                                iArr3[i18] = i19 | (i15 << 4);
                                            } else {
                                                i18++;
                                            }
                                        }
                                    }
                                }
                                i18 = nVar.f2674c + i10;
                                i17++;
                            }
                        }
                        i15++;
                    }
                }
                i15 = nVar4.f2674c + i3;
            }
        }
    }

    public static q b(ArrayDeque arrayDeque, int i3, boolean z5) {
        q qVar;
        Iterator it = arrayDeque.iterator();
        while (true) {
            if (!it.hasNext()) {
                qVar = null;
                break;
            }
            qVar = (q) it.next();
            if (qVar.f2707a == i3 && qVar.f2709c == z5) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            q qVar2 = (q) it.next();
            if (z5) {
                qVar2.f2708b--;
            } else {
                qVar2.f2708b++;
            }
        }
        return qVar;
    }

    public final void a(s0 s0Var) {
        int[] iArr;
        c cVar;
        int i3;
        int i10;
        ArrayList arrayList;
        o oVar = this;
        d dVar = s0Var instanceof d ? (d) s0Var : new d(s0Var);
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList2 = oVar.f2680a;
        boolean z5 = true;
        int size = arrayList2.size() - 1;
        int i11 = oVar.e;
        int i12 = oVar.f2684f;
        int i13 = i11;
        while (size >= 0) {
            n nVar = (n) arrayList2.get(size);
            int i14 = nVar.f2672a;
            int i15 = nVar.f2674c;
            int i16 = i14 + i15;
            int i17 = nVar.f2673b;
            int i18 = i17 + i15;
            while (true) {
                iArr = oVar.f2681b;
                cVar = oVar.f2683d;
                boolean z6 = z5;
                i3 = 0;
                if (i13 <= i16) {
                    break;
                }
                i13--;
                int i19 = iArr[i13];
                if ((i19 & 12) != 0) {
                    arrayList = arrayList2;
                    int i20 = i19 >> 4;
                    q b3 = b(arrayDeque, i20, false);
                    if (b3 != null) {
                        int i21 = (i11 - b3.f2708b) - 1;
                        dVar.onMoved(i13, i21);
                        if ((i19 & 4) != 0) {
                            dVar.onChanged(i21, z6 ? 1 : 0, cVar.getChangePayload(i13, i20));
                        }
                    } else {
                        arrayDeque.add(new q(i13, (i11 - i13) - (z6 ? 1 : 0), z6));
                    }
                } else {
                    arrayList = arrayList2;
                    dVar.onRemoved(i13, z6 ? 1 : 0);
                    i11--;
                }
                arrayList2 = arrayList;
                z5 = true;
            }
            ArrayList arrayList3 = arrayList2;
            while (i12 > i18) {
                i12--;
                int i22 = oVar.f2682c[i12];
                if ((i22 & 12) != 0) {
                    int i23 = i22 >> 4;
                    q b10 = b(arrayDeque, i23, true);
                    if (b10 == null) {
                        arrayDeque.add(new q(i12, i11 - i13, false));
                        i10 = 0;
                    } else {
                        i10 = 0;
                        dVar.onMoved((i11 - b10.f2708b) - 1, i13);
                        if ((i22 & 4) != 0) {
                            dVar.onChanged(i13, 1, cVar.getChangePayload(i23, i12));
                        }
                    }
                } else {
                    i10 = i3;
                    dVar.onInserted(i13, 1);
                    i11++;
                }
                oVar = this;
                i3 = i10;
            }
            i13 = nVar.f2672a;
            int i24 = i13;
            int i25 = i17;
            while (i3 < i15) {
                if ((iArr[i24] & 15) == 2) {
                    dVar.onChanged(i24, 1, cVar.getChangePayload(i24, i25));
                }
                i24++;
                i25++;
                i3++;
            }
            size--;
            oVar = this;
            z5 = true;
            i12 = i17;
            arrayList2 = arrayList3;
        }
        dVar.a();
    }
}
