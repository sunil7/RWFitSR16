package m0;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    /* renamed from: d, reason: collision with root package name */
    public static Object[] f15914d;
    public static int e;

    /* renamed from: f, reason: collision with root package name */
    public static Object[] f15915f;

    /* renamed from: g, reason: collision with root package name */
    public static int f15916g;

    /* renamed from: a, reason: collision with root package name */
    public int[] f15917a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f15918b;

    /* renamed from: c, reason: collision with root package name */
    public int f15919c;

    public k() {
        this.f15917a = d.f15893a;
        this.f15918b = d.f15894b;
        this.f15919c = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (k.class) {
                try {
                    if (f15916g < 10) {
                        objArr[0] = f15915f;
                        objArr[1] = iArr;
                        for (int i10 = (i3 << 1) - 1; i10 >= 2; i10--) {
                            objArr[i10] = null;
                        }
                        f15915f = objArr;
                        f15916g++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (k.class) {
                try {
                    if (e < 10) {
                        objArr[0] = f15914d;
                        objArr[1] = iArr;
                        for (int i11 = (i3 << 1) - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f15914d = objArr;
                        e++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i3) {
        if (i3 == 8) {
            synchronized (k.class) {
                try {
                    Object[] objArr = f15915f;
                    if (objArr != null) {
                        this.f15918b = objArr;
                        f15915f = (Object[]) objArr[0];
                        this.f15917a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f15916g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (k.class) {
                try {
                    Object[] objArr2 = f15914d;
                    if (objArr2 != null) {
                        this.f15918b = objArr2;
                        f15914d = (Object[]) objArr2[0];
                        this.f15917a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f15917a = new int[i3];
        this.f15918b = new Object[i3 << 1];
    }

    public final void b(int i3) {
        int i10 = this.f15919c;
        int[] iArr = this.f15917a;
        if (iArr.length < i3) {
            Object[] objArr = this.f15918b;
            a(i3);
            if (this.f15919c > 0) {
                System.arraycopy(iArr, 0, this.f15917a, 0, i10);
                System.arraycopy(objArr, 0, this.f15918b, 0, i10 << 1);
            }
            c(iArr, objArr, i10);
        }
        if (this.f15919c != i10) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i3 = this.f15919c;
        if (i3 > 0) {
            int[] iArr = this.f15917a;
            Object[] objArr = this.f15918b;
            this.f15917a = d.f15893a;
            this.f15918b = d.f15894b;
            this.f15919c = 0;
            c(iArr, objArr, i3);
        }
        if (this.f15919c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i3, Object obj) {
        int i10 = this.f15919c;
        if (i10 == 0) {
            return -1;
        }
        try {
            int a3 = d.a(this.f15917a, i10, i3);
            if (a3 < 0 || obj.equals(this.f15918b[a3 << 1])) {
                return a3;
            }
            int i11 = a3 + 1;
            while (i11 < i10 && this.f15917a[i11] == i3) {
                if (obj.equals(this.f15918b[i11 << 1])) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = a3 - 1; i12 >= 0 && this.f15917a[i12] == i3; i12--) {
                if (obj.equals(this.f15918b[i12 << 1])) {
                    return i12;
                }
            }
            return ~i11;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f15919c != kVar.f15919c) {
                return false;
            }
            for (int i3 = 0; i3 < this.f15919c; i3++) {
                try {
                    Object h4 = h(i3);
                    Object l3 = l(i3);
                    Object orDefault = kVar.getOrDefault(h4, null);
                    if (l3 == null) {
                        if (orDefault != null || !kVar.containsKey(h4)) {
                            return false;
                        }
                    } else if (!l3.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f15919c != map.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f15919c; i10++) {
                try {
                    Object h10 = h(i10);
                    Object l5 = l(i10);
                    Object obj2 = map.get(h10);
                    if (l5 == null) {
                        if (obj2 != null || !map.containsKey(h10)) {
                            return false;
                        }
                    } else if (!l5.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i3 = this.f15919c;
        if (i3 == 0) {
            return -1;
        }
        try {
            int a3 = d.a(this.f15917a, i3, 0);
            if (a3 < 0 || this.f15918b[a3 << 1] == null) {
                return a3;
            }
            int i10 = a3 + 1;
            while (i10 < i3 && this.f15917a[i10] == 0) {
                if (this.f15918b[i10 << 1] == null) {
                    return i10;
                }
                i10++;
            }
            for (int i11 = a3 - 1; i11 >= 0 && this.f15917a[i11] == 0; i11--) {
                if (this.f15918b[i11 << 1] == null) {
                    return i11;
                }
            }
            return ~i10;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i3 = this.f15919c * 2;
        Object[] objArr = this.f15918b;
        if (obj == null) {
            for (int i10 = 1; i10 < i3; i10 += 2) {
                if (objArr[i10] == null) {
                    return i10 >> 1;
                }
            }
            return -1;
        }
        for (int i11 = 1; i11 < i3; i11 += 2) {
            if (obj.equals(objArr[i11])) {
                return i11 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int e10 = e(obj);
        return e10 >= 0 ? this.f15918b[(e10 << 1) + 1] : obj2;
    }

    public final Object h(int i3) {
        return this.f15918b[i3 << 1];
    }

    public int hashCode() {
        int[] iArr = this.f15917a;
        Object[] objArr = this.f15918b;
        int i3 = this.f15919c;
        int i10 = 1;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i3) {
            Object obj = objArr[i10];
            i12 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i11];
            i11++;
            i10 += 2;
        }
        return i12;
    }

    public void i(b bVar) {
        int i3 = bVar.f15919c;
        b(this.f15919c + i3);
        if (this.f15919c != 0) {
            for (int i10 = 0; i10 < i3; i10++) {
                put(bVar.h(i10), bVar.l(i10));
            }
        } else if (i3 > 0) {
            System.arraycopy(bVar.f15917a, 0, this.f15917a, 0, i3);
            System.arraycopy(bVar.f15918b, 0, this.f15918b, 0, i3 << 1);
            this.f15919c = i3;
        }
    }

    public final boolean isEmpty() {
        return this.f15919c <= 0;
    }

    public Object j(int i3) {
        Object[] objArr = this.f15918b;
        int i10 = i3 << 1;
        Object obj = objArr[i10 + 1];
        int i11 = this.f15919c;
        int i12 = 0;
        if (i11 <= 1) {
            c(this.f15917a, objArr, i11);
            this.f15917a = d.f15893a;
            this.f15918b = d.f15894b;
        } else {
            int i13 = i11 - 1;
            int[] iArr = this.f15917a;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                if (i3 < i13) {
                    int i14 = i3 + 1;
                    int i15 = i13 - i3;
                    System.arraycopy(iArr, i14, iArr, i3, i15);
                    Object[] objArr2 = this.f15918b;
                    System.arraycopy(objArr2, i14 << 1, objArr2, i10, i15 << 1);
                }
                Object[] objArr3 = this.f15918b;
                int i16 = i13 << 1;
                objArr3[i16] = null;
                objArr3[i16 + 1] = null;
            } else {
                a(i11 > 8 ? i11 + (i11 >> 1) : 8);
                if (i11 != this.f15919c) {
                    throw new ConcurrentModificationException();
                }
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f15917a, 0, i3);
                    System.arraycopy(objArr, 0, this.f15918b, 0, i10);
                }
                if (i3 < i13) {
                    int i17 = i3 + 1;
                    int i18 = i13 - i3;
                    System.arraycopy(iArr, i17, this.f15917a, i3, i18);
                    System.arraycopy(objArr, i17 << 1, this.f15918b, i10, i18 << 1);
                }
            }
            i12 = i13;
        }
        if (i11 != this.f15919c) {
            throw new ConcurrentModificationException();
        }
        this.f15919c = i12;
        return obj;
    }

    public Object k(int i3, Object obj) {
        int i10 = (i3 << 1) + 1;
        Object[] objArr = this.f15918b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final Object l(int i3) {
        return this.f15918b[(i3 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i3;
        int d5;
        int i10 = this.f15919c;
        if (obj == null) {
            d5 = f();
            i3 = 0;
        } else {
            int hashCode = obj.hashCode();
            i3 = hashCode;
            d5 = d(hashCode, obj);
        }
        if (d5 >= 0) {
            int i11 = (d5 << 1) + 1;
            Object[] objArr = this.f15918b;
            Object obj3 = objArr[i11];
            objArr[i11] = obj2;
            return obj3;
        }
        int i12 = ~d5;
        int[] iArr = this.f15917a;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            Object[] objArr2 = this.f15918b;
            a(i13);
            if (i10 != this.f15919c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f15917a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f15918b, 0, objArr2.length);
            }
            c(iArr, objArr2, i10);
        }
        if (i12 < i10) {
            int[] iArr3 = this.f15917a;
            int i14 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i14, i10 - i12);
            Object[] objArr3 = this.f15918b;
            System.arraycopy(objArr3, i12 << 1, objArr3, i14 << 1, (this.f15919c - i12) << 1);
        }
        int i15 = this.f15919c;
        if (i10 == i15) {
            int[] iArr4 = this.f15917a;
            if (i12 < iArr4.length) {
                iArr4[i12] = i3;
                Object[] objArr4 = this.f15918b;
                int i16 = i12 << 1;
                objArr4[i16] = obj;
                objArr4[i16 + 1] = obj2;
                this.f15919c = i15 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final Object remove(Object obj) {
        int e10 = e(obj);
        if (e10 >= 0) {
            return j(e10);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int e10 = e(obj);
        if (e10 >= 0) {
            return k(e10, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f15919c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f15919c * 28);
        sb2.append('{');
        for (int i3 = 0; i3 < this.f15919c; i3++) {
            if (i3 > 0) {
                sb2.append(", ");
            }
            Object h4 = h(i3);
            if (h4 != this) {
                sb2.append(h4);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object l3 = l(i3);
            if (l3 != this) {
                sb2.append(l3);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int e10 = e(obj);
        if (e10 < 0) {
            return false;
        }
        Object l3 = l(e10);
        if (obj2 != l3 && (obj2 == null || !obj2.equals(l3))) {
            return false;
        }
        j(e10);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int e10 = e(obj);
        if (e10 < 0) {
            return false;
        }
        Object l3 = l(e10);
        if (l3 != obj2 && (obj2 == null || !obj2.equals(l3))) {
            return false;
        }
        k(e10, obj3);
        return true;
    }

    public k(int i3) {
        if (i3 == 0) {
            this.f15917a = d.f15893a;
            this.f15918b = d.f15894b;
        } else {
            a(i3);
        }
        this.f15919c = 0;
    }
}
