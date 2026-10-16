package ab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f180a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f181b;

    public /* synthetic */ k(l lVar, int i3) {
        this.f180a = i3;
        this.f181b = lVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f180a) {
            case 1:
                super.onAnimationEnd(animator);
                l lVar = this.f181b;
                super/*android.graphics.drawable.Drawable*/.setVisible(false, false);
                ArrayList arrayList = lVar.f187f;
                if (arrayList != null && !lVar.f188g) {
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        ((c) obj).a();
                    }
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f180a) {
            case 0:
                super.onAnimationStart(animator);
                l lVar = this.f181b;
                ArrayList arrayList = lVar.f187f;
                if (arrayList != null && !lVar.f188g) {
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        ((c) obj).getClass();
                    }
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
