package androidx.recyclerview.widget;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f2705a;

    /* renamed from: b, reason: collision with root package name */
    public int f2706b;

    public final o1 a(int i3) {
        SparseArray sparseArray = this.f2705a;
        o1 o1Var = (o1) sparseArray.get(i3);
        if (o1Var != null) {
            return o1Var;
        }
        o1 o1Var2 = new o1();
        sparseArray.put(i3, o1Var2);
        return o1Var2;
    }
}
