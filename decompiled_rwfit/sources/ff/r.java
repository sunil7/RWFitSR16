package ff;

import com.otaliastudios.cameraview.CameraException;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class r implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13669a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f13670b;

    public /* synthetic */ r(q qVar, int i3) {
        this.f13669a = i3;
        this.f13670b = qVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f13669a) {
            case 0:
                return this.f13670b.s();
            case 1:
                return this.f13670b.v();
            case 2:
                q qVar = this.f13670b;
                if (qVar.c(qVar.F)) {
                    return qVar.r();
                }
                q.T.b(3, "onStartEngine:", "No camera available for facing", qVar.F);
                throw new CameraException(6);
            case 3:
                return this.f13670b.u();
            case 4:
                q qVar2 = this.f13670b;
                vf.a aVar = qVar2.e;
                if (aVar != null && aVar.g()) {
                    return qVar2.q();
                }
                ia.m mVar = new ia.m();
                mVar.i();
                return mVar;
            default:
                return this.f13670b.t();
        }
    }
}
