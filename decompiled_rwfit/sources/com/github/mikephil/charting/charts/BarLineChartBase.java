package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;
import n7.f;
import n7.i;
import o7.c;
import r7.b;
import t7.a;
import t7.e;
import u7.t;
import u7.v;
import v7.d;
import v7.h;

@SuppressLint({"RtlHardcoded"})
/* loaded from: classes.dex */
public abstract class BarLineChartBase<T extends c> extends Chart<T> implements b {
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public Paint O;
    public Paint P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public float U;
    public final v7.c U0;
    public boolean V;
    public final float[] V0;
    public i W;

    /* renamed from: a0, reason: collision with root package name */
    public i f8781a0;

    /* renamed from: b0, reason: collision with root package name */
    public v f8782b0;

    /* renamed from: c0, reason: collision with root package name */
    public v f8783c0;

    /* renamed from: d0, reason: collision with root package name */
    public de.i f8784d0;

    /* renamed from: e0, reason: collision with root package name */
    public de.i f8785e0;

    /* renamed from: f0, reason: collision with root package name */
    public t f8786f0;

    /* renamed from: g0, reason: collision with root package name */
    public long f8787g0;

    /* renamed from: h0, reason: collision with root package name */
    public long f8788h0;
    public final RectF i0;

    /* renamed from: j0, reason: collision with root package name */
    public final Matrix f8789j0;

