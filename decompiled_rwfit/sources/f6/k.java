package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class k implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13023a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13024b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13025c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13026d;

    public k(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13023a = linearLayout;
        this.f13024b = viewPager;
        this.f13025c = tabLayout;
        this.f13026d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13023a;
    }
}
