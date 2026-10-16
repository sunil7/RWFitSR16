package m0;

import ab.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class h implements Set {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15907a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f15908b;

    public /* synthetic */ h(n nVar, int i3) {
        this.f15907a = i3;
        this.f15908b = nVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f15907a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f15907a) {
            case 0:
                n nVar = this.f15908b;
                int g10 = nVar.g();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    nVar.j(entry.getKey(), entry.getValue());
                }
                return g10 != nVar.g();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.f15907a) {
            case 0:
                this.f15908b.d();
                break;
            default:
                this.f15908b.d();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f15907a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                n nVar = this.f15908b;
                int h4 = nVar.h(key);
                if (h4 < 0) {
                    return false;
                }
                Object e = nVar.e(h4, 1);
                Object value = entry.getValue();
                return e == value || (e != null && e.equals(value));
            default:
                return this.f15908b.h(obj) >= 0;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f15907a) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        break;
                    }
                }
                break;
            default:
                Map f2 = this.f15908b.f();
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!f2.containsKey(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f15907a) {
        }
        return n.o(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.f15907a) {
            case 0:
                n nVar = this.f15908b;
                int i3 = 0;
                for (int g10 = nVar.g() - 1; g10 >= 0; g10--) {
                    Object e = nVar.e(g10, 0);
                    Object e10 = nVar.e(g10, 1);
                    i3 += (e == null ? 0 : e.hashCode()) ^ (e10 == null ? 0 : e10.hashCode());
                }
                return i3;
            default:
                n nVar2 = this.f15908b;
                int i10 = 0;
                for (int g11 = nVar2.g() - 1; g11 >= 0; g11--) {
                    Object e11 = nVar2.e(g11, 0);
                    i10 += e11 == null ? 0 : e11.hashCode();
                }
                return i10;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f15907a) {
            case 0:
                if (this.f15908b.g() == 0) {
                }
                break;
            default:
                if (this.f15908b.g() == 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f15907a) {
            case 0:
                return new i(this.f15908b);
            default:
                return new g(this.f15908b, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f15907a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                n nVar = this.f15908b;
                int h4 = nVar.h(obj);
                if (h4 < 0) {
                    return false;
                }
                nVar.k(h4);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f15907a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Map f2 = this.f15908b.f();
                int size = f2.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    f2.remove(it.next());
                }
                return size != f2.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f15907a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return n.s(this.f15908b.f(), collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.f15907a) {
        }
        return this.f15908b.g();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f15907a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f15908b.v(0, objArr);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f15907a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                n nVar = this.f15908b;
                int g10 = nVar.g();
                Object[] objArr = new Object[g10];
                for (int i3 = 0; i3 < g10; i3++) {
                    objArr[i3] = nVar.e(i3, 0);
                }
                return objArr;
        }
    }
}
