package l1;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class z implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f15745a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f15746b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f15747c;

    public z(View view, Runnable runnable) {
        this.f15745a = view;
        this.f15746b = view.getViewTreeObserver();
        this.f15747c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        z zVar = new z(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(zVar);
        view.addOnAttachStateChangeListener(zVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean isAlive = this.f15746b.isAlive();
        View view = this.f15745a;
        if (isAlive) {
            this.f15746b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f15747c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f15746b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f15746b.isAlive();
        View view2 = this.f15745a;
        if (isAlive) {
            this.f15746b.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
