package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import o7.a;
import o7.g;
import o7.h;
import o7.i;
import o7.j;
import o7.l;
import q7.c;
import r7.f;

/* loaded from: classes.dex */
public class CombinedChart extends BarLineChartBase<i> implements f {
    public boolean W0;
    public boolean X0;
    public boolean Y0;
    public DrawOrder[] Z0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class DrawOrder {
        public static final DrawOrder BAR;
        public static final DrawOrder BUBBLE;
        public static final DrawOrder CANDLE;
        public static final DrawOrder LINE;
        public static final DrawOrder SCATTER;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DrawOrder[] f8815a;

        static {
            DrawOrder drawOrder = new DrawOrder("BAR", 0);
            BAR = drawOrder;
            DrawOrder drawOrder2 = new DrawOrder("BUBBLE", 1);
            BUBBLE = drawOrder2;
            DrawOrder drawOrder3 = new DrawOrder("LINE", 2);
            LINE = drawOrder3;
            DrawOrder drawOrder4 = new DrawOrder("CANDLE", 3);
            CANDLE = drawOrder4;
            DrawOrder drawOrder5 = new DrawOrder("SCATTER", 4);
            SCATTER = drawOrder5;
            f8815a = new DrawOrder[]{drawOrder, drawOrder2, drawOrder3, drawOrder4, drawOrder5};
        }

        public static DrawOrder valueOf(String str) {
            return (DrawOrder) Enum.valueOf(DrawOrder.class, str);
        }

        public static DrawOrder[] values() {
            return (DrawOrder[]) f8815a.clone();
        }
    }

    public CombinedChart(Context context) {
        super(context);
        this.W0 = true;
        this.X0 = false;
        this.Y0 = false;
    }

    @Override // r7.a
    public final boolean a() {
        return this.Y0;
    }

    @Override // r7.a
    public final boolean b() {
        return this.W0;
    }

    @Override // r7.a
    public final boolean c() {
        return this.X0;
    }

    @Override // r7.a
    public a getBarData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // r7.c
    public o7.f getBubbleData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // r7.d
    public g getCandleData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // r7.f
    public i getCombinedData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    public DrawOrder[] getDrawOrder() {
        return this.Z0;
    }

    @Override // r7.g
    public j getLineData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // r7.h
    public l getScatterData() {
        if (this.f8792b == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final void i(Canvas canvas) {
        if (this.C != null && this.B && p()) {
            c[] cVarArr = this.f8814z;
            if (cVarArr.length <= 0) {
                return;
            }
            c cVar = cVarArr[0];
            this.f8792b.getClass();
            throw new ClassCastException();
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public final c j(float f2, float f10) {
        if (this.f8792b == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        c b3 = getHighlighter().b(f2, f10);
        return (b3 == null || !this.X0) ? b3 : new c(b3.f17797a, b3.f17798b, b3.f17799c, b3.f17800d, b3.f17801f, b3.f17803h, 0);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public final void m() {
        super.m();
        this.Z0 = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new q7.a(this, this));
        setHighlightFullBarEnabled(true);
        u7.g gVar = new u7.g(this.f8808t, this.f8807s);
        gVar.f18945f = new ArrayList(5);
        gVar.f18947h = new ArrayList();
        gVar.f18946g = new WeakReference(this);
        gVar.r();
        this.f8806q = gVar;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public /* synthetic */ void setData(h hVar) {
        if (hVar != null) {
            throw new ClassCastException();
        }
        setData((i) null);
    }

    public void setDrawBarShadow(boolean z5) {
        this.Y0 = z5;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.Z0 = drawOrderArr;
    }

    public void setDrawValueAboveBar(boolean z5) {
        this.W0 = z5;
    }

    public void setHighlightFullBarEnabled(boolean z5) {
        this.X0 = z5;
    }

    public void setData(i iVar) {
        super.setData((CombinedChart) iVar);
        setHighlighter(new q7.a(this, this));
        ((u7.g) this.f8806q).r();
        this.f8806q.p();
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W0 = true;
        this.X0 = false;
        this.Y0 = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.W0 = true;
        this.X0 = false;
        this.Y0 = false;
    }
}
