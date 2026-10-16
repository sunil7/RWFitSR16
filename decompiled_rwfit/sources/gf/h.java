package gf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.List;

/* loaded from: classes2.dex */
public final class h extends e {
    public final List e;

    /* renamed from: f, reason: collision with root package name */
    public int f14061f = -1;

    public h(List list) {
        this.e = list;
        m();
    }

    @Override // gf.e
    public final void d(b bVar) {
        int i3 = this.f14061f;
        if (i3 >= 0) {
            ((e) this.e.get(i3)).d(bVar);
        }
    }

    @Override // gf.e
    public final void e(b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        int i3 = this.f14061f;
        if (i3 >= 0) {
            ((e) this.e.get(i3)).e(bVar, captureRequest, totalCaptureResult);
        }
    }

    @Override // gf.e
    public final void f(b bVar, CaptureRequest captureRequest, CaptureResult captureResult) {
        int i3 = this.f14061f;
        if (i3 >= 0) {
            ((e) this.e.get(i3)).f(bVar, captureRequest, captureResult);
        }
    }

    @Override // gf.e
    public final void g(b bVar, CaptureRequest captureRequest) {
        super.g(bVar, captureRequest);
        int i3 = this.f14061f;
        if (i3 >= 0) {
            ((e) this.e.get(i3)).g(bVar, captureRequest);
        }
    }

    @Override // gf.e
    public final void i(b bVar) {
        this.f14058c = bVar;
        int i3 = this.f14061f;
        if (i3 >= 0) {
            ((e) this.e.get(i3)).i(bVar);
        }
    }

    public final void m() {
        int i3 = this.f14061f;
        boolean z5 = i3 == -1;
        List list = this.e;
        if (i3 == list.size() - 1) {
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
            return;
        }
        int i10 = this.f14061f + 1;
        this.f14061f = i10;
        ((e) list.get(i10)).b(new c(this, 1));
        if (z5) {
            return;
        }
        ((e) list.get(this.f14061f)).i(this.f14058c);
    }
}
