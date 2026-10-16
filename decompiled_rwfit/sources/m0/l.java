package m0;

/* loaded from: classes.dex */
public final class l implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f15920d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public int[] f15921a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f15922b;

    /* renamed from: c, reason: collision with root package name */
    public int f15923c;

    public l() {
        int i3;
        int i10 = 4;
        while (true) {
            i3 = 40;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (40 <= i11) {
                i3 = i11;
                break;
            }
            i10++;
        }
        int i12 = i3 / 4;
        this.f15921a = new int[i12];
        this.f15922b = new Object[i12];
    }

    public final void a(int i3, Object obj) {
        int i10 = this.f15923c;
        if (i10 != 0 && i3 <= this.f15921a[i10 - 1]) {
            c(i3, obj);
            return;
        }
        if (i10 >= this.f15921a.length) {
            int i11 = (i10 + 1) * 4;
            int i12 = 4;
            while (true) {
                if (i12 >= 32) {
                    break;
                }
                int i13 = (1 << i12) - 12;
                if (i11 <= i13) {
                    i11 = i13;
                    break;
                }
                i12++;
            }
            int i14 = i11 / 4;
            int[] iArr = new int[i14];
            Object[] objArr = new Object[i14];
            int[] iArr2 = this.f15921a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f15922b;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f15921a = iArr;
            this.f15922b = objArr;
        }
        this.f15921a[i10] = i3;
        this.f15922b[i10] = obj;
        this.f15923c = i10 + 1;
    }

    public final Object b(int i3, Integer num) {
        Object obj;
        int a3 = d.a(this.f15921a, this.f15923c, i3);
        return (a3 < 0 || (obj = this.f15922b[a3]) == f15920d) ? num : obj;
    }

    public final void c(int i3, Object obj) {
        int a3 = d.a(this.f15921a, this.f15923c, i3);
        if (a3 >= 0) {
            this.f15922b[a3] = obj;
            return;
        }
        int i10 = ~a3;
        int i11 = this.f15923c;
        if (i10 < i11) {
            Object[] objArr = this.f15922b;
            if (objArr[i10] == f15920d) {
                this.f15921a[i10] = i3;
                objArr[i10] = obj;
                return;
            }
        }
        if (i11 >= this.f15921a.length) {
            int i12 = (i11 + 1) * 4;
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
            int i15 = i12 / 4;
            int[] iArr = new int[i15];
            Object[] objArr2 = new Object[i15];
            int[] iArr2 = this.f15921a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f15922b;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15921a = iArr;
            this.f15922b = objArr2;
        }
        int i16 = this.f15923c - i10;
        if (i16 != 0) {
            int[] iArr3 = this.f15921a;
            int i17 = i10 + 1;
            System.arraycopy(iArr3, i10, iArr3, i17, i16);
            Object[] objArr4 = this.f15922b;
            System.arraycopy(objArr4, i10, objArr4, i17, this.f15923c - i10);
        }
        this.f15921a[i10] = i3;
        this.f15922b[i10] = obj;
        this.f15923c++;
    }

    public final Object clone() {
        try {
            l lVar = (l) super.clone();
            lVar.f15921a = (int[]) this.f15921a.clone();
            lVar.f15922b = (Object[]) this.f15922b.clone();
            return lVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final String toString() {
        int i3 = this.f15923c;
        if (i3 <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i3 * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f15923c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(this.f15921a[i10]);
            sb2.append('=');
            Object obj = this.f15922b[i10];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
