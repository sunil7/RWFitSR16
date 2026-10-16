package androidx.databinding;

import com.google.android.gms.internal.mlkit_common.o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final o f1987f = new o(2);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1988a;

    /* renamed from: b, reason: collision with root package name */
    public long f1989b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f1990c;

    /* renamed from: d, reason: collision with root package name */
    public int f1991d;
    public final o e;

    public h() {
        o oVar = f1987f;
        this.f1988a = new ArrayList();
        this.f1989b = 0L;
        this.e = oVar;
    }

    public final boolean a(int i3) {
        int i10;
        if (i3 < 64) {
            return ((1 << i3) & this.f1989b) != 0;
        }
        long[] jArr = this.f1990c;
        if (jArr != null && (i10 = (i3 / 64) - 1) < jArr.length) {
            return ((1 << (i3 % 64)) & jArr[i10]) != 0;
        }
        return false;
    }

    public final synchronized void b(a aVar, int i3) {
        try {
            try {
                this.f1991d++;
                int size = this.f1988a.size();
                int length = this.f1990c == null ? -1 : r0.length - 1;
                d(aVar, i3, length);
                c(aVar, i3, (length + 2) * 64, size, 0L);
                int i10 = this.f1991d - 1;
                this.f1991d = i10;
                if (i10 == 0) {
                    long[] jArr = this.f1990c;
                    if (jArr != null) {
                        for (int length2 = jArr.length - 1; length2 >= 0; length2--) {
                            long j4 = this.f1990c[length2];
                            if (j4 != 0) {
                                e((length2 + 1) * 64, j4);
                                this.f1990c[length2] = 0;
                            }
                        }
                    }
                    long j10 = this.f1989b;
                    if (j10 != 0) {
                        e(0, j10);
                        this.f1989b = 0L;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void c(a aVar, int i3, int i10, int i11, long j4) {
        long j10 = 1;
        while (i10 < i11) {
            if ((j4 & j10) == 0) {
                Object obj = this.f1988a.get(i10);
                this.e.getClass();
                ((b) ((e) obj)).f1984a.notifyChange();
            }
            j10 <<= 1;
            i10++;
        }
    }

    public final Object clone() {
        h hVar;
        CloneNotSupportedException e;
        synchronized (this) {
            try {
                hVar = (h) super.clone();
            } catch (CloneNotSupportedException e10) {
                hVar = null;
                e = e10;
            }
            try {
                hVar.f1989b = 0L;
                hVar.f1990c = null;
                hVar.f1991d = 0;
                hVar.f1988a = new ArrayList();
                int size = this.f1988a.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (!a(i3)) {
                        hVar.f1988a.add(this.f1988a.get(i3));
                    }
                }
            } catch (CloneNotSupportedException e11) {
                e = e11;
                e.printStackTrace();
                return hVar;
            }
        }
        return hVar;
    }

    public final void d(a aVar, int i3, int i10) {
        if (i10 < 0) {
            c(aVar, i3, 0, Math.min(64, this.f1988a.size()), this.f1989b);
            return;
        }
        long j4 = this.f1990c[i10];
        int i11 = (i10 + 1) * 64;
        int min = Math.min(this.f1988a.size(), i11 + 64);
        d(aVar, i3, i10 - 1);
        c(aVar, i3, i11, min, j4);
    }

    public final void e(int i3, long j4) {
        long j10 = Long.MIN_VALUE;
        for (int i10 = i3 + 63; i10 >= i3; i10--) {
            if ((j4 & j10) != 0) {
                this.f1988a.remove(i10);
            }
            j10 >>>= 1;
        }
    }

    public final void f(int i3) {
        if (i3 < 64) {
            this.f1989b = (1 << i3) | this.f1989b;
            return;
        }
        int i10 = (i3 / 64) - 1;
        long[] jArr = this.f1990c;
        if (jArr == null) {
            this.f1990c = new long[this.f1988a.size() / 64];
        } else if (jArr.length <= i10) {
            long[] jArr2 = new long[this.f1988a.size() / 64];
            long[] jArr3 = this.f1990c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f1990c = jArr2;
        }
        long j4 = 1 << (i3 % 64);
        long[] jArr4 = this.f1990c;
        jArr4[i10] = j4 | jArr4[i10];
    }
}
