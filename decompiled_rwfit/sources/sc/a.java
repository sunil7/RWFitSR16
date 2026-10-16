package sc;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f18218c = new int[0];

    /* renamed from: a, reason: collision with root package name */
    public int[] f18219a;

    /* renamed from: b, reason: collision with root package name */
    public int f18220b;

    public a() {
        this.f18220b = 0;
        this.f18219a = f18218c;
    }

    public final void a(boolean z5) {
        c(this.f18220b + 1);
        if (z5) {
            int[] iArr = this.f18219a;
            int i3 = this.f18220b;
            int i10 = i3 / 32;
            iArr[i10] = (1 << (i3 & 31)) | iArr[i10];
        }
        this.f18220b++;
    }

    public final void b(int i3, int i10) {
        if (i10 < 0 || i10 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        int i11 = this.f18220b;
        c(i11 + i10);
        for (int i12 = i10 - 1; i12 >= 0; i12--) {
            if (((1 << i12) & i3) != 0) {
                int[] iArr = this.f18219a;
                int i13 = i11 / 32;
                iArr[i13] = iArr[i13] | (1 << (i11 & 31));
            }
            i11++;
        }
        this.f18220b = i11;
    }

    public final void c(int i3) {
        if (i3 > this.f18219a.length * 32) {
            int[] iArr = new int[(((int) Math.ceil(i3 / 0.75f)) + 31) / 32];
            int[] iArr2 = this.f18219a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            this.f18219a = iArr;
        }
    }

    public final Object clone() {
        int[] iArr = (int[]) this.f18219a.clone();
        int i3 = this.f18220b;
        a aVar = new a();
        aVar.f18219a = iArr;
        aVar.f18220b = i3;
        return aVar;
    }

    public final boolean d(int i3) {
        return ((1 << (i3 & 31)) & this.f18219a[i3 / 32]) != 0;
    }

    public final int e(int i3) {
        int i10 = this.f18220b;
        if (i3 >= i10) {
            return i10;
        }
        int i11 = i3 / 32;
        int i12 = (-(1 << (i3 & 31))) & this.f18219a[i11];
        while (i12 == 0) {
            i11++;
            int[] iArr = this.f18219a;
            if (i11 == iArr.length) {
                return this.f18220b;
            }
            i12 = iArr[i11];
        }
        return Math.min(Integer.numberOfTrailingZeros(i12) + (i11 * 32), this.f18220b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18220b == aVar.f18220b && Arrays.equals(this.f18219a, aVar.f18219a);
    }

    public final int f(int i3) {
        int i10 = this.f18220b;
        if (i3 >= i10) {
            return i10;
        }
        int i11 = i3 / 32;
        int i12 = (-(1 << (i3 & 31))) & (~this.f18219a[i11]);
        while (i12 == 0) {
            i11++;
            int[] iArr = this.f18219a;
            if (i11 == iArr.length) {
                return this.f18220b;
            }
            i12 = ~iArr[i11];
        }
        return Math.min(Integer.numberOfTrailingZeros(i12) + (i11 * 32), this.f18220b);
    }

    public final int g() {
        return (this.f18220b + 7) / 8;
    }

    public final boolean h(int i3, int i10) {
        if (i10 < i3 || i3 < 0 || i10 > this.f18220b) {
            throw new IllegalArgumentException();
        }
        if (i10 != i3) {
            int i11 = i10 - 1;
            int i12 = i3 / 32;
            int i13 = i11 / 32;
            int i14 = i12;
            while (i14 <= i13) {
                if ((((2 << (i14 >= i13 ? 31 & i11 : 31)) - (1 << (i14 > i12 ? 0 : i3 & 31))) & this.f18219a[i14]) != 0) {
                    return false;
                }
                i14++;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f18219a) + (this.f18220b * 31);
    }

    public final void i() {
        int[] iArr = new int[this.f18219a.length];
        int i3 = (this.f18220b - 1) / 32;
        int i10 = i3 + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i3 - i11] = Integer.reverse(this.f18219a[i11]);
        }
        int i12 = this.f18220b;
        int i13 = i10 * 32;
        if (i12 != i13) {
            int i14 = i13 - i12;
            int i15 = iArr[0] >>> i14;
            for (int i16 = 1; i16 < i10; i16++) {
                int i17 = iArr[i16];
                iArr[i16 - 1] = i15 | (i17 << (32 - i14));
                i15 = i17 >>> i14;
            }
            iArr[i3] = i15;
        }
        this.f18219a = iArr;
    }

    public final void j(int i3) {
        int[] iArr = this.f18219a;
        int i10 = i3 / 32;
        iArr[i10] = (1 << (i3 & 31)) | iArr[i10];
    }

    public final String toString() {
        int i3 = this.f18220b;
        StringBuilder sb2 = new StringBuilder((i3 / 8) + i3 + 1);
        for (int i10 = 0; i10 < this.f18220b; i10++) {
            if ((i10 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(d(i10) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public a(int i3) {
        this.f18220b = i3;
        this.f18219a = new int[(i3 + 31) / 32];
    }
}
