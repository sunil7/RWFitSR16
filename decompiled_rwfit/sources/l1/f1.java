package l1;

import android.animation.ValueAnimator;
import android.view.ViewPropertyAnimator;

/* loaded from: classes.dex */
public abstract class f1 {
    public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
    }
}
