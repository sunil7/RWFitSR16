package pe;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* loaded from: classes2.dex */
public final class l extends Binder implements te.b {
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // te.b
    public final void l(MessageSnapshot messageSnapshot) {
        ue.c.f19065a.a(messageSnapshot);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i10) {
        if (i3 == 1) {
            parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            l(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
        if (i3 != 1598968902) {
            return super.onTransact(i3, parcel, parcel2, i10);
        }
        parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
        return true;
    }
}
