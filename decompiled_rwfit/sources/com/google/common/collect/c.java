package com.google.common.collect;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class c implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11047a;

    /* renamed from: b, reason: collision with root package name */
    public int f11048b;

    /* renamed from: c, reason: collision with root package name */
    public int f11049c;

    /* renamed from: d, reason: collision with root package name */
    public int f11050d;
    public final /* synthetic */ Serializable e;

    public c(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        this.f11047a = 0;
        this.e = abstractMapBasedMultiset;
        w1 w1Var = abstractMapBasedMultiset.backingMap;
        this.f11048b = w1Var.f11141c == 0 ? -1 : 0;
        this.f11049c = -1;
        this.f11050d = w1Var.f11142d;
    }

    public abstract Object a(int i3);

    public abstract Object b(int i3);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f11047a) {
            case 0:
                if (((AbstractMapBasedMultiset) this.e).backingMap.f11142d == this.f11050d) {
                    return this.f11048b >= 0;
                }
                throw new ConcurrentModificationException();
            default:
                return this.f11049c >= 0;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f11047a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object b3 = b(this.f11048b);
                int i3 = this.f11048b;
                this.f11049c = i3;
                int i10 = i3 + 1;
                if (i10 >= ((AbstractMapBasedMultiset) this.e).backingMap.f11141c) {
                    i10 = -1;
                }
                this.f11048b = i10;
                return b3;
            default:
                CompactHashMap compactHashMap = (CompactHashMap) this.e;
                if (compactHashMap.modCount != this.f11048b) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i11 = this.f11049c;
                this.f11050d = i11;
                Object a3 = a(i11);
                this.f11049c = compactHashMap.getSuccessor(this.f11049c);
                return a3;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f11047a) {
            case 0:
                AbstractMapBasedMultiset abstractMapBasedMultiset = (AbstractMapBasedMultiset) this.e;
                if (abstractMapBasedMultiset.backingMap.f11142d != this.f11050d) {
                    throw new ConcurrentModificationException();
                }
                h.e(this.f11049c != -1);
                abstractMapBasedMultiset.size -= abstractMapBasedMultiset.backingMap.h(this.f11049c);
                w1 w1Var = abstractMapBasedMultiset.backingMap;
                int i3 = this.f11048b;
                w1Var.getClass();
                this.f11048b = i3 - 1;
                this.f11049c = -1;
                this.f11050d = abstractMapBasedMultiset.backingMap.f11142d;
                return;
            default:
                CompactHashMap compactHashMap = (CompactHashMap) this.e;
                if (compactHashMap.modCount != this.f11048b) {
                    throw new ConcurrentModificationException();
                }
                h.e(this.f11050d >= 0);
                this.f11048b++;
                compactHashMap.b(compactHashMap.keys[r1], (int) (compactHashMap.entries[this.f11050d] >>> 32));
                this.f11049c = compactHashMap.adjustAfterRemove(this.f11049c, this.f11050d);
                this.f11050d = -1;
                return;
        }
    }

    public c(CompactHashMap compactHashMap) {
        this.f11047a = 1;
        this.e = compactHashMap;
        this.f11048b = compactHashMap.modCount;
        this.f11049c = compactHashMap.firstEntryIndex();
        this.f11050d = -1;
    }
}
