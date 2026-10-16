package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class n implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13129a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13130b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13131c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13132d;

    public n(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13129a = linearLayout;
        this.f13130b = viewPager;
        this.f13131c = tabLayout;
        this.f13132d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13129a;
    }
}
