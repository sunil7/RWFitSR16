package nf;

import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import ia.f;
import ia.i;
import ia.l;
import ia.m;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraState f16600a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16601b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraState f16602c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Callable f16603d;
    public final /* synthetic */ boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f16604f;

    public c(e eVar, CameraState cameraState, String str, CameraState cameraState2, Callable callable, boolean z5) {
        this.f16604f = eVar;
        this.f16600a = cameraState;
        this.f16601b = str;
        this.f16602c = cameraState2;
        this.f16603d = callable;
        this.e = z5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        e eVar = this.f16604f;
        if (eVar.e != this.f16600a) {
            e.f16609h.b(2, this.f16601b.toUpperCase(), "- State mismatch, aborting. current:", eVar.e, "from:", this.f16600a, "to:", this.f16602c);
            m mVar = new m();
            mVar.i();
            return mVar;
        }
        l lVar = eVar.f16610a.f13671a.f13645a.f17957d;
        f fVar = (f) this.f16603d.call();
        n6.a aVar = new n6.a(this, 1);
        m mVar2 = (m) fVar;
        mVar2.getClass();
        m mVar3 = new m();
        mVar2.f14399b.f(new i(lVar, aVar, mVar3, 0));
        mVar2.k();
        return mVar3;
    }
}
