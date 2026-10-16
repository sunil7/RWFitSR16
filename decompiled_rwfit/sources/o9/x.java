package o9;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class x extends q {

    /* renamed from: b, reason: collision with root package name */
    public final ia.g f16905b;

    public x(f fVar, ia.g gVar) {
        super(4);
        this.f16905b = gVar;
    }

    @Override // o9.q
    public final boolean a(n nVar) {
        return false;
    }

    @Override // o9.q
    public final Feature[] b(n nVar) {
        return null;
    }

    @Override // o9.q
    public final void c(Status status) {
        this.f16905b.b(new ApiException(status));
    }

    @Override // o9.q
    public final void d(RuntimeException runtimeException) {
        this.f16905b.b(runtimeException);
    }

    @Override // o9.q
    public final void e(n nVar) {
        try {
            h(nVar);
        } catch (DeadObjectException e) {
            c(q.g(e));
            throw e;
        } catch (RemoteException e10) {
            c(q.g(e10));
        } catch (RuntimeException e11) {
            this.f16905b.b(e11);
        }
    }

    @Override // o9.q
    public final /* bridge */ /* synthetic */ void f(o4.c cVar, boolean z5) {
    }

    public final void h(n nVar) {
        ia.g gVar = this.f16905b;
        gVar.f14382a.j(Boolean.FALSE);
    }
}
