package hb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public final class g extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public ValueAnimator f14299a;

    /* renamed from: b, reason: collision with root package name */
    public int f14300b;

    /* renamed from: c, reason: collision with root package name */
    public float f14301c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TabLayout f14302d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TabLayout tabLayout, Context context) {
        super(context);
        this.f14302d = tabLayout;
        this.f14300b = -1;
        setWillNotDraw(false);
    }

    public final void a() {
        View childAt = getChildAt(this.f14300b);
        TabLayout tabLayout = this.f14302d;
        com.google.android.material.tabs.a aVar = tabLayout.E;
        Drawable drawable = tabLayout.f10791l;
        aVar.getClass();
        RectF a3 = com.google.android.material.tabs.a.a(tabLayout, childAt);
        drawable.setBounds((int) a3.left, drawable.getBounds().top, (int) a3.right, drawable.getBounds().bottom);
    }

    public final void b(View view, View view2, float f2) {
        TabLayout tabLayout = this.f14302d;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.f10791l;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.f10791l.getBounds().bottom);
        } else {
            tabLayout.E.b(tabLayout, view, view2, f2, tabLayout.f10791l);
        }
        WeakHashMap weakHashMap = z0.f15748a;
        h0.k(this);
    }

    public final void c(int i3, int i10, boolean z5) {
        View childAt = getChildAt(this.f14300b);
        View childAt2 = getChildAt(i3);
        if (childAt2 == null) {
            a();
            return;
        }
        e eVar = new e(this, childAt, childAt2);
        if (!z5) {
            this.f14299a.removeAllUpdateListeners();
            this.f14299a.addUpdateListener(eVar);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f14299a = valueAnimator;
        valueAnimator.setInterpolator(ja.a.f15384b);
        valueAnimator.setDuration(i10);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(eVar);
        valueAnimator.addListener(new f(this, i3));
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.f14302d;
        int height2 = tabLayout.f10791l.getBounds().height();
        if (height2 < 0) {
            height2 = tabLayout.f10791l.getIntrinsicHeight();
        }
        int i3 = tabLayout.f10803y;
        if (i3 == 0) {
            height = getHeight() - height2;
            height2 = getHeight();
        } else if (i3 != 1) {
            height = 0;
            if (i3 != 2) {
                height2 = i3 != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - height2) / 2;
            height2 = (getHeight() + height2) / 2;
        }
        if (tabLayout.f10791l.getBounds().width() > 0) {
            Rect bounds = tabLayout.f10791l.getBounds();
            tabLayout.f10791l.setBounds(bounds.left, height, bounds.right, height2);
            Drawable drawable = tabLayout.f10791l;
            int i10 = tabLayout.f10792m;
            if (i10 != 0) {
                d1.b.g(drawable, i10);
            }
            drawable.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        ValueAnimator valueAnimator = this.f14299a;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            a();
        } else {
            c(this.f14300b, -1, false);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f14302d;
        boolean z5 = true;
        if (tabLayout.f10801w == 1 || tabLayout.f10804z == 2) {
            int childCount = getChildCount();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0) {
                    i11 = Math.max(i11, childAt.getMeasuredWidth());
                }
            }
            if (i11 <= 0) {
                return;
            }
            if (i11 * childCount <= getMeasuredWidth() - (((int) gb.b(getContext(), 16)) * 2)) {
                boolean z6 = false;
                for (int i13 = 0; i13 < childCount; i13++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                    if (layoutParams.width != i11 || layoutParams.weight != 0.0f) {
                        layoutParams.width = i11;
                        layoutParams.weight = 0.0f;
                        z6 = true;
                    }
                }
                z5 = z6;
            } else {
                tabLayout.f10801w = 0;
                tabLayout.n(false);
            }
            if (z5) {
                super.onMeasure(i3, i10);
            }
        }
    }
}
