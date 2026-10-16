package com.example.test.utils;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Message;
import android.util.Log;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.XXApplication;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public final class t implements AMapLocationListener, o5.a {

    /* renamed from: f, reason: collision with root package name */
    public static t f8758f;

    /* renamed from: a, reason: collision with root package name */
    public com.example.baselibrary.utils.e f8759a;

    /* renamed from: b, reason: collision with root package name */
    public AMapLocationClient f8760b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f8761c;

    /* renamed from: d, reason: collision with root package name */
    public int f8762d;
    public boolean e;

    public static t a() {
        if (f8758f == null) {
            synchronized (t.class) {
                t tVar = new t();
                tVar.f8760b = null;
                tVar.f8759a = new com.example.baselibrary.utils.e(tVar);
                tVar.f8761c = new ArrayList(1);
                f8758f = tVar;
            }
        }
        return f8758f;
    }

    public static void b(Context context) {
        context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    public static boolean d(XXApplication xXApplication) {
        LocationManager locationManager = (LocationManager) xXApplication.getSystemService("location");
        if (locationManager == null) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "isLocationOpen 定位已打开");
            return true;
        }
        boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
        boolean isProviderEnabled2 = locationManager.isProviderEnabled(Const.PROVIDER_NETWORK);
        StringBuilder sb2 = new StringBuilder("isLocationOpen ");
        sb2.append(isProviderEnabled || isProviderEnabled2);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, sb2.toString());
        return isProviderEnabled || isProviderEnabled2;
    }

    public final boolean c(e6.a aVar) {
        ArrayList arrayList = this.f8761c;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference.get() != null && weakReference.get() == aVar) {
                return true;
            }
        }
        return false;
    }

    public final void e(XXApplication xXApplication) {
        if (this.e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationUtils", "正在定位");
            return;
        }
        try {
            this.f8760b = new AMapLocationClient(xXApplication);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f8760b != null) {
            this.e = true;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationUtils", "开启定位");
            AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
            this.f8760b.setLocationListener(this);
            aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            aMapLocationClientOption.setInterval(2000L);
            this.f8760b.setLocationOption(aMapLocationClientOption);
            this.f8760b.startLocation();
            this.f8759a.sendEmptyMessageDelayed(1, 15000L);
        }
    }

    public final void f() {
        ArrayList arrayList = this.f8761c;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference != null && weakReference.get() != null) {
                ((e6.a) weakReference.get()).b();
            }
        }
        AMapLocationClient aMapLocationClient = this.f8760b;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.f8760b.onDestroy();
            this.f8760b = null;
            this.f8762d = 0;
        }
        this.e = false;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() != 0) {
                Log.e("AmapError", "location Error, ErrCode:" + aMapLocation.getErrorCode() + ", errInfo:" + aMapLocation.getErrorInfo());
                int i3 = this.f8762d + 1;
                this.f8762d = i3;
                if (i3 >= 5) {
                    f();
                    return;
                }
                return;
            }
            this.f8759a.removeMessages(1);
            aMapLocation.getLocationType();
            aMapLocation.getLatitude();
            aMapLocation.getLongitude();
            aMapLocation.getAccuracy();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "LocationUtils", "GPS 定位结果 时间 = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(aMapLocation.getTime())) + " 结果 = " + com.example.baselibrary.utils.b.z(aMapLocation));
            ArrayList arrayList = this.f8761c;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                WeakReference weakReference = (WeakReference) obj;
                if (weakReference != null && weakReference.get() != null) {
                    ((e6.a) weakReference.get()).a(aMapLocation);
                }
            }
            AMapLocationClient aMapLocationClient = this.f8760b;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.f8760b.onDestroy();
                this.f8760b = null;
                this.f8762d = 0;
            }
            this.e = false;
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        f();
    }
}
