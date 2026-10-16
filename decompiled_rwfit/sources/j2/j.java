package j2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.R$id;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class j extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15233a;

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f15234b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f15235c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f15236d;
    public final /* synthetic */ View e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f15237f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l f15238g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f15239h;

    public j(n nVar, boolean z5, Matrix matrix, View view, m mVar, l lVar) {
        this.f15239h = nVar;
        this.f15235c = z5;
        this.f15236d = matrix;
        this.e = view;
        this.f15237f = mVar;
        this.f15238g = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f15233a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        boolean z5 = this.f15233a;
        m mVar = this.f15237f;
        View view = this.e;
        if (!z5) {
            if (this.f15235c && this.f15239h.f15266x) {
                Matrix matrix = this.f15236d;
                Matrix matrix2 = this.f15234b;
                matrix2.set(matrix);
                view.setTag(R$id.transition_transform, matrix2);
                view.setTranslationX(mVar.f15256a);
                view.setTranslationY(mVar.f15257b);
                WeakHashMap weakHashMap = z0.f15748a;
                l1.n0.w(view, mVar.f15258c);
                view.setScaleX(mVar.f15259d);
                view.setScaleY(mVar.e);
                view.setRotationX(mVar.f15260f);
                view.setRotationY(mVar.f15261g);
                view.setRotation(mVar.f15262h);
            } else {
                view.setTag(R$id.transition_transform, null);
                view.setTag(R$id.parent_matrix, null);
            }
        }
        o0.f15272a.d(view, null);
        view.setTranslationX(mVar.f15256a);
        view.setTranslationY(mVar.f15257b);
        WeakHashMap weakHashMap2 = z0.f15748a;
        l1.n0.w(view, mVar.f15258c);
        view.setScaleX(mVar.f15259d);
        view.setScaleY(mVar.e);
        view.setRotationX(mVar.f15260f);
        view.setRotationY(mVar.f15261g);
        view.setRotation(mVar.f15262h);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        Matrix matrix = this.f15238g.f15249a;
        Matrix matrix2 = this.f15234b;
        matrix2.set(matrix);
        int i3 = R$id.transition_transform;
        View view = this.e;
        view.setTag(i3, matrix2);
        m mVar = this.f15237f;
        view.setTranslationX(mVar.f15256a);
        view.setTranslationY(mVar.f15257b);
        WeakHashMap weakHashMap = z0.f15748a;
        l1.n0.w(view, mVar.f15258c);
        view.setScaleX(mVar.f15259d);
        view.setScaleY(mVar.e);
        view.setRotationX(mVar.f15260f);
        view.setRotationY(mVar.f15261g);
        view.setRotation(mVar.f15262h);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.e;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        WeakHashMap weakHashMap = z0.f15748a;
        l1.n0.w(view, 0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
    }
}
