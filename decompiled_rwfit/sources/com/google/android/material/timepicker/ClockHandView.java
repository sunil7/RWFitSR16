package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10959a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10960b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10961c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f10962d;
    public final RectF e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10963f;

    /* renamed from: g, reason: collision with root package name */
    public float f10964g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10965h;

    /* renamed from: i, reason: collision with root package name */
    public double f10966i;

    /* renamed from: j, reason: collision with root package name */
    public int f10967j;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public final void a(float f2) {
        float f10 = f2 % 360.0f;
        this.f10964g = f10;
        this.f10966i = Math.toRadians(f10 - 90.0f);
        int height = getHeight() / 2;
        float cos = (this.f10967j * ((float) Math.cos(this.f10966i))) + (getWidth() / 2);
        float sin = (this.f10967j * ((float) Math.sin(this.f10966i))) + height;
        float f11 = this.f10960b;
        this.e.set(cos - f11, sin - f11, cos + f11, sin + f11);
        ArrayList arrayList = this.f10959a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ClockFaceView clockFaceView = (ClockFaceView) ((e) obj);
            if (Math.abs(clockFaceView.H - f10) > 0.001f) {
                clockFaceView.H = f10;
                clockFaceView.q();
            }
        }
        invalidate();
    }

    public void addOnRotateListener(e eVar) {
        this.f10959a.add(eVar);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float cos = (this.f10967j * ((float) Math.cos(this.f10966i))) + width;
        float f2 = height;
        float sin = (this.f10967j * ((float) Math.sin(this.f10966i))) + f2;
        Paint paint = this.f10962d;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.f10960b, paint);
        double sin2 = Math.sin(this.f10966i);
        double cos2 = Math.cos(this.f10966i);
        paint.setStrokeWidth(this.f10963f);
        canvas.drawLine(width, f2, r1 + ((int) (cos2 * r5)), height + ((int) (r5 * sin2)), paint);
        canvas.drawCircle(width, f2, this.f10961c, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        a(this.f10964g);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean z6;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y4 = motionEvent.getY();
        boolean z8 = false;
        if (actionMasked == 0) {
            this.f10965h = false;
            z5 = true;
            z6 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z6 = this.f10965h;
            z5 = false;
        } else {
            z6 = false;
            z5 = false;
        }
        boolean z10 = this.f10965h;
        int degrees = (int) Math.toDegrees(Math.atan2(y4 - (getHeight() / 2), x10 - (getWidth() / 2)));
        int i3 = degrees + 90;
        if (i3 < 0) {
            i3 = degrees + 450;
        }
        float f2 = i3;
        boolean z11 = this.f10964g != f2;
        if (!z5 || !z11) {
            if (z11 || z6) {
                a(f2);
            }
            this.f10965h = z10 | z8;
            return true;
        }
        z8 = true;
        this.f10965h = z10 | z8;
        return true;
    }

    public void setOnActionUpListener(d dVar) {
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10959a = new ArrayList();
        Paint paint = new Paint();
        this.f10962d = paint;
        this.e = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i3, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.f10967j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f10960b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        this.f10963f = getResources().getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f10961c = r6.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        a(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = z0.f15748a;
        h0.s(this, 2);
        obtainStyledAttributes.recycle();
    }
}
