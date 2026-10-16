package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class r1 extends p1 {

    /* renamed from: o, reason: collision with root package name */
    private static final PointF f4934o = new PointF();

    /* renamed from: j, reason: collision with root package name */
    private final a f4935j;

    /* renamed from: k, reason: collision with root package name */
    private PointF f4936k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f4937l;

    /* renamed from: m, reason: collision with root package name */
    private PointF f4938m;

    /* renamed from: n, reason: collision with root package name */
    private PointF f4939n;

    public interface a {
        boolean a(r1 r1Var);

        boolean b(r1 r1Var);

        void c(r1 r1Var);
    }

    public r1(Context context, a aVar) {
        super(context);
        this.f4938m = new PointF();
        this.f4939n = new PointF();
        this.f4935j = aVar;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void a(int i3, MotionEvent motionEvent, int i10, int i11) {
        if (i3 == 0) {
            c();
            this.f4798c = MotionEvent.obtain(motionEvent);
            this.f4801g = 0L;
            b(motionEvent);
            return;
        }
        if (i3 == 2) {
            this.f4797b = this.f4935j.a(this);
            return;
        }
        if (i3 != 5) {
            return;
        }
        MotionEvent motionEvent2 = this.f4798c;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f4798c = MotionEvent.obtain(motionEvent);
        b(motionEvent);
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void b(MotionEvent motionEvent) {
        PointF pointF;
        super.b(motionEvent);
        MotionEvent motionEvent2 = this.f4798c;
        this.f4936k = p1.a(motionEvent);
        this.f4937l = p1.a(motionEvent2);
        boolean z5 = this.f4798c.getPointerCount() != motionEvent.getPointerCount();
        if (z5) {
            pointF = f4934o;
        } else {
            PointF pointF2 = this.f4936k;
            float f2 = pointF2.x;
            PointF pointF3 = this.f4937l;
            pointF = new PointF(f2 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f4939n = pointF;
        if (z5) {
            this.f4798c.recycle();
            this.f4798c = MotionEvent.obtain(motionEvent);
        }
        PointF pointF4 = this.f4938m;
        float f10 = pointF4.x;
        PointF pointF5 = this.f4939n;
        pointF4.x = f10 + pointF5.x;
        pointF4.y += pointF5.y;
    }

    public PointF d() {
        return this.f4939n;
    }

    @Override // com.amap.api.col.p0003sl.p1
    public void a(int i3, MotionEvent motionEvent) {
        if (i3 != 1) {
            if (i3 == 2) {
                b(motionEvent);
                if (this.e / this.f4800f <= 0.67f || motionEvent.getPointerCount() > 1 || !this.f4935j.b(this)) {
                    return;
                }
                this.f4798c.recycle();
                this.f4798c = MotionEvent.obtain(motionEvent);
                return;
            }
            if (i3 != 3) {
                return;
            }
        }
        this.f4935j.c(this);
        c();
    }
}
