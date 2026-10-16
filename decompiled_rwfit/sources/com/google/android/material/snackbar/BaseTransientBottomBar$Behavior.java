package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import ec.a;
import fb.d;

/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: g, reason: collision with root package name */
    public final a f10766g;

    public BaseTransientBottomBar$Behavior() {
        a aVar = new a(11);
        this.f10231d = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.e = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f10230c = 0;
        this.f10766g = aVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, x0.c
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f10766g.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (d.f13555b == null) {
                    d.f13555b = new d();
                }
                synchronized (d.f13555b.f13556a) {
                }
            }
        } else if (coordinatorLayout.t(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (d.f13555b == null) {
                d.f13555b = new d();
            }
            synchronized (d.f13555b.f13556a) {
            }
        }
        return super.g(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean s(View view) {
        this.f10766g.getClass();
        return view instanceof BaseTransientBottomBar$SnackbarBaseLayout;
    }
}
