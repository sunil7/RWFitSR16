package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class z implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13473a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13474b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13475c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13476d;

    public z(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13473a = linearLayout;
        this.f13474b = viewPager;
        this.f13475c = tabLayout;
        this.f13476d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13473a;
    }
}
