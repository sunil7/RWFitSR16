package we;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.appcompat.widget.b0;
import com.google.android.gms.internal.mlkit_common.o;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.services.FileDownloadService;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class b extends te.d implements ue.d, e {

    /* renamed from: b, reason: collision with root package name */
    public final RemoteCallbackList f19619b = new RemoteCallbackList();

    /* renamed from: c, reason: collision with root package name */
    public final o4.c f19620c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f19621d;

    public b(WeakReference weakReference, o4.c cVar) {
        this.f19621d = weakReference;
        this.f19620c = cVar;
        ue.e eVar = ue.c.f19065a;
        eVar.f19067b = this;
        eVar.f19066a = new o4.e(this);
    }

    @Override // te.e
    public final byte a(int i3) {
        FileDownloadModel L = ((re.a) this.f19620c.f16732a).L(i3);
        if (L == null) {
            return (byte) 0;
        }
        return L.k();
    }

    @Override // te.e
    public final boolean c(int i3) {
        return this.f19620c.l(i3);
    }

    @Override // te.e
    public final boolean d(int i3) {
        return this.f19620c.c(i3);
    }

    @Override // ue.d
    public final void g(MessageSnapshot messageSnapshot) {
        RemoteCallbackList remoteCallbackList;
        synchronized (this) {
            try {
                int beginBroadcast = this.f19619b.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        try {
                            ((te.b) this.f19619b.getBroadcastItem(i3)).l(messageSnapshot);
                        } catch (RemoteException e) {
                            o6.a(6, this, e, "callback error", new Object[0]);
                            remoteCallbackList = this.f19619b;
                        }
                    } catch (Throwable th2) {
                        this.f19619b.finishBroadcast();
                        throw th2;
                    }
                }
                remoteCallbackList = this.f19619b;
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // te.e
    public final void h(String str, String str2, boolean z5, int i3, int i10, int i11, boolean z6, FileDownloadHeader fileDownloadHeader, boolean z8) {
        this.f19620c.o(str, str2, z5, i3, i10, i11, z6, fileDownloadHeader, z8);
    }

    @Override // te.e
    public final long i(int i3) {
        FileDownloadModel L = ((re.a) this.f19620c.f16732a).L(i3);
        if (L == null) {
            return 0L;
        }
        return L.n();
    }

    @Override // te.e
    public final void j(boolean z5) {
        WeakReference weakReference = this.f19621d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((FileDownloadService) weakReference.get()).stopForeground(z5);
    }

    @Override // we.e
    public final void k() {
    }

    @Override // we.e
    public final IBinder m() {
        return this;
    }

    @Override // te.e
    public final void n(te.b bVar) {
        this.f19619b.register(bVar);
    }

    @Override // te.e
    public final boolean p() {
        int size;
        b0 b0Var = (b0) this.f19620c.f16733b;
        synchronized (b0Var) {
            b0Var.d();
            size = ((SparseArray) b0Var.f873b).size();
        }
        return size <= 0;
    }

    @Override // te.e
    public final long q(int i3) {
        return this.f19620c.f(i3);
    }

    @Override // te.e
    public final void r() {
        ((re.a) this.f19620c.f16732a).clear();
    }

    @Override // te.e
    public final void s(te.b bVar) {
        this.f19619b.unregister(bVar);
    }

    @Override // te.e
    public final boolean t(String str, String str2) {
        o4.c cVar = this.f19620c;
        cVar.getClass();
        int i3 = ye.e.f20123a;
        com.liulishuo.filedownloader.download.c.f11405a.g().getClass();
        return cVar.j(((re.a) cVar.f16732a).L(o.a(str, str2, false)));
    }

    @Override // te.e
    public final boolean u(int i3) {
        boolean g10;
        o4.c cVar = this.f19620c;
        synchronized (cVar) {
            g10 = ((b0) cVar.f16733b).g(i3);
        }
        return g10;
    }

    @Override // te.e
    public final void v(int i3, Notification notification) {
        WeakReference weakReference = this.f19621d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((FileDownloadService) weakReference.get()).startForeground(i3, notification);
    }

    @Override // te.e
    public final void w() {
        this.f19620c.m();
    }
}
