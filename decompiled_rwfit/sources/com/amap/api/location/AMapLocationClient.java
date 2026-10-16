package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.col.p0003sl.e;
import com.amap.api.col.p0003sl.f9;
import com.amap.api.col.p0003sl.ib;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.l9;
import com.amap.api.col.p0003sl.y;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AMapLocationClient {

    /* renamed from: a, reason: collision with root package name */
    Context f5634a;

    /* renamed from: b, reason: collision with root package name */
    e f5635b;

    public AMapLocationClient(Context context) throws Exception {
        a(context);
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            Context applicationContext = context.getApplicationContext();
            this.f5634a = applicationContext;
            DebugUtils.attachContext(applicationContext);
            this.f5635b = new e(this.f5634a, null, null);
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "ne1");
        }
    }

    private void a(Context context) throws Exception {
        l9 a3 = k9.a(context, CoreUtil.getSDKInfo());
        if (a3.f4490a == k9.e.SuccessCode) {
            return;
        }
        Log.e("AMapLocationClient", a3.f4491b);
        throw new Exception(a3.f4491b);
    }

    public static String getDeviceId(Context context) {
        return f9.l(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.APIKEY = str;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "sKey");
        }
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            ib.f4306a = -1;
            ib.f4307b = "";
        } else {
            ib.f4306a = 1;
            ib.f4307b = str;
        }
    }

    public static void updatePrivacyAgree(Context context, boolean z5) {
        k9.a(context, z5, CoreUtil.getSDKInfo());
    }

    public static void updatePrivacyShow(Context context, boolean z5, boolean z6) {
        k9.a(context, z5, z6, CoreUtil.getSDKInfo());
    }

    public void addLogCallback(ILogCallback iLogCallback) {
        if (this.f5635b != null) {
            y.a(iLogCallback);
        }
    }

    public void addSatelliteListener(IGnssSatelliteListenerDelegate iGnssSatelliteListenerDelegate) {
        e eVar = this.f5635b;
        if (eVar != null) {
            eVar.a(iGnssSatelliteListenerDelegate);
        }
    }

    public void addSensorListener(ISensorListenerDelegate iSensorListenerDelegate) {
        e eVar = this.f5635b;
        if (eVar != null) {
            eVar.a(iSensorListenerDelegate);
        }
    }

    public void disableBackgroundLocation(boolean z5) {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.b(z5);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i3, Notification notification) {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.a(i3, notification);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                return eVar.e();
            }
            return null;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "gLastL");
            return null;
        }
    }

    public void getReGeoLocation(AMapLocation aMapLocation) {
        e eVar = this.f5635b;
        if (eVar != null) {
            eVar.c(aMapLocation);
        }
    }

    public String getVersion() {
        return CoreUtil.STR_CONFIG_VERSION;
    }

    public boolean isLocationDim() {
        return this.f5635b.f();
    }

    public boolean isStarted() {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                return eVar.g();
            }
            return false;
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "isS");
            return false;
        }
    }

    public void notifyAppEnterForeBack(boolean z5) {
        this.f5635b.c(z5);
    }

    public void notifyEventChanged(int i3, int i10, long j4, long j10, String str) {
        e eVar = this.f5635b;
        if (eVar != null) {
            eVar.a(i3, i10, j4, j10, str);
        }
    }

    public void notifySceneChanged(int i3) {
        this.f5635b.a(i3);
    }

    public void onDestroy() {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.h();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "onDy");
        }
    }

    public void removeLogCallback(ILogCallback iLogCallback) {
        if (this.f5635b != null) {
            y.b(iLogCallback);
        }
    }

    public void removeSatelliteListener(IGnssSatelliteListenerDelegate iGnssSatelliteListenerDelegate) {
        e eVar = this.f5635b;
        if (eVar != null) {
            eVar.b(iGnssSatelliteListenerDelegate);
        }
    }

    public void removeSensorListener(ISensorListenerDelegate iSensorListenerDelegate) {
        e eVar = this.f5635b;
        if (eVar != null) {
            eVar.b(iSensorListenerDelegate);
        }
    }

    public void sendFeedback() {
        this.f5635b.i();
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener == null) {
                throw new IllegalArgumentException("listener参数不能为null");
            }
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.a(aMapLocationListener);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption == null) {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption.C) {
                aMapLocationClientOption.C = false;
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(aMapLocationClientOption.D)) {
                    jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.D);
                }
                ReportUtil.applyStatistics(this.f5634a, ReportUtil.STATICS_ID_LOCATE_PURPOSE, jSONObject);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "sLocnO");
        }
    }

    public void setReGeoLocationCallback(IReGeoLocationCallback iReGeoLocationCallback) {
        e eVar = this.f5635b;
        if (eVar != null) {
            eVar.a(iReGeoLocationCallback);
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.a(webView);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.k();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.l();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.m();
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            e eVar = this.f5635b;
            if (eVar != null) {
                eVar.b(aMapLocationListener);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "unRL");
        }
    }

    public AMapLocationClient(Context context, Intent intent) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f5634a = context.getApplicationContext();
                this.f5635b = new e(this.f5634a, intent, null);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(Looper looper, Context context) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f5634a = context.getApplicationContext();
                this.f5635b = new e(this.f5634a, null, looper);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMClt", "ne3");
        }
    }
}
