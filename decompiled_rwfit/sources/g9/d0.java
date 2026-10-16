package g9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

/* loaded from: classes.dex */
public final class d0 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13920a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView f13921b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e0 f13922c;

    public /* synthetic */ d0(e0 e0Var, StyledPlayerControlView styledPlayerControlView, int i3) {
        this.f13920a = i3;
        this.f13922c = e0Var;
        this.f13921b = styledPlayerControlView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f13920a) {
            case 0:
                e0 e0Var = this.f13922c;
                e0Var.i(1);
                if (e0Var.B) {
                    this.f13921b.post(e0Var.f13941s);
                    e0Var.B = false;
                    break;
                }
                break;
            case 1:
                e0 e0Var2 = this.f13922c;
                e0Var2.i(2);
                if (e0Var2.B) {
                    this.f13921b.post(e0Var2.f13941s);
                    e0Var2.B = false;
                    break;
                }
                break;
            default:
                e0 e0Var3 = this.f13922c;
                e0Var3.i(2);
                if (e0Var3.B) {
                    this.f13921b.post(e0Var3.f13941s);
                    e0Var3.B = false;
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f13920a) {
            case 0:
                this.f13922c.i(3);
                break;
            case 1:
                this.f13922c.i(3);
                break;
            default:
                this.f13922c.i(3);
                break;
        }
    }
}
