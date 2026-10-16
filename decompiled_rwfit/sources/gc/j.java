package gc;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import androidx.work.WorkInfo$State;
import com.example.test.ui.device.activity.f0;
import com.google.mlkit.common.MlKitException;
import ia.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import y2.n;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14041a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14042b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f14043c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f14044d;
    public final /* synthetic */ Object e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f14045f;

    public /* synthetic */ j(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i3) {
        this.f14041a = i3;
        this.f14045f = obj;
        this.f14042b = obj2;
        this.f14043c = obj3;
        this.f14044d = obj4;
        this.e = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14041a) {
            case 0:
                mc.e eVar = (mc.e) this.f14042b;
                f0 f0Var = (f0) this.f14043c;
                f0 f0Var2 = (f0) this.f14044d;
                Callable callable = (Callable) this.e;
                ia.g gVar = (ia.g) this.f14045f;
                eVar.getClass();
                try {
                    if (((m) f0Var.f7859b).e()) {
                        f0Var2.n();
                        return;
                    }
                    try {
                        if (!eVar.f16015c.get()) {
                            synchronized (eVar) {
                                eVar.f16020i = eVar.e.b();
                            }
                            eVar.f16015c.set(true);
                        }
                        if (((m) f0Var.f7859b).e()) {
                            f0Var2.n();
                            return;
                        }
                        Object call = callable.call();
                        if (((m) f0Var.f7859b).e()) {
                            f0Var2.n();
                            return;
                        } else {
                            gVar.a(call);
                            return;
                        }
                    } catch (RuntimeException e) {
                        throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e);
                    }
                } catch (Exception e10) {
                    if (((m) f0Var.f7859b).e()) {
                        f0Var2.n();
                        return;
                    } else {
                        gVar.f14382a.g(e10);
                        return;
                    }
                }
            case 1:
                IBinder binder = ((Messenger) ((mc.g) this.f14042b).f16022b).getBinder();
                xg.b bVar = (xg.b) this.f14045f;
                y1.a aVar = (y1.a) ((MediaBrowserServiceCompat) bVar.f19825a).f2426d.getOrDefault(binder, null);
                String str = (String) this.f14043c;
                if (aVar == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    return;
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) bVar.f19825a;
                HashMap hashMap = aVar.e;
                List list = (List) hashMap.get(str);
                if (list == null) {
                    list = new ArrayList();
                }
                Iterator it = list.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    IBinder iBinder = (IBinder) this.f14044d;
                    Bundle bundle = (Bundle) this.e;
                    if (!hasNext) {
                        list.add(new k1.c(iBinder, bundle));
                        hashMap.put(str, list);
                        if (bundle == null) {
                            mediaBrowserServiceCompat.b();
                        } else {
                            mediaBrowserServiceCompat.b();
                        }
                        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + aVar.f19914a + " id=" + str);
                    }
                    k1.c cVar = (k1.c) it.next();
                    if (iBinder == cVar.f15450a) {
                        Bundle bundle2 = (Bundle) cVar.f15451b;
                        if (bundle == bundle2) {
                            return;
                        }
                        if (bundle == null) {
                            if (bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                                return;
                            }
                        } else if (bundle2 == null) {
                            if (bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                                return;
                            }
                        } else if (bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
                            return;
                        }
                    }
                }
                break;
            case 2:
                IBinder binder2 = ((Messenger) ((mc.g) this.f14042b).f16022b).getBinder();
                xg.b bVar2 = (xg.b) this.f14045f;
                if (((y1.a) ((MediaBrowserServiceCompat) bVar2.f19825a).f2426d.getOrDefault(binder2, null)) != null) {
                    ((MediaBrowserServiceCompat) bVar2.f19825a).getClass();
                    ((ResultReceiver) this.e).b(-1, null);
                    return;
                }
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + ((String) this.f14043c) + ", extras=" + ((Bundle) this.f14044d));
                return;
            default:
                try {
                    if (!(((androidx.work.impl.utils.futures.b) this.f14042b).f20203a instanceof z2.a)) {
                        String uuid = ((UUID) this.f14043c).toString();
                        WorkInfo$State f2 = ((n) this.f14045f).f19977c.f(uuid);
                        if (f2 == null || f2.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        ((n) this.f14045f).f19976b.f(uuid, (o2.g) this.f14044d);
                        ((Context) this.e).startService(w2.a.b((Context) this.e, uuid, (o2.g) this.f14044d));
                    }
                    ((androidx.work.impl.utils.futures.b) this.f14042b).j(null);
                    return;
                } catch (Throwable th2) {
                    ((androidx.work.impl.utils.futures.b) this.f14042b).k(th2);
                    return;
                }
        }
    }

    public /* synthetic */ j(mc.e eVar, f0 f0Var, f0 f0Var2, Callable callable, ia.g gVar) {
        this.f14041a = 0;
        this.f14042b = eVar;
        this.f14043c = f0Var;
        this.f14044d = f0Var2;
        this.e = callable;
        this.f14045f = gVar;
    }
}
