package n2;

import android.view.View;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16362a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PagerTabStrip f16363b;

    public /* synthetic */ b(PagerTabStrip pagerTabStrip, int i3) {
        this.f16362a = i3;
        this.f16363b = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f16362a) {
            case 0:
                this.f16363b.f2905a.setCurrentItem(r2.getCurrentItem() - 1);
                break;
            default:
                ViewPager viewPager = this.f16363b.f2905a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                break;
        }
    }
}
