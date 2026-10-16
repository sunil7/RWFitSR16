package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import com.example.test.R$mipmap;

/* loaded from: classes.dex */
public class TRingPowerView extends View {

    /* renamed from: a, reason: collision with root package name */
    public RectF f8614a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap f8615b;

    /* renamed from: c, reason: collision with root package name */
    public final Path f8616c;

    /* renamed from: d, reason: collision with root package name */
    public int f8617d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public Path f8618f;

    /* renamed from: g, reason: collision with root package name */
    public double f8619g;

    /* renamed from: h, reason: collision with root package name */
    public final Bitmap f8620h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f8621i;

    public TRingPowerView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        Bitmap bitmap = this.f8620h;
        super.onMeasure(i3, i10);
        this.e = View.MeasureSpec.getSize(i3);
        this.f8617d = View.MeasureSpec.getSize(i10);
        if (this.e <= 0 || this.f8614a != null) {
            return;
        }
        RectF rectF = new RectF();
        this.f8614a = rectF;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = this.e;
        int i11 = this.f8617d;
        rectF.bottom = i11;
        this.f8619g = Math.tan(Math.toRadians(15.0d)) * i11;
        this.f8618f = new Path();
        RectF rectF2 = new RectF();
        rectF2.left = 2.0f;
        rectF2.top = 2.0f;
        rectF2.right = (float) ((this.e - this.f8619g) + 1.0d);
        rectF2.bottom = this.f8617d - 1;
        this.f8618f.addRoundRect(rectF2, new float[]{3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f}, Path.Direction.CW);
        this.f8616c.moveTo(0.0f, this.f8617d);
        RectF rectF3 = new RectF();
        this.f8621i = rectF3;
        rectF3.left = (this.e - bitmap.getWidth()) / 2.0f;
        this.f8621i.top = ((this.f8617d - bitmap.getHeight()) / 2.0f) + 2.0f;
        RectF rectF4 = this.f8621i;
        rectF4.right = rectF4.left + bitmap.getWidth();
        RectF rectF5 = this.f8621i;
        rectF5.bottom = rectF5.top + bitmap.getHeight();
    }

    public void setCurrentPower(int i3) {
        invalidate();
    }

    public TRingPowerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TRingPowerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        new Paint(1).setColor(getResources().getColor(R$color.colorAccent));
        this.f8615b = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_power_bg);
        BitmapFactory.decodeResource(getResources(), R$mipmap.ic_full_power);
        BitmapFactory.decodeResource(getResources(), R$mipmap.ic_low_power);
        new Rect(0, 0, this.f8615b.getWidth(), this.f8615b.getHeight());
        Path path = new Path();
        this.f8616c = path;
        path.moveTo(0.0f, 0.0f);
        this.f8620h = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_powering);
        new Rect(0, 0, this.f8620h.getWidth(), this.f8620h.getHeight());
    }
}
