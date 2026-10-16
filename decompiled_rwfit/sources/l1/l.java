package l1;

import android.content.Context;
import android.view.GestureDetector;

/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetector f15705a;

    public l(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this.f15705a = new GestureDetector(context, onGestureListener, null);
    }

    @Override // l1.k
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f15705a.setOnDoubleTapListener(onDoubleTapListener);
    }
}
