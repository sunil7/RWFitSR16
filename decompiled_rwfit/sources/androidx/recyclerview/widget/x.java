package androidx.recyclerview.widget;

import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2797a;

    /* renamed from: b, reason: collision with root package name */
    public int f2798b;

    /* renamed from: c, reason: collision with root package name */
    public int f2799c;

    /* renamed from: d, reason: collision with root package name */
    public int f2800d;
    public Object e;

    public /* synthetic */ x(int i3) {
        this.f2797a = i3;
    }

    public void a(ug.b bVar) {
        Object obj;
        Object obj2;
        Object[] objArr = (Object[]) this.e;
        int i3 = this.f2798b;
        int hashCode = bVar.hashCode() * (-1640531527);
        int i10 = (hashCode ^ (hashCode >>> 16)) & i3;
        Object obj3 = objArr[i10];
        if (obj3 != null) {
            if (obj3.equals(bVar)) {
                return;
            }
            do {
                i10 = (i10 + 1) & i3;
                obj2 = objArr[i10];
                if (obj2 == null) {
                }
            } while (!obj2.equals(bVar));
            return;
        }
        objArr[i10] = bVar;
        int i11 = this.f2799c + 1;
        this.f2799c = i11;
        if (i11 < this.f2800d) {
            return;
        }
        Object[] objArr2 = (Object[]) this.e;
        int length = objArr2.length;
        int i12 = length << 1;
        int i13 = i12 - 1;
        Object[] objArr3 = new Object[i12];
        while (true) {
            int i14 = i11 - 1;
            if (i11 == 0) {
                this.f2798b = i13;
                this.f2800d = (int) (i12 * 0.75f);
                this.e = objArr3;
                return;
            }
            do {
                length--;
                obj = objArr2[length];
            } while (obj == null);
            int hashCode2 = obj.hashCode() * (-1640531527);
            int i15 = (hashCode2 ^ (hashCode2 >>> 16)) & i13;
            if (objArr3[i15] != null) {
                do {
                    i15 = (i15 + 1) & i13;
                } while (objArr3[i15] != null);
            }
            objArr3[i15] = objArr2[length];
            i11 = i14;
        }
    }

    public void b(int i3, int i10) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i11 = this.f2800d;
        int i12 = i11 * 2;
        int[] iArr = (int[]) this.e;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.e = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i12 >= iArr.length) {
            int[] iArr3 = new int[i11 * 4];
            this.e = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.e;
        iArr4[i12] = i3;
        iArr4[i12 + 1] = i10;
        this.f2800d++;
    }

    public void c(RecyclerView recyclerView, boolean z5) {
        this.f2800d = 0;
        int[] iArr = (int[]) this.e;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        i1 i1Var = recyclerView.f2471m;
        if (recyclerView.f2470l == null || i1Var == null || !i1Var.f2592i) {
            return;
        }
        if (z5) {
            if (!recyclerView.f2452d.k()) {
                i1Var.i(recyclerView.f2470l.getItemCount(), this);
            }
        } else if (!recyclerView.N()) {
            i1Var.h(this.f2798b, this.f2799c, recyclerView.f2460g0, this);
        }
        int i3 = this.f2800d;
        if (i3 > i1Var.f2593j) {
            i1Var.f2593j = i3;
            i1Var.f2594k = z5;
            recyclerView.f2446b.k();
        }
    }

    public void d(Object[] objArr, int i3, int i10) {
        int i11;
        Object obj;
        this.f2799c--;
        while (true) {
            int i12 = i3 + 1;
            while (true) {
                i11 = i12 & i10;
                obj = objArr[i11];
                if (obj == null) {
                    objArr[i3] = null;
                    return;
                }
                int hashCode = obj.hashCode() * (-1640531527);
                int i13 = (hashCode ^ (hashCode >>> 16)) & i10;
                if (i3 > i11) {
                    if (i3 >= i13 && i13 > i11) {
                        break;
                    }
                    i12 = i11 + 1;
                } else if (i3 < i13 && i13 <= i11) {
                    i12 = i11 + 1;
                }
            }
            objArr[i3] = obj;
            i3 = i11;
        }
    }

    public void e(r7.b bVar, o7.k kVar) {
        ((u7.c) this.e).f18948b.getClass();
        float max = Math.max(0.0f, Math.min(1.0f, 1.0f));
        float lowestVisibleX = bVar.getLowestVisibleX();
        float highestVisibleX = bVar.getHighestVisibleX();
        Entry h4 = kVar.h(lowestVisibleX, Float.NaN, DataSet$Rounding.DOWN);
        Entry h10 = kVar.h(highestVisibleX, Float.NaN, DataSet$Rounding.UP);
        this.f2798b = h4 == null ? 0 : kVar.f16820o.indexOf(h4);
        this.f2799c = h10 != null ? kVar.f16820o.indexOf(h10) : 0;
        this.f2800d = (int) ((r2 - this.f2798b) * max);
    }

    public String toString() {
        switch (this.f2797a) {
            case 3:
                StringBuilder sb2 = new StringBuilder("BaseError{code=");
                sb2.append(this.f2798b);
                sb2.append(", subCode=");
                sb2.append(this.f2799c);
                sb2.append(", opCode=");
                sb2.append(this.f2800d);
                sb2.append(", message='");
                return r5.a.f(sb2, (String) this.e, "'}");
            default:
                return super.toString();
        }
    }

    public x(int i3, String str) {
        this.f2797a = 3;
        this.f2798b = i3;
        this.f2799c = i3;
        this.e = str;
    }

    public x(u7.c cVar) {
        this.f2797a = 2;
        this.e = cVar;
    }
}
