package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/* loaded from: classes.dex */
public final class g extends j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2986a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2987b;

    public /* synthetic */ g(ViewPager2 viewPager2, int i3) {
        this.f2986a = i3;
        this.f2987b = viewPager2;
    }

    @Override // androidx.viewpager2.widget.j
    public void a(int i3) {
        switch (this.f2986a) {
            case 0:
                if (i3 == 0) {
                    ((ViewPager2) this.f2987b).d();
                    return;
                }
                return;
            case 1:
            default:
                return;
            case 2:
                try {
                    ArrayList arrayList = (ArrayList) this.f2987b;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        ((j) obj).a(i3);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
        }
    }

    @Override // androidx.viewpager2.widget.j
    public void b(int i3, float f2, int i10) {
        switch (this.f2986a) {
            case 2:
                try {
                    ArrayList arrayList = (ArrayList) this.f2987b;
                    int size = arrayList.size();
                    int i11 = 0;
                    while (i11 < size) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        ((j) obj).b(i3, f2, i10);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                return;
        }
    }

    @Override // androidx.viewpager2.widget.j
    public final void c(int i3) {
        switch (this.f2986a) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) this.f2987b;
                if (viewPager2.f2950d != i3) {
                    viewPager2.f2950d = i3;
                    viewPager2.f2964t.q();
                    return;
                }
                return;
            case 1:
                ViewPager2 viewPager22 = (ViewPager2) this.f2987b;
                viewPager22.clearFocus();
                if (viewPager22.hasFocus()) {
                    viewPager22.f2955j.requestFocus(2);
                    return;
                }
                return;
            default:
                try {
                    ArrayList arrayList = (ArrayList) this.f2987b;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        ((j) obj).c(i3);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
        }
    }

    public g() {
        this.f2986a = 2;
        this.f2987b = new ArrayList(3);
    }
}
