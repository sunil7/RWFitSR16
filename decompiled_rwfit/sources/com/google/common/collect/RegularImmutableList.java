package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.kb;

/* loaded from: classes.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    final transient Object[] array;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f11026c;

    public RegularImmutableList(Object[] objArr, int i3) {
        this.array = objArr;
        this.f11026c = i3;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        Object[] objArr2 = this.array;
        int i10 = this.f11026c;
        System.arraycopy(objArr2, 0, objArr, i3, i10);
        return i3 + i10;
    }

    @Override // java.util.List
    public E get(int i3) {
        kb.d(i3, this.f11026c);
        return (E) this.array[i3];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f11026c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11026c;
    }
}
