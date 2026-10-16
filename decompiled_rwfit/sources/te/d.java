package te;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

/* loaded from: classes2.dex */
public abstract class d extends Binder implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18617a = 0;

    public d() {
        attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCService");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i10) {
        if (i3 == 1598968902) {
            parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            return true;
        }
        switch (i3) {
            case 1:
                b bVar = null;
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                        a aVar = new a();
                        aVar.f18615a = readStrongBinder;
                        bVar = aVar;
                    } else {
                        bVar = (b) queryLocalInterface;
                    }
                }
                n(bVar);
                return true;
            case 2:
                b bVar2 = null;
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                    if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof b)) {
                        a aVar2 = new a();
                        aVar2.f18615a = readStrongBinder2;
                        bVar2 = aVar2;
                    } else {
                        bVar2 = (b) queryLocalInterface2;
                    }
                }
                s(bVar2);
                return true;
            case 3:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                boolean t8 = t(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(t8 ? 1 : 0);
                return true;
            case 4:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                FileDownloadHeader fileDownloadHeader = null;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean z5 = parcel.readInt() != 0;
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                boolean z6 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    fileDownloadHeader = FileDownloadHeader.CREATOR.createFromParcel(parcel);
                }
                h(readString, readString2, z5, readInt, readInt2, readInt3, z6, fileDownloadHeader, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                boolean c9 = c(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(c9 ? 1 : 0);
                return true;
            case 6:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                w();
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                boolean u10 = u(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(u10 ? 1 : 0);
                return true;
            case 8:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                long q5 = q(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(q5);
                return true;
            case 9:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                long i11 = i(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(i11);
                return true;
            case 10:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                byte a3 = a(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeByte(a3);
                return true;
            case 11:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                boolean p8 = p();
                parcel2.writeNoException();
                parcel2.writeInt(p8 ? 1 : 0);
                return true;
            case 12:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                v(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 13:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                j(parcel.readInt() != 0);
                return true;
            case 14:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                boolean d5 = d(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(d5 ? 1 : 0);
                return true;
            case 15:
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                r();
                parcel2.writeNoException();
                return true;
            default:
                return super.onTransact(i3, parcel, parcel2, i10);
        }
    }
}
