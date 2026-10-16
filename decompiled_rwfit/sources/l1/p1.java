package l1;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class p1 extends v1 {

    /* renamed from: h, reason: collision with root package name */
    public static boolean f15716h = false;

    /* renamed from: i, reason: collision with root package name */
    public static Method f15717i;

    /* renamed from: j, reason: collision with root package name */
    public static Class f15718j;

    /* renamed from: k, reason: collision with root package name */
    public static Field f15719k;

    /* renamed from: l, reason: collision with root package name */
    public static Field f15720l;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f15721c;

    /* renamed from: d, reason: collision with root package name */
    public c1.c[] f15722d;
    public c1.c e;

    /* renamed from: f, reason: collision with root package name */
    public x1 f15723f;

    /* renamed from: g, reason: collision with root package name */
    public c1.c f15724g;

    public p1(x1 x1Var, WindowInsets windowInsets) {
        super(x1Var);
        this.e = null;
        this.f15721c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private c1.c r(int i3, boolean z5) {
        c1.c cVar = c1.c.e;
        for (int i10 = 1; i10 <= 256; i10 <<= 1) {
            if ((i3 & i10) != 0) {
                c1.c s7 = s(i10, z5);
                cVar = c1.c.a(Math.max(cVar.f3354a, s7.f3354a), Math.max(cVar.f3355b, s7.f3355b), Math.max(cVar.f3356c, s7.f3356c), Math.max(cVar.f3357d, s7.f3357d));
            }
        }
        return cVar;
    }

    private c1.c t() {
        x1 x1Var = this.f15723f;
        return x1Var != null ? x1Var.f15738a.h() : c1.c.e;
    }

    private c1.c u(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f15716h) {
            v();
        }
        Method method = f15717i;
        if (method != null && f15718j != null && f15719k != null) {
            try {
                Object invoke = method.invoke(view, null);
                if (invoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f15719k.get(f15720l.get(invoke));
                if (rect != null) {
                    return c1.c.a(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void v() {
        try {
            f15717i = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f15718j = cls;
            f15719k = cls.getDeclaredField("mVisibleInsets");
            f15720l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f15719k.setAccessible(true);
            f15720l.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        f15716h = true;
    }

    @Override // l1.v1
    public void d(View view) {
        c1.c u10 = u(view);
        if (u10 == null) {
            u10 = c1.c.e;
        }
        w(u10);
    }

    @Override // l1.v1
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f15724g, ((p1) obj).f15724g);
        }
        return false;
    }

    @Override // l1.v1
    public c1.c f(int i3) {
        return r(i3, false);
    }

    @Override // l1.v1
    public final c1.c j() {
        if (this.e == null) {
            WindowInsets windowInsets = this.f15721c;
            this.e = c1.c.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override // l1.v1
    public x1 l(int i3, int i10, int i11, int i12) {
        x1 h4 = x1.h(this.f15721c, null);
        int i13 = Build.VERSION.SDK_INT;
        o1 n1Var = i13 >= 30 ? new n1(h4) : i13 >= 29 ? new m1(h4) : new l1(h4);
        n1Var.d(x1.e(j(), i3, i10, i11, i12));
        n1Var.c(x1.e(h(), i3, i10, i11, i12));
        return n1Var.b();
    }

    @Override // l1.v1
    public boolean n() {
        return this.f15721c.isRound();
    }

    @Override // l1.v1
    public void o(c1.c[] cVarArr) {
        this.f15722d = cVarArr;
    }

    @Override // l1.v1
    public void p(x1 x1Var) {
        this.f15723f = x1Var;
    }

    public c1.c s(int i3, boolean z5) {
        c1.c h4;
        int i10;
        if (i3 == 1) {
            return z5 ? c1.c.a(0, Math.max(t().f3355b, j().f3355b), 0, 0) : c1.c.a(0, j().f3355b, 0, 0);
        }
        if (i3 == 2) {
            if (z5) {
                c1.c t8 = t();
                c1.c h10 = h();
                return c1.c.a(Math.max(t8.f3354a, h10.f3354a), 0, Math.max(t8.f3356c, h10.f3356c), Math.max(t8.f3357d, h10.f3357d));
            }
            c1.c j4 = j();
            x1 x1Var = this.f15723f;
            h4 = x1Var != null ? x1Var.f15738a.h() : null;
            int i11 = j4.f3357d;
            if (h4 != null) {
                i11 = Math.min(i11, h4.f3357d);
            }
            return c1.c.a(j4.f3354a, 0, j4.f3356c, i11);
        }
        c1.c cVar = c1.c.e;
        if (i3 == 8) {
            c1.c[] cVarArr = this.f15722d;
            h4 = cVarArr != null ? cVarArr[3] : null;
            if (h4 != null) {
                return h4;
            }
            c1.c j10 = j();
            c1.c t10 = t();
            int i12 = j10.f3357d;
            if (i12 > t10.f3357d) {
                return c1.c.a(0, 0, 0, i12);
            }
            c1.c cVar2 = this.f15724g;
            if (cVar2 != null && !cVar2.equals(cVar) && (i10 = this.f15724g.f3357d) > t10.f3357d) {
                return c1.c.a(0, 0, 0, i10);
            }
        } else {
            if (i3 == 16) {
                return i();
            }
            if (i3 == 32) {
                return g();
            }
            if (i3 == 64) {
                return k();
            }
            if (i3 == 128) {
                x1 x1Var2 = this.f15723f;
                j e = x1Var2 != null ? x1Var2.f15738a.e() : e();
                if (e != null) {
                    int i13 = Build.VERSION.SDK_INT;
                    return c1.c.a(i13 >= 28 ? i.d(e.f15700a) : 0, i13 >= 28 ? i.f(e.f15700a) : 0, i13 >= 28 ? i.e(e.f15700a) : 0, i13 >= 28 ? i.c(e.f15700a) : 0);
                }
            }
        }
        return cVar;
    }

    public void w(c1.c cVar) {
        this.f15724g = cVar;
    }
}
