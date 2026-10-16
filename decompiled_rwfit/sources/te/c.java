package te;

import android.os.IBinder;
import android.os.Parcel;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

/* loaded from: classes2.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f18616a;

    @Override // te.e
    public final byte a(int i3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            obtain.writeInt(i3);
            this.f18616a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readByte();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f18616a;
    }

    @Override // te.e
    public final boolean c(int i3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            obtain.writeInt(i3);
            this.f18616a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // te.e
    public final void h(String str, String str2, boolean z5, int i3, int i10, int i11, boolean z6, FileDownloadHeader fileDownloadHeader, boolean z8) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(z5 ? 1 : 0);
            obtain.writeInt(100);
            obtain.writeInt(10);
            obtain.writeInt(0);
            obtain.writeInt(0);
            obtain.writeInt(0);
            obtain.writeInt(0);
            this.f18616a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // te.e
    public final void j(boolean z5) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            obtain.writeInt(1);
            this.f18616a.transact(13, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // te.e
    public final void n(b bVar) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.f18616a.transact(1, obtain, null, 1);
            obtain.recycle();
        } catch (Throwable th2) {
            obtain.recycle();
            throw th2;
        }
    }

    @Override // te.e
    public final void s(b bVar) {
        throw null;
    }

    @Override // te.e
    public final void w() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            this.f18616a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
