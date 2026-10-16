package com.amap.api.col.p0003sl;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class a {

    /* renamed from: z, reason: collision with root package name */
    private static boolean f3511z = false;

    /* renamed from: b, reason: collision with root package name */
    Context f3513b;

    /* renamed from: a, reason: collision with root package name */
    ReportUtil f3512a = null;

    /* renamed from: c, reason: collision with root package name */
    PendingIntent f3514c = null;

    /* renamed from: d, reason: collision with root package name */
    String f3515d = null;
    GeoFenceListener e = null;

    /* renamed from: f, reason: collision with root package name */
    private Object f3516f = new Object();

    /* renamed from: g, reason: collision with root package name */
    volatile int f3517g = 1;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<GeoFence> f3518h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    d f3519i = null;

    /* renamed from: j, reason: collision with root package name */
    Object f3520j = new Object();

    /* renamed from: k, reason: collision with root package name */
    Object f3521k = new Object();

    /* renamed from: l, reason: collision with root package name */
    b f3522l = null;

    /* renamed from: m, reason: collision with root package name */
    c f3523m = null;

    /* renamed from: n, reason: collision with root package name */
    volatile boolean f3524n = false;

    /* renamed from: o, reason: collision with root package name */
    volatile boolean f3525o = false;

    /* renamed from: p, reason: collision with root package name */
    volatile boolean f3526p = false;

    /* renamed from: q, reason: collision with root package name */
    com.amap.api.col.p0003sl.b f3527q = null;
    com.amap.api.col.p0003sl.c r = null;

    /* renamed from: s, reason: collision with root package name */
    AMapLocationClient f3528s = null;

    /* renamed from: t, reason: collision with root package name */
    volatile AMapLocation f3529t = null;

    /* renamed from: u, reason: collision with root package name */
    long f3530u = 0;

    /* renamed from: v, reason: collision with root package name */
    AMapLocationClientOption f3531v = null;

    /* renamed from: w, reason: collision with root package name */
    int f3532w = 0;

    /* renamed from: x, reason: collision with root package name */
    AMapLocationListener f3533x = new C0000a();

    /* renamed from: y, reason: collision with root package name */
    volatile boolean f3534y = false;

    /* renamed from: com.amap.api.col.3sl.a$a, reason: collision with other inner class name */
    public class C0000a implements AMapLocationListener {
        public C0000a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (!a.this.f3534y && a.this.f3526p) {
                    a.this.f3529t = aMapLocation;
                    int errorCode = aMapLocation.getErrorCode();
                    if (aMapLocation.getErrorCode() == 0) {
                        a.this.f3530u = Utils.getTimeBoot();
                        a.this.a(5, (Bundle) null, 0L);
                        a aVar = a.this;
                        aVar.f3532w = 0;
                        aVar.a(6, (Bundle) null, 0L);
                        return;
                    }
                    a aVar2 = a.this;
                    aVar2.a("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                    Bundle bundle = new Bundle();
                    if (!a.this.f3524n) {
                        a.this.a(7);
                        bundle.putLong("interval", 2000L);
                        a.this.a(8, bundle, 2000L);
                    }
                    a aVar3 = a.this;
                    int i3 = aVar3.f3532w + 1;
                    aVar3.f3532w = i3;
                    if (i3 >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, errorCode);
                        a.this.b(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.e(message.getData());
                        break;
                    case 1:
                        a.this.d(message.getData());
                        break;
                    case 2:
                        a.this.b(message.getData());
                        break;
                    case 3:
                        a.this.c(message.getData());
                        break;
                    case 4:
                        a.this.a(message.getData());
                        break;
                    case 5:
                        a.this.a();
                        break;
                    case 6:
                        a aVar = a.this;
                        aVar.a(aVar.f3529t);
                        break;
                    case 7:
                        a.this.d();
                        break;
                    case 8:
                        a.this.h(message.getData());
                        break;
                    case 9:
                        a.this.f(message.getData());
                        break;
                    case 10:
                        a.this.b();
                        break;
                    case 11:
                        a aVar2 = a.this;
                        Bundle data = message.getData();
                        aVar2.getClass();
                        if (aVar2.f3518h != null) {
                            GeoFence geoFence = (GeoFence) data.getParcelable("fc");
                            if (aVar2.f3518h.contains(geoFence)) {
                                aVar2.f3518h.remove(geoFence);
                            }
                            if (aVar2.f3518h.size() > 0) {
                                aVar2.m();
                                break;
                            } else {
                                aVar2.b();
                                break;
                            }
                        }
                        break;
                    case 12:
                        a.this.g(message.getData());
                        break;
                    case 13:
                        a.this.c();
                        break;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class c extends HandlerThread {
        public c(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        this.f3513b = null;
        try {
            this.f3513b = context.getApplicationContext();
            f();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManger", "<init>");
        }
    }

    public PendingIntent a(String str) {
        synchronized (this.f3516f) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(b9.f(this.f3513b));
                int i3 = 0;
                if (Build.VERSION.SDK_INT < 31 || this.f3513b.getApplicationInfo().targetSdkVersion < 31) {
                    this.f3514c = PendingIntent.getBroadcast(this.f3513b, 0, intent, 0);
                } else {
                    this.f3514c = PendingIntent.getBroadcast(this.f3513b, 0, intent, Const.FLAG_MUTABLE);
                }
                this.f3515d = str;
                ArrayList<GeoFence> arrayList = this.f3518h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    ArrayList<GeoFence> arrayList2 = this.f3518h;
                    int size = arrayList2.size();
                    while (i3 < size) {
                        GeoFence geoFence = arrayList2.get(i3);
                        i3++;
                        GeoFence geoFence2 = geoFence;
                        geoFence2.setPendingIntent(this.f3514c);
                        geoFence2.setPendingIntentAction(this.f3515d);
                    }
                }
            } finally {
                return this.f3514c;
            }
        }
        return this.f3514c;
    }

    public void b(Bundle bundle) {
        a(1, bundle);
    }

    public void c(int i3) {
        try {
            f();
            if (i3 > 7 || i3 < 1) {
                i3 = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i3);
            a(9, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "setActivateAction");
        }
    }

    public void d(Bundle bundle) {
        String str;
        GeoFence a3;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            int i3 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i3 = a((a3 = a(bundle, true)))) == 0) {
                    arrayList.add(a3);
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", i3);
            bundle2.putParcelableArrayList("resultList", arrayList);
            b(1000, bundle2);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    public void e(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            int i3 = 1;
            if (bundle == null || bundle.isEmpty()) {
                str = "";
            } else {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                        GeoFence a3 = a(bundle, false);
                        i3 = a(a3);
                        if (i3 == 0) {
                            arrayList.add(a3);
                        }
                    }
                    a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("errorCode", i3);
            bundle2.putParcelableArrayList("resultList", arrayList);
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            b(1000, bundle2);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x002d -> B:12:0x0032). Please report as a decompilation issue!!! */
    public void f() {
        if (!this.f3526p) {
            this.f3526p = true;
        }
        if (this.f3525o) {
            return;
        }
        try {
            if (Looper.myLooper() == null) {
                this.f3519i = new d(this.f3513b.getMainLooper());
            } else {
                this.f3519i = new d();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManger", "init 1");
        }
        try {
            c cVar = new c("fenceActionThread");
            this.f3523m = cVar;
            cVar.setPriority(5);
            this.f3523m.start();
            this.f3522l = new b(this.f3523m.getLooper());
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "GeoFenceManger", "init 2");
        }
        try {
            this.f3527q = new com.amap.api.col.p0003sl.b(this.f3513b);
            this.r = new com.amap.api.col.p0003sl.c();
            this.f3531v = new AMapLocationClientOption();
            this.f3528s = new AMapLocationClient(this.f3513b);
            this.f3531v.setNeedAddress(false);
            this.f3528s.setLocationListener(this.f3533x);
            if (this.f3512a == null) {
                this.f3512a = new ReportUtil();
            }
        } catch (Throwable th4) {
            CoreUtil.reportError(th4, "GeoFenceManger", "initBase");
        }
        this.f3525o = true;
        try {
            String str = this.f3515d;
            if (str != null && this.f3514c == null) {
                a(str);
            }
        } catch (Throwable th5) {
            CoreUtil.reportError(th5, "GeoFenceManger", "init 4");
        }
        if (f3511z) {
            return;
        }
        f3511z = true;
        ReportUtil.applyStatistics(this.f3513b, ReportUtil.STATICS_ID_GEOFENCE, null);
    }

    public void g(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z5 = bundle.getBoolean("ab", true);
                ArrayList<GeoFence> arrayList = this.f3518h;
                if (arrayList != null && !arrayList.isEmpty()) {
                    ArrayList<GeoFence> arrayList2 = this.f3518h;
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        GeoFence geoFence = arrayList2.get(i3);
                        i3++;
                        GeoFence geoFence2 = geoFence;
                        if (geoFence2.getFenceId().equals(string)) {
                            geoFence2.setAble(z5);
                            break;
                        }
                    }
                }
                if (z5) {
                    m();
                } else if (g()) {
                    c();
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public void h(Bundle bundle) {
        try {
            if (this.f3528s != null) {
                long j4 = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j4 = bundle.getLong("interval", 2000L);
                }
                this.f3531v.setOnceLocation(false);
                this.f3531v.setInterval(j4);
                this.f3531v.setLocationCacheEnable(true);
                this.f3531v.setNeedAddress(false);
                this.f3528s.setLocationOption(this.f3531v);
                if (this.f3524n) {
                    return;
                }
                this.f3528s.stopLocation();
                this.f3528s.startLocation();
                this.f3524n = true;
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public boolean i() {
        return this.f3529t != null && Utils.locCorrect(this.f3529t) && Utils.getTimeBoot() - this.f3530u < 10000;
    }

    public void j() {
        try {
            f();
            this.f3534y = true;
            a(13, (Bundle) null, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public void k() {
        try {
            this.f3526p = false;
            a(10, (Bundle) null, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "removeGeoFence");
        }
    }

    public void l() {
        try {
            f();
            if (this.f3534y) {
                this.f3534y = false;
                m();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public void m() {
        if (this.f3534y || this.f3522l == null) {
            return;
        }
        if (i()) {
            a(6, (Bundle) null, 0L);
            a(5, (Bundle) null, 0L);
        } else {
            a(7);
            a(7, (Bundle) null, 0L);
        }
    }

    public void n() {
        try {
            if (this.f3524n) {
                a(8);
            }
            AMapLocationClient aMapLocationClient = this.f3528s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f3524n = false;
        } catch (Throwable unused) {
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a aVar = a.this;
                        aVar.getClass();
                        if (data != null) {
                            try {
                                if (data.isEmpty()) {
                                    return;
                                }
                                int i3 = data.getInt("errorCode");
                                ArrayList parcelableArrayList = data.getParcelableArrayList("resultList");
                                if (parcelableArrayList == null) {
                                    parcelableArrayList = new ArrayList();
                                }
                                String string = data.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                                if (string == null) {
                                    string = "";
                                }
                                GeoFenceListener geoFenceListener = aVar.e;
                                if (geoFenceListener != null) {
                                    geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i3, string);
                                }
                                if (i3 == 0) {
                                    aVar.m();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                CoreUtil.reportError(th2, "GeoFenceManager", "resultAddGeoFenceFinished");
                                return;
                            }
                        }
                        return;
                    case 1001:
                        try {
                            a.this.c((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            a.this.b(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                            return;
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }

        public d() {
        }
    }

    public boolean b(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.f3518h;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.f3518h.contains(geoFence)) {
                    return false;
                }
                if (this.f3518h.size() == 1) {
                    this.f3526p = false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("fc", geoFence);
                a(11, bundle, 0L);
                return true;
            }
            this.f3526p = false;
            a(10, (Bundle) null, 0L);
            return true;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    public void c(Bundle bundle) {
        a(2, bundle);
    }

    public void c(GeoFence geoFence) {
        Throwable th2;
        try {
            try {
                synchronized (this.f3516f) {
                    try {
                        if (this.f3513b != null) {
                            if (this.f3514c == null) {
                                try {
                                    if (geoFence.getPendingIntent() == null) {
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    try {
                                        throw th2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        CoreUtil.reportError(th, "GeoFenceManager", "resultTriggerGeoFence");
                                        return;
                                    }
                                }
                            }
                            Intent intent = new Intent();
                            intent.putExtras(a(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                            String str = this.f3515d;
                            if (str != null) {
                                intent.setAction(str);
                            }
                            intent.setPackage(b9.f(this.f3513b));
                            if (geoFence.getPendingIntent() != null) {
                                geoFence.getPendingIntent().send(this.f3513b, 0, intent);
                            } else {
                                this.f3514c.send(this.f3513b, 0, intent);
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        th2 = th;
                        throw th2;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void b() {
        if (this.f3525o) {
            ArrayList<GeoFence> arrayList = this.f3518h;
            if (arrayList != null) {
                arrayList.clear();
                this.f3518h = null;
            }
            if (this.f3526p) {
                return;
            }
            try {
                synchronized (this.f3520j) {
                    try {
                        b bVar = this.f3522l;
                        if (bVar != null) {
                            bVar.removeCallbacksAndMessages(null);
                        }
                        this.f3522l = null;
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "GeoFenceManager", "destroyActionHandler");
            }
            AMapLocationClient aMapLocationClient = this.f3528s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.f3528s.onDestroy();
            }
            this.f3528s = null;
            c cVar = this.f3523m;
            if (cVar != null) {
                cVar.quitSafely();
            }
            this.f3523m = null;
            this.f3527q = null;
            synchronized (this.f3516f) {
                try {
                    PendingIntent pendingIntent = this.f3514c;
                    if (pendingIntent != null) {
                        pendingIntent.cancel();
                    }
                    this.f3514c = null;
                } finally {
                }
            }
            try {
                synchronized (this.f3521k) {
                    try {
                        d dVar = this.f3519i;
                        if (dVar != null) {
                            dVar.removeCallbacksAndMessages(null);
                        }
                        this.f3519i = null;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                CoreUtil.reportError(th4, "GeoFenceManager", "destroyResultHandler");
            }
            ReportUtil reportUtil = this.f3512a;
            if (reportUtil != null) {
                reportUtil.saveLocationTypeAndMode(this.f3513b);
            }
            this.f3524n = false;
            this.f3525o = false;
        }
    }

    public boolean g() {
        ArrayList<GeoFence> arrayList = this.f3518h;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<GeoFence> arrayList2 = this.f3518h;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                GeoFence geoFence = arrayList2.get(i3);
                i3++;
                if (geoFence.isAble()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean h() {
        return this.f3534y;
    }

    public void d() {
        try {
            if (this.f3528s != null) {
                n();
                this.f3531v.setLocationCacheEnable(true);
                this.f3531v.setNeedAddress(false);
                this.f3531v.setOnceLocation(true);
                this.f3528s.setLocationOption(this.f3531v);
                this.f3528s.startLocation();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    public void a(GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    public void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f3531v = aMapLocationClientOption.m3clone();
        } catch (Throwable unused) {
        }
    }

    public void a(DPoint dPoint, float f2, String str) {
        try {
            f();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f2);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(0, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public List<GeoFence> e() {
        try {
            if (this.f3518h == null) {
                this.f3518h = new ArrayList<>();
            }
            return (ArrayList) this.f3518h.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public void c() {
        try {
            a(7);
            a(8);
            AMapLocationClient aMapLocationClient = this.f3528s;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f3524n = false;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    public void a(List<DPoint> list, String str) {
        try {
            f();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public void f(Bundle bundle) {
        int i3 = 1;
        if (bundle != null) {
            try {
                i3 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f3517g != i3) {
            ArrayList<GeoFence> arrayList = this.f3518h;
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList<GeoFence> arrayList2 = this.f3518h;
                int size = arrayList2.size();
                int i10 = 0;
                while (i10 < size) {
                    GeoFence geoFence = arrayList2.get(i10);
                    i10++;
                    GeoFence geoFence2 = geoFence;
                    geoFence2.setStatus(0);
                    geoFence2.setEnterTime(-1L);
                }
            }
            m();
        }
        this.f3517g = i3;
    }

    public GeoFence a(Bundle bundle, boolean z5) {
        DPoint dPoint;
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint2 = new DPoint();
        int i3 = 0;
        if (z5) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint2 = new DPoint();
                try {
                    int size = arrayList.size();
                    double d5 = 0.0d;
                    double d8 = 0.0d;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        DPoint dPoint3 = (DPoint) obj;
                        d8 += dPoint3.getLatitude();
                        d5 += dPoint3.getLongitude();
                    }
                    dPoint = new DPoint(Utils.formatDoubleKeep6Point(d8 / arrayList.size()), Utils.formatDoubleKeep6Point(d5 / arrayList.size()));
                } catch (Throwable th2) {
                    CoreUtil.reportError(th2, "GeoFenceUtil", "getPolygonCenter");
                }
                geoFence.setMaxDis2Center(a(dPoint, arrayList));
                geoFence.setMinDis2Center(b(dPoint, arrayList));
            }
            dPoint = dPoint2;
            geoFence.setMaxDis2Center(a(dPoint, arrayList));
            geoFence.setMinDis2Center(b(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f2 = bundle.getFloat("fenceRadius", 1000.0f);
            float f10 = f2 > 0.0f ? f2 : 1000.0f;
            geoFence.setRadius(f10);
            geoFence.setMinDis2Center(f10);
            geoFence.setMaxDis2Center(f10);
        }
        geoFence.setActivatesAction(this.f3517g);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.f3515d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.f3514c);
        geoFence.setFenceId("" + com.amap.api.col.p0003sl.c.a());
        ReportUtil reportUtil = this.f3512a;
        if (reportUtil != null) {
            reportUtil.setLocationType(this.f3513b, 2);
        }
        return geoFence;
    }

    public void b(int i3, Bundle bundle) {
        try {
            synchronized (this.f3521k) {
                try {
                    d dVar = this.f3519i;
                    if (dVar != null) {
                        Message obtainMessage = dVar.obtainMessage();
                        obtainMessage.what = i3;
                        obtainMessage.setData(bundle);
                        this.f3519i.sendMessage(obtainMessage);
                    }
                } finally {
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    public void b(int i3) {
        Throwable th2;
        try {
            if (this.f3513b != null) {
                try {
                    synchronized (this.f3516f) {
                        try {
                            if (this.f3514c != null) {
                                Intent intent = new Intent();
                                intent.putExtras(a((GeoFence) null, (String) null, (String) null, 4, i3));
                                this.f3514c.send(this.f3513b, 0, intent);
                                return;
                            } else {
                                try {
                                    return;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            th2 = th;
                            throw th2;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    throw th2;
                } catch (Throwable th6) {
                    th = th6;
                    CoreUtil.reportError(th, "GeoFenceManager", "resultRemindLocationError");
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static float b(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MAX_VALUE;
        if (list != null && !list.isEmpty()) {
            Iterator<DPoint> it = list.iterator();
            while (it.hasNext()) {
                f2 = Math.min(f2, Utils.dist(dPoint, it.next()));
            }
        }
        return f2;
    }

    public void a(String str, String str2, DPoint dPoint, float f2, int i3, String str3) {
        try {
            f();
            if (f2 <= 0.0f || f2 > 50000.0f) {
                f2 = 3000.0f;
            }
            if (i3 <= 0) {
                i3 = 10;
            }
            if (i3 > 25) {
                i3 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f2);
            bundle.putInt("searchSize", i3);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            a(3, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public boolean b(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z5 = false;
        try {
            if (Utils.locCorrect(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                int type = geoFence.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                            }
                        }
                    }
                    boolean z6 = false;
                    for (List<DPoint> list : geoFence.getPointList()) {
                        try {
                            if (list.size() < 3 ? false : CoreUtil.isInPolygon(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list)) {
                                z6 = true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z5 = z6;
                            CoreUtil.reportError(th, "Utils", "isInGeoFence");
                            return z5;
                        }
                    }
                    return z6;
                }
                if (a(aMapLocation, geoFence.getCenter(), geoFence.getRadius())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(String str, String str2, String str3, int i3, String str4) {
        try {
            f();
            if (i3 <= 0) {
                i3 = 10;
            }
            if (i3 > 25) {
                i3 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i3);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            a(2, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public void a(String str, String str2) {
        try {
            f();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            a(4, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public void a(Bundle bundle) {
        a(3, bundle);
    }

    private boolean a(int i3, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i3 == 1) {
            return !TextUtils.isEmpty(str2);
        }
        if (i3 == 2) {
            if (dPoint != null) {
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    a("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    return false;
                }
            }
        }
    }

    private void a(int i3, Bundle bundle) {
        String str;
        int i10;
        int i11;
        String str2;
        int i12;
        String a3;
        int i13;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle != null) {
                try {
                    if (!bundle.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                        String string2 = bundle.getString("keyWords");
                        String string3 = bundle.getString("city");
                        String string4 = bundle.getString("poiType");
                        DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                        str2 = "errorCode";
                        try {
                            int i14 = bundle.getInt("searchSize", 10);
                            float f2 = bundle.getFloat("aroundRadius", 3000.0f);
                            if (a(i3, string2, string4, dPoint)) {
                                try {
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                                    bundle3.putString("pendingIntentAction", this.f3515d);
                                    bundle3.putLong("expiration", -1L);
                                    bundle3.putInt("activatesAction", this.f3517g);
                                    String str3 = "http://" + g9.b(this.f3513b).a(41);
                                    if (i3 == 1) {
                                        bundle3.putFloat("fenceRadius", 1000.0f);
                                        a3 = this.f3527q.a(this.f3513b, str3 + "/v3/place/text?", string2, string4, string3, String.valueOf(i14));
                                    } else if (i3 == 2) {
                                        double formatDoubleKeep6Point = Utils.formatDoubleKeep6Point(dPoint.getLatitude());
                                        double formatDoubleKeep6Point2 = Utils.formatDoubleKeep6Point(dPoint.getLongitude());
                                        int intValue = Float.valueOf(f2).intValue();
                                        bundle3.putFloat("fenceRadius", 200.0f);
                                        a3 = this.f3527q.b(this.f3513b, str3 + "/v3/place/around?", string2, string4, String.valueOf(i14), String.valueOf(formatDoubleKeep6Point), String.valueOf(formatDoubleKeep6Point2), String.valueOf(intValue));
                                    } else if (i3 != 3) {
                                        a3 = null;
                                    } else {
                                        a3 = this.f3527q.a(this.f3513b, str3 + "/v3/config/district?", string2);
                                    }
                                    if (a3 != null) {
                                        int b3 = 1 == i3 ? this.r.b(a3, arrayList2, bundle3) : 0;
                                        if (2 == i3) {
                                            b3 = this.r.b(a3, arrayList2, bundle3);
                                        }
                                        if (3 == i3) {
                                            b3 = this.r.a(a3, arrayList2, bundle3);
                                        }
                                        if (b3 != 10000) {
                                            if (b3 != 1 && b3 != 7 && b3 != 4 && b3 != 5 && b3 != 16 && b3 != 17) {
                                                switch (b3) {
                                                    case 10000:
                                                        i13 = 0;
                                                        break;
                                                    case 10001:
                                                    case 10002:
                                                    case 10007:
                                                    case 10008:
                                                    case 10009:
                                                    case 10012:
                                                    case 10013:
                                                        i13 = 7;
                                                        break;
                                                    case GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR /* 10003 */:
                                                    case 10004:
                                                    case 10005:
                                                    case 10006:
                                                    case 10010:
                                                    case 10011:
                                                    case 10014:
                                                    case 10015:
                                                    case 10016:
                                                    case 10017:
                                                        i13 = 4;
                                                        break;
                                                    default:
                                                        switch (b3) {
                                                            case Const.I_CITY_TILE_LEN /* 20000 */:
                                                            case 20001:
                                                            case 20002:
                                                                i13 = 1;
                                                                break;
                                                            case 20003:
                                                            default:
                                                                i13 = 8;
                                                                break;
                                                        }
                                                }
                                            } else {
                                                i13 = b3;
                                            }
                                            if (i13 != 0) {
                                                i12 = 0;
                                                try {
                                                    a("添加围栏失败", i13, "searchErrCode is " + i13, new String[0]);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    i11 = i12;
                                                    str = str2;
                                                    CoreUtil.reportError(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                                    bundle2.putInt(str, 8);
                                                    b(1000, bundle2);
                                                    return;
                                                }
                                            }
                                        } else if (arrayList2.isEmpty()) {
                                            i13 = 16;
                                        } else {
                                            try {
                                                if (this.f3518h == null) {
                                                    this.f3518h = new ArrayList<>();
                                                }
                                                int size = arrayList2.size();
                                                int i15 = 0;
                                                while (i15 < size) {
                                                    Object obj = arrayList2.get(i15);
                                                    i15++;
                                                    a((GeoFence) obj);
                                                }
                                                i11 = 0;
                                            } catch (Throwable th3) {
                                                CoreUtil.reportError(th3, "GeoFenceManager", "addGeoFenceList");
                                                a("添加围栏失败", 8, th3.getMessage(), new String[0]);
                                                i11 = 8;
                                            }
                                            if (i11 == 0) {
                                                try {
                                                    arrayList.addAll(arrayList2);
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    str = str2;
                                                    try {
                                                        CoreUtil.reportError(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                                        bundle2.putInt(str, 8);
                                                        b(1000, bundle2);
                                                        return;
                                                    } catch (Throwable th5) {
                                                        bundle2.putInt(str, i11);
                                                        b(1000, bundle2);
                                                        throw th5;
                                                    }
                                                }
                                            }
                                            i13 = i11;
                                        }
                                    } else {
                                        i13 = 4;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    i12 = 0;
                                    i11 = i12;
                                    str = str2;
                                    CoreUtil.reportError(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                    bundle2.putInt(str, 8);
                                    b(1000, bundle2);
                                    return;
                                }
                            } else {
                                i13 = 1;
                            }
                            try {
                                bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                                bundle2.putParcelableArrayList("resultList", arrayList);
                                bundle2.putInt(str2, i13);
                                b(1000, bundle2);
                            } catch (Throwable th7) {
                                th = th7;
                                i11 = i13;
                                str = str2;
                                CoreUtil.reportError(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                bundle2.putInt(str, 8);
                                b(1000, bundle2);
                                return;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            i10 = 0;
                            str = str2;
                            i11 = i10;
                            CoreUtil.reportError(th, "GeoFenceManager", "doAddGeoFenceNearby");
                            bundle2.putInt(str, 8);
                            b(1000, bundle2);
                            return;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    str2 = "errorCode";
                }
            }
            str2 = "errorCode";
            i13 = 1;
            bundle2.putInt(str2, i13);
            b(1000, bundle2);
        } catch (Throwable th10) {
            th = th10;
            str = "errorCode";
            i10 = 0;
        }
    }

    public void a(String str, boolean z5) {
        try {
            f();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z5);
            a(12, bundle, 0L);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public int a(GeoFence geoFence) {
        try {
            if (this.f3518h == null) {
                this.f3518h = new ArrayList<>();
            }
            if (this.f3518h.contains(geoFence)) {
                return 17;
            }
            this.f3518h.add(geoFence);
            return 0;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "addGeoFence2List");
            a("添加围栏失败", 8, th2.getMessage(), new String[0]);
            return 8;
        }
    }

    public void a(int i3, Bundle bundle, long j4) {
        try {
            synchronized (this.f3520j) {
                try {
                    b bVar = this.f3522l;
                    if (bVar != null) {
                        Message obtainMessage = bVar.obtainMessage();
                        obtainMessage.what = i3;
                        obtainMessage.setData(bundle);
                        this.f3522l.sendMessageDelayed(obtainMessage, j4);
                    }
                } finally {
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    public void a(int i3) {
        try {
            synchronized (this.f3520j) {
                try {
                    b bVar = this.f3522l;
                    if (bVar != null) {
                        bVar.removeMessages(i3);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    public Bundle a(GeoFence geoFence, String str, String str2, int i3, int i10) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt(GeoFence.BUNDLE_KEY_FENCESTATUS, i3);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i10);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    public void a(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.f3534y || (arrayList = this.f3518h) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            ArrayList<GeoFence> arrayList2 = this.f3518h;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                GeoFence geoFence = arrayList2.get(i3);
                i3++;
                GeoFence geoFence2 = geoFence;
                if (geoFence2.isAble() && a(aMapLocation, geoFence2) && a(geoFence2, this.f3517g)) {
                    geoFence2.setCurrentLocation(aMapLocation);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("geoFence", geoFence2);
                    b(1001, bundle);
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "doCheckFence");
        }
    }

    public void a() {
        try {
            if (!this.f3534y && Utils.locCorrect(this.f3529t)) {
                float a3 = a(this.f3529t, this.f3518h);
                if (a3 == Float.MAX_VALUE) {
                    return;
                }
                if (a3 < 1000.0f) {
                    a(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong("interval", 2000L);
                    a(8, bundle, 500L);
                    return;
                }
                if (a3 < 5000.0f) {
                    n();
                    a(7);
                    a(7, (Bundle) null, 10000L);
                } else {
                    n();
                    a(7);
                    a(7, (Bundle) null, (long) (((a3 - 4000.0f) / 100.0f) * 1000.0f));
                }
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    public float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f2 = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float dist = Utils.dist(dPoint, geoFence.getCenter());
                    if (dist > geoFence.getMinDis2Center() && dist < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (dist > geoFence.getMaxDis2Center()) {
                        f2 = Math.min(f2, dist - geoFence.getMaxDis2Center());
                    }
                    if (dist < geoFence.getMinDis2Center()) {
                        f2 = Math.min(f2, geoFence.getMinDis2Center() - dist);
                    }
                }
            }
        }
        return f2;
    }

    public static float a(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MIN_VALUE;
        if (list != null && !list.isEmpty()) {
            Iterator<DPoint> it = list.iterator();
            while (it.hasNext()) {
                f2 = Math.max(f2, Utils.dist(dPoint, it.next()));
            }
        }
        return f2;
    }

    public boolean a(AMapLocation aMapLocation, DPoint dPoint, float f2) {
        return Utils.dist(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f2;
    }

    public boolean a(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z5 = false;
        try {
            if (b(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(Utils.getTimeBoot());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && Utils.getTimeBoot() - geoFence.getEnterTime() > Const.FENCE_STATED_MIN_TIME) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1L);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    z5 = true;
                    CoreUtil.reportError(th, "Utils", "isFenceStatusChanged");
                    return z5;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean a(GeoFence geoFence, int i3) {
        boolean z5 = false;
        if ((i3 & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z5 = true;
                }
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "Utils", "remindStatus");
            }
        }
        if ((i3 & 2) == 2 && geoFence.getStatus() == 2) {
            z5 = true;
        }
        if ((i3 & 4) == 4) {
            if (geoFence.getStatus() == 3) {
                return true;
            }
        }
        return z5;
    }

    public void a(String str, int i3, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n-------------------------------------------\n");
        stringBuffer.append("errorCode:" + i3);
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:" + str2);
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }
}
