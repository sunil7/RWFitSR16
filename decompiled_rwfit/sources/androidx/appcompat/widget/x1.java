package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public abstract class x1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f1100a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1101b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1102c;

    /* renamed from: d, reason: collision with root package name */
    public final View f1103d;
    public w1 e;

    /* renamed from: f, reason: collision with root package name */
    public w1 f1104f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1105g;

    /* renamed from: h, reason: collision with root package name */
    public int f1106h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f1107i = new int[2];

    public x1(View view) {
        this.f1103d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1100a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1101b = tapTimeout;
        this.f1102c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        w1 w1Var = this.f1104f;
        View view = this.f1103d;
        if (w1Var != null) {
            view.removeCallbacks(w1Var);
        }
        w1 w1Var2 = this.e;
        if (w1Var2 != null) {
            view.removeCallbacks(w1Var2);
        }
    }

    public abstract h.b0 b();

    public abstract boolean c();

    public boolean d() {
        h.b0 b3 = b();
        if (b3 == null || !b3.a()) {
            return true;
        }
        b3.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r14 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x1.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f1105g = false;
        this.f1106h = -1;
        w1 w1Var = this.e;
        if (w1Var != null) {
            this.f1103d.removeCallbacks(w1Var);
        }
    }
}
