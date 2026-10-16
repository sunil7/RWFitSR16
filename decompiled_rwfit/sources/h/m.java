package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m implements e1.a {
    public l1.d A;
    public MenuItem.OnActionExpandListener B;

    /* renamed from: a, reason: collision with root package name */
    public final int f14169a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14170b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14171c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14172d;
    public CharSequence e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f14173f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f14174g;

    /* renamed from: h, reason: collision with root package name */
    public char f14175h;

    /* renamed from: j, reason: collision with root package name */
    public char f14177j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f14179l;

    /* renamed from: n, reason: collision with root package name */
    public final k f14181n;

    /* renamed from: o, reason: collision with root package name */
    public d0 f14182o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f14183p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f14184q;
    public CharSequence r;

    /* renamed from: y, reason: collision with root package name */
    public int f14191y;

    /* renamed from: z, reason: collision with root package name */
    public View f14192z;

    /* renamed from: i, reason: collision with root package name */
    public int f14176i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f14178k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f14180m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f14185s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f14186t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14187u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f14188v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14189w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f14190x = 16;
    public boolean C = false;

    public m(k kVar, int i3, int i10, int i11, int i12, CharSequence charSequence, int i13) {
        this.f14181n = kVar;
        this.f14169a = i10;
        this.f14170b = i3;
        this.f14171c = i11;
        this.f14172d = i12;
        this.e = charSequence;
        this.f14191y = i13;
    }

    public static void a(StringBuilder sb2, int i3, int i10, String str) {
        if ((i3 & i10) == i10) {
            sb2.append(str);
        }
    }

    public final Drawable b(Drawable drawable) {
        if (drawable != null && this.f14189w && (this.f14187u || this.f14188v)) {
            drawable = drawable.mutate();
            if (this.f14187u) {
                d1.b.h(drawable, this.f14185s);
            }
            if (this.f14188v) {
                d1.b.i(drawable, this.f14186t);
            }
            this.f14189w = false;
        }
        return drawable;
    }

    public final boolean c() {
        l1.d dVar;
        if ((this.f14191y & 8) == 0) {
            return false;
        }
        if (this.f14192z == null && (dVar = this.A) != null) {
            this.f14192z = dVar.b(this);
        }
        return this.f14192z != null;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f14191y & 8) == 0) {
            return false;
        }
        if (this.f14192z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f14181n.d(this);
        }
        return false;
    }

    public final void d(boolean z5) {
        this.f14190x = (z5 ? 4 : 0) | (this.f14190x & (-5));
    }

    public final void e(boolean z5) {
        if (z5) {
            this.f14190x |= 32;
        } else {
            this.f14190x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!c()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f14181n.f(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f14192z;
        if (view != null) {
            return view;
        }
        l1.d dVar = this.A;
        if (dVar == null) {
            return null;
        }
        View b3 = dVar.b(this);
        this.f14192z = b3;
        return b3;
    }

    @Override // e1.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f14178k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f14177j;
    }

    @Override // e1.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f14184q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f14170b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f14179l;
        if (drawable != null) {
            return b(drawable);
        }
        int i3 = this.f14180m;
        if (i3 == 0) {
            return null;
        }
        Drawable b3 = pb.b(this.f14181n.f14144a, i3);
        this.f14180m = 0;
        this.f14179l = b3;
        return b(b3);
    }

    @Override // e1.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f14185s;
    }

    @Override // e1.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f14186t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f14174g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f14169a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // e1.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f14176i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f14175h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f14171c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f14182o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f14173f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // e1.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f14182o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f14190x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f14190x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f14190x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        l1.d dVar = this.A;
        return (dVar == null || !dVar.c()) ? (this.f14190x & 8) == 0 : (this.f14190x & 8) == 0 && this.A.a();
    }

    @Override // e1.a
    public final e1.a l(l1.d dVar) {
        l1.d dVar2 = this.A;
        if (dVar2 != null) {
            dVar2.f15684a = null;
        }
        this.f14192z = null;
        this.A = dVar;
        this.f14181n.p(true);
        l1.d dVar3 = this.A;
        if (dVar3 != null) {
            dVar3.d(new e0(this, 18));
        }
        return this;
    }

    @Override // e1.a
    public final l1.d n() {
        return this.A;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i3;
        this.f14192z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i3 = this.f14169a) > 0) {
            view.setId(i3);
        }
        k kVar = this.f14181n;
        kVar.f14153k = true;
        kVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f14177j == c9) {
            return this;
        }
        this.f14177j = Character.toLowerCase(c9);
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z5) {
        int i3 = this.f14190x;
        int i10 = (z5 ? 1 : 0) | (i3 & (-2));
        this.f14190x = i10;
        if (i3 != i10) {
            this.f14181n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z5) {
        int i3 = this.f14190x;
        if ((i3 & 4) == 0) {
            int i10 = (i3 & (-3)) | (z5 ? 2 : 0);
            this.f14190x = i10;
            if (i3 != i10) {
                this.f14181n.p(false);
            }
            return this;
        }
        k kVar = this.f14181n;
        kVar.getClass();
        ArrayList arrayList = kVar.f14148f;
        int size = arrayList.size();
        kVar.y();
        for (int i11 = 0; i11 < size; i11++) {
            m mVar = (m) arrayList.get(i11);
            if (mVar.f14170b == this.f14170b && (mVar.f14190x & 4) != 0 && mVar.isCheckable()) {
                boolean z6 = mVar == this;
                int i12 = mVar.f14190x;
                int i13 = (z6 ? 2 : 0) | (i12 & (-3));
                mVar.f14190x = i13;
                if (i12 != i13) {
                    mVar.f14181n.p(false);
                }
            }
        }
        kVar.x();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z5) {
        if (z5) {
            this.f14190x |= 16;
        } else {
            this.f14190x &= -17;
        }
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f14180m = 0;
        this.f14179l = drawable;
        this.f14189w = true;
        this.f14181n.p(false);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f14185s = colorStateList;
        this.f14187u = true;
        this.f14189w = true;
        this.f14181n.p(false);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f14186t = mode;
        this.f14188v = true;
        this.f14189w = true;
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f14174g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f14175h == c9) {
            return this;
        }
        this.f14175h = c9;
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f14183p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f14175h = c9;
        this.f14177j = Character.toLowerCase(c10);
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i3) {
        int i10 = i3 & 3;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f14191y = i3;
        k kVar = this.f14181n;
        kVar.f14153k = true;
        kVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.f14181n.p(false);
        d0 d0Var = this.f14182o;
        if (d0Var != null) {
            d0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f14173f = charSequence;
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z5) {
        int i3 = this.f14190x;
        int i10 = (z5 ? 0 : 8) | (i3 & (-9));
        this.f14190x = i10;
        if (i3 != i10) {
            k kVar = this.f14181n;
            kVar.f14150h = true;
            kVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // e1.a, android.view.MenuItem
    public final e1.a setContentDescription(CharSequence charSequence) {
        this.f14184q = charSequence;
        this.f14181n.p(false);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final e1.a setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.f14181n.p(false);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i3) {
        if (this.f14177j == c9 && this.f14178k == i3) {
            return this;
        }
        this.f14177j = Character.toLowerCase(c9);
        this.f14178k = KeyEvent.normalizeMetaState(i3);
        this.f14181n.p(false);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i3) {
        if (this.f14175h == c9 && this.f14176i == i3) {
            return this;
        }
        this.f14175h = c9;
        this.f14176i = KeyEvent.normalizeMetaState(i3);
        this.f14181n.p(false);
        return this;
    }

    @Override // e1.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i3, int i10) {
        this.f14175h = c9;
        this.f14176i = KeyEvent.normalizeMetaState(i3);
        this.f14177j = Character.toLowerCase(c10);
        this.f14178k = KeyEvent.normalizeMetaState(i10);
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i3) {
        this.f14179l = null;
        this.f14180m = i3;
        this.f14189w = true;
        this.f14181n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i3) {
        setTitle(this.f14181n.f14144a.getString(i3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i3) {
        int i10;
        Context context = this.f14181n.f14144a;
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) new LinearLayout(context), false);
        this.f14192z = inflate;
        this.A = null;
        if (inflate != null && inflate.getId() == -1 && (i10 = this.f14169a) > 0) {
            inflate.setId(i10);
        }
        k kVar = this.f14181n;
        kVar.f14153k = true;
        kVar.p(true);
        return this;
    }
}
