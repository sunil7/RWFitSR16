package h;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public final class a implements e1.a {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f14067a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f14068b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f14069c;

    /* renamed from: d, reason: collision with root package name */
    public char f14070d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public char f14071f;

    /* renamed from: g, reason: collision with root package name */
    public int f14072g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f14073h;

    /* renamed from: i, reason: collision with root package name */
    public Context f14074i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f14075j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f14076k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f14077l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f14078m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14079n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14080o;

    /* renamed from: p, reason: collision with root package name */
    public int f14081p;

    public final void a() {
        Drawable drawable = this.f14073h;
        if (drawable != null) {
            if (this.f14079n || this.f14080o) {
                this.f14073h = drawable;
                Drawable mutate = drawable.mutate();
                this.f14073h = mutate;
                if (this.f14079n) {
                    d1.b.h(mutate, this.f14077l);
                }
                if (this.f14080o) {
                    d1.b.i(this.f14073h, this.f14078m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // e1.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f14072g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f14071f;
    }

    @Override // e1.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f14075j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f14073h;
    }

    @Override // e1.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f14077l;
    }

    @Override // e1.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f14078m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f14069c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // e1.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f14070d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f14067a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f14068b;
        return charSequence != null ? charSequence : this.f14067a;
    }

    @Override // e1.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f14076k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f14081p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f14081p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f14081p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f14081p & 8) == 0;
    }

    @Override // e1.a
    public final e1.a l(l1.d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // e1.a
    public final l1.d n() {
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        this.f14071f = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z5) {
        this.f14081p = (z5 ? 1 : 0) | (this.f14081p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z5) {
        this.f14081p = (z5 ? 2 : 0) | (this.f14081p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f14075j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z5) {
        this.f14081p = (z5 ? 16 : 0) | (this.f14081p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f14073h = drawable;
        a();
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f14077l = colorStateList;
        this.f14079n = true;
        a();
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f14078m = mode;
        this.f14080o = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f14069c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f14070d = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f14070d = c9;
        this.f14071f = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i3) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i3) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f14067a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f14068b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f14076k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z5) {
        this.f14081p = (this.f14081p & 8) | (z5 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i3) {
        this.f14071f = Character.toLowerCase(c9);
        this.f14072g = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final e1.a setContentDescription(CharSequence charSequence) {
        this.f14075j = charSequence;
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i3) {
        this.f14070d = c9;
        this.e = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i3) {
        this.f14067a = this.f14074i.getResources().getString(i3);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final e1.a setTooltipText(CharSequence charSequence) {
        this.f14076k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i3) {
        this.f14073h = a1.c.b(this.f14074i, i3);
        a();
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i3, int i10) {
        this.f14070d = c9;
        this.e = KeyEvent.normalizeMetaState(i3);
        this.f14071f = Character.toLowerCase(c10);
        this.f14072g = KeyEvent.normalizeMetaState(i10);
        return this;
    }
}
