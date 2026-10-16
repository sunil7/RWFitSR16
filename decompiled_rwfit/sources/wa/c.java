package wa;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.android.material.R$animator;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.WeakHashMap;
import l1.i0;
import l1.z0;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: g, reason: collision with root package name */
    public final f f19544g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f19545h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f19546i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ExtendedFloatingActionButton extendedFloatingActionButton, mc.g gVar, f fVar, boolean z5) {
        super(extendedFloatingActionButton, gVar);
        this.f19546i = extendedFloatingActionButton;
        this.f19544g = fVar;
        this.f19545h = z5;
    }

    @Override // wa.a
    public final AnimatorSet a() {
        ja.e eVar = this.f19528f;
        if (eVar == null) {
            if (this.e == null) {
                this.e = ja.e.b(this.f19524a, c());
            }
            eVar = this.e;
            eVar.getClass();
        }
        boolean g10 = eVar.g("width");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19546i;
        f fVar = this.f19544g;
        if (g10) {
            PropertyValuesHolder[] e = eVar.e("width");
            e[0].setFloatValues(extendedFloatingActionButton.getWidth(), fVar.getWidth());
            eVar.h("width", e);
        }
        if (eVar.g("height")) {
            PropertyValuesHolder[] e10 = eVar.e("height");
            e10[0].setFloatValues(extendedFloatingActionButton.getHeight(), fVar.getHeight());
            eVar.h("height", e10);
        }
        if (eVar.g("paddingStart")) {
            PropertyValuesHolder[] e11 = eVar.e("paddingStart");
            PropertyValuesHolder propertyValuesHolder = e11[0];
            WeakHashMap weakHashMap = z0.f15748a;
            propertyValuesHolder.setFloatValues(i0.f(extendedFloatingActionButton), fVar.x());
            eVar.h("paddingStart", e11);
        }
        if (eVar.g("paddingEnd")) {
            PropertyValuesHolder[] e12 = eVar.e("paddingEnd");
            PropertyValuesHolder propertyValuesHolder2 = e12[0];
            WeakHashMap weakHashMap2 = z0.f15748a;
            propertyValuesHolder2.setFloatValues(i0.e(extendedFloatingActionButton), fVar.u());
            eVar.h("paddingEnd", e12);
        }
        if (eVar.g("labelOpacity")) {
            PropertyValuesHolder[] e13 = eVar.e("labelOpacity");
            boolean z5 = this.f19545h;
            e13[0].setFloatValues(z5 ? 0.0f : 1.0f, z5 ? 1.0f : 0.0f);
            eVar.h("labelOpacity", e13);
        }
        return b(eVar);
    }

    @Override // wa.a
    public final int c() {
        return this.f19545h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
    }

    @Override // wa.a
    public final void e() {
        this.f19527d.f16022b = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19546i;
        extendedFloatingActionButton.D = false;
        extendedFloatingActionButton.setHorizontallyScrolling(false);
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        f fVar = this.f19544g;
        layoutParams.width = fVar.K().width;
        layoutParams.height = fVar.K().height;
    }

    @Override // wa.a
    public final void f(Animator animator) {
        mc.g gVar = this.f19527d;
        Animator animator2 = (Animator) gVar.f16022b;
        if (animator2 != null) {
            animator2.cancel();
        }
        gVar.f16022b = animator;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19546i;
        extendedFloatingActionButton.C = this.f19545h;
        extendedFloatingActionButton.D = true;
        extendedFloatingActionButton.setHorizontallyScrolling(true);
    }

    @Override // wa.a
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19546i;
        extendedFloatingActionButton.C = this.f19545h;
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        f fVar = this.f19544g;
        layoutParams.width = fVar.K().width;
        layoutParams.height = fVar.K().height;
        int x10 = fVar.x();
        int paddingTop = extendedFloatingActionButton.getPaddingTop();
        int u10 = fVar.u();
        int paddingBottom = extendedFloatingActionButton.getPaddingBottom();
        WeakHashMap weakHashMap = z0.f15748a;
        i0.k(extendedFloatingActionButton, x10, paddingTop, u10, paddingBottom);
        extendedFloatingActionButton.requestLayout();
    }

    @Override // wa.a
    public final boolean h() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19546i;
        return this.f19545h == extendedFloatingActionButton.C || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(extendedFloatingActionButton.getText());
    }
}
