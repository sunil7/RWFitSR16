package dg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.example.test.presenter.device.z;
import com.example.test.ui.device.activity.DialListActivity;
import com.example.test.ui.device.activity.m;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import f6.y;

/* loaded from: classes2.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12385a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f12386b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f12387c;

    public /* synthetic */ b(int i3, SmartRefreshLayout smartRefreshLayout, boolean z5) {
        this.f12385a = i3;
        this.f12387c = smartRefreshLayout;
        this.f12386b = z5;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        boolean z5 = this.f12386b;
        SmartRefreshLayout smartRefreshLayout = this.f12387c;
        switch (this.f12385a) {
            case 0:
                if (animator == null || animator.getDuration() != 0) {
                    smartRefreshLayout.setStateDirectLoading(z5);
                    break;
                }
                break;
            default:
                if (animator == null || animator.getDuration() != 0) {
                    smartRefreshLayout.f11659i1 = System.currentTimeMillis();
                    smartRefreshLayout.u(RefreshState.Refreshing);
                    if (smartRefreshLayout.W == null) {
                        smartRefreshLayout.p(3000, true, Boolean.FALSE);
                    } else if (z5) {
                        smartRefreshLayout.f11649e1.removeCallbacksAndMessages(null);
                        m mVar = smartRefreshLayout.W;
                        mVar.getClass();
                        int i3 = DialListActivity.L;
                        DialListActivity this$0 = mVar.f7876a;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        eh.b bVar = this$0.f7247z;
                        if (((y) bVar.getValue()).f13453c.f11654g1 != RefreshState.Loading) {
                            this$0.F = 1;
                            ((y) bVar.getValue()).f13453c.w(false);
                            ((z) this$0.I0()).k(((Number) this$0.I.getValue()).intValue(), this$0.F, this$0.G);
                        }
                    }
                    eg.c cVar = smartRefreshLayout.f11638a1;
                    if (cVar != null) {
                        float f2 = smartRefreshLayout.V0;
                        if (f2 < 10.0f) {
                            f2 *= smartRefreshLayout.f11653g0;
                        }
                        cVar.h(smartRefreshLayout, smartRefreshLayout.f11653g0, (int) f2);
                        break;
                    }
                }
                break;
        }
    }
}
