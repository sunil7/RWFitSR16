package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class n0 implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f1000b;

    public n0(o0 o0Var, s sVar) {
        this.f1000b = o0Var;
        this.f999a = sVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f1000b.G.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f999a);
        }
    }
}
