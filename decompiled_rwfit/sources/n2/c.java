package n2;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class c extends DataSetObserver implements j, i {

    /* renamed from: a, reason: collision with root package name */
    public int f16364a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PagerTitleStrip f16365b;

    public c(PagerTitleStrip pagerTitleStrip) {
        this.f16365b = pagerTitleStrip;
    }

    @Override // n2.j
    public final void a(int i3) {
        this.f16364a = i3;
    }

    @Override // n2.j
    public final void b(int i3) {
        if (this.f16364a == 0) {
            PagerTitleStrip pagerTitleStrip = this.f16365b;
            pagerTitleStrip.b(pagerTitleStrip.f2905a.getCurrentItem(), pagerTitleStrip.f2905a.getAdapter());
            float f2 = pagerTitleStrip.f2909f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            pagerTitleStrip.c(pagerTitleStrip.f2905a.getCurrentItem(), true, f2);
        }
    }

    @Override // n2.i
    public final void c(ViewPager viewPager, a aVar, a aVar2) {
        this.f16365b.a(aVar, aVar2);
    }

    @Override // n2.j
    public final void d(float f2, int i3) {
        if (f2 > 0.5f) {
            i3++;
        }
        this.f16365b.c(i3, false, f2);
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.f16365b;
        pagerTitleStrip.b(pagerTitleStrip.f2905a.getCurrentItem(), pagerTitleStrip.f2905a.getAdapter());
        float f2 = pagerTitleStrip.f2909f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        pagerTitleStrip.c(pagerTitleStrip.f2905a.getCurrentItem(), true, f2);
    }
}
