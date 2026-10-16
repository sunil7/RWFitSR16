package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class m0 extends q implements RandomAccess, q0 {

    /* renamed from: d, reason: collision with root package name */
    public static final m0 f9803d = new m0(new int[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public int[] f9804b;

    /* renamed from: c, reason: collision with root package name */
    public int f9805c;

    public m0(int[] iArr, int i3, boolean z5) {
        super(z5);
        this.f9804b = iArr;
        this.f9805c = i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i10;
        int intValue = ((Integer) obj).intValue();
        a();
        if (i3 < 0 || i3 > (i10 = this.f9805c)) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, this.f9805c, "Index:", ", Size:"));
        }
        int i11 = i3 + 1;
        int[] iArr = this.f9804b;
        if (i10 < iArr.length) {
            System.arraycopy(iArr, i3, iArr, i11, i10 - i3);
        } else {
            int[] iArr2 = new int[((i10 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.f9804b, i3, iArr2, i11, this.f9805c - i3);
            this.f9804b = iArr2;
        }
        this.f9804b[i3] = intValue;
        this.f9805c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = s0.f9827a;
        collection.getClass();
        if (!(collection instanceof m0)) {
            return super.addAll(collection);
        }
        m0 m0Var = (m0) collection;
        int i3 = m0Var.f9805c;
        if (i3 == 0) {
            return false;
        }
        int i10 = this.f9805c;
        if (SubsamplingScaleImageView.TILE_SIZE_AUTO - i10 < i3) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i3;
        int[] iArr = this.f9804b;
        if (i11 > iArr.length) {
            this.f9804b = Arrays.copyOf(iArr, i11);
        }
        System.arraycopy(m0Var.f9804b, 0, this.f9804b, this.f9805c, m0Var.f9805c);
        this.f9805c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0
    public final /* bridge */ /* synthetic */ r0 b(int i3) {
        if (i3 >= this.f9805c) {
            return new m0(Arrays.copyOf(this.f9804b, i3), this.f9805c, true);
        }
        throw new IllegalArgumentException();
    }

    public final int c(int i3) {
        e(i3);
        return this.f9804b[i3];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i3) {
        a();
        int i10 = this.f9805c;
        int[] iArr = this.f9804b;
        if (i10 == iArr.length) {
            int[] iArr2 = new int[((i10 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            this.f9804b = iArr2;
        }
        int[] iArr3 = this.f9804b;
        int i11 = this.f9805c;
        this.f9805c = i11 + 1;
        iArr3[i11] = i3;
    }

    public final void e(int i3) {
        if (i3 < 0 || i3 >= this.f9805c) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, this.f9805c, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return super.equals(obj);
        }
        m0 m0Var = (m0) obj;
        if (this.f9805c != m0Var.f9805c) {
            return false;
        }
        int[] iArr = m0Var.f9804b;
        for (int i3 = 0; i3 < this.f9805c; i3++) {
            if (this.f9804b[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        e(i3);
        return Integer.valueOf(this.f9804b[i3]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i10 = 0; i10 < this.f9805c; i10++) {
            i3 = (i3 * 31) + this.f9804b[i10];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i3 = this.f9805c;
        for (int i10 = 0; i10 < i3; i10++) {
            if (this.f9804b[i10] == intValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        a();
        e(i3);
        int[] iArr = this.f9804b;
        int i10 = iArr[i3];
        if (i3 < this.f9805c - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.f9805c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i3, int i10) {
        a();
        if (i10 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f9804b;
        System.arraycopy(iArr, i10, iArr, i3, this.f9805c - i10);
        this.f9805c -= i10 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        int intValue = ((Integer) obj).intValue();
        a();
        e(i3);
        int[] iArr = this.f9804b;
        int i10 = iArr[i3];
        iArr[i3] = intValue;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9805c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
