package com.example.test.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import java.util.List;

/* loaded from: classes.dex */
public class SleepDetailChartView extends View {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f8573l = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f8574a;

    /* renamed from: b, reason: collision with root package name */
    public int f8575b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8576c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8577d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public float f8578f;

    /* renamed from: g, reason: collision with root package name */
    public ValueAnimator f8579g;

    /* renamed from: h, reason: collision with root package name */
    public List f8580h;

    /* renamed from: i, reason: collision with root package name */
    public final float f8581i;

    /* renamed from: j, reason: collision with root package name */
    public String f8582j;

    /* renamed from: k, reason: collision with root package name */
    public String f8583k;

    public SleepDetailChartView(Context context) {
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
            int r5 = r11.f8574a
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
            int r7 = r11.f8575b
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
            int r7 = r11.f8575b
        L44:
            float r7 = (float) r7
            float r7 = r7 / r8
            goto L53
        L47:
            r10 = 2
            if (r7 != r10) goto L50
            int r7 = r11.f8575b
            float r9 = (float) r7
            float r9 = r9 / r8
            int r7 = r7 * r10
            goto L44
        L50:
            int r7 = r11.f8575b
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
            int r4 = r11.f8574a
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
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.view.SleepDetailChartView.getData():java.util.List");
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.f8574a;
        Paint paint = this.f8576c;
        float f10 = this.f8581i;
        canvas.drawLine(0.0f, f10, f2, f10, paint);
        int i3 = this.f8575b;
        canvas.drawLine(0.0f, i3 / 3.0f, this.f8574a, i3 / 3.0f, this.f8576c);
        int i10 = this.f8575b;
        canvas.drawLine(0.0f, (i10 * 2) / 3.0f, this.f8574a, (i10 * 2) / 3.0f, this.f8576c);
        int i11 = this.f8575b;
        float f11 = this.f8581i;
        canvas.drawLine(0.0f, i11 - f11, this.f8574a, i11 - f11, this.f8576c);
        String str = this.f8582j;
        if ((str == null || str.length() == 0 || "null".equalsIgnoreCase(str)) ? false : true) {
            canvas.drawText(this.f8582j, 0.0f, this.f8575b, this.e);
        }
        String str2 = this.f8583k;
        if ((str2 == null || str2.length() == 0 || "null".equalsIgnoreCase(str2)) ? false : true) {
            canvas.drawText(this.f8583k, this.f8574a - 70, this.f8575b, this.e);
        }
        canvas.save();
        canvas.clipRect(0.0f, this.f8578f, this.f8574a, this.f8575b);
        List<x6.a> list = this.f8580h;
        if (list != null) {
            for (x6.a aVar : list) {
                int i12 = aVar.f19813a;
                if (i12 == 0) {
                    this.f8577d.setColor(getResources().getColor(R$color.color_fbb612));
                } else if (i12 == 2) {
                    this.f8577d.setColor(getResources().getColor(R$color.color_925ed2));
                } else if (i12 == 1) {
                    this.f8577d.setColor(getResources().getColor(R$color.color_3d56bf));
                } else if (i12 == 3) {
                    this.f8577d.setColor(getResources().getColor(R$color.ring_rapid));
                } else {
                    this.f8577d.setColor(0);
                }
                canvas.drawPath(aVar.f19814b, this.f8577d);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        this.f8574a = View.MeasureSpec.getSize(i3);
        int size = View.MeasureSpec.getSize(i10);
        this.f8575b = size;
        if (this.f8578f == 0.0f) {
            float f2 = size;
            this.f8578f = f2;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 0.0f);
            this.f8579g = ofFloat;
            ofFloat.setDuration(1000L);
            this.f8579g.addUpdateListener(new p(0, this));
        }
        this.f8579g.start();
    }

    public void setData(List<x6.a> list) {
        this.f8580h = list;
        invalidate();
    }

    public SleepDetailChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SleepDetailChartView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8581i = 20.0f;
        Paint paint = new Paint(1);
        this.f8576c = paint;
        paint.setColor(-7829368);
        this.f8576c.setStrokeWidth(1.0f);
        this.f8577d = new Paint(1);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setColor(-1);
        this.e.setTextSize(20.0f);
    }
}
