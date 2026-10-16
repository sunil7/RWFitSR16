package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class f0 extends q implements RandomAccess, p0 {

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f9780d = new f0(new float[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public float[] f9781b;

    /* renamed from: c, reason: collision with root package name */
    public int f9782c;

    public f0(float[] fArr, int i3, boolean z5) {
        super(z5);
        this.f9781b = fArr;
        this.f9782c = i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i10;
        float floatValue = ((Float) obj).floatValue();
        a();
        if (i3 < 0 || i3 > (i10 = this.f9782c)) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, this.f9782c, "Index:", ", Size:"));
        }
        int i11 = i3 + 1;
        float[] fArr = this.f9781b;
        if (i10 < fArr.length) {
            System.arraycopy(fArr, i3, fArr, i11, i10 - i3);
        } else {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            System.arraycopy(this.f9781b, i3, fArr2, i11, this.f9782c - i3);
            this.f9781b = fArr2;
        }
        this.f9781b[i3] = floatValue;
        this.f9782c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = s0.f9827a;
        collection.getClass();
        if (!(collection instanceof f0)) {
            return super.addAll(collection);
        }
        f0 f0Var = (f0) collection;
        int i3 = f0Var.f9782c;
        if (i3 == 0) {
            return false;
        }
        int i10 = this.f9782c;
        if (SubsamplingScaleImageView.TILE_SIZE_AUTO - i10 < i3) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i3;
        float[] fArr = this.f9781b;
        if (i11 > fArr.length) {
            this.f9781b = Arrays.copyOf(fArr, i11);
        }
        System.arraycopy(f0Var.f9781b, 0, this.f9781b, this.f9782c, f0Var.f9782c);
        this.f9782c = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0
    public final r0 b(int i3) {
        if (i3 >= this.f9782c) {
            return new f0(Arrays.copyOf(this.f9781b, i3), this.f9782c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void c(float f2) {
        a();
        int i3 = this.f9782c;
        float[] fArr = this.f9781b;
        if (i3 == fArr.length) {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            this.f9781b = fArr2;
        }
        float[] fArr3 = this.f9781b;
        int i10 = this.f9782c;
        this.f9782c = i10 + 1;
        fArr3[i10] = f2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i3) {
        if (i3 < 0 || i3 >= this.f9782c) {
            throw new IndexOutOfBoundsException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(i3, this.f9782c, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return super.equals(obj);
        }
        f0 f0Var = (f0) obj;
        if (this.f9782c != f0Var.f9782c) {
            return false;
        }
        float[] fArr = f0Var.f9781b;
        for (int i3 = 0; i3 < this.f9782c; i3++) {
            if (Float.floatToIntBits(this.f9781b[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        d(i3);
        return Float.valueOf(this.f9781b[i3]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i10 = 0; i10 < this.f9782c; i10++) {
            i3 = (i3 * 31) + Float.floatToIntBits(this.f9781b[i10]);
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i3 = this.f9782c;
        for (int i10 = 0; i10 < i3; i10++) {
            if (this.f9781b[i10] == floatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.q, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        a();
        d(i3);
        float[] fArr = this.f9781b;
        float f2 = fArr[i3];
        if (i3 < this.f9782c - 1) {
            System.arraycopy(fArr, i3 + 1, fArr, i3, (r2 - i3) - 1);
        }
        this.f9782c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i3, int i10) {
        a();
        if (i10 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f9781b;
        System.arraycopy(fArr, i10, fArr, i3, this.f9782c - i10);
        this.f9782c -= i10 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        a();
        d(i3);
        float[] fArr = this.f9781b;
        float f2 = fArr[i3];
        fArr[i3] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9782c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        c(((Float) obj).floatValue());
        return true;
    }
}
