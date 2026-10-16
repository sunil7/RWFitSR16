package q9;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class s extends k {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f17838g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f17839h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(com.google.android.gms.common.internal.a aVar, int i3, IBinder iBinder, Bundle bundle) {
        super(aVar, i3, bundle);
        this.f17839h = aVar;
        this.f17838g = iBinder;
    }

    @Override // q9.k
    public final void a(ConnectionResult connectionResult) {
        i iVar = this.f17839h.f9126o;
        if (iVar != null) {
            iVar.f17822a.m(connectionResult);
        }
        System.currentTimeMillis();
    }

    @Override // q9.k
    public final boolean b() {
        IBinder iBinder = this.f17838g;
        try {
            n.e(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            com.google.android.gms.common.internal.a aVar = this.f17839h;
            if (!aVar.r().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + aVar.r() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface a3 = aVar.a(iBinder);
            if (a3 == null || !(com.google.android.gms.common.internal.a.u(aVar, 2, 4, a3) || com.google.android.gms.common.internal.a.u(aVar, 3, 4, a3))) {
                return false;
            }
            aVar.f9129s = null;
            e eVar = aVar.f9125n;
            if (eVar == null) {
                return true;
            }
            ((com.google.android.gms.common.api.g) eVar.f17814a).k();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
