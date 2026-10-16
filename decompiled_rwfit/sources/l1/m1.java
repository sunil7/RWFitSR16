package l1;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class m1 extends o1 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInsets.Builder f15715a;

    public m1() {
        this.f15715a = j2.n0.f();
    }

    @Override // l1.o1
    public x1 b() {
        WindowInsets build;
        a();
        build = this.f15715a.build();
        x1 h4 = x1.h(build, null);
        h4.f15738a.o(null);
        return h4;
    }

    @Override // l1.o1
    public void c(c1.c cVar) {
        this.f15715a.setStableInsets(cVar.c());
    }

    @Override // l1.o1
    public void d(c1.c cVar) {
        this.f15715a.setSystemWindowInsets(cVar.c());
    }

    public m1(x1 x1Var) {
        super(x1Var);
        WindowInsets.Builder f2;
        WindowInsets g10 = x1Var.g();
        if (g10 != null) {
            f2 = j2.n0.g(g10);
        } else {
            f2 = j2.n0.f();
        }
        this.f15715a = f2;
    }
}
