package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: m, reason: collision with root package name */
    public int f1625m;

    public b(h hVar) {
        super(hVar);
        if (hVar instanceof e) {
            this.e = DependencyNode$Type.HORIZONTAL_DIMENSION;
        } else {
            this.e = DependencyNode$Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.a
    public final void d(int i3) {
        if (this.f1622j) {
            return;
        }
        this.f1622j = true;
        this.f1619g = i3;
        ArrayList arrayList = this.f1623k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            r0.d dVar = (r0.d) obj;
            dVar.a(dVar);
        }
    }
}
