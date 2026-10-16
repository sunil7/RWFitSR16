package ig;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;
import com.example.baselibrary.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import l1.b0;
import l1.r;
import l1.v;

/* loaded from: classes2.dex */
public final class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public static final float f14432a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b, reason: collision with root package name */
    public static final float f14433b;

    /* renamed from: c, reason: collision with root package name */
    public static final float f14434c;

    static {
        float g10 = 1.0f / g(1.0f);
        f14433b = g10;
        f14434c = 1.0f - (g(1.0f) * g10);
    }

    public static boolean a(View view, PointF pointF, boolean z5) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !d(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (e(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R$id.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a3 = a(childAt, pointF, z5);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a3;
                }
            }
        }
        return z5 || view.canScrollVertically(-1);
    }

    public static boolean b(View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (e(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(R$id.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean b3 = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return b3;
            }
        }
        return true;
    }

    public static boolean c(View view) {
        if (view instanceof eg.a) {
            return false;
        }
        return d(view) || (view instanceof ViewPager) || (view instanceof v);
    }

    public static boolean d(View view) {
        if (view instanceof eg.a) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof b0) || (view instanceof WebView) || (view instanceof r);
    }

    public static boolean e(View view, View view2, float f2, float f10, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f2, f10};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f2;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f11 = fArr[0];
        boolean z5 = f11 >= 0.0f && scrollY >= 0.0f && f11 < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z5) {
            pointF.set(fArr[0] - f2, fArr[1] - f10);
        }
        return z5;
    }

    public static int f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i3 = layoutParams.height;
        view.measure(childMeasureSpec, i3 > 0 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static float g(float f2) {
        float f10 = f2 * 8.0f;
        return f10 < 1.0f ? f10 - (1.0f - ((float) Math.exp(-f10))) : l0.a(1.0f, (float) Math.exp(1.0f - f10), 0.63212055f, 0.36787945f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        float g10 = g(f2) * f14433b;
        return g10 > 0.0f ? g10 + f14434c : g10;
    }
}
