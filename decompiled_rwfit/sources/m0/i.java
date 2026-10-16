package m0;

import ab.n;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class i implements Iterator, Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public int f15909a;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f15912d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15911c = false;

    /* renamed from: b, reason: collision with root package name */
    public int f15910b = -1;

    public i(n nVar) {
        this.f15912d = nVar;
        this.f15909a = nVar.g() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f15911c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i3 = this.f15910b;
        n nVar = this.f15912d;
        Object e = nVar.e(i3, 0);
        if (key != e && (key == null || !key.equals(e))) {
            return false;
        }
        Object value = entry.getValue();
        Object e10 = nVar.e(this.f15910b, 1);
        return value == e10 || (value != null && value.equals(e10));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.f15911c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f15912d.e(this.f15910b, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.f15911c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f15912d.e(this.f15910b, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15910b < this.f15909a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f15911c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i3 = this.f15910b;
        n nVar = this.f15912d;
        Object e = nVar.e(i3, 0);
        Object e10 = nVar.e(this.f15910b, 1);
        return (e == null ? 0 : e.hashCode()) ^ (e10 != null ? e10.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f15910b++;
        this.f15911c = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f15911c) {
            throw new IllegalStateException();
        }
        this.f15912d.k(this.f15910b);
        this.f15910b--;
        this.f15909a--;
        this.f15911c = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f15911c) {
            return this.f15912d.l(this.f15910b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
