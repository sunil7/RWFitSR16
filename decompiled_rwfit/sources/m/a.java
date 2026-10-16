package m;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.c;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.e1;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.w0;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.z1;
import java.util.UUID;
import t.u;
import y.i;

/* loaded from: classes.dex */
public final class a implements u, z1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15875a;

    /* renamed from: b, reason: collision with root package name */
    public final x0 f15876b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i3) {
        this(x0.f());
        this.f15875a = i3;
        switch (i3) {
            case 1:
                break;
            default:
                this.f15876b = x0.f();
                break;
        }
    }

    @Override // t.u
    public final w0 a() {
        switch (this.f15875a) {
            case 0:
                throw null;
            default:
                return this.f15876b;
        }
    }

    @Override // androidx.camera.core.impl.z1
    public a2 b() {
        return new e1(d1.a(this.f15876b));
    }

    public void c(CaptureRequest.Key key, Object obj, Config$OptionPriority config$OptionPriority) {
        this.f15876b.l(b.Y(key), config$OptionPriority, obj);
    }

    public a(x0 x0Var) {
        Object obj;
        this.f15875a = 1;
        this.f15876b = x0Var;
        Object obj2 = null;
        try {
            obj = x0Var.e(i.S0);
        } catch (IllegalArgumentException unused) {
            obj = null;
        }
        Class cls = (Class) obj;
        if (cls != null && !cls.equals(c.class)) {
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
        this.f15876b.m(a2.K0, UseCaseConfigFactory$CaptureType.PREVIEW);
        androidx.camera.core.impl.c cVar = i.S0;
        x0 x0Var2 = this.f15876b;
        x0Var2.m(cVar, c.class);
        try {
            obj2 = x0Var2.e(i.R0);
        } catch (IllegalArgumentException unused2) {
        }
        if (obj2 == null) {
            this.f15876b.m(i.R0, c.class.getCanonicalName() + "-" + UUID.randomUUID());
        }
        Object obj3 = -1;
        try {
            obj3 = x0Var.e(p0.f1469v0);
        } catch (IllegalArgumentException unused3) {
        }
        if (((Integer) obj3).intValue() == -1) {
            x0Var.m(p0.f1469v0, 2);
        }
    }
}
