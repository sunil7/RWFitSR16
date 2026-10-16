package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.example.test.R$styleable;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class LongClickView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8470a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8471b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8472c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f8473d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public Timer f8474f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicInteger f8475g;

    /* renamed from: h, reason: collision with root package name */
    public l f8476h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8477i;

    /* renamed from: j, reason: collision with root package name */
    public long f8478j;

    /* renamed from: k, reason: collision with root package name */
    public long f8479k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8480l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8481m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8482n;

    /* renamed from: o, reason: collision with root package name */
    public final float f8483o;

    public LongClickView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        float f2 = this.f8483o;
        int i3 = this.e;
        RectF rectF = new RectF(f2 / 2.0f, f2 / 2.0f, i3 - (f2 / 2.0f), i3 - (f2 / 2.0f));
        if (this.f8475g.get() > 0) {
            this.f8473d.setStrokeWidth(this.f8483o);
            canvas2 = canvas;
            canvas2.drawArc(rectF, 90.0f, ((360.0f / this.f8480l) / (1000.0f / this.f8481m)) * r0.get(), false, this.f8473d);
        } else {
            canvas2 = canvas;
        }
        super.onDraw(canvas2);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        int size = View.MeasureSpec.getSize(i3);
        this.e = size;
        setMeasuredDimension(size, size);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f8479k = System.currentTimeMillis();
            new k(this, 0).execute(new Void[0]);
        } else if (motionEvent.getAction() == 0) {
            this.f8478j = System.currentTimeMillis();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMyClickListener(l lVar) {
        this.f8476h = lVar;
    }

    public LongClickView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LongClickView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8475g = new AtomicInteger(0);
        this.f8477i = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LongClickView);
        this.f8480l = obtainStyledAttributes.getInt(R$styleable.LongClickView_maxSeconds, 15);
        this.f8483o = obtainStyledAttributes.getInt(R$styleable.LongClickView_annulusWidth, 5);
        this.f8482n = obtainStyledAttributes.getColor(R$styleable.LongClickView_annulusColor, -1);
        this.f8481m = obtainStyledAttributes.getInt(R$styleable.LongClickView_delayMilliseconds, 50);
        this.f8472c = new Paint();
        this.f8470a = new Paint();
        this.f8471b = new Paint();
        this.f8473d = new Paint();
        Paint paint = this.f8472c;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f8472c.setColor(-3355444);
        this.f8472c.setAntiAlias(true);
        this.f8472c.setStrokeWidth(5.0f);
        this.f8470a.setStrokeWidth(5.0f);
        this.f8470a.setAntiAlias(true);
        this.f8470a.setColor(-1);
        this.f8470a.setStyle(style);
        this.f8471b.setStrokeWidth(5.0f);
        this.f8471b.setAntiAlias(true);
        this.f8471b.setColor(-3355444);
        this.f8471b.setStyle(style);
        this.f8473d.setStrokeWidth(5.0f);
        this.f8473d.setAntiAlias(true);
        this.f8473d.setStyle(Paint.Style.STROKE);
        this.f8473d.setStrokeCap(Paint.Cap.ROUND);
        this.f8473d.setColor(this.f8482n);
        setOnLongClickListener(new j(this));
    }
}
