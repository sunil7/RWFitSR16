package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class h1 extends q implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final h1 f9791d = new h1(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public Object[] f9792b;

    /* renamed from: c, reason: collision with root package name */
    public int f9793c;

    public h1(Object[] objArr, int i3, boolean z5) {
        super(z5);
        this.f9792b = objArr;
        this.f9793c = i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i10;
        a();
        if (i3 < 0 || i3 > (i10 = this.f9793c)) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, this.f9793c, "Index:", ", Size:"));
        }
        int i11 = i3 + 1;
        Object[] objArr = this.f9792b;
        if (i10 < objArr.length) {
            System.arraycopy(objArr, i3, objArr, i11, i10 - i3);
        } else {
            Object[] objArr2 = new Object[((i10 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i3);
            System.arraycopy(this.f9792b, i3, objArr2, i11, this.f9793c - i3);
            this.f9792b = objArr2;
        }
        this.f9792b[i3] = obj;
        this.f9793c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0
    public final /* bridge */ /* synthetic */ r0 b(int i3) {
        if (i3 >= this.f9793c) {
            return new h1(Arrays.copyOf(this.f9792b, i3), this.f9793c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void c(int i3) {
        if (i3 < 0 || i3 >= this.f9793c) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, this.f9793c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        c(i3);
        return this.f9792b[i3];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        a();
        c(i3);
        Object[] objArr = this.f9792b;
        Object obj = objArr[i3];
        if (i3 < this.f9793c - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.f9793c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        a();
        c(i3);
        Object[] objArr = this.f9792b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9793c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i3 = this.f9793c;
        Object[] objArr = this.f9792b;
        if (i3 == objArr.length) {
            this.f9792b = Arrays.copyOf(objArr, ((i3 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f9792b;
        int i10 = this.f9793c;
        this.f9793c = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
