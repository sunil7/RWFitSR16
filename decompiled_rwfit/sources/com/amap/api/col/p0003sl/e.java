package com.amap.api.col.p0003sl;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.col.p0003sl.q;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.IGnssSatelliteListenerDelegate;
import com.amap.api.location.IReGeoLocationCallback;
import com.amap.api.location.ISensorListenerDelegate;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.storage.LastLocationInfo;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportRecorder;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class e {
    protected static volatile boolean M = false;
    private static boolean N = false;
    private static AtomicBoolean O = new AtomicBoolean(false);
    private IReGeoLocationCallback D;

    /* renamed from: a, reason: collision with root package name */
    AMapLocation f3925a;

    /* renamed from: b, reason: collision with root package name */
    private Context f3926b;

    /* renamed from: d, reason: collision with root package name */
    protected d f3928d;

    /* renamed from: g, reason: collision with root package name */
    private p f3930g;

    /* renamed from: s, reason: collision with root package name */
    v f3941s;

    /* renamed from: v, reason: collision with root package name */
    Intent f3944v;

    /* renamed from: c, reason: collision with root package name */
    AMapLocationClientOption f3927c = new AMapLocationClientOption();
    private r e = null;

    /* renamed from: f, reason: collision with root package name */
    private u f3929f = null;

    /* renamed from: h, reason: collision with root package name */
    private s f3931h = null;

    /* renamed from: i, reason: collision with root package name */
    private q f3932i = null;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3933j = false;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f3934k = false;

    /* renamed from: l, reason: collision with root package name */
    ArrayList<AMapLocationListener> f3935l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    protected boolean f3936m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3937n = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3938o = true;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3939p = true;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3940q = true;
    public boolean r = true;

    /* renamed from: t, reason: collision with root package name */
    Messenger f3942t = null;

    /* renamed from: u, reason: collision with root package name */
    Messenger f3943u = null;

    /* renamed from: w, reason: collision with root package name */
    c f3945w = null;

    /* renamed from: x, reason: collision with root package name */
    boolean f3946x = false;

    /* renamed from: y, reason: collision with root package name */
    Object f3947y = new Object();

    /* renamed from: z, reason: collision with root package name */
    ReportUtil f3948z = null;
    boolean A = false;
    o B = null;
    private boolean C = false;
    protected AMapLocationClientOption E = new AMapLocationClientOption();
    private n F = null;
    String G = null;
    private ServiceConnection H = new a();
    AMapLocationQualityReport I = null;
    b J = null;
    String K = null;
    boolean L = false;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                e.this.f3942t = new Messenger(iBinder);
                e.this.f3933j = true;
                e.this.A = true;
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e eVar = e.this;
            eVar.f3942t = null;
            eVar.f3933j = false;
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v9 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ?? r02 = 0;
            try {
                super.handleMessage(message);
                if (AuthUtil.mLocationDisable) {
                    Log.e("AMapLocationClient", "SERVICE_NOT_AVAILABLE");
                    return;
                }
                int i3 = message.what;
                if (i3 == 11) {
                    e.this.a(message);
                    return;
                }
                if (i3 == 12) {
                    e.b(e.this, message);
                    return;
                }
                if (i3 == 16) {
                    e.c(e.this, message);
                    return;
                }
                if (i3 == 22) {
                    e.a(e.this, message);
                    return;
                }
                if (i3 == 1011) {
                    e.this.a();
                    return;
                }
                try {
                    switch (i3) {
                        case 1002:
                            e eVar = e.this;
                            AMapLocationListener aMapLocationListener = (AMapLocationListener) message.obj;
                            eVar.getClass();
                            if (aMapLocationListener == null) {
                                throw new IllegalArgumentException("listener参数不能为null");
                            }
                            if (eVar.f3935l == null) {
                                eVar.f3935l = new ArrayList<>();
                            }
                            if (eVar.f3935l.contains(aMapLocationListener)) {
                                return;
                            }
                            eVar.f3935l.add(aMapLocationListener);
                            return;
                        case 1003:
                            e.this.b();
                            e.this.a(13, (Bundle) null);
                            return;
                        case 1004:
                            e.this.c();
                            e.this.a(14, (Bundle) null);
                            return;
                        case 1005:
                            e.a(e.this, (AMapLocationListener) message.obj);
                            return;
                        default:
                            switch (i3) {
                                case 1014:
                                    e.d(e.this, message);
                                    return;
                                case 1015:
                                    ((k) e.this.e).a(e.this.f3927c);
                                    e.this.a(GLMapStaticValue.AM_PARAMETERNAME_PROCESS_MAP, null, Const.L_GPS_REBOOT_INTERVAL);
                                    return;
                                case 1016:
                                    if (Utils.isCoarsePermOpen(e.this.f3926b)) {
                                        DebugUtils.writeCat("coarse permission lbs location");
                                        e.e(e.this);
                                        return;
                                    }
                                    k kVar = (k) e.this.e;
                                    kVar.getClass();
                                    if (Utils.getTimeBoot() - kVar.f4343g <= 2800) {
                                        e.this.a(1016, null, 1000L);
                                        return;
                                    }
                                    ((w) e.this.f3931h).a(e.this.f3927c);
                                    return;
                                case 1017:
                                    ((k) e.this.e).c();
                                    e.this.b(GLMapStaticValue.AM_PARAMETERNAME_PROCESS_MAP);
                                    return;
                                case 1018:
                                    e eVar2 = e.this;
                                    AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                    eVar2.f3927c = aMapLocationClientOption;
                                    if (aMapLocationClientOption != null) {
                                        e.f(eVar2);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i3) {
                                        case 1023:
                                            e.e(e.this, message);
                                            return;
                                        case 1024:
                                            e.f(e.this, message);
                                            return;
                                        case GLMapStaticValue.AM_PARAMETERNAME_PROCESS_MAP /* 1025 */:
                                            k kVar2 = (k) e.this.e;
                                            AMapLocationClientOption aMapLocationClientOption2 = kVar2.e;
                                            if (aMapLocationClientOption2 != null && !aMapLocationClientOption2.isOnceLocation() && Utils.getTimeBoot() - kVar2.f4343g > Const.L_GPS_REBOOT_INTERVAL) {
                                                ((k) e.this.e).c();
                                                ((k) e.this.e).a(e.this.f3927c);
                                            }
                                            e.this.a(GLMapStaticValue.AM_PARAMETERNAME_PROCESS_MAP, null, Const.L_GPS_REBOOT_INTERVAL);
                                            return;
                                        case 1026:
                                            DebugUtils.writeCat("start coarse location", false);
                                            ((h) e.this.f3930g).a(e.this.f3927c);
                                            return;
                                        case 1027:
                                            ((h) e.this.f3930g).c();
                                            return;
                                        case 1028:
                                            e.this.d((AMapLocation) message.obj);
                                            return;
                                        case 1029:
                                            ((w) e.this.f3931h).getClass();
                                            return;
                                        case GLMapStaticValue.MAP_PARAMETERNAME_SCENIC /* 1030 */:
                                            q qVar = e.this.f3932i;
                                            AMapLocationClientOption aMapLocationClientOption3 = e.this.f3927c;
                                            ((q.a) qVar).getClass();
                                            return;
                                        case 1031:
                                            ((q.a) e.this.f3932i).getClass();
                                            return;
                                        case 1032:
                                            if (e.this.f3927c.isSysNetworkLocEnable()) {
                                                e.this.f3929f.a(e.this.f3927c);
                                                e.this.a(1034, null, Const.L_GPS_REBOOT_INTERVAL);
                                                return;
                                            }
                                            return;
                                        case 1033:
                                            e.this.f3929f.c();
                                            e.this.b(1034);
                                            return;
                                        case 1034:
                                            if (e.this.f3929f.a()) {
                                                e.this.f3929f.c();
                                                e.this.f3929f.a(e.this.f3927c);
                                            }
                                            e.this.a(1034, null, Const.L_GPS_REBOOT_INTERVAL);
                                            return;
                                        case 1035:
                                            Bundle data = message.getData();
                                            AMapLocation aMapLocation = (AMapLocation) data.getParcelable(Const.LBS_FAIL_BD_LOC);
                                            AMapLocationStaticsEntity aMapLocationStaticsEntity = (AMapLocationStaticsEntity) data.getParcelable(Const.LBS_FAIL_BD_ENTITY);
                                            e.this.b(aMapLocation, aMapLocationStaticsEntity);
                                            return;
                                        case 1036:
                                            Bundle bundle = new Bundle();
                                            bundle.putString(Const.OBJ_HASH, Integer.toString(System.identityHashCode(this)));
                                            e.this.a(100, bundle);
                                            return;
                                        case 1037:
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putString(Const.OBJ_HASH, Integer.toString(System.identityHashCode(this)));
                                            e.this.a(101, bundle2);
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
                } catch (Throwable th2) {
                    r02 = message;
                    th = th2;
                    if (r02 == 0) {
                        r02 = "handleMessage";
                    }
                    CoreUtil.reportError(th, "AMapLocationManage$MHandlerr", r02);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static class c extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        e f3951a;

        public c(String str, e eVar) {
            super(str);
            this.f3951a = eVar;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            try {
                this.f3951a.f3941s.c();
                ReportRecorder.getInstance(this.f3951a.f3926b);
                this.f3951a.j();
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public e(Context context, Intent intent, Looper looper) {
        this.f3944v = null;
        this.f3926b = context;
        this.f3944v = intent;
        a(looper);
    }

    public static void a(e eVar, AMapLocation aMapLocation) {
        eVar.getClass();
        try {
            int i3 = 0;
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    ReportUtil.reportLog("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (!"gps".equalsIgnoreCase(aMapLocation.getProvider())) {
                k kVar = (k) eVar.e;
                kVar.getClass();
                if (Utils.getTimeBoot() - kVar.f4343g <= 2800 && !Const.PROVIDER_LBS.equalsIgnoreCase(aMapLocation.getProvider()) && eVar.f3929f.b()) {
                    return;
                }
            }
            aMapLocation.setAltitude(Utils.formatDoubleKeep2Point(aMapLocation.getAltitude()));
            aMapLocation.setBearing(Utils.formatFloatKeep2Point(aMapLocation.getBearing()));
            aMapLocation.setSpeed(Utils.formatFloatKeep2Point(aMapLocation.getSpeed()));
            eVar.a(aMapLocation);
            try {
                if (2 == aMapLocation.getLocationType() || 4 == aMapLocation.getLocationType()) {
                    long time = aMapLocation.getTime();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis > time) {
                        aMapLocation.setTime(currentTimeMillis);
                    }
                }
            } catch (Throwable unused) {
            }
            ArrayList<AMapLocationListener> arrayList = eVar.f3935l;
            int size = arrayList.size();
            while (i3 < size) {
                AMapLocationListener aMapLocationListener = arrayList.get(i3);
                i3++;
                try {
                    aMapLocationListener.onLocationChanged(aMapLocation);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void b(e eVar, Message message) {
        eVar.getClass();
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            DebugUtils.writeCatTag("AmapLocationManager", "Gps Longitude:" + aMapLocation.getLongitude() + " Latitude:" + aMapLocation.getLatitude());
            if (eVar.f3938o && eVar.f3942t != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", CoreUtil.getOptionBundle(eVar.f3927c));
                eVar.a(0, bundle);
                eVar.f3938o = false;
            }
            eVar.b(aMapLocation, (AMapLocationStaticsEntity) null);
            eVar.b(GLMapStaticValue.AM_PARAMETERNAME_PROCESS_MAP);
            eVar.a(GLMapStaticValue.AM_PARAMETERNAME_PROCESS_MAP, null, Const.L_GPS_REBOOT_INTERVAL);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "resultGpsLocationSuccess");
        }
    }

    public static void c(e eVar, Message message) {
        eVar.getClass();
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            DebugUtils.writeCatTag("AmapLocationManager", "Network Longitude:" + aMapLocation.getLongitude() + " Latitude:" + aMapLocation.getLatitude());
            if (eVar.f3940q && eVar.f3942t != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", CoreUtil.getOptionBundle(eVar.f3927c));
                eVar.a(0, bundle);
                if (eVar.f3934k) {
                    eVar.a(13, (Bundle) null);
                }
                eVar.f3940q = false;
            }
            if (!eVar.f3927c.isLBSLocationEnable() || eVar.C) {
                eVar.b(1035);
                eVar.b(aMapLocation, (AMapLocationStaticsEntity) null);
            }
            eVar.b(1034);
            eVar.a(1034, null, Const.L_GPS_REBOOT_INTERVAL);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "resultNetworkLocationSuccess");
        }
    }

    public static void d(e eVar, Message message) {
        AMapLocation amapLocation;
        eVar.getClass();
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            if (aMapLocation != null) {
                try {
                    LastLocationInfo lastLocationInfo = v.f5158g;
                    if (lastLocationInfo == null) {
                        v vVar = eVar.f3941s;
                        amapLocation = vVar != null ? vVar.b() : null;
                    } else {
                        amapLocation = lastLocationInfo.getAmapLocation();
                    }
                    ReportUtil.checkBigShift(amapLocation, aMapLocation);
                } catch (Throwable unused) {
                }
            }
            if (eVar.f3941s.a(aMapLocation, string)) {
                eVar.f3941s.e();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "doSaveLastLocation");
        }
    }

    public static void e(e eVar) {
        eVar.getClass();
        try {
            new AMapLocationStaticsEntity().setReason("#2001");
            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_UNSUPPORTCOARSELBSLOC);
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(20);
            aMapLocationServer.setLocationDetail("模糊权限下不支持低功耗定位#2001");
            eVar.d(aMapLocationServer);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "apsLocation:callback");
        }
    }

    public boolean f() {
        return false;
    }

    public void l() {
        try {
            n nVar = this.F;
            if (nVar != null) {
                nVar.a();
                this.F = null;
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "stopAssistantLocation");
        }
    }

    public void m() {
        try {
            a(1004, null, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "stopLocation");
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            d dVar;
            d dVar2;
            AMapLocationClientOption aMapLocationClientOption;
            d dVar3;
            d dVar4;
            try {
                super.handleMessage(message);
                eVar = e.this;
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
                return;
            }
            if (eVar.f3946x) {
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    switch (i3) {
                        case 5:
                            Bundle data = message.getData();
                            data.putBundle("optBundle", CoreUtil.getOptionBundle(e.this.f3927c));
                            e.this.a(10, data);
                            break;
                        case 6:
                            Bundle data2 = message.getData();
                            if (e.this.e != null) {
                                ((k) e.this.e).a(data2);
                                break;
                            }
                            break;
                        case 7:
                            e.b(e.this, message.getData().getBoolean("ngpsAble"));
                            break;
                        case 8:
                            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOENOUGHSTATELLITES);
                            break;
                        case 9:
                            boolean unused = e.N = message.getData().getBoolean("installMockApp");
                            break;
                        case 10:
                            e.a(eVar, (AMapLocation) message.obj);
                            break;
                        default:
                            switch (i3) {
                                case 13:
                                    AMapLocation aMapLocation = eVar.f3925a;
                                    if (aMapLocation == null) {
                                        AMapLocation aMapLocation2 = new AMapLocation(Const.PROVIDER_LBS);
                                        aMapLocation2.setErrorCode(33);
                                        e.a(e.this, aMapLocation2);
                                        break;
                                    } else {
                                        e.a(eVar, aMapLocation);
                                        break;
                                    }
                                case 14:
                                    Bundle data3 = message.getData();
                                    data3.putBundle("optBundle", CoreUtil.getOptionBundle(e.this.f3927c));
                                    e.this.a(18, data3);
                                    break;
                                case 15:
                                    Message obtain = Message.obtain();
                                    obtain.what = 16;
                                    obtain.obj = message.obj;
                                    e.this.J.sendMessage(obtain);
                                    break;
                                default:
                                    switch (i3) {
                                        case 17:
                                            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOCGIANDWIFI);
                                            break;
                                        case 18:
                                            Bundle data4 = message.getData();
                                            if (e.this.f3929f != null) {
                                                e.this.f3929f.a(data4);
                                                break;
                                            }
                                            break;
                                        case 19:
                                            AMapLocation aMapLocation3 = (AMapLocation) message.getData().getParcelable("loc");
                                            if (aMapLocation3 != null && e.this.D != null) {
                                                e.this.D.onReGeoLocation(aMapLocation3);
                                                break;
                                            }
                                            break;
                                        case 20:
                                            message.getData();
                                            if (e.this.f3931h != null) {
                                                ((w) e.this.f3931h).getClass();
                                                break;
                                            }
                                            break;
                                        case 21:
                                            message.getData();
                                            if (e.this.f3932i != null) {
                                                ((q.a) e.this.f3932i).getClass();
                                                break;
                                            }
                                            break;
                                        default:
                                            switch (i3) {
                                                case 23:
                                                    Message obtainMessage = e.this.J.obtainMessage();
                                                    obtainMessage.what = 22;
                                                    obtainMessage.obj = message.obj;
                                                    e.this.J.sendMessage(obtainMessage);
                                                    aMapLocationClientOption = e.this.E;
                                                    if (aMapLocationClientOption == null && aMapLocationClientOption.getCacheCallBack() && (dVar3 = e.this.f3928d) != null) {
                                                        dVar3.removeMessages(13);
                                                        break;
                                                    }
                                                    break;
                                                case 24:
                                                    Bundle data5 = message.getData();
                                                    data5.putBundle("optBundle", CoreUtil.getOptionBundle(e.this.f3927c));
                                                    e.this.a(17, data5);
                                                    break;
                                                case 25:
                                                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NET_LOC_FAIL);
                                                    break;
                                                case 26:
                                                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_FUSION_LOC_FAIL);
                                                    Message obtainMessage2 = e.this.J.obtainMessage();
                                                    obtainMessage2.what = 22;
                                                    obtainMessage2.obj = message.obj;
                                                    e.this.J.sendMessage(obtainMessage2);
                                                    aMapLocationClientOption = e.this.E;
                                                    if (aMapLocationClientOption == null) {
                                                        break;
                                                    }
                                                    break;
                                                case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                                                    Bundle data6 = message.getData();
                                                    data6.putBundle("optBundle", CoreUtil.getOptionBundle(e.this.f3927c));
                                                    e.this.a(16, data6);
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 100:
                                                            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_GPSORNLPUNABLE);
                                                            break;
                                                        case 102:
                                                            Bundle data7 = message.getData();
                                                            data7.putBundle("optBundle", CoreUtil.getOptionBundle(e.this.f3927c));
                                                            e.this.a(15, data7);
                                                            break;
                                                        case OfflineMapStatus.EXCEPTION_SDCARD /* 103 */:
                                                            Bundle data8 = message.getData();
                                                            if (e.this.f3930g != null) {
                                                                ((h) e.this.f3930g).a(data8);
                                                                break;
                                                            }
                                                            break;
                                                    }
                                                    Message obtain2 = Message.obtain();
                                                    obtain2.what = 1028;
                                                    obtain2.obj = message.obj;
                                                    e.this.J.sendMessage(obtain2);
                                                    AMapLocationClientOption aMapLocationClientOption2 = e.this.E;
                                                    if (aMapLocationClientOption2 != null && aMapLocationClientOption2.getCacheCallBack() && (dVar4 = e.this.f3928d) != null) {
                                                        dVar4.removeMessages(13);
                                                        break;
                                                    }
                                                    break;
                                            }
                                    }
                            }
                    }
                    return;
                }
                Message obtain3 = Message.obtain();
                obtain3.what = 12;
                obtain3.obj = message.obj;
                e.this.J.sendMessage(obtain3);
                AMapLocationClientOption aMapLocationClientOption3 = e.this.E;
                if (aMapLocationClientOption3 == null || !aMapLocationClientOption3.getCacheCallBack() || (dVar2 = e.this.f3928d) == null) {
                    return;
                }
                dVar2.removeMessages(13);
                return;
            }
            Message obtainMessage3 = e.this.J.obtainMessage();
            obtainMessage3.what = 11;
            obtainMessage3.setData(message.getData());
            obtainMessage3.obj = message.obj;
            e.this.J.sendMessage(obtainMessage3);
            AMapLocationClientOption aMapLocationClientOption4 = e.this.E;
            if (aMapLocationClientOption4 == null || !aMapLocationClientOption4.getCacheCallBack() || (dVar = e.this.f3928d) == null) {
                return;
            }
            dVar.removeMessages(13);
        }

        public d() {
        }
    }

    public static void f(e eVar, Message message) {
        eVar.getClass();
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z5 = data.getBoolean(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, true);
            Intent d5 = eVar.d();
            d5.putExtra(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, z5);
            d5.putExtra(Const.INTENT_KEY_BACKGROUND_COMMAND, 2);
            eVar.a(d5, false);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "doDisableBackgroundLocation");
        }
    }

    public boolean g() {
        return this.f3933j;
    }

    public void h() {
        try {
            n nVar = this.F;
            if (nVar != null) {
                nVar.a();
                this.F = null;
            }
            a(1011, null, 0L);
            this.f3946x = true;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "onDestroy");
        }
    }

    public void i() {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public void j() {
        try {
            if (this.f3943u == null) {
                this.f3943u = new Messenger(this.f3928d);
            }
            try {
                this.f3926b.bindService(d(), this.H, 1);
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "ALManager", "startServiceImpl");
            }
        } catch (Throwable unused) {
        }
    }

    public void k() {
        d dVar;
        try {
            if (this.E.getCacheCallBack() && (dVar = this.f3928d) != null) {
                dVar.sendEmptyMessageDelayed(13, this.E.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            a(1003, null, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "startLocation");
        }
    }

    public static void e(e eVar, Message message) {
        eVar.getClass();
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i3 = data.getInt(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, 0);
            Notification notification = (Notification) data.getParcelable(Const.INTENT_KEY_BACKGROUND_NOTIFICATION);
            Intent d5 = eVar.d();
            d5.putExtra(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, i3);
            d5.putExtra(Const.INTENT_KEY_BACKGROUND_NOTIFICATION, notification);
            d5.putExtra(Const.INTENT_KEY_BACKGROUND_COMMAND, 1);
            eVar.a(d5, true);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "doEnableBackgroundLocation");
        }
    }

    public static void f(e eVar) {
        ((w) eVar.f3931h).b(eVar.f3927c);
        ((k) eVar.e).b(eVar.f3927c);
        ((h) eVar.f3930g).b(eVar.f3927c);
        ((q.a) eVar.f3932i).getClass();
        if (eVar.f3934k) {
            eVar.c();
            eVar.b();
        }
        eVar.f3927c.getLocationMode();
        if (eVar.f3948z != null) {
            if (eVar.f3927c.isOnceLocation()) {
                eVar.f3948z.setLocationType(eVar.f3926b, 0);
            } else {
                eVar.f3948z.setLocationType(eVar.f3926b, 1);
            }
            eVar.f3948z.setLocationMode(eVar.f3926b, eVar.f3927c);
        }
    }

    public Intent d() {
        String str;
        if (this.f3944v == null) {
            this.f3944v = new Intent(this.f3926b, (Class<?>) APSService.class);
        }
        try {
            if (!TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY())) {
                str = AMapLocationClientOption.getAPIKEY();
            } else {
                str = b9.e(this.f3926b);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.f3944v.putExtra(Const.INTENT_KEY_APIKEY, str);
        this.f3944v.putExtra(Const.INTENT_KEY_PKGNAME, b9.f(this.f3926b));
        this.f3944v.putExtra(Const.INTENT_KEY_UMID, UmidtokenInfo.getUmidtoken());
        return this.f3944v;
    }

    public static /* synthetic */ boolean b(e eVar, boolean z5) {
        eVar.getClass();
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3) {
        synchronized (this.f3947y) {
            try {
                b bVar = this.J;
                if (bVar != null) {
                    bVar.removeMessages(i3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void c(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putParcelable("loc", aMapLocation);
            a(19, bundle);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "gReGeoL");
        }
    }

    public void b(AMapLocationListener aMapLocationListener) {
        try {
            a(1005, aMapLocationListener, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "unRegisterLocationListener");
        }
    }

    public AMapLocation e() {
        AMapLocation aMapLocation = null;
        try {
            v vVar = this.f3941s;
            if (vVar == null || (aMapLocation = vVar.b()) == null) {
                return aMapLocation;
            }
            aMapLocation.setTrustedLevel(3);
            return aMapLocation;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "getLastKnownLocation");
            return aMapLocation;
        }
    }

    private void b(AMapLocation aMapLocation) {
        Message obtainMessage = this.f3928d.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.f3928d.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            DebugUtils.writeCatTag("AmapLocationManager", "doStopLocation");
            b(GLMapStaticValue.AM_PARAMETERNAME_PROCESS_MAP);
            b(1034);
            r rVar = this.e;
            if (rVar != null) {
                ((k) rVar).c();
            }
            u uVar = this.f3929f;
            if (uVar != null) {
                uVar.c();
            }
            p pVar = this.f3930g;
            if (pVar != null) {
                ((h) pVar).c();
            }
            b(1016);
            s sVar = this.f3931h;
            if (sVar != null) {
            }
            q qVar = this.f3932i;
            if (qVar != null) {
            }
            a(1037, null, 0L);
            this.f3934k = false;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "stopLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AMapLocation aMapLocation) {
        try {
            if (this.f3939p && this.f3942t != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", CoreUtil.getOptionBundle(this.f3927c));
                a(0, bundle);
                this.f3939p = false;
            }
            a(aMapLocation, (AMapLocationStaticsEntity) null);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "resultGpsLocationSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:(9:2|3|(1:5)|6|(1:8)|9|(1:11)|12|13)|(11:15|16|(1:18)|(1:20)|21|(2:23|(1:27))|28|29|(5:31|(1:33)|34|(4:38|(2:43|(4:45|(1:(1:(2:(1:50)|51)))|52|51)(4:53|(2:59|51)|52|51))|60|51)|61)|63|(2:65|66)(4:68|(1:70)|72|73))|77|(0)|21|(0)|28|29|(0)|63|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00eb, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0163, code lost:
    
        com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r9, "ALManager", "handlerLocation part2");
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087 A[Catch: all -> 0x001c, TryCatch #1 {all -> 0x001c, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x001f, B:8:0x0023, B:9:0x002a, B:11:0x0039, B:12:0x0051, B:16:0x0072, B:20:0x0087, B:21:0x0090, B:23:0x00a4, B:25:0x00b7, B:27:0x00bc, B:63:0x016a, B:68:0x0170, B:70:0x0178, B:76:0x0163, B:77:0x0080, B:29:0x00c7, B:31:0x00cb, B:33:0x00e3, B:34:0x00ee, B:36:0x0109, B:38:0x010d, B:43:0x0120, B:45:0x012c, B:51:0x014b, B:52:0x0147, B:53:0x0137, B:59:0x0142, B:61:0x0150), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4 A[Catch: all -> 0x001c, TryCatch #1 {all -> 0x001c, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x001f, B:8:0x0023, B:9:0x002a, B:11:0x0039, B:12:0x0051, B:16:0x0072, B:20:0x0087, B:21:0x0090, B:23:0x00a4, B:25:0x00b7, B:27:0x00bc, B:63:0x016a, B:68:0x0170, B:70:0x0178, B:76:0x0163, B:77:0x0080, B:29:0x00c7, B:31:0x00cb, B:33:0x00e3, B:34:0x00ee, B:36:0x0109, B:38:0x010d, B:43:0x0120, B:45:0x012c, B:51:0x014b, B:52:0x0147, B:53:0x0137, B:59:0x0142, B:61:0x0150), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[Catch: all -> 0x00eb, TryCatch #0 {all -> 0x00eb, blocks: (B:29:0x00c7, B:31:0x00cb, B:33:0x00e3, B:34:0x00ee, B:36:0x0109, B:38:0x010d, B:43:0x0120, B:45:0x012c, B:51:0x014b, B:52:0x0147, B:53:0x0137, B:59:0x0142, B:61:0x0150), top: B:28:0x00c7, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016e A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0170 A[Catch: all -> 0x001c, TRY_ENTER, TryCatch #1 {all -> 0x001c, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x001f, B:8:0x0023, B:9:0x002a, B:11:0x0039, B:12:0x0051, B:16:0x0072, B:20:0x0087, B:21:0x0090, B:23:0x00a4, B:25:0x00b7, B:27:0x00bc, B:63:0x016a, B:68:0x0170, B:70:0x0178, B:76:0x0163, B:77:0x0080, B:29:0x00c7, B:31:0x00cb, B:33:0x00e3, B:34:0x00ee, B:36:0x0109, B:38:0x010d, B:43:0x0120, B:45:0x012c, B:51:0x014b, B:52:0x0147, B:53:0x0137, B:59:0x0142, B:61:0x0150), top: B:2:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void b(com.amap.api.location.AMapLocation r9, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r10) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e.b(com.amap.api.location.AMapLocation, com.autonavi.aps.amapapi.AMapLocationStaticsEntity):void");
    }

    public static void a(e eVar, Message message) {
        AMapLocation aMapLocation;
        eVar.getClass();
        try {
            aMapLocation = (AMapLocation) message.obj;
            if (eVar.f3937n && eVar.f3942t != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", CoreUtil.getOptionBundle(eVar.f3927c));
                eVar.a(0, bundle);
                eVar.f3937n = false;
            }
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                r rVar = eVar.e;
                if (rVar != null) {
                    ((k) rVar).f4360y = 0;
                }
                if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("loc", aMapLocation);
                    ((k) eVar.e).a(bundle2);
                    eVar.f3929f.a(bundle2);
                    ((h) eVar.f3930g).a(bundle2);
                    ((q.a) eVar.f3932i).getClass();
                }
            }
            r rVar2 = eVar.e;
            if (rVar2 != null) {
                aMapLocation = ((k) rVar2).a(aMapLocation, eVar.K);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AmapLocationManager", "resultFusionLocationSuccess");
            aMapLocation = null;
        }
        eVar.b(aMapLocation, (AMapLocationStaticsEntity) null);
    }

    public void c(boolean z5) {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public void a(int i3, Object obj, long j4) {
        synchronized (this.f3947y) {
            try {
                if (this.J != null) {
                    Message obtain = Message.obtain();
                    obtain.what = i3;
                    if (obj instanceof Bundle) {
                        obtain.setData((Bundle) obj);
                    } else {
                        obtain.obj = obj;
                    }
                    this.J.sendMessageDelayed(obtain, j4);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.E = aMapLocationClientOption.m3clone();
            a(1018, aMapLocationClientOption.m3clone(), 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "setLocationOption");
        }
    }

    public void a(AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "setLocationListener");
        }
    }

    public void a(IReGeoLocationCallback iReGeoLocationCallback) {
        this.D = iReGeoLocationCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0089 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0014, B:10:0x0074, B:12:0x0089, B:13:0x0090, B:15:0x00d5, B:17:0x00db, B:19:0x00df, B:20:0x00e4, B:27:0x0028, B:29:0x0032, B:33:0x0040, B:35:0x004a, B:37:0x0054, B:40:0x0060, B:42:0x006a, B:44:0x00e9, B:46:0x00ed, B:47:0x00f4, B:52:0x00fb, B:59:0x01ab, B:62:0x012e, B:64:0x0136, B:65:0x0149, B:67:0x0154, B:69:0x015c, B:70:0x0164, B:72:0x016e, B:74:0x0176, B:75:0x0189, B:76:0x019c), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void b() {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e.b():void");
    }

    public void a(WebView webView) {
        if (this.F == null) {
            this.F = new n(this.f3926b, webView);
        }
        this.F.b();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0028 -> B:6:0x002f). Please report as a decompilation issue!!! */
    private void a(Looper looper) {
        b bVar;
        try {
            if (looper == null) {
                if (Looper.myLooper() == null) {
                    this.f3928d = new d(this.f3926b.getMainLooper());
                } else {
                    this.f3928d = new d();
                }
            } else {
                this.f3928d = new d(looper);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "init 1");
        }
        try {
            try {
                this.f3941s = new v(this.f3926b);
            } catch (Throwable th3) {
                CoreUtil.reportError(th3, "ALManager", "init 5");
            }
        } catch (Throwable th4) {
            CoreUtil.reportError(th4, "ALManager", "init 2");
        }
        c cVar = new c("amapLocManagerThread", this);
        this.f3945w = cVar;
        cVar.setPriority(5);
        this.f3945w.start();
        Looper looper2 = this.f3945w.getLooper();
        synchronized (this.f3947y) {
            bVar = new b(looper2);
        }
        this.J = bVar;
        if (this.f3948z == null) {
            this.f3948z = new ReportUtil();
        }
        try {
            this.e = new k(this.f3926b, this.f3928d);
            this.f3930g = new h(this.f3926b, this.f3928d);
            this.f3929f = new z(this.f3926b, this.f3928d);
            this.f3931h = new w(this.f3926b, this);
            this.f3932i = q.f4870a;
            this.B = o.f4716a;
        } catch (Throwable th5) {
            CoreUtil.reportError(th5, "ALManager", "init 3");
        }
        Context context = this.f3926b;
        if (O.compareAndSet(false, true)) {
            qc.d().b(new com.amap.api.col.p0003sl.d(context));
        }
    }

    public void a(int i3, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th2) {
                boolean z5 = (th2 instanceof IllegalStateException) && th2.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th2 instanceof RemoteException) || z5) {
                    this.f3942t = null;
                    this.f3933j = false;
                }
                CoreUtil.reportError(th2, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.G)) {
            this.G = CoreUtil.getScode(this.f3926b);
        }
        bundle.putString("c", this.G);
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.setData(bundle);
        obtain.replyTo = this.f3943u;
        Messenger messenger = this.f3942t;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    private void a(AMapLocation aMapLocation) {
        StringBuilder sb2;
        try {
            String locationDetail = aMapLocation.getLocationDetail();
            if (TextUtils.isEmpty(locationDetail)) {
                sb2 = new StringBuilder();
            } else {
                sb2 = new StringBuilder(locationDetail);
            }
            boolean hasPerminssion = Utils.hasPerminssion(this.f3926b, Const.ACCESS_WIFI_STATE_SELF_BASE64);
            boolean hasPerminssion2 = Utils.hasPerminssion(this.f3926b, Const.CHANGE_WIFI_STATE_SELF_BASE64);
            boolean hasPerminssion3 = Utils.hasPerminssion(this.f3926b, Const.ACCESS_LOCATION_EXTRA_COMMANDS_SELF_BASE64);
            boolean hasPerminssion4 = Utils.hasPerminssion(this.f3926b, Const.READ_PHONE_STATE_SELF_BASE64);
            boolean hasPerminssion5 = Utils.hasPerminssion(this.f3926b, Const.ACCESS_FINE_LOCATION_SELF_BASE64);
            boolean hasPerminssion6 = Utils.hasPerminssion(this.f3926b, Const.ACCESS_COARSE_LOCATION_SELF_BASE64);
            sb2.append(hasPerminssion ? "#pm1" : "#pm0");
            sb2.append(hasPerminssion2 ? "1" : "0");
            sb2.append(hasPerminssion3 ? "1" : "0");
            sb2.append(hasPerminssion4 ? "1" : "0");
            sb2.append(hasPerminssion5 ? "1" : "0");
            sb2.append(hasPerminssion6 ? "1" : "0");
            aMapLocation.setLocationDetail(sb2.toString());
        } catch (Throwable unused) {
            DebugUtils.writeCat("api e", false);
        }
    }

    public void b(ISensorListenerDelegate iSensorListenerDelegate) {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public void b(IGnssSatelliteListenerDelegate iGnssSatelliteListenerDelegate) {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public void b(boolean z5) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, z5);
            a(1024, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "disableBackgroundLocation");
        }
    }

    private synchronized void a(AMapLocation aMapLocation, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } finally {
            }
        }
        if (this.I == null) {
            this.I = new AMapLocationQualityReport();
        }
        this.I.setLocationMode(this.f3927c.getLocationMode());
        if (this.f3930g != null) {
            this.I.setGPSSatellites(aMapLocation.getSatellites());
            this.I.setGpsStatus(((h) this.f3930g).d());
        }
        this.I.setWifiAble(Utils.isWifiAble(this.f3926b));
        this.I.setNetworkType(Utils.getNetWorkTypeStr(this.f3926b));
        this.I.setNetUseTime(0L);
        this.I.setInstallHighDangerMockApp(N);
        aMapLocation.setLocationQualityReport(this.I);
        try {
            if (this.f3934k) {
                ReportUtil.recordOfflineLocLog(this.f3926b, aMapLocation);
                b(aMapLocation.m2clone());
                ReportRecorder.getInstance(this.f3926b).addRecortNum(aMapLocation);
                ReportRecorder.getInstance(this.f3926b).applyStatistics();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "handlerCoarseLocation part");
        }
        if (this.f3946x) {
            return;
        }
        if (this.f3930g != null) {
            c();
        }
    }

    public void a(int i3, int i10, long j4, long j10, String str) {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public void a(ISensorListenerDelegate iSensorListenerDelegate) {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public void a(IGnssSatelliteListenerDelegate iGnssSatelliteListenerDelegate) {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public static void a(e eVar, AMapLocationListener aMapLocationListener) {
        if (!eVar.f3935l.isEmpty() && eVar.f3935l.contains(aMapLocationListener)) {
            eVar.f3935l.remove(aMapLocationListener);
        }
        if (eVar.f3935l.isEmpty()) {
            eVar.c();
        }
    }

    public void a() {
        a(12, (Bundle) null);
        this.f3936m = true;
        this.f3938o = true;
        this.f3940q = true;
        this.f3937n = true;
        this.f3939p = true;
        this.r = true;
        this.f3933j = false;
        this.A = false;
        c();
        ReportUtil reportUtil = this.f3948z;
        if (reportUtil != null) {
            reportUtil.saveLocationTypeAndMode(this.f3926b);
        }
        ReportRecorder.getInstance(this.f3926b).synToDisk();
        ReportUtil.saveStatistics(this.f3926b);
        ServiceConnection serviceConnection = this.H;
        if (serviceConnection != null) {
            this.f3926b.unbindService(serviceConnection);
        }
        try {
            if (this.L) {
                this.f3926b.stopService(d());
            }
        } catch (Throwable unused) {
        }
        this.L = false;
        ArrayList<AMapLocationListener> arrayList = this.f3935l;
        if (arrayList != null) {
            arrayList.clear();
            this.f3935l = null;
        }
        this.H = null;
        synchronized (this.f3947y) {
            try {
                b bVar = this.J;
                if (bVar != null) {
                    bVar.removeCallbacksAndMessages(null);
                }
                this.J = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        c cVar = this.f3945w;
        if (cVar != null) {
            try {
                Reflect.invokeMethod(cVar, HandlerThread.class, "quitSafely", new Object[0]);
            } catch (Throwable unused2) {
                this.f3945w.quit();
            }
        }
        this.f3945w = null;
        d dVar = this.f3928d;
        if (dVar != null) {
            dVar.removeCallbacksAndMessages(null);
        }
        v vVar = this.f3941s;
        if (vVar != null) {
            vVar.a();
            this.f3941s = null;
        }
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    public void a(int i3) {
        o oVar = this.B;
        if (oVar != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.os.Message r9) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e.a(android.os.Message):void");
    }

    public void a(int i3, Notification notification) {
        if (i3 == 0 || notification == null) {
            return;
        }
        try {
            if (this.r && this.f3942t != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", CoreUtil.getOptionBundle(this.f3927c));
                a(0, bundle);
                this.r = false;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, i3);
            bundle2.putParcelable(Const.INTENT_KEY_BACKGROUND_NOTIFICATION, notification);
            a(1023, bundle2, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "ALManager", "disableBackgroundLocation");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.Intent r4, boolean r5) {
        /*
            r3 = this;
            android.content.Context r0 = r3.f3926b
            if (r0 == 0) goto L5d
            r1 = 1
            if (r5 == 0) goto L58
            boolean r5 = com.autonavi.aps.amapapi.utils.Utils.isTargetAndroidP(r0)
            if (r5 == 0) goto L2b
            android.content.Context r5 = r3.f3926b     // Catch: java.lang.Throwable -> L26
            android.content.Context r5 = r5.getApplicationContext()     // Catch: java.lang.Throwable -> L26
            android.app.Application r5 = (android.app.Application) r5     // Catch: java.lang.Throwable -> L26
            android.content.Context r5 = r5.getBaseContext()     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = "checkSelfPermission"
            java.lang.String r2 = "android.permission.FOREGROUND_SERVICE"
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.Throwable -> L26
            int r5 = com.autonavi.aps.amapapi.utils.Reflect.invokeIntMethod(r5, r0, r2)     // Catch: java.lang.Throwable -> L26
            goto L27
        L26:
            r5 = -1
        L27:
            if (r5 == 0) goto L2b
            r5 = 0
            goto L2c
        L2b:
            r5 = r1
        L2c:
            if (r5 != 0) goto L36
            java.lang.String r4 = "amapapi"
            java.lang.String r5 = "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------"
            android.util.Log.e(r4, r5)
            return
        L36:
            android.content.Context r5 = r3.f3926b     // Catch: java.lang.Throwable -> L52
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = "startForegroundService"
            java.lang.Class<android.content.Intent> r2 = android.content.Intent.class
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.Throwable -> L52
            java.lang.reflect.Method r5 = r5.getMethod(r0, r2)     // Catch: java.lang.Throwable -> L52
            android.content.Context r0 = r3.f3926b     // Catch: java.lang.Throwable -> L52
            java.lang.Object[] r2 = new java.lang.Object[]{r4}     // Catch: java.lang.Throwable -> L52
            r5.invoke(r0, r2)     // Catch: java.lang.Throwable -> L52
            goto L5b
        L52:
            android.content.Context r5 = r3.f3926b
            r5.startService(r4)
            goto L5b
        L58:
            r0.startService(r4)
        L5b:
            r3.L = r1
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.e.a(android.content.Intent, boolean):void");
    }
}
