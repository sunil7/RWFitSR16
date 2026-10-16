package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class w1 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13418a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13419b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13420c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13421d;

    public w1(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13418a = linearLayout;
        this.f13419b = viewPager;
        this.f13420c = tabLayout;
        this.f13421d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13418a;
    }
}
