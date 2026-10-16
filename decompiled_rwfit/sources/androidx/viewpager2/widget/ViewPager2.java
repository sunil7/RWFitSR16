package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.t;
import androidx.recyclerview.widget.f1;
import androidx.recyclerview.widget.i1;
import androidx.viewpager2.R$styleable;
import com.example.test.ui.device.activity.f0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.h0;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f2947a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f2948b;

    /* renamed from: c, reason: collision with root package name */
    public final g f2949c;

    /* renamed from: d, reason: collision with root package name */
    public int f2950d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final f f2951f;

    /* renamed from: g, reason: collision with root package name */
    public i f2952g;

    /* renamed from: h, reason: collision with root package name */
    public int f2953h;

    /* renamed from: i, reason: collision with root package name */
    public Parcelable f2954i;

    /* renamed from: j, reason: collision with root package name */
    public m f2955j;

    /* renamed from: k, reason: collision with root package name */
    public l f2956k;

    /* renamed from: l, reason: collision with root package name */
    public e f2957l;

    /* renamed from: m, reason: collision with root package name */
    public g f2958m;

    /* renamed from: n, reason: collision with root package name */
    public y2.f f2959n;

    /* renamed from: o, reason: collision with root package name */
    public c f2960o;

    /* renamed from: p, reason: collision with root package name */
    public f1 f2961p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2962q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f2963s;

    /* renamed from: t, reason: collision with root package name */
    public v2.h f2964t;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new n();

        /* renamed from: a, reason: collision with root package name */
        public int f2965a;

        /* renamed from: b, reason: collision with root package name */
        public int f2966b;

        /* renamed from: c, reason: collision with root package name */
        public Parcelable f2967c;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f2965a);
            parcel.writeInt(this.f2966b);
            parcel.writeParcelable(this.f2967c, i3);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.f2947a = new Rect();
        this.f2948b = new Rect();
        this.f2949c = new g();
        this.e = false;
        this.f2951f = new f(this, 0);
        this.f2953h = -1;
        this.f2961p = null;
        this.f2962q = false;
        this.r = true;
        this.f2963s = -1;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        int i3 = 0;
        int i10 = 6;
        int i11 = 1;
        v2.h hVar = new v2.h();
        hVar.f19149d = this;
        hVar.f19146a = new t(hVar, 5);
        hVar.f19147b = new a2.d(hVar, i10);
        this.f2964t = hVar;
        m mVar = new m(this, context);
        this.f2955j = mVar;
        WeakHashMap weakHashMap = z0.f15748a;
        mVar.setId(i0.a());
        this.f2955j.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        i iVar = new i(this);
        this.f2952g = iVar;
        this.f2955j.setLayoutManager(iVar);
        this.f2955j.setScrollingTouchSlop(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R$styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R$styleable.ViewPager2_android_orientation, 0));
            obtainStyledAttributes.recycle();
            this.f2955j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f2955j.addOnChildAttachStateChangeListener(new h());
            e eVar = new e(this);
            this.f2957l = eVar;
            this.f2959n = new y2.f(eVar, i10);
            l lVar = new l(this);
            this.f2956k = lVar;
            lVar.a(this.f2955j);
            this.f2955j.addOnScrollListener(this.f2957l);
            g gVar = new g();
            this.f2958m = gVar;
            this.f2957l.f2973a = gVar;
            g gVar2 = new g(this, i3);
            g gVar3 = new g(this, i11);
            ((ArrayList) gVar.f2987b).add(gVar2);
            ((ArrayList) this.f2958m.f2987b).add(gVar3);
            v2.h hVar2 = this.f2964t;
            m mVar2 = this.f2955j;
            hVar2.getClass();
            h0.s(mVar2, 2);
            hVar2.f19148c = new f(hVar2, i11);
            ViewPager2 viewPager2 = (ViewPager2) hVar2.f19149d;
            if (h0.c(viewPager2) == 0) {
                h0.s(viewPager2, 1);
            }
            g gVar4 = this.f2958m;
            ((ArrayList) gVar4.f2987b).add(this.f2949c);
            c cVar = new c();
            this.f2960o = cVar;
            ((ArrayList) this.f2958m.f2987b).add(cVar);
            m mVar3 = this.f2955j;
            attachViewToParent(mVar3, 0, mVar3.getLayoutParams());
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public final void b() {
        androidx.recyclerview.widget.z0 adapter;
        if (this.f2953h == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        if (this.f2954i != null) {
            this.f2954i = null;
        }
        int max = Math.max(0, Math.min(this.f2953h, adapter.getItemCount() - 1));
        this.f2950d = max;
        this.f2953h = -1;
        this.f2955j.g0(max);
        this.f2964t.q();
    }

    public final void c(int i3, boolean z5) {
        g gVar;
        androidx.recyclerview.widget.z0 adapter = getAdapter();
        if (adapter == null) {
            if (this.f2953h != -1) {
                this.f2953h = Math.max(i3, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i3, 0), adapter.getItemCount() - 1);
        int i10 = this.f2950d;
        if (min == i10 && this.f2957l.f2977f == 0) {
            return;
        }
        if (min == i10 && z5) {
            return;
        }
        double d5 = i10;
        this.f2950d = min;
        this.f2964t.q();
        e eVar = this.f2957l;
        if (eVar.f2977f != 0) {
            eVar.e();
            d dVar = eVar.f2978g;
            d5 = dVar.f2970a + dVar.f2971b;
        }
        e eVar2 = this.f2957l;
        eVar2.getClass();
        eVar2.e = z5 ? 2 : 3;
        boolean z6 = eVar2.f2980i != min;
        eVar2.f2980i = min;
        eVar2.c(2);
        if (z6 && (gVar = eVar2.f2973a) != null) {
            gVar.c(min);
        }
        if (!z5) {
            this.f2955j.g0(min);
            return;
        }
        double d8 = min;
        if (Math.abs(d8 - d5) <= 3.0d) {
            this.f2955j.i0(min);
            return;
        }
        this.f2955j.g0(d8 > d5 ? min - 3 : min + 3);
        m mVar = this.f2955j;
        mVar.post(new androidx.emoji2.text.i(min, mVar));
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i3) {
        return this.f2955j.canScrollHorizontally(i3);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i3) {
        return this.f2955j.canScrollVertically(i3);
    }

    public final void d() {
        l lVar = this.f2956k;
        if (lVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View e = lVar.e(this.f2952g);
        if (e == null) {
            return;
        }
        this.f2952g.getClass();
        int K = i1.K(e);
        if (K != this.f2950d && getScrollState() == 0) {
            this.f2958m.c(K);
        }
        this.e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i3 = ((SavedState) parcelable).f2965a;
            sparseArray.put(this.f2955j.getId(), sparseArray.get(i3));
            sparseArray.remove(i3);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        this.f2964t.getClass();
        this.f2964t.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public androidx.recyclerview.widget.z0 getAdapter() {
        return this.f2955j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f2950d;
    }

    public int getItemDecorationCount() {
        return this.f2955j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f2963s;
    }

    public int getOrientation() {
        return this.f2952g.f2427p;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        m mVar = this.f2955j;
        if (getOrientation() == 0) {
            height = mVar.getWidth() - mVar.getPaddingLeft();
            paddingBottom = mVar.getPaddingRight();
        } else {
            height = mVar.getHeight() - mVar.getPaddingTop();
            paddingBottom = mVar.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f2957l.f2977f;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i3;
        int i10;
        int itemCount;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ViewPager2 viewPager2 = (ViewPager2) this.f2964t.f19149d;
        if (viewPager2.getAdapter() == null) {
            i3 = 0;
            i10 = 0;
        } else if (viewPager2.getOrientation() == 1) {
            i3 = viewPager2.getAdapter().getItemCount();
            i10 = 0;
        } else {
            i10 = viewPager2.getAdapter().getItemCount();
            i3 = 0;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) f0.p(i3, i10, 0).f7859b);
        androidx.recyclerview.widget.z0 adapter = viewPager2.getAdapter();
        if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !viewPager2.r) {
            return;
        }
        if (viewPager2.f2950d > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        if (viewPager2.f2950d < itemCount - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int measuredWidth = this.f2955j.getMeasuredWidth();
        int measuredHeight = this.f2955j.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.f2947a;
        rect.left = paddingLeft;
        rect.right = (i11 - i3) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i12 - i10) - getPaddingBottom();
        Rect rect2 = this.f2948b;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.f2955j.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.e) {
            d();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        measureChild(this.f2955j, i3, i10);
        int measuredWidth = this.f2955j.getMeasuredWidth();
        int measuredHeight = this.f2955j.getMeasuredHeight();
        int measuredState = this.f2955j.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i3, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2953h = savedState.f2966b;
        this.f2954i = savedState.f2967c;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2965a = this.f2955j.getId();
        int i3 = this.f2953h;
        if (i3 == -1) {
            i3 = this.f2950d;
        }
        savedState.f2966b = i3;
        Parcelable parcelable = this.f2954i;
        if (parcelable != null) {
            savedState.f2967c = parcelable;
            return savedState;
        }
        this.f2955j.getAdapter();
        return savedState;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i3, Bundle bundle) {
        this.f2964t.getClass();
        if (i3 != 8192 && i3 != 4096) {
            return super.performAccessibilityAction(i3, bundle);
        }
        v2.h hVar = this.f2964t;
        hVar.getClass();
        if (i3 != 8192 && i3 != 4096) {
            throw new IllegalStateException();
        }
        ViewPager2 viewPager2 = (ViewPager2) hVar.f19149d;
        int currentItem = i3 == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1;
        if (viewPager2.r) {
            viewPager2.c(currentItem, true);
        }
        return true;
    }

    public void setAdapter(androidx.recyclerview.widget.z0 z0Var) {
        androidx.recyclerview.widget.z0 adapter = this.f2955j.getAdapter();
        v2.h hVar = this.f2964t;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver((f) hVar.f19148c);
        } else {
            hVar.getClass();
        }
        f fVar = this.f2951f;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(fVar);
        }
        this.f2955j.setAdapter(z0Var);
        this.f2950d = 0;
        b();
        v2.h hVar2 = this.f2964t;
        hVar2.q();
        if (z0Var != null) {
            z0Var.registerAdapterDataObserver((f) hVar2.f19148c);
        }
        if (z0Var != null) {
            z0Var.registerAdapterDataObserver(fVar);
        }
    }

    public void setCurrentItem(int i3) {
        Object obj = this.f2959n.f19953b;
        c(i3, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        super.setLayoutDirection(i3);
        this.f2964t.q();
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1 && i3 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f2963s = i3;
        this.f2955j.requestLayout();
    }

    public void setOrientation(int i3) {
        this.f2952g.g1(i3);
        this.f2964t.q();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f2962q) {
                this.f2961p = this.f2955j.getItemAnimator();
                this.f2962q = true;
            }
            this.f2955j.setItemAnimator(null);
        } else if (this.f2962q) {
            this.f2955j.setItemAnimator(this.f2961p);
            this.f2961p = null;
            this.f2962q = false;
        }
        this.f2960o.getClass();
        if (kVar == null) {
            return;
        }
        this.f2960o.getClass();
        this.f2960o.getClass();
    }

    public void setUserInputEnabled(boolean z5) {
        this.r = z5;
        this.f2964t.q();
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2947a = new Rect();
        this.f2948b = new Rect();
        this.f2949c = new g();
        this.e = false;
        this.f2951f = new f(this, 0);
        this.f2953h = -1;
        this.f2961p = null;
        this.f2962q = false;
        this.r = true;
        this.f2963s = -1;
        a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f2947a = new Rect();
        this.f2948b = new Rect();
        this.f2949c = new g();
        this.e = false;
        this.f2951f = new f(this, 0);
        this.f2953h = -1;
        this.f2961p = null;
        this.f2962q = false;
        this.r = true;
        this.f2963s = -1;
        a(context, attributeSet);
    }
}
