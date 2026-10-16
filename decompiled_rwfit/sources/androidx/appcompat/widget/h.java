package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f909a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f910b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f911c;

    public /* synthetic */ h(int i3, Object obj, Object obj2) {
        this.f909a = i3;
        this.f911c = obj;
        this.f910b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.i iVar;
        switch (this.f909a) {
            case 0:
                l lVar = (l) this.f911c;
                h.k kVar = lVar.f955c;
                if (kVar != null && (iVar = kVar.e) != null) {
                    iVar.k(kVar);
                }
                View view = (View) lVar.f959h;
                if (view != null && view.getWindowToken() != null) {
                    f fVar = (f) this.f910b;
                    if (!fVar.b()) {
                        if (fVar.e != null) {
                            fVar.d(0, 0, false, false);
                        }
                    }
                    lVar.f970t = fVar;
                }
                lVar.f972v = null;
                break;
            default:
                View view2 = (View) this.f910b;
                int left = view2.getLeft();
                ScrollingTabContainerView scrollingTabContainerView = (ScrollingTabContainerView) this.f911c;
                scrollingTabContainerView.smoothScrollTo(left - ((scrollingTabContainerView.getWidth() - view2.getWidth()) / 2), 0);
                scrollingTabContainerView.f784a = null;
                break;
        }
    }
}
