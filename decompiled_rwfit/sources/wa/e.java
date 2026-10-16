package wa;

import android.animation.Animator;
import com.google.android.material.R$animator;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f19549g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ExtendedFloatingActionButton extendedFloatingActionButton, mc.g gVar) {
        super(extendedFloatingActionButton, gVar);
        this.f19549g = extendedFloatingActionButton;
    }

    @Override // wa.a
    public final int c() {
        return R$animator.mtrl_extended_fab_show_motion_spec;
    }

    @Override // wa.a
    public final void e() {
        this.f19527d.f16022b = null;
        this.f19549g.f10485t = 0;
    }

    @Override // wa.a
    public final void f(Animator animator) {
        mc.g gVar = this.f19527d;
        Animator animator2 = (Animator) gVar.f16022b;
        if (animator2 != null) {
            animator2.cancel();
        }
        gVar.f16022b = animator;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19549g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.f10485t = 2;
    }

    @Override // wa.a
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19549g;
        extendedFloatingActionButton.setVisibility(0);
        extendedFloatingActionButton.setAlpha(1.0f);
        extendedFloatingActionButton.setScaleY(1.0f);
        extendedFloatingActionButton.setScaleX(1.0f);
    }

    @Override // wa.a
    public final boolean h() {
        int i3 = ExtendedFloatingActionButton.G;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19549g;
        if (extendedFloatingActionButton.getVisibility() != 0) {
            if (extendedFloatingActionButton.f10485t != 2) {
                return false;
            }
        } else if (extendedFloatingActionButton.f10485t == 1) {
            return false;
        }
        return true;
    }
}
