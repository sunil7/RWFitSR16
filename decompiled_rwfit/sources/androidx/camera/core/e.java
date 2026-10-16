package androidx.camera.core;

import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.concurrent.CancellationException;
import x.i;

/* loaded from: classes.dex */
public final class e implements x.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ob.a f1316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.concurrent.futures.b f1317b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1318c;

    public e(ob.a aVar, androidx.concurrent.futures.b bVar, String str) {
        this.f1316a = aVar;
        this.f1317b = bVar;
        this.f1318c = str;
    }

    @Override // x.c
    public final void C(final Throwable th2) {
        boolean z5 = th2 instanceof CancellationException;
        androidx.concurrent.futures.b bVar = this.f1317b;
        if (!z5) {
            bVar.a(null);
        } else {
            final String f2 = r5.a.f(new StringBuilder(), this.f1318c, " cancelled.");
            pd.f(null, bVar.b(new RuntimeException(f2, th2) { // from class: androidx.camera.core.SurfaceRequest$RequestCancelledException
            }));
        }
    }

    @Override // x.c
    public final void onSuccess(Object obj) {
        i.e(true, this.f1316a, this.f1317b, a6.a());
    }
}
