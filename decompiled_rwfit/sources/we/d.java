package we;

import android.app.Notification;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.appcompat.widget.b0;
import com.google.android.gms.internal.mlkit_common.o;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent$ConnectStatus;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.services.FileDownloadService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.m0;
import pe.j;
import pe.k;
import pe.r;

/* loaded from: classes2.dex */
public final class d extends te.d implements e {

    /* renamed from: b, reason: collision with root package name */
    public final o4.c f19622b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference f19623c;

    public d(WeakReference weakReference, o4.c cVar) {
        this.f19623c = weakReference;
        this.f19622b = cVar;
    }

    @Override // te.e
    public final byte a(int i3) {
        FileDownloadModel L = ((re.a) this.f19622b.f16732a).L(i3);
        if (L == null) {
            return (byte) 0;
        }
        return L.k();
    }

    @Override // te.e
    public final boolean c(int i3) {
        return this.f19622b.l(i3);
    }

    @Override // te.e
    public final boolean d(int i3) {
        return this.f19622b.c(i3);
    }

    @Override // te.e
    public final void h(String str, String str2, boolean z5, int i3, int i10, int i11, boolean z6, FileDownloadHeader fileDownloadHeader, boolean z8) {
        this.f19622b.o(str, str2, z5, i3, i10, i11, z6, fileDownloadHeader, z8);
    }

    @Override // te.e
    public final long i(int i3) {
        FileDownloadModel L = ((re.a) this.f19622b.f16732a).L(i3);
        if (L == null) {
            return 0L;
        }
        return L.n();
    }

    @Override // te.e
    public final void j(boolean z5) {
        WeakReference weakReference = this.f19623c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((FileDownloadService) weakReference.get()).stopForeground(z5);
    }

    @Override // we.e
    public final void k() {
        r rVar = (r) j.f17574a.f16254b;
        k kVar = (k) (rVar instanceof k ? (c) rVar : null);
        kVar.f17577c = this;
        ArrayList arrayList = kVar.f17576b;
        List list = (List) arrayList.clone();
        arrayList.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        pe.d.f17561a.b(new m0(DownloadServiceConnectChangedEvent$ConnectStatus.connected, 17));
    }

    @Override // we.e
    public final IBinder m() {
        return null;
    }

    @Override // te.e
    public final void n(te.b bVar) {
    }

    @Override // te.e
    public final boolean p() {
        int size;
        b0 b0Var = (b0) this.f19622b.f16733b;
        synchronized (b0Var) {
            b0Var.d();
            size = ((SparseArray) b0Var.f873b).size();
        }
        return size <= 0;
    }

    @Override // te.e
    public final long q(int i3) {
        return this.f19622b.f(i3);
    }

    @Override // te.e
    public final void r() {
        ((re.a) this.f19622b.f16732a).clear();
    }

    @Override // te.e
    public final void s(te.b bVar) {
    }

    @Override // te.e
    public final boolean t(String str, String str2) {
        o4.c cVar = this.f19622b;
        cVar.getClass();
        int i3 = ye.e.f20123a;
        com.liulishuo.filedownloader.download.c.f11405a.g().getClass();
        return cVar.j(((re.a) cVar.f16732a).L(o.a(str, str2, false)));
    }

    @Override // te.e
    public final boolean u(int i3) {
        boolean g10;
        o4.c cVar = this.f19622b;
        synchronized (cVar) {
            g10 = ((b0) cVar.f16733b).g(i3);
        }
        return g10;
    }

    @Override // te.e
    public final void v(int i3, Notification notification) {
        WeakReference weakReference = this.f19623c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((FileDownloadService) weakReference.get()).startForeground(i3, notification);
    }

    @Override // te.e
    public final void w() {
        this.f19622b.m();
    }
}
