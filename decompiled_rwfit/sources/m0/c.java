package m0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class c implements Collection, Set {
    public static final int[] e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public static final Object[] f15884f = new Object[0];

    /* renamed from: g, reason: collision with root package name */
    public static Object[] f15885g;

    /* renamed from: h, reason: collision with root package name */
    public static int f15886h;

    /* renamed from: i, reason: collision with root package name */
    public static Object[] f15887i;

    /* renamed from: j, reason: collision with root package name */
    public static int f15888j;

    /* renamed from: a, reason: collision with root package name */
    public int[] f15889a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f15890b;

    /* renamed from: c, reason: collision with root package name */
    public int f15891c;

    /* renamed from: d, reason: collision with root package name */
    public a f15892d;

    public c(int i3) {
        if (i3 == 0) {
            this.f15889a = e;
            this.f15890b = f15884f;
        } else {
            a(i3);
        }
        this.f15891c = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                try {
                    if (f15888j < 10) {
                        objArr[0] = f15887i;
                        objArr[1] = iArr;
                        for (int i10 = i3 - 1; i10 >= 2; i10--) {
                            objArr[i10] = null;
                        }
                        f15887i = objArr;
                        f15888j++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c.class) {
                try {
                    if (f15886h < 10) {
                        objArr[0] = f15885g;
                        objArr[1] = iArr;
                        for (int i11 = i3 - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f15885g = objArr;
                        f15886h++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i3) {
        if (i3 == 8) {
            synchronized (c.class) {
                try {
                    Object[] objArr = f15887i;
                    if (objArr != null) {
                        this.f15890b = objArr;
                        f15887i = (Object[]) objArr[0];
                        this.f15889a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f15888j--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (c.class) {
                try {
                    Object[] objArr2 = f15885g;
                    if (objArr2 != null) {
                        this.f15890b = objArr2;
                        f15885g = (Object[]) objArr2[0];
                        this.f15889a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f15886h--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f15889a = new int[i3];
        this.f15890b = new Object[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i3;
        int d5;
        if (obj == null) {
            d5 = e();
            i3 = 0;
        } else {
            int hashCode = obj.hashCode();
            i3 = hashCode;
            d5 = d(hashCode, obj);
        }
        if (d5 >= 0) {
            return false;
        }
        int i10 = ~d5;
        int i11 = this.f15891c;
        int[] iArr = this.f15889a;
        if (i11 >= iArr.length) {
            int i12 = 8;
            if (i11 >= 8) {
                i12 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i12 = 4;
            }
            Object[] objArr = this.f15890b;
            a(i12);
            int[] iArr2 = this.f15889a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f15890b, 0, objArr.length);
            }
            c(iArr, objArr, this.f15891c);
        }
        int i13 = this.f15891c;
        if (i10 < i13) {
            int[] iArr3 = this.f15889a;
            int i14 = i10 + 1;
            System.arraycopy(iArr3, i10, iArr3, i14, i13 - i10);
            Object[] objArr2 = this.f15890b;
            System.arraycopy(objArr2, i10, objArr2, i14, this.f15891c - i10);
        }
        this.f15889a[i10] = i3;
        this.f15890b[i10] = obj;
        this.f15891c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f15891c;
        int[] iArr = this.f15889a;
        boolean z5 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f15890b;
            a(size);
            int i3 = this.f15891c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f15889a, 0, i3);
                System.arraycopy(objArr, 0, this.f15890b, 0, this.f15891c);
            }
            c(iArr, objArr, this.f15891c);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            z5 |= add(it.next());
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i3 = this.f15891c;
        if (i3 != 0) {
            c(this.f15889a, this.f15890b, i3);
            this.f15889a = e;
            this.f15890b = f15884f;
            this.f15891c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? e() : d(obj.hashCode(), obj)) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int d(int i3, Object obj) {
        int i10 = this.f15891c;
        if (i10 == 0) {
            return -1;
        }
        int a3 = d.a(this.f15889a, i10, i3);
        if (a3 < 0 || obj.equals(this.f15890b[a3])) {
            return a3;
        }
        int i11 = a3 + 1;
        while (i11 < i10 && this.f15889a[i11] == i3) {
            if (obj.equals(this.f15890b[i11])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = a3 - 1; i12 >= 0 && this.f15889a[i12] == i3; i12--) {
            if (obj.equals(this.f15890b[i12])) {
                return i12;
            }
        }
        return ~i11;
    }

    public final int e() {
        int i3 = this.f15891c;
        if (i3 == 0) {
            return -1;
        }
        int a3 = d.a(this.f15889a, i3, 0);
        if (a3 < 0 || this.f15890b[a3] == null) {
            return a3;
        }
        int i10 = a3 + 1;
        while (i10 < i3 && this.f15889a[i10] == 0) {
            if (this.f15890b[i10] == null) {
                return i10;
            }
            i10++;
        }
        for (int i11 = a3 - 1; i11 >= 0 && this.f15889a[i11] == 0; i11--) {
            if (this.f15890b[i11] == null) {
                return i11;
            }
        }
        return ~i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f15891c != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f15891c; i3++) {
                try {
                    if (!set.contains(this.f15890b[i3])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        Object[] objArr = this.f15890b;
        Object obj = objArr[i3];
        int i10 = this.f15891c;
        if (i10 <= 1) {
            c(this.f15889a, objArr, i10);
            this.f15889a = e;
            this.f15890b = f15884f;
            this.f15891c = 0;
            return;
        }
        int[] iArr = this.f15889a;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            int i11 = i10 - 1;
            this.f15891c = i11;
            if (i3 < i11) {
                int i12 = i3 + 1;
                System.arraycopy(iArr, i12, iArr, i3, i11 - i3);
                Object[] objArr2 = this.f15890b;
                System.arraycopy(objArr2, i12, objArr2, i3, this.f15891c - i3);
            }
            this.f15890b[this.f15891c] = null;
            return;
        }
        a(i10 > 8 ? i10 + (i10 >> 1) : 8);
        this.f15891c--;
        if (i3 > 0) {
            System.arraycopy(iArr, 0, this.f15889a, 0, i3);
            System.arraycopy(objArr, 0, this.f15890b, 0, i3);
        }
        int i13 = this.f15891c;
        if (i3 < i13) {
            int i14 = i3 + 1;
            System.arraycopy(iArr, i14, this.f15889a, i3, i13 - i3);
            System.arraycopy(objArr, i14, this.f15890b, i3, this.f15891c - i3);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f15889a;
        int i3 = this.f15891c;
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            i10 += iArr[i11];
        }
        return i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f15891c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f15892d == null) {
            this.f15892d = new a(this, 1);
        }
        a aVar = this.f15892d;
        if (((h) aVar.f195b) == null) {
            aVar.f195b = new h(aVar, 1);
        }
        return ((h) aVar.f195b).iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int e10 = obj == null ? e() : d(obj.hashCode(), obj);
        if (e10 < 0) {
            return false;
        }
        f(e10);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= remove(it.next());
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z5 = false;
        for (int i3 = this.f15891c - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.f15890b[i3])) {
                f(i3);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f15891c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i3 = this.f15891c;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f15890b, 0, objArr, 0, i3);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f15891c * 14);
        sb2.append('{');
        for (int i3 = 0; i3 < this.f15891c; i3++) {
            if (i3 > 0) {
                sb2.append(", ");
            }
            Object obj = this.f15890b[i3];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f15891c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f15891c);
        }
        System.arraycopy(this.f15890b, 0, objArr, 0, this.f15891c);
        int length = objArr.length;
        int i3 = this.f15891c;
        if (length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
