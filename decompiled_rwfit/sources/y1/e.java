package y1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19927a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mc.g f19928b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19929c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f19930d;
    public final /* synthetic */ int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xg.b f19931f;

    public e(xg.b bVar, mc.g gVar, String str, int i3, int i10, Bundle bundle) {
        this.f19931f = bVar;
        this.f19928b = gVar;
        this.f19930d = str;
        this.f19929c = i3;
        this.e = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        switch (this.f19927a) {
            case 0:
                mc.g gVar = this.f19928b;
                Messenger messenger = (Messenger) gVar.f16022b;
                IBinder binder = messenger.getBinder();
                xg.b bVar = this.f19931f;
                ((MediaBrowserServiceCompat) bVar.f19825a).f2426d.remove(binder);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) bVar.f19825a;
                String str = this.f19930d;
                new a(mediaBrowserServiceCompat, str, this.f19929c, this.e, gVar);
                mediaBrowserServiceCompat.a();
                StringBuilder r = android.support.v4.media.session.e.r("No root for client ", str, " from service ");
                r.append(e.class.getName());
                Log.i("MBServiceCompat", r.toString());
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.arg1 = 2;
                    obtain.setData(null);
                    messenger.send(obtain);
                    break;
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=".concat(str));
                    return;
                }
            default:
                mc.g gVar2 = this.f19928b;
                IBinder binder2 = ((Messenger) gVar2.f16022b).getBinder();
                xg.b bVar2 = this.f19931f;
                ((MediaBrowserServiceCompat) bVar2.f19825a).f2426d.remove(binder2);
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = (MediaBrowserServiceCompat) bVar2.f19825a;
                Iterator it = mediaBrowserServiceCompat2.f2425c.iterator();
                while (true) {
                    aVar = null;
                    if (it.hasNext()) {
                        a aVar2 = (a) it.next();
                        if (aVar2.f19916c == this.f19929c) {
                            if (TextUtils.isEmpty(this.f19930d) || this.e <= 0) {
                                aVar = new a(mediaBrowserServiceCompat2, aVar2.f19914a, aVar2.f19915b, aVar2.f19916c, gVar2);
                            }
                            it.remove();
                        }
                    }
                }
                if (aVar == null) {
                    aVar = new a(mediaBrowserServiceCompat2, this.f19930d, this.e, this.f19929c, gVar2);
                }
                mediaBrowserServiceCompat2.f2426d.put(binder2, aVar);
                try {
                    binder2.linkToDeath(aVar, 0);
                    break;
                } catch (RemoteException unused2) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
        }
    }

    public e(xg.b bVar, mc.g gVar, int i3, String str, int i10, Bundle bundle) {
        this.f19931f = bVar;
        this.f19928b = gVar;
        this.f19929c = i3;
        this.f19930d = str;
        this.e = i10;
    }
}
