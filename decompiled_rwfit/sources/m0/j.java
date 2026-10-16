package m0;

import ab.n;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j implements Collection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f15913a;

    public j(n nVar) {
        this.f15913a = nVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f15913a.d();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f15913a.i(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f15913a.g() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new g(this.f15913a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        n nVar = this.f15913a;
        int i3 = nVar.i(obj);
        if (i3 < 0) {
            return false;
        }
        nVar.k(i3);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        n nVar = this.f15913a;
        int g10 = nVar.g();
        int i3 = 0;
        boolean z5 = false;
        while (i3 < g10) {
            if (collection.contains(nVar.e(i3, 1))) {
                nVar.k(i3);
                i3--;
                g10--;
                z5 = true;
            }
            i3++;
        }
        return z5;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        n nVar = this.f15913a;
        int g10 = nVar.g();
        int i3 = 0;
        boolean z5 = false;
        while (i3 < g10) {
            if (!collection.contains(nVar.e(i3, 1))) {
                nVar.k(i3);
                i3--;
                g10--;
                z5 = true;
            }
            i3++;
        }
        return z5;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f15913a.g();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        n nVar = this.f15913a;
        int g10 = nVar.g();
        Object[] objArr = new Object[g10];
        for (int i3 = 0; i3 < g10; i3++) {
            objArr[i3] = nVar.e(i3, 1);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f15913a.v(1, objArr);
    }
}
