package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f877a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f878b;

    public /* synthetic */ c(ActionBarOverlayLayout actionBarOverlayLayout, int i3) {
        this.f877a = i3;
        this.f878b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f877a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f878b;
                actionBarOverlayLayout.d();
                actionBarOverlayLayout.f653w = actionBarOverlayLayout.f636d.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f654x);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f878b;
                actionBarOverlayLayout2.d();
                actionBarOverlayLayout2.f653w = actionBarOverlayLayout2.f636d.animate().translationY(-actionBarOverlayLayout2.f636d.getHeight()).setListener(actionBarOverlayLayout2.f654x);
                break;
        }
    }
}
