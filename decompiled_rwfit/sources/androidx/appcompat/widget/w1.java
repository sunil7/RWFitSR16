package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class w1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1076a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x1 f1077b;

    public /* synthetic */ w1(x1 x1Var, int i3) {
        this.f1076a = i3;
        this.f1077b = x1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1076a) {
            case 0:
                ViewParent parent = this.f1077b.f1103d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                x1 x1Var = this.f1077b;
                x1Var.a();
                View view = x1Var.f1103d;
                if (view.isEnabled() && !view.isLongClickable() && x1Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    x1Var.f1105g = true;
                    break;
                }
                break;
        }
    }
}
