package androidx.appcompat.app;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class w implements Window.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Window.Callback f569a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f570b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f571c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f572d;
    public final /* synthetic */ c0 e;

    public w(c0 c0Var, Window.Callback callback) {
        this.e = c0Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f569a = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f570b = true;
            callback.onContentChanged();
        } finally {
            this.f570b = false;
        }
    }

    public final boolean b(int i3, Menu menu) {
        return this.f569a.onMenuOpened(i3, menu);
    }

    public final void c(int i3, Menu menu) {
        this.f569a.onPanelClosed(i3, menu);
    }

    public final void d(List list, Menu menu, int i3) {
        g.l.a(this.f569a, list, menu, i3);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f569a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z5 = this.f571c;
        Window.Callback callback = this.f569a;
        return z5 ? callback.dispatchKeyEvent(keyEvent) : this.e.u(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r7 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (r0 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e A[RETURN] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            android.view.Window$Callback r0 = r6.f569a
            boolean r0 = r0.dispatchKeyShortcutEvent(r7)
            r1 = 1
            if (r0 != 0) goto L6f
            int r0 = r7.getKeyCode()
            androidx.appcompat.app.c0 r2 = r6.e
            r2.A()
            androidx.appcompat.app.p0 r3 = r2.f436o
            r4 = 0
            if (r3 == 0) goto L3d
            androidx.appcompat.app.o0 r3 = r3.f547i
            if (r3 != 0) goto L1d
        L1b:
            r0 = r4
            goto L39
        L1d:
            h.k r3 = r3.f527d
            if (r3 == 0) goto L1b
            int r5 = r7.getDeviceId()
            android.view.KeyCharacterMap r5 = android.view.KeyCharacterMap.load(r5)
            int r5 = r5.getKeyboardType()
            if (r5 == r1) goto L31
            r5 = r1
            goto L32
        L31:
            r5 = r4
        L32:
            r3.setQwertyMode(r5)
            boolean r0 = r3.performShortcut(r0, r7, r4)
        L39:
            if (r0 == 0) goto L3d
        L3b:
            r7 = r1
            goto L6b
        L3d:
            androidx.appcompat.app.b0 r0 = r2.M
            if (r0 == 0) goto L52
            int r3 = r7.getKeyCode()
            boolean r0 = r2.F(r0, r3, r7)
            if (r0 == 0) goto L52
            androidx.appcompat.app.b0 r7 = r2.M
            if (r7 == 0) goto L3b
            r7.f414l = r1
            goto L3b
        L52:
            androidx.appcompat.app.b0 r0 = r2.M
            if (r0 != 0) goto L6a
            androidx.appcompat.app.b0 r0 = r2.z(r4)
            r2.G(r0, r7)
            int r3 = r7.getKeyCode()
            boolean r7 = r2.F(r0, r3, r7)
            r0.f413k = r4
            if (r7 == 0) goto L6a
            goto L3b
        L6a:
            r7 = r4
        L6b:
            if (r7 == 0) goto L6e
            goto L6f
        L6e:
            return r4
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.w.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f569a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f569a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f569a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f569a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f569a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f569a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f570b) {
            this.f569a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0 || (menu instanceof h.k)) {
            return this.f569a.onCreatePanelMenu(i3, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i3) {
        return this.f569a.onCreatePanelView(i3);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f569a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        return this.f569a.onMenuItemSelected(i3, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i3, Menu menu) {
        b(i3, menu);
        c0 c0Var = this.e;
        if (i3 != 108) {
            c0Var.getClass();
            return true;
        }
        c0Var.A();
        p0 p0Var = c0Var.f436o;
        if (p0Var != null && true != p0Var.f550l) {
            p0Var.f550l = true;
            ArrayList arrayList = p0Var.f551m;
            if (arrayList.size() > 0) {
                throw android.support.v4.media.session.e.c(0, arrayList);
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i3, Menu menu) {
        if (this.f572d) {
            this.f569a.onPanelClosed(i3, menu);
            return;
        }
        c(i3, menu);
        c0 c0Var = this.e;
        if (i3 != 108) {
            if (i3 != 0) {
                c0Var.getClass();
                return;
            }
            b0 z5 = c0Var.z(i3);
            if (z5.f415m) {
                c0Var.s(z5, false);
                return;
            }
            return;
        }
        c0Var.A();
        p0 p0Var = c0Var.f436o;
        if (p0Var == null || !p0Var.f550l) {
            return;
        }
        p0Var.f550l = false;
        ArrayList arrayList = p0Var.f551m;
        if (arrayList.size() > 0) {
            throw android.support.v4.media.session.e.c(0, arrayList);
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z5) {
        g.m.a(this.f569a, z5);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i3, View view, Menu menu) {
        h.k kVar = menu instanceof h.k ? (h.k) menu : null;
        if (i3 == 0 && kVar == null) {
            return false;
        }
        if (kVar != null) {
            kVar.f14165x = true;
        }
        boolean onPreparePanel = this.f569a.onPreparePanel(i3, view, menu);
        if (kVar != null) {
            kVar.f14165x = false;
        }
        return onPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i3) {
        h.k kVar = this.e.z(0).f410h;
        if (kVar != null) {
            d(list, kVar, i3);
        } else {
            d(list, menu, i3);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return g.k.a(this.f569a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f569a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z5) {
        this.f569a.onWindowFocusChanged(z5);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f569a.onSearchRequested();
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01bd  */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10, int r11) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.w.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
    }
}
