package z3;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20247a;

    public k(ArrayList arrayList) {
        this.f20247a = arrayList;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f20247a.iterator();
    }
}
