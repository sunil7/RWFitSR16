package h;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14083a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f14084b;

    public /* synthetic */ c(s sVar, int i3) {
        this.f14083a = i3;
        this.f14084b = sVar;
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i3 = this.f14083a;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f14083a) {
            case 0:
                e eVar = (e) this.f14084b;
                ViewTreeObserver viewTreeObserver = eVar.f14127x;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        eVar.f14127x = view.getViewTreeObserver();
                    }
                    eVar.f14127x.removeGlobalOnLayoutListener(eVar.f14113i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                c0 c0Var = (c0) this.f14084b;
                ViewTreeObserver viewTreeObserver2 = c0Var.f14098o;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        c0Var.f14098o = view.getViewTreeObserver();
                    }
                    c0Var.f14098o.removeGlobalOnLayoutListener(c0Var.f14092i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }
}
