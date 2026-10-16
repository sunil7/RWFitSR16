package c0;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a6;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f3322a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f3323b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3324c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t.i f3325d;
    public final /* synthetic */ t.i e;

    public /* synthetic */ l(n nVar, m mVar, int i3, t.i iVar, t.i iVar2) {
        this.f3322a = nVar;
        this.f3323b = mVar;
        this.f3324c = i3;
        this.f3325d = iVar;
        this.e = iVar2;
    }

    @Override // x.a
    /* renamed from: apply */
    public final ob.a mo0apply(Object obj) {
        m mVar = this.f3323b;
        Surface surface = (Surface) obj;
        n nVar = this.f3322a;
        nVar.getClass();
        surface.getClass();
        try {
            mVar.d();
            o oVar = new o(surface, this.f3324c, nVar.f3334g.f1405a, this.f3325d, this.e);
            oVar.f3351j.f16358b.a(new j(mVar, 1), a6.a());
            pd.f("Consumer can only be linked once.", mVar.r == null);
            mVar.r = oVar;
            return x.i.c(oVar);
        } catch (DeferrableSurface$SurfaceClosedException e) {
            return new x.k(e, 1);
        }
    }
}
