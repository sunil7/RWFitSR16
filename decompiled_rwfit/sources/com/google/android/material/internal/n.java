package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.R$dimen;
import h.d0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n implements h.x {

    /* renamed from: a, reason: collision with root package name */
    public NavigationMenuView f10600a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f10601b;

    /* renamed from: c, reason: collision with root package name */
    public h.k f10602c;

    /* renamed from: d, reason: collision with root package name */
    public int f10603d;
    public f e;

    /* renamed from: f, reason: collision with root package name */
    public LayoutInflater f10604f;

    /* renamed from: g, reason: collision with root package name */
    public int f10605g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10606h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f10607i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f10608j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f10609k;

    /* renamed from: l, reason: collision with root package name */
    public int f10610l;

    /* renamed from: m, reason: collision with root package name */
    public int f10611m;

    /* renamed from: n, reason: collision with root package name */
    public int f10612n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10613o;

    /* renamed from: q, reason: collision with root package name */
    public int f10615q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f10616s;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10614p = true;

    /* renamed from: t, reason: collision with root package name */
    public int f10617t = -1;

    /* renamed from: u, reason: collision with root package name */
    public final androidx.appcompat.app.c f10618u = new androidx.appcompat.app.c(this, 4);

    @Override // h.x
    public final void b(h.k kVar, boolean z5) {
    }

    @Override // h.x
    public final void e(Parcelable parcelable) {
        h.m mVar;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f10600a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                f fVar = this.e;
                fVar.getClass();
                int i3 = bundle2.getInt("android:menu:checked", 0);
                ArrayList arrayList = fVar.f10591a;
                if (i3 != 0) {
                    fVar.f10593c = true;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        h hVar = (h) arrayList.get(i10);
                        if (hVar instanceof j) {
                            h.m mVar2 = ((j) hVar).f10597a;
                            if (mVar2.f14169a == i3) {
                                fVar.b(mVar2);
                                break;
                            }
                        }
                        i10++;
                    }
                    fVar.f10593c = false;
                    fVar.a();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        h hVar2 = (h) arrayList.get(i11);
                        if ((hVar2 instanceof j) && (actionView = (mVar = ((j) hVar2).f10597a).getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(mVar.f14169a)) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f10601b.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // h.x
    public final void g(boolean z5) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a();
            fVar.notifyDataSetChanged();
        }
    }

    @Override // h.x
    public final int getId() {
        return this.f10603d;
    }

    @Override // h.x
    public final void h(Context context, h.k kVar) {
        this.f10604f = LayoutInflater.from(context);
        this.f10602c = kVar;
        this.f10616s = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    @Override // h.x
    public final boolean i() {
        return false;
    }

    @Override // h.x
    public final Parcelable j() {
        Bundle bundle = new Bundle();
        if (this.f10600a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f10600a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        f fVar = this.e;
        if (fVar != null) {
            fVar.getClass();
            Bundle bundle2 = new Bundle();
            h.m mVar = fVar.f10592b;
            if (mVar != null) {
                bundle2.putInt("android:menu:checked", mVar.f14169a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            ArrayList arrayList = fVar.f10591a;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                h hVar = (h) arrayList.get(i3);
                if (hVar instanceof j) {
                    h.m mVar2 = ((j) hVar).f10597a;
                    View actionView = mVar2 != null ? mVar2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray2.put(mVar2.f14169a, parcelableSparseArray);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f10601b != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.f10601b.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // h.x
    public final boolean k(h.m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean l(h.m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean m(d0 d0Var) {
        return false;
    }
}
