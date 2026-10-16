package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class p1 {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f4796a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f4797b;

    /* renamed from: c, reason: collision with root package name */
    protected MotionEvent f4798c;

    /* renamed from: d, reason: collision with root package name */
    protected MotionEvent f4799d;
    protected float e;

    /* renamed from: f, reason: collision with root package name */
    protected float f4800f;

    /* renamed from: g, reason: collision with root package name */
    protected long f4801g;

    /* renamed from: h, reason: collision with root package name */
    protected int f4802h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected int f4803i = 0;

    public p1(Context context) {
        this.f4796a = context;
    }

    public void a(int i3, int i10) {
        this.f4802h = i3;
        this.f4803i = i10;
    }

    public abstract void a(int i3, MotionEvent motionEvent);

    public abstract void a(int i3, MotionEvent motionEvent, int i10, int i11);

    public void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f4798c;
        MotionEvent motionEvent3 = this.f4799d;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f4799d = null;
        }
        this.f4799d = MotionEvent.obtain(motionEvent);
        this.f4801g = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.e = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f4800f = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }

    public void c() {
        MotionEvent motionEvent = this.f4798c;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f4798c = null;
        }
        MotionEvent motionEvent2 = this.f4799d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f4799d = null;
        }
        this.f4797b = false;
    }

    public boolean a(MotionEvent motionEvent, int i3, int i10) {
        int action = motionEvent.getAction() & 255;
        if (!this.f4797b) {
            a(action, motionEvent, i3, i10);
            return true;
        }
        a(action, motionEvent);
        return true;
    }

    public static PointF a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f10 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            f10 += motionEvent.getX(i3);
            f2 += motionEvent.getY(i3);
        }
        float f11 = pointerCount;
        return new PointF(f10 / f11, f2 / f11);
    }

    public long b() {
        return this.f4801g;
    }

    public MotionEvent a() {
        return this.f4799d;
    }
}
