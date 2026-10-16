package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.ui.device.activity.f0;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;
import ma.a;
import ma.b;
import p1.d;
import x0.c;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends c {

    /* renamed from: a, reason: collision with root package name */
    public d f10228a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10229b;

    /* renamed from: c, reason: collision with root package name */
    public int f10230c = 2;

    /* renamed from: d, reason: collision with root package name */
    public float f10231d = 0.0f;
    public float e = 0.5f;

    /* renamed from: f, reason: collision with root package name */
    public final a f10232f = new a(this);

    @Override // x0.c
    public boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z5 = this.f10229b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z5 = coordinatorLayout.t(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f10229b = z5;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f10229b = false;
        }
        if (!z5) {
            return false;
        }
        if (this.f10228a == null) {
            this.f10228a = new d(coordinatorLayout.getContext(), coordinatorLayout, this.f10232f);
        }
        return this.f10228a.r(motionEvent);
    }

    @Override // x0.c
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
        WeakHashMap weakHashMap = z0.f15748a;
        if (h0.c(view) == 0) {
            h0.s(view, 1);
            z0.k(Const.I_MAX_OFFLINE_DATA_CACHE, view);
            z0.g(0, view);
            if (s(view)) {
                z0.l(view, m1.c.f15930l, new f0(this, 26));
            }
        }
        return false;
    }

    @Override // x0.c
    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        d dVar = this.f10228a;
        if (dVar == null) {
            return false;
        }
        dVar.k(motionEvent);
        return true;
    }

    public boolean s(View view) {
        return true;
    }

    public void setListener(b bVar) {
    }
}
