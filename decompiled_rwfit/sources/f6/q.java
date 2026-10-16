package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class q implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13245a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13246b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13247c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13248d;

    public q(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13245a = linearLayout;
        this.f13246b = viewPager;
        this.f13247c = tabLayout;
        this.f13248d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13245a;
    }
}
