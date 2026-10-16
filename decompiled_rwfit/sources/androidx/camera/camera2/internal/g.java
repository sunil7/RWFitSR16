package androidx.camera.camera2.internal;

import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1231a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1232b;

    public /* synthetic */ g(Object obj, int i3) {
        this.f1231a = i3;
        this.f1232b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1231a) {
            case 0:
                n.l lVar = (n.l) this.f1232b;
                if (((i) ((y) lVar.f16247d).f8774c).e == Camera2CameraImpl$InternalState.OPENING) {
                    ((i) ((y) lVar.f16247d).f8774c).s("Camera onError timeout, reopen it.", null);
                    ((i) ((y) lVar.f16247d).f8774c).D(Camera2CameraImpl$InternalState.REOPENING);
                    ((i) ((y) lVar.f16247d).f8774c).f1245i.b();
                    break;
                } else {
                    ((i) ((y) lVar.f16247d).f8774c).s("Camera skip reopen at state: " + ((i) ((y) lVar.f16247d).f8774c).e, null);
                    break;
                }
            default:
                androidx.fragment.app.h hVar = (androidx.fragment.app.h) this.f1232b;
                if (!hVar.f2188b) {
                    pd.f(null, ((h) hVar.f2190d).f1237f.e == Camera2CameraImpl$InternalState.REOPENING || ((h) hVar.f2190d).f1237f.e == Camera2CameraImpl$InternalState.REOPENING_QUIRK);
                    if (!((h) hVar.f2190d).c()) {
                        ((h) hVar.f2190d).f1237f.I(true);
                        break;
                    } else {
                        ((h) hVar.f2190d).f1237f.H(true);
                        break;
                    }
                }
                break;
        }
    }
}
