package androidx.emoji2.text;

import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public int f2051a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final r f2052b;

    /* renamed from: c, reason: collision with root package name */
    public r f2053c;

    /* renamed from: d, reason: collision with root package name */
    public r f2054d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f2055f;

    public o(r rVar) {
        this.f2052b = rVar;
        this.f2053c = rVar;
    }

    public final int a(int i3) {
        SparseArray sparseArray = this.f2053c.f2064a;
        r rVar = sparseArray == null ? null : (r) sparseArray.get(i3);
        int i10 = 1;
        int i11 = 2;
        if (this.f2051a == 2) {
            if (rVar != null) {
                this.f2053c = rVar;
                this.f2055f++;
            } else if (i3 == 65038) {
                b();
            } else if (i3 != 65039) {
                r rVar2 = this.f2053c;
                if (rVar2.f2065b != null) {
                    i11 = 3;
                    if (this.f2055f != 1) {
                        this.f2054d = rVar2;
                        b();
                    } else if (c()) {
                        this.f2054d = this.f2053c;
                        b();
                    } else {
                        b();
                    }
                } else {
                    b();
                }
            }
            i10 = i11;
        } else if (rVar == null) {
            b();
        } else {
            this.f2051a = 2;
            this.f2053c = rVar;
            this.f2055f = 1;
            i10 = i11;
        }
        this.e = i3;
        return i10;
    }

    public final void b() {
        this.f2051a = 1;
        this.f2053c = this.f2052b;
        this.f2055f = 0;
    }

    public final boolean c() {
        s1.a b3 = this.f2053c.f2065b.b();
        int a3 = b3.a(6);
        return !(a3 == 0 || ((ByteBuffer) b3.f15697d).get(a3 + b3.f15694a) == 0) || this.e == 65039;
    }
}
