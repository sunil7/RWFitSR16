package p1;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.test.ui.device.activity.e0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;
import m1.g;

/* loaded from: classes.dex */
public abstract class b extends l1.c {

    /* renamed from: n, reason: collision with root package name */
    public static final Rect f17352n = new Rect(SubsamplingScaleImageView.TILE_SIZE_AUTO, SubsamplingScaleImageView.TILE_SIZE_AUTO, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o, reason: collision with root package name */
    public static final gc.b f17353o = new gc.b(17);

    /* renamed from: p, reason: collision with root package name */
    public static final hc.a f17354p = new hc.a(17);

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f17358h;

    /* renamed from: i, reason: collision with root package name */
    public final View f17359i;

    /* renamed from: j, reason: collision with root package name */
    public a f17360j;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f17355d = new Rect();
    public final Rect e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f17356f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    public final int[] f17357g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public int f17361k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f17362l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f17363m = Integer.MIN_VALUE;

    public b(View view) {
        this.f17359i = view;
        this.f17358h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = z0.f15748a;
        if (h0.c(view) == 0) {
            h0.s(view, 1);
        }
    }

    @Override // l1.c
    public final e0 b(View view) {
        if (this.f17360j == null) {
            this.f17360j = new a(this);
        }
        return this.f17360j;
    }

    @Override // l1.c
    public final void d(View view, m1.d dVar) {
        this.f15682a.onInitializeAccessibilityNodeInfo(view, dVar.f15938a);
        t(dVar);
    }

    public final boolean j(int i3) {
        if (this.f17362l != i3) {
            return false;
        }
        this.f17362l = Integer.MIN_VALUE;
        v(i3, false);
        x(i3, 8);
        return true;
    }

    public final AccessibilityEvent k(int i3, int i10) {
        View view = this.f17359i;
        if (i3 == -1) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
            view.onInitializeAccessibilityEvent(obtain);
            return obtain;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain(i10);
        m1.d r = r(i3);
        obtain2.getText().add(r.e());
        AccessibilityNodeInfo accessibilityNodeInfo = r.f15938a;
        obtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        obtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        obtain2.setPassword(accessibilityNodeInfo.isPassword());
        obtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        obtain2.setChecked(accessibilityNodeInfo.isChecked());
        if (obtain2.getText().isEmpty() && obtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain2.setClassName(accessibilityNodeInfo.getClassName());
        g.a(obtain2, view, i3);
        obtain2.setPackageName(view.getContext().getPackageName());
        return obtain2;
    }

    public final m1.d l(int i3) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        m1.d dVar = new m1.d(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        dVar.f("android.view.View");
        Rect rect = f17352n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        View view = this.f17359i;
        obtain.setParent(view);
        u(i3, dVar);
        if (dVar.e() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.e;
        dVar.d(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(view.getContext().getPackageName());
        dVar.f15939b = i3;
        obtain.setSource(view, i3);
        if (this.f17361k == i3) {
            obtain.setAccessibilityFocused(true);
            dVar.a(128);
        } else {
            obtain.setAccessibilityFocused(false);
            dVar.a(64);
        }
        boolean z5 = this.f17362l == i3;
        if (z5) {
            dVar.a(2);
        } else if (obtain.isFocusable()) {
            dVar.a(1);
        }
        obtain.setFocused(z5);
        int[] iArr = this.f17357g;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f17355d;
        obtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            dVar.d(rect3);
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f17356f;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                obtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            dVar.f15938a.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return dVar;
    }

    public final boolean m(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = this.f17358h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int n4 = n(motionEvent.getX(), motionEvent.getY());
            y(n4);
            return n4 != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f17363m == Integer.MIN_VALUE) {
            return false;
        }
        y(Integer.MIN_VALUE);
        return true;
    }

    public abstract int n(float f2, float f10);

    public abstract void o(ArrayList arrayList);

    public final void p(int i3) {
        View view;
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f17358h.isEnabled() || (parent = (view = this.f17359i).getParent()) == null) {
            return;
        }
        AccessibilityEvent k10 = k(i3, 2048);
        m1.a.b(k10, 0);
        parent.requestSendAccessibilityEvent(view, k10);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r21, android.graphics.Rect r22) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.b.q(int, android.graphics.Rect):boolean");
    }

    public final m1.d r(int i3) {
        if (i3 != -1) {
            return l(i3);
        }
        View view = this.f17359i;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
        m1.d dVar = new m1.d(obtain);
        WeakHashMap weakHashMap = z0.f15748a;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        o(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            dVar.f15938a.addChild(view, ((Integer) arrayList.get(i10)).intValue());
        }
        return dVar;
    }

    public abstract boolean s(int i3, int i10, Bundle bundle);

    public void t(m1.d dVar) {
    }

    public abstract void u(int i3, m1.d dVar);

    public void v(int i3, boolean z5) {
    }

    public final boolean w(int i3) {
        int i10;
        View view = this.f17359i;
        if ((!view.isFocused() && !view.requestFocus()) || (i10 = this.f17362l) == i3) {
            return false;
        }
        if (i10 != Integer.MIN_VALUE) {
            j(i10);
        }
        if (i3 == Integer.MIN_VALUE) {
            return false;
        }
        this.f17362l = i3;
        v(i3, true);
        x(i3, 8);
        return true;
    }

    public final void x(int i3, int i10) {
        View view;
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f17358h.isEnabled() || (parent = (view = this.f17359i).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, k(i3, i10));
    }

    public final void y(int i3) {
        int i10 = this.f17363m;
        if (i10 == i3) {
            return;
        }
        this.f17363m = i3;
        x(i3, 128);
        x(i10, 256);
    }
}
