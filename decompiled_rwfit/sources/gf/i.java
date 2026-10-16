package gf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

/* loaded from: classes2.dex */
public final class i extends d {

    /* renamed from: f, reason: collision with root package name */
    public long f14062f;

    /* renamed from: g, reason: collision with root package name */
    public long f14063g;

    /* renamed from: h, reason: collision with root package name */
    public d f14064h;

    @Override // gf.d, gf.e
    public final void e(b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.e(bVar, captureRequest, totalCaptureResult);
        if (c() || System.currentTimeMillis() <= this.f14062f + this.f14063g) {
            return;
        }
        this.f14064h.a(bVar);
    }

    @Override // gf.d, gf.e
    public final void i(b bVar) {
        this.f14062f = System.currentTimeMillis();
        super.i(bVar);
    }

    @Override // gf.d
    public final e o() {
        return this.f14064h;
    }
}
