package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public abstract class o1 extends p1 {

    /* renamed from: j, reason: collision with root package name */
    private final float f4728j;

    /* renamed from: k, reason: collision with root package name */
    private float f4729k;

    /* renamed from: l, reason: collision with root package name */
    private float f4730l;

    /* renamed from: m, reason: collision with root package name */
    private float f4731m;

    /* renamed from: n, reason: collision with root package name */
    private float f4732n;

    /* renamed from: o, reason: collision with root package name */
    private float f4733o;

    /* renamed from: p, reason: collision with root package name */
    private float f4734p;

    public o1(Context context) {
        super(context);
        this.f4731m = 0.0f;
        this.f4732n = 0.0f;
        this.f4733o = 0.0f;
        this.f4734p = 0.0f;
        this.f4728j = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    public PointF a(int i3) {
        return i3 == 0 ? new PointF(this.f4731m, this.f4732n) : new PointF(this.f4733o, this.f4734p);
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void b(MotionEvent motionEvent) {
        super.b(motionEvent);
        MotionEvent motionEvent2 = this.f4798c;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            float x10 = motionEvent2.getX(0);
            float y4 = motionEvent2.getY(0);
            float x11 = motionEvent2.getX(1);
            float y10 = motionEvent2.getY(1);
            float x12 = motionEvent.getX(0);
            float y11 = motionEvent.getY(0);
            float x13 = motionEvent.getX(1);
            float y12 = motionEvent.getY(1);
            this.f4731m = x12 - x10;
            this.f4732n = y11 - y4;
            this.f4733o = x13 - x11;
            this.f4734p = y12 - y10;
        }
    }

    public boolean b(MotionEvent motionEvent, int i3, int i10) {
        int i11;
        int i12 = this.f4802h;
        if (i12 != 0 && (i11 = this.f4803i) != 0) {
            float f2 = this.f4728j;
            this.f4729k = i12 - f2;
            this.f4730l = i11 - f2;
        } else {
            float f10 = this.f4796a.getResources().getDisplayMetrics().widthPixels;
            float f11 = this.f4728j;
            this.f4729k = f10 - f11;
            this.f4730l = r0.heightPixels - f11;
        }
        float f12 = this.f4728j;
        float f13 = this.f4729k;
        float f14 = this.f4730l;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float x10 = 1 < motionEvent.getPointerCount() ? motionEvent.getX(1) + ((motionEvent.getX() + i3) - motionEvent.getRawX()) : 0.0f;
        float y4 = 1 < motionEvent.getPointerCount() ? motionEvent.getY(1) + ((motionEvent.getY() + i10) - motionEvent.getRawY()) : 0.0f;
        boolean z5 = rawX < f12 || rawY < f12 || rawX > f13 || rawY > f14;
        boolean z6 = x10 < f12 || y4 < f12 || x10 > f13 || y4 > f14;
        return (z5 && z6) || z5 || z6;
    }
}
