package kotlin.collections;

import java.util.ListIterator;

/* loaded from: classes2.dex */
public final class q implements ListIterator, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15637a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final ListIterator f15638b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15639c;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    public q(s sVar, int i3) {
        this.f15639c = sVar;
        this.f15638b = sVar.f15641a.listIterator(h.k(i3, sVar));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f15637a) {
            case 0:
                ListIterator listIterator = this.f15638b;
                listIterator.add(obj);
                listIterator.previous();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f15637a) {
        }
        return this.f15638b.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f15637a) {
        }
        return this.f15638b.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f15637a) {
        }
        return this.f15638b.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f15637a) {
            case 0:
                return i.c((r) this.f15639c) - this.f15638b.previousIndex();
            default:
                return i.c((s) this.f15639c) - this.f15638b.previousIndex();
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f15637a) {
        }
        return this.f15638b.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        switch (this.f15637a) {
            case 0:
                return i.c((r) this.f15639c) - this.f15638b.nextIndex();
            default:
                return i.c((s) this.f15639c) - this.f15638b.nextIndex();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f15637a) {
            case 0:
                this.f15638b.remove();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f15637a) {
            case 0:
                this.f15638b.set(obj);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public q(r rVar, int i3) {
        this.f15639c = rVar;
        this.f15638b = rVar.f15640a.listIterator(h.k(i3, rVar));
    }
}
