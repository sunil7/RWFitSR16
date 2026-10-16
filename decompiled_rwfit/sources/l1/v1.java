package l1;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class v1 {

    /* renamed from: b, reason: collision with root package name */
    public static final x1 f15734b;

    /* renamed from: a, reason: collision with root package name */
    public final x1 f15735a;

    static {
        int i3 = Build.VERSION.SDK_INT;
        f15734b = (i3 >= 30 ? new n1() : i3 >= 29 ? new m1() : new l1()).b().f15738a.a().f15738a.b().f15738a.c();
    }

    public v1(x1 x1Var) {
        this.f15735a = x1Var;
    }

    public x1 a() {
        return this.f15735a;
    }

    public x1 b() {
        return this.f15735a;
    }

    public x1 c() {
        return this.f15735a;
    }

    public void d(View view) {
    }

    public j e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return n() == v1Var.n() && m() == v1Var.m() && k1.b.a(j(), v1Var.j()) && k1.b.a(h(), v1Var.h()) && k1.b.a(e(), v1Var.e());
    }

    public c1.c f(int i3) {
        return c1.c.e;
    }

    public c1.c g() {
        return j();
    }

    public c1.c h() {
        return c1.c.e;
    }

    public int hashCode() {
        return k1.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public c1.c i() {
        return j();
    }

    public c1.c j() {
        return c1.c.e;
    }

    public c1.c k() {
        return j();
    }

    public x1 l(int i3, int i10, int i11, int i12) {
        return f15734b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void o(c1.c[] cVarArr) {
    }

    public void p(x1 x1Var) {
    }

    public void q(c1.c cVar) {
    }
}
