package h;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class q implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f14199a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f14200b;

    public q(r rVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f14200b = rVar;
        this.f14199a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f14199a.onMenuItemClick(this.f14200b.z(menuItem));
    }
}
