package com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class m implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f11091a;

    /* renamed from: b, reason: collision with root package name */
    public int f11092b;

    /* renamed from: c, reason: collision with root package name */
    public int f11093c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CompactHashSet f11094d;

    public m(CompactHashSet compactHashSet) {
        this.f11094d = compactHashSet;
        this.f11091a = compactHashSet.modCount;
        this.f11092b = compactHashSet.firstEntryIndex();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11092b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        CompactHashSet compactHashSet = this.f11094d;
        if (compactHashSet.modCount != this.f11091a) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f11092b;
        this.f11093c = i3;
        Object obj = compactHashSet.elements[i3];
        this.f11092b = compactHashSet.getSuccessor(i3);
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        long[] jArr;
        CompactHashSet compactHashSet = this.f11094d;
        if (compactHashSet.modCount != this.f11091a) {
            throw new ConcurrentModificationException();
        }
        h.e(this.f11093c >= 0);
        this.f11091a++;
        Object obj = compactHashSet.elements[this.f11093c];
        jArr = compactHashSet.f11003b;
        compactHashSet.a(CompactHashSet.access$100(jArr[this.f11093c]), obj);
        this.f11092b = compactHashSet.adjustAfterRemove(this.f11092b, this.f11093c);
        this.f11093c = -1;
    }
}
