package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f732a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f733b;

    /* renamed from: c, reason: collision with root package name */
    public int f734c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f734c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ButtonBarLayout);
        l1.z0.m(this, context, R$styleable.ButtonBarLayout, attributeSet, obtainStyledAttributes, 0);
        this.f732a = obtainStyledAttributes.getBoolean(R$styleable.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f732a);
        }
    }

    private void setStacked(boolean z5) {
        if (this.f733b != z5) {
            if (!z5 || this.f732a) {
                this.f733b = z5;
                setOrientation(z5 ? 1 : 0);
                setGravity(z5 ? 8388613 : 80);
                View findViewById = findViewById(R$id.spacer);
                if (findViewById != null) {
                    findViewById.setVisibility(z5 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        boolean z5;
        int i12;
        int size = View.MeasureSpec.getSize(i3);
        int i13 = 0;
        if (this.f732a) {
            if (size > this.f734c && this.f733b) {
                setStacked(false);
            }
            this.f734c = size;
        }
        if (this.f733b || View.MeasureSpec.getMode(i3) != 1073741824) {
            i11 = i3;
            z5 = false;
        } else {
            i11 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z5 = true;
        }
        super.onMeasure(i11, i10);
        if (this.f732a && !this.f733b && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z5 = true;
        }
        if (z5) {
            super.onMeasure(i3, i10);
        }
        int childCount = getChildCount();
        int i14 = 0;
        while (true) {
            i12 = -1;
            if (i14 >= childCount) {
                i14 = -1;
                break;
            } else if (getChildAt(i14).getVisibility() == 0) {
                break;
            } else {
                i14++;
            }
        }
        if (i14 >= 0) {
            View childAt = getChildAt(i14);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f733b) {
                int i15 = i14 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i15 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i15).getVisibility() == 0) {
                        i12 = i15;
                        break;
                    }
                    i15++;
                }
                i13 = i12 >= 0 ? getChildAt(i12).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                i13 = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = l1.z0.f15748a;
        if (l1.h0.d(this) != i13) {
            setMinimumHeight(i13);
            if (i10 == 0) {
                super.onMeasure(i3, i10);
            }
        }
    }

    public void setAllowStacking(boolean z5) {
        if (this.f732a != z5) {
            this.f732a = z5;
            if (!z5 && this.f733b) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
