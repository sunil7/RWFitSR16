package j2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class o extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15269a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15270b;

    /* renamed from: c, reason: collision with root package name */
    public final View f15271c;

    public o(View view, boolean z5) {
        this.f15269a = 1;
        this.f15270b = z5;
        this.f15271c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f15269a) {
            case 0:
                View view = this.f15271c;
                o0.b(view, 1.0f);
                if (this.f15270b) {
                    view.setLayerType(0, null);
                    break;
                }
                break;
            default:
                if (!this.f15270b) {
                    this.f15271c.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f15271c;
        switch (this.f15269a) {
            case 0:
                WeakHashMap weakHashMap = z0.f15748a;
                if (l1.h0.h(view) && view.getLayerType() == 0) {
                    this.f15270b = true;
                    view.setLayerType(2, null);
                    break;
                }
                break;
            default:
                if (this.f15270b) {
                    view.setVisibility(0);
                    break;
                }
                break;
        }
    }

    public o(View view) {
        this.f15269a = 0;
        this.f15270b = false;
        this.f15271c = view;
    }
}
