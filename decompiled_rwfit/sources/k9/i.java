package k9;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class i extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, b {

    /* renamed from: c, reason: collision with root package name */
    public final h f15569c;
    public final GestureDetector e;

    /* renamed from: a, reason: collision with root package name */
    public final PointF f15567a = new PointF();

    /* renamed from: b, reason: collision with root package name */
    public final PointF f15568b = new PointF();

    /* renamed from: d, reason: collision with root package name */
    public final float f15570d = 25.0f;

    /* renamed from: f, reason: collision with root package name */
    public volatile float f15571f = 3.1415927f;

    public i(Context context, h hVar) {
        this.f15569c = hVar;
        this.e = new GestureDetector(context, this);
    }

    @Override // k9.b
    public final void a(float f2, float[] fArr) {
        this.f15571f = -f2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f15567a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f10) {
        float x10 = (motionEvent2.getX() - this.f15567a.x) / this.f15570d;
        float y4 = motionEvent2.getY();
        PointF pointF = this.f15567a;
        float f11 = (y4 - pointF.y) / this.f15570d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d5 = this.f15571f;
        float cos = (float) Math.cos(d5);
        float sin = (float) Math.sin(d5);
        PointF pointF2 = this.f15568b;
        pointF2.x -= (cos * x10) - (sin * f11);
        float f12 = (cos * f11) + (sin * x10) + pointF2.y;
        pointF2.y = f12;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f12));
        h hVar = this.f15569c;
        PointF pointF3 = this.f15568b;
        synchronized (hVar) {
            float f13 = pointF3.y;
            hVar.f15562g = f13;
            Matrix.setRotateM(hVar.e, 0, -f13, (float) Math.cos(hVar.f15563h), (float) Math.sin(hVar.f15563h), 0.0f);
            Matrix.setRotateM(hVar.f15561f, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f15569c.f15566k.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.e.onTouchEvent(motionEvent);
    }
}
