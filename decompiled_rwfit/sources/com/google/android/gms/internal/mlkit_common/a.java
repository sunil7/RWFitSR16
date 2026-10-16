package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ka;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    public final int f9164a;

    /* renamed from: b, reason: collision with root package name */
    public int f9165b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaf f9166c;

    public a(zzaf zzafVar, int i3) {
        int size = zzafVar.size();
        ka.b(i3, size);
        this.f9164a = size;
        this.f9165b = i3;
        this.f9166c = zzafVar;
    }

    public final Object a(int i3) {
        return this.f9166c.get(i3);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f9165b < this.f9164a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9165b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f9165b;
        this.f9165b = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9165b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f9165b - 1;
        this.f9165b = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9165b - 1;
    }
}
