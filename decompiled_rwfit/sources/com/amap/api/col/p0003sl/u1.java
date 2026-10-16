package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class u1 extends o1 {

    /* renamed from: w, reason: collision with root package name */
    private static final PointF f5118w = new PointF();

    /* renamed from: q, reason: collision with root package name */
    private final a f5119q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private PointF f5120s;

    /* renamed from: t, reason: collision with root package name */
    private PointF f5121t;

    /* renamed from: u, reason: collision with root package name */
    private PointF f5122u;

    /* renamed from: v, reason: collision with root package name */
    private PointF f5123v;

    public interface a {
        void a(u1 u1Var);
    }

    public static class b implements a {
    }

    public u1(Context context, a aVar) {
        super(context);
        this.f5122u = new PointF();
        this.f5123v = new PointF();
        this.f5119q = aVar;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void a(int i3, MotionEvent motionEvent, int i10, int i11) {
        if (i3 != 5) {
            return;
        }
        c();
        this.f4798c = MotionEvent.obtain(motionEvent);
        this.f4801g = 0L;
        b(motionEvent);
        boolean b3 = b(motionEvent, i10, i11);
        this.r = b3;
        if (b3) {
            return;
        }
        this.f5119q.getClass();
        this.f4797b = true;
    }

    @Override // com.amap.api.col.p0003sl.o1, com.amap.api.col.p0003sl.p1
    public void b(MotionEvent motionEvent) {
        PointF pointF;
        super.b(motionEvent);
        MotionEvent motionEvent2 = this.f4798c;
        this.f5120s = p1.a(motionEvent);
        this.f5121t = p1.a(motionEvent2);
        if (this.f4798c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = f5118w;
        } else {
            PointF pointF2 = this.f5120s;
            float f2 = pointF2.x;
            PointF pointF3 = this.f5121t;
            pointF = new PointF(f2 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f5123v = pointF;
        PointF pointF4 = this.f5122u;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void c() {
        super.c();
        this.r = false;
        PointF pointF = this.f5122u;
        pointF.x = 0.0f;
        PointF pointF2 = this.f5123v;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    public float d() {
        return this.f5122u.x;
    }

    public float e() {
        return this.f5122u.y;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void a(int i3, MotionEvent motionEvent) {
        if (i3 == 3) {
            c();
        } else {
            if (i3 != 6) {
                return;
            }
            b(motionEvent);
            if (!this.r) {
                this.f5119q.a(this);
            }
            c();
        }
    }
}
