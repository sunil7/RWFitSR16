package g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import h.r;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import l1.q;

/* loaded from: classes.dex */
public final class h {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ i E;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f13706a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13712h;

    /* renamed from: i, reason: collision with root package name */
    public int f13713i;

    /* renamed from: j, reason: collision with root package name */
    public int f13714j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f13715k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f13716l;

    /* renamed from: m, reason: collision with root package name */
    public int f13717m;

    /* renamed from: n, reason: collision with root package name */
    public char f13718n;

    /* renamed from: o, reason: collision with root package name */
    public int f13719o;

    /* renamed from: p, reason: collision with root package name */
    public char f13720p;

    /* renamed from: q, reason: collision with root package name */
    public int f13721q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13722s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13723t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13724u;

    /* renamed from: v, reason: collision with root package name */
    public int f13725v;

    /* renamed from: w, reason: collision with root package name */
    public int f13726w;

    /* renamed from: x, reason: collision with root package name */
    public String f13727x;

    /* renamed from: y, reason: collision with root package name */
    public String f13728y;

    /* renamed from: z, reason: collision with root package name */
    public l1.d f13729z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;

    /* renamed from: b, reason: collision with root package name */
    public int f13707b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f13708c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f13709d = 0;
    public int e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13710f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13711g = true;

    public h(i iVar, Menu menu) {
        this.E = iVar;
        this.f13706a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.f13733c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z5 = false;
        menuItem.setChecked(this.f13722s).setVisible(this.f13723t).setEnabled(this.f13724u).setCheckable(this.r >= 1).setTitleCondensed(this.f13716l).setIcon(this.f13717m);
        int i3 = this.f13725v;
        if (i3 >= 0) {
            menuItem.setShowAsAction(i3);
        }
        String str = this.f13728y;
        i iVar = this.E;
        if (str != null) {
            if (iVar.f13733c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (iVar.f13734d == null) {
                iVar.f13734d = i.a(iVar.f13733c);
            }
            Object obj = iVar.f13734d;
            String str2 = this.f13728y;
            g gVar = new g();
            gVar.f13704a = obj;
            Class<?> cls = obj.getClass();
            try {
                gVar.f13705b = cls.getMethod(str2, g.f13703c);
                menuItem.setOnMenuItemClickListener(gVar);
            } catch (Exception e) {
                StringBuilder r = android.support.v4.media.session.e.r("Couldn't resolve menu item onClick handler ", str2, " in class ");
                r.append(cls.getName());
                InflateException inflateException = new InflateException(r.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.r >= 2) {
            if (menuItem instanceof h.m) {
                ((h.m) menuItem).d(true);
            } else if (menuItem instanceof r) {
                r rVar = (r) menuItem;
                try {
                    Method method = rVar.f14202d;
                    e1.a aVar = rVar.f14201c;
                    if (method == null) {
                        rVar.f14202d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    rVar.f14202d.invoke(aVar, Boolean.TRUE);
                } catch (Exception e10) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
                }
            }
        }
        String str3 = this.f13727x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, i.e, iVar.f13731a));
            z5 = true;
        }
        int i10 = this.f13726w;
        if (i10 > 0) {
            if (z5) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i10);
            }
        }
        l1.d dVar = this.f13729z;
        if (dVar != null) {
            if (menuItem instanceof e1.a) {
                ((e1.a) menuItem).l(dVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z6 = menuItem instanceof e1.a;
        if (z6) {
            ((e1.a) menuItem).setContentDescription(charSequence);
        } else {
            q.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z6) {
            ((e1.a) menuItem).setTooltipText(charSequence2);
        } else {
            q.m(menuItem, charSequence2);
        }
        char c9 = this.f13718n;
        int i11 = this.f13719o;
        if (z6) {
            ((e1.a) menuItem).setAlphabeticShortcut(c9, i11);
        } else {
            q.g(menuItem, c9, i11);
        }
        char c10 = this.f13720p;
        int i12 = this.f13721q;
        if (z6) {
            ((e1.a) menuItem).setNumericShortcut(c10, i12);
        } else {
            q.k(menuItem, c10, i12);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z6) {
                ((e1.a) menuItem).setIconTintMode(mode);
            } else {
                q.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z6) {
                ((e1.a) menuItem).setIconTintList(colorStateList);
            } else {
                q.i(menuItem, colorStateList);
            }
        }
    }
}
