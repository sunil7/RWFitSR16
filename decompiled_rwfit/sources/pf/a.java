package pf;

import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import ff.e;

/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: g, reason: collision with root package name */
    public final e f17591g;

    /* renamed from: h, reason: collision with root package name */
    public final int f17592h;

    public a(int i3, e eVar) {
        super(byte[].class, i3);
        this.f17591g = eVar;
        this.f17592h = 0;
    }

    @Override // pf.c
    public final void b(Object obj, boolean z5) {
        byte[] bArr = (byte[]) obj;
        if (z5 && bArr.length == this.f17599b) {
            if (this.f17592h != 0) {
                throw null;
            }
            e eVar = this.f17591g;
            nf.e eVar2 = eVar.f13648d;
            CameraState cameraState = eVar2.e;
            CameraState cameraState2 = CameraState.ENGINE;
            if (cameraState.isAtLeast(cameraState2) && eVar2.f16614f.isAtLeast(cameraState2)) {
                eVar.V.addCallbackBuffer(bArr);
            }
        }
    }

    @Override // pf.c
    public final void c() {
        super.c();
        if (this.f17592h == 1) {
            throw null;
        }
    }

    @Override // pf.c
    public final void d(int i3, wf.b bVar, lf.b bVar2) {
        super.d(i3, bVar, bVar2);
        int i10 = this.f17599b;
        for (int i11 = 0; i11 < this.f17598a; i11++) {
            if (this.f17592h != 0) {
                byte[] bArr = new byte[i10];
                throw null;
            }
            byte[] bArr2 = new byte[i10];
            e eVar = this.f17591g;
            nf.e eVar2 = eVar.f13648d;
            CameraState cameraState = eVar2.e;
            CameraState cameraState2 = CameraState.ENGINE;
            if (cameraState.isAtLeast(cameraState2) && eVar2.f16614f.isAtLeast(cameraState2)) {
                eVar.V.addCallbackBuffer(bArr2);
            }
        }
    }
}
