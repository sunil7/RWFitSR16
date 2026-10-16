package f6;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.view.TitleView;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class l2 implements m2.a {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13095a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f13096b;

    /* renamed from: c, reason: collision with root package name */
    public final TabLayout f13097c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleView f13098d;

    public l2(LinearLayout linearLayout, ViewPager viewPager, TabLayout tabLayout, TitleView titleView) {
        this.f13095a = linearLayout;
        this.f13096b = viewPager;
        this.f13097c = tabLayout;
        this.f13098d = titleView;
    }

    @Override // m2.a
    public final View b() {
        return this.f13095a;
    }
}
