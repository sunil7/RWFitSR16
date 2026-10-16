package kb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import o4.e;
import wa.g;
import wa.n;

/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15596a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f15597b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15598c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f15599d;

    public b(boolean z5, View view, View view2) {
        this.f15597b = z5;
        this.f15598c = view;
        this.f15599d = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f15596a) {
            case 0:
                if (!this.f15597b) {
                    ((View) this.f15598c).setVisibility(4);
                    View view = (View) this.f15599d;
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                    break;
                }
                break;
            default:
                n nVar = (n) this.f15599d;
                nVar.f19582t = 0;
                nVar.f19577n = null;
                e eVar = (e) this.f15598c;
                if (eVar != null) {
                    ((g) eVar.f16737a).b();
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f15596a) {
            case 0:
                if (this.f15597b) {
                    ((View) this.f15598c).setVisibility(0);
                    View view = (View) this.f15599d;
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                    break;
                }
                break;
            default:
                n nVar = (n) this.f15599d;
                nVar.f19586x.a(0, this.f15597b);
                nVar.f19582t = 2;
                nVar.f19577n = animator;
                break;
        }
    }

    public b(n nVar, boolean z5, e eVar) {
        this.f15599d = nVar;
        this.f15597b = z5;
        this.f15598c = eVar;
    }
}
