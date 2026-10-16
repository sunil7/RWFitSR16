package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.example.test.R$color;
import java.util.List;

/* loaded from: classes.dex */
public class TRingSleepDetailChartView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8628a;

    /* renamed from: b, reason: collision with root package name */
    public int f8629b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8630c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8631d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public List f8632f;

    /* renamed from: g, reason: collision with root package name */
    public x6.a f8633g;

    /* renamed from: h, reason: collision with root package name */
    public float f8634h;

    /* renamed from: i, reason: collision with root package name */
    public float f8635i;

    /* renamed from: j, reason: collision with root package name */
    public q f8636j;

    public TRingSleepDetailChartView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<x6.a> getData() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 1
            r0.<init>(r1)
            r2 = 10
            r3 = 0
            r4 = r2
        La:
            int r5 = r11.f8628a
            int r5 = r5 - r2
            if (r4 >= r5) goto L7e
            java.util.Random r5 = new java.util.Random
            r5.<init>()
            r6 = 4
            int r5 = r5.nextInt(r6)
            if (r5 != 0) goto L22
            int r3 = r3 + 1
            r6 = 3
            if (r3 < r6) goto L22
            int r5 = r5 + 1
        L22:
            x6.a r6 = new x6.a
            r6.<init>()
            r6.f19813a = r5
            android.graphics.Path r5 = new android.graphics.Path
            r5.<init>()
            int r7 = r6.f19813a
            r8 = 1077936128(0x40400000, float:3.0)
            if (r7 != 0) goto L3e
            int r7 = r11.f8629b
            int r9 = r7 * 2
            float r9 = (float) r9
            float r9 = r9 / r8
        L3a:
            int r7 = r7 + (-20)
            float r7 = (float) r7
            goto L53
        L3e:
            r9 = 1101004800(0x41a00000, float:20.0)
            if (r7 != r1) goto L47
            int r7 = r11.f8629b
        L44:
            float r7 = (float) r7
            float r7 = r7 / r8
            goto L53
        L47:
            r10 = 2
            if (r7 != r10) goto L50
            int r7 = r11.f8629b
            float r9 = (float) r7
            float r9 = r9 / r8
            int r7 = r7 * r10
            goto L44
        L50:
            int r7 = r11.f8629b
            goto L3a
        L53:
            float r8 = (float) r4
            r5.moveTo(r8, r9)
            r5.lineTo(r8, r7)
            java.util.Random r8 = new java.util.Random
            r8.<init>()
            r10 = 30
            int r8 = r8.nextInt(r10)
            int r8 = r8 + r2
            int r8 = r8 + r4
            int r4 = r11.f8628a
            int r10 = r4 + (-10)
            if (r8 < r10) goto L70
            int r4 = r4 + (-10)
            goto L71
        L70:
            r4 = r8
        L71:
            float r8 = (float) r4
            r5.lineTo(r8, r7)
            r5.lineTo(r8, r9)
            r6.f19814b = r5
            r0.add(r6)
            goto La
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.view.TRingSleepDetailChartView.getData():java.util.List");
    }

    public final x6.a a(float f2) {
        for (x6.a aVar : this.f8632f) {
            if (aVar.e <= f2 && aVar.f19817f >= f2) {
                return aVar;
            }
        }
        return null;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Log.d("chart", "------ondraw");
        super.onDraw(canvas);
        canvas.save();
        canvas.clipRect(0.0f, 0.0f, this.f8628a, this.f8629b);
        List<x6.a> list = this.f8632f;
        if (list != null) {
            for (x6.a aVar : list) {
                int i3 = aVar.f19813a;
                if (i3 == 0) {
                    this.f8631d.setColor(getResources().getColor(R$color.ring_wake));
                } else if (i3 == 2) {
                    this.f8631d.setColor(getResources().getColor(R$color.ring_deep_sleep));
                } else if (i3 == 1) {
                    this.f8631d.setColor(getResources().getColor(R$color.ring_light_sleep));
                } else if (i3 == 3) {
                    this.f8631d.setColor(getResources().getColor(R$color.ring_rapid));
                } else {
                    this.f8631d.setColor(0);
                }
                canvas.drawPath(aVar.f19814b, this.f8631d);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        Log.d("chart", "------onMeasure");
        super.onMeasure(i3, i10);
        this.f8628a = View.MeasureSpec.getSize(i3);
        this.f8629b = View.MeasureSpec.getSize(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r0 != 3) goto L31;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            java.lang.String r1 = "qob"
            r2 = 1
            if (r0 == 0) goto L5a
            if (r0 == r2) goto L4b
            r3 = 2
            if (r0 == r3) goto L12
            r6 = 3
            if (r0 == r6) goto L4b
            goto L7e
        L12:
            float r0 = r6.getX()
            float r6 = r6.getY()
            float r1 = r5.f8634h
            float r1 = r0 - r1
            float r3 = r5.f8635i
            float r6 = r6 - r3
            float r1 = java.lang.Math.abs(r1)
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 <= 0) goto L49
            x6.a r6 = r5.a(r0)
            x6.a r0 = r5.f8633g
            if (r0 == 0) goto L7e
            long r0 = r0.f19816d
            long r3 = r6.f19816d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L7e
            r5.f8633g = r6
            com.example.test.ui.view.q r0 = r5.f8636j
            if (r0 == 0) goto L7e
            com.example.test.ui.testui.p0 r0 = (com.example.test.ui.testui.p0) r0
            r0.e(r6)
            return r2
        L49:
            r6 = 0
            return r6
        L4b:
            java.lang.String r6 = "MotionEvent.ACTION_UP"
            android.util.Log.e(r1, r6)
            com.example.test.ui.view.q r6 = r5.f8636j
            if (r6 == 0) goto L7e
            com.example.test.ui.testui.p0 r6 = (com.example.test.ui.testui.p0) r6
            r6.f()
            return r2
        L5a:
            java.lang.String r0 = "MotionEvent.ACTION_DOWN"
            android.util.Log.e(r1, r0)
            float r0 = r6.getX()
            r5.f8634h = r0
            float r6 = r6.getY()
            r5.f8635i = r6
            float r6 = r5.f8634h
            x6.a r6 = r5.a(r6)
            r5.f8633g = r6
            if (r6 == 0) goto L7e
            com.example.test.ui.view.q r0 = r5.f8636j
            if (r0 == 0) goto L7e
            com.example.test.ui.testui.p0 r0 = (com.example.test.ui.testui.p0) r0
            r0.e(r6)
        L7e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.view.TRingSleepDetailChartView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setData(List<x6.a> list) {
        Log.d("chart", "------setData");
        this.f8632f = list;
        invalidate();
    }

    public void setSleepChartChangeListener(q qVar) {
        this.f8636j = qVar;
    }

    public TRingSleepDetailChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TRingSleepDetailChartView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint(1);
        this.f8630c = paint;
        paint.setColor(-7829368);
        this.f8630c.setStrokeWidth(1.0f);
        this.f8631d = new Paint(1);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setColor(-1);
        this.e.setTextSize(30.0f);
    }
}
