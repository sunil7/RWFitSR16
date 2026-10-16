package wa;

import android.animation.Animator;
import com.google.android.material.R$animator;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: g, reason: collision with root package name */
    public boolean f19547g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f19548h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ExtendedFloatingActionButton extendedFloatingActionButton, mc.g gVar) {
        super(extendedFloatingActionButton, gVar);
        this.f19548h = extendedFloatingActionButton;
    }

    @Override // wa.a
    public final int c() {
        return R$animator.mtrl_extended_fab_hide_motion_spec;
    }

    @Override // wa.a
    public final void d() {
        super.d();
        this.f19547g = true;
    }

    @Override // wa.a
    public final void e() {
        this.f19527d.f16022b = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19548h;
        extendedFloatingActionButton.f10485t = 0;
        if (this.f19547g) {
            return;
        }
        extendedFloatingActionButton.setVisibility(8);
    }

    @Override // wa.a
    public final void f(Animator animator) {
        mc.g gVar = this.f19527d;
        Animator animator2 = (Animator) gVar.f16022b;
        if (animator2 != null) {
            animator2.cancel();
        }
        gVar.f16022b = animator;
        this.f19547g = false;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19548h;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.f10485t = 1;
    }

    @Override // wa.a
    public final void g() {
        this.f19548h.setVisibility(8);
    }

    @Override // wa.a
    public final boolean h() {
        int i3 = ExtendedFloatingActionButton.G;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19548h;
        if (extendedFloatingActionButton.getVisibility() == 0) {
            if (extendedFloatingActionButton.f10485t != 1) {
                return false;
            }
        } else if (extendedFloatingActionButton.f10485t == 2) {
            return false;
        }
        return true;
    }
}
