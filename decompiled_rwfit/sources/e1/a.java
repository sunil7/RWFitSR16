package e1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import l1.d;

/* loaded from: classes.dex */
public interface a extends MenuItem {
    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    a l(d dVar);

    d n();

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char c9, int i3);

    @Override // android.view.MenuItem
    a setContentDescription(CharSequence charSequence);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char c9, int i3);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char c9, char c10, int i3, int i10);

    @Override // android.view.MenuItem
    a setTooltipText(CharSequence charSequence);
}
