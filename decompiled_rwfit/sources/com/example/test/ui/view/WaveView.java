package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$mipmap;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WaveView extends View {

    /* renamed from: a, reason: collision with root package name */
    public float f8664a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f8665b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8666c;

    /* renamed from: d, reason: collision with root package name */
    public float f8667d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f8668f;

    /* renamed from: g, reason: collision with root package name */
    public float f8669g;

    /* renamed from: h, reason: collision with root package name */
    public float f8670h;

    public WaveView(Context context) {
        super(context);
        this.f8664a = 4.0f;
        this.f8666c = false;
        this.f8667d = 0.0f;
        this.e = 0.0f;
        new ArrayList();
        this.f8669g = 25.0f;
        this.f8670h = 20.0f;
        b();
    }

    public static float a(float f2, float f10) {
        float f11 = f10 / 2.0f;
        return (float) (f2 <= f11 ? Math.sqrt(Math.pow(f11, 2.0d) - Math.pow(f11 - f2, 2.0d)) : Math.sqrt(Math.pow(f11, 2.0d) - Math.pow(f2 - f11, 2.0d)));
    }

    public final void b() {
        Paint paint = new Paint();
        this.f8668f = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f8668f.setAntiAlias(true);
        this.f8668f.setTextAlign(Paint.Align.CENTER);
        setBackgroundColor(0);
        this.f8665b = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_activitypage_line);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f8666c) {
            this.f8668f.setColor(Color.parseColor("#828282"));
            this.f8668f.setStyle(Paint.Style.FILL);
            this.f8668f.setTextAlign(Paint.Align.LEFT);
            this.f8668f.setTextSize(this.f8664a);
            float textSize = (this.e - this.f8668f.getTextSize()) - (this.f8669g * 2.0f);
            float measureText = this.f8668f.measureText("00:00");
            float f2 = this.f8670h;
            if (f2 <= 0.0f || f2 >= measureText) {
                canvas.drawText("00:00", 0.0f, textSize + 20.0f, this.f8668f);
            } else {
                canvas.drawText("00:00", 0.0f, (textSize - a(f2 - 0.0f, measureText)) + 20.0f, this.f8668f);
            }
            this.f8668f.setTextAlign(Paint.Align.CENTER);
            float f10 = this.f8667d / 4.0f;
            float f11 = measureText / 2.0f;
            float f12 = f10 - f11;
            float f13 = this.f8670h;
            if (f13 <= f12 || f13 >= f12 + measureText) {
                canvas.drawText("06:00", f10, textSize + 20.0f, this.f8668f);
            } else {
                canvas.drawText("06:00", f10, (textSize - a(f13 - f12, measureText)) + 20.0f, this.f8668f);
            }
            float f14 = this.f8667d / 2.0f;
            float f15 = f14 - f11;
            float f16 = this.f8670h;
            if (f16 <= f15 || f16 >= f15 + measureText) {
                canvas.drawText("12:00", f14, textSize + 20.0f, this.f8668f);
            } else {
                canvas.drawText("12:00", f14, (textSize - a(f16 - f15, measureText)) + 20.0f, this.f8668f);
            }
            float f17 = (this.f8667d * 3.0f) / 4.0f;
            float f18 = f17 - f11;
            float f19 = this.f8670h;
            if (f19 <= f18 || f19 >= f18 + measureText) {
                canvas.drawText("18:00", f17, textSize + 20.0f, this.f8668f);
            } else {
                canvas.drawText("18:00", f17, (textSize - a(f19 - f18, measureText)) + 20.0f, this.f8668f);
            }
            this.f8668f.setTextAlign(Paint.Align.RIGHT);
            float f20 = this.f8667d;
            float f21 = f20 - measureText;
            float f22 = this.f8670h;
            if (f22 <= f21 || f22 >= f21 + measureText) {
                canvas.drawText("23:59", f20, textSize + 20.0f, this.f8668f);
            } else {
                canvas.drawText("23:59", f20, (textSize - a(f22 - f21, measureText)) + 20.0f, this.f8668f);
            }
        }
        float f23 = this.f8670h;
        if (f23 < 20.0f || f23 >= this.f8667d) {
            return;
        }
        float f24 = (((this.e / 4.0f) * 3.0f) / 5.0f) + 30.0f;
        float f25 = this.f8670h;
        canvas.drawBitmap(this.f8665b, (Rect) null, new RectF(f25 - 5.0f, f24, f25 + 2.0f, this.e - f24), (Paint) null);
        this.f8668f.setStyle(Paint.Style.FILL);
        this.f8668f.setColor(Color.parseColor("#61B7FF"));
        float f26 = this.f8670h;
        float f27 = this.e;
        float f28 = this.f8669g;
        canvas.drawCircle(f26, f27 - f28, f28, this.f8668f);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        this.f8667d = i3;
        float f2 = i10;
        this.e = f2;
        float f10 = f2 / 18.0f;
        this.f8664a = f10;
        this.f8669g = f10 * 0.8f;
        super.onSizeChanged(i3, i10, i11, i12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L4d
            if (r0 == r1) goto L44
            r2 = 2
            if (r0 == r2) goto L10
            r4 = 3
            if (r0 == r4) goto L44
            goto L5a
        L10:
            float r4 = r4.getX()
            r3.f8670h = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "selectedX = "
            r4.<init>(r0)
            float r0 = r3.f8670h
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "tong"
            android.util.Log.d(r0, r4)
            float r4 = r3.f8670h
            r0 = 1101004800(0x41a00000, float:20.0)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L35
            r3.f8670h = r0
        L35:
            float r4 = r3.f8670h
            r0 = 1141342208(0x44078000, float:542.0)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 <= 0) goto L40
            r3.f8670h = r0
        L40:
            r3.postInvalidate()
            goto L5a
        L44:
            android.view.ViewParent r4 = r3.getParent()
            r0 = 0
            r4.requestDisallowInterceptTouchEvent(r0)
            goto L5a
        L4d:
            r4.getX()
            java.lang.System.currentTimeMillis()
            android.view.ViewParent r4 = r3.getParent()
            r4.requestDisallowInterceptTouchEvent(r1)
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.view.WaveView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setHideText(boolean z5) {
        this.f8666c = z5;
    }

    public void setMaxProgress(int i3) {
    }

    public void setWVOnSeekBarChangeListener(s sVar) {
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8664a = 4.0f;
        this.f8666c = false;
        this.f8667d = 0.0f;
        this.e = 0.0f;
        new ArrayList();
        this.f8669g = 25.0f;
        this.f8670h = 20.0f;
        b();
    }

    public WaveView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8664a = 4.0f;
        this.f8666c = false;
        this.f8667d = 0.0f;
        this.e = 0.0f;
        new ArrayList();
        this.f8669g = 25.0f;
        this.f8670h = 20.0f;
        b();
    }
}
