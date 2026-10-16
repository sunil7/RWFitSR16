package u;

import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import t.w;
import t.z0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public z0 f18656a;

    /* renamed from: b, reason: collision with root package name */
    public a f18657b;

    public void setOnImageCloseListener(w wVar) {
        y5.a();
        pd.f("The ImageReader is not initialized.", this.f18656a != null);
        this.f18656a.setOnImageCloseListener(wVar);
    }
}
