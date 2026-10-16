package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f606a;

    /* renamed from: b, reason: collision with root package name */
    public ScrollingTabContainerView f607b;

    /* renamed from: c, reason: collision with root package name */
    public View f608c;

    /* renamed from: d, reason: collision with root package name */
    public View f609d;
    public Drawable e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f610f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f611g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f612h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f613i;

    /* renamed from: j, reason: collision with root package name */
    public final int f614j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful()) {
            this.e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f610f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f610f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f611g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f611g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f607b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f610f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f611g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f608c = findViewById(R$id.action_bar);
        this.f609d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f606a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        Drawable drawable;
        super.onLayout(z5, i3, i10, i11, i12);
        ScrollingTabContainerView scrollingTabContainerView = this.f607b;
        boolean z6 = true;
        boolean z8 = false;
        boolean z10 = (scrollingTabContainerView == null || scrollingTabContainerView.getVisibility() == 8) ? false : true;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) scrollingTabContainerView.getLayoutParams();
            int measuredHeight2 = measuredHeight - scrollingTabContainerView.getMeasuredHeight();
            int i13 = layoutParams.bottomMargin;
            scrollingTabContainerView.layout(i3, measuredHeight2 - i13, i11, measuredHeight - i13);
        }
        if (this.f612h) {
            Drawable drawable2 = this.f611g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z6 = z8;
        } else {
            if (this.e != null) {
                if (this.f608c.getVisibility() == 0) {
                    this.e.setBounds(this.f608c.getLeft(), this.f608c.getTop(), this.f608c.getRight(), this.f608c.getBottom());
                } else {
                    View view = this.f609d;
                    if (view == null || view.getVisibility() != 0) {
                        this.e.setBounds(0, 0, 0, 0);
                    } else {
                        this.e.setBounds(this.f609d.getLeft(), this.f609d.getTop(), this.f609d.getRight(), this.f609d.getBottom());
                    }
                }
                z8 = true;
            }
            this.f613i = z10;
            if (z10 && (drawable = this.f610f) != null) {
                drawable.setBounds(scrollingTabContainerView.getLeft(), scrollingTabContainerView.getTop(), scrollingTabContainerView.getRight(), scrollingTabContainerView.getBottom());
            }
            z6 = z8;
        }
        if (z6) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int a3;
        int i11;
        if (this.f608c == null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && (i11 = this.f614j) >= 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i11, View.MeasureSpec.getSize(i10)), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i10);
        if (this.f608c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        ScrollingTabContainerView scrollingTabContainerView = this.f607b;
        if (scrollingTabContainerView == null || scrollingTabContainerView.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        View view = this.f608c;
        if (view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0) {
            View view2 = this.f609d;
            a3 = (view2 == null || view2.getVisibility() == 8 || view2.getMeasuredHeight() == 0) ? 0 : a(this.f609d);
        } else {
            a3 = a(this.f608c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.f607b) + a3, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i10) : SubsamplingScaleImageView.TILE_SIZE_AUTO));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.e);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f608c;
            if (view != null) {
                this.e.setBounds(view.getLeft(), this.f608c.getTop(), this.f608c.getRight(), this.f608c.getBottom());
            }
        }
        boolean z5 = false;
        if (!this.f612h ? !(this.e != null || this.f610f != null) : this.f611g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f611g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f611g);
        }
        this.f611g = drawable;
        boolean z5 = this.f612h;
        boolean z6 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z5 && (drawable2 = this.f611g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z5 ? !(this.e != null || this.f610f != null) : this.f611g == null) {
            z6 = true;
        }
        setWillNotDraw(z6);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f610f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f610f);
        }
        this.f610f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f613i && (drawable2 = this.f610f) != null) {
                drawable2.setBounds(this.f607b.getLeft(), this.f607b.getTop(), this.f607b.getRight(), this.f607b.getBottom());
            }
        }
        boolean z5 = false;
        if (!this.f612h ? !(this.e != null || this.f610f != null) : this.f611g == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.f607b;
        if (scrollingTabContainerView2 != null) {
            removeView(scrollingTabContainerView2);
        }
        this.f607b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z5) {
        this.f606a = z5;
        setDescendantFocusability(z5 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z5 = i3 == 0;
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setVisible(z5, false);
        }
        Drawable drawable2 = this.f610f;
        if (drawable2 != null) {
            drawable2.setVisible(z5, false);
        }
        Drawable drawable3 = this.f611g;
        if (drawable3 != null) {
            drawable3.setVisible(z5, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.e;
        boolean z5 = this.f612h;
        if (drawable == drawable2 && !z5) {
            return true;
        }
        if (drawable == this.f610f && this.f613i) {
            return true;
        }
        return (drawable == this.f611g && z5) || super.verifyDrawable(drawable);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.h0.q(this, bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f610f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f614j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z5 = true;
        if (getId() == R$id.split_action_bar) {
            this.f612h = true;
            this.f611g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f612h ? this.e != null || this.f610f != null : this.f611g != null) {
            z5 = false;
        }
        setWillNotDraw(z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i3) {
        if (i3 != 0) {
            return super.startActionModeForChild(view, callback, i3);
        }
        return null;
    }
}
