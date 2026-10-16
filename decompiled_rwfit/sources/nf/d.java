package nf;

import com.otaliastudios.cameraview.engine.orchestrator.CameraState;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraState f16606b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f16607c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f16608d;

    public /* synthetic */ d(e eVar, CameraState cameraState, Runnable runnable, int i3) {
        this.f16605a = i3;
        this.f16608d = eVar;
        this.f16606b = cameraState;
        this.f16607c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16605a) {
            case 0:
                if (this.f16608d.e.isAtLeast(this.f16606b)) {
                    this.f16607c.run();
                    break;
                }
                break;
            default:
                if (this.f16608d.e.isAtLeast(this.f16606b)) {
                    this.f16607c.run();
                    break;
                }
                break;
        }
    }
}
