package q9;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;

/* loaded from: classes.dex */
public final class m implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f17828a;

    public m(IBinder iBinder) {
        this.f17828a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f17828a;
    }

    public final void g(q qVar, GetServiceRequest getServiceRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(qVar);
            obtain.writeInt(1);
            o.a(getServiceRequest, obtain, 0);
            this.f17828a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
