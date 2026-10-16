package androidx.emoji2.text;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f2064a;

    /* renamed from: b, reason: collision with root package name */
    public n f2065b;

    public r(int i3) {
        this.f2064a = new SparseArray(i3);
    }

    public final void a(n nVar, int i3, int i10) {
        int a3 = nVar.a(i3);
        SparseArray sparseArray = this.f2064a;
        r rVar = sparseArray == null ? null : (r) sparseArray.get(a3);
        if (rVar == null) {
            rVar = new r(1);
            sparseArray.put(nVar.a(i3), rVar);
        }
        if (i10 > i3) {
            rVar.a(nVar, i3 + 1, i10);
        } else {
            rVar.f2065b = nVar;
        }
    }
}
