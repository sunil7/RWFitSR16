package ab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.haibin.calendarview.CalendarLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import j2.f0;

/* loaded from: classes.dex */
public final class q extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f201a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f202b;

    public /* synthetic */ q(Object obj, int i3) {
        this.f201a = i3;
        this.f202b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f201a) {
            case 2:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f202b;
                actionBarOverlayLayout.f653w = null;
                actionBarOverlayLayout.f642k = false;
                break;
            case 11:
                ((wa.a) this.f202b).d();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        RefreshState refreshState;
        RefreshState refreshState2;
        switch (this.f201a) {
            case 1:
                super.onAnimationEnd(animator);
                s sVar = (s) this.f202b;
                if (sVar.f217j) {
                    sVar.f212d.setRepeatCount(-1);
                    sVar.f218k.a();
                    sVar.f217j = false;
                    break;
                }
                break;
            case 2:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f202b;
                actionBarOverlayLayout.f653w = null;
                actionBarOverlayLayout.f642k = false;
                break;
            case 3:
                de.o oVar = (de.o) this.f202b;
                if (((ValueAnimator) oVar.f12378c) == animator) {
                    oVar.f12378c = null;
                    break;
                }
                break;
            case 4:
                com.google.android.material.textfield.l lVar = (com.google.android.material.textfield.l) this.f202b;
                lVar.f10923c.setChecked(lVar.f10914j);
                lVar.f10920p.start();
                break;
            case 5:
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f202b;
                    smartRefreshLayout.f11677q1 = null;
                    if (smartRefreshLayout.f11639b == 0 && (refreshState = smartRefreshLayout.f11654g1) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                        smartRefreshLayout.u(refreshState2);
                        break;
                    } else {
                        RefreshState refreshState3 = smartRefreshLayout.f11654g1;
                        if (refreshState3 != smartRefreshLayout.f11657h1) {
                            smartRefreshLayout.setViceState(refreshState3);
                            break;
                        }
                    }
                }
                break;
            case 6:
                if (animator == null || animator.getDuration() != 0) {
                    dg.d dVar = (dg.d) ((androidx.emoji2.text.i) this.f202b).f2034c;
                    SmartRefreshLayout smartRefreshLayout2 = dVar.f12395d;
                    smartRefreshLayout2.f11667l1 = false;
                    if (dVar.f12394c) {
                        smartRefreshLayout2.w(true);
                    }
                    SmartRefreshLayout smartRefreshLayout3 = dVar.f12395d;
                    if (smartRefreshLayout3.f11654g1 == RefreshState.LoadFinish) {
                        smartRefreshLayout3.u(RefreshState.None);
                        break;
                    }
                }
                break;
            case 7:
                ((f0) this.f202b).m();
                animator.removeListener(this);
                break;
            case 8:
                ((ExpandableTransformationBehavior) this.f202b).f10987b = null;
                break;
            case 9:
                ((HideBottomViewOnScrollBehavior) this.f202b).f10227d = null;
                break;
            case 10:
                super.onAnimationEnd(animator);
                md.c cVar = (md.c) this.f202b;
                CalendarLayout calendarLayout = cVar.f16035b;
                calendarLayout.f11319p = false;
                calendarLayout.f11307c = true;
                CalendarLayout.a(calendarLayout);
                md.r rVar = cVar.f16035b.f11323u;
                if (rVar != null) {
                    rVar.getClass();
                    break;
                }
                break;
            case 11:
                ((wa.a) this.f202b).e();
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        switch (this.f201a) {
            case 0:
                super.onAnimationRepeat(animator);
                r rVar = (r) this.f202b;
                rVar.f206g = (rVar.f206g + 1) % rVar.f205f.f153c.length;
                rVar.f207h = true;
                break;
            case 1:
                super.onAnimationRepeat(animator);
                s sVar = (s) this.f202b;
                sVar.f214g = (sVar.f214g + 1) % sVar.f213f.f153c.length;
                sVar.f215h = true;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f201a) {
            case 11:
                ((wa.a) this.f202b).f(animator);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
