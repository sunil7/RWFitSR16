package com.dh.keeplive.entity;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IKeepLiveInterface extends IInterface {
    public static final String DESCRIPTOR = "com.dh.keeplive.entity.IKeepLiveInterface";

    public static class Default implements IKeepLiveInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.dh.keeplive.entity.IKeepLiveInterface
        public void connectionTimes(int i3) throws RemoteException {
        }

        @Override // com.dh.keeplive.entity.IKeepLiveInterface
        public void wakeup(KeepLiveConfig keepLiveConfig) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IKeepLiveInterface {
        static final int TRANSACTION_connectionTimes = 2;
        static final int TRANSACTION_wakeup = 1;

        public static class Proxy implements IKeepLiveInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.dh.keeplive.entity.IKeepLiveInterface
            public void connectionTimes(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IKeepLiveInterface.DESCRIPTOR);
                    obtain.writeInt(i3);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IKeepLiveInterface.DESCRIPTOR;
            }

            @Override // com.dh.keeplive.entity.IKeepLiveInterface
            public void wakeup(KeepLiveConfig keepLiveConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IKeepLiveInterface.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, keepLiveConfig, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IKeepLiveInterface.DESCRIPTOR);
        }

        public static IKeepLiveInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IKeepLiveInterface.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IKeepLiveInterface)) ? new Proxy(iBinder) : (IKeepLiveInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i10) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IKeepLiveInterface.DESCRIPTOR);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(IKeepLiveInterface.DESCRIPTOR);
                return true;
            }
            if (i3 == 1) {
                wakeup((KeepLiveConfig) _Parcel.readTypedObject(parcel, KeepLiveConfig.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            if (i3 != 2) {
                return super.onTransact(i3, parcel, parcel2, i10);
            }
            connectionTimes(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t8, int i3) {
            if (t8 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t8.writeToParcel(parcel, i3);
            }
        }
    }

    void connectionTimes(int i3) throws RemoteException;

    void wakeup(KeepLiveConfig keepLiveConfig) throws RemoteException;
}
