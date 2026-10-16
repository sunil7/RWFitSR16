package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.github.mikephil.charting.components.Legend$LegendDirection;
import com.github.mikephil.charting.components.Legend$LegendForm;
import com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend$LegendOrientation;
import com.github.mikephil.charting.components.Legend$LegendVerticalAlignment;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.data.Entry;
import com.google.android.material.internal.t;
import java.util.ArrayList;
import n6.a;
import n7.c;
import n7.d;
import n7.f;
import n7.g;
import o7.h;
import r7.e;
import t7.b;
import u7.k;
import v7.i;

/* loaded from: classes.dex */
public abstract class Chart<T extends h> extends ViewGroup implements e {
    public float A;
    public boolean B;
    public d C;
    public final ArrayList D;
    public boolean E;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8791a;

    /* renamed from: b, reason: collision with root package name */
    public h f8792b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8793c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8794d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public final a f8795f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f8796g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f8797h;

    /* renamed from: i, reason: collision with root package name */
    public n7.h f8798i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8799j;

    /* renamed from: k, reason: collision with root package name */
    public c f8800k;

    /* renamed from: l, reason: collision with root package name */
    public f f8801l;

    /* renamed from: m, reason: collision with root package name */
    public t7.d f8802m;

    /* renamed from: n, reason: collision with root package name */
    public b f8803n;

    /* renamed from: o, reason: collision with root package name */
    public String f8804o;

    /* renamed from: p, reason: collision with root package name */
    public k f8805p;

    /* renamed from: q, reason: collision with root package name */
    public u7.h f8806q;
    public q7.e r;

    /* renamed from: s, reason: collision with root package name */
    public i f8807s;

    /* renamed from: t, reason: collision with root package name */
    public k7.a f8808t;

    /* renamed from: u, reason: collision with root package name */
    public float f8809u;

    /* renamed from: v, reason: collision with root package name */
    public float f8810v;

    /* renamed from: w, reason: collision with root package name */
    public float f8811w;

    /* renamed from: x, reason: collision with root package name */
    public float f8812x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8813y;

    /* renamed from: z, reason: collision with root package name */
    public q7.c[] f8814z;

    public Chart(Context context) {
        super(context);
        this.f8791a = false;
        this.f8792b = null;
        this.f8793c = true;
        this.f8794d = true;
        this.e = 0.9f;
        this.f8795f = new a(0);
        this.f8799j = true;
        this.f8804o = "No chart data available.";
        this.f8807s = new i();
        this.f8809u = 0.0f;
        this.f8810v = 0.0f;
        this.f8811w = 0.0f;
        this.f8812x = 0.0f;
        this.f8813y = false;
        this.A = 0.0f;
        this.B = true;
        this.D = new ArrayList();
        this.E = false;
        m();
    }

