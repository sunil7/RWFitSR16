package fb;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class c implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13554a;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f13554a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }
}
