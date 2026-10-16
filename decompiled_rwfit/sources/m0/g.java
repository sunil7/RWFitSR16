package m0;

import ab.n;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class g implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f15903a;

    /* renamed from: b, reason: collision with root package name */
    public int f15904b;

    /* renamed from: c, reason: collision with root package name */
    public int f15905c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15906d = false;
    public final /* synthetic */ n e;

    public g(n nVar, int i3) {
        this.e = nVar;
        this.f15903a = i3;
        this.f15904b = nVar.g();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15905c < this.f15904b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object e = this.e.e(this.f15905c, this.f15903a);
        this.f15905c++;
        this.f15906d = true;
        return e;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f15906d) {
            throw new IllegalStateException();
        }
        int i3 = this.f15905c - 1;
        this.f15905c = i3;
        this.f15904b--;
        this.f15906d = false;
        this.e.k(i3);
    }
}
