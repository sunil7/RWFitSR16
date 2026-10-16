package o9;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* loaded from: classes.dex */
public final class w extends q {

    /* renamed from: b, reason: collision with root package name */
    public final j f16902b;

    /* renamed from: c, reason: collision with root package name */
    public final ia.g f16903c;

    /* renamed from: d, reason: collision with root package name */
    public final ec.a f16904d;

    public w(int i3, j jVar, ia.g gVar, ec.a aVar) {
        super(i3);
        this.f16903c = gVar;
        this.f16902b = jVar;
        this.f16904d = aVar;
        if (i3 == 2 && jVar.f16865b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // o9.q
    public final boolean a(n nVar) {
        return this.f16902b.f16865b;
    }

    @Override // o9.q
    public final Feature[] b(n nVar) {
        return this.f16902b.f16864a;
    }

    @Override // o9.q
    public final void c(Status status) {
        this.f16904d.getClass();
        this.f16903c.b(status.k() ? new ResolvableApiException(status) : new ApiException(status));
    }

    @Override // o9.q
    public final void d(RuntimeException runtimeException) {
        this.f16903c.b(runtimeException);
    }

    @Override // o9.q
    public final void e(n nVar) {
        ia.g gVar = this.f16903c;
        try {
            j jVar = this.f16902b;
            ((i) ((j) jVar.f16867d).f16867d).i(nVar.f16870b, gVar);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e10) {
            c(q.g(e10));
        } catch (RuntimeException e11) {
            gVar.b(e11);
        }
    }

    @Override // o9.q
    public final void f(o4.c cVar, boolean z5) {
        Boolean valueOf = Boolean.valueOf(z5);
        Map map = (Map) cVar.f16733b;
        ia.g gVar = this.f16903c;
        map.put(gVar, valueOf);
        o4.e eVar = new o4.e(cVar, gVar);
        ia.m mVar = gVar.f14382a;
        mVar.getClass();
        mVar.f14399b.f(new ia.i(ia.h.f14383a, eVar));
        mVar.k();
    }
}
