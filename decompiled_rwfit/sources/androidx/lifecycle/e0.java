package androidx.lifecycle;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class e0 extends g {
    final /* synthetic */ f0 this$0;

    public class a extends g {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            e0.this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            f0 f0Var = e0.this.this$0;
            int i3 = f0Var.f2350a + 1;
            f0Var.f2350a = i3;
            if (i3 == 1 && f0Var.f2353d) {
                f0Var.f2354f.e(Lifecycle$Event.ON_START);
                f0Var.f2353d = false;
            }
        }
    }

    public e0(f0 f0Var) {
        this.this$0 = f0Var;
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            int i3 = g0.f2357b;
            ((g0) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag")).f2358a = this.this$0.f2356h;
        }
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        f0 f0Var = this.this$0;
        int i3 = f0Var.f2351b - 1;
        f0Var.f2351b = i3;
        if (i3 == 0) {
            f0Var.e.postDelayed(f0Var.f2355g, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new a());
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        f0 f0Var = this.this$0;
        int i3 = f0Var.f2350a - 1;
        f0Var.f2350a = i3;
        if (i3 == 0 && f0Var.f2352c) {
            f0Var.f2354f.e(Lifecycle$Event.ON_STOP);
            f0Var.f2353d = true;
        }
    }
}
