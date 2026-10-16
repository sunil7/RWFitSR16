package j2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class y implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15309a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15310b;

    public /* synthetic */ y(Object obj, int i3) {
        this.f15309a = i3;
        this.f15310b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view;
        Object obj = this.f15310b;
        switch (this.f15309a) {
            case 0:
                WeakHashMap weakHashMap = z0.f15748a;
                z zVar = (z) obj;
                l1.h0.k(zVar);
                ViewGroup viewGroup = zVar.f15312a;
                if (viewGroup != null && (view = zVar.f15313b) != null) {
                    viewGroup.endViewTransition(view);
                    l1.h0.k(zVar.f15312a);
                    zVar.f15312a = null;
                    zVar.f15313b = null;
                    break;
                }
                break;
            case 1:
                wa.n nVar = (wa.n) obj;
                float rotation = nVar.f19586x.getRotation();
                if (nVar.f19580q != rotation) {
                    nVar.f19580q = rotation;
                    nVar.p();
                    break;
                }
                break;
            default:
                ((CoordinatorLayout) obj).u(0);
                break;
        }
        return true;
    }
}
