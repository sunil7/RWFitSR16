package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class q1 extends o1 {

    /* renamed from: w, reason: collision with root package name */
    private static final PointF f4883w = new PointF();

    /* renamed from: q, reason: collision with root package name */
    private final a f4884q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private PointF f4885s;

    /* renamed from: t, reason: collision with root package name */
    private PointF f4886t;

    /* renamed from: u, reason: collision with root package name */
    private PointF f4887u;

    /* renamed from: v, reason: collision with root package name */
    private PointF f4888v;

    public interface a {
        boolean a(q1 q1Var);

        void b(q1 q1Var);

        boolean c(q1 q1Var);
    }

    public q1(Context context, a aVar) {
        super(context);
        this.f4887u = new PointF();
        this.f4888v = new PointF();
        this.f4884q = aVar;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void a(int i3, MotionEvent motionEvent, int i10, int i11) {
        if (i3 == 2) {
            if (this.r) {
                boolean b3 = b(motionEvent, i10, i11);
                this.r = b3;
                if (b3) {
                    return;
                }
                this.f4797b = this.f4884q.c(this);
                return;
            }
            return;
        }
        if (i3 != 5) {
            return;
        }
        c();
        this.f4798c = MotionEvent.obtain(motionEvent);
        this.f4801g = 0L;
        b(motionEvent);
        boolean b10 = b(motionEvent, i10, i11);
        this.r = b10;
        if (b10) {
            return;
        }
        this.f4797b = this.f4884q.c(this);
    }

    @Override // com.amap.api.col.p0003sl.o1, com.amap.api.col.p0003sl.p1
    public void b(MotionEvent motionEvent) {
        PointF pointF;
        super.b(motionEvent);
        MotionEvent motionEvent2 = this.f4798c;
        this.f4885s = p1.a(motionEvent);
        this.f4886t = p1.a(motionEvent2);
        if (this.f4798c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = f4883w;
        } else {
            PointF pointF2 = this.f4885s;
            float f2 = pointF2.x;
            PointF pointF3 = this.f4886t;
            pointF = new PointF(f2 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f4888v = pointF;
        PointF pointF4 = this.f4887u;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void c() {
        super.c();
        this.r = false;
    }

    public PointF d() {
        return this.f4888v;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void a(int i3, MotionEvent motionEvent) {
        if (i3 == 2) {
            b(motionEvent);
            if (this.e / this.f4800f <= 0.67f || !this.f4884q.a(this)) {
                return;
            }
            this.f4798c.recycle();
            this.f4798c = MotionEvent.obtain(motionEvent);
            return;
        }
        if (i3 == 3) {
            if (!this.r) {
                this.f4884q.b(this);
            }
            c();
        } else {
            if (i3 != 6) {
                return;
            }
            b(motionEvent);
            if (!this.r) {
                this.f4884q.b(this);
            }
            c();
        }
    }
}
