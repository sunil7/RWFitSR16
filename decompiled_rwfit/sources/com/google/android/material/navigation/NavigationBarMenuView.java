package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.R$attr;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.material.internal.u;
import h.k;
import h.m;
import h.z;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements z {

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f10661t = {R.attr.state_checked};

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f10662u = {-16842910};

    /* renamed from: a, reason: collision with root package name */
    public final j2.a f10663a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.appcompat.app.c f10664b;

    /* renamed from: c, reason: collision with root package name */
    public final k1.e f10665c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f10666d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public NavigationBarItemView[] f10667f;

    /* renamed from: g, reason: collision with root package name */
    public int f10668g;

    /* renamed from: h, reason: collision with root package name */
    public int f10669h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f10670i;

    /* renamed from: j, reason: collision with root package name */
    public int f10671j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f10672k;

    /* renamed from: l, reason: collision with root package name */
    public final ColorStateList f10673l;

    /* renamed from: m, reason: collision with root package name */
    public int f10674m;

    /* renamed from: n, reason: collision with root package name */
    public int f10675n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f10676o;

    /* renamed from: p, reason: collision with root package name */
    public int f10677p;

    /* renamed from: q, reason: collision with root package name */
    public SparseArray f10678q;
    public c r;

    /* renamed from: s, reason: collision with root package name */
    public k f10679s;

    public NavigationBarMenuView(Context context) {
        super(context);
        this.f10665c = new k1.e(5);
        this.f10666d = new SparseArray(5);
        this.f10668g = 0;
        this.f10669h = 0;
        this.f10678q = new SparseArray(5);
        this.f10673l = c();
        j2.a aVar = new j2.a();
        this.f10663a = aVar;
        aVar.L(0);
        aVar.A(115L);
        aVar.C(new v1.a());
        aVar.I(new u());
        this.f10664b = new androidx.appcompat.app.c(this, 5);
        WeakHashMap weakHashMap = z0.f15748a;
        h0.s(this, 1);
    }

    public static boolean e(int i3, int i10) {
        return i3 == -1 ? i10 > 3 : i3 == 0;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.f10665c.a();
        return navigationBarItemView == null ? d(getContext()) : navigationBarItemView;
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView) {
        la.a aVar;
        int id2 = navigationBarItemView.getId();
        if (id2 == -1 || (aVar = (la.a) this.f10678q.get(id2)) == null) {
            return;
        }
        navigationBarItemView.setBadge(aVar);
    }

    @Override // h.z
    public final void a(k kVar) {
        this.f10679s = kVar;
    }

    public final void b() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f10665c.c(navigationBarItemView);
                    if (navigationBarItemView.f10660p != null) {
                        ImageView imageView = navigationBarItemView.f10651g;
                        if (imageView != null) {
                            navigationBarItemView.setClipChildren(true);
                            navigationBarItemView.setClipToPadding(true);
                            la.a aVar = navigationBarItemView.f10660p;
                            if (aVar != null) {
                                WeakReference weakReference = aVar.f15852p;
                                if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                                    WeakReference weakReference2 = aVar.f15852p;
                                    (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(aVar);
                                }
                            }
                        }
                        navigationBarItemView.f10660p = null;
                    }
                }
            }
        }
        if (this.f10679s.f14148f.size() == 0) {
            this.f10668g = 0;
            this.f10669h = 0;
            this.f10667f = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < this.f10679s.f14148f.size(); i3++) {
            hashSet.add(Integer.valueOf(this.f10679s.getItem(i3).getItemId()));
        }
        for (int i10 = 0; i10 < this.f10678q.size(); i10++) {
            int keyAt = this.f10678q.keyAt(i10);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.f10678q.delete(keyAt);
            }
        }
        this.f10667f = new NavigationBarItemView[this.f10679s.f14148f.size()];
        boolean e = e(this.e, this.f10679s.l().size());
        for (int i11 = 0; i11 < this.f10679s.f14148f.size(); i11++) {
            this.r.f10700b = true;
            this.f10679s.getItem(i11).setCheckable(true);
            this.r.f10700b = false;
            NavigationBarItemView newItem = getNewItem();
            this.f10667f[i11] = newItem;
            newItem.setIconTintList(this.f10670i);
            newItem.setIconSize(this.f10671j);
            newItem.setTextColor(this.f10673l);
            newItem.setTextAppearanceInactive(this.f10674m);
            newItem.setTextAppearanceActive(this.f10675n);
            newItem.setTextColor(this.f10672k);
            Drawable drawable = this.f10676o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f10677p);
            }
            newItem.setShifting(e);
            newItem.setLabelVisibilityMode(this.e);
            m mVar = (m) this.f10679s.getItem(i11);
            newItem.d(mVar);
            newItem.setItemPosition(i11);
            SparseArray sparseArray = this.f10666d;
            int i12 = mVar.f14169a;
            newItem.setOnTouchListener((View.OnTouchListener) sparseArray.get(i12));
            newItem.setOnClickListener(this.f10664b);
            int i13 = this.f10668g;
            if (i13 != 0 && i12 == i13) {
                this.f10669h = i11;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.f10679s.f14148f.size() - 1, this.f10669h);
        this.f10669h = min;
        this.f10679s.getItem(min).setChecked(true);
    }

    public final ColorStateList c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList a3 = pb.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a3.getDefaultColor();
        int[] iArr = f10662u;
        return new ColorStateList(new int[][]{iArr, f10661t, ViewGroup.EMPTY_STATE_SET}, new int[]{a3.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    public abstract NavigationBarItemView d(Context context);

    public SparseArray<la.a> getBadgeDrawables() {
        return this.f10678q;
    }

    public ColorStateList getIconTintList() {
        return this.f10670i;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f10676o : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f10677p;
    }

    public int getItemIconSize() {
        return this.f10671j;
    }

    public int getItemTextAppearanceActive() {
        return this.f10675n;
    }

    public int getItemTextAppearanceInactive() {
        return this.f10674m;
    }

    public ColorStateList getItemTextColor() {
        return this.f10672k;
    }

    public int getLabelVisibilityMode() {
        return this.e;
    }

    public k getMenu() {
        return this.f10679s;
    }

    public int getSelectedItemId() {
        return this.f10668g;
    }

    public int getSelectedItemPosition() {
        return this.f10669h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) f0.p(1, this.f10679s.l().size(), 1).f7859b);
    }

    public void setBadgeDrawables(SparseArray<la.a> sparseArray) {
        this.f10678q = sparseArray;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(sparseArray.get(navigationBarItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f10670i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f10676o = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i3) {
        this.f10677p = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i3);
            }
        }
    }

    public void setItemIconSize(int i3) {
        this.f10671j = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i3);
            }
        }
    }

    public void setItemTextAppearanceActive(int i3) {
        this.f10675n = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i3);
                ColorStateList colorStateList = this.f10672k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i3) {
        this.f10674m = i3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i3);
                ColorStateList colorStateList = this.f10672k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f10672k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f10667f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i3) {
        this.e = i3;
    }

    public void setPresenter(c cVar) {
        this.r = cVar;
    }
}
