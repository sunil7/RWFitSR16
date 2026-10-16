package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import com.google.android.material.badge.BadgeDrawable$SavedState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.s;
import h.d0;
import h.k;
import h.m;
import h.x;
import j2.i0;

/* loaded from: classes.dex */
public final class c implements x {

    /* renamed from: a, reason: collision with root package name */
    public NavigationBarMenuView f10699a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10700b;

    /* renamed from: c, reason: collision with root package name */
    public int f10701c;

    @Override // h.x
    public final void b(k kVar, boolean z5) {
    }

    @Override // h.x
    public final void e(Parcelable parcelable) {
        int i3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z5;
        int i18;
        int i19;
        if (parcelable instanceof NavigationBarPresenter$SavedState) {
            NavigationBarMenuView navigationBarMenuView = this.f10699a;
            NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = (NavigationBarPresenter$SavedState) parcelable;
            int i20 = navigationBarPresenter$SavedState.f10680a;
            int size = navigationBarMenuView.f10679s.f14148f.size();
            int i21 = 0;
            while (true) {
                if (i21 >= size) {
                    break;
                }
                MenuItem item = navigationBarMenuView.f10679s.getItem(i21);
                if (i20 == item.getItemId()) {
                    navigationBarMenuView.f10668g = i20;
                    navigationBarMenuView.f10669h = i21;
                    item.setChecked(true);
                    break;
                }
                i21++;
            }
            Context context = this.f10699a.getContext();
            ParcelableSparseArray parcelableSparseArray = navigationBarPresenter$SavedState.f10681b;
            SparseArray<la.a> sparseArray = new SparseArray<>(parcelableSparseArray.size());
            for (int i22 = 0; i22 < parcelableSparseArray.size(); i22++) {
                int keyAt = parcelableSparseArray.keyAt(i22);
                BadgeDrawable$SavedState badgeDrawable$SavedState = (BadgeDrawable$SavedState) parcelableSparseArray.valueAt(i22);
                if (badgeDrawable$SavedState == null) {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
                la.a aVar = new la.a(context);
                i3 = badgeDrawable$SavedState.maxCharacterCount;
                aVar.g(i3);
                i10 = badgeDrawable$SavedState.number;
                s sVar = aVar.f15840c;
                BadgeDrawable$SavedState badgeDrawable$SavedState2 = aVar.f15844h;
                if (i10 != -1) {
                    i18 = badgeDrawable$SavedState.number;
                    int max = Math.max(0, i18);
                    i19 = badgeDrawable$SavedState2.number;
                    if (i19 != max) {
                        badgeDrawable$SavedState2.number = max;
                        sVar.f10635d = true;
                        aVar.i();
                        aVar.invalidateSelf();
                    }
                }
                i11 = badgeDrawable$SavedState.backgroundColor;
                badgeDrawable$SavedState2.backgroundColor = i11;
                ColorStateList valueOf = ColorStateList.valueOf(i11);
                eb.h hVar = aVar.f15839b;
                if (hVar.f12505a.f12490c != valueOf) {
                    hVar.l(valueOf);
                    aVar.invalidateSelf();
                }
                i12 = badgeDrawable$SavedState.badgeTextColor;
                badgeDrawable$SavedState2.badgeTextColor = i12;
                if (sVar.f10632a.getColor() != i12) {
                    sVar.f10632a.setColor(i12);
                    aVar.invalidateSelf();
                }
                i13 = badgeDrawable$SavedState.badgeGravity;
                aVar.f(i13);
                i14 = badgeDrawable$SavedState.horizontalOffset;
                badgeDrawable$SavedState2.horizontalOffset = i14;
                aVar.i();
                i15 = badgeDrawable$SavedState.verticalOffset;
                badgeDrawable$SavedState2.verticalOffset = i15;
                aVar.i();
                i16 = badgeDrawable$SavedState.additionalHorizontalOffset;
                badgeDrawable$SavedState2.additionalHorizontalOffset = i16;
                aVar.i();
                i17 = badgeDrawable$SavedState.additionalVerticalOffset;
                badgeDrawable$SavedState2.additionalVerticalOffset = i17;
                aVar.i();
                z5 = badgeDrawable$SavedState.isVisible;
                aVar.setVisible(z5, false);
                badgeDrawable$SavedState2.isVisible = z5;
                sparseArray.put(keyAt, aVar);
            }
            this.f10699a.setBadgeDrawables(sparseArray);
        }
    }

    @Override // h.x
    public final void g(boolean z5) {
        if (this.f10700b) {
            return;
        }
        if (z5) {
            this.f10699a.b();
            return;
        }
        NavigationBarMenuView navigationBarMenuView = this.f10699a;
        k kVar = navigationBarMenuView.f10679s;
        if (kVar == null || navigationBarMenuView.f10667f == null) {
            return;
        }
        int size = kVar.f14148f.size();
        if (size != navigationBarMenuView.f10667f.length) {
            navigationBarMenuView.b();
            return;
        }
        int i3 = navigationBarMenuView.f10668g;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = navigationBarMenuView.f10679s.getItem(i10);
            if (item.isChecked()) {
                navigationBarMenuView.f10668g = item.getItemId();
                navigationBarMenuView.f10669h = i10;
            }
        }
        if (i3 != navigationBarMenuView.f10668g) {
            i0.a(navigationBarMenuView, navigationBarMenuView.f10663a);
        }
        boolean e = NavigationBarMenuView.e(navigationBarMenuView.e, navigationBarMenuView.f10679s.l().size());
        for (int i11 = 0; i11 < size; i11++) {
            navigationBarMenuView.r.f10700b = true;
            navigationBarMenuView.f10667f[i11].setLabelVisibilityMode(navigationBarMenuView.e);
            navigationBarMenuView.f10667f[i11].setShifting(e);
            navigationBarMenuView.f10667f[i11].d((m) navigationBarMenuView.f10679s.getItem(i11));
            navigationBarMenuView.r.f10700b = false;
        }
    }

    @Override // h.x
    public final int getId() {
        return this.f10701c;
    }

    @Override // h.x
    public final void h(Context context, k kVar) {
        this.f10699a.f10679s = kVar;
    }

    @Override // h.x
    public final boolean i() {
        return false;
    }

    @Override // h.x
    public final Parcelable j() {
        NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = new NavigationBarPresenter$SavedState();
        navigationBarPresenter$SavedState.f10680a = this.f10699a.getSelectedItemId();
        SparseArray<la.a> badgeDrawables = this.f10699a.getBadgeDrawables();
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i3 = 0; i3 < badgeDrawables.size(); i3++) {
            int keyAt = badgeDrawables.keyAt(i3);
            la.a valueAt = badgeDrawables.valueAt(i3);
            if (valueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(keyAt, valueAt.f15844h);
        }
        navigationBarPresenter$SavedState.f10681b = parcelableSparseArray;
        return navigationBarPresenter$SavedState;
    }

    @Override // h.x
    public final boolean k(m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean l(m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean m(d0 d0Var) {
        return false;
    }
}
