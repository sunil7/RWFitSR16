package androidx.recyclerview.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class h0 extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2577a = true;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f2578b;

    public h0(j0 j0Var) {
        this.f2578b = j0Var;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        j0 j0Var;
        View m10;
        z1 K;
        if (this.f2577a && (m10 = (j0Var = this.f2578b).m(motionEvent)) != null && (K = j0Var.r.K(m10)) != null && j0Var.f2620m.hasDragFlag(j0Var.r, K)) {
            int pointerId = motionEvent.getPointerId(0);
            int i3 = j0Var.f2619l;
            if (pointerId == i3) {
                int findPointerIndex = motionEvent.findPointerIndex(i3);
                float x10 = motionEvent.getX(findPointerIndex);
                float y4 = motionEvent.getY(findPointerIndex);
                j0Var.f2612d = x10;
                j0Var.e = y4;
                j0Var.f2616i = 0.0f;
                j0Var.f2615h = 0.0f;
                if (j0Var.f2620m.isLongPressDragEnabled()) {
                    j0Var.r(K, 2);
                }
            }
        }
    }
}
