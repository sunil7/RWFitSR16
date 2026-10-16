package o6;

import androidx.camera.core.CameraControl$OperationCanceledException;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.jieli.jl_bt_ota.impl.RcspAuth;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16759a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16760b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16761c;

    public /* synthetic */ e(Object obj, boolean z5, int i3) {
        this.f16759a = i3;
        this.f16761c = obj;
        this.f16760b = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16759a) {
            case 0:
                g gVar = (g) this.f16761c;
                gVar.f16765d.b(gVar.f16762a, gVar.f16763b, this.f16760b);
                break;
            case 1:
                ((RcspAuth) this.f16761c).lambda$onInitResult$1(this.f16760b);
                break;
            default:
                s.c cVar = (s.c) this.f16761c;
                boolean z5 = cVar.f18150a;
                boolean z6 = this.f16760b;
                if (z5 != z6) {
                    cVar.f18150a = z6;
                    if (!z6) {
                        CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("The camera control has became inactive.");
                        androidx.concurrent.futures.b bVar = cVar.f18155g;
                        if (bVar != null) {
                            bVar.b(cameraControl$OperationCanceledException);
                            cVar.f18155g = null;
                            break;
                        }
                    } else if (cVar.f18151b) {
                        n.h hVar = cVar.f18152c;
                        hVar.getClass();
                        x.i.d(ve.a(new af.a(hVar, 18))).a(new m5.a(cVar, 10), cVar.f18153d);
                        cVar.f18151b = false;
                        break;
                    }
                }
                break;
        }
    }
}
