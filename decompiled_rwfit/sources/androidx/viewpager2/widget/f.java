package androidx.viewpager2.widget;

import androidx.recyclerview.widget.b1;

/* loaded from: classes.dex */
public final class f extends b1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2984a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2985b;

    public /* synthetic */ f(Object obj, int i3) {
        this.f2984a = i3;
        this.f2985b = obj;
    }

    @Override // androidx.recyclerview.widget.b1
    public final void a() {
        switch (this.f2984a) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) this.f2985b;
                viewPager2.e = true;
                viewPager2.f2957l.f2983l = true;
                break;
            default:
                ((v2.h) this.f2985b).q();
                break;
        }
    }

    @Override // androidx.recyclerview.widget.b1
    public final void b(int i3, int i10, Object obj) {
        a();
    }

    @Override // androidx.recyclerview.widget.b1
    public final void c(int i3, int i10) {
        a();
    }

    @Override // androidx.recyclerview.widget.b1
    public final void d(int i3, int i10) {
        a();
    }

    @Override // androidx.recyclerview.widget.b1
    public final void e(int i3, int i10) {
        a();
    }
}
