package dg;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import androidx.emoji2.text.i;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f12392a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12393b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f12394c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f12395d;

    public d(int i3, SmartRefreshLayout smartRefreshLayout, boolean z5) {
        this.f12395d = smartRefreshLayout;
        this.f12393b = i3;
        this.f12394c = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f12392a;
        boolean z5 = this.f12394c;
        SmartRefreshLayout smartRefreshLayout = this.f12395d;
        if (i3 != 0) {
            int i10 = smartRefreshLayout.f11641b1.i(smartRefreshLayout, true);
            if (i10 < Integer.MAX_VALUE) {
                boolean z6 = z5 && smartRefreshLayout.H && smartRefreshLayout.f11639b < 0 && smartRefreshLayout.f11644c1.a();
                int i11 = smartRefreshLayout.f11639b;
                int max = i11 - (z6 ? Math.max(i11, -smartRefreshLayout.i0) : 0);
                if (smartRefreshLayout.f11670n || smartRefreshLayout.f11643c0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (smartRefreshLayout.f11670n) {
                        float f2 = smartRefreshLayout.f11663k;
                        smartRefreshLayout.f11658i = f2;
                        smartRefreshLayout.f11645d = smartRefreshLayout.f11639b - max;
                        smartRefreshLayout.f11670n = false;
                        float f10 = smartRefreshLayout.G ? max : 0;
                        super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout.f11660j, f2 + f10 + (smartRefreshLayout.f11636a * 2), 0));
                        super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout.f11660j, smartRefreshLayout.f11663k + f10, 0));
                    }
                    if (smartRefreshLayout.f11643c0) {
                        smartRefreshLayout.f11640b0 = 0;
                        super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout.f11660j, smartRefreshLayout.f11663k, 0));
                        smartRefreshLayout.f11643c0 = false;
                        smartRefreshLayout.f11645d = 0;
                    }
                }
                smartRefreshLayout.f11649e1.postDelayed(new i(max, 3, this), smartRefreshLayout.f11639b < 0 ? i10 : 0L);
                return;
            }
            return;
        }
        RefreshState refreshState = smartRefreshLayout.f11654g1;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState == refreshState2 && smartRefreshLayout.f11657h1 == RefreshState.Loading) {
            smartRefreshLayout.f11657h1 = refreshState2;
        } else {
            ValueAnimator valueAnimator = smartRefreshLayout.f11677q1;
            if (valueAnimator != null && ((refreshState.isDragging || refreshState == RefreshState.LoadReleased) && refreshState.isFooter)) {
                valueAnimator.setDuration(0L);
                smartRefreshLayout.f11677q1.cancel();
                smartRefreshLayout.f11677q1 = null;
                if (smartRefreshLayout.f1.k(0) == null) {
                    smartRefreshLayout.u(refreshState2);
                } else {
                    smartRefreshLayout.u(RefreshState.PullUpCanceled);
                }
            } else if (refreshState == RefreshState.Loading && smartRefreshLayout.f11641b1 != null && smartRefreshLayout.f11644c1 != null) {
                this.f12392a = i3 + 1;
                smartRefreshLayout.f11649e1.postDelayed(this, this.f12393b);
                smartRefreshLayout.u(RefreshState.LoadFinish);
                return;
            }
        }
        if (z5) {
            smartRefreshLayout.w(true);
        }
    }
}
