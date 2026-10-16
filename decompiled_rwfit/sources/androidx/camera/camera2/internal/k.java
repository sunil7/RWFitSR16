package androidx.camera.camera2.internal;

/* loaded from: classes.dex */
public final /* synthetic */ class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1265a;

    public final void a() {
        m mVar = this.f1265a;
        synchronized (mVar.f1267a) {
            try {
                if (mVar.f1274i == CaptureSession$State.OPENED) {
                    mVar.j(mVar.f1271f);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
