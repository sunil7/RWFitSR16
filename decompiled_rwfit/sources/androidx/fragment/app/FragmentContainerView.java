package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R$id;
import androidx.fragment.R$styleable;
import java.util.ArrayList;
import l1.x1;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f2095a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2096b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f2097c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2098d;

    public FragmentContainerView(Context context) {
        super(context);
        this.f2098d = true;
    }

    public final void a(View view) {
        ArrayList arrayList = this.f2096b;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f2095a == null) {
            this.f2095a = new ArrayList();
        }
        this.f2095a.add(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z5) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            return super.addViewInLayout(view, i3, layoutParams, z5);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        x1 h4 = x1.h(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2097c;
        x1 h10 = onApplyWindowInsetsListener != null ? x1.h(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets), null) : l1.z0.h(this, h4);
        if (!h10.f15738a.m()) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                l1.z0.b(getChildAt(i3), h10);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.f2098d && this.f2095a != null) {
            for (int i3 = 0; i3 < this.f2095a.size(); i3++) {
                super.drawChild(canvas, (View) this.f2095a.get(i3), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        ArrayList arrayList;
        if (!this.f2098d || (arrayList = this.f2095a) == null || arrayList.size() <= 0 || !this.f2095a.contains(view)) {
            return super.drawChild(canvas, view, j4);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList arrayList = this.f2096b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f2095a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f2098d = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z5) {
        if (z5) {
            a(view);
        }
        super.removeDetachedView(view, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i3) {
        a(getChildAt(i3));
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i3, int i10) {
        for (int i11 = i3; i11 < i3 + i10; i11++) {
            a(getChildAt(i11));
        }
        super.removeViews(i3, i10);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i3, int i10) {
        for (int i11 = i3; i11 < i3 + i10; i11++) {
            a(getChildAt(i11));
        }
        super.removeViewsInLayout(i3, i10);
    }

    public void setDrawDisappearingViewsLast(boolean z5) {
        this.f2098d = z5;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f2097c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f2096b == null) {
                this.f2096b = new ArrayList();
            }
            this.f2096b.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        String str;
        this.f2098d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException(com.google.android.gms.internal.mlkit_vision_barcode.l0.q("FragmentContainerView must be within a FragmentActivity to use ", str, "=\"", classAttribute, "\""));
            }
        }
    }
}
