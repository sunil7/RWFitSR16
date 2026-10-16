package org.joda.time.format;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.MutablePeriod;

/* loaded from: classes2.dex */
public final class b0 implements k0, j0 {

    /* renamed from: a, reason: collision with root package name */
    public final k0[] f17157a;

    /* renamed from: b, reason: collision with root package name */
    public final j0[] f17158b;

    public b0(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3 += 2) {
            Object obj = list.get(i3);
            if (obj instanceof k0) {
                if (obj instanceof b0) {
                    k0[] k0VarArr = ((b0) obj).f17157a;
                    if (k0VarArr != null) {
                        for (k0 k0Var : k0VarArr) {
                            arrayList.add(k0Var);
                        }
                    }
                } else {
                    arrayList.add(obj);
                }
            }
            Object obj2 = list.get(i3 + 1);
            if (obj2 instanceof j0) {
                if (obj2 instanceof b0) {
                    j0[] j0VarArr = ((b0) obj2).f17158b;
                    if (j0VarArr != null) {
                        for (j0 j0Var : j0VarArr) {
                            arrayList2.add(j0Var);
                        }
                    }
                } else {
                    arrayList2.add(obj2);
                }
            }
        }
        if (arrayList.size() <= 0) {
            this.f17157a = null;
        } else {
            this.f17157a = (k0[]) arrayList.toArray(new k0[arrayList.size()]);
        }
        if (arrayList2.size() <= 0) {
            this.f17158b = null;
        } else {
            this.f17158b = (j0[]) arrayList2.toArray(new j0[arrayList2.size()]);
        }
    }

    @Override // org.joda.time.format.k0
    public final int a(ai.f fVar, int i3) {
        k0[] k0VarArr = this.f17157a;
        int length = k0VarArr.length;
        int i10 = 0;
        while (i10 < i3) {
            length--;
            if (length < 0) {
                break;
            }
            i10 += k0VarArr[length].a(fVar, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
        return i10;
    }

    @Override // org.joda.time.format.k0
    public final int b(ai.f fVar) {
        k0[] k0VarArr = this.f17157a;
        int length = k0VarArr.length;
        int i3 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i3;
            }
            i3 += k0VarArr[length].b(fVar);
        }
    }

    @Override // org.joda.time.format.j0
    public final int c(MutablePeriod mutablePeriod, String str, int i3) {
        j0[] j0VarArr = this.f17158b;
        if (j0VarArr == null) {
            throw new UnsupportedOperationException();
        }
        int length = j0VarArr.length;
        for (int i10 = 0; i10 < length && i3 >= 0; i10++) {
            i3 = j0VarArr[i10].c(mutablePeriod, str, i3);
        }
        return i3;
    }

    @Override // org.joda.time.format.k0
    public final void d(StringBuffer stringBuffer, ai.f fVar) {
        for (k0 k0Var : this.f17157a) {
            k0Var.d(stringBuffer, fVar);
        }
    }
}
