package ka;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.xb;
import com.google.android.material.appbar.AppBarLayout;
import java.util.WeakHashMap;
import l1.h0;
import l1.n;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public abstract class f extends g {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f15582c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f15583d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f15584f;

    public f() {
        this.f15582c = new Rect();
        this.f15583d = new Rect();
        this.e = 0;
    }

    @Override // x0.c
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i3, int i10, int i11) {
        AppBarLayout v6;
        x1 lastWindowInsets;
        int i12 = view.getLayoutParams().height;
        if ((i12 != -1 && i12 != -2) || (v6 = AppBarLayout.ScrollingViewBehavior.v(coordinatorLayout.o(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i11);
        if (size > 0) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (h0.b(v6) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.a() + lastWindowInsets.d();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.w(i3, i10, View.MeasureSpec.makeMeasureSpec((v6.getTotalScrollRange() + size) - v6.getMeasuredHeight(), i12 == -1 ? 1073741824 : Integer.MIN_VALUE), view);
        return true;
    }

    @Override // ka.g
    public final void t(CoordinatorLayout coordinatorLayout, View view, int i3) {
        AppBarLayout v6 = AppBarLayout.ScrollingViewBehavior.v(coordinatorLayout.o(view));
        if (v6 == null) {
            coordinatorLayout.v(i3, view);
            this.e = 0;
            return;
        }
        x0.f fVar = (x0.f) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
        int bottom = v6.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
        int bottom2 = ((v6.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
        Rect rect = this.f15582c;
        rect.set(paddingLeft, bottom, width, bottom2);
        x1 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (h0.b(coordinatorLayout) && !h0.b(view)) {
                rect.left = lastWindowInsets.b() + rect.left;
                rect.right -= lastWindowInsets.c();
            }
        }
        int i10 = fVar.f19718c;
        if (i10 == 0) {
            i10 = 8388659;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect2 = this.f15583d;
        n.b(i10, measuredWidth, measuredHeight, rect, rect2, i3);
        int u10 = u(v6);
        view.layout(rect2.left, rect2.top - u10, rect2.right, rect2.bottom - u10);
        this.e = rect2.top - v6.getBottom();
    }

    public final int u(View view) {
        int i3;
        if (this.f15584f == 0) {
            return 0;
        }
        float f2 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            x0.c cVar = ((x0.f) appBarLayout.getLayoutParams()).f19716a;
            int u10 = cVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) cVar).u() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + u10 > downNestedPreScrollRange) && (i3 = totalScrollRange - downNestedPreScrollRange) != 0) {
                f2 = (u10 / i3) + 1.0f;
            }
        }
        int i10 = this.f15584f;
        return xb.a((int) (f2 * i10), 0, i10);
    }

    public f(int i3) {
        super(0);
        this.f15582c = new Rect();
        this.f15583d = new Rect();
        this.e = 0;
    }
}
