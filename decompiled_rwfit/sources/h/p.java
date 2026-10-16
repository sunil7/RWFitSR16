package h;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class p implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f14197a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f14198b;

    public p(r rVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f14198b = rVar;
        this.f14197a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f14197a.onMenuItemActionCollapse(this.f14198b.z(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f14197a.onMenuItemActionExpand(this.f14198b.z(menuItem));
    }
}
