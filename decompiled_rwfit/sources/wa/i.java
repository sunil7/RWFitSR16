package wa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19552a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f19553b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o4.e f19554c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f19555d;

    public i(n nVar, boolean z5, o4.e eVar) {
        this.f19555d = nVar;
        this.f19553b = z5;
        this.f19554c = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f19552a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        n nVar = this.f19555d;
        nVar.f19582t = 0;
        nVar.f19577n = null;
        if (this.f19552a) {
            return;
        }
        boolean z5 = this.f19553b;
        nVar.f19586x.a(z5 ? 8 : 4, z5);
        o4.e eVar = this.f19554c;
        if (eVar != null) {
            ((g) eVar.f16737a).a((FloatingActionButton) eVar.f16738b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        n nVar = this.f19555d;
        nVar.f19586x.a(0, this.f19553b);
        nVar.f19582t = 1;
        nVar.f19577n = animator;
        this.f19552a = false;
    }
}
