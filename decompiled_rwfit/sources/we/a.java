package we;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent$ConnectStatus;
import com.liulishuo.filedownloader.services.FileDownloadService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import n.m0;
import pe.l;
import pe.r;

/* loaded from: classes2.dex */
public abstract class a implements r, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final l f19614a;

    /* renamed from: b, reason: collision with root package name */
    public volatile te.e f19615b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f19616c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19617d = false;
    public final ArrayList e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f19618f;

    public a() {
        new HashMap();
        this.e = new ArrayList();
        this.f19618f = new ArrayList();
        this.f19616c = FileDownloadService.SeparateProcessService.class;
        l lVar = new l();
        lVar.attachInterface(lVar, "com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
        this.f19614a = lVar;
    }

    @Override // pe.r
    public final boolean b() {
        return this.f19615b != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [te.e] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        te.c cVar;
        int i3 = te.d.f18617a;
        if (iBinder == null) {
            cVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof te.e)) {
                te.c cVar2 = new te.c();
                cVar2.f18616a = iBinder;
                cVar = cVar2;
            } else {
                cVar = (te.e) queryLocalInterface;
            }
        }
        this.f19615b = cVar;
        try {
            this.f19615b.n(this.f19614a);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List list = (List) this.f19618f.clone();
        this.f19618f.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        pe.d.f17561a.b(new m0(DownloadServiceConnectChangedEvent$ConnectStatus.connected, 17));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f19615b = null;
        pe.d.f17561a.b(new m0(DownloadServiceConnectChangedEvent$ConnectStatus.lost, 17));
    }

    @Override // pe.r
    public final boolean p() {
        return this.f19617d;
    }

    @Override // pe.r
    public final void s(Context context) {
        if (ye.e.f(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        Intent intent = new Intent(context, (Class<?>) this.f19616c);
        ArrayList arrayList = this.e;
        if (!arrayList.contains(context)) {
            arrayList.add(context);
        }
        boolean j4 = ye.e.j(context);
        this.f19617d = j4;
        intent.putExtra("is_foreground", j4);
        context.bindService(intent, this, 1);
        if (this.f19617d) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
