package q9;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzk;

/* loaded from: classes.dex */
public final class q extends com.google.android.gms.internal.mlkit_vision_barcode.g {

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.internal.a f17834b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17835c;

    public q(com.google.android.gms.common.internal.a aVar, int i3) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 2);
        this.f17834b = aVar;
        this.f17835c = i3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.g
    public final boolean z(int i3, Parcel parcel, Parcel parcel2) {
        if (i3 == 1) {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) ea.a.a(parcel, Bundle.CREATOR);
            ea.a.b(parcel);
            n.f(this.f17834b, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar = this.f17834b;
            aVar.getClass();
            s sVar = new s(aVar, readInt, readStrongBinder, bundle);
            p pVar = aVar.e;
            pVar.sendMessage(pVar.obtainMessage(1, this.f17835c, -1, sVar));
            this.f17834b = null;
        } else if (i3 == 2) {
            parcel.readInt();
            ea.a.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i3 != 3) {
                return false;
            }
            int readInt2 = parcel.readInt();
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) ea.a.a(parcel, zzk.CREATOR);
            ea.a.b(parcel);
            com.google.android.gms.common.internal.a aVar2 = this.f17834b;
            n.f(aVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            n.e(zzkVar);
            aVar2.f9131u = zzkVar;
            if (aVar2 instanceof u9.g) {
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.f9142d;
                e b3 = e.b();
                RootTelemetryConfiguration l3 = connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.l();
                synchronized (b3) {
                    if (l3 == null) {
                        l3 = e.f17812c;
                    } else {
                        RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) b3.f17814a;
                        if (rootTelemetryConfiguration != null) {
                            if (rootTelemetryConfiguration.getVersion() < l3.getVersion()) {
                            }
                        }
                    }
                    b3.f17814a = l3;
                }
            }
            Bundle bundle2 = zzkVar.f9139a;
            n.f(this.f17834b, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar3 = this.f17834b;
            aVar3.getClass();
            s sVar2 = new s(aVar3, readInt2, readStrongBinder2, bundle2);
            p pVar2 = aVar3.e;
            pVar2.sendMessage(pVar2.obtainMessage(1, this.f17835c, -1, sVar2));
            this.f17834b = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
