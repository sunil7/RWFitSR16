package com.example.test.service;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Message;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.ExchangeSportDataBean;
import com.example.blesdk.bean.function.SportDataBean;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.cf;
import com.google.android.gms.internal.mlkit_vision_barcode.ee;
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
public final class r0 implements SensorEventListener, AMapLocationListener, e6.c, o5.a {
    public static final Object M = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.test.service.SportHelper$Companion$sInstance$2
        @Override // oh.a
        public final r0 invoke() {
            return new r0();
        }
    });
    public boolean A;
    public boolean B;
    public float C;
    public boolean D;
    public boolean E;
    public boolean F;
    public long G;
    public long I;
    public int J;
    public float K;
    public boolean L;

    /* renamed from: a, reason: collision with root package name */
    public SensorManager f7755a;

    /* renamed from: b, reason: collision with root package name */
    public AMapLocationClient f7756b;

    /* renamed from: c, reason: collision with root package name */
    public float f7757c;

    /* renamed from: d, reason: collision with root package name */
    public float f7758d;
    public double e;

    /* renamed from: f, reason: collision with root package name */
    public double f7759f;

    /* renamed from: g, reason: collision with root package name */
    public double f7760g;

    /* renamed from: q, reason: collision with root package name */
    public long f7770q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f7771s;

    /* renamed from: t, reason: collision with root package name */
    public Timer f7772t;

    /* renamed from: u, reason: collision with root package name */
    public long f7773u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7774v;

    /* renamed from: w, reason: collision with root package name */
    public User f7775w;

    /* renamed from: z, reason: collision with root package name */
    public int f7778z;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7761h = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$stepPaces$2
        @Override // oh.a
        public final HashMap<Integer, Float> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7762i = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$stepPacesMin$2
        @Override // oh.a
        public final HashMap<Integer, Float> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7763j = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$speedPaces$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7764k = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$speedPacesImperial$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7765l = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$kmTimeSec$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final eh.b f7766m = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$mileTimeSec$2
        @Override // oh.a
        public final HashMap<Integer, Long> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: n, reason: collision with root package name */
    public final eh.b f7767n = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$distanceMeter$2
        @Override // oh.a
        public final HashMap<Integer, Double> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public final eh.b f7768o = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$distanceImperial$2
        @Override // oh.a
        public final HashMap<Integer, Double> invoke() {
            return new HashMap<>();
        }
    });

    /* renamed from: p, reason: collision with root package name */
    public final eh.b f7769p = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$line$2
        @Override // oh.a
        public final List<LatLng> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: x, reason: collision with root package name */
    public final eh.b f7776x = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$dataCallbacks$2
        @Override // oh.a
        public final LinkedList<e6.b> invoke() {
            return new LinkedList<>();
        }
    });

    /* renamed from: y, reason: collision with root package name */
    public final eh.b f7777y = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SportHelper$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(r0.this);
        }
    });
    public boolean H = true;

    public final void a() {
        double d5;
        double d8;
        int i3 = (int) (this.f7759f / 1000);
        int i10 = i3 + 1;
        eh.b bVar = this.f7765l;
        Long l3 = (Long) ((HashMap) bVar.getValue()).get(Integer.valueOf(i3));
        long longValue = l3 != null ? this.f7773u - l3.longValue() : this.f7773u;
        eh.b bVar2 = this.f7767n;
        Double d10 = (Double) ((HashMap) bVar2.getValue()).get(Integer.valueOf(i3));
        if (d10 != null) {
            d5 = longValue;
            d8 = this.f7759f - d10.doubleValue();
        } else {
            d5 = this.f7773u;
            d8 = this.f7759f;
        }
        long j4 = (long) (d5 / (d8 / 1000.0f));
        Integer valueOf = Integer.valueOf(i10);
        Long valueOf2 = Long.valueOf(j4);
        eh.b bVar3 = this.f7763j;
        ((HashMap) bVar3.getValue()).put(valueOf, valueOf2);
        ((HashMap) bVar.getValue()).put(Integer.valueOf(i10), Long.valueOf(this.f7773u));
        ((HashMap) bVar2.getValue()).put(Integer.valueOf(i10), Double.valueOf(this.f7759f));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前公里配速表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar3.getValue())));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前公里时间表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar.getValue())));
    }

    @Override // e6.c
    public final void b() {
        if (this.f7774v || this.L) {
            return;
        }
        this.f7773u++;
        if (this.f7759f > 20.0d) {
            c();
            a();
            long j4 = this.f7773u;
            double d5 = this.f7759f;
            this.r = (long) (j4 / (d5 / 1000));
            this.f7771s = (long) (j4 / v1.b((float) d5));
        }
        if (this.f7773u >= 21600) {
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
        int b3 = (int) v1.b((float) this.f7759f);
        int i3 = b3 + 1;
        eh.b bVar = this.f7766m;
        Long l3 = (Long) ((HashMap) bVar.getValue()).get(Integer.valueOf(b3));
        long longValue = l3 != null ? this.f7773u - l3.longValue() : this.f7773u;
        eh.b bVar2 = this.f7768o;
        Double d5 = (Double) ((HashMap) bVar2.getValue()).get(Integer.valueOf(b3));
        long b10 = d5 != null ? (long) (longValue / v1.b((float) (this.f7759f - d5.doubleValue()))) : (long) (this.f7773u / v1.b((float) this.f7759f));
        Integer valueOf = Integer.valueOf(i3);
        Long valueOf2 = Long.valueOf(b10);
        eh.b bVar3 = this.f7764k;
        ((HashMap) bVar3.getValue()).put(valueOf, valueOf2);
        ((HashMap) bVar.getValue()).put(Integer.valueOf(i3), Long.valueOf(this.f7773u));
        ((HashMap) bVar2.getValue()).put(Integer.valueOf(i3), Double.valueOf(this.f7759f));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前英里配速表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar3.getValue())));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("当前英里时间表(S)----：", com.example.baselibrary.utils.b.z((HashMap) bVar.getValue())));
    }

    public final void d() {
        int i3 = (int) (this.f7773u / 60);
        int i10 = i3 + 1;
        eh.b bVar = this.f7762i;
        Float f2 = (Float) ((HashMap) bVar.getValue()).get(Integer.valueOf(i3));
        float floatValue = f2 != null ? this.f7758d - f2.floatValue() : this.f7758d;
        Integer valueOf = Integer.valueOf(i10);
        Float valueOf2 = Float.valueOf(floatValue);
        eh.b bVar2 = this.f7761h;
        ((HashMap) bVar2.getValue()).put(valueOf, valueOf2);
        ((HashMap) bVar.getValue()).put(Integer.valueOf(i10), Float.valueOf(this.f7758d));
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
            if (this.f7773u / 60 >= B.getTime() && !this.D) {
                this.D = true;
                if (isVibrator == 1) {
                    ef.i.y().M(300L);
                }
                com.example.baselibrary.utils.d.a(R$string.str_time_goal_reached);
            }
            if (this.f7760g >= B.getCalorie() && !this.E) {
                this.E = true;
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
                if (this.f7759f / 1000 < B.getDistance() || this.F) {
                    return;
                }
                this.F = true;
                if (isVibrator == 1) {
                    ef.i.y().M(300L);
                }
                com.example.baselibrary.utils.d.a(R$string.str_distance_goal_reached);
                return;
            }
            if (v1.b((float) this.f7759f) < B.getDistance() || this.F) {
                return;
            }
            this.F = true;
            if (isVibrator == 1) {
                ef.i.y().M(300L);
            }
            com.example.baselibrary.utils.d.a(R$string.str_distance_goal_reached);
        }
    }

    public final void f() {
        h6.b bVar = new h6.b();
        bVar.f14271g = this.f7760g;
        bVar.e = this.f7773u;
        bVar.f14270f = (long) this.f7758d;
        bVar.f14269d = this.f7770q;
        bVar.f14268c = this.f7759f;
        int i3 = 1;
        ArrayList arrayList = new ArrayList(1);
        eh.b bVar2 = this.f7763j;
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
        eh.b bVar3 = this.f7764k;
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
        eh.b bVar4 = this.f7761h;
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
        return (LinkedList) this.f7776x.getValue();
    }

    public final List h() {
        return (List) this.f7769p.getValue();
    }

    public final com.example.baselibrary.utils.e i() {
        return (com.example.baselibrary.utils.e) this.f7777y.getValue();
    }

    public final boolean j(Context context) {
        this.A = context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
        this.B = context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
        return context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter") || context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
    }

    public final void k(e6.b bVar) {
        if (g().contains(bVar)) {
            return;
        }
        g().add(bVar);
    }

    public final void l() {
        SensorManager sensorManager = this.f7755a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        AMapLocationClient aMapLocationClient = this.f7756b;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            AMapLocationClient aMapLocationClient2 = this.f7756b;
            kotlin.jvm.internal.e.c(aMapLocationClient2);
            aMapLocationClient2.onDestroy();
            this.f7756b = null;
        }
        Timer timer = this.f7772t;
        if (timer != null) {
            timer.cancel();
        }
        this.f7772t = null;
        ((HashMap) this.f7763j.getValue()).clear();
        ((HashMap) this.f7764k.getValue()).clear();
        ((HashMap) this.f7765l.getValue()).clear();
        ((HashMap) this.f7766m.getValue()).clear();
        ((HashMap) this.f7761h.getValue()).clear();
        ((HashMap) this.f7762i.getValue()).clear();
        h().clear();
        ((HashMap) this.f7767n.getValue()).clear();
        ((HashMap) this.f7768o.getValue()).clear();
        this.f7757c = 0.0f;
        this.f7758d = 0.0f;
        this.e = 0.0d;
        this.f7759f = 0.0d;
        this.f7760g = 0.0d;
        this.f7770q = 0L;
        this.r = 0L;
        this.f7771s = 0L;
        this.f7773u = 0L;
        this.C = 0.0f;
        this.D = false;
        this.E = false;
        this.F = false;
        this.J = 0;
        this.K = 0.0f;
        this.L = false;
        this.I = 0L;
        i().removeCallbacksAndMessages(null);
    }

    public final void m() {
        XXApplication xXApplication = XXApplication.f7400h;
        com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
        kotlin.jvm.internal.e.e(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_tab_sport_running_indoor), "getString(...)");
        int i3 = this.f7778z;
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
                    String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Double.valueOf(this.f7759f / 1000), com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_km)}, 2));
                } else {
                    String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Float.valueOf(v1.b((float) this.f7759f)), com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getString(R$string.str_mile)}, 2));
                }
            }
            String.format(Locale.ENGLISH, "%.2f%s", Arrays.copyOf(new Object[]{Double.valueOf(this.f7760g), "KCAL"}, 2));
        }
    }

    public final void n(int i3) {
        double d5;
        double d8;
        float f2;
        double d10;
        double d11;
        XXApplication xXApplication = XXApplication.f7400h;
        Context applicationContext = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getApplicationContext();
        if (applicationContext != null) {
            if (j(applicationContext)) {
                Object systemService = applicationContext.getSystemService("sensor");
                kotlin.jvm.internal.e.d(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
                SensorManager sensorManager = (SensorManager) systemService;
                this.f7755a = sensorManager;
                Sensor defaultSensor = sensorManager.getDefaultSensor(19);
                SensorManager sensorManager2 = this.f7755a;
                kotlin.jvm.internal.e.c(sensorManager2);
                Sensor defaultSensor2 = sensorManager2.getDefaultSensor(18);
                SensorManager sensorManager3 = this.f7755a;
                kotlin.jvm.internal.e.c(sensorManager3);
                sensorManager3.registerListener(this, defaultSensor2, 0, i());
                SensorManager sensorManager4 = this.f7755a;
                kotlin.jvm.internal.e.c(sensorManager4);
                sensorManager4.registerListener(this, defaultSensor, 0);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    kotlin.jvm.internal.e.c(kVar);
                    User d12 = kVar.d();
                    this.f7775w = d12;
                    if (d12 != null) {
                        double height = d12.getHeight();
                        if (height < 30.0d || height >= 100.0d) {
                            if (height >= 100.0d && height < 150.0d) {
                                d8 = height * 0.004f;
                                f2 = 0.1f;
                            } else if (height >= 150.0d && height < 180.0d) {
                                d10 = height / 300.0f;
                                d11 = 100;
                            } else if (height < 180.0d || height >= 230.0d) {
                                d5 = 55.0d;
                                this.e = d5;
                            } else {
                                d8 = height * 0.005f;
                                f2 = 0.3f;
                            }
                            d10 = d8 - f2;
                            d11 = 100;
                        } else {
                            d10 = (height * 0.001f) + 0.2f;
                            d11 = 100.0f;
                        }
                        d5 = d10 * d11;
                        this.e = d5;
                    }
                }
                this.f7773u = 0L;
                this.f7774v = false;
                this.f7770q = System.currentTimeMillis() / 1000;
                if (this.f7772t == null) {
                    this.f7772t = new Timer();
                }
                Timer timer = this.f7772t;
                if (timer != null) {
                    timer.scheduleAtFixedRate(new com.example.test.presenter.sport.g(this), 1000L, 1000L);
                }
            }
            this.f7778z = i3;
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if ((kVar2 != null ? kVar2.B().isAutoPause() : 1) == 1) {
                i().removeMessages(0);
                i().sendEmptyMessageDelayed(0, 1000L);
            }
            if (i3 != 4) {
                this.H = true;
                try {
                    this.f7756b = new AMapLocationClient(applicationContext);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("LOCATION ERROR ", e.getMessage()));
                }
                if (this.f7756b != null) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "开启定位");
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    AMapLocationClient aMapLocationClient = this.f7756b;
                    kotlin.jvm.internal.e.c(aMapLocationClient);
                    aMapLocationClient.setLocationListener(this);
                    XXApplication xXApplication2 = XXApplication.f7400h;
                    com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
                    AMapLocationClient aMapLocationClient2 = this.f7756b;
                    kotlin.jvm.internal.e.c(aMapLocationClient2);
                    String str = com.dh.keeplive.a.f7201c;
                    aMapLocationClient2.enableBackgroundLocation(ee.a().f7205a.getServiceId(), cf.a(com.google.android.gms.internal.mlkit_vision_barcode.j1.a(), ee.a().f7205a));
                    aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                    aMapLocationClientOption.setInterval(Const.L_MIN_WIFI_RESULT);
                    aMapLocationClientOption.setLocationCacheEnable(false);
                    aMapLocationClientOption.setGpsFirst(true);
                    AMapLocationClient aMapLocationClient3 = this.f7756b;
                    kotlin.jvm.internal.e.c(aMapLocationClient3);
                    aMapLocationClient3.setLocationOption(aMapLocationClientOption);
                    AMapLocationClient aMapLocationClient4 = this.f7756b;
                    kotlin.jvm.internal.e.c(aMapLocationClient4);
                    aMapLocationClient4.startLocation();
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
        kotlin.jvm.internal.e.f(sensor, "sensor");
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation == null || aMapLocation.getErrorCode() != 0) {
            return;
        }
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
        if (h().size() == 0 && this.H) {
            this.H = false;
            return;
        }
        if (this.I == 0 || System.currentTimeMillis() - this.I < 10000) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "时间小于10S不记录");
            if (this.I == 0) {
                this.I = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (h().size() > 0) {
            LatLng latLng2 = (LatLng) h().get(h().size() - 1);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "上次定位：lat " + latLng2.latitude + " lng " + latLng2.longitude);
            float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, latLng2);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("与上次定位距离 ", calculateLineDistance));
            long currentTimeMillis = (System.currentTimeMillis() - this.G) / ((long) 1000);
            if (calculateLineDistance > (20 < ((int) currentTimeMillis) * 20 ? r0 : 20)) {
                this.G = System.currentTimeMillis();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(currentTimeMillis, "定位大于50M 时间间隔 "));
                return;
            } else {
                if (calculateLineDistance == 0.0f) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(currentTimeMillis, "定位距离为0 时间间隔 "));
                    return;
                }
                this.G = System.currentTimeMillis();
            }
        }
        h().add(latLng);
        Iterator it2 = g().iterator();
        while (it2.hasNext()) {
            ((e6.b) it2.next()).y(h());
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent event) {
        kotlin.jvm.internal.e.f(event, "event");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "步数步数步数");
        if (this.A && event.sensor.getType() == 18) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "步数步数步数");
            if (this.f7774v) {
                return;
            }
            float f2 = this.f7758d + event.values[0];
            this.f7758d = f2;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("当前步数----：", f2));
            double d5 = 100;
            double d8 = (this.f7758d * this.e) / d5;
            this.f7759f = d8;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "当前步数距离(M)----：" + d8);
            User user = this.f7775w;
            kotlin.jvm.internal.e.c(user);
            double d10 = 1000;
            this.f7760g = ((((user.getWeight() * this.f7758d) * this.e) * 0.8214d) / d5) / d10;
            double d11 = this.f7759f;
            if (d11 > 0.0d) {
                long j4 = this.f7773u;
                this.r = (long) (j4 / (d11 / d10));
                this.f7771s = (long) (j4 / v1.b((float) d11));
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "当前卡路里(KCAL)----：" + this.f7760g);
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7773u, "当前运动时长(S)----："));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.r, "当前公里配速(S)----："));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7771s, "当前英里配速(S)----："));
            a();
            c();
            d();
            m();
            e();
            return;
        }
        if (!this.B || event.sensor.getType() != 19) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "无效步数传感器数据");
            return;
        }
        float f10 = this.f7757c;
        if (f10 == 0.0f) {
            float f11 = event.values[0];
            this.f7757c = f11;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("当前总步数：startStep ", f11));
            return;
        }
        if (this.f7774v) {
            float f12 = event.values[0];
            float f13 = (f12 - f10) - this.f7758d;
            if (f13 > 0.0f) {
                this.C = f13;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 event.values[0] ", f12));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 startStep ", this.f7757c));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 totalStep ", this.f7758d));
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 暂停步数 ", this.C));
            return;
        }
        float f14 = (event.values[0] - f10) - this.C;
        if (f14 > 0.0f) {
            this.f7758d = f14;
        } else {
            this.C = 0.0f;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("COUNTER 当前步数----：", this.f7758d));
        double d12 = 100;
        double d13 = (this.f7758d * this.e) / d12;
        this.f7759f = d13;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "COUNTER 当前步数距离(M)----：" + d13);
        User user2 = this.f7775w;
        kotlin.jvm.internal.e.c(user2);
        double d14 = 1000;
        this.f7760g = ((((user2.getWeight() * this.f7758d) * this.e) * 0.8214d) / d12) / d14;
        double d15 = this.f7759f;
        if (d15 > 0.0d) {
            long j10 = this.f7773u;
            this.r = (long) (j10 / (d15 / d14));
            this.f7771s = (long) (j10 / v1.b((float) d15));
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", "COUNTER 当前卡路里(KCAL)----：" + this.f7760g);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7773u, "COUNTER 当前运动时长(S)----："));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.r, "COUNTER 当前公里配速(S)----："));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportService", com.google.android.gms.internal.mlkit_vision_barcode.l0.l(this.f7771s, "COUNTER 当前英里配速(S)----："));
        a();
        c();
        d();
        m();
        e();
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        if (message.what == 0) {
            if (this.K == this.f7758d) {
                this.J++;
            } else {
                this.J = 0;
                if (this.L) {
                    this.L = false;
                    Iterator it = g().iterator();
                    while (it.hasNext()) {
                        ((e6.b) it.next()).j(false);
                    }
                }
            }
            if (this.J >= 15 && !this.L && !this.f7774v) {
                this.L = true;
                Iterator it2 = g().iterator();
                while (it2.hasNext()) {
                    ((e6.b) it2.next()).j(true);
                }
            }
            this.K = this.f7758d;
            i().removeMessages(0);
            i().sendEmptyMessageDelayed(0, 1000L);
            return;
        }
        i().removeMessages(1);
        Iterator it3 = g().iterator();
        while (it3.hasNext()) {
            ((e6.b) it3.next()).X(this.f7773u, this.f7760g, this.f7759f, this.r, this.f7771s);
        }
        if (y5.d.f20006c || !r5.b.k().f18054c) {
            return;
        }
        if (!y5.d.f20005b) {
            ExchangeSportDataBean exchangeSportDataBean = new ExchangeSportDataBean();
            exchangeSportDataBean.setTimeLen((int) this.f7773u);
            exchangeSportDataBean.setStep((int) this.f7758d);
            exchangeSportDataBean.setCal((long) (this.f7760g * 1000));
            exchangeSportDataBean.setPaceKm(this.r);
            exchangeSportDataBean.setPaceImp(this.f7771s);
            exchangeSportDataBean.setDistance((int) this.f7759f);
            com.google.android.gms.internal.mlkit_vision_common.p.f(exchangeSportDataBean);
            return;
        }
        SportDataBean sportDataBean = new SportDataBean();
        sportDataBean.setTotalTime(this.f7773u);
        sportDataBean.setStep((int) this.f7758d);
        sportDataBean.setCalorie((int) this.f7760g);
        sportDataBean.setDistance((int) this.f7759f);
        sportDataBean.setAltitude(0);
        sportDataBean.setPressure(0);
        int i3 = this.f7778z;
        int i10 = i3 != 2 ? i3 != 14 ? i3 != 4 ? i3 != 5 ? -1 : 7 : 8 : 13 : 10;
        if (i10 == -1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportDetailPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "表端不支持的运动类型 "));
            return;
        }
        sportDataBean.setWorkMode(i10);
        sportDataBean.setCurrentPace((int) this.r);
        com.google.android.gms.internal.mlkit_vision_common.p.D(sportDataBean);
    }
}
