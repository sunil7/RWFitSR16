package dg;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f12401a;

    /* renamed from: b, reason: collision with root package name */
    public float f12402b;

    /* renamed from: c, reason: collision with root package name */
    public long f12403c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f12404d = AnimationUtils.currentAnimationTimeMillis();
    public final /* synthetic */ SmartRefreshLayout e;

    public f(SmartRefreshLayout smartRefreshLayout, float f2) {
        this.e = smartRefreshLayout;
        this.f12402b = f2;
        this.f12401a = smartRefreshLayout.f11639b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmartRefreshLayout smartRefreshLayout = this.e;
        if (smartRefreshLayout.f11675p1 != this || smartRefreshLayout.f11654g1.isFinishing) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        long j4 = currentAnimationTimeMillis - this.f12404d;
        float pow = (float) (Math.pow(0.98f, (currentAnimationTimeMillis - this.f12403c) / (1000.0f / 10)) * this.f12402b);
        this.f12402b = pow;
        float f2 = ((j4 * 1.0f) / 1000.0f) * pow;
        if (Math.abs(f2) <= 1.0f) {
            smartRefreshLayout.f11675p1 = null;
            return;
        }
        this.f12404d = currentAnimationTimeMillis;
        int i3 = (int) (this.f12401a + f2);
        this.f12401a = i3;
        if (smartRefreshLayout.f11639b * i3 > 0) {
            smartRefreshLayout.f1.l(i3, true);
            smartRefreshLayout.f11649e1.postDelayed(this, 10);
            return;
        }
        smartRefreshLayout.f11675p1 = null;
        smartRefreshLayout.f1.l(0, true);
        View view = smartRefreshLayout.f11644c1.f15443c;
        int i10 = (int) (-this.f12402b);
        float f10 = ig.b.f14432a;
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i10);
        } else if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i10);
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i10);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).k(i10);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).H(0, i10);
        }
        if (!smartRefreshLayout.f11667l1 || f2 <= 0.0f) {
            return;
        }
        smartRefreshLayout.f11667l1 = false;
    }
}
