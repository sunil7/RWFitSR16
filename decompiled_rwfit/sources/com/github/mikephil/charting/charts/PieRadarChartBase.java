package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend$LegendVerticalAlignment;
import java.util.ArrayList;
import m7.d;
import n7.f;
import o7.h;
import t7.b;
import t7.g;

/* loaded from: classes.dex */
public abstract class PieRadarChartBase<T extends h> extends Chart<T> {
    public float F;
    public float G;
    public boolean H;
    public float I;

    public PieRadarChartBase(Context context) {
        super(context);
        this.F = 270.0f;
        this.G = 270.0f;
        this.H = true;
        this.I = 0.0f;
    }

    @Override // android.view.View
    public final void computeScroll() {
        b bVar = this.f8803n;
        if (bVar instanceof g) {
            g gVar = (g) bVar;
            if (gVar.f18590i == 0.0f) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f2 = gVar.f18590i;
            Chart chart = gVar.f18584d;
            PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) chart;
            gVar.f18590i = pieRadarChartBase.getDragDecelerationFrictionCoef() * f2;
            pieRadarChartBase.setRotationAngle((gVar.f18590i * ((currentAnimationTimeMillis - gVar.f18589h) / 1000.0f)) + pieRadarChartBase.getRotationAngle());
            gVar.f18589h = currentAnimationTimeMillis;
            if (Math.abs(gVar.f18590i) < 0.001d) {
                gVar.f18590i = 0.0f;
            } else {
                DisplayMetrics displayMetrics = v7.h.f19191a;
                chart.postInvalidateOnAnimation();
            }
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void f() {
        float f2;
        float f10;
        float f11;
        float f12;
        float c9;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        Legend$LegendVerticalAlignment legend$LegendVerticalAlignment;
        f fVar = this.f8801l;
        float f18 = 0.0f;
        if (fVar == null || !fVar.f16406a) {
            f2 = 0.0f;
            f10 = 0.0f;
            f11 = 0.0f;
            f12 = 0.0f;
        } else {
            float min = Math.min(fVar.r, this.f8807s.f19203c * fVar.f16424q);
            int i3 = d.f15990c[this.f8801l.f16416i.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && ((legend$LegendVerticalAlignment = this.f8801l.f16415h) == Legend$LegendVerticalAlignment.TOP || legend$LegendVerticalAlignment == Legend$LegendVerticalAlignment.BOTTOM)) {
                    float requiredLegendOffset = getRequiredLegendOffset();
                    f fVar2 = this.f8801l;
                    f17 = Math.min(fVar2.f16425s + requiredLegendOffset, this.f8807s.f19204d * fVar2.f16424q);
                    int i10 = d.f15988a[this.f8801l.f16415h.ordinal()];
                    if (i10 == 1) {
                        f16 = 0.0f;
                        f14 = f16;
                    } else if (i10 == 2) {
                        f16 = f17;
                        f17 = 0.0f;
                        f14 = 0.0f;
                    }
                }
                f17 = 0.0f;
                f16 = 0.0f;
                f14 = f16;
            } else {
                f fVar3 = this.f8801l;
                Legend$LegendHorizontalAlignment legend$LegendHorizontalAlignment = fVar3.f16414g;
                if (legend$LegendHorizontalAlignment != Legend$LegendHorizontalAlignment.LEFT && legend$LegendHorizontalAlignment != Legend$LegendHorizontalAlignment.RIGHT) {
                    c9 = 0.0f;
                } else if (fVar3.f16415h == Legend$LegendVerticalAlignment.CENTER) {
                    c9 = v7.h.c(13.0f) + min;
                } else {
                    float c10 = v7.h.c(8.0f) + min;
                    f fVar4 = this.f8801l;
                    float f19 = fVar4.f16425s + fVar4.f16426t;
                    v7.d center = getCenter();
                    float width = this.f8801l.f16414g == Legend$LegendHorizontalAlignment.RIGHT ? (getWidth() - c10) + 15.0f : c10 - 15.0f;
                    float f20 = f19 + 15.0f;
                    float r = r(width, f20);
                    float radius = getRadius();
                    float s7 = s(width, f20);
                    v7.d b3 = v7.d.b(0.0f, 0.0f);
                    double d5 = radius;
                    double d8 = s7;
                    b3.f19182b = (float) ((Math.cos(Math.toRadians(d8)) * d5) + center.f19182b);
                    float sin = (float) ((Math.sin(Math.toRadians(d8)) * d5) + center.f19183c);
                    b3.f19183c = sin;
                    float r8 = r(b3.f19182b, sin);
                    c9 = (f20 < center.f19183c || ((float) getHeight()) - c10 <= ((float) getWidth())) ? r < r8 ? (r8 - r) + v7.h.c(5.0f) : 0.0f : c10;
                    v7.d.c(center);
                    v7.d.c(b3);
                }
                int i11 = d.f15989b[this.f8801l.f16414g.ordinal()];
                if (i11 == 1) {
                    f18 = c9;
                    f13 = 0.0f;
                } else if (i11 != 2) {
                    if (i11 == 3) {
                        int i12 = d.f15988a[this.f8801l.f16415h.ordinal()];
                        if (i12 == 1) {
                            f fVar5 = this.f8801l;
                            f15 = Math.min(fVar5.f16425s, this.f8807s.f19204d * fVar5.f16424q);
                            f13 = 0.0f;
                            f18 = 0.0f;
                            f14 = 0.0f;
                            float f21 = f15;
                            f16 = f13;
                            f17 = f21;
                        } else if (i12 == 2) {
                            f fVar6 = this.f8801l;
                            f13 = Math.min(fVar6.f16425s, this.f8807s.f19204d * fVar6.f16424q);
                            f18 = 0.0f;
                        }
                    }
                    f13 = 0.0f;
                    f18 = 0.0f;
                } else {
                    f14 = c9;
                    f13 = 0.0f;
                    f18 = 0.0f;
                    f15 = 0.0f;
                    float f212 = f15;
                    f16 = f13;
                    f17 = f212;
                }
                f15 = 0.0f;
                f14 = 0.0f;
                float f2122 = f15;
                f16 = f13;
                f17 = f2122;
            }
            f10 = f18 + getRequiredBaseOffset();
            f12 = getRequiredBaseOffset() + f14;
            f2 = f17 + getRequiredBaseOffset();
            f11 = f16 + getRequiredBaseOffset();
        }
        float c11 = v7.h.c(this.I);
        if (this instanceof RadarChart) {
            n7.h xAxis = getXAxis();
            if (xAxis.f16406a && xAxis.f16399t) {
                c11 = Math.max(c11, xAxis.F);
            }
        }
        float extraTopOffset = getExtraTopOffset() + f2;
        float extraRightOffset = getExtraRightOffset() + f12;
        float extraBottomOffset = getExtraBottomOffset() + f11;
        float max = Math.max(c11, getExtraLeftOffset() + f10);
        float max2 = Math.max(c11, extraTopOffset);
        float max3 = Math.max(c11, extraRightOffset);
        float max4 = Math.max(c11, Math.max(getRequiredBaseOffset(), extraBottomOffset));
        this.f8807s.l(max, max2, max3, max4);
        if (this.f8791a) {
            Log.i("MPAndroidChart", "offsetLeft: " + max + ", offsetTop: " + max2 + ", offsetRight: " + max3 + ", offsetBottom: " + max4);
        }
    }

