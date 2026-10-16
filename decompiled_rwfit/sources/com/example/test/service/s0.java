package com.example.test.service;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Message;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.example.blesdk.bean.function.ExchangeSportDataBean;
import com.example.blesdk.bean.function.SportDataBean;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes.dex */
public final class s0 implements SensorEventListener, AMapLocationListener, e6.c, o5.a {
    public static final Object N = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.test.service.SportNewHelper$Companion$sInstance$2
        @Override // oh.a
        public final s0 invoke() {
            return new s0();
        }
    });
    public int A;
    public boolean B;
    public boolean C;
    public float D;
    public boolean E;
    public boolean F;
    public boolean G;
    public long H;
    public long J;
    public int K;
    public float L;
    public boolean M;

    /* renamed from: a, reason: collision with root package name */
    public SensorManager f7781a;

    /* renamed from: b, reason: collision with root package name */
    public AMapLocationClient f7782b;

    /* renamed from: c, reason: collision with root package name */
    public float f7783c;

    /* renamed from: d, reason: collision with root package name */
    public float f7784d;
    public double e;

    /* renamed from: f, reason: collision with root package name */
    public double f7785f;

    /* renamed from: g, reason: collision with root package name */
    public double f7786g;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f7797s;

    /* renamed from: t, reason: collision with root package name */
    public long f7798t;

    /* renamed from: u, reason: collision with root package name */
    public Timer f7799u;

    /* renamed from: v, reason: collision with root package name */
    public long f7800v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7801w;

    /* renamed from: x, reason: collision with root package name */
    public User f7802x;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7787h = true;

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7788i = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$stepPaces$2
        @Override // oh.a
        public final HashMap<Integer, Float> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7789j = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$stepPacesMin$2
        @Override // oh.a
        public final HashMap<Integer, Float> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7790k = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$speedPaces$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7791l = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$speedPacesImperial$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final eh.b f7792m = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$kmTimeSec$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: n, reason: collision with root package name */
    public final eh.b f7793n = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$mileTimeSec$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public final eh.b f7794o = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$distanceMeter$2
        @Override // oh.a
        public final HashMap<Integer, Double> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: p, reason: collision with root package name */
    public final eh.b f7795p = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$distanceImperial$2
        @Override // oh.a
        public final HashMap<Integer, Double> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: q, reason: collision with root package name */
    public final eh.b f7796q = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$line$2
        @Override // oh.a
        public final List<LatLng> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: y, reason: collision with root package name */
    public final eh.b f7803y = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$dataCallbacks$2
        @Override // oh.a
        public final LinkedList<e6.b> invoke() {
            return new LinkedList<>();
        }
    });

    /* renamed from: z, reason: collision with root package name */
    public final eh.b f7804z = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportNewHelper$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(s0.this);
        }
    });
    public boolean I = true;

    public final void a() {
        double d5;
        double d8;
        int i3 = (int) (this.f7785f / 1000);
        int i10 = i3 + 1;
        eh.b bVar = this.f7792m;
        Long l3 = (Long) ((HashMap) bVar.getValue()).get(Integer.valueOf(i3));
        long longValue = l3 != null ? this.f7800v - l3.longValue() : this.f7800v;
        eh.b bVar2 = this.f7794o;
        Double d10 = (Double) ((HashMap) bVar2.getValue()).get(Integer.valueOf(i3));
        if (d10 != null) {
            d5 = longValue;
            d8 = this.f7785f - d10.doubleValue();
        } else {
            d5 = this.f7800v;
            d8 = this.f7785f;
        }
        long j4 = (long) (d5 / (d8 / 1000.0f));
        Integer valueOf = Integer.valueOf(i10);
        Long valueOf2 = Long.valueOf(j4);
        eh.b bVar3 = this.f7790k;
        ((HashMap) bVar3.getValue()).put(valueOf, valueOf2);
        ((HashMap) bVar.getValue()).put(Integer.valueOf(i10), Long.valueOf(this.f7800v));
        ((HashMap) bVar2.getValue()).put(Integer.valueOf(i10), Double.valueOf(this.f7785f));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前公里配速表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar3.getValue())));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前公里时间表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar.getValue())));
    }

    @Override // e6.c
    public final void b() {
        if (this.f7801w || this.M) {
            return;
        }
        this.f7800v++;
        if (this.f7785f > 20.0d) {
            c();
            a();
            long j4 = this.f7800v;
            double d5 = this.f7785f;
            this.f7797s = (long) (j4 / (d5 / 1000));
            this.f7798t = (long) (j4 / v1.b((float) d5));
        }
        if (this.f7800v >= 21600) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "运动超过6小时，自动结束");
            Iterator it = g().iterator();
            while (it.hasNext()) {
                ((e6.b) it.next()).W();
            }
            f();
        }
        i().removeMessages(1);
        i().sendEmptyMessage(1);
    }

    public final void c() {
        int b3 = (int) v1.b((float) this.f7785f);
        int i3 = b3 + 1;
        eh.b bVar = this.f7793n;
        Long l3 = (Long) ((HashMap) bVar.getValue()).get(Integer.valueOf(b3));
        long longValue = l3 != null ? this.f7800v - l3.longValue() : this.f7800v;
        eh.b bVar2 = this.f7795p;
        Double d5 = (Double) ((HashMap) bVar2.getValue()).get(Integer.valueOf(b3));
        long b10 = d5 != null ? (long) (longValue / v1.b((float) (this.f7785f - d5.doubleValue()))) : (long) (this.f7800v / v1.b((float) this.f7785f));
        Integer valueOf = Integer.valueOf(i3);
        Long valueOf2 = Long.valueOf(b10);
        eh.b bVar3 = this.f7791l;
        ((HashMap) bVar3.getValue()).put(valueOf, valueOf2);
        ((HashMap) bVar.getValue()).put(Integer.valueOf(i3), Long.valueOf(this.f7800v));
        ((HashMap) bVar2.getValue()).put(Integer.valueOf(i3), Double.valueOf(this.f7785f));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前英里配速表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar3.getValue())));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前英里时间表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar.getValue())));
    }

    public final void d() {
        int i3 = (int) (this.f7800v / 60);
        int i10 = i3 + 1;
        eh.b bVar = this.f7789j;
        Float f2 = (Float) ((HashMap) bVar.getValue()).get(Integer.valueOf(i3));
        float floatValue = f2 != null ? this.f7784d - f2.floatValue() : this.f7784d;
        Integer valueOf = Integer.valueOf(i10);
        Float valueOf2 = Float.valueOf(floatValue);
        eh.b bVar2 = this.f7788i;
        ((HashMap) bVar2.getValue()).put(valueOf, valueOf2);
        ((HashMap) bVar.getValue()).put(Integer.valueOf(i10), Float.valueOf(this.f7784d));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前步频表----：", com.example.baselibrary.utils.b.z((HashMap) bVar2.getValue())));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前步数时间表----：", com.example.baselibrary.utils.b.z((HashMap) bVar.getValue())));
    }

    public final void e() {
        User d5;
        com.example.test.utils.k a3 = y1.a();
        if (a3 != null) {
            SportTargetBean B = a3.B();
            com.example.test.utils.k a10 = y1.a();
            int isVibrator = a10 != null ? a10.B().isVibrator() : 1;
            if (this.f7800v / 60 >= B.getTime() && !this.E) {
                this.E = true;
                if (isVibrator == 1) {
                    ef.i.y().M(300L);
                }
                com.example.baselibrary.utils.d.a(R$string.str_time_goal_reached);
            }
            if (this.f7786g >= B.getCalorie() && !this.F) {
                this.F = true;
                if (isVibrator == 1) {
                    ef.i.y().M(300L);
                }
                com.example.baselibrary.utils.d.a(R$string.str_calorie_goal_reached);
            }
            com.example.test.utils.k a11 = y1.a();
            if (a11 == null || (d5 = a11.d()) == null) {
                return;
            }
            if (d5.getMeterUnit() == 0) {
                if (this.f7785f / 1000 < B.getDistance() || this.G) {
                    return;
                }
                this.G = true;
                if (isVibrator == 1) {
                    ef.i.y().M(300L);
                }
                com.example.baselibrary.utils.d.a(R$string.str_distance_goal_reached);
                return;
            }
            if (v1.b((float) this.f7785f) < B.getDistance() || this.G) {
                return;
            }
            this.G = true;
            if (isVibrator == 1) {
                ef.i.y().M(300L);
            }
            com.example.baselibrary.utils.d.a(R$string.str_distance_goal_reached);
        }
    }

    public final void f() {
        h6.b bVar = new h6.b();
        bVar.f14271g = this.f7786g;
        bVar.e = this.f7800v;
        bVar.f14270f = (long) this.f7784d;
        bVar.f14269d = this.r;
        bVar.f14268c = this.f7785f;
        int i3 = 1;
        ArrayList arrayList = new ArrayList(1);
        eh.b bVar2 = this.f7790k;
        int size = ((HashMap) bVar2.getValue()).size();
        if (1 <= size) {
            int i10 = 1;
            while (true) {
                arrayList.add(((HashMap) bVar2.getValue()).get(Integer.valueOf(i10)));
                if (i10 == size) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(1);
        eh.b bVar3 = this.f7791l;
        int size2 = ((HashMap) bVar3.getValue()).size();
        if (1 <= size2) {
            int i11 = 1;
            while (true) {
                arrayList2.add(((HashMap) bVar3.getValue()).get(Integer.valueOf(i11)));
                if (i11 == size2) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        ArrayList arrayList3 = new ArrayList(1);
        eh.b bVar4 = this.f7788i;
        int size3 = ((HashMap) bVar4.getValue()).size();
        if (1 <= size3) {
            while (true) {
                Float f2 = (Float) ((HashMap) bVar4.getValue()).get(Integer.valueOf(i3));
                if (f2 != null) {
                    arrayList3.add(Long.valueOf((long) f2.floatValue()));
                }
                if (i3 == size3) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        bVar.f14272h = arrayList;
        bVar.f14273i = arrayList2;
        bVar.f14274j = arrayList3;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("计算运动总数据 ", com.example.baselibrary.utils.b.z(bVar)));
        Iterator it = g().iterator();
        while (it.hasNext()) {
            ((e6.b) it.next()).q0(bVar);
        }
    }

    public final LinkedList g() {
        return (LinkedList) this.f7803y.getValue();
    }

    public final List h() {
        return (List) this.f7796q.getValue();
    }

    public final com.example.baselibrary.utils.e i() {
        return (com.example.baselibrary.utils.e) this.f7804z.getValue();
    }

    public final void j() {
        SensorManager sensorManager = this.f7781a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        AMapLocationClient aMapLocationClient = this.f7782b;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            AMapLocationClient aMapLocationClient2 = this.f7782b;
            kotlin.jvm.internal.e.c(aMapLocationClient2);
            aMapLocationClient2.onDestroy();
            this.f7782b = null;
        }
        Timer timer = this.f7799u;
        if (timer != null) {
            timer.cancel();
        }
        this.f7799u = null;
        ((HashMap) this.f7790k.getValue()).clear();
        ((HashMap) this.f7791l.getValue()).clear();
        ((HashMap) this.f7792m.getValue()).clear();
        ((HashMap) this.f7793n.getValue()).clear();
        ((HashMap) this.f7788i.getValue()).clear();
        ((HashMap) this.f7789j.getValue()).clear();
        ((HashMap) this.f7794o.getValue()).clear();
        ((HashMap) this.f7795p.getValue()).clear();
        this.f7783c = 0.0f;
        this.f7784d = 0.0f;
        this.e = 0.0d;
        this.f7785f = 0.0d;
        this.f7786g = 0.0d;
        this.r = 0L;
        this.f7797s = 0L;
        this.f7798t = 0L;
        this.f7800v = 0L;
        this.D = 0.0f;
        this.E = false;
        this.F = false;
        this.G = false;
        this.K = 0;
        this.L = 0.0f;
        this.M = false;
        this.J = 0L;
        i().removeCallbacksAndMessages(null);
    }

    public final void k() {
        XXApplication xXApplication = XXApplication.f7400h;
        com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
        kotlin.jvm.internal.e.e(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_tab_sport_running_indoor), "getString(...)");
        int i3 = this.A;
        if (i3 == 5) {
            kotlin.jvm.internal.e.e(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_tab_sport_running_outdoor), "getString(...)");
        } else if (i3 == 2) {
            kotlin.jvm.internal.e.e(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_tab_sport_biking), "getString(...)");
        } else if (i3 == 14) {
            kotlin.jvm.internal.e.e(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_tab_sport_climing), "getString(...)");
        } else if (i3 == 7) {
            kotlin.jvm.internal.e.e(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_tab_sport_walking), "getString(...)");
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            if (kVar == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            User d5 = kVar2 != null ? kVar2.d() : null;
            if (d5 != null) {
                if (d5.getMeterUnit() == 0) {
                    String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Double.valueOf(this.f7785f / 1000), com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_km)}, 2));
                } else {
                    String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Float.valueOf(v1.b((float) this.f7785f)), com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_mile)}, 2));
                }
            }
            String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Double.valueOf(this.f7786g), "KCAL"}, 2));
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
        kotlin.jvm.internal.e.f(sensor, "sensor");
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        if (this.f7787h && aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "运动定位成功 lat = " + aMapLocation.getLatitude() + " lng = " + aMapLocation.getLongitude());
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(aMapLocation.getGpsAccuracyStatus(), "运动定位成功 status = "));
            Iterator it = g().iterator();
            while (true) {
                int i3 = 0;
                if (!it.hasNext()) {
                    break;
                }
                e6.b bVar = (e6.b) it.next();
                if (aMapLocation.getGpsAccuracyStatus() != -1) {
                    i3 = aMapLocation.getGpsAccuracyStatus();
                }
                bVar.u(i3);
            }
            LatLng latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "当前运动定位 lat = " + latLng.latitude + " lng = " + latLng.longitude);
            if (h().size() == 0 && this.I) {
                this.I = false;
                return;
            }
            if (this.J == 0 || System.currentTimeMillis() - this.J < 10000) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "时间小于10S不记录");
                if (this.J == 0) {
                    this.J = System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (h().size() > 0) {
                LatLng latLng2 = (LatLng) h().get(h().size() - 1);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "上次定位：lat " + latLng2.latitude + " lng " + latLng2.longitude);
                float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, latLng2);
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("与上次定位距离 ", calculateLineDistance));
                long currentTimeMillis = (System.currentTimeMillis() - this.H) / ((long) 1000);
                if (calculateLineDistance > (20 < ((int) currentTimeMillis) * 20 ? r3 : 20)) {
                    this.H = System.currentTimeMillis();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(currentTimeMillis, "定位大于50M 时间间隔 "));
                    return;
                } else {
                    if (calculateLineDistance == 0.0f) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(currentTimeMillis, "定位距离为0 时间间隔 "));
                        return;
                    }
                    this.H = System.currentTimeMillis();
                }
            }
            h().add(latLng);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                List h4 = h();
                Devices c9 = kVar.c();
                if (c9 != null) {
                    kVar.M(com.example.baselibrary.utils.b.z(h4), android.support.v4.media.session.e.l(c9.getMacAddress(), "gps_track"));
                }
            }
            Iterator it2 = g().iterator();
            while (it2.hasNext()) {
                ((e6.b) it2.next()).y(h());
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent event) {
        kotlin.jvm.internal.e.f(event, "event");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "步数步数步数");
        if (this.B && event.sensor.getType() == 18) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "步数步数步数");
            if (this.f7801w) {
                return;
            }
            float f2 = this.f7784d + event.values[0];
            this.f7784d = f2;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("当前步数----：", f2));
            double d5 = 100;
            double d8 = (this.f7784d * this.e) / d5;
            this.f7785f = d8;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "当前步数距离(M)----：" + d8);
            User user = this.f7802x;
            kotlin.jvm.internal.e.c(user);
            double d10 = 1000;
            this.f7786g = ((((user.getWeight() * this.f7784d) * this.e) * 0.8214d) / d5) / d10;
            double d11 = this.f7785f;
            if (d11 > 0.0d) {
                long j4 = this.f7800v;
                this.f7797s = (long) (j4 / (d11 / d10));
                this.f7798t = (long) (j4 / v1.b((float) d11));
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "当前卡路里(KCAL)----：" + this.f7786g);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7800v, "当前运动时长(S)----："));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7797s, "当前公里配速(S)----："));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7798t, "当前英里配速(S)----："));
            a();
            c();
            d();
            k();
            e();
            return;
        }
        if (!this.C || event.sensor.getType() != 19) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "无效步数传感器数据");
            return;
        }
        float f10 = this.f7783c;
        if (f10 == 0.0f) {
            float f11 = event.values[0];
            this.f7783c = f11;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("当前总步数：startStep ", f11));
            return;
        }
        if (this.f7801w) {
            float f12 = event.values[0];
            float f13 = (f12 - f10) - this.f7784d;
            if (f13 > 0.0f) {
                this.D = f13;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 event.values[0] ", f12));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 startStep ", this.f7783c));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 totalStep ", this.f7784d));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 ", this.D));
            return;
        }
        float f14 = (event.values[0] - f10) - this.D;
        if (f14 > 0.0f) {
            this.f7784d = f14;
        } else {
            this.D = 0.0f;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 当前步数----：", this.f7784d));
        double d12 = 100;
        double d13 = (this.f7784d * this.e) / d12;
        this.f7785f = d13;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "COUNTER 当前步数距离(M)----：" + d13);
        User user2 = this.f7802x;
        kotlin.jvm.internal.e.c(user2);
        double d14 = 1000;
        this.f7786g = ((((user2.getWeight() * this.f7784d) * this.e) * 0.8214d) / d12) / d14;
        double d15 = this.f7785f;
        if (d15 > 0.0d) {
            long j10 = this.f7800v;
            this.f7797s = (long) (j10 / (d15 / d14));
            this.f7798t = (long) (j10 / v1.b((float) d15));
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "COUNTER 当前卡路里(KCAL)----：" + this.f7786g);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7800v, "COUNTER 当前运动时长(S)----："));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7797s, "COUNTER 当前公里配速(S)----："));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7798t, "COUNTER 当前英里配速(S)----："));
        a();
        c();
        d();
        k();
        e();
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        if (message.what == 0) {
            if (this.L == this.f7784d) {
                this.K++;
            } else {
                this.K = 0;
                if (this.M) {
                    this.M = false;
                    Iterator it = g().iterator();
                    while (it.hasNext()) {
                        ((e6.b) it.next()).j(false);
                    }
                }
            }
            if (this.K >= 15 && !this.M && !this.f7801w) {
                this.M = true;
                Iterator it2 = g().iterator();
                while (it2.hasNext()) {
                    ((e6.b) it2.next()).j(true);
                }
            }
            this.L = this.f7784d;
            i().removeMessages(0);
            i().sendEmptyMessageDelayed(0, 1000L);
            return;
        }
        i().removeMessages(1);
        Iterator it3 = g().iterator();
        while (it3.hasNext()) {
            ((e6.b) it3.next()).X(this.f7800v, this.f7786g, this.f7785f, this.f7797s, this.f7798t);
        }
        if (y5.d.f20006c || !r5.b.k().f18054c) {
            return;
        }
        if (!y5.d.f20005b) {
            ExchangeSportDataBean exchangeSportDataBean = new ExchangeSportDataBean();
            exchangeSportDataBean.setTimeLen((int) this.f7800v);
            exchangeSportDataBean.setStep((int) this.f7784d);
            exchangeSportDataBean.setCal((long) (this.f7786g * 1000));
            exchangeSportDataBean.setPaceKm(this.f7797s);
            exchangeSportDataBean.setPaceImp(this.f7798t);
            exchangeSportDataBean.setDistance((int) this.f7785f);
            com.google.android.gms.internal.mlkit_vision_common.p.f(exchangeSportDataBean);
            return;
        }
        SportDataBean sportDataBean = new SportDataBean();
        sportDataBean.setTotalTime(this.f7800v);
        sportDataBean.setStep((int) this.f7784d);
        sportDataBean.setCalorie((int) this.f7786g);
        sportDataBean.setDistance((int) this.f7785f);
        sportDataBean.setAltitude(0);
        sportDataBean.setPressure(0);
        int i3 = this.A;
        int i10 = i3 != 2 ? i3 != 14 ? i3 != 4 ? i3 != 5 ? -1 : 7 : 8 : 13 : 10;
        if (i10 == -1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportDetailPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "表端不支持的运动类型 "));
            return;
        }
        sportDataBean.setWorkMode(i10);
        sportDataBean.setCurrentPace((int) this.f7797s);
        com.google.android.gms.internal.mlkit_vision_common.p.D(sportDataBean);
    }
}
