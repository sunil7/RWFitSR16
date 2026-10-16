package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.b1;

/* loaded from: classes.dex */
public class k implements Menu {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f14143y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f14144a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f14145b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14146c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14147d;
    public i e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f14148f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f14149g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14150h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f14151i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f14152j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14153k;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f14155m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f14156n;

    /* renamed from: o, reason: collision with root package name */
    public View f14157o;

    /* renamed from: v, reason: collision with root package name */
    public m f14163v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14165x;

    /* renamed from: l, reason: collision with root package name */
    public int f14154l = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14158p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14159q = false;
    public boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14160s = false;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f14161t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f14162u = new CopyOnWriteArrayList();

    /* renamed from: w, reason: collision with root package name */
    public boolean f14164w = false;

    public k(Context context) {
        boolean z5;
        boolean z6 = false;
        this.f14144a = context;
        Resources resources = context.getResources();
        this.f14145b = resources;
        this.f14148f = new ArrayList();
        this.f14149g = new ArrayList();
        this.f14150h = true;
        this.f14151i = new ArrayList();
        this.f14152j = new ArrayList();
        this.f14153k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            if (Build.VERSION.SDK_INT >= 28) {
                z5 = b1.b(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z5 = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z5) {
                z6 = true;
            }
        }
        this.f14147d = z6;
    }

