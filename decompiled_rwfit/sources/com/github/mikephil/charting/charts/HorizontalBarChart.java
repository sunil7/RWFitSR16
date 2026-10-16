package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import de.i;
import n7.f;
import n7.h;
import q7.d;
import u7.u;
import u7.w;
import v7.b;
import v7.c;
import v7.g;

/* loaded from: classes.dex */
public class HorizontalBarChart extends BarChart {

    /* renamed from: a1, reason: collision with root package name */
    public final RectF f8816a1;

    public HorizontalBarChart(Context context) {
        super(context);
        this.f8816a1 = new RectF();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void f() {
        RectF rectF = this.f8816a1;
        r(rectF);
        float f2 = rectF.left + 0.0f;
        float f10 = rectF.top + 0.0f;
        float f11 = rectF.right + 0.0f;
        float f12 = rectF.bottom + 0.0f;
        if (this.W.k()) {
            f10 += this.W.i(this.f8782b0.e);
        }
        if (this.f8781a0.k()) {
            f12 += this.f8781a0.i(this.f8783c0.e);
        }
        h hVar = this.f8798i;
        float f13 = hVar.F;
        if (hVar.f16406a) {
            XAxis$XAxisPosition xAxis$XAxisPosition = hVar.I;
            if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTTOM) {
                f2 += f13;
            } else {
                if (xAxis$XAxisPosition != XAxis$XAxisPosition.TOP) {
                    if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTH_SIDED) {
                        f2 += f13;
                    }
                }
                f11 += f13;
            }
        }
        float extraTopOffset = getExtraTopOffset() + f10;
        float extraRightOffset = getExtraRightOffset() + f11;
        float extraBottomOffset = getExtraBottomOffset() + f12;
        float extraLeftOffset = getExtraLeftOffset() + f2;
        float c9 = v7.h.c(this.U);
        this.f8807s.l(Math.max(c9, extraLeftOffset), Math.max(c9, extraTopOffset), Math.max(c9, extraRightOffset), Math.max(c9, extraBottomOffset));
        if (this.f8791a) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb2 = new StringBuilder("Content: ");
            sb2.append(this.f8807s.f19202b.toString());
            Log.i("MPAndroidChart", sb2.toString());
        }
        i iVar = this.f8785e0;
        this.f8781a0.getClass();
        iVar.q();
        i iVar2 = this.f8784d0;
        this.W.getClass();
        iVar2.q();
        u();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, r7.b
    public float getHighestVisibleX() {
        i s7 = s(YAxis$AxisDependency.LEFT);
        RectF rectF = this.f8807s.f19202b;
        float f2 = rectF.left;
        float f10 = rectF.top;
        c cVar = this.U0;
        s7.k(f2, f10, cVar);
        return (float) Math.min(this.f8798i.A, cVar.f19180c);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, r7.b
    public float getLowestVisibleX() {
        i s7 = s(YAxis$AxisDependency.LEFT);
        RectF rectF = this.f8807s.f19202b;
        float f2 = rectF.left;
        float f10 = rectF.bottom;
        c cVar = this.f8790k0;
        s7.k(f2, f10, cVar);
        return (float) Math.max(this.f8798i.B, cVar.f19180c);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public final q7.c j(float f2, float f10) {
        if (this.f8792b != null) {
            return getHighlighter().b(f10, f2);
        }
        if (!this.f8791a) {
            return null;
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final float[] k(q7.c cVar) {
        return new float[]{cVar.f17805j, cVar.f17804i};
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        this.f8807s = new b();
        super.m();
        this.f8784d0 = new g(this.f8807s);
        this.f8785e0 = new g(this.f8807s);
        u7.i iVar = new u7.i(this, this.f8808t, this.f8807s);
        iVar.f18951m = new RectF();
        iVar.e.setTextAlign(Paint.Align.LEFT);
        this.f8806q = iVar;
        setHighlighter(new d(this));
        this.f8782b0 = new w(this.f8807s, this.W, this.f8784d0);
        this.f8783c0 = new w(this.f8807s, this.f8781a0, this.f8785e0);
        u uVar = new u(this.f8807s, this.f8798i, this.f8784d0, 0);
        uVar.f18998n = new Path();
        this.f8786f0 = uVar;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public final void r(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        f fVar = this.f8801l;
        if (fVar == null || !fVar.f16406a) {
            return;
        }
        int i3 = m7.c.f15987c[fVar.f16416i.ordinal()];
        if (i3 == 1) {
            int i10 = m7.c.f15986b[this.f8801l.f16414g.ordinal()];
            if (i10 == 1) {
                float f2 = rectF.left;
                f fVar2 = this.f8801l;
                rectF.left = Math.min(fVar2.r, this.f8807s.f19203c * fVar2.f16424q) + this.f8801l.f16407b + f2;
                return;
            }
            if (i10 == 2) {
                float f10 = rectF.right;
                f fVar3 = this.f8801l;
                rectF.right = Math.min(fVar3.r, this.f8807s.f19203c * fVar3.f16424q) + this.f8801l.f16407b + f10;
                return;
            } else {
                if (i10 != 3) {
                    return;
                }
                int i11 = m7.c.f15985a[this.f8801l.f16415h.ordinal()];
                if (i11 == 1) {
                    float f11 = rectF.top;
                    f fVar4 = this.f8801l;
                    rectF.top = Math.min(fVar4.f16425s, this.f8807s.f19204d * fVar4.f16424q) + this.f8801l.f16408c + f11;
                    return;
                } else {
                    if (i11 != 2) {
                        return;
                    }
                    float f12 = rectF.bottom;
                    f fVar5 = this.f8801l;
                    rectF.bottom = Math.min(fVar5.f16425s, this.f8807s.f19204d * fVar5.f16424q) + this.f8801l.f16408c + f12;
                    return;
                }
            }
        }
        if (i3 != 2) {
            return;
        }
        int i12 = m7.c.f15985a[this.f8801l.f16415h.ordinal()];
        if (i12 == 1) {
            float f13 = rectF.top;
            f fVar6 = this.f8801l;
            float min = Math.min(fVar6.f16425s, this.f8807s.f19204d * fVar6.f16424q) + this.f8801l.f16408c + f13;
            rectF.top = min;
            n7.i iVar = this.W;
            if (iVar.f16406a && iVar.f16399t) {
                rectF.top = iVar.i(this.f8782b0.e) + min;
                return;
            }
            return;
        }
        if (i12 != 2) {
            return;
        }
        float f14 = rectF.bottom;
        f fVar7 = this.f8801l;
        float min2 = Math.min(fVar7.f16425s, this.f8807s.f19204d * fVar7.f16424q) + this.f8801l.f16408c + f14;
        rectF.bottom = min2;
        n7.i iVar2 = this.f8781a0;
        if (iVar2.f16406a && iVar2.f16399t) {
            rectF.bottom = iVar2.i(this.f8783c0.e) + min2;
        }
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f2) {
        float f10 = this.f8798i.C / f2;
        v7.i iVar = this.f8807s;
        iVar.getClass();
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        iVar.e = f10;
        iVar.i(iVar.f19201a, iVar.f19202b);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f2) {
        float f10 = this.f8798i.C / f2;
        v7.i iVar = this.f8807s;
        iVar.getClass();
        if (f10 == 0.0f) {
            f10 = Float.MAX_VALUE;
        }
        iVar.f19205f = f10;
        iVar.i(iVar.f19201a, iVar.f19202b);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public final void u() {
        i iVar = this.f8785e0;
        n7.i iVar2 = this.f8781a0;
        float f2 = iVar2.B;
        float f10 = iVar2.C;
        h hVar = this.f8798i;
        iVar.r(f2, f10, hVar.C, hVar.B);
        i iVar3 = this.f8784d0;
        n7.i iVar4 = this.W;
        float f11 = iVar4.B;
        float f12 = iVar4.C;
        h hVar2 = this.f8798i;
        iVar3.r(f11, f12, hVar2.C, hVar2.B);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8816a1 = new RectF();
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8816a1 = new RectF();
    }
}
