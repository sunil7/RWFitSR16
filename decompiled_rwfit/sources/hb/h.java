package hb;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import n2.j;

/* loaded from: classes.dex */
public final class h implements j {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f14303a;

    /* renamed from: b, reason: collision with root package name */
    public int f14304b;

    /* renamed from: c, reason: collision with root package name */
    public int f14305c;

    public h(TabLayout tabLayout) {
        this.f14303a = new WeakReference(tabLayout);
    }

    @Override // n2.j
    public final void a(int i3) {
        this.f14304b = this.f14305c;
        this.f14305c = i3;
    }

    @Override // n2.j
    public final void b(int i3) {
        TabLayout tabLayout = (TabLayout) this.f14303a.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i3 || i3 >= tabLayout.getTabCount()) {
            return;
        }
        int i10 = this.f14305c;
        tabLayout.j(tabLayout.g(i3), i10 == 0 || (i10 == 2 && this.f14304b == 0));
    }

    @Override // n2.j
    public final void d(float f2, int i3) {
        TabLayout tabLayout = (TabLayout) this.f14303a.get();
        if (tabLayout != null) {
            int i10 = this.f14305c;
            tabLayout.l(i3, f2, i10 != 2 || this.f14304b == 1, (i10 == 2 && this.f14304b == 0) ? false : true);
        }
    }
}
