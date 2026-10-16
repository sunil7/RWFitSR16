package h;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class o extends FrameLayout implements g.b {

    /* renamed from: a, reason: collision with root package name */
    public final CollapsibleActionView f14196a;

    /* JADX WARN: Multi-variable type inference failed */
    public o(View view) {
        super(view.getContext());
        this.f14196a = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // g.b
    public final void c() {
        this.f14196a.onActionViewExpanded();
    }

    @Override // g.b
    public final void e() {
        this.f14196a.onActionViewCollapsed();
    }
}
