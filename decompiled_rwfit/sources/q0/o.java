package q0;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* loaded from: classes.dex */
public abstract class o extends l {

    /* renamed from: u0, reason: collision with root package name */
    public int f17723u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public int f17724v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public int f17725w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public int f17726x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public int f17727y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public int f17728z0 = 0;
    public boolean A0 = false;
    public int B0 = 0;
    public int C0 = 0;
    public final r0.b D0 = new r0.b();
    public w0.f E0 = null;

    @Override // q0.l
    public final void P() {
        for (int i3 = 0; i3 < this.f17721t0; i3++) {
            f fVar = this.f17720s0[i3];
            if (fVar != null) {
                fVar.F = true;
            }
        }
    }

    public abstract void Q(int i3, int i10, int i11, int i12);

    public final void R(f fVar, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int i3, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int i10) {
        w0.f fVar2;
        f fVar3;
        while (true) {
            fVar2 = this.E0;
            if (fVar2 != null || (fVar3 = this.U) == null) {
                break;
            } else {
                this.E0 = ((g) fVar3).f17689w0;
            }
        }
        r0.b bVar = this.D0;
        bVar.f17958a = constraintWidget$DimensionBehaviour;
        bVar.f17959b = constraintWidget$DimensionBehaviour2;
        bVar.f17960c = i3;
        bVar.f17961d = i10;
        fVar2.b(fVar, bVar);
        fVar.K(bVar.e);
        fVar.H(bVar.f17962f);
        fVar.D = bVar.f17964h;
        fVar.E(bVar.f17963g);
    }
}
