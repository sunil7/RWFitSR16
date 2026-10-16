package g0;

import androidx.camera.core.impl.b1;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f implements v {

    /* renamed from: a, reason: collision with root package name */
    public final v f13767a;

    /* renamed from: b, reason: collision with root package name */
    public final j f13768b;

    /* renamed from: c, reason: collision with root package name */
    public final k f13769c;

    /* renamed from: d, reason: collision with root package name */
    public final h f13770d;

    public f(v vVar, h hVar, b9.a aVar) {
        this.f13767a = vVar;
        this.f13770d = hVar;
        this.f13768b = new j(vVar.m());
        this.f13769c = new k(vVar.h());
    }

    @Override // t.g1
    public final void c(androidx.camera.core.f fVar) {
        y5.a();
        this.f13770d.c(fVar);
    }

    @Override // androidx.camera.core.impl.v
    public final void d(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.v
    public final void e(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.v
    public final boolean f() {
        return false;
    }

    @Override // androidx.camera.core.impl.v
    public final u h() {
        return this.f13769c;
    }

    @Override // t.g1
    public final void i(androidx.camera.core.f fVar) {
        y5.a();
        this.f13770d.i(fVar);
    }

    @Override // t.g1
    public final void j(androidx.camera.core.f fVar) {
        y5.a();
        this.f13770d.j(fVar);
    }

    @Override // t.g1
    public final void k(androidx.camera.core.f fVar) {
        y5.a();
        this.f13770d.k(fVar);
    }

    @Override // androidx.camera.core.impl.v
    public final b1 l() {
        return this.f13767a.l();
    }

    @Override // androidx.camera.core.impl.v
    public final t m() {
        return this.f13768b;
    }
}
