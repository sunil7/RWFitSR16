package sc;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f18221a;

    /* renamed from: b, reason: collision with root package name */
    public int f18222b;

    /* renamed from: c, reason: collision with root package name */
    public int f18223c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f18224d;

    public b(int i3, int i10) {
        if (i3 < 1 || i10 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f18221a = i3;
        this.f18222b = i10;
        int i11 = (i3 + 31) / 32;
        this.f18223c = i11;
        this.f18224d = new int[i11 * i10];
    }

    public final void a(int i3, int i10) {
        int i11 = (i3 / 32) + (i10 * this.f18223c);
        int[] iArr = this.f18224d;
        iArr[i11] = (1 << (i3 & 31)) ^ iArr[i11];
    }

    public final boolean b(int i3, int i10) {
        return ((this.f18224d[(i3 / 32) + (i10 * this.f18223c)] >>> (i3 & 31)) & 1) != 0;
    }

    public final int[] c() {
        int length = this.f18224d.length - 1;
        while (length >= 0 && this.f18224d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i3 = this.f18223c;
        int i10 = length / i3;
        int i11 = (length % i3) * 32;
        int i12 = 31;
        while ((this.f18224d[length] >>> i12) == 0) {
            i12--;
        }
        return new int[]{i11 + i12, i10};
    }

    public final Object clone() {
        int i3 = this.f18221a;
        int i10 = this.f18222b;
        int i11 = this.f18223c;
        int[] iArr = (int[]) this.f18224d.clone();
        b bVar = new b();
        bVar.f18221a = i3;
        bVar.f18222b = i10;
        bVar.f18223c = i11;
        bVar.f18224d = iArr;
        return bVar;
    }

    public final a d(a aVar, int i3) {
        int i10 = aVar.f18220b;
        int i11 = this.f18221a;
        if (i10 < i11) {
            aVar = new a(i11);
        } else {
            int length = aVar.f18219a.length;
            for (int i12 = 0; i12 < length; i12++) {
                aVar.f18219a[i12] = 0;
            }
        }
        int i13 = i3 * this.f18223c;
        for (int i14 = 0; i14 < this.f18223c; i14++) {
            aVar.f18219a[(i14 * 32) / 32] = this.f18224d[i13 + i14];
        }
        return aVar;
    }

    public final int[] e() {
        int[] iArr;
        int i3 = 0;
        int i10 = 0;
        while (true) {
            iArr = this.f18224d;
            if (i10 >= iArr.length || iArr[i10] != 0) {
                break;
            }
            i10++;
        }
        if (i10 == iArr.length) {
            return null;
        }
        int i11 = this.f18223c;
        int i12 = i10 / i11;
        int i13 = (i10 % i11) * 32;
        while ((iArr[i10] << (31 - i3)) == 0) {
            i3++;
        }
        return new int[]{i13 + i3, i12};
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f18221a == bVar.f18221a && this.f18222b == bVar.f18222b && this.f18223c == bVar.f18223c && Arrays.equals(this.f18224d, bVar.f18224d);
    }

    public final void f() {
        a aVar = new a(this.f18221a);
        a aVar2 = new a(this.f18221a);
        int i3 = (this.f18222b + 1) / 2;
        for (int i10 = 0; i10 < i3; i10++) {
            aVar = d(aVar, i10);
            int i11 = (this.f18222b - 1) - i10;
            aVar2 = d(aVar2, i11);
            aVar.i();
            aVar2.i();
            int[] iArr = aVar2.f18219a;
            int[] iArr2 = this.f18224d;
            int i12 = this.f18223c;
            System.arraycopy(iArr, 0, iArr2, i10 * i12, i12);
            int[] iArr3 = aVar.f18219a;
            int[] iArr4 = this.f18224d;
            int i13 = this.f18223c;
            System.arraycopy(iArr3, 0, iArr4, i11 * i13, i13);
        }
    }

    public final void g() {
        int i3 = this.f18222b;
        int i10 = this.f18221a;
        int i11 = (i3 + 31) / 32;
        int[] iArr = new int[i11 * i10];
        for (int i12 = 0; i12 < this.f18222b; i12++) {
            for (int i13 = 0; i13 < this.f18221a; i13++) {
                if (((this.f18224d[(i13 / 32) + (this.f18223c * i12)] >>> (i13 & 31)) & 1) != 0) {
                    int i14 = (i12 / 32) + (((i10 - 1) - i13) * i11);
                    iArr[i14] = iArr[i14] | (1 << (i12 & 31));
                }
            }
        }
        this.f18221a = i3;
        this.f18222b = i10;
        this.f18223c = i11;
        this.f18224d = iArr;
    }

    public final void h(int i3, int i10) {
        int i11 = (i3 / 32) + (i10 * this.f18223c);
        int[] iArr = this.f18224d;
        iArr[i11] = (1 << (i3 & 31)) | iArr[i11];
    }

    public final int hashCode() {
        int i3 = this.f18221a;
        return Arrays.hashCode(this.f18224d) + (((((((i3 * 31) + i3) * 31) + this.f18222b) * 31) + this.f18223c) * 31);
    }

    public final void i(int i3, int i10, int i11, int i12) {
        if (i10 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i12 < 1 || i11 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i13 = i11 + i3;
        int i14 = i12 + i10;
        if (i14 > this.f18222b || i13 > this.f18221a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i10 < i14) {
            int i15 = this.f18223c * i10;
            for (int i16 = i3; i16 < i13; i16++) {
                int[] iArr = this.f18224d;
                int i17 = (i16 / 32) + i15;
                iArr[i17] = iArr[i17] | (1 << (i16 & 31));
            }
            i10++;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((this.f18221a + 1) * this.f18222b);
        for (int i3 = 0; i3 < this.f18222b; i3++) {
            for (int i10 = 0; i10 < this.f18221a; i10++) {
                sb2.append(b(i10, i3) ? "X " : "  ");
            }
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