    public static void o(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                o(viewGroup.getChildAt(i3));
                i3++;
            }
        }
    }

    public final void d(int i3) {
        k7.a aVar = this.f8808t;
        aVar.getClass();
        k7.b bVar = k7.c.f15528a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(bVar);
        ofFloat.setDuration(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar, "phaseY", 0.0f, 1.0f);
        ofFloat2.setInterpolator(bVar);
        ofFloat2.setDuration(i3);
        t tVar = aVar.f15526a;
        if (i3 < 0) {
            ofFloat.addUpdateListener(tVar);
        } else {
            ofFloat2.addUpdateListener(tVar);
        }
        ofFloat.start();
        ofFloat2.start();
    }

    public final void e() {
        k7.a aVar = this.f8808t;
        aVar.getClass();
        k7.b bVar = k7.c.f15528a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(bVar);
        ofFloat.setDuration(1500);
        ofFloat.addUpdateListener(aVar.f15526a);
        ofFloat.start();
    }

    public abstract void f();

    public final void g() {
        this.f8792b = null;
        this.f8813y = false;
        this.f8814z = null;
        this.f8803n.f18582b = null;
        invalidate();
    }

    public k7.a getAnimator() {
        return this.f8808t;
    }

    public v7.d getCenter() {
        return v7.d.b(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public v7.d getCenterOfView() {
        return getCenter();
    }

    public v7.d getCenterOffsets() {
        RectF rectF = this.f8807s.f19202b;
        return v7.d.b(rectF.centerX(), rectF.centerY());
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.f8807s.f19202b;
    }

    public T getData() {
        return (T) this.f8792b;
    }

    public p7.d getDefaultValueFormatter() {
        return this.f8795f;
    }

    public c getDescription() {
        return this.f8800k;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.e;
    }

    public float getExtraBottomOffset() {
        return this.f8811w;
    }

    public float getExtraLeftOffset() {
        return this.f8812x;
    }

    public float getExtraRightOffset() {
        return this.f8810v;
    }

    public float getExtraTopOffset() {
        return this.f8809u;
    }

    public q7.c[] getHighlighted() {
        return this.f8814z;
    }

    public q7.e getHighlighter() {
        return this.r;
    }

    public ArrayList<Runnable> getJobs() {
        return this.D;
    }

    public f getLegend() {
        return this.f8801l;
    }

    public k getLegendRenderer() {
        return this.f8805p;
    }

    public d getMarker() {
        return this.C;
    }

    @Deprecated
    public d getMarkerView() {
        return getMarker();
    }

    @Override // r7.e
    public float getMaxHighlightDistance() {
        return this.A;
    }

    public abstract /* synthetic */ int getMaxVisibleCount();

    public t7.c getOnChartGestureListener() {
        return null;
    }

    public b getOnTouchListener() {
        return this.f8803n;
    }

    public u7.h getRenderer() {
        return this.f8806q;
    }

    public i getViewPortHandler() {
        return this.f8807s;
    }

    public n7.h getXAxis() {
        return this.f8798i;
    }

    public float getXChartMax() {
        return this.f8798i.A;
    }

    public float getXChartMin() {
        return this.f8798i.B;
    }

    public float getXRange() {
        return this.f8798i.C;
    }

    public abstract /* synthetic */ float getYChartMax();

    public abstract /* synthetic */ float getYChartMin();

    public float getYMax() {
        return this.f8792b.f16826a;
    }

    public float getYMin() {
        return this.f8792b.f16827b;
    }

    public final void h(Canvas canvas) {
        c cVar = this.f8800k;
        if (cVar == null || !cVar.f16406a) {
            return;
        }
        Paint paint = this.f8796g;
        cVar.getClass();
        paint.setTypeface(null);
        this.f8796g.setTextSize(this.f8800k.f16409d);
        this.f8796g.setColor(this.f8800k.e);
        this.f8796g.setTextAlign(this.f8800k.f16411g);
        float width = getWidth();
        i iVar = this.f8807s;
        float f2 = (width - (iVar.f19203c - iVar.f19202b.right)) - this.f8800k.f16407b;
        float height = getHeight() - this.f8807s.j();
        c cVar2 = this.f8800k;
        canvas.drawText(cVar2.f16410f, f2, height - cVar2.f16408c, this.f8796g);
    }

    public void i(Canvas canvas) {
        if (this.C == null || !this.B || !p()) {
            return;
        }
        int i3 = 0;
        while (true) {
            q7.c[] cVarArr = this.f8814z;
            if (i3 >= cVarArr.length) {
                return;
            }
            q7.c cVar = cVarArr[i3];
            o7.d b3 = this.f8792b.b(cVar.f17801f);
            Entry e = this.f8792b.e(this.f8814z[i3]);
            int indexOf = b3.f16820o.indexOf(e);
            if (e != null) {
                float f2 = indexOf;
                float size = b3.f16820o.size();
                this.f8808t.getClass();
                if (f2 <= size * 1.0f) {
                    float[] k10 = k(cVar);
                    i iVar = this.f8807s;
                    float f10 = k10[0];
                    float f11 = k10[1];
                    if (iVar.g(f10) && iVar.h(f11)) {
                        this.C.a(e, cVar);
                        d dVar = this.C;
                        float f12 = k10[0];
                        float f13 = k10[1];
                        MarkerView markerView = (MarkerView) dVar;
                        v7.d offset = markerView.getOffset();
                        float f14 = offset.f19182b;
                        v7.d dVar2 = markerView.f8823b;
                        dVar2.f19182b = f14;
                        dVar2.f19183c = offset.f19183c;
                        Chart chartView = markerView.getChartView();
                        float width = markerView.getWidth();
                        float height = markerView.getHeight();
                        float f15 = dVar2.f19182b;
                        if (f12 + f15 < 0.0f) {
                            dVar2.f19182b = -f12;
                        } else if (chartView != null && f12 + width + f15 > chartView.getWidth()) {
                            dVar2.f19182b = (chartView.getWidth() - f12) - width;
                        }
                        float f16 = dVar2.f19183c;
                        if (f13 + f16 < 0.0f) {
                            dVar2.f19183c = -f13;
                        } else if (chartView != null && f13 + height + f16 > chartView.getHeight()) {
                            dVar2.f19183c = (chartView.getHeight() - f13) - height;
                        }
                        int save = canvas.save();
                        canvas.translate(f12 + dVar2.f19182b, f13 + dVar2.f19183c);
                        markerView.draw(canvas);
                        canvas.restoreToCount(save);
                    }
                }
            }
            i3++;
        }
    }

    public q7.c j(float f2, float f10) {
        if (this.f8792b != null) {
            return getHighlighter().b(f2, f10);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    public float[] k(q7.c cVar) {
        return new float[]{cVar.f17804i, cVar.f17805j};
    }

    public final void l(q7.c cVar) {
        Entry entry = null;
        if (cVar == null) {
            this.f8814z = null;
        } else {
            if (this.f8791a) {
                Log.i("MPAndroidChart", "Highlighted: " + cVar.toString());
            }
            Entry e = this.f8792b.e(cVar);
            if (e == null) {
                this.f8814z = null;
            } else {
                this.f8814z = new q7.c[]{cVar};
            }
            entry = e;
        }
        setLastHighlighted(this.f8814z);
        if (this.f8802m != null) {
            if (p()) {
                this.f8802m.x(entry);
            } else {
                this.f8802m.A();
            }
        }
        invalidate();
    }

    public void m() {
        setWillNotDraw(false);
        t tVar = new t(this, 8);
        k7.a aVar = new k7.a();
        aVar.f15526a = tVar;
        this.f8808t = aVar;
        Context context = getContext();
        DisplayMetrics displayMetrics = v7.h.f19191a;
        if (context == null) {
            v7.h.f19192b = ViewConfiguration.getMinimumFlingVelocity();
            v7.h.f19193c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            v7.h.f19192b = viewConfiguration.getScaledMinimumFlingVelocity();
            v7.h.f19193c = viewConfiguration.getScaledMaximumFlingVelocity();
            v7.h.f19191a = context.getResources().getDisplayMetrics();
        }
        this.A = v7.h.c(500.0f);
        c cVar = new c();
        cVar.f16410f = "Description Label";
        cVar.f16411g = Paint.Align.RIGHT;
        cVar.f16409d = v7.h.c(8.0f);
        this.f8800k = cVar;
        f fVar = new f();
        fVar.f16413f = new g[0];
        fVar.f16414g = Legend$LegendHorizontalAlignment.LEFT;
        fVar.f16415h = Legend$LegendVerticalAlignment.BOTTOM;
        fVar.f16416i = Legend$LegendOrientation.HORIZONTAL;
        fVar.f16417j = Legend$LegendDirection.LEFT_TO_RIGHT;
        fVar.f16418k = Legend$LegendForm.SQUARE;
        fVar.f16419l = 8.0f;
        fVar.f16420m = 3.0f;
        fVar.f16421n = 6.0f;
        fVar.f16422o = 5.0f;
        fVar.f16423p = 3.0f;
        fVar.f16424q = 0.95f;
        fVar.r = 0.0f;
        fVar.f16425s = 0.0f;
        fVar.f16426t = 0.0f;
        fVar.f16427u = new ArrayList(16);
        fVar.f16428v = new ArrayList(16);
        fVar.f16429w = new ArrayList(16);
        fVar.f16409d = v7.h.c(10.0f);
        fVar.f16407b = v7.h.c(5.0f);
        fVar.f16408c = v7.h.c(3.0f);
        this.f8801l = fVar;
        k kVar = new k(this.f8807s);
        kVar.e = new ArrayList(16);
        kVar.f18959f = new Paint.FontMetrics();
        kVar.f18960g = new Path();
        kVar.f18958d = fVar;
        Paint paint = new Paint(1);
        kVar.f18956b = paint;
        paint.setTextSize(v7.h.c(9.0f));
        paint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        kVar.f18957c = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f8805p = kVar;
        n7.h hVar = new n7.h();
        hVar.F = 1;
        hVar.G = 1;
        hVar.H = false;
        hVar.I = XAxis$XAxisPosition.TOP;
        hVar.f16408c = v7.h.c(4.0f);
        this.f8798i = hVar;
        this.f8796g = new Paint(1);
        Paint paint3 = new Paint(1);
        this.f8797h = paint3;
        paint3.setColor(Color.rgb(247, 189, 51));
        this.f8797h.setTextAlign(Paint.Align.CENTER);
        this.f8797h.setTextSize(v7.h.c(12.0f));
        if (this.f8791a) {
            Log.i("", "Chart.init()");
        }
    }

    public abstract void n();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.E) {
            o(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f8792b != null) {
            if (this.f8813y) {
                return;
            }
            f();
            this.f8813y = true;
            return;
        }
        if (TextUtils.isEmpty(this.f8804o)) {
            return;
        }
        v7.d center = getCenter();
        int i3 = m7.b.f15983a[this.f8797h.getTextAlign().ordinal()];
        if (i3 == 1) {
            center.f19182b = 0.0f;
            canvas.drawText(this.f8804o, 0.0f, center.f19183c, this.f8797h);
        } else {
            if (i3 != 2) {
                canvas.drawText(this.f8804o, center.f19182b, center.f19183c, this.f8797h);
                return;
            }
            float f2 = (float) (center.f19182b * 2.0d);
            center.f19182b = f2;
            canvas.drawText(this.f8804o, f2, center.f19183c, this.f8797h);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            getChildAt(i13).layout(i3, i10, i11, i12);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        int c9 = (int) v7.h.c(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(c9, i3)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(c9, i10)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i10, int i11, int i12) {
        if (this.f8791a) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i3 > 0 && i10 > 0 && i3 < 10000 && i10 < 10000) {
            if (this.f8791a) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i3 + ", height: " + i10);
            }
            i iVar = this.f8807s;
            RectF rectF = iVar.f19202b;
            float f2 = rectF.left;
            float f10 = rectF.top;
            float f11 = iVar.f19203c - rectF.right;
            float j4 = iVar.j();
            iVar.f19204d = i10;
            iVar.f19203c = i3;
            iVar.l(f2, f10, f11, j4);
        } else if (this.f8791a) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i3 + ", height: " + i10);
        }
        n();
        ArrayList arrayList = this.D;
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            post((Runnable) obj);
        }
        arrayList.clear();
        super.onSizeChanged(i3, i10, i11, i12);
    }

    public final boolean p() {
        q7.c[] cVarArr = this.f8814z;
        return (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) ? false : true;
    }

    public void setData(T t8) {
        this.f8792b = t8;
        int i3 = 0;
        this.f8813y = false;
        if (t8 == null) {
            return;
        }
        float f2 = t8.f16827b;
        float f10 = t8.f16826a;
        float h4 = v7.h.h(t8.d() < 2 ? Math.max(Math.abs(f2), Math.abs(f10)) : Math.abs(f10 - f2));
        int ceil = Float.isInfinite(h4) ? 0 : ((int) Math.ceil(-Math.log10(h4))) + 2;
        a aVar = this.f8795f;
        aVar.W(ceil);
        ArrayList arrayList = this.f8792b.f16833i;
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            o7.d dVar = (o7.d) obj;
            if (dVar.f16811f == null || dVar.j() == aVar) {
                dVar.f16811f = aVar;
            }
        }
        n();
        if (this.f8791a) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(c cVar) {
        this.f8800k = cVar;
    }

    public void setDragDecelerationEnabled(boolean z5) {
        this.f8794d = z5;
    }

    public void setDragDecelerationFrictionCoef(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 >= 1.0f) {
            f2 = 0.999f;
        }
        this.e = f2;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z5) {
        setDrawMarkers(z5);
    }

    public void setDrawMarkers(boolean z5) {
        this.B = z5;
    }

    public void setExtraBottomOffset(float f2) {
        this.f8811w = v7.h.c(f2);
    }

    public void setExtraLeftOffset(float f2) {
        this.f8812x = v7.h.c(f2);
    }

    public void setExtraRightOffset(float f2) {
        this.f8810v = v7.h.c(f2);
    }

    public void setExtraTopOffset(float f2) {
        this.f8809u = v7.h.c(f2);
    }

    public void setHardwareAccelerationEnabled(boolean z5) {
        if (z5) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z5) {
        this.f8793c = z5;
    }

    public void setHighlighter(q7.b bVar) {
        this.r = bVar;
    }

    public void setLastHighlighted(q7.c[] cVarArr) {
        q7.c cVar;
        if (cVarArr == null || cVarArr.length <= 0 || (cVar = cVarArr[0]) == null) {
            this.f8803n.f18582b = null;
        } else {
            this.f8803n.f18582b = cVar;
        }
    }

    public void setLogEnabled(boolean z5) {
        this.f8791a = z5;
    }

    public void setMarker(d dVar) {
        this.C = dVar;
    }

    @Deprecated
    public void setMarkerView(d dVar) {
        setMarker(dVar);
    }

    public void setMaxHighlightDistance(float f2) {
        this.A = v7.h.c(f2);
    }

    public void setNoDataText(String str) {
        this.f8804o = str;
    }

    public void setNoDataTextAlignment(Paint.Align align) {
        this.f8797h.setTextAlign(align);
    }

    public void setNoDataTextColor(int i3) {
        this.f8797h.setColor(i3);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.f8797h.setTypeface(typeface);
    }

    public void setOnChartGestureListener(t7.c cVar) {
    }

    public void setOnChartValueSelectedListener(t7.d dVar) {
        this.f8802m = dVar;
    }

    public void setOnTouchListener(b bVar) {
        this.f8803n = bVar;
    }

    public void setRenderer(u7.h hVar) {
        if (hVar != null) {
            this.f8806q = hVar;
        }
    }

    public void setTouchEnabled(boolean z5) {
        this.f8799j = z5;
    }

    public void setUnbindEnabled(boolean z5) {
        this.E = z5;
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8791a = false;
        this.f8792b = null;
        this.f8793c = true;
        this.f8794d = true;
        this.e = 0.9f;
        this.f8795f = new a(0);
        this.f8799j = true;
        this.f8804o = "No chart data available.";
        this.f8807s = new i();
        this.f8809u = 0.0f;
        this.f8810v = 0.0f;
        this.f8811w = 0.0f;
        this.f8812x = 0.0f;
        this.f8813y = false;
        this.A = 0.0f;
        this.B = true;
        this.D = new ArrayList();
        this.E = false;
        m();
    }

    public Chart(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8791a = false;
        this.f8792b = null;
        this.f8793c = true;
        this.f8794d = true;
        this.e = 0.9f;
        this.f8795f = new a(0);
        this.f8799j = true;
        this.f8804o = "No chart data available.";
        this.f8807s = new i();
        this.f8809u = 0.0f;
        this.f8810v = 0.0f;
        this.f8811w = 0.0f;
        this.f8812x = 0.0f;
        this.f8813y = false;
        this.A = 0.0f;
        this.B = true;
        this.D = new ArrayList();
        this.E = false;
        m();
    }
}
