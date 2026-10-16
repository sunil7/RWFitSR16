package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class g extends Binder implements IInterface {
    public g(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public abstract boolean g(int i3, Parcel parcel, Parcel parcel2);

    @Override // android.os.Binder
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i10) throws RemoteException {
        if (i3 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i3, parcel, parcel2, i10)) {
            return true;
        }
        return g(i3, parcel, parcel2);
    }
}
