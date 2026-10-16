package com.example.test.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import com.example.test.R$color;
import com.example.test.R$mipmap;

/* loaded from: classes.dex */
public class PowerView extends View {

    /* renamed from: a, reason: collision with root package name */
    public RectF f8504a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8505b;

    /* renamed from: c, reason: collision with root package name */
    public final Bitmap f8506c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f8507d;
    public final Path e;

    /* renamed from: f, reason: collision with root package name */
    public int f8508f;

    /* renamed from: g, reason: collision with root package name */
    public int f8509g;

    /* renamed from: h, reason: collision with root package name */
    public int f8510h;

    /* renamed from: i, reason: collision with root package name */
    public final Bitmap f8511i;

    /* renamed from: j, reason: collision with root package name */
    public Path f8512j;

    /* renamed from: k, reason: collision with root package name */
    public double f8513k;

    /* renamed from: l, reason: collision with root package name */
    public final Bitmap f8514l;

    /* renamed from: m, reason: collision with root package name */
    public final Bitmap f8515m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f8516n;

    /* renamed from: o, reason: collision with root package name */
    public RectF f8517o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8518p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8519q;

    public PowerView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8519q) {
            this.f8505b.setColor(-65536);
        } else {
            this.f8505b.setColor(getResources().getColor(R$color.colorAccent));
        }
        if (this.f8510h == 100) {
            canvas.drawBitmap(this.f8511i, this.f8507d, this.f8504a, this.f8505b);
        } else if (this.f8519q) {
            canvas.drawBitmap(this.f8514l, this.f8507d, this.f8504a, this.f8505b);
        } else {
            canvas.drawBitmap(this.f8506c, this.f8507d, this.f8504a, this.f8505b);
        }
        if (this.f8510h < 100) {
            canvas.save();
            Paint paint = new Paint(1);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            paint.setColor(-16711936);
            float f2 = (float) ((this.f8509g - this.f8513k) * (this.f8510h / 100.0f));
            this.e.reset();
            double d5 = f2;
            this.e.moveTo((float) ((this.f8513k / 2.0d) + d5), this.f8508f);
            this.e.lineTo((float) (d5 - (this.f8513k / 2.0d)), 0.0f);
            this.e.lineTo(0.0f, 0.0f);
            this.e.lineTo(0.0f, this.f8508f);
            canvas.clipPath(this.f8512j, Region.Op.INTERSECT);
            canvas.drawPath(this.e, this.f8505b);
            canvas.restore();
        }
        if (this.f8518p) {
            canvas.drawBitmap(this.f8515m, this.f8516n, this.f8517o, this.f8505b);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        Bitmap bitmap = this.f8515m;
        super.onMeasure(i3, i10);
        this.f8509g = View.MeasureSpec.getSize(i3);
        this.f8508f = View.MeasureSpec.getSize(i10);
        if (this.f8509g <= 0 || this.f8504a != null) {
            return;
        }
        RectF rectF = new RectF();
        this.f8504a = rectF;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = this.f8509g;
        int i11 = this.f8508f;
        rectF.bottom = i11;
        this.f8513k = Math.tan(Math.toRadians(15.0d)) * i11;
        this.f8512j = new Path();
        RectF rectF2 = new RectF();
        rectF2.left = 2.0f;
        rectF2.top = 2.0f;
        rectF2.right = (float) ((this.f8509g - this.f8513k) + 1.0d);
        rectF2.bottom = this.f8508f - 1;
        this.f8512j.addRoundRect(rectF2, new float[]{3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f}, Path.Direction.CW);
        this.e.moveTo(0.0f, this.f8508f);
        RectF rectF3 = new RectF();
        this.f8517o = rectF3;
        rectF3.left = (this.f8509g - bitmap.getWidth()) / 2.0f;
        this.f8517o.top = ((this.f8508f - bitmap.getHeight()) / 2.0f) + 2.0f;
        RectF rectF4 = this.f8517o;
        rectF4.right = rectF4.left + bitmap.getWidth();
        RectF rectF5 = this.f8517o;
        rectF5.bottom = rectF5.top + bitmap.getHeight();
    }

    public void setCurrentPower(int i3) {
        this.f8510h = i3;
        invalidate();
    }

    public PowerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PowerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8510h = 78;
        this.f8518p = true;
        Paint paint = new Paint(1);
        this.f8505b = paint;
        paint.setColor(getResources().getColor(R$color.colorAccent));
        this.f8506c = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_power_bg);
        this.f8511i = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_full_power);
        this.f8514l = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_low_power);
        this.f8507d = new Rect(0, 0, this.f8506c.getWidth(), this.f8506c.getHeight());
        Path path = new Path();
        this.e = path;
        path.moveTo(0.0f, 0.0f);
        this.f8515m = BitmapFactory.decodeResource(getResources(), R$mipmap.ic_powering);
        this.f8516n = new Rect(0, 0, this.f8515m.getWidth(), this.f8515m.getHeight());
    }
}
