package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class g3 extends TouchDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final View f904a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f905b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f906c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f907d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f908f;

    public g3(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f905b = rect3;
        Rect rect4 = new Rect();
        this.f907d = rect4;
        Rect rect5 = new Rect();
        this.f906c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i3 = -scaledTouchSlop;
        rect4.inset(i3, i3);
        rect5.set(rect2);
        this.f904a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean z6;
        int x10 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z8 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z6 = this.f908f;
                if (z6 && !this.f907d.contains(x10, y4)) {
                    z8 = z6;
                    z5 = false;
                }
            } else {
                if (action == 3) {
                    z6 = this.f908f;
                    this.f908f = false;
                }
                z5 = true;
                z8 = false;
            }
            z8 = z6;
            z5 = true;
        } else {
            if (this.f905b.contains(x10, y4)) {
                this.f908f = true;
                z5 = true;
            }
            z5 = true;
            z8 = false;
        }
        if (!z8) {
            return false;
        }
        Rect rect = this.f906c;
        View view = this.f904a;
        if (!z5 || rect.contains(x10, y4)) {
            motionEvent.setLocation(x10 - rect.left, y4 - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
