package ff;

import android.hardware.Camera;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13606a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f13607b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f13608c;

    public /* synthetic */ d(q qVar, float f2, int i3) {
        this.f13606a = i3;
        this.f13608c = qVar;
        this.f13607b = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13606a) {
            case 0:
                e eVar = (e) this.f13608c;
                Camera.Parameters parameters = eVar.V.getParameters();
                if (eVar.Z(parameters, this.f13607b)) {
                    eVar.V.setParameters(parameters);
                    break;
                }
                break;
            default:
                n nVar = (n) this.f13608c;
                if (nVar.X(nVar.Z, this.f13607b)) {
                    nVar.Y();
                    break;
                }
                break;
        }
    }
}
