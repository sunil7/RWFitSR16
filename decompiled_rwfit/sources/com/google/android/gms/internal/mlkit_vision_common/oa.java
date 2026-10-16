package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ya;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class oa extends b {

    /* renamed from: a, reason: collision with root package name */
    public final int f10071a;

    /* renamed from: b, reason: collision with root package name */
    public int f10072b;

    /* renamed from: c, reason: collision with root package name */
    public final zzp f10073c;

    public oa(zzp zzpVar, int i3) {
        int size = zzpVar.size();
        if (i3 < 0 || i3 > size) {
            throw new IndexOutOfBoundsException(ya.c(i3, size, "index"));
        }
        this.f10071a = size;
        this.f10072b = i3;
        this.f10073c = zzpVar;
    }

    public final Object a(int i3) {
        return this.f10073c.get(i3);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f10072b < this.f10071a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f10072b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f10072b;
        this.f10072b = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f10072b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f10072b - 1;
        this.f10072b = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f10072b - 1;
    }
}
