package th;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class b implements Iterator, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f18636a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18637b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18638c;

    /* renamed from: d, reason: collision with root package name */
    public int f18639d;

    public b(int i3, int i10, int i11) {
        this.f18636a = i11;
        this.f18637b = i10;
        boolean z5 = false;
        if (i11 <= 0 ? i3 >= i10 : i3 <= i10) {
            z5 = true;
        }
        this.f18638c = z5;
        this.f18639d = z5 ? i3 : i10;
    }

    public final int a() {
        int i3 = this.f18639d;
        if (i3 != this.f18637b) {
            this.f18639d = this.f18636a + i3;
            return i3;
        }
        if (!this.f18638c) {
            throw new NoSuchElementException();
        }
        this.f18638c = false;
        return i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f18638c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
