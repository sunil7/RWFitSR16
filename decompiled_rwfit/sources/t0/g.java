package t0;

import android.view.View;

/* loaded from: classes.dex */
public final class g extends k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f18447f;

    @Override // t0.k
    public final void c(View view, float f2) {
        switch (this.f18447f) {
            case 0:
                view.setAlpha(a(f2));
                break;
            case 1:
                view.setElevation(a(f2));
                break;
            case 2:
                view.setPivotX(a(f2));
                break;
            case 3:
                view.setPivotY(a(f2));
                break;
            case 4:
                view.setRotation(a(f2));
                break;
            case 5:
                view.setRotationX(a(f2));
                break;
            case 6:
                view.setRotationY(a(f2));
                break;
            case 7:
                view.setScaleX(a(f2));
                break;
            case 8:
                view.setScaleY(a(f2));
                break;
            case 9:
                view.setTranslationX(a(f2));
                break;
            case 10:
                view.setTranslationY(a(f2));
                break;
            default:
                view.setTranslationZ(a(f2));
                break;
        }
    }
}
