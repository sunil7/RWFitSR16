package o0;

import androidx.constraintlayout.core.SolverVariable$Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16670a;
    public float e;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable$Type f16677i;

    /* renamed from: b, reason: collision with root package name */
    public int f16671b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f16672c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f16673d = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16674f = false;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f16675g = new float[9];

    /* renamed from: h, reason: collision with root package name */
    public final float[] f16676h = new float[9];

    /* renamed from: j, reason: collision with root package name */
    public b[] f16678j = new b[16];

    /* renamed from: k, reason: collision with root package name */
    public int f16679k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f16680l = 0;

    public e(SolverVariable$Type solverVariable$Type) {
        this.f16677i = solverVariable$Type;
    }

    public final void a(b bVar) {
        int i3 = 0;
        while (true) {
            int i10 = this.f16679k;
            if (i3 >= i10) {
                b[] bVarArr = this.f16678j;
                if (i10 >= bVarArr.length) {
                    this.f16678j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f16678j;
                int i11 = this.f16679k;
                bVarArr2[i11] = bVar;
                this.f16679k = i11 + 1;
                return;
            }
            if (this.f16678j[i3] == bVar) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void b(b bVar) {
        int i3 = this.f16679k;
        int i10 = 0;
        while (i10 < i3) {
            if (this.f16678j[i10] == bVar) {
                while (i10 < i3 - 1) {
                    b[] bVarArr = this.f16678j;
                    int i11 = i10 + 1;
                    bVarArr[i10] = bVarArr[i11];
                    i10 = i11;
                }
                this.f16679k--;
                return;
            }
            i10++;
        }
    }

    public final void c() {
        this.f16677i = SolverVariable$Type.UNKNOWN;
        this.f16673d = 0;
        this.f16671b = -1;
        this.f16672c = -1;
        this.e = 0.0f;
        this.f16674f = false;
        int i3 = this.f16679k;
        for (int i10 = 0; i10 < i3; i10++) {
            this.f16678j[i10] = null;
        }
        this.f16679k = 0;
        this.f16680l = 0;
        this.f16670a = false;
        Arrays.fill(this.f16676h, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f16671b - ((e) obj).f16671b;
    }

    public final void d(c cVar, float f2) {
        this.e = f2;
        this.f16674f = true;
        int i3 = this.f16679k;
        this.f16672c = -1;
        for (int i10 = 0; i10 < i3; i10++) {
            this.f16678j[i10].h(cVar, this, false);
        }
        this.f16679k = 0;
    }

    public final void e(c cVar, b bVar) {
        int i3 = this.f16679k;
        for (int i10 = 0; i10 < i3; i10++) {
            this.f16678j[i10].i(cVar, bVar, false);
        }
        this.f16679k = 0;
    }

    public final String toString() {
        return "" + this.f16671b;
    }
}
