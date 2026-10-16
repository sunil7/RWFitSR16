package l1;

import android.content.Context;
import android.view.GestureDetector;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final l f15711a;

    public m(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this.f15711a = new l(context, onGestureListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f15711a.setOnDoubleTapListener(onDoubleTapListener);
    }
}
