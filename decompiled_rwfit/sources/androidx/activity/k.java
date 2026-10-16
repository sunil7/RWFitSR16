package androidx.activity;

import androidx.camera.core.impl.h0;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements k1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f367a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f368b;

    public /* synthetic */ k(Object obj, int i3) {
        this.f367a = i3;
        this.f368b = obj;
    }

    @Override // k1.a
    public final void f(Object obj) {
        switch (this.f367a) {
            case 0:
                o oVar = (o) this.f368b;
                oVar.getClass();
                if (ic.b()) {
                    oVar.c();
                    break;
                }
                break;
            case 1:
                t.l lVar = (t.l) obj;
                for (Map.Entry entry : ((Map) this.f368b).entrySet()) {
                    int i3 = lVar.f18355b - ((e0.b) entry.getKey()).f12415f;
                    if (((e0.b) entry.getKey()).f12416g) {
                        i3 = -i3;
                    }
                    int f2 = v.d.f(i3);
                    c0.n nVar = (c0.n) entry.getValue();
                    nVar.getClass();
                    y5.c(new c0.k(nVar, f2, -1));
                }
                break;
            case 2:
                a0.a("SurfaceViewImpl", "Safe to release surface.");
                h0 h0Var = (h0) this.f368b;
                if (h0Var != null) {
                    h0Var.a();
                    break;
                }
                break;
            case 3:
                ((androidx.concurrent.futures.b) this.f368b).a((t.k) obj);
                break;
            default:
                ((u.c) this.f368b).getClass();
                y5.a();
                break;
        }
    }
}
