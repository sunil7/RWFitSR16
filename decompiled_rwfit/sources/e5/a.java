package e5;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.dh.imagepick.preview.widgets.BackgroundView;
import com.dh.imagepick.preview.widgets.InterceptLayout;

/* loaded from: classes.dex */
public final class a implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final InterceptLayout f12463a;

    /* renamed from: b, reason: collision with root package name */
    public final BackgroundView f12464b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager2 f12465c;

    public a(InterceptLayout interceptLayout, BackgroundView backgroundView, ConstraintLayout constraintLayout, ViewPager2 viewPager2) {
        this.f12463a = interceptLayout;
        this.f12464b = backgroundView;
        this.f12465c = viewPager2;
    }

    @Override // m2.a
    public final View b() {
        return this.f12463a;
    }
}
