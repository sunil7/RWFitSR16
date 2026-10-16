package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.google.android.material.R$layout;
import h.d0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.h0;

/* loaded from: classes.dex */
public final class f extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10591a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public h.m f10592b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10593c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f10594d;

    public f(n nVar) {
        this.f10594d = nVar;
        a();
    }

    public final void a() {
        boolean z5;
        if (this.f10593c) {
            return;
        }
        this.f10593c = true;
        ArrayList arrayList = this.f10591a;
        arrayList.clear();
        arrayList.add(new g());
        n nVar = this.f10594d;
        int size = nVar.f10602c.l().size();
        boolean z6 = false;
        int i3 = -1;
        int i10 = 0;
        boolean z8 = false;
        int i11 = 0;
        while (i10 < size) {
            h.m mVar = (h.m) nVar.f10602c.l().get(i10);
            if (mVar.isChecked()) {
                b(mVar);
            }
            if (mVar.isCheckable()) {
                mVar.d(z6);
            }
            if (mVar.hasSubMenu()) {
                d0 d0Var = mVar.f14182o;
                if (d0Var.hasVisibleItems()) {
                    if (i10 != 0) {
                        arrayList.add(new i(nVar.f10616s, z6 ? 1 : 0));
                    }
                    arrayList.add(new j(mVar));
                    int size2 = d0Var.f14148f.size();
                    int i12 = z6 ? 1 : 0;
                    int i13 = i12;
                    while (i12 < size2) {
                        h.m mVar2 = (h.m) d0Var.getItem(i12);
                        if (mVar2.isVisible()) {
                            if (i13 == 0 && mVar2.getIcon() != null) {
                                i13 = 1;
                            }
                            if (mVar2.isCheckable()) {
                                mVar2.d(z6);
                            }
                            if (mVar.isChecked()) {
                                b(mVar);
                            }
                            arrayList.add(new j(mVar2));
                        }
                        i12++;
                        z6 = false;
                    }
                    if (i13 != 0) {
                        int size3 = arrayList.size();
                        for (int size4 = arrayList.size(); size4 < size3; size4++) {
                            ((j) arrayList.get(size4)).f10598b = true;
                        }
                    }
                }
                z5 = true;
            } else {
                int i14 = mVar.f14170b;
                if (i14 != i3) {
                    i11 = arrayList.size();
                    z8 = mVar.getIcon() != null;
                    if (i10 != 0) {
                        i11++;
                        int i15 = nVar.f10616s;
                        arrayList.add(new i(i15, i15));
                    }
                } else if (!z8 && mVar.getIcon() != null) {
                    int size5 = arrayList.size();
                    for (int i16 = i11; i16 < size5; i16++) {
                        ((j) arrayList.get(i16)).f10598b = true;
                    }
                    z5 = true;
                    z8 = true;
                    j jVar = new j(mVar);
                    jVar.f10598b = z8;
                    arrayList.add(jVar);
                    i3 = i14;
                }
                z5 = true;
                j jVar2 = new j(mVar);
                jVar2.f10598b = z8;
                arrayList.add(jVar2);
                i3 = i14;
            }
            i10++;
            z6 = false;
        }
        this.f10593c = z6 ? 1 : 0;
    }

    public final void b(h.m mVar) {
        if (this.f10592b == mVar || !mVar.isCheckable()) {
            return;
        }
        h.m mVar2 = this.f10592b;
        if (mVar2 != null) {
            mVar2.setChecked(false);
        }
        this.f10592b = mVar;
        mVar.setChecked(true);
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f10591a.size();
    }

    @Override // androidx.recyclerview.widget.z0
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemViewType(int i3) {
        h hVar = (h) this.f10591a.get(i3);
        if (hVar instanceof i) {
            return 2;
        }
        if (hVar instanceof g) {
            return 3;
        }
        if (hVar instanceof j) {
            return ((j) hVar).f10597a.hasSubMenu() ? 1 : 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        m mVar = (m) z1Var;
        int itemViewType = getItemViewType(i3);
        ArrayList arrayList = this.f10591a;
        if (itemViewType != 0) {
            if (itemViewType == 1) {
                ((TextView) mVar.itemView).setText(((j) arrayList.get(i3)).f10597a.e);
                return;
            } else {
                if (itemViewType != 2) {
                    return;
                }
                i iVar = (i) arrayList.get(i3);
                mVar.itemView.setPadding(0, iVar.f10595a, 0, iVar.f10596b);
                return;
            }
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) mVar.itemView;
        n nVar = this.f10594d;
        navigationMenuItemView.setIconTintList(nVar.f10608j);
        if (nVar.f10606h) {
            navigationMenuItemView.setTextAppearance(nVar.f10605g);
        }
        ColorStateList colorStateList = nVar.f10607i;
        if (colorStateList != null) {
            navigationMenuItemView.setTextColor(colorStateList);
        }
        Drawable drawable = nVar.f10609k;
        Drawable newDrawable = drawable != null ? drawable.getConstantState().newDrawable() : null;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        h0.q(navigationMenuItemView, newDrawable);
        j jVar = (j) arrayList.get(i3);
        navigationMenuItemView.setNeedsEmptyIcon(jVar.f10598b);
        navigationMenuItemView.setHorizontalPadding(nVar.f10610l);
        navigationMenuItemView.setIconPadding(nVar.f10611m);
        if (nVar.f10613o) {
            navigationMenuItemView.setIconSize(nVar.f10612n);
        }
        navigationMenuItemView.setMaxLines(nVar.f10615q);
        navigationMenuItemView.d(jVar.f10597a);
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        n nVar = this.f10594d;
        if (i3 == 0) {
            LayoutInflater layoutInflater = nVar.f10604f;
            androidx.appcompat.app.c cVar = nVar.f10618u;
            l lVar = new l(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            lVar.itemView.setOnClickListener(cVar);
            return lVar;
        }
        if (i3 == 1) {
            return new e(nVar.f10604f.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
        if (i3 == 2) {
            return new e(nVar.f10604f.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
        if (i3 != 3) {
            return null;
        }
        return new e(nVar.f10601b);
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onViewRecycled(z1 z1Var) {
        m mVar = (m) z1Var;
        if (mVar instanceof l) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) mVar.itemView;
            FrameLayout frameLayout = navigationMenuItemView.f10548z;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.f10547y.setCompoundDrawables(null, null, null, null);
        }
    }
}
