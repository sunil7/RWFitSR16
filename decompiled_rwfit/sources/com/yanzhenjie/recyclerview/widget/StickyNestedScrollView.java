package com.yanzhenjie.recyclerview.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.e;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import pe.o;
import qg.a;

/* loaded from: classes2.dex */
public class StickyNestedScrollView extends NestedScrollView {
    public final ArrayList D;
    public View E;
    public float F;
    public final o G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public Drawable M;
    public boolean N;
    public ArrayList O;

    public StickyNestedScrollView(Context context) {
        this(context, null);
    }

    public final int A(View view) {
        int right = view.getRight();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            right += view.getRight();
        }
        return right;
    }

    public final int B(View view) {
        int top = view.getTop();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            top += view.getTop();
        }
        return top;
    }

    public final void C() {
        if (String.valueOf(this.E.getTag()).contains("-hastransparency")) {
            this.E.setAlpha(1.0f);
        }
        this.E = null;
        removeCallbacks(this.G);
    }

    public void addOnViewStickyListener(a aVar) {
        if (this.O == null) {
            this.O = new ArrayList();
        }
        this.O.add(aVar);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View view) {
        super.addView(view);
        y(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.E != null) {
            canvas.save();
            canvas.translate(getPaddingLeft() + this.H, getScrollY() + this.F + (this.J ? getPaddingTop() : 0));
            canvas.clipRect(0.0f, this.J ? -this.F : 0.0f, getWidth() - this.H, this.E.getHeight() + this.L + 1);
            if (this.M != null) {
                this.M.setBounds(0, this.E.getHeight(), this.E.getWidth(), this.E.getHeight() + this.L);
                this.M.draw(canvas);
            }
            canvas.clipRect(0.0f, this.J ? -this.F : 0.0f, getWidth(), this.E.getHeight());
            if (String.valueOf(this.E.getTag()).contains("-hastransparency")) {
                this.E.setAlpha(1.0f);
                this.E.draw(canvas);
                this.E.setAlpha(0.0f);
            } else {
                this.E.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.I = true;
        }
        if (this.I) {
            boolean z5 = this.E != null;
            this.I = z5;
            if (z5) {
                this.I = motionEvent.getY() <= ((float) this.E.getHeight()) + this.F && motionEvent.getX() >= ((float) z(this.E)) && motionEvent.getX() <= ((float) A(this.E));
            }
        } else if (this.E == null) {
            this.I = false;
        }
        if (this.I) {
            motionEvent.offsetLocation(0.0f, ((getScrollY() + this.F) - B(this.E)) * (-1.0f));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.G);
        super.onDetachedFromWindow();
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        if (!this.K) {
            this.J = true;
        }
        if (this.E != null) {
            C();
        }
        this.D.clear();
        y(getChildAt(0));
        x();
        invalidate();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onScrollChanged(int i3, int i10, int i11, int i12) {
        super.onScrollChanged(i3, i10, i11, i12);
        x();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.I) {
            motionEvent.offsetLocation(0.0f, (getScrollY() + this.F) - B(this.E));
        }
        if (motionEvent.getAction() == 0) {
            this.N = false;
        }
        if (this.N) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            super.onTouchEvent(obtain);
            this.N = false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.N = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnViewStickyListener(a aVar) {
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            arrayList.remove(aVar);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z5) {
        super.setClipToPadding(z5);
        this.J = z5;
        this.K = true;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.M = drawable;
    }

    public void setShadowHeight(int i3) {
        this.L = i3;
    }

    public final void x() {
        float min;
        ArrayList arrayList = this.D;
        int size = arrayList.size();
        View view = null;
        View view2 = null;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            View view3 = (View) obj;
            int B = (B(view3) - getScrollY()) + (this.J ? 0 : getPaddingTop());
            if (B <= 0) {
                if (view != null) {
                    if (B > (B(view) - getScrollY()) + (this.J ? 0 : getPaddingTop())) {
                    }
                }
                view = view3;
            } else {
                if (view2 != null) {
                    if (B < (B(view2) - getScrollY()) + (this.J ? 0 : getPaddingTop())) {
                    }
                }
                view2 = view3;
            }
        }
        if (view == null) {
            if (this.E != null) {
                ArrayList arrayList2 = this.O;
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    if (it.hasNext()) {
                        throw e.d(it);
                    }
                }
                C();
                return;
            }
            return;
        }
        if (view2 == null) {
            min = 0.0f;
        } else {
            min = Math.min(0, ((B(view2) - getScrollY()) + (this.J ? 0 : getPaddingTop())) - view.getHeight());
        }
        this.F = min;
        View view4 = this.E;
        if (view != view4) {
            if (view4 != null) {
                ArrayList arrayList3 = this.O;
                if (arrayList3 != null) {
                    Iterator it2 = arrayList3.iterator();
                    if (it2.hasNext()) {
                        throw e.d(it2);
                    }
                }
                C();
            }
            this.H = z(view);
            this.E = view;
            if (String.valueOf(view.getTag()).contains("-hastransparency")) {
                this.E.setAlpha(0.0f);
            }
            if (String.valueOf(this.E.getTag()).contains("-nonconstant")) {
                post(this.G);
            }
            ArrayList arrayList4 = this.O;
            if (arrayList4 != null) {
                Iterator it3 = arrayList4.iterator();
                if (it3.hasNext()) {
                    throw e.d(it3);
                }
            }
        }
    }

    public final void y(View view) {
        if (String.valueOf(view.getTag()).contains("sticky")) {
            this.D.add(view);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                y(viewGroup.getChildAt(i3));
            }
        }
    }

    public final int z(View view) {
        int left = view.getLeft();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            left += view.getLeft();
        }
        return left;
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.scrollViewStyle);
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = new o(this, 3);
        this.L = 10;
        this.N = true;
        this.D = new ArrayList();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View view, int i3) {
        super.addView(view, i3);
        y(view);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        y(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, int i10) {
        super.addView(view, i3, i10);
        y(view);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        y(view);
    }
}
