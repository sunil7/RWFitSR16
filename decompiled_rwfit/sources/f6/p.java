package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class p implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13207a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13208b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13209c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13210d;

    public p(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13207a = linearLayout;
        this.f13208b = viewPager;
        this.f13209c = tabLayout;
        this.f13210d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13207a;
    }
}
