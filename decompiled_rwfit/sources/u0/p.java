package u0;

import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18737a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f18738b;

    public /* synthetic */ p(ViewGroup viewGroup, int i3) {
        this.f18737a = i3;
        this.f18738b = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18737a) {
            case 0:
                this.f18738b.setNestedScrollingEnabled(true);
                break;
            default:
                ((MotionLayout) this.f18738b).f1.a();
                break;
        }
    }
}
