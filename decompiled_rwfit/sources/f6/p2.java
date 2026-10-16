package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class p2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13227a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13228b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13229c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13230d;

    public p2(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13227a = linearLayout;
        this.f13228b = viewPager;
        this.f13229c = tabLayout;
        this.f13230d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13227a;
    }
}
