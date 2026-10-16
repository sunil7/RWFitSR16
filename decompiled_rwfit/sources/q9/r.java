package q9;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class r implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f17836a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f17837b;

    public r(com.google.android.gms.common.internal.a aVar, int i3) {
        this.f17837b = aVar;
        this.f17836a = i3;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i3;
        int i10;
        com.google.android.gms.common.internal.a aVar = this.f17837b;
        if (iBinder == null) {
            synchronized (aVar.f9117f) {
                i3 = aVar.f9124m;
            }
            if (i3 == 3) {
                aVar.f9130t = true;
                i10 = 5;
            } else {
                i10 = 4;
            }
            p pVar = aVar.e;
            pVar.sendMessage(pVar.obtainMessage(i10, aVar.f9132v.get(), 16));
            return;
        }
        synchronized (aVar.f9118g) {
            try {
                com.google.android.gms.common.internal.a aVar2 = this.f17837b;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar2.f9119h = (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new m(iBinder) : (m) queryLocalInterface;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        com.google.android.gms.common.internal.a aVar3 = this.f17837b;
        int i11 = this.f17836a;
        aVar3.getClass();
        t tVar = new t(aVar3, 0);
        p pVar2 = aVar3.e;
        pVar2.sendMessage(pVar2.obtainMessage(7, i11, -1, tVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.a aVar;
        synchronized (this.f17837b.f9118g) {
            aVar = this.f17837b;
            aVar.f9119h = null;
        }
        int i3 = this.f17836a;
        p pVar = aVar.e;
        pVar.sendMessage(pVar.obtainMessage(6, i3, 1));
    }
}
