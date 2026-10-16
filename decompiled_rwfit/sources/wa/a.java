package wa;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.nd;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19524a;

    /* renamed from: b, reason: collision with root package name */
    public final ExtendedFloatingActionButton f19525b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f19526c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final mc.g f19527d;
    public ja.e e;

    /* renamed from: f, reason: collision with root package name */
    public ja.e f19528f;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton, mc.g gVar) {
        this.f19525b = extendedFloatingActionButton;
        this.f19524a = extendedFloatingActionButton.getContext();
        this.f19527d = gVar;
    }

    public AnimatorSet a() {
        ja.e eVar = this.f19528f;
        if (eVar == null) {
            if (this.e == null) {
                this.e = ja.e.b(this.f19524a, c());
            }
            eVar = this.e;
            eVar.getClass();
        }
        return b(eVar);
    }

    public final AnimatorSet b(ja.e eVar) {
        ArrayList arrayList = new ArrayList();
        boolean g10 = eVar.g("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f19525b;
        if (g10) {
            arrayList.add(eVar.d("opacity", extendedFloatingActionButton, View.ALPHA));
        }
        if (eVar.g("scale")) {
            arrayList.add(eVar.d("scale", extendedFloatingActionButton, View.SCALE_Y));
            arrayList.add(eVar.d("scale", extendedFloatingActionButton, View.SCALE_X));
        }
        if (eVar.g("width")) {
            arrayList.add(eVar.d("width", extendedFloatingActionButton, ExtendedFloatingActionButton.H));
        }
        if (eVar.g("height")) {
            arrayList.add(eVar.d("height", extendedFloatingActionButton, ExtendedFloatingActionButton.I));
        }
        if (eVar.g("paddingStart")) {
            arrayList.add(eVar.d("paddingStart", extendedFloatingActionButton, ExtendedFloatingActionButton.J));
        }
        if (eVar.g("paddingEnd")) {
            arrayList.add(eVar.d("paddingEnd", extendedFloatingActionButton, ExtendedFloatingActionButton.K));
        }
        if (eVar.g("labelOpacity")) {
            arrayList.add(eVar.d("labelOpacity", extendedFloatingActionButton, new j2.b(this)));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        nd.a(animatorSet, arrayList);
        return animatorSet;
    }

    public abstract int c();

    public void d() {
        this.f19527d.f16022b = null;
    }

    public abstract void e();

    public abstract void f(Animator animator);

    public abstract void g();

    public abstract boolean h();
}
