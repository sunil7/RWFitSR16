package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public h f784a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f785b;

    /* renamed from: c, reason: collision with root package name */
    public AppCompatSpinner f786c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f787d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f788f;

    /* renamed from: g, reason: collision with root package name */
    public int f789g;

    /* renamed from: h, reason: collision with root package name */
    public int f790h;

    static {
        new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        new r2(this, 0);
        setHorizontalScrollBarEnabled(false);
        a8.c d5 = a8.c.d(context);
        setContentHeight(d5.f());
        this.f788f = d5.f123a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new y1(-2, -1));
        this.f785b = linearLayoutCompat;
        addView(linearLayoutCompat, new ViewGroup.LayoutParams(-2, -1));
    }

    public final void a() {
        AppCompatSpinner appCompatSpinner = this.f786c;
        if (appCompatSpinner != null && appCompatSpinner.getParent() == this) {
            removeView(this.f786c);
            addView(this.f785b, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f786c.getSelectedItemPosition());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h hVar = this.f784a;
        if (hVar != null) {
            post(hVar);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a8.c d5 = a8.c.d(getContext());
        setContentHeight(d5.f());
        this.f788f = d5.f123a.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f784a;
        if (hVar != null) {
            removeCallbacks(hVar);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i3, long j4) {
        ((q2) view).getClass();
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int mode = View.MeasureSpec.getMode(i3);
        boolean z5 = mode == 1073741824;
        setFillViewport(z5);
        LinearLayoutCompat linearLayoutCompat = this.f785b;
        int childCount = linearLayoutCompat.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.e = -1;
        } else {
            if (childCount > 2) {
                this.e = (int) (View.MeasureSpec.getSize(i3) * 0.4f);
            } else {
                this.e = View.MeasureSpec.getSize(i3) / 2;
            }
            this.e = Math.min(this.e, this.f788f);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f789g, 1073741824);
        if (z5 || !this.f787d) {
            a();
        } else {
            linearLayoutCompat.measure(0, makeMeasureSpec);
            if (linearLayoutCompat.getMeasuredWidth() > View.MeasureSpec.getSize(i3)) {
                AppCompatSpinner appCompatSpinner = this.f786c;
                if (appCompatSpinner == null || appCompatSpinner.getParent() != this) {
                    if (this.f786c == null) {
                        AppCompatSpinner appCompatSpinner2 = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
                        appCompatSpinner2.setLayoutParams(new y1(-2, -1));
                        appCompatSpinner2.setOnItemSelectedListener(this);
                        this.f786c = appCompatSpinner2;
                    }
                    removeView(linearLayoutCompat);
                    addView(this.f786c, new ViewGroup.LayoutParams(-2, -1));
                    if (this.f786c.getAdapter() == null) {
                        this.f786c.setAdapter((SpinnerAdapter) new p2(this));
                    }
                    Runnable runnable = this.f784a;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                        this.f784a = null;
                    }
                    this.f786c.setSelection(this.f790h);
                }
            } else {
                a();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i3, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z5 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f790h);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }

    public void setAllowCollapse(boolean z5) {
        this.f787d = z5;
    }

    public void setContentHeight(int i3) {
        this.f789g = i3;
        requestLayout();
    }

    public void setTabSelected(int i3) {
        this.f790h = i3;
        LinearLayoutCompat linearLayoutCompat = this.f785b;
        int childCount = linearLayoutCompat.getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = linearLayoutCompat.getChildAt(i10);
            boolean z5 = i10 == i3;
            childAt.setSelected(z5);
            if (z5) {
                View childAt2 = linearLayoutCompat.getChildAt(i3);
                Runnable runnable = this.f784a;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                h hVar = new h(1, this, childAt2);
                this.f784a = hVar;
                post(hVar);
            }
            i10++;
        }
        AppCompatSpinner appCompatSpinner = this.f786c;
        if (appCompatSpinner == null || i3 < 0) {
            return;
        }
        appCompatSpinner.setSelection(i3);
    }
}
