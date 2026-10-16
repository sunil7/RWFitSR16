package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l implements h.x {

    /* renamed from: a, reason: collision with root package name */
    public final Context f953a;

    /* renamed from: b, reason: collision with root package name */
    public Context f954b;

    /* renamed from: c, reason: collision with root package name */
    public h.k f955c;

    /* renamed from: d, reason: collision with root package name */
    public final LayoutInflater f956d;
    public h.w e;

    /* renamed from: f, reason: collision with root package name */
    public final int f957f;

    /* renamed from: g, reason: collision with root package name */
    public final int f958g;

    /* renamed from: h, reason: collision with root package name */
    public h.z f959h;

    /* renamed from: i, reason: collision with root package name */
    public int f960i;

    /* renamed from: j, reason: collision with root package name */
    public j f961j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f962k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f963l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f964m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f965n;

    /* renamed from: o, reason: collision with root package name */
    public int f966o;

    /* renamed from: p, reason: collision with root package name */
    public int f967p;

    /* renamed from: q, reason: collision with root package name */
    public int f968q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final SparseBooleanArray f969s;

    /* renamed from: t, reason: collision with root package name */
    public f f970t;

    /* renamed from: u, reason: collision with root package name */
    public f f971u;

    /* renamed from: v, reason: collision with root package name */
    public h f972v;

    /* renamed from: w, reason: collision with root package name */
    public g f973w;

    /* renamed from: x, reason: collision with root package name */
    public final androidx.appcompat.app.t f974x;

    /* renamed from: y, reason: collision with root package name */
    public int f975y;

    public l(Context context) {
        int i3 = R$layout.abc_action_menu_layout;
        int i10 = R$layout.abc_action_menu_item_layout;
        this.f953a = context;
        this.f956d = LayoutInflater.from(context);
        this.f957f = i3;
        this.f958g = i10;
        this.f969s = new SparseBooleanArray();
        this.f974x = new androidx.appcompat.app.t(this, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [h.y] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View a(h.m mVar, View view, ViewGroup viewGroup) {
        View actionView = mVar.getActionView();
        if (actionView == null || mVar.c()) {
            ActionMenuItemView actionMenuItemView = view instanceof h.y ? (h.y) view : (h.y) this.f956d.inflate(this.f958g, viewGroup, false);
            actionMenuItemView.d(mVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f959h);
            if (this.f973w == null) {
                this.f973w = new g(this);
            }
            actionMenuItemView2.setPopupCallback(this.f973w);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(mVar.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof o)) {
            actionView.setLayoutParams(ActionMenuView.m(layoutParams));
        }
        return actionView;
    }

    @Override // h.x
    public final void b(h.k kVar, boolean z5) {
        d();
        f fVar = this.f971u;
        if (fVar != null && fVar.b()) {
            fVar.f14212i.dismiss();
        }
        h.w wVar = this.e;
        if (wVar != null) {
            wVar.b(kVar, z5);
        }
    }

    @Override // h.x
    public final void c(h.w wVar) {
        throw null;
    }

    public final boolean d() {
        Object obj;
        h hVar = this.f972v;
        if (hVar != null && (obj = this.f959h) != null) {
            ((View) obj).removeCallbacks(hVar);
            this.f972v = null;
            return true;
        }
        f fVar = this.f970t;
        if (fVar == null) {
            return false;
        }
        if (fVar.b()) {
            fVar.f14212i.dismiss();
        }
        return true;
    }

    @Override // h.x
    public final void e(Parcelable parcelable) {
        int i3;
        MenuItem findItem;
        if ((parcelable instanceof ActionMenuPresenter$SavedState) && (i3 = ((ActionMenuPresenter$SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.f955c.findItem(i3)) != null) {
            m((h.d0) findItem.getSubMenu());
        }
    }

    public final boolean f() {
        f fVar = this.f970t;
        return fVar != null && fVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.x
    public final void g(boolean z5) {
        int i3;
        ViewGroup viewGroup = (ViewGroup) this.f959h;
        ArrayList arrayList = null;
        boolean z6 = false;
        if (viewGroup != null) {
            h.k kVar = this.f955c;
            if (kVar != null) {
                kVar.i();
                ArrayList l3 = this.f955c.l();
                int size = l3.size();
                i3 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    h.m mVar = (h.m) l3.get(i10);
                    if ((mVar.f14190x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i3);
                        h.m itemData = childAt instanceof h.y ? ((h.y) childAt).getItemData() : null;
                        View a3 = a(mVar, childAt, viewGroup);
                        if (mVar != itemData) {
                            a3.setPressed(false);
                            a3.jumpDrawablesToCurrentState();
                        }
                        if (a3 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a3.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a3);
                            }
                            ((ViewGroup) this.f959h).addView(a3, i3);
                        }
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            while (i3 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i3) == this.f961j) {
                    i3++;
                } else {
                    viewGroup.removeViewAt(i3);
                }
            }
        }
        ((View) this.f959h).requestLayout();
        h.k kVar2 = this.f955c;
        if (kVar2 != null) {
            kVar2.i();
            ArrayList arrayList2 = kVar2.f14151i;
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                l1.d dVar = ((h.m) arrayList2.get(i11)).A;
                if (dVar != null) {
                    dVar.f15684a = this;
                }
            }
        }
        h.k kVar3 = this.f955c;
        if (kVar3 != null) {
            kVar3.i();
            arrayList = kVar3.f14152j;
        }
        if (this.f964m && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z6 = !((h.m) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z6 = true;
            }
        }
        if (z6) {
            if (this.f961j == null) {
                this.f961j = new j(this, this.f953a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f961j.getParent();
            if (viewGroup3 != this.f959h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f961j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f959h;
                j jVar = this.f961j;
                actionMenuView.getClass();
                o l5 = ActionMenuView.l();
                l5.f1008a = true;
                actionMenuView.addView(jVar, l5);
            }
        } else {
            j jVar2 = this.f961j;
            if (jVar2 != null) {
                Object parent = jVar2.getParent();
                Object obj = this.f959h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f961j);
                }
            }
        }
        ((ActionMenuView) this.f959h).setOverflowReserved(this.f964m);
    }

    @Override // h.x
    public final int getId() {
        return this.f960i;
    }

    @Override // h.x
    public final void h(Context context, h.k kVar) {
        this.f954b = context;
        LayoutInflater.from(context);
        this.f955c = kVar;
        Resources resources = context.getResources();
        a8.c d5 = a8.c.d(context);
        if (!this.f965n) {
            this.f964m = true;
        }
        this.f966o = d5.f123a.getResources().getDisplayMetrics().widthPixels / 2;
        this.f968q = d5.e();
        int i3 = this.f966o;
        if (this.f964m) {
            if (this.f961j == null) {
                j jVar = new j(this, this.f953a);
                this.f961j = jVar;
                if (this.f963l) {
                    jVar.setImageDrawable(this.f962k);
                    this.f962k = null;
                    this.f963l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f961j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i3 -= this.f961j.getMeasuredWidth();
        } else {
            this.f961j = null;
        }
        this.f967p = i3;
        float f2 = resources.getDisplayMetrics().density;
    }

    @Override // h.x
    public final boolean i() {
        int i3;
        ArrayList arrayList;
        int i10;
        boolean z5;
        l lVar = this;
        h.k kVar = lVar.f955c;
        if (kVar != null) {
            arrayList = kVar.l();
            i3 = arrayList.size();
        } else {
            i3 = 0;
            arrayList = null;
        }
        int i11 = lVar.f968q;
        int i12 = lVar.f967p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) lVar.f959h;
        int i13 = 0;
        boolean z6 = false;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i10 = 2;
            z5 = true;
            if (i13 >= i3) {
                break;
            }
            h.m mVar = (h.m) arrayList.get(i13);
            int i16 = mVar.f14191y;
            if ((i16 & 2) == 2) {
                i14++;
            } else if ((i16 & 1) == 1) {
                i15++;
            } else {
                z6 = true;
            }
            if (lVar.r && mVar.C) {
                i11 = 0;
            }
            i13++;
        }
        if (lVar.f964m && (z6 || i15 + i14 > i11)) {
            i11--;
        }
        int i17 = i11 - i14;
        SparseBooleanArray sparseBooleanArray = lVar.f969s;
        sparseBooleanArray.clear();
        int i18 = 0;
        int i19 = 0;
        while (i18 < i3) {
            h.m mVar2 = (h.m) arrayList.get(i18);
            int i20 = mVar2.f14191y;
            boolean z8 = (i20 & 2) == i10 ? z5 : false;
            int i21 = mVar2.f14170b;
            if (z8) {
                View a3 = lVar.a(mVar2, null, viewGroup);
                a3.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a3.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i19 == 0) {
                    i19 = measuredWidth;
                }
                if (i21 != 0) {
                    sparseBooleanArray.put(i21, z5);
                }
                mVar2.e(z5);
            } else if ((i20 & 1) == z5) {
                boolean z10 = sparseBooleanArray.get(i21);
                boolean z11 = ((i17 > 0 || z10) && i12 > 0) ? z5 : false;
                if (z11) {
                    View a10 = lVar.a(mVar2, null, viewGroup);
                    a10.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = a10.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i19 == 0) {
                        i19 = measuredWidth2;
                    }
                    z11 &= i12 + i19 > 0;
                }
                if (z11 && i21 != 0) {
                    sparseBooleanArray.put(i21, true);
                } else if (z10) {
                    sparseBooleanArray.put(i21, false);
                    for (int i22 = 0; i22 < i18; i22++) {
                        h.m mVar3 = (h.m) arrayList.get(i22);
                        if (mVar3.f14170b == i21) {
                            if ((mVar3.f14190x & 32) == 32) {
                                i17++;
                            }
                            mVar3.e(false);
                        }
                    }
                }
                if (z11) {
                    i17--;
                }
                mVar2.e(z11);
            } else {
                mVar2.e(false);
                i18++;
                i10 = 2;
                lVar = this;
                z5 = true;
            }
            i18++;
            i10 = 2;
            lVar = this;
            z5 = true;
        }
        return z5;
    }

    @Override // h.x
    public final Parcelable j() {
        ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.openSubMenuId = this.f975y;
        return actionMenuPresenter$SavedState;
    }

    @Override // h.x
    public final boolean k(h.m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean l(h.m mVar) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.x
    public final boolean m(h.d0 d0Var) {
        boolean z5;
        if (d0Var.hasVisibleItems()) {
            h.d0 d0Var2 = d0Var;
            while (true) {
                h.k kVar = d0Var2.f14106z;
                if (kVar == this.f955c) {
                    break;
                }
                d0Var2 = (h.d0) kVar;
            }
            ViewGroup viewGroup = (ViewGroup) this.f959h;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i3);
                    if ((childAt instanceof h.y) && ((h.y) childAt).getItemData() == d0Var2.A) {
                        view = childAt;
                        break;
                    }
                    i3++;
                }
            }
            if (view != null) {
                this.f975y = d0Var.A.f14169a;
                int size = d0Var.f14148f.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        z5 = false;
                        break;
                    }
                    MenuItem item = d0Var.getItem(i10);
                    if (item.isVisible() && item.getIcon() != null) {
                        z5 = true;
                        break;
                    }
                    i10++;
                }
                f fVar = new f(this, this.f954b, d0Var, view);
                this.f971u = fVar;
                fVar.f14210g = z5;
                h.s sVar = fVar.f14212i;
                if (sVar != null) {
                    sVar.q(z5);
                }
                f fVar2 = this.f971u;
                if (!fVar2.b()) {
                    if (fVar2.e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    fVar2.d(0, 0, false, false);
                }
                h.w wVar = this.e;
                if (wVar != null) {
                    wVar.c(d0Var);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean n() {
        h.k kVar;
        if (!this.f964m || f() || (kVar = this.f955c) == null || this.f959h == null || this.f972v != null) {
            return false;
        }
        kVar.i();
        if (kVar.f14152j.isEmpty()) {
            return false;
        }
        h hVar = new h(0, this, new f(this, this.f954b, this.f955c, this.f961j));
        this.f972v = hVar;
        ((View) this.f959h).post(hVar);
        return true;
    }
}
