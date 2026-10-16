package wa;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import com.google.android.material.R$color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class p extends n {
    @Override // wa.n
    public final float d() {
        return this.f19586x.getElevation();
    }

    @Override // wa.n
    public final void e(Rect rect) {
        if (((FloatingActionButton) this.f19587y.f16022b).f10504k) {
            super.e(rect);
            return;
        }
        if (this.f19569f) {
            FloatingActionButton floatingActionButton = this.f19586x;
            int sizeDimension = floatingActionButton.getSizeDimension();
            int i3 = this.f19574k;
            if (sizeDimension < i3) {
                int sizeDimension2 = (i3 - floatingActionButton.getSizeDimension()) / 2;
                rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override // wa.n
    public final void f(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i3) {
        Drawable drawable;
        eb.m mVar = this.f19565a;
        mVar.getClass();
        o oVar = new o(mVar);
        this.f19566b = oVar;
        oVar.setTintList(colorStateList);
        if (mode != null) {
            this.f19566b.setTintMode(mode);
        }
        eb.h hVar = this.f19566b;
        FloatingActionButton floatingActionButton = this.f19586x;
        hVar.j(floatingActionButton.getContext());
        if (i3 > 0) {
            Context context = floatingActionButton.getContext();
            eb.m mVar2 = this.f19565a;
            mVar2.getClass();
            b bVar = new b(mVar2);
            int a3 = a1.d.a(context, R$color.design_fab_stroke_top_outer_color);
            int a10 = a1.d.a(context, R$color.design_fab_stroke_top_inner_color);
            int a11 = a1.d.a(context, R$color.design_fab_stroke_end_inner_color);
            int a12 = a1.d.a(context, R$color.design_fab_stroke_end_outer_color);
            bVar.f19536i = a3;
            bVar.f19537j = a10;
            bVar.f19538k = a11;
            bVar.f19539l = a12;
            float f2 = i3;
            if (bVar.f19535h != f2) {
                bVar.f19535h = f2;
                bVar.f19530b.setStrokeWidth(f2 * 1.3333f);
                bVar.f19541n = true;
                bVar.invalidateSelf();
            }
            if (colorStateList != null) {
                bVar.f19540m = colorStateList.getColorForState(bVar.getState(), bVar.f19540m);
            }
            bVar.f19543p = colorStateList;
            bVar.f19541n = true;
            bVar.invalidateSelf();
            this.f19568d = bVar;
            b bVar2 = this.f19568d;
            bVar2.getClass();
            eb.h hVar2 = this.f19566b;
            hVar2.getClass();
            drawable = new LayerDrawable(new Drawable[]{bVar2, hVar2});
        } else {
            this.f19568d = null;
            drawable = this.f19566b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(cb.a.b(colorStateList2), drawable, null);
        this.f19567c = rippleDrawable;
        this.e = rippleDrawable;
    }

    @Override // wa.n
    public final void g() {
    }

    @Override // wa.n
    public final void h() {
        q();
    }

    @Override // wa.n
    public final void i(int[] iArr) {
    }

    @Override // wa.n
    public final void j(float f2, float f10, float f11) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(n.F, r(f2, f11));
        stateListAnimator.addState(n.G, r(f2, f10));
        stateListAnimator.addState(n.H, r(f2, f10));
        stateListAnimator.addState(n.I, r(f2, f10));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        float[] fArr = {f2};
        FloatingActionButton floatingActionButton = this.f19586x;
        arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(n.E);
        stateListAnimator.addState(n.J, animatorSet);
        stateListAnimator.addState(n.K, r(0.0f, 0.0f));
        floatingActionButton.setStateListAnimator(stateListAnimator);
        if (o()) {
            q();
        }
    }

    @Override // wa.n
    public final void m(ColorStateList colorStateList) {
        Drawable drawable = this.f19567c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(cb.a.b(colorStateList));
        } else {
            super.m(colorStateList);
        }
    }

    @Override // wa.n
    public final boolean o() {
        if (((FloatingActionButton) this.f19587y.f16022b).f10504k) {
            return true;
        }
        return this.f19569f && this.f19586x.getSizeDimension() < this.f19574k;
    }

    @Override // wa.n
    public final void p() {
    }

    public final AnimatorSet r(float f2, float f10) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f2};
        FloatingActionButton floatingActionButton = this.f19586x;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f10).setDuration(100L));
        animatorSet.setInterpolator(n.E);
        return animatorSet;
    }
}
