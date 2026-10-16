package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class a extends e2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f11039a;

    /* renamed from: b, reason: collision with root package name */
    public int f11040b;

    public a(int i3, int i10) {
        kb.e(i10, i3);
        this.f11039a = i3;
        this.f11040b = i10;
    }

    public abstract Object a(int i3);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f11040b < this.f11039a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11040b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f11040b;
        this.f11040b = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11040b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f11040b - 1;
        this.f11040b = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11040b - 1;
    }
}
