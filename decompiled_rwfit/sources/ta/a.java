package ta;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final Dialog f18591a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18592b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18593c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18594d;

    public a(Dialog dialog, Rect rect) {
        this.f18591a = dialog;
        this.f18592b = rect.left;
        this.f18593c = rect.top;
        this.f18594d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = findViewById.getLeft() + this.f18592b;
        int width = findViewById.getWidth() + left;
        if (new RectF(left, findViewById.getTop() + this.f18593c, width, findViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i3 = this.f18594d;
            obtain.setLocation((-i3) - 1, (-i3) - 1);
        }
        view.performClick();
        return this.f18591a.onTouchEvent(obtain);
    }
}