    public float getDiameter() {
        RectF rectF = this.f8807s.f19202b;
        rectF.left = getExtraLeftOffset() + rectF.left;
        rectF.top = getExtraTopOffset() + rectF.top;
        rectF.right -= getExtraRightOffset();
        rectF.bottom -= getExtraBottomOffset();
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // com.github.mikephil.charting.charts.Chart, r7.e
    public int getMaxVisibleCount() {
        return this.f8792b.d();
    }

    public float getMinOffset() {
        return this.I;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.G;
    }

    public abstract float getRequiredBaseOffset();

    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.F;
    }

    @Override // com.github.mikephil.charting.charts.Chart, r7.e
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart, r7.e
    public float getYChartMin() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void m() {
        super.m();
        g gVar = new g(this);
        gVar.e = v7.d.b(0.0f, 0.0f);
        gVar.f18587f = 0.0f;
        gVar.f18588g = new ArrayList();
        gVar.f18589h = 0L;
        gVar.f18590i = 0.0f;
        this.f8803n = gVar;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void n() {
        if (this.f8792b == null) {
            return;
        }
        q();
        if (this.f8801l != null) {
            this.f8805p.j(this.f8792b);
        }
        f();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        return (!this.f8799j || (bVar = this.f8803n) == null) ? super.onTouchEvent(motionEvent) : bVar.onTouch(this, motionEvent);
    }

    public void q() {
    }

    public final float r(float f2, float f10) {
        v7.d centerOffsets = getCenterOffsets();
        float f11 = centerOffsets.f19182b;
        float f12 = f2 > f11 ? f2 - f11 : f11 - f2;
        float sqrt = (float) Math.sqrt(Math.pow(f10 > centerOffsets.f19183c ? f10 - r1 : r1 - f10, 2.0d) + Math.pow(f12, 2.0d));
        v7.d.c(centerOffsets);
        return sqrt;
    }

    public final float s(float f2, float f10) {
        v7.d centerOffsets = getCenterOffsets();
        double d5 = f2 - centerOffsets.f19182b;
        double d8 = f10 - centerOffsets.f19183c;
        float degrees = (float) Math.toDegrees(Math.acos(d8 / Math.sqrt((d8 * d8) + (d5 * d5))));
        if (f2 > centerOffsets.f19182b) {
            degrees = 360.0f - degrees;
        }
        float f11 = degrees + 90.0f;
        if (f11 > 360.0f) {
            f11 -= 360.0f;
        }
        v7.d.c(centerOffsets);
        return f11;
    }

    public void setMinOffset(float f2) {
        this.I = f2;
    }

    public void setRotationAngle(float f2) {
        this.G = f2;
        DisplayMetrics displayMetrics = v7.h.f19191a;
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.F = f2 % 360.0f;
    }

    public void setRotationEnabled(boolean z5) {
        this.H = z5;
    }

    public abstract int t(float f2);

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = 270.0f;
        this.G = 270.0f;
        this.H = true;
        this.I = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = 270.0f;
        this.G = 270.0f;
        this.H = true;
        this.I = 0.0f;
    }
}
