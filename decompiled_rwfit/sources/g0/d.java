package g0;

import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.n0;
import androidx.camera.core.impl.w0;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.z1;
import java.util.UUID;
import t.b0;
import t.m0;
import t.u;

/* loaded from: classes.dex */
public final class d implements z1, u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13763a;

    /* renamed from: b, reason: collision with root package name */
    public final x0 f13764b;

    public d(x0 x0Var, int i3) {
        Object obj;
        Object obj2;
        Object obj3;
        this.f13763a = i3;
        switch (i3) {
            case 2:
                this.f13764b = x0Var;
                Object obj4 = null;
                try {
                    obj = x0Var.e(y.i.S0);
                } catch (IllegalArgumentException unused) {
                    obj = null;
                }
                Class cls = (Class) obj;
                if (cls != null && !cls.equals(b0.class)) {
                    throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
                }
                this.f13764b.m(a2.K0, UseCaseConfigFactory$CaptureType.IMAGE_ANALYSIS);
                androidx.camera.core.impl.c cVar = y.i.S0;
                x0 x0Var2 = this.f13764b;
                x0Var2.m(cVar, b0.class);
                try {
                    obj4 = x0Var2.e(y.i.R0);
                } catch (IllegalArgumentException unused2) {
                }
                if (obj4 == null) {
                    x0Var2.m(y.i.R0, b0.class.getCanonicalName() + "-" + UUID.randomUUID());
                    return;
                }
                return;
            case 3:
                this.f13764b = x0Var;
                Object obj5 = null;
                try {
                    obj2 = x0Var.e(y.i.S0);
                } catch (IllegalArgumentException unused3) {
                    obj2 = null;
                }
                Class cls2 = (Class) obj2;
                if (cls2 != null && !cls2.equals(m0.class)) {
                    throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
                }
                this.f13764b.m(a2.K0, UseCaseConfigFactory$CaptureType.IMAGE_CAPTURE);
                androidx.camera.core.impl.c cVar2 = y.i.S0;
                x0 x0Var3 = this.f13764b;
                x0Var3.m(cVar2, m0.class);
                try {
                    obj5 = x0Var3.e(y.i.R0);
                } catch (IllegalArgumentException unused4) {
                }
                if (obj5 == null) {
                    this.f13764b.m(y.i.R0, m0.class.getCanonicalName() + "-" + UUID.randomUUID());
                    return;
                }
                return;
            default:
                this.f13764b = x0Var;
                Object obj6 = null;
                try {
                    obj3 = x0Var.e(y.i.S0);
                } catch (IllegalArgumentException unused5) {
                    obj3 = null;
                }
                Class cls3 = (Class) obj3;
                if (cls3 != null && !cls3.equals(c.class)) {
                    throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls3);
                }
                this.f13764b.m(a2.K0, UseCaseConfigFactory$CaptureType.STREAM_SHARING);
                androidx.camera.core.impl.c cVar3 = y.i.S0;
                x0 x0Var4 = this.f13764b;
                x0Var4.m(cVar3, c.class);
                try {
                    obj6 = x0Var4.e(y.i.R0);
                } catch (IllegalArgumentException unused6) {
                }
                if (obj6 == null) {
                    x0Var4.m(y.i.R0, c.class.getCanonicalName() + "-" + UUID.randomUUID());
                    return;
                }
                return;
        }
    }

    public static d d(e0 e0Var) {
        d dVar = new d(1);
        e0Var.c(new c0.b(18, dVar, e0Var));
        return dVar;
    }

    @Override // t.u
    public final w0 a() {
        switch (this.f13763a) {
            case 0:
                return this.f13764b;
            case 1:
                throw null;
            case 2:
                return this.f13764b;
            default:
                return this.f13764b;
        }
    }

    @Override // androidx.camera.core.impl.z1
    public a2 b() {
        switch (this.f13763a) {
            case 0:
                return new e(d1.a(this.f13764b));
            case 1:
            default:
                return new n0(d1.a(this.f13764b));
            case 2:
                return new androidx.camera.core.impl.m0(d1.a(this.f13764b));
        }
    }

    public n6.a c() {
        return new n6.a(d1.a(this.f13764b), 12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(int i3) {
        this(x0.f(), 3);
        this.f13763a = i3;
        switch (i3) {
            case 2:
                this(x0.f(), 2);
                break;
            case 3:
                break;
            default:
                this.f13764b = x0.f();
                break;
        }
    }
}
