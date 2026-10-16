package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.Aps;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    /* renamed from: x, reason: collision with root package name */
    static boolean f4027x = false;

    /* renamed from: i, reason: collision with root package name */
    Context f4035i;

    /* renamed from: p, reason: collision with root package name */
    private List<Messenger> f4042p;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4028a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4029b = false;

    /* renamed from: c, reason: collision with root package name */
    String f4030c = null;

    /* renamed from: d, reason: collision with root package name */
    b f4031d = null;
    private long e = 0;

    /* renamed from: f, reason: collision with root package name */
    private AMapLocationServer f4032f = null;

    /* renamed from: g, reason: collision with root package name */
    AMapLocation f4033g = null;

    /* renamed from: h, reason: collision with root package name */
    a f4034h = null;

    /* renamed from: j, reason: collision with root package name */
    private v f4036j = null;

    /* renamed from: k, reason: collision with root package name */
    Aps f4037k = null;

    /* renamed from: l, reason: collision with root package name */
    HashMap<Messenger, Long> f4038l = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    ReportUtil f4039m = null;

    /* renamed from: n, reason: collision with root package name */
    long f4040n = 0;

    /* renamed from: o, reason: collision with root package name */
    long f4041o = 0;

    /* renamed from: q, reason: collision with root package name */
    private long f4043q = 0;
    private HashMap<String, Boolean> r = new HashMap<>();

    /* renamed from: s, reason: collision with root package name */
    String f4044s = null;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4045t = true;

    /* renamed from: u, reason: collision with root package name */
    private String f4046u = "";

    /* renamed from: v, reason: collision with root package name */
    AMapLocationClientOption f4047v = null;

    /* renamed from: w, reason: collision with root package name */
    AMapLocationClientOption f4048w = new AMapLocationClientOption();

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01bd A[Catch: all -> 0x0096, TryCatch #1 {all -> 0x0096, blocks: (B:20:0x0042, B:29:0x0058, B:31:0x0064, B:34:0x006c, B:37:0x0078, B:38:0x009a, B:39:0x00a8, B:40:0x00b6, B:41:0x00c4, B:42:0x00d2, B:44:0x00d6, B:46:0x00de, B:48:0x00ea, B:49:0x00f3, B:51:0x00fb, B:53:0x0107, B:54:0x0110, B:56:0x0114, B:58:0x011c, B:60:0x0128, B:62:0x013d, B:63:0x0144, B:64:0x014d, B:65:0x0154, B:66:0x0161, B:71:0x0172, B:76:0x01c7, B:80:0x017a, B:82:0x0180, B:84:0x0197, B:86:0x019d, B:87:0x01b2, B:88:0x01bd, B:92:0x003d, B:68:0x016b), top: B:91:0x003d, inners: #0 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r11) {
            /*
                Method dump skipped, instructions count: 494
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3sl.f.a.handleMessage(android.os.Message):void");
        }
    }

    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            try {
                try {
                    f fVar = f.this;
                    fVar.f4036j = new v(fVar.f4035i);
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "APSManager$ActionThread", "init 2");
                }
                f.this.f4037k = new Aps(false);
                super.onLooperPrepared();
            } catch (Throwable th3) {
                CoreUtil.reportError(th3, "APSManager$ActionThread", "onLooperPrepared");
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                super.run();
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "APSManager$ActionThread", "run");
            }
        }
    }

    public f(Context context) {
        this.f4035i = null;
        this.f4035i = context;
    }

    public static void a(f fVar, Messenger messenger, Bundle bundle) {
        fVar.getClass();
        if (bundle != null) {
            try {
                if (!bundle.isEmpty() && !fVar.f4029b) {
                    fVar.f4029b = true;
                    try {
                        fVar.f4037k.requestSdkAuth(fVar.f4035i);
                        if (AuthUtil.isInstalledHighDangerMockApp()) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putBoolean("installMockApp", true);
                            fVar.a(messenger, 9, bundle2);
                        }
                    } catch (Throwable th2) {
                        CoreUtil.reportError(th2, "ApsServiceCore", "initAuth");
                    }
                }
            } catch (Throwable th3) {
                CoreUtil.reportError(th3, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    public static void b(f fVar, Messenger messenger, Bundle bundle) {
        String str;
        v vVar;
        fVar.getClass();
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                AMapLocationStaticsEntity aMapLocationStaticsEntity = new AMapLocationStaticsEntity();
                aMapLocationStaticsEntity.setLocationType(AMapLocationStaticsEntity.CONTINUE_LOCATE);
                AMapLocationClientOption b3 = fVar.b(bundle);
                AuthUtil.loadLastAbleState(fVar.f4035i, b3);
                AuthUtil.registerLoadConfig(fVar.f4035i);
                fVar.a(b3);
                if (fVar.f4038l.containsKey(messenger) && !b3.isOnceLocation()) {
                    if (Utils.getTimeBoot() - fVar.f4038l.get(messenger).longValue() < 800) {
                        return;
                    }
                }
                AMapLocation aMapLocation = null;
                if (!fVar.f4045t) {
                    fVar.f4032f = fVar.a(9, "init error : " + fVar.f4046u + "#0901");
                    aMapLocationStaticsEntity.setReason("#0901");
                    AMapLocationServer aMapLocationServer = fVar.f4032f;
                    fVar.a(messenger, aMapLocationServer, aMapLocationServer.getNb(), aMapLocationStaticsEntity);
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_INTT);
                    return;
                }
                long timeBoot = Utils.getTimeBoot();
                if (Utils.locCorrect(fVar.f4032f) && timeBoot - fVar.e < 600) {
                    AMapLocationServer aMapLocationServer2 = fVar.f4032f;
                    fVar.a(messenger, aMapLocationServer2, aMapLocationServer2.getNb(), aMapLocationStaticsEntity);
                    fVar.f4037k.setNetworkLocation(fVar.f4032f);
                    return;
                }
                aMapLocationStaticsEntity.setStartTime(Utils.getTimeBoot());
                try {
                    AMapLocationServer location = fVar.f4037k.getLocation(aMapLocationStaticsEntity);
                    fVar.f4032f = location;
                    fVar.f4037k.setNetworkLocation(location);
                    fVar.f4032f = fVar.f4037k.filter(fVar.f4032f, new String[0]);
                } catch (Throwable th2) {
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_LOCALLOC);
                    aMapLocationStaticsEntity.setReason("#0801");
                    fVar.f4032f = fVar.a(8, "loc error : " + th2.getMessage() + "#0801");
                    CoreUtil.reportError(th2, "ApsServiceCore", "run part2");
                }
                if (Utils.locCorrect(fVar.f4032f)) {
                    fVar.e = Utils.getTimeBoot();
                }
                if (fVar.f4032f == null) {
                    fVar.f4032f = fVar.a(8, "loc is null#0801");
                    aMapLocationStaticsEntity.setReason("#0801");
                }
                AMapLocationServer aMapLocationServer3 = fVar.f4032f;
                if (aMapLocationServer3 != null) {
                    String nb = aMapLocationServer3.getNb();
                    aMapLocation = fVar.f4032f.m2clone();
                    str = nb;
                } else {
                    str = null;
                }
                try {
                    if (b3.isLocationCacheEnable() && (vVar = fVar.f4036j) != null) {
                        aMapLocation = vVar.a(aMapLocation, str, b3.getLastLocationLifeCycle());
                    }
                } catch (Throwable th3) {
                    CoreUtil.reportError(th3, "ApsServiceCore", "fixLastLocation");
                }
                fVar.a(messenger, aMapLocation, str, aMapLocationStaticsEntity);
            } catch (Throwable th4) {
                CoreUtil.reportError(th4, "ApsServiceCore", "doLocation");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (Utils.isCoarsePermOpen(this.f4035i)) {
            DebugUtils.writeCat("Cl | dl -- sc_cpo");
            return;
        }
        try {
            Aps aps = this.f4037k;
            if (aps != null) {
                aps.initHandler(this.f4034h);
                this.f4037k.startColl();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ApsServiceCore", "startColl");
        }
    }

    public void c() {
        HashMap<String, Boolean> hashMap;
        if (this.f4037k == null || (hashMap = this.r) == null || hashMap.isEmpty()) {
            return;
        }
        Iterator<Boolean> it = this.r.values().iterator();
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                this.f4037k.notifyLocationStatus(true);
                return;
            }
        }
        this.f4037k.notifyLocationStatus(false);
    }

    private AMapLocationServer a(int i3, String str) {
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(i3);
            aMapLocationServer.setLocationDetail(str);
            return aMapLocationServer;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        try {
            if (this.f4028a) {
                Aps aps = this.f4037k;
                if (aps != null) {
                    aps.reInitIfNeed();
                    return;
                }
                return;
            }
            CoreUtil.checkUrl(this.f4035i);
            if (bundle != null) {
                this.f4048w = CoreUtil.getOptionFromBundle(bundle.getBundle("optBundle"));
            }
            this.f4037k.initBase(this.f4035i);
            this.f4037k.initNetManager();
            a(this.f4048w);
            this.f4037k.initOther();
            this.f4028a = true;
            this.f4045t = true;
            this.f4046u = "";
            List<Messenger> list = this.f4042p;
            if (list == null || list.size() <= 0) {
                return;
            }
            d();
        } catch (Throwable th2) {
            this.f4045t = false;
            th2.printStackTrace();
            this.f4046u = th2.getMessage();
            CoreUtil.reportError(th2, "ApsServiceCore", "init");
        }
    }

    private void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            Aps aps = this.f4037k;
            if (aps != null) {
                aps.setExtra(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                f4027x = aMapLocationClientOption.isKillProcess();
                if (this.f4047v != null) {
                    if (aMapLocationClientOption.isOffset() != this.f4047v.isOffset() || aMapLocationClientOption.isNeedAddress() != this.f4047v.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.f4047v.isLocationCacheEnable() || this.f4047v.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.e = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.f4047v.isOffset() || this.f4047v.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f4033g = null;
                    }
                }
                this.f4047v = aMapLocationClientOption;
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ApsServiceCore", "setExtra");
        }
    }

    public void b() {
        try {
            this.f4039m = new ReportUtil();
            b bVar = new b("amapLocCoreThread");
            this.f4031d = bVar;
            bVar.setPriority(5);
            this.f4031d.start();
            this.f4034h = new a(this.f4031d.getLooper());
            this.f4042p = new ArrayList();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ApsServiceCore", "onCreate");
        }
    }

    private AMapLocationClientOption b(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = CoreUtil.getOptionFromBundle(bundle.getBundle("optBundle"));
            try {
                String string = bundle.getString(Const.INTENT_KEY_UMID);
                if (!TextUtils.isEmpty(string)) {
                    f9.a(string);
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "APSManager", "doLocation setUmidToken");
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    public void a() {
        try {
            HashMap<Messenger, Long> hashMap = this.f4038l;
            if (hashMap != null) {
                hashMap.clear();
                this.f4038l = null;
            }
            try {
                this.f4037k.destroyColl();
                List<Messenger> list = this.f4042p;
                if (list != null) {
                    list.clear();
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "apm", "des1");
            }
            v vVar = this.f4036j;
            if (vVar != null) {
                vVar.a();
                this.f4036j = null;
            }
            this.f4028a = false;
            this.f4029b = false;
            this.f4037k.destroy();
            a aVar = this.f4034h;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.f4034h = null;
            b bVar = this.f4031d;
            if (bVar != null) {
                try {
                    Reflect.invokeMethod(bVar, HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                    this.f4031d.quit();
                }
            }
            this.f4031d = null;
            if (this.f4039m != null && this.f4040n != 0 && this.f4041o != 0) {
                long timeBoot = Utils.getTimeBoot() - this.f4040n;
                ReportUtil.reportServiceAliveTime(this.f4035i, this.f4039m.getLocationType(this.f4035i), this.f4039m.getLocationMode(this.f4035i), this.f4041o, timeBoot);
                this.f4039m.clearLocationModeAndType(this.f4035i);
            }
            HashMap<String, Boolean> hashMap2 = this.r;
            if (hashMap2 != null) {
                hashMap2.clear();
                this.r = null;
            }
            ReportUtil.saveStatistics(this.f4035i);
            ka.c();
            if (f4027x) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "apm", "tdest");
        }
    }

    public void a(Messenger messenger, int i3, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i3;
                messenger.send(obtain);
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ApsServiceCore", "sendMessage");
            }
        }
    }

    private void a(Messenger messenger, AMapLocation aMapLocation, String str, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable(AMapLocationStaticsEntity.STATICS_LOCATE, aMapLocationStaticsEntity);
        this.f4038l.put(messenger, Long.valueOf(Utils.getTimeBoot()));
        a(messenger, 1, bundle);
    }

    public void a(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption b3;
        float f2;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d5 = bundle.getDouble(Const.JSON_KEY_LAT);
                double d8 = bundle.getDouble(Const.JSON_KEY_LON);
                boolean z5 = bundle.getBoolean(Const.JSON_KEY_ISOFFSET);
                float f10 = bundle.getFloat("radius");
                long j4 = bundle.getLong(Const.JSON_KEY_TIME);
                int i3 = bundle.getInt("locationType");
                if (Const.TYPE_GPS_LOC.equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation("gps");
                    aMapLocation.setLatitude(d5);
                    aMapLocation.setLocationType(i3);
                    aMapLocation.setLongitude(d8);
                    aMapLocation.setAccuracy(f10);
                    aMapLocation.setTime(j4);
                    this.f4037k.setGpsLocation(aMapLocation);
                } else if (Const.TYPE_NETWORK_LOC.equals(str)) {
                    AMapLocationServer aMapLocationServer = new AMapLocationServer(Const.PROVIDER_NETWORK);
                    aMapLocationServer.setLatitude(d5);
                    aMapLocationServer.setLocationType(i3);
                    aMapLocationServer.setLongitude(d8);
                    aMapLocationServer.setAccuracy(f10);
                    aMapLocationServer.setTime(j4);
                    this.f4037k.setNetworkLocation(aMapLocationServer);
                } else if (Const.TYPE_FUSION_LOC.equals(str)) {
                    AMapLocation aMapLocation2 = new AMapLocation(Const.PROVIDER_FUSED);
                    aMapLocation2.setLatitude(d5);
                    aMapLocation2.setLocationType(i3);
                    aMapLocation2.setLongitude(d8);
                    aMapLocation2.setAccuracy(f10);
                    aMapLocation2.setTime(j4);
                    this.f4037k.setFusionLocation(aMapLocation2);
                }
                if (AuthUtil.getGpsGeoAble() && (b3 = b(bundle)) != null && b3.isNeedAddress()) {
                    a(b3);
                    AMapLocation aMapLocation3 = this.f4033g;
                    if (aMapLocation3 != null) {
                        f2 = Utils.dist(new double[]{d5, d8, aMapLocation3.getLatitude(), this.f4033g.getLongitude()});
                        if (f2 < AuthUtil.getGpsGeoDis() * 3) {
                            a(messenger, str, 3);
                        }
                    } else {
                        f2 = -1.0f;
                    }
                    if (f2 == -1.0f || (f2 > AuthUtil.getGpsGeoDis() && Utils.getTimeBoot() - this.f4043q > AuthUtil.getGpsGeoDelay() * 1000)) {
                        a(bundle);
                        this.f4033g = this.f4037k.gpsLocationGeo(d5, d8, z5);
                        this.f4043q = Utils.getTimeBoot();
                        AMapLocation aMapLocation4 = this.f4033g;
                        if (aMapLocation4 == null || TextUtils.isEmpty(aMapLocation4.getAdCode())) {
                            return;
                        }
                        a(messenger, str, 3);
                    }
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    private void a(Messenger messenger, String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", AuthUtil.getGpsGeoDis() * i3);
        bundle.putInt("I_MIN_GEO_DIS", AuthUtil.getGpsGeoDis());
        bundle.putParcelable("loc", this.f4033g);
        if (Const.TYPE_COARSE_LOC.equals(str)) {
            a(messenger, OfflineMapStatus.EXCEPTION_SDCARD, bundle);
            return;
        }
        if (Const.TYPE_GPS_LOC.equals(str)) {
            a(messenger, 6, bundle);
            return;
        }
        if (Const.TYPE_NETWORK_LOC.equals(str)) {
            a(messenger, 18, bundle);
        } else if (Const.TYPE_LBS_LOC.equals(str)) {
            a(messenger, 20, bundle);
        } else if (Const.TYPE_FUSION_LOC.equals(str)) {
            a(messenger, 21, bundle);
        }
    }
}
