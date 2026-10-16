package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class x extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f9656a;

    /* renamed from: b, reason: collision with root package name */
    public int f9657b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcs f9658c;

    public x(zzcs zzcsVar, int i3) {
        int size = zzcsVar.size();
        if (i3 < 0 || i3 > size) {
            throw new IndexOutOfBoundsException(oa.d(i3, size, "index"));
        }
        this.f9656a = size;
        this.f9657b = i3;
        this.f9658c = zzcsVar;
    }

    public final Object a(int i3) {
        return this.f9658c.get(i3);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f9657b < this.f9656a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9657b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f9657b;
        this.f9657b = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9657b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f9657b - 1;
        this.f9657b = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9657b - 1;
    }
}
