package q0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;

/* loaded from: classes.dex */
public final class n extends o {
    @Override // q0.o
    public final void Q(int i3, int i10, int i11, int i12) {
        int i13 = this.f17727y0 + this.f17728z0;
        int i14 = this.f17723u0 + this.f17724v0;
        if (this.f17721t0 > 0) {
            i13 += this.f17720s0[0].o();
            i14 += this.f17720s0[0].l();
        }
        int max = Math.max(this.f17649c0, i13);
        int max2 = Math.max(this.f17651d0, i14);
        if (i3 != 1073741824) {
            i10 = i3 == Integer.MIN_VALUE ? Math.min(max, i10) : i3 == 0 ? max : 0;
        }
        if (i11 != 1073741824) {
            i12 = i11 == Integer.MIN_VALUE ? Math.min(max2, i12) : i11 == 0 ? max2 : 0;
        }
        this.B0 = i10;
        this.C0 = i12;
        K(i10);
        H(i12);
        this.A0 = this.f17721t0 > 0;
    }

    @Override // q0.f
    public final void b(o0.c cVar, boolean z5) {
        super.b(cVar, z5);
        if (this.f17721t0 > 0) {
            f fVar = this.f17720s0[0];
            fVar.B();
            fVar.f17654f0 = 0.5f;
            fVar.f17652e0 = 0.5f;
            ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.LEFT;
            fVar.e(constraintAnchor$Type, this, constraintAnchor$Type, 0);
            ConstraintAnchor$Type constraintAnchor$Type2 = ConstraintAnchor$Type.RIGHT;
            fVar.e(constraintAnchor$Type2, this, constraintAnchor$Type2, 0);
            ConstraintAnchor$Type constraintAnchor$Type3 = ConstraintAnchor$Type.TOP;
            fVar.e(constraintAnchor$Type3, this, constraintAnchor$Type3, 0);
            ConstraintAnchor$Type constraintAnchor$Type4 = ConstraintAnchor$Type.BOTTOM;
            fVar.e(constraintAnchor$Type4, this, constraintAnchor$Type4, 0);
        }
    }
}
