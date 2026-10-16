package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements h.j, h.z {

    /* renamed from: p, reason: collision with root package name */
    public h.k f657p;

    /* renamed from: q, reason: collision with root package name */
    public Context f658q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f659s;

    /* renamed from: t, reason: collision with root package name */
    public l f660t;

    /* renamed from: u, reason: collision with root package name */
    public a2.d f661u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f662v;

    /* renamed from: w, reason: collision with root package name */
    public int f663w;

    /* renamed from: x, reason: collision with root package name */
    public final int f664x;

    /* renamed from: y, reason: collision with root package name */
    public final int f665y;

    /* renamed from: z, reason: collision with root package name */
    public p f666z;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public static o l() {
        o oVar = new o(-2, -2);
        oVar.f1008a = false;
        ((LinearLayout.LayoutParams) oVar).gravity = 16;
        return oVar;
    }

    public static o m(ViewGroup.LayoutParams layoutParams) {
        o oVar;
        if (layoutParams == null) {
            return l();
        }
        if (layoutParams instanceof o) {
            o oVar2 = (o) layoutParams;
            oVar = new o(oVar2);
            oVar.f1008a = oVar2.f1008a;
        } else {
            oVar = new o(layoutParams);
        }
        if (((LinearLayout.LayoutParams) oVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) oVar).gravity = 16;
        }
        return oVar;
    }

    @Override // h.z
    public final void a(h.k kVar) {
        this.f657p = kVar;
    }

    @Override // h.j
    public final boolean b(h.m mVar) {
        return this.f657p.q(mVar, null, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof o;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public Menu getMenu() {
        if (this.f657p == null) {
            Context context = getContext();
            h.k kVar = new h.k(context);
            this.f657p = kVar;
            kVar.e = new a2.d(this, 1);
            l lVar = new l(context);
            this.f660t = lVar;
            lVar.f964m = true;
            lVar.f965n = true;
            lVar.e = new n();
            this.f657p.b(lVar, this.f658q);
            l lVar2 = this.f660t;
            lVar2.f959h = this;
            this.f657p = lVar2.f955c;
        }
        return this.f657p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        l lVar = this.f660t;
        j jVar = lVar.f961j;
        if (jVar != null) {
            return jVar.getDrawable();
        }
        if (lVar.f963l) {
            return lVar.f962k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ y1 generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: i */
    public final y1 generateLayoutParams(AttributeSet attributeSet) {
        return new o(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ y1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public final boolean n(int i3) {
        boolean z5 = false;
        if (i3 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i3 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i3);
        if (i3 < getChildCount() && (childAt instanceof m)) {
            z5 = ((m) childAt).a();
        }
        return (i3 <= 0 || !(childAt2 instanceof m)) ? z5 : ((m) childAt2).b() | z5;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        l lVar = this.f660t;
        if (lVar != null) {
            lVar.g(false);
            if (this.f660t.f()) {
                this.f660t.d();
                this.f660t.n();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.f660t;
        if (lVar != null) {
            lVar.d();
            f fVar = lVar.f971u;
            if (fVar == null || !fVar.b()) {
                return;
            }
            fVar.f14212i.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int width;
        int i13;
        if (!this.f662v) {
            super.onLayout(z5, i3, i10, i11, i12);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i12 - i10) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i11 - i3;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean a3 = b4.a(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                o oVar = (o) childAt.getLayoutParams();
                if (oVar.f1008a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (n(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a3) {
                        i13 = getPaddingLeft() + ((LinearLayout.LayoutParams) oVar).leftMargin;
                        width = i13 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) oVar).rightMargin;
                        i13 = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(i13, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) oVar).leftMargin) + ((LinearLayout.LayoutParams) oVar).rightMargin;
                    n(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int max = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (a3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                o oVar2 = (o) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !oVar2.f1008a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) oVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) oVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            o oVar3 = (o) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !oVar3.f1008a) {
                int i27 = paddingLeft + ((LinearLayout.LayoutParams) oVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) oVar3).rightMargin + max + i27;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v40 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        int i12;
        ?? r11;
        int i13;
        int i14;
        h.k kVar;
        boolean z5 = this.f662v;
        boolean z6 = View.MeasureSpec.getMode(i3) == 1073741824;
        this.f662v = z6;
        if (z5 != z6) {
            this.f663w = 0;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (this.f662v && (kVar = this.f657p) != null && size != this.f663w) {
            this.f663w = size;
            kVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.f662v || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                o oVar = (o) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) oVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) oVar).leftMargin = 0;
            }
            super.onMeasure(i3, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i3);
        int size3 = View.MeasureSpec.getSize(i10);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.f664x;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z8 = false;
        int i25 = 0;
        long j4 = 0;
        while (true) {
            i11 = this.f665y;
            if (i24 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i24);
            int i26 = size3;
            int i27 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i13 = i20;
            } else {
                boolean z10 = childAt instanceof ActionMenuItemView;
                i22++;
                if (z10) {
                    childAt.setPadding(i11, 0, i11, 0);
                }
                o oVar2 = (o) childAt.getLayoutParams();
                oVar2.f1012f = false;
                oVar2.f1010c = 0;
                oVar2.f1009b = 0;
                oVar2.f1011d = false;
                ((LinearLayout.LayoutParams) oVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) oVar2).rightMargin = 0;
                oVar2.e = z10 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i28 = oVar2.f1008a ? 1 : i18;
                o oVar3 = (o) childAt.getLayoutParams();
                int i29 = i18;
                i13 = i20;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i27, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z10 ? (ActionMenuItemView) childAt : null;
                boolean z11 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z12 = z11;
                if (i28 <= 0 || (z11 && i28 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i13 * i28, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i13;
                    if (measuredWidth % i13 != 0) {
                        i14++;
                    }
                    if (z12 && i14 < 2) {
                        i14 = 2;
                    }
                }
                oVar3.f1011d = !oVar3.f1008a && z12;
                oVar3.f1009b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i13, 1073741824), makeMeasureSpec);
                i23 = Math.max(i23, i14);
                if (oVar2.f1011d) {
                    i25++;
                }
                if (oVar2.f1008a) {
                    z8 = true;
                }
                i18 = i29 - i14;
                i21 = Math.max(i21, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j4 |= 1 << i24;
                }
            }
            i24++;
            size3 = i26;
            paddingBottom = i27;
            i20 = i13;
        }
        int i30 = size3;
        int i31 = i18;
        int i32 = i20;
        boolean z13 = z8 && i22 == 2;
        int i33 = i31;
        boolean z14 = false;
        while (i25 > 0 && i33 > 0) {
            int i34 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            long j10 = 0;
            int i35 = 0;
            int i36 = 0;
            while (i36 < childCount2) {
                boolean z15 = z13;
                o oVar4 = (o) getChildAt(i36).getLayoutParams();
                int i37 = i21;
                if (oVar4.f1011d) {
                    int i38 = oVar4.f1009b;
                    if (i38 < i34) {
                        j10 = 1 << i36;
                        i34 = i38;
                        i35 = 1;
                    } else if (i38 == i34) {
                        j10 |= 1 << i36;
                        i35++;
                    }
                }
                i36++;
                i21 = i37;
                z13 = z15;
            }
            boolean z16 = z13;
            i12 = i21;
            j4 |= j10;
            if (i35 > i33) {
                break;
            }
            int i39 = i34 + 1;
            int i40 = 0;
            while (i40 < childCount2) {
                View childAt2 = getChildAt(i40);
                o oVar5 = (o) childAt2.getLayoutParams();
                boolean z17 = z8;
                long j11 = 1 << i40;
                if ((j10 & j11) != 0) {
                    if (z16 && oVar5.e) {
                        r11 = 1;
                        r11 = 1;
                        if (i33 == 1) {
                            childAt2.setPadding(i11 + i32, 0, i11, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    oVar5.f1009b += r11;
                    oVar5.f1012f = r11;
                    i33--;
                } else if (oVar5.f1009b == i39) {
                    j4 |= j11;
                }
                i40++;
                z8 = z17;
            }
            i21 = i12;
            z13 = z16;
            z14 = true;
        }
        i12 = i21;
        boolean z18 = !z8 && i22 == 1;
        if (i33 > 0 && j4 != 0 && (i33 < i22 - 1 || z18 || i23 > 1)) {
            float bitCount = Long.bitCount(j4);
            if (!z18) {
                if ((j4 & 1) != 0 && !((o) getChildAt(0).getLayoutParams()).e) {
                    bitCount -= 0.5f;
                }
                int i41 = childCount2 - 1;
                if ((j4 & (1 << i41)) != 0 && !((o) getChildAt(i41).getLayoutParams()).e) {
                    bitCount -= 0.5f;
                }
            }
            int i42 = bitCount > 0.0f ? (int) ((i33 * i32) / bitCount) : 0;
            boolean z19 = z14;
            for (int i43 = 0; i43 < childCount2; i43++) {
                if ((j4 & (1 << i43)) != 0) {
                    View childAt3 = getChildAt(i43);
                    o oVar6 = (o) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        oVar6.f1010c = i42;
                        oVar6.f1012f = true;
                        if (i43 == 0 && !oVar6.e) {
                            ((LinearLayout.LayoutParams) oVar6).leftMargin = (-i42) / 2;
                        }
                        z19 = true;
                    } else if (oVar6.f1008a) {
                        oVar6.f1010c = i42;
                        oVar6.f1012f = true;
                        ((LinearLayout.LayoutParams) oVar6).rightMargin = (-i42) / 2;
                        z19 = true;
                    } else {
                        if (i43 != 0) {
                            ((LinearLayout.LayoutParams) oVar6).leftMargin = i42 / 2;
                        }
                        if (i43 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) oVar6).rightMargin = i42 / 2;
                        }
                    }
                }
            }
            z14 = z19;
        }
        if (z14) {
            for (int i44 = 0; i44 < childCount2; i44++) {
                View childAt4 = getChildAt(i44);
                o oVar7 = (o) childAt4.getLayoutParams();
                if (oVar7.f1012f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((oVar7.f1009b * i32) + oVar7.f1010c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i16, mode != 1073741824 ? i12 : i30);
    }

    public void setExpandedActionViewsExclusive(boolean z5) {
        this.f660t.r = z5;
    }

    public void setOnMenuItemClickListener(p pVar) {
        this.f666z = pVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        l lVar = this.f660t;
        j jVar = lVar.f961j;
        if (jVar != null) {
            jVar.setImageDrawable(drawable);
        } else {
            lVar.f963l = true;
            lVar.f962k = drawable;
        }
    }

    public void setOverflowReserved(boolean z5) {
        this.f659s = z5;
    }

    public void setPopupTheme(int i3) {
        if (this.r != i3) {
            this.r = i3;
            if (i3 == 0) {
                this.f658q = getContext();
            } else {
                this.f658q = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setPresenter(l lVar) {
        this.f660t = lVar;
        lVar.f959h = this;
        this.f657p = lVar.f955c;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f664x = (int) (56.0f * f2);
        this.f665y = (int) (f2 * 4.0f);
        this.f658q = context;
        this.r = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new o(getContext(), attributeSet);
    }
}
