package dg;

import android.view.animation.AnimationUtils;
import com.example.test.ui.device.activity.i0;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final int f12397b;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f12400f;

    /* renamed from: a, reason: collision with root package name */
    public int f12396a = 0;

    /* renamed from: d, reason: collision with root package name */
    public float f12399d = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public long f12398c = AnimationUtils.currentAnimationTimeMillis();

    public e(SmartRefreshLayout smartRefreshLayout, float f2, int i3) {
        this.f12400f = smartRefreshLayout;
        this.e = f2;
        this.f12397b = i3;
        smartRefreshLayout.f11649e1.postDelayed(this, 10);
        i0 i0Var = smartRefreshLayout.f1;
        if (f2 > 0.0f) {
            i0Var.w(RefreshState.PullDownToRefresh);
        } else {
            i0Var.w(RefreshState.PullUpToLoad);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmartRefreshLayout smartRefreshLayout = this.f12400f;
        if (smartRefreshLayout.f11675p1 != this || smartRefreshLayout.f11654g1.isFinishing) {
            return;
        }
        int abs = Math.abs(smartRefreshLayout.f11639b);
        int i3 = this.f12397b;
        if (abs < Math.abs(i3)) {
            double d5 = this.e;
            this.f12396a = this.f12396a + 1;
            this.e = (float) (Math.pow(0.949999988079071d, r1 * 2) * d5);
        } else if (i3 != 0) {
            double d8 = this.e;
            this.f12396a = this.f12396a + 1;
            this.e = (float) (Math.pow(0.44999998807907104d, r1 * 2) * d8);
        } else {
            double d10 = this.e;
            this.f12396a = this.f12396a + 1;
            this.e = (float) (Math.pow(0.8500000238418579d, r1 * 2) * d10);
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float f2 = this.e * (((currentAnimationTimeMillis - this.f12398c) * 1.0f) / 1000.0f);
        if (Math.abs(f2) >= 1.0f) {
            this.f12398c = currentAnimationTimeMillis;
            float f10 = this.f12399d + f2;
            this.f12399d = f10;
            smartRefreshLayout.t(f10);
            smartRefreshLayout.f11649e1.postDelayed(this, 10);
            return;
        }
        RefreshState refreshState = smartRefreshLayout.f11657h1;
        boolean z5 = refreshState.isDragging;
        if (z5 && refreshState.isHeader) {
            smartRefreshLayout.f1.w(RefreshState.PullDownCanceled);
        } else if (z5 && refreshState.isFooter) {
            smartRefreshLayout.f1.w(RefreshState.PullUpCanceled);
        }
        smartRefreshLayout.f11675p1 = null;
        if (Math.abs(smartRefreshLayout.f11639b) >= Math.abs(i3)) {
            smartRefreshLayout.m(i3, 0, smartRefreshLayout.f11685z, Math.min(Math.max((int) (Math.abs(smartRefreshLayout.f11639b - i3) / ig.b.f14432a), 30), 100) * 10);
        }
    }
}
