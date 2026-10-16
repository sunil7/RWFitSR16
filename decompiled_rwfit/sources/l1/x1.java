package l1;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class x1 {

    /* renamed from: b, reason: collision with root package name */
    public static final x1 f15737b;

    /* renamed from: a, reason: collision with root package name */
    public final v1 f15738a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f15737b = u1.f15733q;
        } else {
            f15737b = v1.f15734b;
        }
    }

    public x1(WindowInsets windowInsets) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.f15738a = new u1(this, windowInsets);
            return;
        }
        if (i3 >= 29) {
            this.f15738a = new t1(this, windowInsets);
        } else if (i3 >= 28) {
            this.f15738a = new s1(this, windowInsets);
        } else {
            this.f15738a = new q1(this, windowInsets);
        }
    }

    public static c1.c e(c1.c cVar, int i3, int i10, int i11, int i12) {
        int max = Math.max(0, cVar.f3354a - i3);
        int max2 = Math.max(0, cVar.f3355b - i10);
        int max3 = Math.max(0, cVar.f3356c - i11);
        int max4 = Math.max(0, cVar.f3357d - i12);
        return (max == i3 && max2 == i10 && max3 == i11 && max4 == i12) ? cVar : c1.c.a(max, max2, max3, max4);
    }

    public static x1 h(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        x1 x1Var = new x1(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (k0.b(view)) {
                x1 a3 = o0.a(view);
                v1 v1Var = x1Var.f15738a;
                v1Var.p(a3);
                v1Var.d(view.getRootView());
            }
        }
        return x1Var;
    }

    public final int a() {
        return this.f15738a.j().f3357d;
    }

    public final int b() {
        return this.f15738a.j().f3354a;
    }

    public final int c() {
        return this.f15738a.j().f3356c;
    }

    public final int d() {
        return this.f15738a.j().f3355b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        return k1.b.a(this.f15738a, ((x1) obj).f15738a);
    }

    public final x1 f(int i3, int i10, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        o1 n1Var = i13 >= 30 ? new n1(this) : i13 >= 29 ? new m1(this) : new l1(this);
        n1Var.d(c1.c.a(i3, i10, i11, i12));
        return n1Var.b();
    }

    public final WindowInsets g() {
        v1 v1Var = this.f15738a;
        if (v1Var instanceof p1) {
            return ((p1) v1Var).f15721c;
        }
        return null;
    }

    public final int hashCode() {
        v1 v1Var = this.f15738a;
        if (v1Var == null) {
            return 0;
        }
        return v1Var.hashCode();
    }

    public x1() {
        this.f15738a = new v1(this);
    }
}
