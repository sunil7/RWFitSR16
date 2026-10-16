package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a2 extends l1.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2514d;
    public final Object e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f2515f;

    public a2(b2 b2Var) {
        this.f2514d = 0;
        this.f2515f = new WeakHashMap();
        this.e = b2Var;
    }

    @Override // l1.c
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        View.AccessibilityDelegate accessibilityDelegate = this.f15682a;
        Object obj = this.f2515f;
        switch (this.f2514d) {
            case 0:
                l1.c cVar = (l1.c) ((WeakHashMap) obj).get(view);
                if (cVar == null) {
                    break;
                } else {
                    break;
                }
            default:
                if (accessibilityEvent.getEventType() != 32) {
                    break;
                } else {
                    accessibilityEvent.getText();
                    DrawerLayout drawerLayout = (DrawerLayout) obj;
                    View g10 = drawerLayout.g();
                    if (g10 != null) {
                        int i3 = drawerLayout.i(g10);
                        drawerLayout.getClass();
                        WeakHashMap weakHashMap = l1.z0.f15748a;
                        Gravity.getAbsoluteGravity(i3, l1.i0.d(drawerLayout));
                        break;
                    }
                }
                break;
        }
        return accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // l1.c
    public com.example.test.ui.device.activity.e0 b(View view) {
        switch (this.f2514d) {
            case 0:
                l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(view);
                if (cVar == null) {
                    break;
                } else {
                    break;
                }
        }
        return super.b(view);
    }

    @Override // l1.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2514d) {
            case 0:
                l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(view);
                if (cVar == null) {
                    super.c(view, accessibilityEvent);
                    break;
                } else {
                    cVar.c(view, accessibilityEvent);
                    break;
                }
            default:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
                break;
        }
    }

    @Override // l1.c
    public final void d(View view, m1.d dVar) {
        Object obj = this.e;
        View.AccessibilityDelegate accessibilityDelegate = this.f15682a;
        switch (this.f2514d) {
            case 0:
                b2 b2Var = (b2) obj;
                boolean N = b2Var.f2518d.N();
                AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
                if (!N) {
                    RecyclerView recyclerView = b2Var.f2518d;
                    if (recyclerView.getLayoutManager() != null) {
                        recyclerView.getLayoutManager().Y(view, dVar);
                        l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(view);
                        if (cVar != null) {
                            cVar.d(view, dVar);
                            break;
                        } else {
                            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                            break;
                        }
                    }
                }
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                break;
            default:
                boolean z5 = DrawerLayout.E;
                AccessibilityNodeInfo accessibilityNodeInfo2 = dVar.f15938a;
                if (z5) {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                } else {
                    AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo2);
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, obtain);
                    dVar.f15939b = -1;
                    accessibilityNodeInfo2.setSource(view);
                    WeakHashMap weakHashMap = l1.z0.f15748a;
                    Object f2 = l1.h0.f(view);
                    if (f2 instanceof View) {
                        accessibilityNodeInfo2.setParent((View) f2);
                    }
                    Rect rect = (Rect) obj;
                    obtain.getBoundsInScreen(rect);
                    accessibilityNodeInfo2.setBoundsInScreen(rect);
                    accessibilityNodeInfo2.setVisibleToUser(obtain.isVisibleToUser());
                    accessibilityNodeInfo2.setPackageName(obtain.getPackageName());
                    dVar.f(obtain.getClassName());
                    accessibilityNodeInfo2.setContentDescription(obtain.getContentDescription());
                    accessibilityNodeInfo2.setEnabled(obtain.isEnabled());
                    accessibilityNodeInfo2.setFocused(obtain.isFocused());
                    accessibilityNodeInfo2.setAccessibilityFocused(obtain.isAccessibilityFocused());
                    accessibilityNodeInfo2.setSelected(obtain.isSelected());
                    dVar.a(obtain.getActions());
                    obtain.recycle();
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (DrawerLayout.k(childAt)) {
                            accessibilityNodeInfo2.addChild(childAt);
                        }
                    }
                }
                dVar.f("androidx.drawerlayout.widget.DrawerLayout");
                accessibilityNodeInfo2.setFocusable(false);
                accessibilityNodeInfo2.setFocused(false);
                accessibilityNodeInfo2.removeAction((AccessibilityNodeInfo.AccessibilityAction) m1.c.e.f15934a);
                accessibilityNodeInfo2.removeAction((AccessibilityNodeInfo.AccessibilityAction) m1.c.f15924f.f15934a);
                break;
        }
    }

    @Override // l1.c
    public void e(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2514d) {
            case 0:
                l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(view);
                if (cVar == null) {
                    super.e(view, accessibilityEvent);
                    break;
                } else {
                    cVar.e(view, accessibilityEvent);
                    break;
                }
            default:
                super.e(view, accessibilityEvent);
                break;
        }
    }

    @Override // l1.c
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2514d) {
            case 0:
                l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(viewGroup);
                if (cVar == null) {
                    break;
                } else {
                    break;
                }
            default:
                if (DrawerLayout.E || DrawerLayout.k(view)) {
                    break;
                }
                break;
        }
        return this.f15682a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // l1.c
    public boolean g(View view, int i3, Bundle bundle) {
        switch (this.f2514d) {
            case 0:
                b2 b2Var = (b2) this.e;
                if (!b2Var.f2518d.N()) {
                    RecyclerView recyclerView = b2Var.f2518d;
                    if (recyclerView.getLayoutManager() != null) {
                        l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(view);
                        if (cVar == null ? !super.g(view, i3, bundle) : !cVar.g(view, i3, bundle)) {
                            q1 q1Var = recyclerView.getLayoutManager().f2586b.f2446b;
                            break;
                        }
                    }
                }
                break;
        }
        return super.g(view, i3, bundle);
    }

    @Override // l1.c
    public void h(View view, int i3) {
        switch (this.f2514d) {
            case 0:
                l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(view);
                if (cVar == null) {
                    super.h(view, i3);
                    break;
                } else {
                    cVar.h(view, i3);
                    break;
                }
            default:
                super.h(view, i3);
                break;
        }
    }

    @Override // l1.c
    public void i(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2514d) {
            case 0:
                l1.c cVar = (l1.c) ((WeakHashMap) this.f2515f).get(view);
                if (cVar == null) {
                    super.i(view, accessibilityEvent);
                    break;
                } else {
                    cVar.i(view, accessibilityEvent);
                    break;
                }
            default:
                super.i(view, accessibilityEvent);
                break;
        }
    }

    public a2(DrawerLayout drawerLayout) {
        this.f2514d = 1;
        this.f2515f = drawerLayout;
        this.e = new Rect();
    }
}
