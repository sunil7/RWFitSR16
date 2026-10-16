package androidx.camera.core;

import android.view.Surface;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import n0.i;
import t.k;

/* loaded from: classes.dex */
public final class d implements x.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1313a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1314b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1315c;

    public /* synthetic */ d(int i3, Object obj, Object obj2) {
        this.f1313a = i3;
        this.f1314b = obj;
        this.f1315c = obj2;
    }

    @Override // x.c
    public final void C(Throwable th2) {
        switch (this.f1313a) {
            case 0:
                if (!(th2 instanceof SurfaceRequest$RequestCancelledException)) {
                    pd.f(null, ((androidx.concurrent.futures.b) this.f1314b).a(null));
                    break;
                } else {
                    pd.f(null, ((i) this.f1315c).cancel(false));
                    break;
                }
            default:
                pd.f("Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th2, th2 instanceof SurfaceRequest$RequestCancelledException);
                ((k1.a) this.f1314b).f(new k(1, (Surface) this.f1315c));
                break;
        }
    }

    @Override // x.c
    public final void onSuccess(Object obj) {
        switch (this.f1313a) {
            case 0:
                pd.f(null, ((androidx.concurrent.futures.b) this.f1314b).a(null));
                break;
            default:
                ((k1.a) this.f1314b).f(new k(0, (Surface) this.f1315c));
                break;
        }
    }
}
