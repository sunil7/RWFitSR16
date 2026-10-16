package androidx.recyclerview.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d0 implements m1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f2528a;

    public d0(j0 j0Var) {
        this.f2528a = j0Var;
    }

    @Override // androidx.recyclerview.widget.m1
    public final boolean b(MotionEvent motionEvent) {
        int findPointerIndex;
        j0 j0Var = this.f2528a;
        j0Var.f2630x.f15711a.f15705a.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        e0 e0Var = null;
        if (actionMasked == 0) {
            j0Var.f2619l = motionEvent.getPointerId(0);
            j0Var.f2612d = motionEvent.getX();
            j0Var.e = motionEvent.getY();
            VelocityTracker velocityTracker = j0Var.f2626t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            j0Var.f2626t = VelocityTracker.obtain();
            if (j0Var.f2611c == null) {
                ArrayList arrayList = j0Var.f2623p;
                if (!arrayList.isEmpty()) {
                    View m10 = j0Var.m(motionEvent);
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        e0 e0Var2 = (e0) arrayList.get(size);
                        if (e0Var2.e.itemView == m10) {
                            e0Var = e0Var2;
                            break;
                        }
                        size--;
                    }
                }
                if (e0Var != null) {
                    j0Var.f2612d -= e0Var.f2545i;
                    j0Var.e -= e0Var.f2546j;
                    z1 z1Var = e0Var.e;
                    j0Var.l(z1Var, true);
                    if (j0Var.f2609a.remove(z1Var.itemView)) {
                        j0Var.f2620m.clearView(j0Var.r, z1Var);
                    }
                    j0Var.r(z1Var, e0Var.f2542f);
                    j0Var.t(motionEvent, j0Var.f2622o, 0);
                }
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            j0Var.f2619l = -1;
            j0Var.r(null, 0);
        } else {
            int i3 = j0Var.f2619l;
            if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) >= 0) {
                j0Var.j(motionEvent, actionMasked, findPointerIndex);
            }
        }
        VelocityTracker velocityTracker2 = j0Var.f2626t;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return j0Var.f2611c != null;
    }

    @Override // androidx.recyclerview.widget.m1
    public final void d(boolean z5) {
        if (z5) {
            this.f2528a.r(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.m1
    public final void onTouchEvent(MotionEvent motionEvent) {
        j0 j0Var = this.f2528a;
        j0Var.f2630x.f15711a.f15705a.onTouchEvent(motionEvent);
        VelocityTracker velocityTracker = j0Var.f2626t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (j0Var.f2619l == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int findPointerIndex = motionEvent.findPointerIndex(j0Var.f2619l);
        if (findPointerIndex >= 0) {
            j0Var.j(motionEvent, actionMasked, findPointerIndex);
        }
        z1 z1Var = j0Var.f2611c;
        if (z1Var == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (findPointerIndex >= 0) {
                    j0Var.t(motionEvent, j0Var.f2622o, findPointerIndex);
                    j0Var.p(z1Var);
                    RecyclerView recyclerView = j0Var.r;
                    t tVar = j0Var.f2625s;
                    recyclerView.removeCallbacks(tVar);
                    tVar.run();
                    j0Var.r.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == j0Var.f2619l) {
                    j0Var.f2619l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    j0Var.t(motionEvent, j0Var.f2622o, actionIndex);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = j0Var.f2626t;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        j0Var.r(null, 0);
        j0Var.f2619l = -1;
    }
}
