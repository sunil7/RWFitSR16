package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public class a0 extends a2.h implements Menu {

    /* renamed from: c, reason: collision with root package name */
    public final k f14082c;

    public a0(Context context, k kVar) {
        super(context);
        if (kVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f14082c = kVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return z(this.f14082c.a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i3, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f14082c.addIntentOptions(i3, i10, i11, componentName, intentArr, intent, i12, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i13 = 0; i13 < length; i13++) {
                menuItemArr[i13] = z(menuItemArr2[i13]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f14082c.addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        m0.k kVar = (m0.k) this.f37b;
        if (kVar != null) {
            kVar.clear();
        }
        this.f14082c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f14082c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i3) {
        return z(this.f14082c.findItem(i3));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i3) {
        return z(this.f14082c.getItem(i3));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f14082c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return this.f14082c.isShortcutKey(i3, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i3, int i10) {
        return this.f14082c.performIdentifierAction(i3, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i3, KeyEvent keyEvent, int i10) {
        return this.f14082c.performShortcut(i3, keyEvent, i10);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i3) {
        if (((m0.k) this.f37b) != null) {
            int i10 = 0;
            while (true) {
                m0.k kVar = (m0.k) this.f37b;
                if (i10 >= kVar.f15919c) {
                    break;
                }
                if (((e1.a) kVar.h(i10)).getGroupId() == i3) {
                    ((m0.k) this.f37b).j(i10);
                    i10--;
                }
                i10++;
            }
        }
        this.f14082c.removeGroup(i3);
    }

    @Override // android.view.Menu
    public final void removeItem(int i3) {
        if (((m0.k) this.f37b) != null) {
            int i10 = 0;
            while (true) {
                m0.k kVar = (m0.k) this.f37b;
                if (i10 >= kVar.f15919c) {
                    break;
                }
                if (((e1.a) kVar.h(i10)).getItemId() == i3) {
                    ((m0.k) this.f37b).j(i10);
                    break;
                }
                i10++;
            }
        }
        this.f14082c.removeItem(i3);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i3, boolean z5, boolean z6) {
        this.f14082c.setGroupCheckable(i3, z5, z6);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i3, boolean z5) {
        this.f14082c.setGroupEnabled(i3, z5);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i3, boolean z5) {
        this.f14082c.setGroupVisible(i3, z5);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z5) {
        this.f14082c.setQwertyMode(z5);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f14082c.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3) {
        return this.f14082c.addSubMenu(i3);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3) {
        return z(this.f14082c.add(i3));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3, int i10, int i11, CharSequence charSequence) {
        return this.f14082c.addSubMenu(i3, i10, i11, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i10, int i11, CharSequence charSequence) {
        return z(this.f14082c.a(i3, i10, i11, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3, int i10, int i11, int i12) {
        return this.f14082c.addSubMenu(i3, i10, i11, i12);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i10, int i11, int i12) {
        return z(this.f14082c.add(i3, i10, i11, i12));
    }
}
