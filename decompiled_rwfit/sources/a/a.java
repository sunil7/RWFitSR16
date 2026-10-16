package a;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f1a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1a;
    }

    public final void g(String str, int i3, Notification notification) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(str);
            obtain.writeInt(i3);
            obtain.writeString(null);
            obtain.writeInt(1);
            notification.writeToParcel(obtain, 0);
            this.f1a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
