package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$id;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class g0 {
    private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
    static final int RELATIVE_DIR_FLAGS = 3158064;
    private static final Interpolator sDragScrollInterpolator = new f0(0);
    private static final Interpolator sDragViewScrollCapInterpolator = new f0(1);
    private int mCachedMaxScrollSpeed = -1;

    public static int convertToRelativeDirection(int i3, int i10) {
        int i11;
        int i12 = i3 & ABS_HORIZONTAL_DIR_FLAGS;
        if (i12 == 0) {
            return i3;
        }
        int i13 = i3 & (~i12);
        if (i10 == 0) {
            i11 = i12 << 2;
        } else {
            int i14 = i12 << 1;
            i13 |= (-789517) & i14;
            i11 = (i14 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
        }
        return i13 | i11;
    }

    public static k0 getDefaultUIUtil() {
        return l0.f2662a;
    }

    public static int makeFlag(int i3, int i10) {
        return i10 << (i3 * 8);
    }

    public static int makeMovementFlags(int i3, int i10) {
        return makeFlag(2, i3) | makeFlag(1, i10) | makeFlag(0, i10 | i3);
    }

    public boolean canDropOver(RecyclerView recyclerView, z1 z1Var, z1 z1Var2) {
        return true;
    }

    public z1 chooseDropTarget(z1 z1Var, List<z1> list, int i3, int i10) {
        int bottom;
        int abs;
        int top;
        int abs2;
        int left;
        int abs3;
        int right;
        int abs4;
        int width = z1Var.itemView.getWidth() + i3;
        int height = z1Var.itemView.getHeight() + i10;
        int left2 = i3 - z1Var.itemView.getLeft();
        int top2 = i10 - z1Var.itemView.getTop();
        int size = list.size();
        z1 z1Var2 = null;
        int i11 = -1;
        for (int i12 = 0; i12 < size; i12++) {
            z1 z1Var3 = list.get(i12);
            if (left2 > 0 && (right = z1Var3.itemView.getRight() - width) < 0 && z1Var3.itemView.getRight() > z1Var.itemView.getRight() && (abs4 = Math.abs(right)) > i11) {
                z1Var2 = z1Var3;
                i11 = abs4;
            }
            if (left2 < 0 && (left = z1Var3.itemView.getLeft() - i3) > 0 && z1Var3.itemView.getLeft() < z1Var.itemView.getLeft() && (abs3 = Math.abs(left)) > i11) {
                z1Var2 = z1Var3;
                i11 = abs3;
            }
            if (top2 < 0 && (top = z1Var3.itemView.getTop() - i10) > 0 && z1Var3.itemView.getTop() < z1Var.itemView.getTop() && (abs2 = Math.abs(top)) > i11) {
                z1Var2 = z1Var3;
                i11 = abs2;
            }
            if (top2 > 0 && (bottom = z1Var3.itemView.getBottom() - height) < 0 && z1Var3.itemView.getBottom() > z1Var.itemView.getBottom() && (abs = Math.abs(bottom)) > i11) {
                z1Var2 = z1Var3;
                i11 = abs;
            }
        }
        return z1Var2;
    }

    public void clearView(RecyclerView recyclerView, z1 z1Var) {
        View view = z1Var.itemView;
        Object tag = view.getTag(R$id.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            float floatValue = ((Float) tag).floatValue();
            WeakHashMap weakHashMap = l1.z0.f15748a;
            l1.n0.s(view, floatValue);
        }
        view.setTag(R$id.item_touch_helper_previous_elevation, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public int convertToAbsoluteDirection(int i3, int i10) {
        int i11;
        int i12 = i3 & RELATIVE_DIR_FLAGS;
        if (i12 == 0) {
            return i3;
        }
        int i13 = i3 & (~i12);
        if (i10 == 0) {
            i11 = i12 >> 2;
        } else {
            int i14 = i12 >> 1;
            i13 |= (-3158065) & i14;
            i11 = (i14 & RELATIVE_DIR_FLAGS) >> 2;
        }
        return i13 | i11;
    }

    public final int getAbsoluteMovementFlags(RecyclerView recyclerView, z1 z1Var) {
        int movementFlags = getMovementFlags(recyclerView, z1Var);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        return convertToAbsoluteDirection(movementFlags, l1.i0.d(recyclerView));
    }

    public long getAnimationDuration(RecyclerView recyclerView, int i3, float f2, float f10) {
        f1 itemAnimator = recyclerView.getItemAnimator();
        return itemAnimator == null ? i3 == 8 ? 200L : 250L : i3 == 8 ? itemAnimator.e : itemAnimator.f2564d;
    }

    public int getBoundingBoxMargin() {
        return 0;
    }

    public float getMoveThreshold(z1 z1Var) {
        return 0.5f;
    }

    public abstract int getMovementFlags(RecyclerView recyclerView, z1 z1Var);

    public float getSwipeEscapeVelocity(float f2) {
        return f2;
    }

    public float getSwipeThreshold(z1 z1Var) {
        return 0.5f;
    }

    public float getSwipeVelocityThreshold(float f2) {
        return f2;
    }

    public boolean hasDragFlag(RecyclerView recyclerView, z1 z1Var) {
        return (getAbsoluteMovementFlags(recyclerView, z1Var) & 16711680) != 0;
    }

    public boolean hasSwipeFlag(RecyclerView recyclerView, z1 z1Var) {
        return (getAbsoluteMovementFlags(recyclerView, z1Var) & 65280) != 0;
    }

    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i3, int i10, int i11, long j4) {
        if (this.mCachedMaxScrollSpeed == -1) {
            this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
        }
        int interpolation = (int) (sDragScrollInterpolator.getInterpolation(j4 <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? j4 / 2000.0f : 1.0f) * ((int) (sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i10) * 1.0f) / i3)) * ((int) Math.signum(i10)) * this.mCachedMaxScrollSpeed)));
        return interpolation == 0 ? i10 > 0 ? 1 : -1 : interpolation;
    }

    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public boolean isLongPressDragEnabled() {
        return true;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, z1 z1Var, float f2, float f10, int i3, boolean z5) {
        View view = z1Var.itemView;
        if (z5 && view.getTag(R$id.item_touch_helper_previous_elevation) == null) {
            WeakHashMap weakHashMap = l1.z0.f15748a;
            Float valueOf = Float.valueOf(l1.n0.i(view));
            int childCount = recyclerView.getChildCount();
            float f11 = 0.0f;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = recyclerView.getChildAt(i10);
                if (childAt != view) {
                    WeakHashMap weakHashMap2 = l1.z0.f15748a;
                    float i11 = l1.n0.i(childAt);
                    if (i11 > f11) {
                        f11 = i11;
                    }
                }
            }
            l1.n0.s(view, f11 + 1.0f);
            view.setTag(R$id.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f2);
        view.setTranslationY(f10);
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, z1 z1Var, float f2, float f10, int i3, boolean z5) {
        View view = z1Var.itemView;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, z1 z1Var, List<e0> list, int i3, float f2, float f10) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            e0 e0Var = list.get(i10);
            float f11 = e0Var.f2538a;
            float f12 = e0Var.f2540c;
            z1 z1Var2 = e0Var.e;
            if (f11 == f12) {
                e0Var.f2545i = z1Var2.itemView.getTranslationX();
            } else {
                e0Var.f2545i = com.google.android.gms.internal.mlkit_vision_barcode.l0.a(f12, f11, e0Var.f2549m, f11);
            }
            float f13 = e0Var.f2539b;
            float f14 = e0Var.f2541d;
            if (f13 == f14) {
                e0Var.f2546j = z1Var2.itemView.getTranslationY();
            } else {
                e0Var.f2546j = com.google.android.gms.internal.mlkit_vision_barcode.l0.a(f14, f13, e0Var.f2549m, f13);
            }
            int save = canvas.save();
            onChildDraw(canvas, recyclerView, e0Var.e, e0Var.f2545i, e0Var.f2546j, e0Var.f2542f, false);
            canvas.restoreToCount(save);
        }
        if (z1Var != null) {
            int save2 = canvas.save();
            onChildDraw(canvas, recyclerView, z1Var, f2, f10, i3, true);
            canvas.restoreToCount(save2);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, z1 z1Var, List<e0> list, int i3, float f2, float f10) {
        int size = list.size();
        boolean z5 = false;
        for (int i10 = 0; i10 < size; i10++) {
            e0 e0Var = list.get(i10);
            int save = canvas.save();
            onChildDrawOver(canvas, recyclerView, e0Var.e, e0Var.f2545i, e0Var.f2546j, e0Var.f2542f, false);
            canvas.restoreToCount(save);
        }
        if (z1Var != null) {
            int save2 = canvas.save();
            onChildDrawOver(canvas, recyclerView, z1Var, f2, f10, i3, true);
            canvas.restoreToCount(save2);
        }
        for (int i11 = size - 1; i11 >= 0; i11--) {
            e0 e0Var2 = list.get(i11);
            boolean z6 = e0Var2.f2548l;
            if (z6 && !e0Var2.f2544h) {
                list.remove(i11);
            } else if (!z6) {
                z5 = true;
            }
        }
        if (z5) {
            recyclerView.invalidate();
        }
    }

    public abstract boolean onMove(RecyclerView recyclerView, z1 z1Var, z1 z1Var2);

    /* JADX WARN: Multi-variable type inference failed */
    public void onMoved(RecyclerView recyclerView, z1 z1Var, int i3, z1 z1Var2, int i10, int i11, int i12) {
        i1 layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof i0)) {
            if (layoutManager.d()) {
                if (i1.A(z1Var2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.g0(i10);
                }
                if (i1.C(z1Var2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.g0(i10);
                }
            }
            if (layoutManager.e()) {
                if (i1.D(z1Var2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.g0(i10);
                }
                if (i1.y(z1Var2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.g0(i10);
                    return;
                }
                return;
            }
            return;
        }
        View view = z1Var.itemView;
        View view2 = z1Var2.itemView;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ((i0) layoutManager);
        linearLayoutManager.c("Cannot drop a view during a scroll or layout calculation");
        linearLayoutManager.L0();
        linearLayoutManager.d1();
        int K = i1.K(view);
        int K2 = i1.K(view2);
        char c9 = K < K2 ? (char) 1 : (char) 65535;
        if (linearLayoutManager.f2431u) {
            if (c9 == 1) {
                linearLayoutManager.f1(K2, linearLayoutManager.r.j() - (linearLayoutManager.r.f(view) + linearLayoutManager.r.h(view2)));
                return;
            } else {
                linearLayoutManager.f1(K2, linearLayoutManager.r.j() - linearLayoutManager.r.e(view2));
                return;
            }
        }
        if (c9 == 65535) {
            linearLayoutManager.f1(K2, linearLayoutManager.r.h(view2));
        } else {
            linearLayoutManager.f1(K2, linearLayoutManager.r.e(view2) - linearLayoutManager.r.f(view));
        }
    }

    public void onSelectedChanged(z1 z1Var, int i3) {
    }

    public abstract void onSwiped(z1 z1Var, int i3);
}
