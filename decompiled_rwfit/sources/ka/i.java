package ka;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f15591a = {R.attr.stateListAnimator};

    public static void a(AppBarLayout appBarLayout, float f2) {
        int integer = appBarLayout.getResources().getInteger(R$integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j4 = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, R$attr.state_liftable, -R$attr.state_lifted}, ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(j4));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(appBarLayout, "elevation", f2).setDuration(j4));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(0L));
        appBarLayout.setStateListAnimator(stateListAnimator);
    }
}
