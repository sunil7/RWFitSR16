package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TRingSleepChartView extends View {

    /* renamed from: a, reason: collision with root package name */
    public List f8622a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8623b;

    /* renamed from: c, reason: collision with root package name */
    public x6.a f8624c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8625d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f8626f;

    /* renamed from: g, reason: collision with root package name */
    public q f8627g;

    public TRingSleepChartView(Context context) {
        super(context);
        this.f8622a = new ArrayList();
        Paint paint = new Paint(1);
        this.f8623b = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    public final int a(int i3) {
        if (i3 == 0) {
            return getResources().getColor(R$color.ring_wake);
        }
        if (i3 == 1) {
            return getResources().getColor(R$color.ring_light_sleep);
        }
        if (i3 == 2) {
            return getResources().getColor(R$color.ring_deep_sleep);
        }
        if (i3 != 3) {
            return 0;
        }
        return getResources().getColor(R$color.ring_rapid);
    }

    public final x6.a b(float f2) {
        for (x6.a aVar : this.f8622a) {
            if (aVar.e <= f2 && aVar.f19817f >= f2) {
                return aVar;
            }
        }
        return null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Paint paint = this.f8623b;
        super.onDraw(canvas);
        float height = getHeight() / (this.f8625d ? 4.0f : 3.0f);
        float f2 = 0.6f * height;
        for (int i3 = 0; i3 < this.f8622a.size(); i3++) {
            x6.a aVar = (x6.a) this.f8622a.get(i3);
            float f10 = aVar.e;
            float f11 = aVar.f19817f;
            int i10 = aVar.f19813a;
            int i11 = i10 == 0 ? 2 : i10 == 2 ? 0 : i10;
            if (i3 > 0) {
                f10 -= 4.0f;
            }
            float f12 = ((height - f2) / 2.0f) + (i11 * height);
            RectF rectF = new RectF(f10, f12, f11, f12 + f2);
            Path path = new Path();
            path.addRoundRect(rectF, 10.0f, 10.0f, Path.Direction.CW);
            paint.setColor(a(i10));
            paint.setShader(null);
            canvas.drawPath(path, paint);
            if (i3 < this.f8622a.size() - 1) {
                x6.a aVar2 = (x6.a) this.f8622a.get(i3 + 1);
                float f13 = aVar.f19817f - 2.0f;
                int i12 = aVar.f19813a;
                int i13 = aVar2.f19813a;
                float f14 = height / 2.0f;
                float f15 = ((i12 == 0 ? 2 : i12 == 2 ? 0 : i12) * height) + f14;
                float f16 = ((i13 != 0 ? i13 == 2 ? 0 : i13 : 2) * height) + f14;
                Paint paint2 = new Paint(1);
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setStrokeWidth(4.0f);
                paint2.setStrokeCap(Paint.Cap.ROUND);
                paint2.setShader(new LinearGradient(f13, f15, f13, f16, new int[]{a(i12), a(i12), a(i13), a(i13)}, new float[]{0.0f, 0.3f, 0.7f, 1.0f}, Shader.TileMode.CLAMP));
                canvas.drawLine(f13, f15, f13, f16, paint2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r0 != 3) goto L30;
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
            if (r0 == 0) goto L6f
            if (r0 == r2) goto L58
            r3 = 2
            if (r0 == r3) goto L13
            r6 = 3
            if (r0 == r6) goto L58
            goto L9a
        L13:
            java.lang.String r0 = "MotionEvent.ACTION_MOVE"
            android.util.Log.e(r1, r0)
            float r0 = r6.getX()
            float r6 = r6.getY()
            float r1 = r5.e
            float r1 = r0 - r1
            float r3 = r5.f8626f
            float r6 = r6 - r3
            float r1 = java.lang.Math.abs(r1)
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 <= 0) goto L9a
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r2)
            x6.a r6 = r5.b(r0)
            x6.a r0 = r5.f8624c
            if (r0 == 0) goto L9a
            if (r6 == 0) goto L9a
            long r0 = r0.f19816d
            long r3 = r6.f19816d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L9a
            r5.f8624c = r6
            com.example.test.ui.view.q r0 = r5.f8627g
            if (r0 == 0) goto L9a
            com.example.test.ui.testui.p0 r0 = (com.example.test.ui.testui.p0) r0
            r0.e(r6)
            return r2
        L58:
            java.lang.String r6 = "MotionEvent.ACTION_UP"
            android.util.Log.e(r1, r6)
            android.view.ViewParent r6 = r5.getParent()
            r0 = 0
            r6.requestDisallowInterceptTouchEvent(r0)
            com.example.test.ui.view.q r6 = r5.f8627g
            if (r6 == 0) goto L9a
            com.example.test.ui.testui.p0 r6 = (com.example.test.ui.testui.p0) r6
            r6.f()
            return r2
        L6f:
            java.lang.String r0 = "MotionEvent.ACTION_DOWN"
            android.util.Log.e(r1, r0)
            float r0 = r6.getX()
            r5.e = r0
            float r6 = r6.getY()
            r5.f8626f = r6
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r2)
            float r6 = r5.e
            x6.a r6 = r5.b(r6)
            r5.f8624c = r6
            if (r6 == 0) goto L9a
            com.example.test.ui.view.q r0 = r5.f8627g
            if (r0 == 0) goto L9a
            com.example.test.ui.testui.p0 r0 = (com.example.test.ui.testui.p0) r0
            r0.e(r6)
        L9a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.view.TRingSleepChartView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setItems(List<x6.a> list) {
        this.f8622a = list;
        invalidate();
    }

    public void setSleepChartChangeListener(q qVar) {
        this.f8627g = qVar;
    }

    public TRingSleepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8622a = new ArrayList();
        Paint paint = new Paint(1);
        this.f8623b = paint;
        paint.setStyle(Paint.Style.FILL);
    }
}
