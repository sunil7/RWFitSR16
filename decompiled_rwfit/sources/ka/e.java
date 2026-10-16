package ka;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class e extends g {

    /* renamed from: c, reason: collision with root package name */
    public e8.a f15576c;

    /* renamed from: d, reason: collision with root package name */
    public OverScroller f15577d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public int f15578f;

    /* renamed from: g, reason: collision with root package name */
    public int f15579g;

    /* renamed from: h, reason: collision with root package name */
    public int f15580h;

    /* renamed from: i, reason: collision with root package name */
    public VelocityTracker f15581i;

    @Override // x0.c
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        View view2;
        int findPointerIndex;
        if (this.f15580h < 0) {
            this.f15580h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.e) {
            int i3 = this.f15578f;
            if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) != -1) {
                int y4 = (int) motionEvent.getY(findPointerIndex);
                if (Math.abs(y4 - this.f15579g) > this.f15580h) {
                    this.f15579g = y4;
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f15578f = -1;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            WeakReference weakReference = ((AppBarLayout.BaseBehavior) this).f10187p;
            boolean z5 = (weakReference == null || !((view2 = (View) weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) && coordinatorLayout.t(view, x10, y10);
            this.e = z5;
            if (z5) {
                this.f15579g = y10;
                this.f15578f = motionEvent.getPointerId(0);
                if (this.f15581i == null) {
                    this.f15581i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f15577d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f15577d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f15581i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0101 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f1  */
    @Override // x0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(androidx.coordinatorlayout.widget.CoordinatorLayout r21, android.view.View r22, android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.e.r(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract int u();

    public abstract int v(CoordinatorLayout coordinatorLayout, View view, int i3, int i10, int i11);
}
