package b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f3038a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3038a;
    }

    @Override // b.b
    public final void x(int i3, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
            obtain.writeInt(i3);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3038a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
