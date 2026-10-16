package h;

import android.view.ActionProvider;
import android.view.View;
import com.example.test.ui.device.activity.e0;

/* loaded from: classes.dex */
public final class n extends l1.d implements ActionProvider.VisibilityListener {

    /* renamed from: b, reason: collision with root package name */
    public final ActionProvider f14193b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f14194c;

    /* renamed from: d, reason: collision with root package name */
    public e0 f14195d;

    public n(r rVar, ActionProvider actionProvider) {
        this.f14194c = rVar;
        this.f14193b = actionProvider;
    }

    @Override // l1.d
    public final boolean a() {
        return this.f14193b.isVisible();
    }

    @Override // l1.d
    public final View b(m mVar) {
        return this.f14193b.onCreateActionView(mVar);
    }

    @Override // l1.d
    public final boolean c() {
        return this.f14193b.overridesItemVisibility();
    }

    @Override // l1.d
    public final void d(e0 e0Var) {
        this.f14195d = e0Var;
        this.f14193b.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z5) {
        e0 e0Var = this.f14195d;
        if (e0Var != null) {
            k kVar = ((m) e0Var.f7855b).f14181n;
            kVar.f14150h = true;
            kVar.p(true);
        }
    }
}
