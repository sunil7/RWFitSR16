package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
public final class f1 extends Transition.EpicenterCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2176a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f2177b;

    public /* synthetic */ f1(int i3, Rect rect) {
        this.f2176a = i3;
        this.f2177b = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        switch (this.f2176a) {
            case 0:
                return this.f2177b;
            default:
                Rect rect = this.f2177b;
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
        }
    }
}
