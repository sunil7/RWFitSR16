package androidx.fragment.app;

import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class y0 implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f2323a;

    public y0(View view) {
        this.f2323a = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        View view2 = this.f2323a;
        view2.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.l0.c(view2);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
