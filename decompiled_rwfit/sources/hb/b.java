package hb;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class b implements n2.i {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout f14293b;

    public b(TabLayout tabLayout) {
        this.f14293b = tabLayout;
    }

    @Override // n2.i
    public final void c(ViewPager viewPager, n2.a aVar, n2.a aVar2) {
        TabLayout tabLayout = this.f14293b;
        if (tabLayout.J == viewPager) {
            tabLayout.k(aVar2, this.f14292a);
        }
    }
}
