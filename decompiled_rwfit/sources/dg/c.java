package dg;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f12388a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12389b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Boolean f12390c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f12391d;
    public final /* synthetic */ SmartRefreshLayout e;

    public c(SmartRefreshLayout smartRefreshLayout, int i3, Boolean bool, boolean z5) {
        this.e = smartRefreshLayout;
        this.f12389b = i3;
        this.f12390c = bool;
        this.f12391d = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f12388a;
        SmartRefreshLayout smartRefreshLayout = this.e;
        if (i3 == 0) {
            RefreshState refreshState = smartRefreshLayout.f11654g1;
            RefreshState refreshState2 = RefreshState.None;
            Boolean bool = this.f12390c;
            if (refreshState == refreshState2 && smartRefreshLayout.f11657h1 == RefreshState.Refreshing) {
                smartRefreshLayout.f11657h1 = refreshState2;
            } else {
                ValueAnimator valueAnimator = smartRefreshLayout.f11677q1;
                if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                    valueAnimator.setDuration(0L);
                    smartRefreshLayout.f11677q1.cancel();
                    smartRefreshLayout.f11677q1 = null;
                    if (smartRefreshLayout.f1.k(0) == null) {
                        smartRefreshLayout.u(refreshState2);
                    } else {
                        smartRefreshLayout.u(RefreshState.PullDownCanceled);
                    }
                } else if (refreshState == RefreshState.Refreshing && smartRefreshLayout.f11638a1 != null && smartRefreshLayout.f11644c1 != null) {
                    this.f12388a = i3 + 1;
                    smartRefreshLayout.f11649e1.postDelayed(this, this.f12389b);
                    smartRefreshLayout.u(RefreshState.RefreshFinish);
                    if (bool == Boolean.FALSE) {
                        smartRefreshLayout.w(false);
                    }
                }
            }
            if (bool == Boolean.TRUE) {
                smartRefreshLayout.w(true);
                return;
            }
            return;
        }
        int i10 = smartRefreshLayout.f11638a1.i(smartRefreshLayout, this.f12391d);
        if (i10 < Integer.MAX_VALUE) {
            if (smartRefreshLayout.f11670n || smartRefreshLayout.f11643c0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (smartRefreshLayout.f11670n) {
                    float f2 = smartRefreshLayout.f11663k;
                    smartRefreshLayout.f11658i = f2;
                    smartRefreshLayout.f11645d = 0;
                    smartRefreshLayout.f11670n = false;
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout.f11660j, (f2 + smartRefreshLayout.f11639b) - (smartRefreshLayout.f11636a * 2), 0));
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout.f11660j, smartRefreshLayout.f11663k + smartRefreshLayout.f11639b, 0));
                }
                if (smartRefreshLayout.f11643c0) {
                    smartRefreshLayout.f11640b0 = 0;
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout.f11660j, smartRefreshLayout.f11663k, 0));
                    smartRefreshLayout.f11643c0 = false;
                    smartRefreshLayout.f11645d = 0;
                }
            }
            int i11 = smartRefreshLayout.f11639b;
            if (i11 <= 0) {
                if (i11 < 0) {
                    smartRefreshLayout.m(0, i10, smartRefreshLayout.f11685z, smartRefreshLayout.f11650f);
                    return;
                } else {
                    smartRefreshLayout.f1.l(0, false);
                    smartRefreshLayout.f1.w(RefreshState.None);
                    return;
                }
            }
            ValueAnimator m10 = smartRefreshLayout.m(0, i10, smartRefreshLayout.f11685z, smartRefreshLayout.f11650f);
            jg.a e = smartRefreshLayout.O ? smartRefreshLayout.f11644c1.e(smartRefreshLayout.f11639b) : null;
            if (m10 == null || e == null) {
                return;
            }
            m10.addUpdateListener(e);
        }
    }
}
