package m0;

/* loaded from: classes.dex */
public final class e implements Cloneable {
    public static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    public boolean f15895a = false;

    /* renamed from: b, reason: collision with root package name */
    public long[] f15896b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f15897c;

    /* renamed from: d, reason: collision with root package name */
    public int f15898d;

    public e() {
        int i3;
        int i10 = 4;
        while (true) {
            i3 = 80;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (80 <= i11) {
                i3 = i11;
                break;
            }
            i10++;
        }
        int i12 = i3 / 8;
        this.f15896b = new long[i12];
        this.f15897c = new Object[i12];
    }

    public final void a() {
        int i3 = this.f15898d;
        Object[] objArr = this.f15897c;
        for (int i10 = 0; i10 < i3; i10++) {
            objArr[i10] = null;
        }
        this.f15898d = 0;
        this.f15895a = false;
    }

    public final void b() {
        int i3 = this.f15898d;
        long[] jArr = this.f15896b;
        Object[] objArr = this.f15897c;
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            Object obj = objArr[i11];
            if (obj != e) {
                if (i11 != i10) {
                    jArr[i10] = jArr[i11];
                    objArr[i10] = obj;
                    objArr[i11] = null;
                }
                i10++;
            }
        }
        this.f15895a = false;
        this.f15898d = i10;
    }

    public final Object c(long j4, Long l3) {
        Object obj;
        int b3 = d.b(this.f15896b, this.f15898d, j4);
        return (b3 < 0 || (obj = this.f15897c[b3]) == e) ? l3 : obj;
    }

    public final Object clone() {
        try {
            e eVar = (e) super.clone();
            eVar.f15896b = (long[]) this.f15896b.clone();
            eVar.f15897c = (Object[]) this.f15897c.clone();
            return eVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void d(long j4, Object obj) {
        int b3 = d.b(this.f15896b, this.f15898d, j4);
        if (b3 >= 0) {
            this.f15897c[b3] = obj;
            return;
        }
        int i3 = ~b3;
        int i10 = this.f15898d;
        if (i3 < i10) {
            Object[] objArr = this.f15897c;
            if (objArr[i3] == e) {
                this.f15896b[i3] = j4;
                objArr[i3] = obj;
                return;
            }
        }
        if (this.f15895a && i10 >= this.f15896b.length) {
            b();
            i3 = ~d.b(this.f15896b, this.f15898d, j4);
        }
        int i11 = this.f15898d;
        if (i11 >= this.f15896b.length) {
            int i12 = (i11 + 1) * 8;
            int i13 = 4;
            while (true) {
                if (i13 >= 32) {
                    break;
                }
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
                i13++;
            }
            int i15 = i12 / 8;
            long[] jArr = new long[i15];
            Object[] objArr2 = new Object[i15];
            long[] jArr2 = this.f15896b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f15897c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15896b = jArr;
            this.f15897c = objArr2;
        }
        int i16 = this.f15898d - i3;
        if (i16 != 0) {
            long[] jArr3 = this.f15896b;
            int i17 = i3 + 1;
            System.arraycopy(jArr3, i3, jArr3, i17, i16);
            Object[] objArr4 = this.f15897c;
            System.arraycopy(objArr4, i3, objArr4, i17, this.f15898d - i3);
        }
        this.f15896b[i3] = j4;
        this.f15897c[i3] = obj;
        this.f15898d++;
    }

    public final int e() {
        if (this.f15895a) {
            b();
        }
        return this.f15898d;
    }

    public final Object f(int i3) {
        if (this.f15895a) {
            b();
        }
        return this.f15897c[i3];
    }

    public final String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f15898d * 28);
        sb2.append('{');
        for (int i3 = 0; i3 < this.f15898d; i3++) {
            if (i3 > 0) {
                sb2.append(", ");
            }
            if (this.f15895a) {
                b();
            }
            sb2.append(this.f15896b[i3]);
            sb2.append('=');
            Object f2 = f(i3);
            if (f2 != this) {
                sb2.append(f2);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
