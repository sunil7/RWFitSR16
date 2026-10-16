package g0;

import androidx.camera.core.impl.l0;
import androidx.camera.core.impl.u;
import java.util.UUID;

/* loaded from: classes.dex */
public final class k extends l0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f13787b;

    /* renamed from: c, reason: collision with root package name */
    public int f13788c;

    public k(u uVar) {
        super(uVar);
        this.f13787b = "virtual-" + uVar.c() + "-" + UUID.randomUUID().toString();
    }

    @Override // androidx.camera.core.impl.l0, androidx.camera.core.impl.u
    public final int a() {
        return f(0);
    }

    @Override // androidx.camera.core.impl.l0, androidx.camera.core.impl.u
    public final String c() {
        return this.f13787b;
    }

    @Override // androidx.camera.core.impl.l0, androidx.camera.core.impl.u
    public final int f(int i3) {
        return v.d.f(this.f1432a.f(i3) - this.f13788c);
    }
}
