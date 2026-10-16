package te;

import android.os.IBinder;
import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot;

/* loaded from: classes2.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f18615a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f18615a;
    }

    @Override // te.b
    public final void l(MessageSnapshot messageSnapshot) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            if (messageSnapshot != null) {
                obtain.writeInt(1);
                messageSnapshot.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f18615a.transact(1, obtain, null, 1);
            obtain.recycle();
        } catch (Throwable th2) {
            obtain.recycle();
            throw th2;
        }
    }
}
