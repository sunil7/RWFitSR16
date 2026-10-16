package androidx.appcompat.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.R$color;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.b4;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public final class r implements l1.w, h.w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f564a;

    public /* synthetic */ r(c0 c0Var) {
        this.f564a = c0Var;
    }

    @Override // l1.w
    public x1 P(View view, x1 x1Var) {
        boolean z5;
        boolean z6;
        int d5 = x1Var.d();
        c0 c0Var = this.f564a;
        c0Var.getClass();
        int d8 = x1Var.d();
        ActionBarContextView actionBarContextView = c0Var.f442v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z5 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) c0Var.f442v.getLayoutParams();
            if (c0Var.f442v.isShown()) {
                if (c0Var.f426c0 == null) {
                    c0Var.f426c0 = new Rect();
                    c0Var.f427d0 = new Rect();
                }
                Rect rect = c0Var.f426c0;
                Rect rect2 = c0Var.f427d0;
                rect.set(x1Var.b(), x1Var.d(), x1Var.c(), x1Var.a());
                ViewGroup viewGroup = c0Var.A;
                Method method = b4.f875a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception e) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                    }
                }
                int i3 = rect.top;
                int i10 = rect.left;
                int i11 = rect.right;
                ViewGroup viewGroup2 = c0Var.A;
                WeakHashMap weakHashMap = z0.f15748a;
                x1 a3 = l1.o0.a(viewGroup2);
                int b3 = a3 == null ? 0 : a3.b();
                int c9 = a3 == null ? 0 : a3.c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i10 && marginLayoutParams.rightMargin == i11) {
                    z6 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i10;
                    marginLayoutParams.rightMargin = i11;
                    z6 = true;
                }
                Context context = c0Var.f432k;
                if (i3 <= 0 || c0Var.C != null) {
                    View view2 = c0Var.C;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i12 = marginLayoutParams2.height;
                        int i13 = marginLayoutParams.topMargin;
                        if (i12 != i13 || marginLayoutParams2.leftMargin != b3 || marginLayoutParams2.rightMargin != c9) {
                            marginLayoutParams2.height = i13;
                            marginLayoutParams2.leftMargin = b3;
                            marginLayoutParams2.rightMargin = c9;
                            c0Var.C.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    c0Var.C = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = b3;
                    layoutParams.rightMargin = c9;
                    c0Var.A.addView(c0Var.C, -1, layoutParams);
                }
                View view4 = c0Var.C;
                r8 = view4 != null;
                if (r8 && view4.getVisibility() != 0) {
                    View view5 = c0Var.C;
                    view5.setBackgroundColor((l1.h0.g(view5) & 8192) != 0 ? a1.d.a(context, R$color.abc_decor_view_status_guard_light) : a1.d.a(context, R$color.abc_decor_view_status_guard));
                }
                if (!c0Var.H && r8) {
                    d8 = 0;
                }
                z5 = r8;
                r8 = z6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z5 = false;
            } else {
                z5 = false;
                r8 = false;
            }
            if (r8) {
                c0Var.f442v.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = c0Var.C;
        if (view6 != null) {
            view6.setVisibility(z5 ? 0 : 8);
        }
        return z0.h(view, d5 != d8 ? x1Var.f(x1Var.b(), d8, x1Var.c(), x1Var.a()) : x1Var);
    }

    @Override // h.w
    public void b(h.k kVar, boolean z5) {
        b0 b0Var;
        h.k k10 = kVar.k();
        int i3 = 0;
        boolean z6 = k10 != kVar;
        if (z6) {
            kVar = k10;
        }
        c0 c0Var = this.f564a;
        b0[] b0VarArr = c0Var.L;
        int length = b0VarArr != null ? b0VarArr.length : 0;
        while (true) {
            if (i3 < length) {
                b0Var = b0VarArr[i3];
                if (b0Var != null && b0Var.f410h == kVar) {
                    break;
                } else {
                    i3++;
                }
            } else {
                b0Var = null;
                break;
            }
        }
        if (b0Var != null) {
            if (!z6) {
                c0Var.s(b0Var, z5);
            } else {
                c0Var.q(b0Var.f404a, b0Var, k10);
                c0Var.s(b0Var, true);
            }
        }
    }

    @Override // h.w
    public boolean c(h.k kVar) {
        Window.Callback callback;
        if (kVar != kVar.k()) {
            return true;
        }
        c0 c0Var = this.f564a;
        if (!c0Var.F || (callback = c0Var.f433l.getCallback()) == null || c0Var.Q) {
            return true;
        }
        callback.onMenuOpened(108, kVar);
        return true;
    }
}
