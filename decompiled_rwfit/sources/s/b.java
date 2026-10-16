package s;

import androidx.camera.core.CameraControl$OperationCanceledException;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import n.h;
import n0.g;
import x.i;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18148a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f18149b;

    public /* synthetic */ b(c cVar, int i3) {
        this.f18148a = i3;
        this.f18149b = cVar;
    }

    @Override // n0.g
    public final Object b(final androidx.concurrent.futures.b bVar) {
        switch (this.f18148a) {
            case 0:
                final c cVar = this.f18149b;
                cVar.getClass();
                final int i3 = 1;
                cVar.f18153d.execute(new Runnable() { // from class: s.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                androidx.concurrent.futures.b bVar2 = bVar;
                                c cVar2 = cVar;
                                cVar2.f18151b = true;
                                CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera2CameraControl was updated with new options.");
                                androidx.concurrent.futures.b bVar3 = cVar2.f18155g;
                                if (bVar3 != null) {
                                    bVar3.b(cameraControl$OperationCanceledException);
                                    cVar2.f18155g = null;
                                }
                                cVar2.f18155g = bVar2;
                                if (cVar2.f18150a) {
                                    h hVar = cVar2.f18152c;
                                    hVar.getClass();
                                    i.d(ve.a(new af.a(hVar, 18))).a(new m5.a(cVar2, 10), cVar2.f18153d);
                                    cVar2.f18151b = false;
                                    break;
                                }
                                break;
                            default:
                                androidx.concurrent.futures.b bVar4 = bVar;
                                c cVar3 = cVar;
                                cVar3.f18151b = true;
                                CameraControl$OperationCanceledException cameraControl$OperationCanceledException2 = new CameraControl$OperationCanceledException("Camera2CameraControl was updated with new options.");
                                androidx.concurrent.futures.b bVar5 = cVar3.f18155g;
                                if (bVar5 != null) {
                                    bVar5.b(cameraControl$OperationCanceledException2);
                                    cVar3.f18155g = null;
                                }
                                cVar3.f18155g = bVar4;
                                if (cVar3.f18150a) {
                                    h hVar2 = cVar3.f18152c;
                                    hVar2.getClass();
                                    i.d(ve.a(new af.a(hVar2, 18))).a(new m5.a(cVar3, 10), cVar3.f18153d);
                                    cVar3.f18151b = false;
                                    break;
                                }
                                break;
                        }
                    }
                });
                return "addCaptureRequestOptions";
            default:
                final c cVar2 = this.f18149b;
                cVar2.getClass();
                final int i10 = 0;
                cVar2.f18153d.execute(new Runnable() { // from class: s.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i10) {
                            case 0:
                                androidx.concurrent.futures.b bVar2 = bVar;
                                c cVar22 = cVar2;
                                cVar22.f18151b = true;
                                CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera2CameraControl was updated with new options.");
                                androidx.concurrent.futures.b bVar3 = cVar22.f18155g;
                                if (bVar3 != null) {
                                    bVar3.b(cameraControl$OperationCanceledException);
                                    cVar22.f18155g = null;
                                }
                                cVar22.f18155g = bVar2;
                                if (cVar22.f18150a) {
                                    h hVar = cVar22.f18152c;
                                    hVar.getClass();
                                    i.d(ve.a(new af.a(hVar, 18))).a(new m5.a(cVar22, 10), cVar22.f18153d);
                                    cVar22.f18151b = false;
                                    break;
                                }
                                break;
                            default:
                                androidx.concurrent.futures.b bVar4 = bVar;
                                c cVar3 = cVar2;
                                cVar3.f18151b = true;
                                CameraControl$OperationCanceledException cameraControl$OperationCanceledException2 = new CameraControl$OperationCanceledException("Camera2CameraControl was updated with new options.");
                                androidx.concurrent.futures.b bVar5 = cVar3.f18155g;
                                if (bVar5 != null) {
                                    bVar5.b(cameraControl$OperationCanceledException2);
                                    cVar3.f18155g = null;
                                }
                                cVar3.f18155g = bVar4;
                                if (cVar3.f18150a) {
                                    h hVar2 = cVar3.f18152c;
                                    hVar2.getClass();
                                    i.d(ve.a(new af.a(hVar2, 18))).a(new m5.a(cVar3, 10), cVar3.f18153d);
                                    cVar3.f18151b = false;
                                    break;
                                }
                                break;
                        }
                    }
                });
                return "clearCaptureRequestOptions";
        }
    }
}
