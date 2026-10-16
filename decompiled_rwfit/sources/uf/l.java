package uf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.impl.y0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class l extends o {

    /* renamed from: k, reason: collision with root package name */
    public final gf.h f19085k;

    /* renamed from: l, reason: collision with root package name */
    public final ff.n f19086l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f19087m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f19088n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f19089o;

    public l(y0 y0Var, ff.n nVar, vf.g gVar, wf.a aVar) {
        super(y0Var, nVar, gVar, aVar, nVar.S);
        this.f19086l = nVar;
        hf.c cVar = new hf.c(0);
        gf.i iVar = new gf.i(0);
        iVar.f14063g = 2500L;
        iVar.f14064h = cVar;
        gf.h hVar = new gf.h(Arrays.asList(iVar, new k()));
        this.f19085k = hVar;
        hVar.b(new j(this));
        TotalCaptureResult totalCaptureResult = nVar.f13631a0;
        if (totalCaptureResult == null) {
            p.f19101d.b(2, "Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        this.f19087m = nVar.f13666x && num != null && num.intValue() == 4;
        this.f19088n = (Integer) nVar.Z.get(CaptureRequest.CONTROL_AE_MODE);
        this.f19089o = (Integer) nVar.Z.get(CaptureRequest.FLASH_MODE);
    }

    @Override // uf.o, ab.n
    public final void n() {
        new ff.j(this, 3).l(this.f19086l);
        super.n();
    }

    @Override // uf.o, ab.n
    public final void u() {
        boolean z5 = this.f19087m;
        ef.b bVar = p.f19101d;
        if (z5) {
            bVar.b(1, "take:", "Engine needs flash. Starting action");
            this.f19085k.l(this.f19086l);
        } else {
            bVar.b(1, "take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.u();
        }
    }
}
