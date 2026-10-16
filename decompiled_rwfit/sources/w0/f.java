package w0;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f19333a;

    /* renamed from: b, reason: collision with root package name */
    public int f19334b;

    /* renamed from: c, reason: collision with root package name */
    public int f19335c;

    /* renamed from: d, reason: collision with root package name */
    public int f19336d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f19337f;

    /* renamed from: g, reason: collision with root package name */
    public int f19338g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f19339h;

    public f(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f19339h = constraintLayout;
        this.f19333a = constraintLayout2;
    }

    public static boolean a(int i3, int i10, int i11) {
        if (i3 == i10) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i11 == size;
        }
        return false;
    }

    public final void b(q0.f fVar, r0.b bVar) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int max;
        int max2;
        int i3;
        boolean z5;
        int baseline;
        int i10;
        int childMeasureSpec;
        if (fVar == null) {
            return;
        }
        if (fVar.f17658h0 == 8 && !fVar.E) {
            bVar.e = 0;
            bVar.f17962f = 0;
            bVar.f17963g = 0;
            return;
        }
        if (fVar.U == null) {
            return;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = bVar.f17958a;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = bVar.f17959b;
        int i11 = bVar.f17960c;
        int i12 = bVar.f17961d;
        int i13 = this.f19334b + this.f19335c;
        int i14 = this.f19336d;
        View view = fVar.f17656g0;
        int[] iArr = c.f19292a;
        int i15 = iArr[constraintWidget$DimensionBehaviour.ordinal()];
        q0.d dVar = fVar.K;
        q0.d dVar2 = fVar.I;
        if (i15 != 1) {
            if (i15 == 2) {
                childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f19337f, i14, -2);
            } else if (i15 == 3) {
                int i16 = this.f19337f;
                int i17 = dVar2 != null ? dVar2.f17639g : 0;
                if (dVar != null) {
                    i17 += dVar.f17639g;
                }
                childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, i14 + i17, -1);
            } else if (i15 != 4) {
                makeMeasureSpec = 0;
            } else {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f19337f, i14, -2);
                boolean z6 = fVar.f17674q == 1;
                int i18 = bVar.f17966j;
                if (i18 == 1 || i18 == 2) {
                    boolean z8 = view.getMeasuredHeight() == fVar.l();
                    if (bVar.f17966j == 2 || !z6 || ((z6 && z8) || (view instanceof Placeholder) || fVar.y())) {
                        childMeasureSpec = View.MeasureSpec.makeMeasureSpec(fVar.o(), 1073741824);
                    }
                }
            }
            makeMeasureSpec = childMeasureSpec;
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        int i19 = iArr[constraintWidget$DimensionBehaviour2.ordinal()];
        if (i19 == 1) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else if (i19 == 2) {
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f19338g, i13, -2);
        } else if (i19 == 3) {
            int i20 = this.f19338g;
            int i21 = dVar2 != null ? fVar.J.f17639g : 0;
            if (dVar != null) {
                i21 += fVar.L.f17639g;
            }
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i20, i13 + i21, -1);
        } else if (i19 != 4) {
            makeMeasureSpec2 = 0;
        } else {
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f19338g, i13, -2);
            boolean z10 = fVar.r == 1;
            int i22 = bVar.f17966j;
            if (i22 == 1 || i22 == 2) {
                boolean z11 = view.getMeasuredWidth() == fVar.o();
                if (bVar.f17966j == 2 || !z10 || ((z10 && z11) || (view instanceof Placeholder) || fVar.z())) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(fVar.l(), 1073741824);
                }
            }
        }
        q0.g gVar = (q0.g) fVar.U;
        ConstraintLayout constraintLayout = this.f19339h;
        if (gVar != null && q0.m.c(constraintLayout.f1863i, 256) && view.getMeasuredWidth() == fVar.o() && view.getMeasuredWidth() < gVar.o() && view.getMeasuredHeight() == fVar.l() && view.getMeasuredHeight() < gVar.l() && view.getBaseline() == fVar.f17647b0 && !fVar.x() && a(fVar.G, makeMeasureSpec, fVar.o()) && a(fVar.H, makeMeasureSpec2, fVar.l())) {
            bVar.e = fVar.o();
            bVar.f17962f = fVar.l();
            bVar.f17963g = fVar.f17647b0;
            return;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z12 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3;
        boolean z13 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
        boolean z14 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.FIXED;
        boolean z15 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.FIXED;
        boolean z16 = z12 && fVar.X > 0.0f;
        boolean z17 = z13 && fVar.X > 0.0f;
        if (view == null) {
            return;
        }
        e eVar = (e) view.getLayoutParams();
        int i23 = bVar.f17966j;
        if (i23 != 1 && i23 != 2 && z12 && fVar.f17674q == 0 && z13 && fVar.r == 0) {
            z5 = false;
            baseline = 0;
            i10 = -1;
            max = 0;
            max2 = 0;
        } else {
            if ((view instanceof VirtualLayout) && (fVar instanceof q0.o)) {
                ((VirtualLayout) view).r((q0.o) fVar, makeMeasureSpec, makeMeasureSpec2);
            } else {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
            }
            fVar.G = makeMeasureSpec;
            fVar.H = makeMeasureSpec2;
            fVar.f17655g = false;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i24 = fVar.f17678t;
            max = i24 > 0 ? Math.max(i24, measuredWidth) : measuredWidth;
            int i25 = fVar.f17679u;
            if (i25 > 0) {
                max = Math.min(i25, max);
            }
            int i26 = fVar.f17681w;
            max2 = i26 > 0 ? Math.max(i26, measuredHeight) : measuredHeight;
            boolean z18 = z15;
            int i27 = fVar.f17682x;
            if (i27 > 0) {
                max2 = Math.min(i27, max2);
            }
            if (!q0.m.c(constraintLayout.f1863i, 1)) {
                if (z16 && z14) {
                    max = (int) ((max2 * fVar.X) + 0.5f);
                } else if (z17 && z18) {
                    max2 = (int) ((max / fVar.X) + 0.5f);
                }
            }
            if (measuredWidth == max && measuredHeight == max2) {
                baseline = baseline2;
                z5 = false;
            } else {
                if (measuredWidth != max) {
                    i3 = 1073741824;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
                } else {
                    i3 = 1073741824;
                }
                if (measuredHeight != max2) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(max2, i3);
                }
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                fVar.G = makeMeasureSpec;
                fVar.H = makeMeasureSpec2;
                z5 = false;
                fVar.f17655g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                max = measuredWidth2;
                max2 = measuredHeight2;
            }
            i10 = -1;
        }
        boolean z19 = baseline != i10 ? true : z5;
        if (max != bVar.f17960c || max2 != bVar.f17961d) {
            z5 = true;
        }
        bVar.f17965i = z5;
        if (eVar.f19297b0) {
            z19 = true;
        }
        if (z19 && baseline != -1 && fVar.f17647b0 != baseline) {
            bVar.f17965i = true;
        }
        bVar.e = max;
        bVar.f17962f = max2;
        bVar.f17964h = z19;
        bVar.f17963g = baseline;
    }
}