    /* renamed from: k0, reason: collision with root package name */
    public final v7.c f8790k0;

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = 100;
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = true;
        this.U = 15.0f;
        this.V = false;
        this.f8787g0 = 0L;
        this.f8788h0 = 0L;
        this.i0 = new RectF();
        this.f8789j0 = new Matrix();
        new Matrix();
        this.f8790k0 = v7.c.b(0.0d, 0.0d);
        this.U0 = v7.c.b(0.0d, 0.0d);
        this.V0 = new float[2];
    }

    @Override // android.view.View
    public final void computeScroll() {
        t7.b bVar = this.f8803n;
        if (bVar instanceof a) {
            a aVar = (a) bVar;
            d dVar = aVar.f18579p;
            if (dVar.f19182b == 0.0f && dVar.f19183c == 0.0f) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f2 = dVar.f19182b;
            Chart chart = aVar.f18584d;
            BarLineChartBase barLineChartBase = (BarLineChartBase) chart;
            dVar.f19182b = barLineChartBase.getDragDecelerationFrictionCoef() * f2;
            float dragDecelerationFrictionCoef = barLineChartBase.getDragDecelerationFrictionCoef() * dVar.f19183c;
            dVar.f19183c = dragDecelerationFrictionCoef;
            float f10 = (currentAnimationTimeMillis - aVar.f18577n) / 1000.0f;
            float f11 = dVar.f19182b * f10;
            float f12 = dragDecelerationFrictionCoef * f10;
            d dVar2 = aVar.f18578o;
            float f13 = dVar2.f19182b + f11;
            dVar2.f19182b = f13;
            float f14 = dVar2.f19183c + f12;
            dVar2.f19183c = f14;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f13, f14, 0);
            boolean z5 = barLineChartBase.K;
            d dVar3 = aVar.f18570g;
            aVar.c(z5 ? dVar2.f19182b - dVar3.f19182b : 0.0f, barLineChartBase.L ? dVar2.f19183c - dVar3.f19183c : 0.0f);
            obtain.recycle();
            v7.i viewPortHandler = barLineChartBase.getViewPortHandler();
            Matrix matrix = aVar.e;
            viewPortHandler.k(matrix, chart, false);
            aVar.e = matrix;
            aVar.f18577n = currentAnimationTimeMillis;
            if (Math.abs(dVar.f19182b) >= 0.01d || Math.abs(dVar.f19183c) >= 0.01d) {
                DisplayMetrics displayMetrics = h.f19191a;
                chart.postInvalidateOnAnimation();
                return;
            }
            barLineChartBase.f();
            barLineChartBase.postInvalidate();
            d dVar4 = aVar.f18579p;
            dVar4.f19182b = 0.0f;
            dVar4.f19183c = 0.0f;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void f() {
        RectF rectF = this.i0;
        r(rectF);
        float f2 = rectF.left + 0.0f;
        float f10 = rectF.top + 0.0f;
        float f11 = rectF.right + 0.0f;
        float f12 = rectF.bottom + 0.0f;
        if (this.W.k()) {
            f2 += this.W.j(this.f8782b0.e);
        }
        if (this.f8781a0.k()) {
            f11 += this.f8781a0.j(this.f8783c0.e);
        }
        n7.h hVar = this.f8798i;
        if (hVar.f16406a && hVar.f16399t) {
            float f13 = hVar.G + hVar.f16408c;
            XAxis$XAxisPosition xAxis$XAxisPosition = hVar.I;
            if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTTOM) {
                f12 += f13;
            } else {
                if (xAxis$XAxisPosition != XAxis$XAxisPosition.TOP) {
                    if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTH_SIDED) {
                        f12 += f13;
                    }
                }
                f10 += f13;
            }
        }
        float extraTopOffset = getExtraTopOffset() + f10;
        float extraRightOffset = getExtraRightOffset() + f11;
        float extraBottomOffset = getExtraBottomOffset() + f12;
        float extraLeftOffset = getExtraLeftOffset() + f2;
        float c9 = h.c(this.U);
        this.f8807s.l(Math.max(c9, extraLeftOffset), Math.max(c9, extraTopOffset), Math.max(c9, extraRightOffset), Math.max(c9, extraBottomOffset));
        if (this.f8791a) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb2 = new StringBuilder("Content: ");
            sb2.append(this.f8807s.f19202b.toString());
            Log.i("MPAndroidChart", sb2.toString());
        }
        de.i iVar = this.f8785e0;
        this.f8781a0.getClass();
        iVar.q();
        de.i iVar2 = this.f8784d0;
        this.W.getClass();
        iVar2.q();
        u();
    }

    public i getAxisLeft() {
        return this.W;
    }

    public i getAxisRight() {
        return this.f8781a0;
    }

    @Override // com.github.mikephil.charting.charts.Chart, r7.e, r7.b
    public /* bridge */ /* synthetic */ c getData() {
        return (c) super.getData();
    }

    public e getDrawListener() {
        return null;
    }

    @Override // r7.b
    public float getHighestVisibleX() {
        de.i s7 = s(YAxis$AxisDependency.LEFT);
        RectF rectF = this.f8807s.f19202b;
        float f2 = rectF.right;
        float f10 = rectF.bottom;
        v7.c cVar = this.U0;
        s7.k(f2, f10, cVar);
        return (float) Math.min(this.f8798i.A, cVar.f19179b);
    }

    @Override // r7.b
    public float getLowestVisibleX() {
        de.i s7 = s(YAxis$AxisDependency.LEFT);
        RectF rectF = this.f8807s.f19202b;
        float f2 = rectF.left;
        float f10 = rectF.bottom;
        v7.c cVar = this.f8790k0;
        s7.k(f2, f10, cVar);
        return (float) Math.max(this.f8798i.B, cVar.f19179b);
    }

    @Override // com.github.mikephil.charting.charts.Chart, r7.e
    public int getMaxVisibleCount() {
        return this.F;
    }

    public float getMinOffset() {
        return this.U;
    }

    public v getRendererLeftYAxis() {
        return this.f8782b0;
    }

    public v getRendererRightYAxis() {
        return this.f8783c0;
    }

    public t getRendererXAxis() {
        return this.f8786f0;
    }

    @Override // android.view.View
    public float getScaleX() {
        v7.i iVar = this.f8807s;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f19208i;
    }

    @Override // android.view.View
    public float getScaleY() {
        v7.i iVar = this.f8807s;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f19209j;
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // com.github.mikephil.charting.charts.Chart, r7.e
    public float getYChartMax() {
        return Math.max(this.W.A, this.f8781a0.A);
    }

    @Override // com.github.mikephil.charting.charts.Chart, r7.e
    public float getYChartMin() {
        return Math.min(this.W.B, this.f8781a0.B);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void m() {
        super.m();
        this.W = new i(YAxis$AxisDependency.LEFT);
        this.f8781a0 = new i(YAxis$AxisDependency.RIGHT);
        this.f8784d0 = new de.i(this.f8807s);
        this.f8785e0 = new de.i(this.f8807s);
        this.f8782b0 = new v(this.f8807s, this.W, this.f8784d0);
        this.f8783c0 = new v(this.f8807s, this.f8781a0, this.f8785e0);
        this.f8786f0 = new t(this.f8807s, this.f8798i, this.f8784d0);
        setHighlighter(new q7.b(this));
        Matrix matrix = this.f8807s.f19201a;
        a aVar = new a(this);
        aVar.e = new Matrix();
        aVar.f18569f = new Matrix();
        aVar.f18570g = d.b(0.0f, 0.0f);
        aVar.f18571h = d.b(0.0f, 0.0f);
        aVar.f18572i = 1.0f;
        aVar.f18573j = 1.0f;
        aVar.f18574k = 1.0f;
        aVar.f18577n = 0L;
        aVar.f18578o = d.b(0.0f, 0.0f);
        aVar.f18579p = d.b(0.0f, 0.0f);
        aVar.e = matrix;
        aVar.f18580q = h.c(3.0f);
        aVar.r = h.c(3.5f);
        this.f8803n = aVar;
        Paint paint = new Paint();
        this.O = paint;
        paint.setStyle(Paint.Style.FILL);
        this.O.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.P = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.P.setColor(-16777216);
        this.P.setStrokeWidth(h.c(1.0f));
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final void n() {
        if (this.f8792b == null) {
            if (this.f8791a) {
                Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.f8791a) {
            Log.i("MPAndroidChart", "Preparing...");
        }
        u7.h hVar = this.f8806q;
        if (hVar != null) {
            hVar.p();
        }
        q();
        v vVar = this.f8782b0;
        i iVar = this.W;
        vVar.j(iVar.B, iVar.A);
        v vVar2 = this.f8783c0;
        i iVar2 = this.f8781a0;
        vVar2.j(iVar2.B, iVar2.A);
        t tVar = this.f8786f0;
        n7.h hVar2 = this.f8798i;
        tVar.j(hVar2.B, hVar2.A);
        if (this.f8801l != null) {
            this.f8805p.j(this.f8792b);
        }
        f();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onDraw(Canvas canvas) {
        int i3;
        int i10;
        super.onDraw(canvas);
        if (this.f8792b == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.Q) {
            canvas.drawRect(this.f8807s.f19202b, this.O);
        }
        if (this.R) {
            canvas.drawRect(this.f8807s.f19202b, this.P);
        }
        if (this.G) {
            float lowestVisibleX = getLowestVisibleX();
            float highestVisibleX = getHighestVisibleX();
            c cVar = (c) this.f8792b;
            ArrayList arrayList = cVar.f16833i;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                o7.d dVar = (o7.d) obj;
                dVar.f16821p = -3.4028235E38f;
                dVar.f16822q = Float.MAX_VALUE;
                List list = dVar.f16820o;
                if (list != null && !list.isEmpty() && (i10 = dVar.i(highestVisibleX, Float.NaN, DataSet$Rounding.UP)) >= (i3 = dVar.i(lowestVisibleX, Float.NaN, DataSet$Rounding.DOWN))) {
                    for (i3 = dVar.i(lowestVisibleX, Float.NaN, DataSet$Rounding.DOWN); i3 <= i10; i3++) {
                        dVar.d((Entry) dVar.f16820o.get(i3));
                    }
                }
            }
            cVar.a();
            n7.h hVar = this.f8798i;
            c cVar2 = (c) this.f8792b;
            hVar.a(cVar2.f16829d, cVar2.f16828c);
            i iVar = this.W;
            if (iVar.f16406a) {
                c cVar3 = (c) this.f8792b;
                YAxis$AxisDependency yAxis$AxisDependency = YAxis$AxisDependency.LEFT;
                iVar.a(cVar3.g(yAxis$AxisDependency), ((c) this.f8792b).f(yAxis$AxisDependency));
            }
            i iVar2 = this.f8781a0;
            if (iVar2.f16406a) {
                c cVar4 = (c) this.f8792b;
                YAxis$AxisDependency yAxis$AxisDependency2 = YAxis$AxisDependency.RIGHT;
                iVar2.a(cVar4.g(yAxis$AxisDependency2), ((c) this.f8792b).f(yAxis$AxisDependency2));
            }
            f();
        }
        i iVar3 = this.W;
        if (iVar3.f16406a) {
            this.f8782b0.j(iVar3.B, iVar3.A);
        }
        i iVar4 = this.f8781a0;
        if (iVar4.f16406a) {
            this.f8783c0.j(iVar4.B, iVar4.A);
        }
        n7.h hVar2 = this.f8798i;
        if (hVar2.f16406a) {
            this.f8786f0.j(hVar2.B, hVar2.A);
        }
        this.f8786f0.r(canvas);
        this.f8782b0.q(canvas);
        this.f8783c0.q(canvas);
        if (this.f8798i.f16402w) {
            this.f8786f0.s(canvas);
        }
        if (this.W.f16402w) {
            this.f8782b0.r(canvas);
        }
        if (this.f8781a0.f16402w) {
            this.f8783c0.r(canvas);
        }
        boolean z5 = this.f8798i.f16406a;
        boolean z6 = this.W.f16406a;
        boolean z8 = this.f8781a0.f16406a;
        int save = canvas.save();
        if (this.T) {
            canvas.clipRect(this.f8807s.f19202b);
        }
        this.f8806q.k(canvas);
        if (!this.f8798i.f16402w) {
            this.f8786f0.s(canvas);
        }
        if (!this.W.f16402w) {
            this.f8782b0.r(canvas);
        }
        if (!this.f8781a0.f16402w) {
            this.f8783c0.r(canvas);
        }
        if (p()) {
            this.f8806q.m(canvas, this.f8814z);
        }
        canvas.restoreToCount(save);
        this.f8806q.l(canvas);
        if (this.f8798i.f16406a) {
            this.f8786f0.t();
        }
        if (this.W.f16406a) {
            this.f8782b0.s();
        }
        if (this.f8781a0.f16406a) {
            this.f8783c0.s();
        }
        this.f8786f0.q(canvas);
        this.f8782b0.p(canvas);
        this.f8783c0.p(canvas);
        if (this.S) {
            int save2 = canvas.save();
            canvas.clipRect(this.f8807s.f19202b);
            this.f8806q.o(canvas);
            canvas.restoreToCount(save2);
        } else {
            this.f8806q.o(canvas);
        }
        this.f8805p.l(canvas);
        h(canvas);
        i(canvas);
        if (this.f8791a) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long j4 = this.f8787g0 + currentTimeMillis2;
            this.f8787g0 = j4;
            long j10 = this.f8788h0 + 1;
            this.f8788h0 = j10;
            Log.i("MPAndroidChart", "Drawtime: " + currentTimeMillis2 + " ms, average: " + (j4 / j10) + " ms, cycles: " + this.f8788h0);
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        float[] fArr = this.V0;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.V) {
            RectF rectF = this.f8807s.f19202b;
            fArr[0] = rectF.left;
            fArr[1] = rectF.top;
            s(YAxis$AxisDependency.LEFT).o(fArr);
        }
        super.onSizeChanged(i3, i10, i11, i12);
        if (!this.V) {
            v7.i iVar = this.f8807s;
            iVar.k(iVar.f19201a, this, true);
            return;
        }
        s(YAxis$AxisDependency.LEFT).p(fArr);
        v7.i iVar2 = this.f8807s;
        Matrix matrix = iVar2.f19213n;
        matrix.reset();
        matrix.set(iVar2.f19201a);
        float f2 = fArr[0];
        RectF rectF2 = iVar2.f19202b;
        matrix.postTranslate(-(f2 - rectF2.left), -(fArr[1] - rectF2.top));
        iVar2.k(matrix, this, true);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        t7.b bVar = this.f8803n;
        if (bVar == null || this.f8792b == null || !this.f8799j) {
            return false;
        }
        return bVar.onTouch(this, motionEvent);
    }

    public void q() {
        n7.h hVar = this.f8798i;
        o7.h hVar2 = this.f8792b;
        hVar.a(((c) hVar2).f16829d, ((c) hVar2).f16828c);
        i iVar = this.W;
        c cVar = (c) this.f8792b;
        YAxis$AxisDependency yAxis$AxisDependency = YAxis$AxisDependency.LEFT;
        iVar.a(cVar.g(yAxis$AxisDependency), ((c) this.f8792b).f(yAxis$AxisDependency));
        i iVar2 = this.f8781a0;
        c cVar2 = (c) this.f8792b;
        YAxis$AxisDependency yAxis$AxisDependency2 = YAxis$AxisDependency.RIGHT;
        iVar2.a(cVar2.g(yAxis$AxisDependency2), ((c) this.f8792b).f(yAxis$AxisDependency2));
    }

    public void r(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        f fVar = this.f8801l;
        if (fVar == null || !fVar.f16406a) {
            return;
        }
        int i3 = m7.a.f15982c[fVar.f16416i.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            int i10 = m7.a.f15980a[this.f8801l.f16415h.ordinal()];
            if (i10 == 1) {
                float f2 = rectF.top;
                f fVar2 = this.f8801l;
                rectF.top = Math.min(fVar2.f16425s, this.f8807s.f19204d * fVar2.f16424q) + this.f8801l.f16408c + f2;
                return;
            } else {
                if (i10 != 2) {
                    return;
                }
                float f10 = rectF.bottom;
                f fVar3 = this.f8801l;
                rectF.bottom = Math.min(fVar3.f16425s, this.f8807s.f19204d * fVar3.f16424q) + this.f8801l.f16408c + f10;
                return;
            }
        }
        int i11 = m7.a.f15981b[this.f8801l.f16414g.ordinal()];
        if (i11 == 1) {
            float f11 = rectF.left;
            f fVar4 = this.f8801l;
            rectF.left = Math.min(fVar4.r, this.f8807s.f19203c * fVar4.f16424q) + this.f8801l.f16407b + f11;
            return;
        }
        if (i11 == 2) {
            float f12 = rectF.right;
            f fVar5 = this.f8801l;
            rectF.right = Math.min(fVar5.r, this.f8807s.f19203c * fVar5.f16424q) + this.f8801l.f16407b + f12;
        } else {
            if (i11 != 3) {
                return;
            }
            int i12 = m7.a.f15980a[this.f8801l.f16415h.ordinal()];
            if (i12 == 1) {
                float f13 = rectF.top;
                f fVar6 = this.f8801l;
                rectF.top = Math.min(fVar6.f16425s, this.f8807s.f19204d * fVar6.f16424q) + this.f8801l.f16408c + f13;
            } else {
                if (i12 != 2) {
                    return;
                }
                float f14 = rectF.bottom;
                f fVar7 = this.f8801l;
                rectF.bottom = Math.min(fVar7.f16425s, this.f8807s.f19204d * fVar7.f16424q) + this.f8801l.f16408c + f14;
            }
        }
    }

    public final de.i s(YAxis$AxisDependency yAxis$AxisDependency) {
        return yAxis$AxisDependency == YAxis$AxisDependency.LEFT ? this.f8784d0 : this.f8785e0;
    }

    public void setAutoScaleMinMaxEnabled(boolean z5) {
        this.G = z5;
    }

    public void setBorderColor(int i3) {
        this.P.setColor(i3);
    }

    public void setBorderWidth(float f2) {
        this.P.setStrokeWidth(h.c(f2));
    }

    public void setClipDataToContent(boolean z5) {
        this.T = z5;
    }

    public void setClipValuesToContent(boolean z5) {
        this.S = z5;
    }

    public void setDoubleTapToZoomEnabled(boolean z5) {
        this.I = z5;
    }

    public void setDragEnabled(boolean z5) {
        this.K = z5;
        this.L = z5;
    }

    public void setDragOffsetX(float f2) {
        v7.i iVar = this.f8807s;
        iVar.getClass();
        iVar.f19211l = h.c(f2);
    }

    public void setDragOffsetY(float f2) {
        v7.i iVar = this.f8807s;
        iVar.getClass();
        iVar.f19212m = h.c(f2);
    }

    public void setDragXEnabled(boolean z5) {
        this.K = z5;
    }

    public void setDragYEnabled(boolean z5) {
        this.L = z5;
    }

    public void setDrawBorders(boolean z5) {
        this.R = z5;
    }

    public void setDrawGridBackground(boolean z5) {
        this.Q = z5;
    }

    public void setGridBackgroundColor(int i3) {
        this.O.setColor(i3);
    }

    public void setHighlightPerDragEnabled(boolean z5) {
        this.J = z5;
    }

    public void setKeepPositionOnRotation(boolean z5) {
        this.V = z5;
    }

    public void setMaxVisibleValueCount(int i3) {
        this.F = i3;
    }

    public void setMinOffset(float f2) {
        this.U = f2;
    }

    public void setOnDrawListener(e eVar) {
    }

    public void setPinchZoom(boolean z5) {
        this.H = z5;
    }

    public void setRendererLeftYAxis(v vVar) {
        this.f8782b0 = vVar;
    }

    public void setRendererRightYAxis(v vVar) {
        this.f8783c0 = vVar;
    }

    public void setScaleEnabled(boolean z5) {
        this.M = z5;
        this.N = z5;
    }

    public void setScaleXEnabled(boolean z5) {
        this.M = z5;
    }

    public void setScaleYEnabled(boolean z5) {
        this.N = z5;
    }

    public void setVisibleXRangeMaximum(float f2) {
        float f10 = this.f8798i.C / f2;
        v7.i iVar = this.f8807s;
        iVar.getClass();
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        iVar.f19206g = f10;
        iVar.i(iVar.f19201a, iVar.f19202b);
    }

    public void setVisibleXRangeMinimum(float f2) {
        float f10 = this.f8798i.C / f2;
        v7.i iVar = this.f8807s;
        iVar.getClass();
        if (f10 == 0.0f) {
            f10 = Float.MAX_VALUE;
        }
        iVar.f19207h = f10;
        iVar.i(iVar.f19201a, iVar.f19202b);
    }

    public void setXAxisRenderer(t tVar) {
        this.f8786f0 = tVar;
    }

    public final boolean t(YAxis$AxisDependency yAxis$AxisDependency) {
        (yAxis$AxisDependency == YAxis$AxisDependency.LEFT ? this.W : this.f8781a0).getClass();
        return false;
    }

    public void u() {
        if (this.f8791a) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.f8798i.B + ", xmax: " + this.f8798i.A + ", xdelta: " + this.f8798i.C);
        }
        de.i iVar = this.f8785e0;
        n7.h hVar = this.f8798i;
        float f2 = hVar.B;
        float f10 = hVar.C;
        i iVar2 = this.f8781a0;
        iVar.r(f2, f10, iVar2.C, iVar2.B);
        de.i iVar3 = this.f8784d0;
        n7.h hVar2 = this.f8798i;
        float f11 = hVar2.B;
        float f12 = hVar2.C;
        i iVar4 = this.W;
        iVar3.r(f11, f12, iVar4.C, iVar4.B);
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = 100;
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = true;
        this.U = 15.0f;
        this.V = false;
        this.f8787g0 = 0L;
        this.f8788h0 = 0L;
        this.i0 = new RectF();
        this.f8789j0 = new Matrix();
        new Matrix();
        this.f8790k0 = v7.c.b(0.0d, 0.0d);
        this.U0 = v7.c.b(0.0d, 0.0d);
        this.V0 = new float[2];
    }

    public BarLineChartBase(Context context) {
        super(context);
        this.F = 100;
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = true;
        this.U = 15.0f;
        this.V = false;
        this.f8787g0 = 0L;
        this.f8788h0 = 0L;
        this.i0 = new RectF();
        this.f8789j0 = new Matrix();
        new Matrix();
        this.f8790k0 = v7.c.b(0.0d, 0.0d);
        this.U0 = v7.c.b(0.0d, 0.0d);
        this.V0 = new float[2];
    }
}
