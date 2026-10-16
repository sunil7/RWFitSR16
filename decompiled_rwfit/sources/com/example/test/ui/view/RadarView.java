package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public class RadarView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f8530a;

    /* renamed from: b, reason: collision with root package name */
    public int f8531b;

    /* renamed from: c, reason: collision with root package name */
    public int f8532c;

    /* renamed from: d, reason: collision with root package name */
    public int f8533d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f8534f;

    /* renamed from: g, reason: collision with root package name */
    public int f8535g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f8536h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8537i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8538j;

    /* renamed from: k, reason: collision with root package name */
    public Paint f8539k;

    /* renamed from: l, reason: collision with root package name */
    public int f8540l;

    /* renamed from: m, reason: collision with root package name */
    public int f8541m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8542n;

    /* renamed from: o, reason: collision with root package name */
    public final int f8543o;

    /* renamed from: p, reason: collision with root package name */
    public final Bitmap f8544p;

    /* renamed from: q, reason: collision with root package name */
    public final androidx.activity.e f8545q;

    public RadarView(Context context) {
        super(context);
        this.f8540l = 1;
        this.f8543o = 60;
        this.f8545q = new androidx.activity.e(this, 13);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f8539k = paint;
        paint.setColor(this.f8534f);
        this.f8539k.setStyle(Paint.Style.FILL);
        this.f8539k.setAntiAlias(true);
        this.f8535g = (this.f8534f >> 24) & 255;
    }

    public final void b() {
        Log.i("RadarView", "start radar");
        androidx.activity.e eVar = this.f8545q;
        removeCallbacks(eVar);
        this.f8542n = true;
        postDelayed(eVar, this.f8543o);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i3 = this.f8541m;
        int i10 = this.f8532c;
        int i11 = this.f8537i;
        if (i3 > i10) {
            this.f8541m = i3 - i11;
        }
        this.f8541m += this.f8538j;
        Bitmap bitmap = this.f8544p;
        int i12 = 0;
        int width = bitmap != null ? bitmap.getWidth() / 2 : 0;
        if (this.f8536h) {
            while (i12 < this.f8540l) {
                int i13 = this.f8541m - (i12 * i11);
                if (i13 > 133) {
                    int i14 = this.f8535g;
                    int i15 = this.f8532c;
                    if (i13 < i15) {
                        i14 = (i14 * i13) / i15;
                    }
                    this.f8539k.setColor(this.f8534f - (i14 << 24));
                    canvas.drawCircle(this.f8533d, this.e, i13, this.f8539k);
                }
                i12++;
            }
            width = 133;
        } else {
            while (i12 < this.f8540l) {
                int i16 = this.f8541m - (i12 * i11);
                if (i16 > width) {
                    canvas.drawCircle(this.f8533d, this.e, i16, this.f8539k);
                }
                i12++;
            }
        }
        if (width > 0) {
            canvas.drawBitmap(bitmap, this.f8533d - (bitmap.getWidth() / 2), this.e - (bitmap.getHeight() / 2), this.f8539k);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int i11 = 200;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                size = 200;
            } else if (mode != 1073741824) {
                size = 0;
            }
        }
        this.f8530a = size;
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 0) {
                if (mode2 != 1073741824) {
                    i11 = 0;
                }
            }
            this.f8531b = i11;
            this.f8532c = Math.max(this.f8530a, i11) / 2;
            setMeasuredDimension(this.f8530a, this.f8531b);
            int i12 = this.f8532c;
            int i13 = this.f8537i;
            int i14 = i12 / i13;
            this.f8540l = i14;
            this.f8532c = i14 * i13;
            this.f8533d = this.f8530a / 2;
            this.e = this.f8531b / 2;
        }
        i11 = size2;
        this.f8531b = i11;
        this.f8532c = Math.max(this.f8530a, i11) / 2;
        setMeasuredDimension(this.f8530a, this.f8531b);
        int i122 = this.f8532c;
        int i132 = this.f8537i;
        int i142 = i122 / i132;
        this.f8540l = i142;
        this.f8532c = i142 * i132;
        this.f8533d = this.f8530a / 2;
        this.e = this.f8531b / 2;
    }

    public void setColor(int i3) {
        this.f8534f = i3;
        this.f8539k.setColor(i3);
        this.f8535g = (this.f8534f >> 24) & 255;
    }

    public RadarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8540l = 1;
        this.f8543o = 60;
        this.f8545q = new androidx.activity.e(this, 13);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.radar_view, i3, 0);
        this.f8537i = obtainStyledAttributes.getInteger(R$styleable.radar_view_radar_view_space, 150);
        this.f8534f = obtainStyledAttributes.getColor(R$styleable.radar_view_radar_view_color, -2130771713);
        this.f8538j = obtainStyledAttributes.getInteger(R$styleable.radar_view_radar_view_speed, 10);
        this.f8536h = obtainStyledAttributes.getBoolean(R$styleable.radar_view_radar_view_is_alpha, true);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.radar_view_radar_view_center_image, 0);
        if (resourceId > 0) {
            this.f8544p = BitmapFactory.decodeResource(getResources(), resourceId);
        }
        obtainStyledAttributes.recycle();
        a();
    }
}
