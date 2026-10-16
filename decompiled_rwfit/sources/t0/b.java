package t0;

import android.view.View;

/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f18441d;

    @Override // t0.f
    public final void c(View view, float f2) {
        switch (this.f18441d) {
            case 0:
                view.setAlpha(a(f2));
                break;
            case 1:
                view.setElevation(a(f2));
                break;
            case 2:
                view.setRotation(a(f2));
                break;
            case 3:
                view.setRotationX(a(f2));
                break;
            case 4:
                view.setRotationY(a(f2));
                break;
            case 5:
                view.setScaleX(a(f2));
                break;
            case 6:
                view.setScaleY(a(f2));
                break;
            case 7:
                view.setTranslationX(a(f2));
                break;
            case 8:
                view.setTranslationY(a(f2));
                break;
            default:
                view.setTranslationZ(a(f2));
                break;
        }
    }
}
