package o9;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.q6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class c implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public static final Status f16848o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* renamed from: p, reason: collision with root package name */
    public static final Status f16849p = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* renamed from: q, reason: collision with root package name */
    public static final Object f16850q = new Object();
    public static c r;

    /* renamed from: a, reason: collision with root package name */
    public long f16851a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16852b;

    /* renamed from: c, reason: collision with root package name */
    public TelemetryData f16853c;

    /* renamed from: d, reason: collision with root package name */
    public s9.b f16854d;
    public final Context e;

    /* renamed from: f, reason: collision with root package name */
    public final n9.b f16855f;

    /* renamed from: g, reason: collision with root package name */
    public final o4.c f16856g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f16857h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f16858i;

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f16859j;

    /* renamed from: k, reason: collision with root package name */
    public final m0.c f16860k;

    /* renamed from: l, reason: collision with root package name */
    public final m0.c f16861l;

    /* renamed from: m, reason: collision with root package name */
    public final c5.b f16862m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f16863n;

    public c(Looper looper, Context context) {
        n9.b bVar = n9.b.f16438d;
        this.f16851a = 10000L;
        this.f16852b = false;
        this.f16857h = new AtomicInteger(1);
        this.f16858i = new AtomicInteger(0);
        this.f16859j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f16860k = new m0.c(0);
        this.f16861l = new m0.c(0);
        this.f16863n = true;
        this.e = context;
        c5.b bVar2 = new c5.b(looper, this, 2);
        Looper.getMainLooper();
        this.f16862m = bVar2;
        this.f16855f = bVar;
        this.f16856g = new o4.c(7);
        PackageManager packageManager = context.getPackageManager();
        if (q6.f10089d == null) {
            q6.f10089d = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (q6.f10089d.booleanValue()) {
            this.f16863n = false;
        }
        bVar2.sendMessage(bVar2.obtainMessage(6));
    }

    public static Status c(a aVar, ConnectionResult connectionResult) {
        return new Status(17, l0.p("API: ", (String) aVar.f16841b.f8774c, " is not available on this device. Connection failed with: ", String.valueOf(connectionResult)), connectionResult.i(), connectionResult);
    }

    public static c e(Context context) {
        c cVar;
        HandlerThread handlerThread;
        synchronized (f16850q) {
            if (r == null) {
                synchronized (q9.x.f17852g) {
                    try {
                        handlerThread = q9.x.f17854i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            q9.x.f17854i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = q9.x.f17854i;
                        }
                    } finally {
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = n9.b.f16437c;
                r = new c(looper, applicationContext);
            }
            cVar = r;
        }
        return cVar;
    }

    public final boolean a() {
        if (this.f16852b) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) q9.e.b().f17814a;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.i()) {
            return false;
        }
        int i3 = ((SparseIntArray) this.f16856g.f16732a).get(203400000, -1);
        return i3 == -1 || i3 == 0;
    }

    public final boolean b(ConnectionResult connectionResult, int i3) {
        boolean z5;
        PendingIntent activity;
        Boolean bool;
        n9.b bVar = this.f16855f;
        Context context = this.e;
        bVar.getClass();
        synchronized (aa.a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = aa.a.f142a;
            if (context2 != null && (bool = aa.a.f143b) != null && context2 == applicationContext) {
                z5 = bool.booleanValue();
            }
            aa.a.f143b = null;
            boolean isInstantApp = applicationContext.getPackageManager().isInstantApp();
            aa.a.f143b = Boolean.valueOf(isInstantApp);
            aa.a.f142a = applicationContext;
            z5 = isInstantApp;
        }
        if (!z5) {
            if (connectionResult.j()) {
                activity = connectionResult.i();
            } else {
                Intent b3 = bVar.b(context, connectionResult.b(), null);
                activity = b3 != null ? PendingIntent.getActivity(context, 0, b3, 201326592) : null;
            }
            if (activity != null) {
                int b10 = connectionResult.b();
                int i10 = GoogleApiActivity.f9075b;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i3);
                intent.putExtra("notify_manager", true);
                bVar.g(context, b10, PendingIntent.getActivity(context, 0, intent, da.c.f12314a | AMapEngineUtils.HALF_MAX_P20_WIDTH));
                return true;
            }
        }
        return false;
    }

    public final n d(com.google.android.gms.common.api.f fVar) {
        ConcurrentHashMap concurrentHashMap = this.f16859j;
        a aVar = fVar.e;
        n nVar = (n) concurrentHashMap.get(aVar);
        if (nVar == null) {
            nVar = new n(this, fVar);
            concurrentHashMap.put(aVar, nVar);
        }
        if (nVar.f16870b.n()) {
            this.f16861l.add(aVar);
        }
        nVar.l();
        return nVar;
    }

    public final void f(ConnectionResult connectionResult, int i3) {
        if (b(connectionResult, i3)) {
            return;
        }
        c5.b bVar = this.f16862m;
        bVar.sendMessage(bVar.obtainMessage(5, i3, 0, connectionResult));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        n nVar;
        Feature[] b3;
        int i3 = message.what;
        long j4 = Const.L_GPS_REBOOT_INTERVAL;
        switch (i3) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j4 = 10000;
                }
                this.f16851a = j4;
                this.f16862m.removeMessages(12);
                for (a aVar : this.f16859j.keySet()) {
                    c5.b bVar = this.f16862m;
                    bVar.sendMessageDelayed(bVar.obtainMessage(12, aVar), this.f16851a);
                }
                return true;
            case 2:
                throw l0.f(message.obj);
            case 3:
                for (n nVar2 : this.f16859j.values()) {
                    q9.n.b(nVar2.f16880m.f16862m);
                    nVar2.f16878k = null;
                    nVar2.l();
                }
                return true;
            case 4:
            case 8:
            case 13:
                t tVar = (t) message.obj;
                n nVar3 = (n) this.f16859j.get(tVar.f16894c.e);
                if (nVar3 == null) {
                    nVar3 = d(tVar.f16894c);
                }
                if (!nVar3.f16870b.n() || this.f16858i.get() == tVar.f16893b) {
                    nVar3.n(tVar.f16892a);
                    return true;
                }
                tVar.f16892a.c(f16848o);
                nVar3.q();
                return true;
            case 5:
                int i10 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it = this.f16859j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        nVar = (n) it.next();
                        if (nVar.f16874g == i10) {
                        }
                    } else {
                        nVar = null;
                    }
                }
                if (nVar == null) {
                    Log.wtf("GoogleApiManager", l0.k(i10, "Could not find API instance ", " while trying to fail enqueued calls."), new Exception());
                    return true;
                }
                if (connectionResult.b() != 13) {
                    nVar.b(c(nVar.f16871c, connectionResult));
                    return true;
                }
                n9.b bVar2 = this.f16855f;
                int b10 = connectionResult.b();
                bVar2.getClass();
                AtomicBoolean atomicBoolean = n9.d.f16441a;
                nVar.b(new Status(17, l0.p("Error resolution was canceled by the user, original error message: ", ConnectionResult.l(b10), ": ", connectionResult.h()), null, null));
                return true;
            case 6:
                if (this.e.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.e.getApplicationContext();
                    b bVar3 = b.e;
                    synchronized (bVar3) {
                        try {
                            if (!bVar3.f16847d) {
                                application.registerActivityLifecycleCallbacks(bVar3);
                                application.registerComponentCallbacks(bVar3);
                                bVar3.f16847d = true;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    m mVar = new m(this);
                    synchronized (bVar3) {
                        bVar3.f16846c.add(mVar);
                    }
                    AtomicBoolean atomicBoolean2 = bVar3.f16845b;
                    boolean z5 = atomicBoolean2.get();
                    AtomicBoolean atomicBoolean3 = bVar3.f16844a;
                    if (!z5) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean2.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean3.set(true);
                        }
                    }
                    if (!atomicBoolean3.get()) {
                        this.f16851a = Const.L_GPS_REBOOT_INTERVAL;
                        return true;
                    }
                }
                return true;
            case 7:
                d((com.google.android.gms.common.api.f) message.obj);
                return true;
            case 9:
                if (this.f16859j.containsKey(message.obj)) {
                    n nVar4 = (n) this.f16859j.get(message.obj);
                    q9.n.b(nVar4.f16880m.f16862m);
                    if (nVar4.f16876i) {
                        nVar4.l();
                        return true;
                    }
                }
                return true;
            case 10:
                Iterator it2 = this.f16861l.iterator();
                while (true) {
                    m0.g gVar = (m0.g) it2;
                    if (!gVar.hasNext()) {
                        this.f16861l.clear();
                        return true;
                    }
                    n nVar5 = (n) this.f16859j.remove((a) gVar.next());
                    if (nVar5 != null) {
                        nVar5.q();
                    }
                }
            case 11:
                if (this.f16859j.containsKey(message.obj)) {
                    n nVar6 = (n) this.f16859j.get(message.obj);
                    c cVar = nVar6.f16880m;
                    q9.n.b(cVar.f16862m);
                    boolean z6 = nVar6.f16876i;
                    if (z6) {
                        if (z6) {
                            c cVar2 = nVar6.f16880m;
                            c5.b bVar4 = cVar2.f16862m;
                            a aVar2 = nVar6.f16871c;
                            bVar4.removeMessages(11, aVar2);
                            cVar2.f16862m.removeMessages(9, aVar2);
                            nVar6.f16876i = false;
                        }
                        nVar6.b(cVar.f16855f.c(cVar.e, n9.c.f16439a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.", null, null) : new Status(22, "API failed to connect while resuming due to an unknown error.", null, null));
                        nVar6.f16870b.e("Timing out connection while resuming.");
                        return true;
                    }
                }
                return true;
            case 12:
                if (this.f16859j.containsKey(message.obj)) {
                    n nVar7 = (n) this.f16859j.get(message.obj);
                    q9.n.b(nVar7.f16880m.f16862m);
                    com.google.android.gms.common.api.c cVar3 = nVar7.f16870b;
                    if (cVar3.b() && nVar7.f16873f.isEmpty()) {
                        o4.c cVar4 = nVar7.f16872d;
                        if (((Map) cVar4.f16732a).isEmpty() && ((Map) cVar4.f16733b).isEmpty()) {
                            cVar3.e("Timing out service connection.");
                            return true;
                        }
                        nVar7.h();
                    }
                    return true;
                }
                return true;
            case 14:
                throw l0.f(message.obj);
            case 15:
                o oVar = (o) message.obj;
                if (this.f16859j.containsKey(oVar.f16881a)) {
                    n nVar8 = (n) this.f16859j.get(oVar.f16881a);
                    if (nVar8.f16877j.contains(oVar) && !nVar8.f16876i) {
                        if (nVar8.f16870b.b()) {
                            nVar8.d();
                            return true;
                        }
                        nVar8.l();
                        return true;
                    }
                }
                return true;
            case 16:
                o oVar2 = (o) message.obj;
                if (this.f16859j.containsKey(oVar2.f16881a)) {
                    n nVar9 = (n) this.f16859j.get(oVar2.f16881a);
                    if (nVar9.f16877j.remove(oVar2)) {
                        c cVar5 = nVar9.f16880m;
                        cVar5.f16862m.removeMessages(15, oVar2);
                        cVar5.f16862m.removeMessages(16, oVar2);
                        Feature feature = oVar2.f16882b;
                        LinkedList<q> linkedList = nVar9.f16869a;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        for (q qVar : linkedList) {
                            if (qVar != null && (b3 = qVar.b(nVar9)) != null) {
                                int length = b3.length;
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= length) {
                                        break;
                                    }
                                    if (!q9.n.h(b3[i11], feature)) {
                                        i11++;
                                    } else if (i11 >= 0) {
                                        arrayList.add(qVar);
                                    }
                                }
                            }
                        }
                        int size = arrayList.size();
                        for (int i12 = 0; i12 < size; i12++) {
                            q qVar2 = (q) arrayList.get(i12);
                            linkedList.remove(qVar2);
                            qVar2.d(new UnsupportedApiCallException(feature));
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.f16853c;
                if (telemetryData != null) {
                    if (telemetryData.b() > 0 || a()) {
                        if (this.f16854d == null) {
                            this.f16854d = new s9.b(this.e, s9.b.f18216i, q9.f.f17815b, com.google.android.gms.common.api.e.f9078b);
                        }
                        this.f16854d.c(telemetryData);
                    }
                    this.f16853c = null;
                    return true;
                }
                return true;
            case 18:
                s sVar = (s) message.obj;
                if (sVar.f16890c == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(sVar.f16889b, Arrays.asList(sVar.f16888a));
                    if (this.f16854d == null) {
                        this.f16854d = new s9.b(this.e, s9.b.f18216i, q9.f.f17815b, com.google.android.gms.common.api.e.f9078b);
                    }
                    this.f16854d.c(telemetryData2);
                    return true;
                }
                TelemetryData telemetryData3 = this.f16853c;
                if (telemetryData3 != null) {
                    List h4 = telemetryData3.h();
                    if (telemetryData3.b() != sVar.f16889b || (h4 != null && h4.size() >= sVar.f16891d)) {
                        this.f16862m.removeMessages(17);
                        TelemetryData telemetryData4 = this.f16853c;
                        if (telemetryData4 != null) {
                            if (telemetryData4.b() > 0 || a()) {
                                if (this.f16854d == null) {
                                    this.f16854d = new s9.b(this.e, s9.b.f18216i, q9.f.f17815b, com.google.android.gms.common.api.e.f9078b);
                                }
                                this.f16854d.c(telemetryData4);
                            }
                            this.f16853c = null;
                        }
                    } else {
                        this.f16853c.i(sVar.f16888a);
                    }
                }
                if (this.f16853c == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(sVar.f16888a);
                    this.f16853c = new TelemetryData(sVar.f16889b, arrayList2);
                    c5.b bVar5 = this.f16862m;
                    bVar5.sendMessageDelayed(bVar5.obtainMessage(17), sVar.f16890c);
                    return true;
                }
                return true;
            case 19:
                this.f16852b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i3);
                return false;
        }
    }
}
