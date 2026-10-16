package t0;

import android.view.View;

/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f18455g;

    @Override // t0.p
    public final boolean b(float f2, long j4, View view, p0.e eVar) {
        switch (this.f18455g) {
            case 0:
                view.setAlpha(a(f2, j4, view, eVar));
                break;
            case 1:
                view.setElevation(a(f2, j4, view, eVar));
                break;
            case 2:
                view.setRotation(a(f2, j4, view, eVar));
                break;
            case 3:
                view.setRotationX(a(f2, j4, view, eVar));
                break;
            case 4:
                view.setRotationY(a(f2, j4, view, eVar));
                break;
            case 5:
                view.setScaleX(a(f2, j4, view, eVar));
                break;
            case 6:
                view.setScaleY(a(f2, j4, view, eVar));
                break;
            case 7:
                view.setTranslationX(a(f2, j4, view, eVar));
                break;
            case 8:
                view.setTranslationY(a(f2, j4, view, eVar));
                break;
            default:
                view.setTranslationZ(a(f2, j4, view, eVar));
                break;
        }
        return this.f18465d;
    }
}
