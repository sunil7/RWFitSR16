package com.amap.api.col.p0003sl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class x8 implements LBSTraceBase, LocationSource.OnLocationChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private Context f5375a;

    /* renamed from: b, reason: collision with root package name */
    private CoordinateConverter f5376b;

    /* renamed from: c, reason: collision with root package name */
    private qc f5377c;

    /* renamed from: d, reason: collision with root package name */
    private qc f5378d;

    /* renamed from: g, reason: collision with root package name */
    private TraceStatusListener f5380g;

    /* renamed from: h, reason: collision with root package name */
    private x1 f5381h;

    /* renamed from: m, reason: collision with root package name */
    private c f5386m;
    private long e = 2000;

    /* renamed from: f, reason: collision with root package name */
    private int f5379f = 5;

    /* renamed from: i, reason: collision with root package name */
    private List<TraceLocation> f5382i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private int f5383j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f5384k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f5385l = 0;

    /* renamed from: n, reason: collision with root package name */
    private TraceLocation f5387n = null;

    /* renamed from: o, reason: collision with root package name */
    private List<LatLng> f5388o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    private List<LatLng> f5389p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private List<LatLng> f5390q = new ArrayList();
    int r = Runtime.getRuntime().availableProcessors();

    /* renamed from: s, reason: collision with root package name */
    private BlockingQueue<Runnable> f5391s = new LinkedBlockingQueue();

    /* renamed from: t, reason: collision with root package name */
    private BlockingQueue<Runnable> f5392t = new LinkedBlockingQueue();

    public class a extends rc {

        /* renamed from: b, reason: collision with root package name */
        private int f5394b;

        /* renamed from: c, reason: collision with root package name */
        private int f5395c;

        /* renamed from: d, reason: collision with root package name */
        private List<TraceLocation> f5396d;

        /* renamed from: f, reason: collision with root package name */
        private TraceListener f5397f;

        /* renamed from: a, reason: collision with root package name */
        private List<TraceLocation> f5393a = new ArrayList();
        private String e = q4.a();

        /* renamed from: com.amap.api.col.3sl.x8$a$a, reason: collision with other inner class name */
        public class C0008a extends rc {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ w8 f5399a;

            public C0008a(a aVar, w8 w8Var) {
                this.f5399a = w8Var;
            }

            @Override // com.amap.api.col.p0003sl.rc
            public void runTask() {
                this.f5399a.run();
            }
        }

        public a(int i3, List<TraceLocation> list, int i10, TraceListener traceListener) {
            this.f5394b = i10;
            this.f5395c = i3;
            this.f5396d = list;
            this.f5397f = traceListener;
        }

        private int a() {
            int time;
            List<TraceLocation> list = this.f5396d;
            if (list == null || list.size() == 0) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (TraceLocation traceLocation : this.f5396d) {
                if (traceLocation != null) {
                    if (traceLocation.getSpeed() < 0.01d) {
                        arrayList.add(traceLocation);
                    } else {
                        int size = arrayList.size();
                        if (size > 1) {
                            TraceLocation traceLocation2 = (TraceLocation) arrayList.get(0);
                            TraceLocation traceLocation3 = (TraceLocation) arrayList.get(size - 1);
                            if (traceLocation2 != null && traceLocation3 != null) {
                                time = (int) ((traceLocation3.getTime() - traceLocation2.getTime()) / 1000);
                                i3 += time;
                                arrayList.clear();
                            }
                        }
                        time = 0;
                        i3 += time;
                        arrayList.clear();
                    }
                }
            }
            return i3;
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            try {
                x8.this.f5386m.a(this.f5397f);
                int a3 = a();
                List<TraceLocation> list = this.f5396d;
                if (list != null && list.size() >= 2) {
                    Iterator<TraceLocation> it = this.f5396d.iterator();
                    while (it.hasNext()) {
                        TraceLocation copy = it.next().copy();
                        if (copy != null && copy.getLatitude() > 0.0d && copy.getLongitude() > 0.0d) {
                            this.f5393a.add(copy);
                        }
                    }
                    int size = (this.f5393a.size() - 2) / 500;
                    y8.a().a(this.e, this.f5395c, size, a3);
                    int i3 = 500;
                    int i10 = 0;
                    while (i10 <= size) {
                        if (i10 == size) {
                            i3 = this.f5393a.size();
                        }
                        int i11 = i3;
                        ArrayList arrayList = new ArrayList();
                        for (int i12 = 0; i12 < i11; i12++) {
                            TraceLocation remove = this.f5393a.remove(0);
                            if (remove != null) {
                                int i13 = this.f5394b;
                                if (i13 != 1) {
                                    if (i13 == 3) {
                                        x8.this.f5376b.from(CoordinateConverter.CoordType.BAIDU);
                                    } else if (i13 == 2) {
                                        x8.this.f5376b.from(CoordinateConverter.CoordType.GPS);
                                    }
                                    x8.this.f5376b.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                    LatLng convert = x8.this.f5376b.convert();
                                    if (convert != null) {
                                        remove.setLatitude(convert.latitude);
                                        remove.setLongitude(convert.longitude);
                                    }
                                }
                                arrayList.add(remove);
                            }
                        }
                        if (arrayList.size() >= 2 && arrayList.size() <= 500) {
                            x8.this.f5378d.b(new C0008a(this, new w8(x8.this.f5375a, x8.this.f5386m, arrayList, this.e, this.f5395c, i10)));
                            i10++;
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        i3 = i11;
                    }
                    return;
                }
                y8.a().a(x8.this.f5386m, this.f5395c, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class b implements TraceListener {

        /* renamed from: a, reason: collision with root package name */
        private final List<TraceLocation> f5400a;

        public b(List<TraceLocation> list) {
            this.f5400a = list;
        }

        private void a(int i3, List<LatLng> list) {
            try {
                synchronized (x8.this.f5390q) {
                    x8.this.f5390q.clear();
                    x8.this.f5390q.addAll(list);
                }
                x8.this.f5389p.clear();
                if (i3 == 0) {
                    x8.this.f5389p.addAll(x8.this.f5390q);
                } else {
                    x8.this.f5389p.addAll(x8.this.f5388o);
                    x8.this.f5389p.addAll(x8.this.f5390q);
                }
                x8.this.f5380g.onTraceStatus(x8.this.f5382i, x8.this.f5389p, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public void onFinished(int i3, List<LatLng> list, int i10, int i11) {
            a(i3, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public void onRequestFailed(int i3, String str) {
            ArrayList arrayList = new ArrayList();
            if (x8.this.f5390q != null) {
                arrayList.addAll(x8.this.f5390q);
            }
            List<TraceLocation> list = this.f5400a;
            if (list != null) {
                int size = list.size();
                if (this.f5400a.size() > x8.this.f5379f) {
                    for (int i10 = size - x8.this.f5379f; i10 < size; i10++) {
                        TraceLocation traceLocation = this.f5400a.get(i10);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i3, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public void onTraceProcessing(int i3, int i10, List<LatLng> list) {
        }
    }

    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private TraceListener f5402a;

        public c(Looper looper) {
            super(looper);
        }

        public void a(TraceListener traceListener) {
            this.f5402a = traceListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (this.f5402a != null && (data = message.getData()) != null) {
                int i3 = data.getInt("lineID");
                switch (message.what) {
                    case 100:
                        this.f5402a.onTraceProcessing(i3, message.arg1, (List) message.obj);
                        break;
                    case 101:
                        this.f5402a.onFinished(i3, (List) message.obj, message.arg1, message.arg2);
                        break;
                    case 102:
                        this.f5402a.onRequestFailed(i3, (String) message.obj);
                        break;
                }
            }
        }
    }

    public x8(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5375a = applicationContext;
        this.f5376b = new CoordinateConverter(applicationContext);
        this.f5386m = new c(Looper.getMainLooper());
        i9.a().a(this.f5375a);
        this.f5377c = x.a(1, this.r * 2, this.f5391s, "AMapTraceManagerProcess");
        this.f5378d = x.a(1, this.r * 2, this.f5392t, "AMapTraceManagerRequest");
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void destroy() {
        try {
            stopTrace();
            qc qcVar = this.f5377c;
            if (qcVar != null) {
                qcVar.a();
                this.f5377c = null;
            }
            qc qcVar2 = this.f5378d;
            if (qcVar2 != null) {
                qcVar2.a();
                this.f5378d = null;
            }
            this.f5382i = null;
            this.f5380g = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f5375a = null;
        this.f5376b = null;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public void onLocationChanged(Location location) {
        TraceStatusListener traceStatusListener;
        if (this.f5380g != null) {
            try {
                if (System.currentTimeMillis() - this.f5385l >= 30000 && (traceStatusListener = this.f5380g) != null) {
                    traceStatusListener.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.f5385l = System.currentTimeMillis();
                Bundle extras = location.getExtras();
                int i3 = extras.getInt("errorCode");
                if (i3 != 0) {
                    Log.w("LBSTraceClient", "Locate failed [errorCode:\"" + i3 + "\"  errorInfo:" + extras.getString("errorInfo") + "\"]");
                    return;
                }
                synchronized (this.f5382i) {
                    try {
                        TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                        TraceLocation traceLocation2 = this.f5387n;
                        if (traceLocation2 != null && traceLocation2.getLatitude() == traceLocation.getLatitude() && traceLocation2.getLongitude() == traceLocation.getLongitude()) {
                            return;
                        }
                        this.f5382i.add(traceLocation);
                        this.f5387n = traceLocation;
                        int i10 = this.f5383j + 1;
                        this.f5383j = i10;
                        if (i10 == this.f5379f) {
                            this.f5384k += i10;
                            a();
                            this.f5383j = 0;
                        }
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void queryProcessedTrace(int i3, List<TraceLocation> list, int i10, TraceListener traceListener) {
        try {
            try {
                this.f5377c.b(new a(i3, list, i10, traceListener));
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setLocationInterval(long j4) {
        this.e = j4;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void setTraceStatusInterval(int i3) {
        this.f5379f = Math.max(i3, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void startTrace(TraceStatusListener traceStatusListener) {
        if (this.f5375a == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.f5385l = System.currentTimeMillis();
        this.f5380g = traceStatusListener;
        if (this.f5381h == null) {
            x1 x1Var = new x1(this.f5375a);
            this.f5381h = x1Var;
            x1Var.a(this.e);
            this.f5381h.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void stopTrace() {
        x1 x1Var = this.f5381h;
        if (x1Var != null) {
            x1Var.deactivate();
            this.f5381h = null;
        }
        this.f5391s.clear();
        this.f5392t.clear();
        List<TraceLocation> list = this.f5382i;
        if (list != null) {
            synchronized (list) {
                try {
                    List<TraceLocation> list2 = this.f5382i;
                    if (list2 != null) {
                        list2.clear();
                    }
                    this.f5384k = 0;
                    this.f5383j = 0;
                    this.f5385l = 0L;
                    this.f5387n = null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private void a() {
        int size = this.f5382i.size();
        if (size < this.f5379f) {
            return;
        }
        int i3 = 0;
        if (size <= 50) {
            ArrayList arrayList = new ArrayList(this.f5382i);
            queryProcessedTrace(0, arrayList, 1, new b(arrayList));
            return;
        }
        int i10 = size - 50;
        if (i10 < 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(this.f5382i.subList(i10 - this.f5379f, i10));
        synchronized (this.f5390q) {
            try {
                if (arrayList2.size() >= 1) {
                    if (this.f5390q.size() >= 1) {
                        int size2 = arrayList2.size();
                        LatLng latLng = null;
                        double d5 = 0.0d;
                        TraceLocation traceLocation = null;
                        double d8 = 0.0d;
                        while (i3 < size2) {
                            int i11 = i3 + 1;
                            TraceLocation traceLocation2 = (TraceLocation) arrayList2.get(i3);
                            if (traceLocation2 != null) {
                                if (traceLocation != null) {
                                    double a3 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                                    if (a3 <= 100.0d) {
                                        d8 += a3;
                                    }
                                }
                                i3 = i11;
                                traceLocation = traceLocation2;
                            }
                            i3 = i11;
                        }
                        Iterator<LatLng> it = this.f5390q.iterator();
                        while (it.hasNext()) {
                            LatLng next = it.next();
                            if (next == null) {
                                it.remove();
                            } else {
                                if (latLng != null) {
                                    d5 += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                    if (d5 >= d8) {
                                        break;
                                    }
                                    this.f5388o.add(next);
                                    it.remove();
                                } else {
                                    this.f5388o.add(next);
                                    it.remove();
                                }
                                latLng = next;
                            }
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList3 = new ArrayList(this.f5382i.subList(i10, size));
        queryProcessedTrace(i10, arrayList3, 1, new b(arrayList3));
    }

    private double a(double d5, double d8, double d10, double d11) {
        double d12 = d5 > d10 ? d5 - d10 : d10 - d5;
        double d13 = d8 > d11 ? d8 - d11 : d11 - d8;
        return Math.sqrt((d13 * d13) + (d12 * d12));
    }
}
