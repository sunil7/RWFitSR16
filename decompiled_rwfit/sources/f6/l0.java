package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class l0 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13082a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13083b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13084c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13085d;

    public l0(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13082a = linearLayout;
        this.f13083b = viewPager;
        this.f13084c = tabLayout;
        this.f13085d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13082a;
    }
}
