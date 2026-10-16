package uc;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f19046a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f19047b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f19046a = aVar;
        int length = iArr.length;
        int i3 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f19047b = iArr;
            return;
        }
        while (i3 < length && iArr[i3] == 0) {
            i3++;
        }
        if (i3 == length) {
            this.f19047b = new int[]{0};
            return;
        }
        int i10 = length - i3;
        int[] iArr2 = new int[i10];
        this.f19047b = iArr2;
        System.arraycopy(iArr, i3, iArr2, 0, i10);
    }

    public final b a(b bVar) {
        a aVar = bVar.f19046a;
        a aVar2 = this.f19046a;
        if (!aVar2.equals(aVar)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e()) {
            return bVar;
        }
        if (bVar.e()) {
            return this;
        }
        int[] iArr = this.f19047b;
        int length = iArr.length;
        int[] iArr2 = bVar.f19047b;
        if (length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length2 = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length2);
        for (int i3 = length2; i3 < iArr.length; i3++) {
            iArr3[i3] = iArr2[i3 - length2] ^ iArr[i3];
        }
        return new b(aVar2, iArr3);
    }

    public final int b(int i3) {
        if (i3 == 0) {
            return c(0);
        }
        int[] iArr = this.f19047b;
        if (i3 != 1) {
            int i10 = iArr[0];
            int length = iArr.length;
            for (int i11 = 1; i11 < length; i11++) {
                i10 = this.f19046a.c(i3, i10) ^ iArr[i11];
            }
            return i10;
        }
        int i12 = 0;
        for (int i13 : iArr) {
            a aVar = a.f19032h;
            i12 ^= i13;
        }
        return i12;
    }

    public final int c(int i3) {
        return this.f19047b[(r0.length - 1) - i3];
    }

    public final int d() {
        return this.f19047b.length - 1;
    }

    public final boolean e() {
        return this.f19047b[0] == 0;
    }

    public final b f(int i3) {
        a aVar = this.f19046a;
        if (i3 == 0) {
            return aVar.f19042c;
        }
        if (i3 == 1) {
            return this;
        }
        int[] iArr = this.f19047b;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = aVar.c(iArr[i10], i3);
        }
        return new b(aVar, iArr2);
    }

    public final b g(b bVar) {
        a aVar = bVar.f19046a;
        a aVar2 = this.f19046a;
        if (!aVar2.equals(aVar)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e() || bVar.e()) {
            return aVar2.f19042c;
        }
        int[] iArr = this.f19047b;
        int length = iArr.length;
        int[] iArr2 = bVar.f19047b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i3 = 0; i3 < length; i3++) {
            int i10 = iArr[i3];
            for (int i11 = 0; i11 < length2; i11++) {
                int i12 = i3 + i11;
                iArr3[i12] = iArr3[i12] ^ aVar2.c(i10, iArr2[i11]);
            }
        }
        return new b(aVar2, iArr3);
    }

    public final b h(int i3, int i10) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        a aVar = this.f19046a;
        if (i10 == 0) {
            return aVar.f19042c;
        }
        int[] iArr = this.f19047b;
        int length = iArr.length;
        int[] iArr2 = new int[i3 + length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr2[i11] = aVar.c(iArr[i11], i10);
        }
        return new b(aVar, iArr2);
    }

    public final String toString() {
        if (e()) {
            return "0";
        }
        StringBuilder sb2 = new StringBuilder(d() * 8);
        for (int d5 = d(); d5 >= 0; d5--) {
            int c9 = c(d5);
            if (c9 != 0) {
                if (c9 < 0) {
                    if (d5 == d()) {
                        sb2.append("-");
                    } else {
                        sb2.append(" - ");
                    }
                    c9 = -c9;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (d5 == 0 || c9 != 1) {
                    a aVar = this.f19046a;
                    if (c9 == 0) {
                        aVar.getClass();
                        throw new IllegalArgumentException();
                    }
                    int i3 = aVar.f19041b[c9];
                    if (i3 == 0) {
                        sb2.append('1');
                    } else if (i3 == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(i3);
                    }
                }
                if (d5 != 0) {
                    if (d5 == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(d5);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
