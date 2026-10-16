package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final a f615a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f616b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f617c;

    /* renamed from: d, reason: collision with root package name */
    public l f618d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public l1.g1 f619f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f620g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f621h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f622i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f623j;

    /* renamed from: k, reason: collision with root package name */
    public View f624k;

    /* renamed from: l, reason: collision with root package name */
    public View f625l;

    /* renamed from: m, reason: collision with root package name */
    public View f626m;

    /* renamed from: n, reason: collision with root package name */
    public LinearLayout f627n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f628o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f629p;

    /* renamed from: q, reason: collision with root package name */
    public final int f630q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f631s;

    /* renamed from: t, reason: collision with root package name */
    public final int f632t;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public static int f(View view, int i3, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), i10);
        return Math.max(0, i3 - view.getMeasuredWidth());
    }

    public static int g(int i3, int i10, int i11, View view, boolean z5) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = ((i11 - measuredHeight) / 2) + i10;
        if (z5) {
            view.layout(i3 - measuredWidth, i12, i3, measuredHeight + i12);
        } else {
            view.layout(i3, i12, i3 + measuredWidth, measuredHeight + i12);
        }
        return z5 ? -measuredWidth : measuredWidth;
    }

    public final void c(g.a aVar) {
        int i3 = 1;
        View view = this.f624k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f632t, (ViewGroup) this, false);
            this.f624k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f624k);
        }
        View findViewById = this.f624k.findViewById(R$id.action_mode_close_button);
        this.f625l = findViewById;
        findViewById.setOnClickListener(new androidx.appcompat.app.c(aVar, i3));
        h.k c9 = aVar.c();
        l lVar = this.f618d;
        if (lVar != null) {
            lVar.d();
            f fVar = lVar.f971u;
            if (fVar != null && fVar.b()) {
                fVar.f14212i.dismiss();
            }
        }
        l lVar2 = new l(getContext());
        this.f618d = lVar2;
        lVar2.f964m = true;
        lVar2.f965n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c9.b(this.f618d, this.f616b);
        l lVar3 = this.f618d;
        h.z zVar = lVar3.f959h;
        if (zVar == null) {
            h.z zVar2 = (h.z) lVar3.f956d.inflate(lVar3.f957f, (ViewGroup) this, false);
            lVar3.f959h = zVar2;
            zVar2.a(lVar3.f955c);
            lVar3.g(true);
        }
        h.z zVar3 = lVar3.f959h;
        if (zVar != zVar3) {
            ((ActionMenuView) zVar3).setPresenter(lVar3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) zVar3;
        this.f617c = actionMenuView;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.h0.q(actionMenuView, null);
        addView(this.f617c, layoutParams);
    }

    public final void d() {
        if (this.f627n == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f627n = linearLayout;
            this.f628o = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f629p = (TextView) this.f627n.findViewById(R$id.action_bar_subtitle);
            int i3 = this.f630q;
            if (i3 != 0) {
                this.f628o.setTextAppearance(getContext(), i3);
            }
            int i10 = this.r;
            if (i10 != 0) {
                this.f629p.setTextAppearance(getContext(), i10);
            }
        }
        this.f628o.setText(this.f622i);
        this.f629p.setText(this.f623j);
        boolean isEmpty = TextUtils.isEmpty(this.f622i);
        boolean isEmpty2 = TextUtils.isEmpty(this.f623j);
        this.f629p.setVisibility(!isEmpty2 ? 0 : 8);
        this.f627n.setVisibility((isEmpty && isEmpty2) ? 8 : 0);
        if (this.f627n.getParent() == null) {
            addView(this.f627n);
        }
    }

    public final void e() {
        removeAllViews();
        this.f626m = null;
        this.f617c = null;
        this.f618d = null;
        View view = this.f625l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f619f != null ? this.f615a.f866a : getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    public CharSequence getSubtitle() {
        return this.f623j;
    }

    public CharSequence getTitle() {
        return this.f622i;
    }

    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i3) {
        if (i3 != getVisibility()) {
            l1.g1 g1Var = this.f619f;
            if (g1Var != null) {
                g1Var.b();
            }
            super.setVisibility(i3);
        }
    }

    public final l1.g1 i(int i3, long j4) {
        l1.g1 g1Var = this.f619f;
        if (g1Var != null) {
            g1Var.b();
        }
        a aVar = this.f615a;
        if (i3 != 0) {
            l1.g1 a3 = l1.z0.a(this);
            a3.a(0.0f);
            a3.c(j4);
            ((ActionBarContextView) aVar.f868c).f619f = a3;
            aVar.f866a = i3;
            a3.d(aVar);
            return a3;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        l1.g1 a10 = l1.z0.a(this);
        a10.a(1.0f);
        a10.c(j4);
        ((ActionBarContextView) aVar.f868c).f619f = a10;
        aVar.f866a = i3;
        a10.d(aVar);
        return a10;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        l lVar = this.f618d;
        if (lVar != null) {
            lVar.f968q = a8.c.d(lVar.f954b).e();
            h.k kVar = lVar.f955c;
            if (kVar != null) {
                kVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.f618d;
        if (lVar != null) {
            lVar.d();
            f fVar = this.f618d.f971u;
            if (fVar == null || !fVar.b()) {
                return;
            }
            fVar.f14212i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f621h = false;
        }
        if (!this.f621h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f621h = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f621h = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        boolean a3 = b4.a(this);
        int paddingRight = a3 ? (i11 - i3) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
        View view = this.f624k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f624k.getLayoutParams();
            int i13 = a3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i14 = a3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i15 = a3 ? paddingRight - i13 : paddingRight + i13;
            int g10 = g(i15, paddingTop, paddingTop2, this.f624k, a3) + i15;
            paddingRight = a3 ? g10 - i14 : g10 + i14;
        }
        LinearLayout linearLayout = this.f627n;
        if (linearLayout != null && this.f626m == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(paddingRight, paddingTop, paddingTop2, this.f627n, a3);
        }
        View view2 = this.f626m;
        if (view2 != null) {
            g(paddingRight, paddingTop, paddingTop2, view2, a3);
        }
        int paddingLeft = a3 ? getPaddingLeft() : (i11 - i3) - getPaddingRight();
        ActionMenuView actionMenuView = this.f617c;
        if (actionMenuView != null) {
            g(paddingLeft, paddingTop, paddingTop2, actionMenuView, !a3);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i10) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i3);
        int i11 = this.e;
        if (i11 <= 0) {
            i11 = View.MeasureSpec.getSize(i10);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i12 = i11 - paddingBottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        View view = this.f624k;
        if (view != null) {
            int f2 = f(view, paddingLeft, makeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f624k.getLayoutParams();
            paddingLeft = f2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f617c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f617c, paddingLeft, makeMeasureSpec);
        }
        LinearLayout linearLayout = this.f627n;
        if (linearLayout != null && this.f626m == null) {
            if (this.f631s) {
                this.f627n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f627n.getMeasuredWidth();
                boolean z5 = measuredWidth <= paddingLeft;
                if (z5) {
                    paddingLeft -= measuredWidth;
                }
                this.f627n.setVisibility(z5 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
            }
        }
        View view2 = this.f626m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i13 = layoutParams.width;
            int i14 = i13 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i13 >= 0) {
                paddingLeft = Math.min(i13, paddingLeft);
            }
            int i15 = layoutParams.height;
            int i16 = i15 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i15 >= 0) {
                i12 = Math.min(i15, i12);
            }
            this.f626m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i14), View.MeasureSpec.makeMeasureSpec(i12, i16));
        }
        if (this.e > 0) {
            setMeasuredDimension(size, i11);
            return;
        }
        int childCount = getChildCount();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            int measuredHeight = getChildAt(i18).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i17) {
                i17 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i17);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f620g = false;
        }
        if (!this.f620g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f620g = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f620g = false;
        return true;
    }

    public void setContentHeight(int i3) {
        this.e = i3;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f626m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f626m = view;
        if (view != null && (linearLayout = this.f627n) != null) {
            removeView(linearLayout);
            this.f627n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f623j = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f622i = charSequence;
        d();
        l1.z0.o(this, charSequence);
    }

    public void setTitleOptional(boolean z5) {
        if (z5 != this.f631s) {
            requestLayout();
        }
        this.f631s = z5;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Drawable drawable;
        int resourceId;
        a aVar = new a();
        aVar.f868c = this;
        aVar.f867b = false;
        this.f615a = aVar;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f616b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f616b = context;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMode, i3, 0);
        int i10 = R$styleable.ActionMode_background;
        if (obtainStyledAttributes.hasValue(i10) && (resourceId = obtainStyledAttributes.getResourceId(i10, 0)) != 0) {
            drawable = pb.b(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(i10);
        }
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.h0.q(this, drawable);
        this.f630q = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_titleTextStyle, 0);
        this.r = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.e = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionMode_height, 0);
        this.f632t = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
}
