package j2;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;

/* loaded from: classes.dex */
public final class r0 extends g0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f15282a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f15283b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f15284c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f15285d;

    public r0(p pVar, ViewGroup viewGroup, View view, View view2) {
        this.f15285d = pVar;
        this.f15282a = viewGroup;
        this.f15283b = view;
        this.f15284c = view2;
    }

    @Override // j2.g0, j2.e0
    public final void b() {
        this.f15282a.getOverlay().remove(this.f15283b);
    }

    @Override // j2.g0, j2.e0
    public final void c() {
        View view = this.f15283b;
        if (view.getParent() == null) {
            this.f15282a.getOverlay().add(view);
        } else {
            this.f15285d.cancel();
        }
    }

    @Override // j2.e0
    public final void e(f0 f0Var) {
        this.f15284c.setTag(R$id.save_overlay_view, null);
        this.f15282a.getOverlay().remove(this.f15283b);
        f0Var.w(this);
    }
}
