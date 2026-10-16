package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    private Context f4663b;

    /* renamed from: d, reason: collision with root package name */
    private WebView f4665d;

    /* renamed from: h, reason: collision with root package name */
    a f4668h;

    /* renamed from: a, reason: collision with root package name */
    Object f4662a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private AMapLocationClient f4664c = null;
    private String e = "AMap.Geolocation.cbk";

    /* renamed from: f, reason: collision with root package name */
    AMapLocationClientOption f4666f = null;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f4667g = false;

    public class a implements AMapLocationListener {
        public a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (n.this.f4667g) {
                n nVar = n.this;
                nVar.getClass();
                JSONObject jSONObject = new JSONObject();
                try {
                    if (aMapLocation.getErrorCode() == 0) {
                        jSONObject.put("errorCode", 0);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", aMapLocation.getLongitude());
                        jSONObject2.put("y", aMapLocation.getLatitude());
                        jSONObject2.put("precision", aMapLocation.getAccuracy());
                        jSONObject2.put("type", aMapLocation.getLocationType());
                        jSONObject2.put("country", aMapLocation.getCountry());
                        jSONObject2.put("province", aMapLocation.getProvince());
                        jSONObject2.put("city", aMapLocation.getCity());
                        jSONObject2.put("cityCode", aMapLocation.getCityCode());
                        jSONObject2.put("district", aMapLocation.getDistrict());
                        jSONObject2.put("adCode", aMapLocation.getAdCode());
                        jSONObject2.put(Const.JSON_KEY_STREET, aMapLocation.getStreet());
                        jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                        jSONObject2.put(Const.JSON_KEY_FLOOR, aMapLocation.getFloor());
                        jSONObject2.put(Const.JSON_KEY_ADDRESS, aMapLocation.getAddress());
                        jSONObject.put("result", jSONObject2);
                    } else {
                        jSONObject.put("errorCode", aMapLocation.getErrorCode());
                        jSONObject.put("errorInfo", aMapLocation.getErrorInfo());
                        jSONObject.put(Const.JSON_KEY_LOCATIONDETAIL, aMapLocation.getLocationDetail());
                    }
                } catch (Throwable unused) {
                }
                n.a(nVar, jSONObject.toString());
            }
        }
    }

    public n(Context context, WebView webView) {
        this.f4665d = null;
        this.f4668h = null;
        this.f4663b = context.getApplicationContext();
        this.f4665d = webView;
        this.f4668h = new a();
    }

    public static void a(n nVar, String str) {
        nVar.getClass();
        try {
            WebView webView = nVar.f4665d;
            if (webView != null) {
                webView.evaluateJavascript("javascript:" + nVar.e + "('" + str + "')", new l(nVar));
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "H5LocationClient", "callbackJs()");
        }
    }

    @JavascriptInterface
    public void getLocation(String str) {
        synchronized (this.f4662a) {
            try {
                if (this.f4667g) {
                    a(str);
                    AMapLocationClient aMapLocationClient = this.f4664c;
                    if (aMapLocationClient != null) {
                        aMapLocationClient.setLocationOption(this.f4666f);
                        this.f4664c.stopLocation();
                        this.f4664c.startLocation();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @JavascriptInterface
    public void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.f4667g && (aMapLocationClient = this.f4664c) != null) {
            aMapLocationClient.stopLocation();
        }
    }

    public void b() {
        if (this.f4665d == null || this.f4663b == null || this.f4667g) {
            return;
        }
        try {
            this.f4665d.getSettings().setJavaScriptEnabled(true);
            this.f4665d.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.f4665d.getUrl())) {
                this.f4665d.reload();
            }
            if (this.f4664c == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f4663b);
                this.f4664c = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.f4668h);
            }
            this.f4667g = true;
        } catch (Throwable unused) {
        }
    }

    public void a() {
        synchronized (this.f4662a) {
            try {
                this.f4667g = false;
                AMapLocationClient aMapLocationClient = this.f4664c;
                if (aMapLocationClient != null) {
                    aMapLocationClient.unRegisterLocationListener(this.f4668h);
                    this.f4664c.stopLocation();
                    this.f4664c.onDestroy();
                    this.f4664c = null;
                }
                this.f4666f = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void a(String str) {
        boolean z5;
        if (this.f4666f == null) {
            this.f4666f = new AMapLocationClientOption();
        }
        int i3 = 5;
        long j4 = 30000;
        try {
            JSONObject jSONObject = new JSONObject(str);
            j4 = jSONObject.optLong("to", 30000L);
            boolean z6 = jSONObject.optInt("useGPS", 1) == 1;
            try {
                r3 = jSONObject.optInt("watch", 0) == 1;
                i3 = jSONObject.optInt("interval", 5);
                String optString = jSONObject.optString("callback", null);
                if (!TextUtils.isEmpty(optString)) {
                    this.e = optString;
                } else {
                    this.e = "AMap.Geolocation.cbk";
                }
            } catch (Throwable unused) {
            }
            boolean z8 = r3;
            r3 = z6;
            z5 = z8;
        } catch (Throwable unused2) {
            z5 = false;
        }
        try {
            this.f4666f.setHttpTimeOut(j4);
            if (r3) {
                this.f4666f.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            } else {
                this.f4666f.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
            }
            this.f4666f.setOnceLocation(!z5);
            if (z5) {
                this.f4666f.setInterval(i3 * 1000);
            }
        } catch (Throwable unused3) {
        }
    }
}
