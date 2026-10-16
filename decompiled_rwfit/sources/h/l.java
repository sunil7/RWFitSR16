package h;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class l implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, w {

    /* renamed from: a, reason: collision with root package name */
    public d0 f14166a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.j f14167b;

    /* renamed from: c, reason: collision with root package name */
    public g f14168c;

    @Override // h.w
    public final void b(k kVar, boolean z5) {
        androidx.appcompat.app.j jVar;
        if ((z5 || kVar == this.f14166a) && (jVar = this.f14167b) != null) {
            jVar.dismiss();
        }
    }

    @Override // h.w
    public final boolean c(k kVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        g gVar = this.f14168c;
        if (gVar.f14137g == null) {
            gVar.f14137g = new f(gVar);
        }
        this.f14166a.q(gVar.f14137g.getItem(i3), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f14168c.b(this.f14166a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        d0 d0Var = this.f14166a;
        if (i3 == 82 || i3 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f14167b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f14167b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                d0Var.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return d0Var.performShortcut(i3, keyEvent, 0);
    }
}