    public m a(int i3, int i10, int i11, CharSequence charSequence) {
        int i12;
        int i13 = ((-65536) & i11) >> 16;
        if (i13 < 0 || i13 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i14 = (f14143y[i13] << 16) | (65535 & i11);
        m mVar = new m(this, i3, i10, i11, i14, charSequence, this.f14154l);
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i12 = 0;
                break;
            }
            if (((m) arrayList.get(size)).f14172d <= i14) {
                i12 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i12, mVar);
        p(true);
        return mVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i3, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        int i13;
        PackageManager packageManager = this.f14144a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i12 & 1) == 0) {
            removeGroup(i3);
        }
        for (int i14 = 0; i14 < size; i14++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i14);
            int i15 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i15 < 0 ? intent : intentArr[i15]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            m a3 = a(i3, i10, i11, resolveInfo.loadLabel(packageManager));
            a3.setIcon(resolveInfo.loadIcon(packageManager));
            a3.f14174g = intent2;
            if (menuItemArr != null && (i13 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i13] = a3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(x xVar, Context context) {
        this.f14162u.add(new WeakReference(xVar));
        xVar.h(context, this);
        this.f14153k = true;
    }

    public final void c(boolean z5) {
        if (this.f14160s) {
            return;
        }
        this.f14160s = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar = (x) weakReference.get();
            if (xVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                xVar.b(this, z5);
            }
        }
        this.f14160s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        m mVar = this.f14163v;
        if (mVar != null) {
            d(mVar);
        }
        this.f14148f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f14156n = null;
        this.f14155m = null;
        this.f14157o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(m mVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
        boolean z5 = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f14163v == mVar) {
            y();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z5 = xVar.l(mVar);
                    if (z5) {
                        break;
                    }
                }
            }
            x();
            if (z5) {
                this.f14163v = null;
            }
        }
        return z5;
    }

    public boolean e(k kVar, MenuItem menuItem) {
        i iVar = this.e;
        return iVar != null && iVar.d(kVar, menuItem);
    }

    public boolean f(m mVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
        boolean z5 = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        y();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar = (x) weakReference.get();
            if (xVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z5 = xVar.k(mVar);
                if (z5) {
                    break;
                }
            }
        }
        x();
        if (z5) {
            this.f14163v = mVar;
        }
        return z5;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i3) {
        MenuItem findItem;
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f14169a == i3) {
                return mVar;
            }
            if (mVar.hasSubMenu() && (findItem = mVar.f14182o.findItem(i3)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final m g(int i3, KeyEvent keyEvent) {
        ArrayList arrayList = this.f14161t;
        arrayList.clear();
        h(arrayList, i3, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (m) arrayList.get(0);
        }
        boolean n4 = n();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            char c9 = n4 ? mVar.f14177j : mVar.f14175h;
            char[] cArr = keyData.meta;
            if ((c9 == cArr[0] && (metaState & 2) == 0) || ((c9 == cArr[2] && (metaState & 2) != 0) || (n4 && c9 == '\b' && i3 == 67))) {
                return mVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i3) {
        return (MenuItem) this.f14148f.get(i3);
    }

    public final void h(ArrayList arrayList, int i3, KeyEvent keyEvent) {
        boolean n4 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i3 == 67) {
            ArrayList arrayList2 = this.f14148f;
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                m mVar = (m) arrayList2.get(i10);
                if (mVar.hasSubMenu()) {
                    mVar.f14182o.h(arrayList, i3, keyEvent);
                }
                char c9 = n4 ? mVar.f14177j : mVar.f14175h;
                if ((modifiers & 69647) == ((n4 ? mVar.f14178k : mVar.f14176i) & 69647) && c9 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c9 == cArr[0] || c9 == cArr[2] || (n4 && c9 == '\b' && i3 == 67)) && mVar.isEnabled()) {
                        arrayList.add(mVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f14165x) {
            return true;
        }
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((m) arrayList.get(i3)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList l3 = l();
        if (this.f14153k) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z5 |= xVar.i();
                }
            }
            ArrayList arrayList = this.f14151i;
            ArrayList arrayList2 = this.f14152j;
            if (z5) {
                arrayList.clear();
                arrayList2.clear();
                int size = l3.size();
                for (int i3 = 0; i3 < size; i3++) {
                    m mVar = (m) l3.get(i3);
                    if ((mVar.f14190x & 32) == 32) {
                        arrayList.add(mVar);
                    } else {
                        arrayList2.add(mVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f14153k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return g(i3, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public k k() {
        return this;
    }

    public final ArrayList l() {
        boolean z5 = this.f14150h;
        ArrayList arrayList = this.f14149g;
        if (!z5) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f14148f;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = (m) arrayList2.get(i3);
            if (mVar.isVisible()) {
                arrayList.add(mVar);
            }
        }
        this.f14150h = false;
        this.f14153k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f14164w;
    }

    public boolean n() {
        return this.f14146c;
    }

    public boolean o() {
        return this.f14147d;
    }

    public void p(boolean z5) {
        if (this.f14158p) {
            this.f14159q = true;
            if (z5) {
                this.r = true;
                return;
            }
            return;
        }
        if (z5) {
            this.f14150h = true;
            this.f14153k = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        y();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar = (x) weakReference.get();
            if (xVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                xVar.g(z5);
            }
        }
        x();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i3, int i10) {
        return q(findItem(i3), null, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i3, KeyEvent keyEvent, int i10) {
        m g10 = g(i3, keyEvent);
        boolean q5 = g10 != null ? q(g10, null, i10) : false;
        if ((i10 & 2) != 0) {
            c(true);
        }
        return q5;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, h.x r8, int r9) {
        /*
            r6 = this;
            h.m r7 = (h.m) r7
            r0 = 0
            if (r7 == 0) goto Ldb
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Ldb
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f14183p
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L1a
        L18:
            r1 = r2
            goto L45
        L1a:
            h.k r1 = r7.f14181n
            boolean r3 = r1.e(r1, r7)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r7.f14174g
            if (r3 == 0) goto L35
            android.content.Context r1 = r1.f14144a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L18
        L2d:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L35:
            l1.d r1 = r7.A
            if (r1 == 0) goto L44
            h.n r1 = (h.n) r1
            android.view.ActionProvider r1 = r1.f14193b
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L44
            goto L18
        L44:
            r1 = r0
        L45:
            l1.d r3 = r7.A
            if (r3 == 0) goto L56
            r4 = r3
            h.n r4 = (h.n) r4
            android.view.ActionProvider r4 = r4.f14193b
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L56
            r4 = r2
            goto L57
        L56:
            r4 = r0
        L57:
            boolean r5 = r7.c()
            if (r5 == 0) goto L69
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Lda
            r6.c(r2)
            goto Lda
        L69:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L7a
            if (r4 == 0) goto L72
            goto L7a
        L72:
            r7 = r9 & 1
            if (r7 != 0) goto Lda
            r6.c(r2)
            goto Lda
        L7a:
            r9 = r9 & 4
            if (r9 != 0) goto L81
            r6.c(r0)
        L81:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L95
            h.d0 r9 = new h.d0
            android.content.Context r5 = r6.f14144a
            r9.<init>(r5, r6, r7)
            r7.f14182o = r9
            java.lang.CharSequence r5 = r7.e
            r9.setHeaderTitle(r5)
        L95:
            h.d0 r7 = r7.f14182o
            if (r4 == 0) goto La2
            h.n r3 = (h.n) r3
            h.r r9 = r3.f14194c
            android.view.ActionProvider r9 = r3.f14193b
            r9.onPrepareSubMenu(r7)
        La2:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f14162u
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto Lab
            goto Ld4
        Lab:
            if (r8 == 0) goto Lb1
            boolean r0 = r8.m(r7)
        Lb1:
            java.util.Iterator r8 = r9.iterator()
        Lb5:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Ld4
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            h.x r4 = (h.x) r4
            if (r4 != 0) goto Lcd
            r9.remove(r3)
            goto Lb5
        Lcd:
            if (r0 != 0) goto Lb5
            boolean r0 = r4.m(r7)
            goto Lb5
        Ld4:
            r1 = r1 | r0
            if (r1 != 0) goto Lda
            r6.c(r2)
        Lda:
            return r1
        Ldb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.k.q(android.view.MenuItem, h.x, int):boolean");
    }

    public final void r(x xVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar2 = (x) weakReference.get();
            if (xVar2 == null || xVar2 == xVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i3) {
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (((m) arrayList.get(i11)).f14170b == i3) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            int size2 = arrayList.size() - i11;
            while (true) {
                int i12 = i10 + 1;
                if (i10 >= size2 || ((m) arrayList.get(i11)).f14170b != i3) {
                    break;
                }
                if (i11 >= 0) {
                    ArrayList arrayList2 = this.f14148f;
                    if (i11 < arrayList2.size()) {
                        arrayList2.remove(i11);
                    }
                }
                i10 = i12;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i3) {
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((m) arrayList.get(i10)).f14169a == i3) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            ArrayList arrayList2 = this.f14148f;
            if (i10 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i10);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f14148f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((d0) item.getSubMenu()).s(bundle);
            }
        }
        int i10 = bundle.getInt("android:menu:expandedactionview");
        if (i10 <= 0 || (findItem = findItem(i10)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i3, boolean z5, boolean z6) {
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f14170b == i3) {
                mVar.d(z6);
                mVar.setCheckable(z5);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z5) {
        this.f14164w = z5;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i3, boolean z5) {
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f14170b == i3) {
                mVar.setEnabled(z5);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i3, boolean z5) {
        ArrayList arrayList = this.f14148f;
        int size = arrayList.size();
        boolean z6 = false;
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f14170b == i3) {
                int i11 = mVar.f14190x;
                int i12 = (i11 & (-9)) | (z5 ? 0 : 8);
                mVar.f14190x = i12;
                if (i11 != i12) {
                    z6 = true;
                }
            }
        }
        if (z6) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z5) {
        this.f14146c = z5;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f14148f.size();
    }

    public final void t(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                x xVar = (x) weakReference.get();
                if (xVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id2 = xVar.getId();
                    if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                        xVar.e(parcelable);
                    }
                }
            }
        }
    }

    public final void u(Bundle bundle) {
        int size = this.f14148f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((d0) item.getSubMenu()).u(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void v(Bundle bundle) {
        Parcelable j4;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14162u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            x xVar = (x) weakReference.get();
            if (xVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id2 = xVar.getId();
                if (id2 > 0 && (j4 = xVar.j()) != null) {
                    sparseArray.put(id2, j4);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public final void w(int i3, CharSequence charSequence, int i10, Drawable drawable, View view) {
        if (view != null) {
            this.f14157o = view;
            this.f14155m = null;
            this.f14156n = null;
        } else {
            if (i3 > 0) {
                this.f14155m = this.f14145b.getText(i3);
            } else if (charSequence != null) {
                this.f14155m = charSequence;
            }
            if (i10 > 0) {
                this.f14156n = a1.c.b(this.f14144a, i10);
            } else if (drawable != null) {
                this.f14156n = drawable;
            }
            this.f14157o = null;
        }
        p(false);
    }

    public final void x() {
        this.f14158p = false;
        if (this.f14159q) {
            this.f14159q = false;
            p(this.r);
        }
    }

    public final void y() {
        if (this.f14158p) {
            return;
        }
        this.f14158p = true;
        this.f14159q = false;
        this.r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3) {
        return a(0, 0, 0, this.f14145b.getString(i3));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3) {
        return addSubMenu(0, 0, 0, this.f14145b.getString(i3));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i10, int i11, CharSequence charSequence) {
        return a(i3, i10, i11, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i10, int i11, CharSequence charSequence) {
        m a3 = a(i3, i10, i11, charSequence);
        d0 d0Var = new d0(this.f14144a, this, a3);
        a3.f14182o = d0Var;
        d0Var.setHeaderTitle(a3.e);
        return d0Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i10, int i11, int i12) {
        return a(i3, i10, i11, this.f14145b.getString(i12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3, int i10, int i11, int i12) {
        return addSubMenu(i3, i10, i11, this.f14145b.getString(i12));
    }
}
