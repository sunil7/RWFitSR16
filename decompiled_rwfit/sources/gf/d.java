package gf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes2.dex */
public abstract class d extends e {
    public final /* synthetic */ int e;

    public /* synthetic */ d(int i3) {
        this.e = i3;
    }

    @Override // gf.e
    public void d(b bVar) {
        switch (this.e) {
            case 0:
                o().d(bVar);
                break;
        }
    }

    @Override // gf.e
    public void e(b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        switch (this.e) {
            case 0:
                o().e(bVar, captureRequest, totalCaptureResult);
                break;
        }
    }

    @Override // gf.e
    public void f(b bVar, CaptureRequest captureRequest, CaptureResult captureResult) {
        switch (this.e) {
            case 0:
                o().f(bVar, captureRequest, captureResult);
                break;
        }
    }

    @Override // gf.e
    public void g(b bVar, CaptureRequest captureRequest) {
        switch (this.e) {
            case 0:
                super.g(bVar, captureRequest);
                o().g(bVar, captureRequest);
                break;
            default:
                super.g(bVar, captureRequest);
                break;
        }
    }

    @Override // gf.e
    public void i(b bVar) {
        switch (this.e) {
            case 0:
                this.f14058c = bVar;
                o().b(new c(this, 0));
                o().i(bVar);
                break;
            default:
                this.f14058c = bVar;
                boolean n4 = n(bVar);
                if (m(bVar) && !n4) {
                    p(bVar);
                    break;
                } else {
                    k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                    break;
                }
        }
    }

    public abstract boolean m(b bVar);

    public abstract boolean n(b bVar);

    public abstract e o();

    public abstract void p(b bVar);
}
