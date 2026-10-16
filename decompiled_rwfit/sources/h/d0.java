package h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public class d0 extends k implements SubMenu {
    public final m A;

    /* renamed from: z, reason: collision with root package name */
    public final k f14106z;

    public d0(Context context, k kVar, m mVar) {
        super(context);
        this.f14106z = kVar;
        this.A = mVar;
    }

    @Override // h.k
    public final boolean d(m mVar) {
        return this.f14106z.d(mVar);
    }

    @Override // h.k
    public final boolean e(k kVar, MenuItem menuItem) {
        return super.e(kVar, menuItem) || this.f14106z.e(kVar, menuItem);
    }

    @Override // h.k
    public final boolean f(m mVar) {
        return this.f14106z.f(mVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // h.k
    public final String j() {
        m mVar = this.A;
        int i3 = mVar != null ? mVar.f14169a : 0;
        if (i3 == 0) {
            return null;
        }
        return l0.j(i3, "android:menu:actionviewstates:");
    }

    @Override // h.k
    public final k k() {
        return this.f14106z.k();
    }

    @Override // h.k
    public final boolean m() {
        return this.f14106z.m();
    }

    @Override // h.k
    public final boolean n() {
        return this.f14106z.n();
    }

    @Override // h.k
    public final boolean o() {
        return this.f14106z.o();
    }

    @Override // h.k, android.view.Menu
    public final void setGroupDividerEnabled(boolean z5) {
        this.f14106z.setGroupDividerEnabled(z5);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        w(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        w(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        w(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // h.k, android.view.Menu
    public final void setQwertyMode(boolean z5) {
        this.f14106z.setQwertyMode(z5);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i3) {
        w(0, null, i3, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i3) {
        w(i3, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i3) {
        this.A.setIcon(i3);
        return this;
    }
}
