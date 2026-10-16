package f6;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.ToolBarView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class q3 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f13263a;

    /* renamed from: b, reason: collision with root package name */
    public final TabLayout f13264b;

    /* renamed from: c, reason: collision with root package name */
    public final ToolBarView f13265c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewPager f13266d;

    public q3(ConstraintLayout constraintLayout, TabLayout tabLayout, ToolBarView toolBarView, ViewPager viewPager) {
        this.f13263a = constraintLayout;
        this.f13264b = tabLayout;
        this.f13265c = toolBarView;
        this.f13266d = viewPager;
    }

    @Override // m2.a
    public final View b() {
        return this.f13263a;
    }
}
