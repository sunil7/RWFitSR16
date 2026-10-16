package androidx.recyclerview.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.R$dimen;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class j0 extends g1 implements k1 {
    public Rect A;
    public long B;

    /* renamed from: d, reason: collision with root package name */
    public float f2612d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f2613f;

    /* renamed from: g, reason: collision with root package name */
    public float f2614g;

    /* renamed from: h, reason: collision with root package name */
    public float f2615h;

    /* renamed from: i, reason: collision with root package name */
    public float f2616i;

    /* renamed from: j, reason: collision with root package name */
    public float f2617j;

    /* renamed from: k, reason: collision with root package name */
    public float f2618k;

    /* renamed from: m, reason: collision with root package name */
    public final g0 f2620m;

    /* renamed from: o, reason: collision with root package name */
    public int f2622o;

    /* renamed from: q, reason: collision with root package name */
    public int f2624q;
    public RecyclerView r;

    /* renamed from: t, reason: collision with root package name */
    public VelocityTracker f2626t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f2627u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f2628v;

    /* renamed from: x, reason: collision with root package name */
    public l1.m f2630x;

    /* renamed from: y, reason: collision with root package name */
    public h0 f2631y;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2609a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final float[] f2610b = new float[2];

    /* renamed from: c, reason: collision with root package name */
    public z1 f2611c = null;

    /* renamed from: l, reason: collision with root package name */
    public int f2619l = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f2621n = 0;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f2623p = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final t f2625s = new t(this, 1);

    /* renamed from: w, reason: collision with root package name */
    public View f2629w = null;

    /* renamed from: z, reason: collision with root package name */
    public final d0 f2632z = new d0(this);

    public j0(g0 g0Var) {
        this.f2620m = g0Var;
    }

    public static boolean o(View view, float f2, float f10, float f11, float f12) {
        return f2 >= f11 && f2 <= f11 + ((float) view.getWidth()) && f10 >= f12 && f10 <= f12 + ((float) view.getHeight());
    }

    @Override // androidx.recyclerview.widget.k1
    public final void a(View view) {
    }

    @Override // androidx.recyclerview.widget.k1
    public final void c(View view) {
        q(view);
        z1 K = this.r.K(view);
        if (K == null) {
            return;
        }
        z1 z1Var = this.f2611c;
        if (z1Var != null && K == z1Var) {
            r(null, 0);
            return;
        }
        l(K, false);
        if (this.f2609a.remove(K.itemView)) {
            this.f2620m.clearView(this.r, K);
        }
    }

    @Override // androidx.recyclerview.widget.g1
    public final void e(Rect rect, View view, RecyclerView recyclerView, w1 w1Var) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.g1
    public final void f(Canvas canvas, RecyclerView recyclerView) {
        float f2;
        float f10;
        if (this.f2611c != null) {
            float[] fArr = this.f2610b;
            n(fArr);
            float f11 = fArr[0];
            f10 = fArr[1];
            f2 = f11;
        } else {
            f2 = 0.0f;
            f10 = 0.0f;
        }
        this.f2620m.onDraw(canvas, recyclerView, this.f2611c, this.f2623p, this.f2621n, f2, f10);
    }

    @Override // androidx.recyclerview.widget.g1
    public final void g(Canvas canvas, RecyclerView recyclerView) {
        float f2;
        float f10;
        if (this.f2611c != null) {
            float[] fArr = this.f2610b;
            n(fArr);
            float f11 = fArr[0];
            f10 = fArr[1];
            f2 = f11;
        } else {
            f2 = 0.0f;
            f10 = 0.0f;
        }
        this.f2620m.onDrawOver(canvas, recyclerView, this.f2611c, this.f2623p, this.f2621n, f2, f10);
    }

    public final void h(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        d0 d0Var = this.f2632z;
        if (recyclerView2 != null) {
            recyclerView2.b0(this);
            this.r.removeOnItemTouchListener(d0Var);
            this.r.removeOnChildAttachStateChangeListener(this);
            ArrayList arrayList = this.f2623p;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                e0 e0Var = (e0) arrayList.get(0);
                e0Var.f2543g.cancel();
                this.f2620m.clearView(this.r, e0Var.e);
            }
            arrayList.clear();
            this.f2629w = null;
            VelocityTracker velocityTracker = this.f2626t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2626t = null;
            }
            h0 h0Var = this.f2631y;
            if (h0Var != null) {
                h0Var.f2577a = false;
                this.f2631y = null;
            }
            if (this.f2630x != null) {
                this.f2630x = null;
            }
        }
        this.r = recyclerView;
        Resources resources = recyclerView.getResources();
        this.f2613f = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
        this.f2614g = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
        this.f2624q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.g(this);
        this.r.addOnItemTouchListener(d0Var);
        this.r.addOnChildAttachStateChangeListener(this);
        this.f2631y = new h0(this);
        this.f2630x = new l1.m(this.r.getContext(), this.f2631y);
    }

    public final int i(z1 z1Var, int i3) {
        if ((i3 & 12) == 0) {
            return 0;
        }
        int i10 = this.f2615h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f2626t;
        g0 g0Var = this.f2620m;
        if (velocityTracker != null && this.f2619l > -1) {
            velocityTracker.computeCurrentVelocity(1000, g0Var.getSwipeVelocityThreshold(this.f2614g));
            float xVelocity = this.f2626t.getXVelocity(this.f2619l);
            float yVelocity = this.f2626t.getYVelocity(this.f2619l);
            int i11 = xVelocity > 0.0f ? 8 : 4;
            float abs = Math.abs(xVelocity);
            if ((i11 & i3) != 0 && i10 == i11 && abs >= g0Var.getSwipeEscapeVelocity(this.f2613f) && abs > Math.abs(yVelocity)) {
                return i11;
            }
        }
        float swipeThreshold = g0Var.getSwipeThreshold(z1Var) * this.r.getWidth();
        if ((i3 & i10) == 0 || Math.abs(this.f2615h) <= swipeThreshold) {
            return 0;
        }
        return i10;
    }

    public final void j(MotionEvent motionEvent, int i3, int i10) {
        int absoluteMovementFlags;
        View m10;
        if (this.f2611c == null && i3 == 2 && this.f2621n != 2) {
            g0 g0Var = this.f2620m;
            if (g0Var.isItemViewSwipeEnabled() && this.r.getScrollState() != 1) {
                i1 layoutManager = this.r.getLayoutManager();
                int i11 = this.f2619l;
                z1 z1Var = null;
                if (i11 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i11);
                    float x10 = motionEvent.getX(findPointerIndex) - this.f2612d;
                    float y4 = motionEvent.getY(findPointerIndex) - this.e;
                    float abs = Math.abs(x10);
                    float abs2 = Math.abs(y4);
                    float f2 = this.f2624q;
                    if ((abs >= f2 || abs2 >= f2) && ((abs <= abs2 || !layoutManager.d()) && ((abs2 <= abs || !layoutManager.e()) && (m10 = m(motionEvent)) != null))) {
                        z1Var = this.r.K(m10);
                    }
                }
                if (z1Var == null || (absoluteMovementFlags = (g0Var.getAbsoluteMovementFlags(this.r, z1Var) & 65280) >> 8) == 0) {
                    return;
                }
                float x11 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                float f10 = x11 - this.f2612d;
                float f11 = y10 - this.e;
                float abs3 = Math.abs(f10);
                float abs4 = Math.abs(f11);
                float f12 = this.f2624q;
                if (abs3 >= f12 || abs4 >= f12) {
                    if (abs3 > abs4) {
                        if (f10 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                            return;
                        }
                        if (f10 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                            return;
                        }
                    } else {
                        if (f11 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                            return;
                        }
                        if (f11 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                            return;
                        }
                    }
                    this.f2616i = 0.0f;
                    this.f2615h = 0.0f;
                    this.f2619l = motionEvent.getPointerId(0);
                    r(z1Var, 1);
                }
            }
        }
    }

    public final int k(z1 z1Var, int i3) {
        if ((i3 & 3) == 0) {
            return 0;
        }
        int i10 = this.f2616i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f2626t;
        g0 g0Var = this.f2620m;
        if (velocityTracker != null && this.f2619l > -1) {
            velocityTracker.computeCurrentVelocity(1000, g0Var.getSwipeVelocityThreshold(this.f2614g));
            float xVelocity = this.f2626t.getXVelocity(this.f2619l);
            float yVelocity = this.f2626t.getYVelocity(this.f2619l);
            int i11 = yVelocity > 0.0f ? 2 : 1;
            float abs = Math.abs(yVelocity);
            if ((i11 & i3) != 0 && i11 == i10 && abs >= g0Var.getSwipeEscapeVelocity(this.f2613f) && abs > Math.abs(xVelocity)) {
                return i11;
            }
        }
        float swipeThreshold = g0Var.getSwipeThreshold(z1Var) * this.r.getHeight();
        if ((i3 & i10) == 0 || Math.abs(this.f2616i) <= swipeThreshold) {
            return 0;
        }
        return i10;
    }

    public final void l(z1 z1Var, boolean z5) {
        ArrayList arrayList = this.f2623p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            e0 e0Var = (e0) arrayList.get(size);
            if (e0Var.e == z1Var) {
                e0Var.f2547k |= z5;
                if (!e0Var.f2548l) {
                    e0Var.f2543g.cancel();
                }
                arrayList.remove(size);
                return;
            }
        }
    }

    public final View m(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y4 = motionEvent.getY();
        z1 z1Var = this.f2611c;
        if (z1Var != null) {
            View view = z1Var.itemView;
            if (o(view, x10, y4, this.f2617j + this.f2615h, this.f2618k + this.f2616i)) {
                return view;
            }
        }
        ArrayList arrayList = this.f2623p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            e0 e0Var = (e0) arrayList.get(size);
            View view2 = e0Var.e.itemView;
            if (o(view2, x10, y4, e0Var.f2545i, e0Var.f2546j)) {
                return view2;
            }
        }
        return this.r.A(x10, y4);
    }

    public final void n(float[] fArr) {
        if ((this.f2622o & 12) != 0) {
            fArr[0] = (this.f2617j + this.f2615h) - this.f2611c.itemView.getLeft();
        } else {
            fArr[0] = this.f2611c.itemView.getTranslationX();
        }
        if ((this.f2622o & 3) != 0) {
            fArr[1] = (this.f2618k + this.f2616i) - this.f2611c.itemView.getTop();
        } else {
            fArr[1] = this.f2611c.itemView.getTranslationY();
        }
    }

    public final void p(z1 z1Var) {
        int i3;
        int i10;
        int i11;
        if (this.r.isLayoutRequested()) {
            return;
        }
        char c9 = 2;
        if (this.f2621n != 2) {
            return;
        }
        g0 g0Var = this.f2620m;
        float moveThreshold = g0Var.getMoveThreshold(z1Var);
        int i12 = (int) (this.f2617j + this.f2615h);
        int i13 = (int) (this.f2618k + this.f2616i);
        if (Math.abs(i13 - z1Var.itemView.getTop()) >= z1Var.itemView.getHeight() * moveThreshold || Math.abs(i12 - z1Var.itemView.getLeft()) >= z1Var.itemView.getWidth() * moveThreshold) {
            ArrayList arrayList = this.f2627u;
            if (arrayList == null) {
                this.f2627u = new ArrayList();
                this.f2628v = new ArrayList();
            } else {
                arrayList.clear();
                this.f2628v.clear();
            }
            int boundingBoxMargin = g0Var.getBoundingBoxMargin();
            int round = Math.round(this.f2617j + this.f2615h) - boundingBoxMargin;
            int round2 = Math.round(this.f2618k + this.f2616i) - boundingBoxMargin;
            int i14 = boundingBoxMargin * 2;
            int width = z1Var.itemView.getWidth() + round + i14;
            int height = z1Var.itemView.getHeight() + round2 + i14;
            int i15 = (round + width) / 2;
            int i16 = (round2 + height) / 2;
            i1 layoutManager = this.r.getLayoutManager();
            int v6 = layoutManager.v();
            int i17 = 0;
            while (i17 < v6) {
                char c10 = c9;
                View u10 = layoutManager.u(i17);
                if (u10 != z1Var.itemView && u10.getBottom() >= round2 && u10.getTop() <= height && u10.getRight() >= round && u10.getLeft() <= width) {
                    z1 K = this.r.K(u10);
                    i3 = i15;
                    if (g0Var.canDropOver(this.r, this.f2611c, K)) {
                        int abs = Math.abs(i3 - ((u10.getRight() + u10.getLeft()) / 2));
                        int abs2 = Math.abs(i16 - ((u10.getBottom() + u10.getTop()) / 2));
                        int i18 = (abs2 * abs2) + (abs * abs);
                        int size = this.f2627u.size();
                        i10 = round;
                        i11 = round2;
                        int i19 = 0;
                        int i20 = 0;
                        while (i19 < size) {
                            int i21 = size;
                            if (i18 <= ((Integer) this.f2628v.get(i19)).intValue()) {
                                break;
                            }
                            i20++;
                            i19++;
                            size = i21;
                        }
                        this.f2627u.add(i20, K);
                        this.f2628v.add(i20, Integer.valueOf(i18));
                        i17++;
                        c9 = c10;
                        round = i10;
                        i15 = i3;
                        round2 = i11;
                    }
                } else {
                    i3 = i15;
                }
                i10 = round;
                i11 = round2;
                i17++;
                c9 = c10;
                round = i10;
                i15 = i3;
                round2 = i11;
            }
            ArrayList arrayList2 = this.f2627u;
            if (arrayList2.size() == 0) {
                return;
            }
            z1 chooseDropTarget = g0Var.chooseDropTarget(z1Var, arrayList2, i12, i13);
            if (chooseDropTarget == null) {
                this.f2627u.clear();
                this.f2628v.clear();
                return;
            }
            int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
            int absoluteAdapterPosition2 = z1Var.getAbsoluteAdapterPosition();
            if (g0Var.onMove(this.r, z1Var, chooseDropTarget)) {
                this.f2620m.onMoved(this.r, z1Var, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, i12, i13);
            }
        }
    }

    public final void q(View view) {
        if (view == this.f2629w) {
            this.f2629w = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0092, code lost:
    
        if (r8 > 0) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f5  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(androidx.recyclerview.widget.z1 r22, int r23) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.j0.r(androidx.recyclerview.widget.z1, int):void");
    }

    public final void s(z1 z1Var) {
        if (!this.f2620m.hasDragFlag(this.r, z1Var)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (z1Var.itemView.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        VelocityTracker velocityTracker = this.f2626t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f2626t = VelocityTracker.obtain();
        this.f2616i = 0.0f;
        this.f2615h = 0.0f;
        r(z1Var, 2);
    }

    public final void t(MotionEvent motionEvent, int i3, int i10) {
        float x10 = motionEvent.getX(i10);
        float y4 = motionEvent.getY(i10);
        float f2 = x10 - this.f2612d;
        this.f2615h = f2;
        this.f2616i = y4 - this.e;
        if ((i3 & 4) == 0) {
            this.f2615h = Math.max(0.0f, f2);
        }
        if ((i3 & 8) == 0) {
            this.f2615h = Math.min(0.0f, this.f2615h);
        }
        if ((i3 & 1) == 0) {
            this.f2616i = Math.max(0.0f, this.f2616i);
        }
        if ((i3 & 2) == 0) {
            this.f2616i = Math.min(0.0f, this.f2616i);
        }
    }
}
