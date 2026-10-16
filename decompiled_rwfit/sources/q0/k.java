package q0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: s0, reason: collision with root package name */
    public float f17714s0 = -1.0f;

    /* renamed from: t0, reason: collision with root package name */
    public int f17715t0 = -1;

    /* renamed from: u0, reason: collision with root package name */
    public int f17716u0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    public d f17717v0 = this.J;

    /* renamed from: w0, reason: collision with root package name */
    public int f17718w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f17719x0;

    public k() {
        this.R.clear();
        this.R.add(this.f17717v0);
        int length = this.Q.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.Q[i3] = this.f17717v0;
        }
    }

    @Override // q0.f
    public final void M(o0.c cVar, boolean z5) {
        if (this.U == null) {
            return;
        }
        d dVar = this.f17717v0;
        cVar.getClass();
        int n4 = o0.c.n(dVar);
        if (this.f17718w0 == 1) {
            this.Z = n4;
            this.f17645a0 = 0;
            H(this.U.l());
            K(0);
            return;
        }
        this.Z = 0;
        this.f17645a0 = n4;
        K(this.U.o());
        H(0);
    }

    public final void N(int i3) {
        this.f17717v0.l(i3);
        this.f17719x0 = true;
    }

    public final void O(int i3) {
        if (this.f17718w0 == i3) {
            return;
        }
        this.f17718w0 = i3;
        ArrayList arrayList = this.R;
        arrayList.clear();
        if (this.f17718w0 == 1) {
            this.f17717v0 = this.I;
        } else {
            this.f17717v0 = this.J;
        }
        arrayList.add(this.f17717v0);
        d[] dVarArr = this.Q;
        int length = dVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            dVarArr[i10] = this.f17717v0;
        }
    }

    @Override // q0.f
    public final void b(o0.c cVar, boolean z5) {
        g gVar = (g) this.U;
        if (gVar == null) {
            return;
        }
        Object j4 = gVar.j(ConstraintAnchor$Type.LEFT);
        Object j10 = gVar.j(ConstraintAnchor$Type.RIGHT);
        f fVar = this.U;
        boolean z6 = fVar != null && fVar.T[0] == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (this.f17718w0 == 0) {
            j4 = gVar.j(ConstraintAnchor$Type.TOP);
            j10 = gVar.j(ConstraintAnchor$Type.BOTTOM);
            f fVar2 = this.U;
            z6 = fVar2 != null && fVar2.T[1] == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.f17719x0) {
            d dVar = this.f17717v0;
            if (dVar.f17636c) {
                o0.e k10 = cVar.k(dVar);
                cVar.d(k10, this.f17717v0.d());
                if (this.f17715t0 != -1) {
                    if (z6) {
                        cVar.f(cVar.k(j10), k10, 0, 5);
                    }
                } else if (this.f17716u0 != -1 && z6) {
                    o0.e k11 = cVar.k(j10);
                    cVar.f(k10, cVar.k(j4), 0, 5);
                    cVar.f(k11, k10, 0, 5);
                }
                this.f17719x0 = false;
                return;
            }
        }
        if (this.f17715t0 != -1) {
            o0.e k12 = cVar.k(this.f17717v0);
            cVar.e(k12, cVar.k(j4), this.f17715t0, 8);
            if (z6) {
                cVar.f(cVar.k(j10), k12, 0, 5);
                return;
            }
            return;
        }
        if (this.f17716u0 != -1) {
            o0.e k13 = cVar.k(this.f17717v0);
            o0.e k14 = cVar.k(j10);
            cVar.e(k13, k14, -this.f17716u0, 8);
            if (z6) {
                cVar.f(k13, cVar.k(j4), 0, 5);
                cVar.f(k14, k13, 0, 5);
                return;
            }
            return;
        }
        if (this.f17714s0 != -1.0f) {
            o0.e k15 = cVar.k(this.f17717v0);
            o0.e k16 = cVar.k(j10);
            float f2 = this.f17714s0;
            o0.b l3 = cVar.l();
            l3.f16649d.g(k15, -1.0f);
            l3.f16649d.g(k16, f2);
            cVar.c(l3);
        }
    }

    @Override // q0.f
    public final boolean c() {
        return true;
    }

    @Override // q0.f
    public final void g(f fVar, HashMap hashMap) {
        super.g(fVar, hashMap);
        k kVar = (k) fVar;
        this.f17714s0 = kVar.f17714s0;
        this.f17715t0 = kVar.f17715t0;
        this.f17716u0 = kVar.f17716u0;
        O(kVar.f17718w0);
    }

    @Override // q0.f
    public final d j(ConstraintAnchor$Type constraintAnchor$Type) {
        int i3 = j.f17713a[constraintAnchor$Type.ordinal()];
        if (i3 == 1 || i3 == 2) {
            if (this.f17718w0 == 1) {
                return this.f17717v0;
            }
            return null;
        }
        if ((i3 == 3 || i3 == 4) && this.f17718w0 == 0) {
            return this.f17717v0;
        }
        return null;
    }

    @Override // q0.f
    public final boolean y() {
        return this.f17719x0;
    }

    @Override // q0.f
    public final boolean z() {
        return this.f17719x0;
    }
}
