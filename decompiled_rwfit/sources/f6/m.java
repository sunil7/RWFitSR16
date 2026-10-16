package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class m implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13110a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13111b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13112c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13113d;

    public m(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13110a = linearLayout;
        this.f13111b = viewPager;
        this.f13112c = tabLayout;
        this.f13113d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13110a;
    }
}
